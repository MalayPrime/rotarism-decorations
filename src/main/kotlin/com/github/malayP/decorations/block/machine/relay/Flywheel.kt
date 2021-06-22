package com.github.malayP.decorations.block.machine.relay


import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.flywheelType
import com.github.zomb_676.fantasySoup.block.HorizonBlockWithTileEntity
import com.github.zomb_676.fantasySoup.render.RenderWithTexture
import com.mojang.blaze3d.matrix.MatrixStack
import com.mojang.blaze3d.vertex.IVertexBuilder
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.IRenderTypeBuffer
import net.minecraft.client.renderer.RenderType
import net.minecraft.client.renderer.model.Model
import net.minecraft.client.renderer.model.ModelRenderer
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher
import net.minecraft.state.EnumProperty
import net.minecraft.state.StateContainer
import net.minecraft.state.properties.BlockStateProperties
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.IStringSerializable
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.vector.Vector3f
import net.minecraft.world.IBlockReader


abstract class Flywheel : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    enum class FlywheelMaterial(private val materialName: String) : IStringSerializable {
        WOODEN("wooden"),
        STONE("stone"),
        IRON("iron"),
        GOLD("gold");

        override fun toString(): String {
            return this.string
        }

        override fun getString(): String {
            return materialName
        }
    }

    companion object {
        val flywheelMaterial: EnumProperty<FlywheelMaterial> = EnumProperty
            .create("flywheel_material", FlywheelMaterial::class.java)
    }

    override fun fillStateContainer(builder: StateContainer.Builder<Block, BlockState>) {
        super.fillStateContainer(builder.add(flywheelMaterial))
    }

    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = FlywheelTileEntity()
}

class WoodenFlyWheel : Flywheel() {
    init {
        this.defaultState = this.defaultState.with(flywheelMaterial, FlywheelMaterial.WOODEN)
    }
}

class StoneFlyWheel : Flywheel() {
    init {
        this.defaultState = this.defaultState.with(flywheelMaterial, FlywheelMaterial.STONE)
    }
}

class IronFlyWheel : Flywheel() {
    init {
        this.defaultState = this.defaultState.with(flywheelMaterial, FlywheelMaterial.IRON)
    }
}

class GoldFlyWheel : Flywheel() {
    init {
        this.defaultState = this.defaultState.with(flywheelMaterial, FlywheelMaterial.GOLD)
    }
}

class FlywheelTileEntity : TileEntity(flywheelType.get())

class FlywheelTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    RenderWithTexture<FlywheelTileEntity>(dispatcher) {
    companion object {
        val model = FlywheelModel()
        val woodenFlyWheel =
            modResourcesLocation("textures/tile_entity/transmission/flywheel/wooden/wooden_flywheel.png")
        val stoneFlyWheel = modResourcesLocation("textures/tile_entity/transmission/flywheel/stone/stone_flywheel.png")
        val ironFlyWheel = modResourcesLocation("textures/tile_entity/transmission/flywheel/iron/iron_flywheel.png")
        val goldFlyWheel = modResourcesLocation("textures/tile_entity/transmission/flywheel/gold/gold_flywheel.png")
    }

    override fun render(
        tileEntityIn: FlywheelTileEntity,
        partialTicks: Float,
        matrixStackIn: MatrixStack,
        bufferIn: IRenderTypeBuffer,
        combinedLightIn: Int,
        combinedOverlayIn: Int,
    ) {
        val texture = if (tileEntityIn.world != null) {
            when (tileEntityIn.blockState.get(Flywheel.flywheelMaterial)!!) {
                Flywheel.FlywheelMaterial.WOODEN -> woodenFlyWheel
                Flywheel.FlywheelMaterial.STONE -> stoneFlyWheel
                Flywheel.FlywheelMaterial.IRON -> ironFlyWheel
                Flywheel.FlywheelMaterial.GOLD -> goldFlyWheel
            }
        } else {
            stoneFlyWheel
        }
        renderWithTexture(
            tileEntityIn,
            texture,
            partialTicks,
            matrixStackIn,
            bufferIn,
            combinedLightIn,
            combinedOverlayIn
        )
    }

    override fun renderWithTexture(
        tileEntityIn: FlywheelTileEntity,
        texture: ResourceLocation,
        partialTicks: Float,
        matrixStackIn: MatrixStack,
        bufferIn: IRenderTypeBuffer,
        combinedLightIn: Int,
        combinedOverlayIn: Int,
    ) {
        matrixStackIn.push()
        val renderType = RenderType.getEntityTranslucent(texture)
        val buffer = bufferIn.getBuffer(renderType)
        matrixStackIn.scale(1f, -1f, -1f)
        matrixStackIn.translate(0.5, -1.5, -0.5)
        val f: Float =
            if (tileEntityIn.world != null) tileEntityIn.blockState.get(BlockStateProperties.HORIZONTAL_FACING).horizontalAngle else 90f
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f))
        model.render(matrixStackIn, buffer, combinedLightIn, combinedOverlayIn, 1f, 1f, 1f, 1f)
        matrixStackIn.pop()
    }
}

class FlywheelModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val pos: ModelRenderer
    private val rot: ModelRenderer
    private val rotatable: ModelRenderer
    private val pos2: ModelRenderer
    private val rot2: ModelRenderer
    private val wheel: ModelRenderer
    private val part: ModelRenderer
    private val bone9: ModelRenderer
    private val part2: ModelRenderer
    private val bone2: ModelRenderer
    private val part3: ModelRenderer
    private val bone3: ModelRenderer
    private val part4: ModelRenderer
    private val bone4: ModelRenderer
    private val part5: ModelRenderer
    private val bone5: ModelRenderer
    private val part6: ModelRenderer
    private val bone6: ModelRenderer
    private val part7: ModelRenderer
    private val bone7: ModelRenderer
    private val part8: ModelRenderer
    private val bone8: ModelRenderer

    override fun render(
        matrixStack: MatrixStack,
        buffer: IVertexBuilder,
        packedLight: Int,
        packedOverlay: Int,
        red: Float,
        green: Float,
        blue: Float,
        alpha: Float
    ) {
        shell.render(matrixStack, buffer, packedLight, packedOverlay)
    }

    fun setRotationAngle(modelRenderer: ModelRenderer, x: Float, y: Float, z: Float) {
        modelRenderer.rotateAngleX = x
        modelRenderer.rotateAngleY = y
        modelRenderer.rotateAngleZ = z
    }

    init {
        textureWidth = 128
        textureHeight = 128
        shell = ModelRenderer(this)
        shell.setRotationPoint(0.0f, 16.0f, 0.0f)
        fixed = ModelRenderer(this)
        fixed.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(fixed)
        pos = ModelRenderer(this)
        pos.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(pos)
        pos.setTextureOffset(0, 0).addBox(-8.0f, 7.0f, -8.0f, 16.0f, 1.0f, 16.0f, 0.0f, false)
        pos.setTextureOffset(31, 42).addBox(-8.0f, 2.0f, -7.0f, 1.0f, 5.0f, 14.0f, 0.0f, false)
        pos.setTextureOffset(0, 38).addBox(7.0f, 2.0f, -7.0f, 1.0f, 5.0f, 14.0f, 0.0f, false)
        pos.setTextureOffset(44, 18).addBox(-8.0f, -5.0f, 7.0f, 16.0f, 12.0f, 1.0f, 0.0f, false)
        pos.setTextureOffset(44, 18).addBox(-8.0f, -5.0f, -8.0f, 16.0f, 12.0f, 1.0f, 0.0f, false)
        rot = ModelRenderer(this)
        rot.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(rot)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        pos2 = ModelRenderer(this)
        pos2.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(pos2)
        pos2.setTextureOffset(22, 22).addBox(-1.0f, -1.0f, -8.5f, 2.0f, 2.0f, 17.0f, 0.0f, false)
        rot2 = ModelRenderer(this)
        rot2.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(rot2)
        setRotationAngle(rot2, 0.0f, 0.0f, 0.7854f)
        rot2.setTextureOffset(0, 18).addBox(-1.0f, -1.0f, -8.49f, 2.0f, 2.0f, 17.0f, 0.0f, false)
        wheel = ModelRenderer(this)
        wheel.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(wheel)
        part = ModelRenderer(this)
        part.setRotationPoint(0.0f, 0.0f, 0.0f)
        wheel.addChild(part)
        part.setTextureOffset(17, 42).addBox(-2.5f, 5.0f, -3.0f, 5.0f, 1.0f, 6.0f, 0.0f, false)
        bone9 = ModelRenderer(this)
        bone9.setRotationPoint(-0.25f, 1.0f, 0.5f)
        part.addChild(bone9)
        bone9.setTextureOffset(48, 42).addBox(-2.25f, 0.0f, -2.99f, 5.0f, 5.0f, 5.0f, -0.01f, false)
        part2 = ModelRenderer(this)
        part2.setRotationPoint(0.0f, 0.0f, 0.0f)
        wheel.addChild(part2)
        setRotationAngle(part2, 0.0f, 0.0f, 0.7854f)
        part2.setTextureOffset(17, 42).addBox(-2.5f, 5.0f, -2.99f, 5.0f, 1.0f, 6.0f, 0.0f, false)
        bone2 = ModelRenderer(this)
        bone2.setRotationPoint(-0.25f, 1.0f, 0.5f)
        part2.addChild(bone2)
        bone2.setTextureOffset(48, 42).addBox(-2.25f, 0.0f, -2.98f, 5.0f, 5.0f, 5.0f, -0.01f, false)
        part3 = ModelRenderer(this)
        part3.setRotationPoint(0.0f, 0.0f, 0.0f)
        wheel.addChild(part3)
        setRotationAngle(part3, 0.0f, 0.0f, 1.5708f)
        part3.setTextureOffset(17, 42).addBox(-2.5f, 5.0f, -3.0f, 5.0f, 1.0f, 6.0f, 0.0f, false)
        bone3 = ModelRenderer(this)
        bone3.setRotationPoint(-0.25f, 1.0f, 0.5f)
        part3.addChild(bone3)
        bone3.setTextureOffset(48, 42).addBox(-2.25f, 0.0f, -2.97f, 5.0f, 5.0f, 5.0f, -0.01f, false)
        part4 = ModelRenderer(this)
        part4.setRotationPoint(0.0f, 0.0f, 0.0f)
        wheel.addChild(part4)
        setRotationAngle(part4, 0.0f, 0.0f, 2.3562f)
        part4.setTextureOffset(17, 42).addBox(-2.5f, 5.0f, -2.99f, 5.0f, 1.0f, 6.0f, 0.0f, false)
        bone4 = ModelRenderer(this)
        bone4.setRotationPoint(-0.25f, 1.0f, 0.5f)
        part4.addChild(bone4)
        bone4.setTextureOffset(48, 42).addBox(-2.25f, 0.0f, -3.0f, 5.0f, 5.0f, 5.0f, -0.01f, false)
        part5 = ModelRenderer(this)
        part5.setRotationPoint(0.0f, 0.0f, 0.0f)
        wheel.addChild(part5)
        setRotationAngle(part5, 0.0f, 0.0f, -3.1416f)
        part5.setTextureOffset(17, 42).addBox(-2.5f, 5.0f, -3.0f, 5.0f, 1.0f, 6.0f, 0.0f, false)
        bone5 = ModelRenderer(this)
        bone5.setRotationPoint(-0.25f, 1.0f, 0.5f)
        part5.addChild(bone5)
        bone5.setTextureOffset(48, 42).addBox(-2.25f, 0.0f, -2.99f, 5.0f, 5.0f, 5.0f, -0.01f, false)
        part6 = ModelRenderer(this)
        part6.setRotationPoint(0.0f, 0.0f, 0.0f)
        wheel.addChild(part6)
        setRotationAngle(part6, 0.0f, 0.0f, -2.3562f)
        part6.setTextureOffset(17, 42).addBox(-2.5f, 5.0f, -2.99f, 5.0f, 1.0f, 6.0f, 0.0f, false)
        bone6 = ModelRenderer(this)
        bone6.setRotationPoint(-0.25f, 1.0f, 0.5f)
        part6.addChild(bone6)
        bone6.setTextureOffset(48, 42).addBox(-2.25f, 0.0f, -2.98f, 5.0f, 5.0f, 5.0f, -0.01f, false)
        part7 = ModelRenderer(this)
        part7.setRotationPoint(0.0f, 0.0f, 0.0f)
        wheel.addChild(part7)
        setRotationAngle(part7, 0.0f, 0.0f, -1.5708f)
        part7.setTextureOffset(17, 42).addBox(-2.5f, 5.0f, -3.0f, 5.0f, 1.0f, 6.0f, 0.0f, false)
        bone7 = ModelRenderer(this)
        bone7.setRotationPoint(-0.25f, 1.0f, 0.5f)
        part7.addChild(bone7)
        bone7.setTextureOffset(48, 42).addBox(-2.25f, 0.0f, -2.97f, 5.0f, 5.0f, 5.0f, -0.01f, false)
        part8 = ModelRenderer(this)
        part8.setRotationPoint(0.0f, 0.0f, 0.0f)
        wheel.addChild(part8)
        setRotationAngle(part8, 0.0f, 0.0f, -0.7854f)
        part8.setTextureOffset(17, 42).addBox(-2.5f, 5.0f, -2.99f, 5.0f, 1.0f, 6.0f, 0.0f, false)
        bone8 = ModelRenderer(this)
        bone8.setRotationPoint(-0.25f, 1.0f, 0.5f)
        part8.addChild(bone8)
        bone8.setTextureOffset(48, 42).addBox(-2.25f, 0.0f, -3.0f, 5.0f, 5.0f, 5.0f, -0.01f, false)
    }
}
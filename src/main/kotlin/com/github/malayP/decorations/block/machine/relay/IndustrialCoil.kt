package com.github.malayP.decorations.block.machine.relay


import com.github.malayP.decorations.block.machine.relay.IndustrialCoil.Companion.industrialCoilMaterial
import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.industrialCoilType
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


abstract class IndustrialCoil : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    enum class IndustrialCoilMaterial(private val materialName: String) : IStringSerializable {
        STEEL("wooden"),
        BEDROCK("stone");

        override fun toString(): String {
            return this.string
        }

        override fun getString(): String {
            return materialName
        }
    }

    companion object {
        val industrialCoilMaterial: EnumProperty<IndustrialCoilMaterial> = EnumProperty
            .create("industrial_coil_material", IndustrialCoilMaterial::class.java)
    }

    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = IndustrialCoilTileEntity()

    override fun fillStateContainer(builder: StateContainer.Builder<Block, BlockState>) {
        super.fillStateContainer(builder.add(industrialCoilMaterial))
    }
}

class SteelIndustrialCoil : IndustrialCoil() {
    init {
        this.defaultState = this.defaultState.with(industrialCoilMaterial, IndustrialCoilMaterial.STEEL)
    }
}

class BedrockIndustrialCoil : IndustrialCoil() {
    init {
        this.defaultState = this.defaultState.with(industrialCoilMaterial, IndustrialCoilMaterial.BEDROCK)
    }
}

class IndustrialCoilTileEntity : TileEntity(industrialCoilType.get()) {

}

class IndustrialCoilTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    RenderWithTexture<IndustrialCoilTileEntity>(dispatcher) {
    companion object {
        val model = IndustrialCoilModel()
        val steelIndustrialCoil =
            modResourcesLocation("textures/tile_entity/transmission/industrial_coil/steel/industrial_coil.png")
        val bedrockIndustrialCoil =
            modResourcesLocation("textures/tile_entity/transmission/industrial_coil/bedrock/industrial_coil_bedrock.png")
    }

    override fun render(
        tileEntityIn: IndustrialCoilTileEntity,
        partialTicks: Float,
        matrixStackIn: MatrixStack,
        bufferIn: IRenderTypeBuffer,
        combinedLightIn: Int,
        combinedOverlayIn: Int,
    ) {
        val texture = if (tileEntityIn.world != null) {
            when (tileEntityIn.blockState.get(industrialCoilMaterial)!!) {
                IndustrialCoil.IndustrialCoilMaterial.STEEL -> steelIndustrialCoil
                IndustrialCoil.IndustrialCoilMaterial.BEDROCK -> bedrockIndustrialCoil
            }
        } else {
            bedrockIndustrialCoil
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
        tileEntityIn: IndustrialCoilTileEntity,
        texture: ResourceLocation,
        partialTicks: Float,
        matrixStackIn: MatrixStack,
        bufferIn: IRenderTypeBuffer,
        combinedLightIn: Int,
        combinedOverlayIn: Int
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

class IndustrialCoilModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val pos: ModelRenderer
    private val rotatable: ModelRenderer
    private val pos2: ModelRenderer
    private val rot2: ModelRenderer
    private val pane: ModelRenderer
    private val bone: ModelRenderer
    private val bone2: ModelRenderer
    private val bone3: ModelRenderer
    private val bone4: ModelRenderer
    private val pane2: ModelRenderer
    private val bone5: ModelRenderer
    private val bone6: ModelRenderer
    private val bone7: ModelRenderer
    private val bone8: ModelRenderer
    private val pane3: ModelRenderer
    private val bone9: ModelRenderer
    private val bone10: ModelRenderer
    private val bone11: ModelRenderer
    private val bone12: ModelRenderer

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
        pos.setTextureOffset(19, 29).addBox(-8.0f, -3.0f, -8.0f, 1.0f, 10.0f, 16.0f, 0.0f, false)
        pos.setTextureOffset(0, 18).addBox(7.0f, -3.0f, -8.0f, 1.0f, 10.0f, 16.0f, 0.0f, false)
        pos.setTextureOffset(37, 59).addBox(-7.0f, -5.0f, 4.0f, 14.0f, 12.0f, 4.0f, 0.0f, false)
        pos.setTextureOffset(0, 56).addBox(-7.0f, -5.0f, -8.0f, 14.0f, 12.0f, 4.0f, 0.0f, false)
        pos.setTextureOffset(0, 49).addBox(-4.0f, -7.0f, -8.0f, 8.0f, 2.0f, 1.0f, 0.0f, false)
        pos.setTextureOffset(0, 45).addBox(-4.0f, -7.0f, 7.0f, 8.0f, 2.0f, 1.0f, 0.0f, false)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        pos2 = ModelRenderer(this)
        pos2.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(pos2)
        pos2.setTextureOffset(37, 39).addBox(-1.0f, -1.0f, -8.5f, 2.0f, 2.0f, 17.0f, 0.0f, false)
        rot2 = ModelRenderer(this)
        rot2.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(rot2)
        setRotationAngle(rot2, 0.0f, 0.0f, 0.7854f)
        rot2.setTextureOffset(38, 18).addBox(-1.0f, -1.0f, -8.5f, 2.0f, 2.0f, 17.0f, 0.0f, false)
        pane = ModelRenderer(this)
        pane.setRotationPoint(0.0f, 0.0f, 0.5f)
        rotatable.addChild(pane)
        bone = ModelRenderer(this)
        bone.setRotationPoint(0.0f, 0.0f, 0.0f)
        pane.addChild(bone)
        bone.setTextureOffset(0, 73).addBox(-3.0f, -5.0f, -4.0f, 6.0f, 10.0f, 7.0f, 0.0f, false)
        bone2 = ModelRenderer(this)
        bone2.setRotationPoint(0.0f, 0.0f, 0.0f)
        pane.addChild(bone2)
        setRotationAngle(bone2, 0.0f, 0.0f, -0.7854f)
        bone2.setTextureOffset(67, 69).addBox(-3.0f, -5.0f, -4.0f, 6.0f, 10.0f, 7.0f, 0.0f, false)
        bone3 = ModelRenderer(this)
        bone3.setRotationPoint(0.0f, 0.0f, 0.0f)
        pane.addChild(bone3)
        setRotationAngle(bone3, 0.0f, 0.0f, -1.5708f)
        bone3.setTextureOffset(60, 11).addBox(-3.0f, -5.0f, -4.0f, 6.0f, 10.0f, 7.0f, 0.0f, false)
        bone4 = ModelRenderer(this)
        bone4.setRotationPoint(0.0f, 0.0f, 0.0f)
        pane.addChild(bone4)
        setRotationAngle(bone4, 0.0f, 0.0f, -2.3562f)
        bone4.setTextureOffset(59, 38).addBox(-3.0f, -5.0f, -4.0f, 6.0f, 10.0f, 7.0f, 0.0f, false)
        pane2 = ModelRenderer(this)
        pane2.setRotationPoint(0.0f, 0.0f, 0.75f)
        rotatable.addChild(pane2)
        bone5 = ModelRenderer(this)
        bone5.setRotationPoint(0.5f, 0.0f, 0.0f)
        pane2.addChild(bone5)
        bone5.setTextureOffset(79, 29).addBox(-3.0f, -6.0f, -0.25f, 5.0f, 12.0f, 2.0f, 0.1f, false)
        bone6 = ModelRenderer(this)
        bone6.setRotationPoint(0.5f, 0.0f, 0.0f)
        pane2.addChild(bone6)
        setRotationAngle(bone6, 0.0f, 0.0f, -0.7854f)
        bone6.setTextureOffset(27, 76).addBox(-2.8787f, -6.364f, -0.25f, 5.0f, 12.0f, 2.0f, 0.1f, false)
        bone7 = ModelRenderer(this)
        bone7.setRotationPoint(0.5f, 0.0f, 0.0f)
        pane2.addChild(bone7)
        setRotationAngle(bone7, 0.0f, 0.0f, -1.5708f)
        bone7.setTextureOffset(42, 76).addBox(-2.5355f, -6.5355f, -0.25f, 5.0f, 12.0f, 2.0f, 0.1f, false)
        bone8 = ModelRenderer(this)
        bone8.setRotationPoint(0.5f, 0.0f, 0.0f)
        pane2.addChild(bone8)
        setRotationAngle(bone8, 0.0f, 0.0f, -2.3562f)
        bone8.setTextureOffset(49, 0).addBox(-2.1716f, -6.4142f, -0.25f, 5.0f, 12.0f, 2.0f, 0.1f, false)
        pane3 = ModelRenderer(this)
        pane3.setRotationPoint(0.0f, 0.0f, -1.6f)
        rotatable.addChild(pane3)
        bone9 = ModelRenderer(this)
        bone9.setRotationPoint(0.5f, 0.0f, 0.0f)
        pane3.addChild(bone9)
        bone9.setTextureOffset(38, 18).addBox(-3.0f, -6.0f, -0.9f, 5.0f, 12.0f, 2.0f, 0.1f, false)
        bone10 = ModelRenderer(this)
        bone10.setRotationPoint(0.5f, 0.0f, 0.0f)
        pane3.addChild(bone10)
        setRotationAngle(bone10, 0.0f, 0.0f, -0.7854f)
        bone10.setTextureOffset(19, 19).addBox(-2.8787f, -6.364f, -0.9f, 5.0f, 12.0f, 2.0f, 0.1f, false)
        bone11 = ModelRenderer(this)
        bone11.setRotationPoint(0.5f, 0.0f, 0.0f)
        pane3.addChild(bone11)
        setRotationAngle(bone11, 0.0f, 0.0f, -1.5708f)
        bone11.setTextureOffset(0, 18).addBox(-2.5355f, -6.5355f, -0.9f, 5.0f, 12.0f, 2.0f, 0.1f, false)
        bone12 = ModelRenderer(this)
        bone12.setRotationPoint(0.5f, 0.0f, 0.0f)
        pane3.addChild(bone12)
        setRotationAngle(bone12, 0.0f, 0.0f, -2.3562f)
        bone12.setTextureOffset(0, 0).addBox(-2.1716f, -6.4142f, -0.9f, 5.0f, 12.0f, 2.0f, 0.1f, false)
    }
}
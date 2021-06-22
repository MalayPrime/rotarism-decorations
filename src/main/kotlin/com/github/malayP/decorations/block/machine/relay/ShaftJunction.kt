package com.github.malayP.decorations.block.machine.relay

import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.ShaftJunctionType
import com.github.zomb_676.fantasySoup.block.HorizonBlockWithTileEntity
import com.github.zomb_676.fantasySoup.render.RenderWithTextureAndModel
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


abstract class ShaftJunction : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    enum class ShaftJunctionMode(private val materialName: String) : IStringSerializable {
        MERGE("merge"),
        SPLIT("split");

        override fun toString(): String {
            return this.string
        }

        override fun getString(): String {
            return materialName
        }
    }

    enum class ShaftJunctionMaterial(private val materialName: String) : IStringSerializable {
        STEEL("steel"),
        BEDROCK("bedrock");

        override fun toString(): String {
            return this.string
        }

        override fun getString(): String {
            return materialName
        }
    }

    companion object {
        val shaftJunctionMode: EnumProperty<ShaftJunctionMode> =
            EnumProperty.create("shaft_junction_mode", ShaftJunctionMode::class.java)
        val shaftJunctionMaterial: EnumProperty<ShaftJunctionMaterial> =
            EnumProperty.create("shaft_junction_material", ShaftJunctionMaterial::class.java)
    }

    init {
        this.defaultState = defaultState.with(shaftJunctionMode, ShaftJunctionMode.MERGE)
    }

    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = ShaftJunctionTileEntity()
    override fun fillStateContainer(builder: StateContainer.Builder<Block, BlockState>) {
        super.fillStateContainer(builder.add(shaftJunctionMode).add(shaftJunctionMaterial))
    }
}

class SteelShaftJunction : ShaftJunction() {
    init {
        this.defaultState = this.defaultState.with(shaftJunctionMaterial, ShaftJunctionMaterial.STEEL)
    }
}

class BedrockShaftJunction : ShaftJunction() {
    init {
        this.defaultState = this.defaultState.with(shaftJunctionMaterial, ShaftJunctionMaterial.BEDROCK)
    }
}

class ShaftJunctionTileEntity : TileEntity(ShaftJunctionType.get()) {

}

class ShaftJunctionTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    RenderWithTextureAndModel<ShaftJunctionTileEntity>(dispatcher) {
    companion object {
        val model = ShaftJunctionModel()
        val steelCenterShaftJunction =
            modResourcesLocation("textures/tile_entity/transmission/shaft_junction/steel/shaft_junction_steel_center.png")
        val steelSideShaftJunction =
            modResourcesLocation("textures/tile_entity/transmission/shaft_junction/steel/shaft_junction_steel_side.png")
        val bedrockCenterShaftJunction =
            modResourcesLocation("textures/tile_entity/transmission/shaft_junction/bedrock/shaft_junction_bedrock_center.png")
        val bedrockSideShaftJunction =
            modResourcesLocation("textures/tile_entity/transmission/shaft_junction/bedrock/shaft_junction_bedrock_side.png")
    }

    override fun render(
        tileEntityIn: ShaftJunctionTileEntity,
        partialTicks: Float,
        matrixStackIn: MatrixStack,
        bufferIn: IRenderTypeBuffer,
        combinedLightIn: Int,
        combinedOverlayIn: Int,
    ) {
        val texture: ResourceLocation
        val model: Model = model
        texture = when (tileEntityIn.blockState.get(ShaftJunction.shaftJunctionMaterial)!!) {
            ShaftJunction.ShaftJunctionMaterial.STEEL -> steelSideShaftJunction
            ShaftJunction.ShaftJunctionMaterial.BEDROCK -> bedrockCenterShaftJunction
        }
        renderWithTextureAndModel(
            tileEntityIn,
            texture,
            model,
            partialTicks,
            matrixStackIn,
            bufferIn,
            combinedLightIn,
            combinedOverlayIn
        )
    }

    override fun renderWithTextureAndModel(
        tileEntityIn: ShaftJunctionTileEntity,
        texture: ResourceLocation,
        model: Model,
        partialTicks: Float,
        matrixStackIn: MatrixStack,
        bufferIn: IRenderTypeBuffer,
        combinedLightIn: Int,
        combinedOverlayIn: Int
    ) {
        matrixStackIn.push()
        val renderType = RenderType.getEntitySolid(texture)
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

class ShaftJunctionModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val rotateable: ModelRenderer
    private val part1: ModelRenderer
    private val pos1: ModelRenderer
    private val rot1: ModelRenderer
    private val part2: ModelRenderer
    private val pos2: ModelRenderer
    private val rot2: ModelRenderer
    private val part3: ModelRenderer
    private val pos3: ModelRenderer
    private val rot3: ModelRenderer
    private val fixed: ModelRenderer

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
        shell.setRotationPoint(0.0f, 24.0f, 0.0f)
        rotateable = ModelRenderer(this)
        rotateable.setRotationPoint(1.0f, 1.0f, 4.0f)
        shell.addChild(rotateable)
        part1 = ModelRenderer(this)
        part1.setRotationPoint(-1.0f, -9.0f, -4.0f)
        rotateable.addChild(part1)
        pos1 = ModelRenderer(this)
        pos1.setRotationPoint(0.0f, 0.0f, 0.0f)
        part1.addChild(pos1)
        pos1.setTextureOffset(14, 47).addBox(-1.0f, -1.0f, 3.51f, 2.0f, 2.0f, 5.0f, 0.0f, false)
        pos1.setTextureOffset(0, 47).addBox(-3.0f, -3.0f, 3.0f, 6.0f, 6.0f, 1.0f, 0.0f, false)
        pos1.setTextureOffset(0, 54).addBox(-2.0f, -2.0f, 2.0f, 4.0f, 4.0f, 1.0f, 0.0f, false)
        rot1 = ModelRenderer(this)
        rot1.setRotationPoint(0.0f, 0.0f, 0.0f)
        part1.addChild(rot1)
        setRotationAngle(rot1, 0.0f, 0.0f, 0.7854f)
        rot1.setTextureOffset(46, 46).addBox(-1.0f, -1.0f, 3.5f, 2.0f, 2.0f, 5.0f, 0.0f, false)
        rot1.setTextureOffset(32, 46).addBox(-3.0f, -3.0f, 3.01f, 6.0f, 6.0f, 1.0f, 0.0f, false)
        rot1.setTextureOffset(52, 53).addBox(-2.0f, -2.0f, 2.01f, 4.0f, 4.0f, 1.0f, 0.0f, false)
        part2 = ModelRenderer(this)
        part2.setRotationPoint(-1.0f, -9.0f, -4.0f)
        rotateable.addChild(part2)
        pos2 = ModelRenderer(this)
        pos2.setRotationPoint(0.0f, 0.0f, 0.0f)
        part2.addChild(pos2)
        pos2.setTextureOffset(51, 24).addBox(3.5f, -1.0f, -1.0f, 5.0f, 2.0f, 2.0f, 0.0f, false)
        pos2.setTextureOffset(16, 38).addBox(2.0f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        pos2.setTextureOffset(16, 0).addBox(3.0f, -3.0f, -3.0f, 1.0f, 6.0f, 6.0f, 0.0f, false)
        rot2 = ModelRenderer(this)
        rot2.setRotationPoint(0.0f, 0.0f, 0.0f)
        part2.addChild(rot2)
        setRotationAngle(rot2, -0.7854f, 0.0f, 0.0f)
        rot2.setTextureOffset(48, 17).addBox(3.49f, -1.0f, -1.0f, 5.0f, 2.0f, 2.0f, 0.0f, false)
        rot2.setTextureOffset(16, 30).addBox(1.99f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        rot2.setTextureOffset(0, 0).addBox(2.99f, -3.0f, -3.0f, 1.0f, 6.0f, 6.0f, 0.0f, false)
        part3 = ModelRenderer(this)
        part3.setRotationPoint(-1.0f, -9.0f, -4.0f)
        rotateable.addChild(part3)
        pos3 = ModelRenderer(this)
        pos3.setRotationPoint(0.0f, 0.0f, 0.0f)
        part3.addChild(pos3)
        pos3.setTextureOffset(39, 19).addBox(-1.0f, -1.0f, -8.5f, 2.0f, 2.0f, 5.0f, 0.0f, false)
        pos3.setTextureOffset(42, 53).addBox(-2.0f, -2.0f, -3.0f, 4.0f, 4.0f, 1.0f, 0.0f, false)
        pos3.setTextureOffset(0, 37).addBox(-3.0f, -3.0f, -4.0f, 6.0f, 6.0f, 1.0f, 0.0f, false)
        rot3 = ModelRenderer(this)
        rot3.setRotationPoint(0.0f, 0.0f, 0.0f)
        part3.addChild(rot3)
        setRotationAngle(rot3, 0.0f, 0.0f, -0.7854f)
        rot3.setTextureOffset(30, 17).addBox(-3.0f, -3.0f, -3.99f, 6.0f, 6.0f, 1.0f, 0.0f, false)
        rot3.setTextureOffset(32, 53).addBox(-2.0f, -2.0f, -2.99f, 4.0f, 4.0f, 1.0f, 0.0f, false)
        rot3.setTextureOffset(0, 30).addBox(-1.0f, -1.0f, -8.49f, 2.0f, 2.0f, 5.0f, 0.0f, false)
        fixed = ModelRenderer(this)
        fixed.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(fixed)
        fixed.setTextureOffset(16, 46).addBox(-8.0f, -1.0f, -7.0f, 1.0f, 1.0f, 14.0f, 0.0f, false)
        fixed.setTextureOffset(29, 29).addBox(-8.0f, -16.0f, -8.0f, 16.0f, 16.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(0, 32).addBox(-8.0f, -16.0f, -7.0f, 1.0f, 1.0f, 14.0f, 0.0f, false)
        fixed.setTextureOffset(30, 0).addBox(-8.0f, -16.0f, 7.0f, 16.0f, 16.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(0, 0).addBox(7.0f, -16.0f, -7.0f, 1.0f, 16.0f, 14.0f, 0.0f, false)
    }
}
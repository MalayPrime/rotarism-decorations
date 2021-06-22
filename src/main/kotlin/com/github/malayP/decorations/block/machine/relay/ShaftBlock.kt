package com.github.malayP.decorations.block.machine.relay

import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity
import com.github.zomb_676.fantasySoup.EnumShaftMaterial
import com.github.zomb_676.fantasySoup.block.AllFaceBlockWithTileEntity
import com.github.zomb_676.fantasySoup.render.RenderWithTextureAndModel
import com.github.zomb_676.fantasySoup.safeReturn
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
import net.minecraft.util.Direction
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.vector.Vector3f
import net.minecraft.world.IBlockReader


abstract class ShaftBlock(material: Material, val shaftType: EnumShaftMaterial) :
    AllFaceBlockWithTileEntity(Properties.create(material)) {
    override fun createTileEntity(state: BlockState, world: IBlockReader?): TileEntity = ShaftTileEntity()

    companion object {
        val shaftBlockMaterial: EnumProperty<EnumShaftMaterial> =
            EnumProperty.create("shaft_material", EnumShaftMaterial::class.java)
    }

    override fun fillStateContainer(builder: StateContainer.Builder<Block, BlockState>) {
        super.fillStateContainer(builder.add(shaftBlockMaterial))
    }
}

class WoodenShaft : ShaftBlock(Material.WOOD, EnumShaftMaterial.WOODEN) {
    init {
        defaultState = defaultState.with(shaftBlockMaterial, EnumShaftMaterial.WOODEN)
    }
}

class StoneShaft : ShaftBlock(Material.WOOD, EnumShaftMaterial.STONE) {
    init {
        defaultState = defaultState.with(shaftBlockMaterial, EnumShaftMaterial.STONE)
    }
}

class SteelShaft : ShaftBlock(Material.WOOD, EnumShaftMaterial.STEEL) {
    init {
        defaultState = defaultState.with(shaftBlockMaterial, EnumShaftMaterial.STEEL)
    }
}

class DiamondShaft : ShaftBlock(Material.WOOD, EnumShaftMaterial.DIAMOND) {
    init {
        defaultState = defaultState.with(shaftBlockMaterial, EnumShaftMaterial.DIAMOND)
    }
}

class BedrockShaft : ShaftBlock(Material.WOOD, EnumShaftMaterial.BEDROCK) {
    init {
        defaultState = defaultState.with(shaftBlockMaterial, EnumShaftMaterial.BEDROCK)
    }
}

class ShaftTileEntity : RelayTileEntity(AllTileEntity.shaftType.get()) {

}

class ShaftTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    RenderWithTextureAndModel<ShaftTileEntity>(dispatcher) {
    companion object {
        val horizonWoodenShaft =
            modResourcesLocation("textures/tile_entity/transmission/shaft/wooden/wooden_shaft/wooden_shaft.png")
        val verticalWoodenShaft =
            modResourcesLocation("textures/tile_entity/transmission/shaft/wooden/wooden_shaft_vertical/wooden_shaft_vertical_merged.png")
        val horizonStoneShaft =
            modResourcesLocation("textures/tile_entity/transmission/shaft/stone/stone_shaft/stone_shaft.png")
        val verticalStoneShaft =
            modResourcesLocation("textures/tile_entity/transmission/shaft/stone/stone_shaft_vertical/stone_shaft_vertical_merged.png")
        val horizonSteelShaft =
            modResourcesLocation("textures/tile_entity/transmission/shaft/steel/steel_shaft/steel_shaft.png")
        val verticalSteelShaft =
            modResourcesLocation("textures/tile_entity/transmission/shaft/steel/steel_shaft_vertical/steel_shaft_vertical_merged.png")
        val horizonDiamondShaft =
            modResourcesLocation("textures/tile_entity/transmission/shaft/diamond/diamond_shaft/diamond_shaft.png")
        val verticalDiamondShaft =
            modResourcesLocation("textures/tile_entity/transmission/shaft/diamond/diamond_shaft_vertical/diamond_shaft_vertical_merged.png")
        val horizonBedrockShaft =
            modResourcesLocation("textures/tile_entity/transmission/shaft/bedrock/bedrock_shaft/bedrock_shaft.png")
        val verticalBedrockShaft =
            modResourcesLocation("textures/tile_entity/transmission/shaft/bedrock/bedrock_shaft_vertical/bedrock_shaft_vertical_merged.png")
    }

    override fun render(
        tileEntityIn: ShaftTileEntity,
        partialTicks: Float,
        matrixStackIn: MatrixStack,
        bufferIn: IRenderTypeBuffer,
        combinedLightIn: Int,
        combinedOverlayIn: Int,
    ) {
        val model: Model = tileEntityIn.model.safeReturn {
            when (tileEntityIn.blockState.get(BlockStateProperties.FACING)!!) {
                Direction.UP, Direction.DOWN -> VerticalShaftModel()
                Direction.WEST, Direction.EAST, Direction.NORTH, Direction.SOUTH -> HorizonShaftModel()
            }
        }
        val texture: ResourceLocation =
            when (tileEntityIn.blockState.get(BlockStateProperties.FACING)!!) {
                Direction.UP, Direction.DOWN -> {
                    when (tileEntityIn.blockState.get(EnumShaftMaterial.shaftMaterial)!!) {
                        EnumShaftMaterial.WOODEN -> verticalWoodenShaft
                        EnumShaftMaterial.STONE -> verticalStoneShaft
                        EnumShaftMaterial.STEEL -> verticalSteelShaft
                        EnumShaftMaterial.DIAMOND -> verticalDiamondShaft
                        EnumShaftMaterial.BEDROCK -> verticalBedrockShaft
                    }
                }

                Direction.WEST, Direction.EAST, Direction.NORTH, Direction.SOUTH -> {
                    when (tileEntityIn.blockState.get(EnumShaftMaterial.shaftMaterial)!!) {
                        EnumShaftMaterial.WOODEN -> horizonWoodenShaft
                        EnumShaftMaterial.STONE -> horizonStoneShaft
                        EnumShaftMaterial.STEEL -> horizonSteelShaft
                        EnumShaftMaterial.DIAMOND -> horizonDiamondShaft
                        EnumShaftMaterial.BEDROCK -> horizonBedrockShaft
                    }
                }
            }
        when (model) {
            is HorizonShaftModel -> model.rotate(tileEntityIn.speed * partialTicks)
            is VerticalShaftModel -> model.rotate(tileEntityIn.speed * partialTicks)
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
        tileEntityIn: ShaftTileEntity,
        texture: ResourceLocation,
        model: Model,
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
            if (tileEntityIn.world != null) tileEntityIn.blockState.get(BlockStateProperties.FACING).horizontalAngle else 90f
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f))
        model.render(matrixStackIn, buffer, combinedLightIn, combinedOverlayIn, 1f, 1f, 1f, 1f)
        matrixStackIn.pop()
    }


}

class HorizonShaftModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val rotatable: ModelRenderer
    private val shaft_obl_r1: ModelRenderer
    private val fixed: ModelRenderer

    fun rotate(speed: Float) {
        rotatable.rotateAngleX += speed / 20
    }

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
        setRotationAngle(shell, 0.0f, 1.5708f, 0.0f)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, -8.0f, 0.0f)
        shell.addChild(rotatable)
        rotatable.setTextureOffset(18, 22).addBox(-8.5f, -1.0f, -1.0f, 17.0f, 2.0f, 2.0f, 0.0f, false)
        shaft_obl_r1 = ModelRenderer(this)
        shaft_obl_r1.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(shaft_obl_r1)
        setRotationAngle(shaft_obl_r1, -0.7854f, 0.0f, 0.0f)
        shaft_obl_r1.setTextureOffset(18, 18).addBox(-8.51f, -1.0f, -1.0f, 17.0f, 2.0f, 2.0f, 0.0f, false)
        fixed = ModelRenderer(this)
        fixed.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(fixed)
        fixed.setTextureOffset(0, 49).addBox(-8.0f, -16.0f, -5.0f, 1.0f, 3.0f, 10.0f, 0.0f, false)
        fixed.setTextureOffset(44, 0).addBox(7.0f, -16.0f, -5.0f, 1.0f, 3.0f, 10.0f, 0.0f, false)
        fixed.setTextureOffset(18, 30).addBox(-8.0f, -13.0f, -8.0f, 1.0f, 13.0f, 16.0f, 0.0f, false)
        fixed.setTextureOffset(0, 17).addBox(7.0f, -13.0f, -8.0f, 1.0f, 13.0f, 16.0f, 0.0f, false)
        fixed.setTextureOffset(0, 0).addBox(-7.0f, -1.0f, -8.0f, 14.0f, 1.0f, 16.0f, 0.0f, false)
        fixed.setTextureOffset(36, 26).addBox(-7.0f, -8.0f, -8.0f, 14.0f, 7.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(36, 36).addBox(-7.0f, -8.0f, 7.0f, 14.0f, 7.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(6, 6).addBox(6.0f, -11.0f, 7.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(0, 0).addBox(6.0f, -11.0f, -8.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(0, 6).addBox(-7.0f, -11.0f, 7.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(3, 3).addBox(-7.0f, -11.0f, -8.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
    }
}

class VerticalShaftModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val shell2: ModelRenderer
    private val rotatable: ModelRenderer
    private val pos: ModelRenderer
    private val pos_r1: ModelRenderer
    private val rot: ModelRenderer

    fun rotate(speed: Float) {
        rotatable.rotateAngleX += speed / 20
    }

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
        shell2.render(matrixStack, buffer, packedLight, packedOverlay)
    }

    fun setRotationAngle(modelRenderer: ModelRenderer, x: Float, y: Float, z: Float) {
        modelRenderer.rotateAngleX = x
        modelRenderer.rotateAngleY = y
        modelRenderer.rotateAngleZ = z
    }

    init {
        textureWidth = 64
        textureHeight = 64
        shell = ModelRenderer(this)
        shell.setRotationPoint(0.0f, 16.0f, 0.0f)
        fixed = ModelRenderer(this)
        fixed.setRotationPoint(0.0f, 8.0f, 0.0f)
        shell.addChild(fixed)
        fixed.setTextureOffset(0, 17).addBox(-8.0f, -1.0f, -8.0f, 16.0f, 1.0f, 16.0f, 0.0f, false)
        fixed.setTextureOffset(0, 0).addBox(-8.0f, -16.0f, -8.0f, 16.0f, 1.0f, 16.0f, 0.0f, false)
        fixed.setTextureOffset(6, 17).addBox(7.0f, -15.0f, -8.0f, 1.0f, 14.0f, 2.0f, 0.0f, false)
        fixed.setTextureOffset(0, 0).addBox(-8.0f, -15.0f, -8.0f, 1.0f, 14.0f, 2.0f, 0.0f, false)
        fixed.setTextureOffset(0, 17).addBox(7.0f, -15.0f, 6.0f, 1.0f, 14.0f, 2.0f, 0.0f, false)
        fixed.setTextureOffset(6, 0).addBox(-8.0f, -15.0f, 6.0f, 1.0f, 14.0f, 2.0f, 0.0f, false)
        fixed.setTextureOffset(4, 34).addBox(6.0f, -15.0f, -8.0f, 1.0f, 14.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(12, 0).addBox(-7.0f, -15.0f, -8.0f, 1.0f, 14.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(0, 34).addBox(6.0f, -15.0f, 7.0f, 1.0f, 14.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(12, 17).addBox(-7.0f, -15.0f, 7.0f, 1.0f, 14.0f, 1.0f, 0.0f, false)
        shell2 = ModelRenderer(this)
        shell2.setRotationPoint(0.0f, 16.0f, 0.0f)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(8.0f, 8.0f, -8.0f)
        shell2.addChild(rotatable)
        pos = ModelRenderer(this)
        pos.setRotationPoint(0.0f, 0.5f, 0.0f)
        rotatable.addChild(pos)
        pos_r1 = ModelRenderer(this)
        pos_r1.setRotationPoint(-8.0f, -8.5f, 8.0f)
        pos.addChild(pos_r1)
        setRotationAngle(pos_r1, 0.0f, 0.7854f, 0.0f)
        pos_r1.setTextureOffset(16, 34).addBox(-1.0f, -8.5f, -1.0f, 2.0f, 17.0f, 2.0f, 0.0f, false)
        rot = ModelRenderer(this)
        rot.setRotationPoint(0.0f, -8.0f, 0.0f)
        rotatable.addChild(rot)
        rot.setTextureOffset(8, 34).addBox(-9.0f, -8.51f, 7.0f, 2.0f, 17.0f, 2.0f, 0.0f, false)
    }
}
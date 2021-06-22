package com.github.malayP.decorations.block.machine.relay


import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.shaftDistributionClutchType
import com.github.zomb_676.fantasySoup.block.HorizonBlockWithTileEntity
import com.mojang.blaze3d.matrix.MatrixStack
import com.mojang.blaze3d.vertex.IVertexBuilder
import net.minecraft.block.BlockState
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.IRenderTypeBuffer
import net.minecraft.client.renderer.RenderType
import net.minecraft.client.renderer.model.Model
import net.minecraft.client.renderer.model.ModelRenderer
import net.minecraft.client.renderer.tileentity.TileEntityRenderer
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher
import net.minecraft.state.properties.BlockStateProperties
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.math.vector.Vector3f
import net.minecraft.world.IBlockReader


class ShaftDistributionClutch : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity =
        ShaftDistributionClutchTileEntity()
}

class ShaftDistributionClutchTileEntity : TileEntity(shaftDistributionClutchType.get()) {

}

class ShaftDistributionClutchTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    TileEntityRenderer<ShaftDistributionClutchTileEntity>(dispatcher) {
    companion object {
        val model = ShaftDistributionClutchModel()
        val texture =
            modResourcesLocation("textures/tile_entity/transmission/shaft_distribution_clutch/shaft_distribution_clutch.png")
    }

    override fun render(
        tileEntityIn: ShaftDistributionClutchTileEntity,
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

class ShaftDistributionClutchModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val pos: ModelRenderer
    private val rotatable: ModelRenderer
    private val input: ModelRenderer
    private val pos1: ModelRenderer
    private val rot1: ModelRenderer
    private val outputMain: ModelRenderer
    private val pos2: ModelRenderer
    private val rot2: ModelRenderer
    private val outputSide1: ModelRenderer
    private val pos3: ModelRenderer
    private val rot3: ModelRenderer
    private val outputSide2: ModelRenderer
    private val pos4: ModelRenderer
    private val rot4: ModelRenderer

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
        pos.setTextureOffset(38, 30).addBox(-7.0f, -3.0f, 7.0f, 14.0f, 10.0f, 1.0f, 0.0f, false)
        pos.setTextureOffset(38, 18).addBox(-7.0f, -3.0f, -8.0f, 14.0f, 10.0f, 1.0f, 0.0f, false)
        pos.setTextureOffset(19, 29).addBox(-8.0f, -3.0f, -8.0f, 1.0f, 10.0f, 16.0f, 0.0f, false)
        pos.setTextureOffset(0, 18).addBox(7.0f, -3.0f, -8.0f, 1.0f, 10.0f, 16.0f, 0.0f, false)
        pos.setTextureOffset(0, 18).addBox(-5.0f, -2.0f, -2.0f, 1.0f, 9.0f, 4.0f, 0.0f, false)
        pos.setTextureOffset(0, 0).addBox(4.0f, -2.0f, -2.0f, 1.0f, 9.0f, 4.0f, 0.0f, false)
        pos.setTextureOffset(11, 56).addBox(-2.0f, -2.0f, 4.0f, 4.0f, 9.0f, 1.0f, 0.0f, false)
        pos.setTextureOffset(0, 55).addBox(-2.0f, -2.0f, -5.0f, 4.0f, 9.0f, 1.0f, 0.0f, false)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        input = ModelRenderer(this)
        input.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(input)
        pos1 = ModelRenderer(this)
        pos1.setRotationPoint(0.0f, 0.0f, 0.0f)
        input.addChild(pos1)
        pos1.setTextureOffset(49, 0).addBox(-1.0f, -1.0f, 1.5f, 2.0f, 2.0f, 7.0f, 0.0f, false)
        pos1.setTextureOffset(61, 0).addBox(-2.0f, -2.0f, 1.48f, 4.0f, 4.0f, 1.0f, 0.0f, false)
        rot1 = ModelRenderer(this)
        rot1.setRotationPoint(0.0f, 0.0f, 0.0f)
        input.addChild(rot1)
        setRotationAngle(rot1, 0.0f, 0.0f, 0.7854f)
        rot1.setTextureOffset(47, 49).addBox(-1.0f, -1.0f, 1.49f, 2.0f, 2.0f, 7.0f, 0.0f, false)
        rot1.setTextureOffset(22, 61).addBox(-2.0f, -2.0f, 1.49f, 4.0f, 4.0f, 1.0f, 0.0f, false)
        outputMain = ModelRenderer(this)
        outputMain.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(outputMain)
        pos2 = ModelRenderer(this)
        pos2.setRotationPoint(0.0f, 0.0f, 0.0f)
        outputMain.addChild(pos2)
        pos2.setTextureOffset(0, 45).addBox(-1.0f, -1.0f, -8.5f, 2.0f, 2.0f, 7.0f, 0.0f, false)
        pos2.setTextureOffset(59, 47).addBox(-2.0f, -2.0f, -2.48f, 4.0f, 4.0f, 1.0f, 0.0f, false)
        rot2 = ModelRenderer(this)
        rot2.setRotationPoint(0.0f, 0.0f, 0.0f)
        outputMain.addChild(rot2)
        setRotationAngle(rot2, 0.0f, 0.0f, 0.7854f)
        rot2.setTextureOffset(19, 19).addBox(-1.0f, -1.0f, -8.51f, 2.0f, 2.0f, 7.0f, 0.0f, false)
        rot2.setTextureOffset(54, 59).addBox(-2.0f, -2.0f, -2.51f, 4.0f, 4.0f, 1.0f, 0.0f, false)
        outputSide1 = ModelRenderer(this)
        outputSide1.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(outputSide1)
        pos3 = ModelRenderer(this)
        pos3.setRotationPoint(0.0f, 0.0f, 0.0f)
        outputSide1.addChild(pos3)
        pos3.setTextureOffset(37, 59).addBox(2.5f, -1.0f, -1.0f, 6.0f, 2.0f, 2.0f, 0.0f, false)
        pos3.setTextureOffset(62, 62).addBox(1.95f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        rot3 = ModelRenderer(this)
        rot3.setRotationPoint(0.0f, 0.0f, 0.0f)
        outputSide1.addChild(rot3)
        setRotationAngle(rot3, -0.7854f, 0.0f, 0.0f)
        rot3.setTextureOffset(22, 56).addBox(2.49f, -1.0f, -1.0f, 6.0f, 2.0f, 2.0f, 0.0f, false)
        rot3.setTextureOffset(30, 64).addBox(1.99f, -1.5303f, -1.4697f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        outputSide2 = ModelRenderer(this)
        outputSide2.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(outputSide2)
        pos4 = ModelRenderer(this)
        pos4.setRotationPoint(0.0f, 0.0f, 0.0f)
        outputSide2.addChild(pos4)
        pos4.setTextureOffset(54, 42).addBox(-8.5f, -1.0f, -1.0f, 6.0f, 2.0f, 2.0f, 0.0f, false)
        pos4.setTextureOffset(48, 64).addBox(-2.98f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        rot4 = ModelRenderer(this)
        rot4.setRotationPoint(0.0f, 0.0f, 0.0f)
        outputSide2.addChild(rot4)
        setRotationAngle(rot4, -0.7854f, 0.0f, 0.0f)
        rot4.setTextureOffset(49, 10).addBox(-8.51f, -1.0f, -1.0f, 6.0f, 2.0f, 2.0f, 0.0f, false)
        rot4.setTextureOffset(39, 64).addBox(-3.01f, -1.4697f, -1.5303f, 1.0f, 3.0f, 3.0f, 0.0f, false)
    }
}
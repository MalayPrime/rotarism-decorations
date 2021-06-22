package com.github.malayP.decorations.block.machine.engine

import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.microturbineType
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


class Microturbine : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = MicroturbineTileEntity()
}

class MicroturbineTileEntity : TileEntity(microturbineType.get())

class MicroturbineTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    TileEntityRenderer<MicroturbineTileEntity>(
        dispatcher
    ) {
    companion object {
        val model = MicroturbineModel()
        val texture = modResourcesLocation("textures/tile_entity/engines/microturbine/microturbine.png")
    }

    override fun render(
        tileEntityIn: MicroturbineTileEntity,
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

class MicroturbineModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val pos: ModelRenderer
    private val rot: ModelRenderer
    private val other: ModelRenderer
    private val size2: ModelRenderer
    private val cast5: ModelRenderer
    private val cast6: ModelRenderer
    private val cast7: ModelRenderer
    private val cast8: ModelRenderer
    private val size3: ModelRenderer
    private val cast9: ModelRenderer
    private val cast10: ModelRenderer
    private val cast11: ModelRenderer
    private val cast12: ModelRenderer
    private val rotatable: ModelRenderer
    private val pos2: ModelRenderer
    private val rot2: ModelRenderer
    private val infan: ModelRenderer
    private val blade1: ModelRenderer
    private val blade2: ModelRenderer
    private val blade3: ModelRenderer
    private val blade4: ModelRenderer
    private val blade5: ModelRenderer
    private val blade6: ModelRenderer
    private val blade7: ModelRenderer
    private val blade8: ModelRenderer

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
        pos.setTextureOffset(0, 0).addBox(-8.0f, 6.0f, -8.0f, 16.0f, 2.0f, 16.0f, 0.0f, false)
        pos.setTextureOffset(49, 49).addBox(-2.0f, -2.0f, -5.0f, 4.0f, 4.0f, 12.0f, 0.0f, false)
        pos.setTextureOffset(69, 74).addBox(4.0f, 2.0f, -5.9f, 3.0f, 4.0f, 11.0f, 0.0f, false)
        pos.setTextureOffset(0, 70).addBox(-7.0f, 2.0f, -5.9f, 3.0f, 4.0f, 11.0f, 0.0f, false)
        pos.setTextureOffset(49, 0).addBox(-3.5f, -3.5f, -1.0f, 7.0f, 7.0f, 2.0f, 0.0f, false)
        pos.setTextureOffset(48, 19).addBox(-0.5f, -4.5f, -7.5f, 1.0f, 9.0f, 1.0f, 0.0f, false)
        pos.setTextureOffset(24, 19).addBox(-4.5f, -0.5f, -7.5f, 9.0f, 1.0f, 1.0f, 0.0f, false)
        rot = ModelRenderer(this)
        rot.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(rot)
        other = ModelRenderer(this)
        other.setRotationPoint(0.0f, 0.0f, 4.0f)
        rot.addChild(other)
        setRotationAngle(other, 0.0f, 0.0f, 0.7854f)
        other.setTextureOffset(48, 19).addBox(-2.0f, -2.0f, -9.01f, 4.0f, 4.0f, 12.0f, 0.0f, false)
        other.setTextureOffset(0, 27).addBox(-1.5f, -1.5f, -11.75f, 3.0f, 3.0f, 1.0f, 0.0f, false)
        size2 = ModelRenderer(this)
        size2.setRotationPoint(0.0f, 1.05f, 4.0f)
        rot.addChild(size2)
        cast5 = ModelRenderer(this)
        cast5.setRotationPoint(0.0f, 0.0f, 0.0f)
        size2.addChild(cast5)
        setRotationAngle(cast5, 0.0f, 0.0f, 0.7854f)
        cast5.setTextureOffset(49, 66).addBox(-6.7678f, -3.2322f, -11.95f, 2.0f, 5.0f, 13.0f, 0.0f, false)
        cast5.setTextureOffset(65, 0).addBox(3.3033f, -3.2322f, -11.95f, 2.0f, 5.0f, 13.0f, 0.0f, false)
        cast6 = ModelRenderer(this)
        cast6.setRotationPoint(0.0f, 0.0f, 0.0f)
        size2.addChild(cast6)
        cast6.setTextureOffset(31, 56).addBox(-6.0355f, -3.5355f, -12.0f, 2.0f, 5.0f, 13.0f, 0.0f, false)
        cast6.setTextureOffset(0, 51).addBox(4.0355f, -3.5355f, -12.0f, 2.0f, 5.0f, 13.0f, 0.0f, false)
        cast7 = ModelRenderer(this)
        cast7.setRotationPoint(0.0f, 0.0f, 0.0f)
        size2.addChild(cast7)
        setRotationAngle(cast7, 0.0f, 0.0f, 0.7854f)
        cast7.setTextureOffset(24, 40).addBox(-3.2322f, 3.3033f, -11.95f, 5.0f, 2.0f, 13.0f, 0.0f, false)
        cast7.setTextureOffset(0, 35).addBox(-3.2322f, -6.7678f, -11.95f, 5.0f, 2.0f, 13.0f, 0.0f, false)
        cast8 = ModelRenderer(this)
        cast8.setRotationPoint(0.0f, 0.0f, 0.0f)
        size2.addChild(cast8)
        cast8.setTextureOffset(24, 24).addBox(-2.5f, 3.0f, -12.0f, 5.0f, 2.0f, 13.0f, 0.0f, false)
        cast8.setTextureOffset(0, 19).addBox(-2.5f, -7.0711f, -12.0f, 5.0f, 2.0f, 13.0f, 0.0f, false)
        size3 = ModelRenderer(this)
        size3.setRotationPoint(0.0f, 0.85f, 7.0f)
        rot.addChild(size3)
        cast9 = ModelRenderer(this)
        cast9.setRotationPoint(0.0f, 0.0f, 0.0f)
        size3.addChild(cast9)
        setRotationAngle(cast9, 0.0f, 0.0f, 0.7854f)
        cast9.setTextureOffset(24, 40).addBox(-5.4142f, -2.5858f, -2.05f, 2.0f, 4.0f, 3.0f, 0.0f, false)
        cast9.setTextureOffset(0, 35).addBox(2.2426f, -2.5858f, -2.05f, 2.0f, 4.0f, 3.0f, 0.0f, false)
        cast10 = ModelRenderer(this)
        cast10.setRotationPoint(0.0f, 0.0f, 0.0f)
        size3.addChild(cast10)
        cast10.setTextureOffset(24, 24).addBox(-4.8284f, -2.8284f, -2.0f, 2.0f, 4.0f, 3.0f, 0.0f, false)
        cast10.setTextureOffset(0, 19).addBox(2.8284f, -2.8284f, -2.0f, 2.0f, 4.0f, 3.0f, 0.0f, false)
        cast11 = ModelRenderer(this)
        cast11.setRotationPoint(0.0f, 0.0f, 0.0f)
        size3.addChild(cast11)
        setRotationAngle(cast11, 0.0f, 0.0f, 0.7854f)
        cast11.setTextureOffset(49, 10).addBox(-2.5858f, 2.2426f, -2.05f, 4.0f, 2.0f, 3.0f, 0.0f, false)
        cast11.setTextureOffset(48, 40).addBox(-2.5858f, -5.4142f, -2.05f, 4.0f, 2.0f, 3.0f, 0.0f, false)
        cast12 = ModelRenderer(this)
        cast12.setRotationPoint(0.0f, 0.0f, 0.0f)
        size3.addChild(cast12)
        cast12.setTextureOffset(0, 6).addBox(-2.0f, 2.0f, -2.0f, 4.0f, 2.0f, 3.0f, 0.0f, false)
        cast12.setTextureOffset(0, 0).addBox(-2.0f, -5.6569f, -2.0f, 4.0f, 2.0f, 3.0f, 0.0f, false)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        pos2 = ModelRenderer(this)
        pos2.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(pos2)
        pos2.setTextureOffset(68, 52).addBox(-1.0f, -1.0f, -8.5f, 2.0f, 2.0f, 14.0f, 0.0f, false)
        pos2.setTextureOffset(7, 12).addBox(-3.0f, -1.0f, 4.0f, 2.0f, 1.0f, 1.0f, 0.0f, false)
        pos2.setTextureOffset(0, 12).addBox(1.0f, 0.0f, 4.0f, 2.0f, 1.0f, 1.0f, 0.0f, false)
        pos2.setTextureOffset(0, 43).addBox(0.0f, -3.0f, 4.0f, 1.0f, 2.0f, 1.0f, 0.0f, false)
        pos2.setTextureOffset(32, 22).addBox(-1.0f, 1.0f, 4.0f, 1.0f, 2.0f, 1.0f, 0.0f, false)
        rot2 = ModelRenderer(this)
        rot2.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(rot2)
        setRotationAngle(rot2, 0.0f, 0.0f, 0.7854f)
        rot2.setTextureOffset(67, 22).addBox(-1.0f, -1.0f, -8.49f, 2.0f, 2.0f, 14.0f, 0.0f, false)
        infan = ModelRenderer(this)
        infan.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(infan)
        blade1 = ModelRenderer(this)
        blade1.setRotationPoint(0.0f, 0.0f, -8.5f)
        infan.addChild(blade1)
        setRotationAngle(blade1, 0.0f, 0.7854f, 0.0f)
        blade1.setTextureOffset(0, 51).addBox(-2.4445f, -4.0f, 1.4445f, 1.0f, 8.0f, 1.0f, -0.05f, false)
        blade2 = ModelRenderer(this)
        blade2.setRotationPoint(0.0f, 0.0f, -8.5f)
        infan.addChild(blade2)
        setRotationAngle(blade2, 0.0f, 0.7854f, 0.3927f)
        blade2.setTextureOffset(0, 51).addBox(-2.4445f, -4.0f, 1.4445f, 1.0f, 8.0f, 1.0f, -0.05f, false)
        blade3 = ModelRenderer(this)
        blade3.setRotationPoint(0.0f, 0.0f, -8.5f)
        infan.addChild(blade3)
        setRotationAngle(blade3, 0.0f, 0.7854f, 0.7854f)
        blade3.setTextureOffset(0, 51).addBox(-2.4445f, -4.0f, 1.4445f, 1.0f, 8.0f, 1.0f, -0.05f, false)
        blade4 = ModelRenderer(this)
        blade4.setRotationPoint(0.0f, 0.0f, -8.5f)
        infan.addChild(blade4)
        setRotationAngle(blade4, 0.0f, 0.7854f, 1.1781f)
        blade4.setTextureOffset(0, 51).addBox(-2.4445f, -4.0f, 1.4445f, 1.0f, 8.0f, 1.0f, -0.05f, false)
        blade5 = ModelRenderer(this)
        blade5.setRotationPoint(0.0f, 0.0f, -8.5f)
        infan.addChild(blade5)
        setRotationAngle(blade5, 0.0f, 0.7854f, 1.5708f)
        blade5.setTextureOffset(0, 51).addBox(-2.4445f, -4.0f, 1.4445f, 1.0f, 8.0f, 1.0f, -0.05f, false)
        blade6 = ModelRenderer(this)
        blade6.setRotationPoint(0.0f, 0.0f, -8.5f)
        infan.addChild(blade6)
        setRotationAngle(blade6, 0.0f, 0.7854f, 1.9635f)
        blade6.setTextureOffset(0, 51).addBox(-2.4445f, -4.0f, 1.4445f, 1.0f, 8.0f, 1.0f, -0.05f, false)
        blade7 = ModelRenderer(this)
        blade7.setRotationPoint(0.0f, 0.0f, -8.5f)
        infan.addChild(blade7)
        setRotationAngle(blade7, 0.0f, 0.7854f, 2.3562f)
        blade7.setTextureOffset(0, 51).addBox(-2.4445f, -4.0f, 1.4445f, 1.0f, 8.0f, 1.0f, -0.05f, false)
        blade8 = ModelRenderer(this)
        blade8.setRotationPoint(0.0f, 0.0f, -8.5f)
        infan.addChild(blade8)
        setRotationAngle(blade8, 0.0f, 0.7854f, 2.7489f)
        blade8.setTextureOffset(0, 51).addBox(-2.4445f, -4.0f, 1.4445f, 1.0f, 8.0f, 1.0f, -0.05f, false)
    }
}
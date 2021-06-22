package com.github.malayP.decorations.block.machine.engine

import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.hydrokineticEngineType
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


class HydrokineticEngine : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = HydrokineticEngineTileEntity()
}

class HydrokineticEngineTileEntity : TileEntity(hydrokineticEngineType.get())

class HydrokineticEngineTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    TileEntityRenderer<HydrokineticEngineTileEntity>(
        dispatcher
    ) {
    companion object {
        val model = HydrokineticEngineModel()
        val texture = modResourcesLocation("textures/tile_entity/engines/hydrokinetic_engine/hydrokinetic_engine.png")
    }

    override fun render(
        tileEntityIn: HydrokineticEngineTileEntity,
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

class HydrokineticEngineModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val rotatable: ModelRenderer
    private val pos: ModelRenderer
    private val rot: ModelRenderer
    private val fan: ModelRenderer
    private val blade: ModelRenderer
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
        fixed.setRotationPoint(0.0f, 8.0f, 0.0f)
        shell.addChild(fixed)
        fixed.setTextureOffset(39, 0).addBox(-8.0f, -16.0f, 7.0f, 16.0f, 16.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(38, 39).addBox(-8.0f, -16.0f, -8.0f, 16.0f, 16.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(19, 40).addBox(-3.0f, -14.0f, -7.0f, 6.0f, 8.0f, 3.0f, 0.0f, false)
        fixed.setTextureOffset(0, 5).addBox(-3.0f, -6.0f, -7.0f, 6.0f, 2.0f, 2.0f, 0.0f, false)
        fixed.setTextureOffset(0, 0).addBox(-3.0f, -6.0f, 5.0f, 6.0f, 2.0f, 2.0f, 0.0f, false)
        fixed.setTextureOffset(0, 40).addBox(-3.0f, -14.0f, 4.0f, 6.0f, 8.0f, 3.0f, 0.0f, false)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        pos = ModelRenderer(this)
        pos.setRotationPoint(0.0f, 8.0f, 0.0f)
        rotatable.addChild(pos)
        pos.setTextureOffset(0, 20).addBox(-1.0f, -9.0f, -8.51f, 2.0f, 2.0f, 17.0f, 0.0f, false)
        rot = ModelRenderer(this)
        rot.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(rot)
        setRotationAngle(rot, 0.0f, 0.0f, 0.7854f)
        rot.setTextureOffset(0, 0).addBox(-1.0f, -1.0f, -8.5f, 2.0f, 2.0f, 17.0f, 0.0f, false)
        fan = ModelRenderer(this)
        fan.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(fan)
        blade = ModelRenderer(this)
        blade.setRotationPoint(0.0f, 0.0f, 0.0f)
        fan.addChild(blade)
        blade.setTextureOffset(0, 52).addBox(-7.0f, -0.5f, -3.5f, 7.0f, 1.0f, 2.0f, 0.0f, false)
        blade.setTextureOffset(37, 18).addBox(-7.0f, -0.5f, 1.5f, 7.0f, 1.0f, 2.0f, 0.0f, false)
        blade.setTextureOffset(22, 22).addBox(-15.0f, -0.5f, -6.5f, 8.0f, 1.0f, 13.0f, 0.0f, false)
        blade2 = ModelRenderer(this)
        blade2.setRotationPoint(0.0f, 0.0f, 0.0f)
        fan.addChild(blade2)
        setRotationAngle(blade2, 0.0f, 0.0f, 0.7854f)
        blade2.setTextureOffset(0, 52).addBox(-7.0f, -0.5f, -3.5f, 7.0f, 1.0f, 2.0f, 0.0f, false)
        blade2.setTextureOffset(37, 18).addBox(-7.0f, -0.5f, 1.5f, 7.0f, 1.0f, 2.0f, 0.0f, false)
        blade2.setTextureOffset(22, 22).addBox(-15.0f, -0.5f, -6.5f, 8.0f, 1.0f, 13.0f, 0.0f, false)
        blade3 = ModelRenderer(this)
        blade3.setRotationPoint(0.0f, 0.0f, 0.0f)
        fan.addChild(blade3)
        setRotationAngle(blade3, 0.0f, 0.0f, 1.5708f)
        blade3.setTextureOffset(0, 52).addBox(-7.0f, -0.5f, -3.5f, 7.0f, 1.0f, 2.0f, 0.0f, false)
        blade3.setTextureOffset(37, 18).addBox(-7.0f, -0.5f, 1.5f, 7.0f, 1.0f, 2.0f, 0.0f, false)
        blade3.setTextureOffset(22, 22).addBox(-15.0f, -0.5f, -6.5f, 8.0f, 1.0f, 13.0f, 0.0f, false)
        blade4 = ModelRenderer(this)
        blade4.setRotationPoint(0.0f, 0.0f, 0.0f)
        fan.addChild(blade4)
        setRotationAngle(blade4, 0.0f, 0.0f, 2.3562f)
        blade4.setTextureOffset(0, 52).addBox(-7.0f, -0.5f, -3.5f, 7.0f, 1.0f, 2.0f, 0.0f, false)
        blade4.setTextureOffset(37, 18).addBox(-7.0f, -0.5f, 1.5f, 7.0f, 1.0f, 2.0f, 0.0f, false)
        blade4.setTextureOffset(22, 22).addBox(-15.0f, -0.5f, -6.5f, 8.0f, 1.0f, 13.0f, 0.0f, false)
        blade5 = ModelRenderer(this)
        blade5.setRotationPoint(0.0f, 0.0f, 0.0f)
        fan.addChild(blade5)
        setRotationAngle(blade5, 0.0f, 0.0f, -3.1416f)
        blade5.setTextureOffset(0, 52).addBox(-7.0f, -0.5f, -3.5f, 7.0f, 1.0f, 2.0f, 0.0f, false)
        blade5.setTextureOffset(37, 18).addBox(-7.0f, -0.5f, 1.5f, 7.0f, 1.0f, 2.0f, 0.0f, false)
        blade5.setTextureOffset(22, 22).addBox(-15.0f, -0.5f, -6.5f, 8.0f, 1.0f, 13.0f, 0.0f, false)
        blade6 = ModelRenderer(this)
        blade6.setRotationPoint(0.0f, 0.0f, 0.0f)
        fan.addChild(blade6)
        setRotationAngle(blade6, 0.0f, 0.0f, -2.3562f)
        blade6.setTextureOffset(0, 52).addBox(-7.0f, -0.5f, -3.5f, 7.0f, 1.0f, 2.0f, 0.0f, false)
        blade6.setTextureOffset(37, 18).addBox(-7.0f, -0.5f, 1.5f, 7.0f, 1.0f, 2.0f, 0.0f, false)
        blade6.setTextureOffset(22, 22).addBox(-15.0f, -0.5f, -6.5f, 8.0f, 1.0f, 13.0f, 0.0f, false)
        blade7 = ModelRenderer(this)
        blade7.setRotationPoint(0.0f, 0.0f, 0.0f)
        fan.addChild(blade7)
        setRotationAngle(blade7, 0.0f, 0.0f, -1.5708f)
        blade7.setTextureOffset(0, 52).addBox(-7.0f, -0.5f, -3.5f, 7.0f, 1.0f, 2.0f, 0.0f, false)
        blade7.setTextureOffset(37, 18).addBox(-7.0f, -0.5f, 1.5f, 7.0f, 1.0f, 2.0f, 0.0f, false)
        blade7.setTextureOffset(22, 22).addBox(-15.0f, -0.5f, -6.5f, 8.0f, 1.0f, 13.0f, 0.0f, false)
        blade8 = ModelRenderer(this)
        blade8.setRotationPoint(0.0f, 0.0f, 0.0f)
        fan.addChild(blade8)
        setRotationAngle(blade8, 0.0f, 0.0f, -0.7854f)
        blade8.setTextureOffset(0, 52).addBox(-7.0f, -0.5f, -3.5f, 7.0f, 1.0f, 2.0f, 0.0f, false)
        blade8.setTextureOffset(37, 18).addBox(-7.0f, -0.5f, 1.5f, 7.0f, 1.0f, 2.0f, 0.0f, false)
        blade8.setTextureOffset(22, 22).addBox(-15.0f, -0.5f, -6.5f, 8.0f, 1.0f, 13.0f, 0.0f, false)
    }
}
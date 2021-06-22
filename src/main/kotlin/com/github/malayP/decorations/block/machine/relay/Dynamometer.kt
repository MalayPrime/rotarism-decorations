package com.github.malayP.decorations.block.machine.relay


import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.dynamometerType
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


class Dynamometer : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = DynamometerTileEntity()
}

class DynamometerTileEntity : TileEntity(dynamometerType.get()) {

}

class DynamometerTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    TileEntityRenderer<DynamometerTileEntity>(dispatcher) {
    companion object {
        val model = DynamometerModel()
        val texture = modResourcesLocation("textures/tile_entity/transmission/dynamometer/dynamometer.png")
    }

    override fun render(
        tileEntityIn: DynamometerTileEntity,
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

class DynamometerModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val pos0: ModelRenderer
    private val rotatable: ModelRenderer
    private val pos: ModelRenderer
    private val rot: ModelRenderer

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
        pos0 = ModelRenderer(this)
        pos0.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(pos0)
        pos0.setTextureOffset(0, 0).addBox(-7.0f, -8.0f, -8.0f, 14.0f, 16.0f, 16.0f, 0.0f, false)
        pos0.setTextureOffset(19, 56).addBox(-8.0f, -8.0f, -8.0f, 1.0f, 1.0f, 16.0f, 0.0f, false)
        pos0.setTextureOffset(45, 51).addBox(7.0f, -8.0f, -8.0f, 1.0f, 1.0f, 16.0f, 0.0f, false)
        pos0.setTextureOffset(0, 53).addBox(-8.0f, 7.0f, -8.0f, 1.0f, 1.0f, 16.0f, 0.0f, false)
        pos0.setTextureOffset(44, 33).addBox(7.0f, 7.0f, -8.0f, 1.0f, 1.0f, 16.0f, 0.0f, false)
        pos0.setTextureOffset(0, 33).addBox(-8.0f, -7.0f, 7.0f, 1.0f, 14.0f, 1.0f, 0.0f, false)
        pos0.setTextureOffset(0, 0).addBox(7.0f, -7.0f, 7.0f, 1.0f, 14.0f, 1.0f, 0.0f, false)
        pos0.setTextureOffset(10, 0).addBox(-8.0f, -7.0f, -8.0f, 1.0f, 14.0f, 1.0f, 0.0f, false)
        pos0.setTextureOffset(5, 0).addBox(7.0f, -7.0f, -8.0f, 1.0f, 14.0f, 1.0f, 0.0f, false)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        pos = ModelRenderer(this)
        pos.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(pos)
        pos.setTextureOffset(22, 36).addBox(-1.0f, -1.0f, -8.5f, 2.0f, 2.0f, 17.0f, 0.0f, false)
        rot = ModelRenderer(this)
        rot.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(rot)
        setRotationAngle(rot, 0.0f, 0.0f, 0.7854f)
        rot.setTextureOffset(0, 33).addBox(-1.0f, -1.0f, -8.49f, 2.0f, 2.0f, 17.0f, 0.0f, false)
    }
}
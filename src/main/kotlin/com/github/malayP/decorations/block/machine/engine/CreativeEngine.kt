package com.github.malayP.decorations.block.machine.engine

import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.creativeEngineType
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
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.vector.Vector3f
import net.minecraft.world.IBlockReader


class CreativeEngine : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = CreativeEngineTileEntity()
}

class CreativeEngineTileEntity : TileEntity(creativeEngineType.get()) {

}

class CreativeEngineTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    TileEntityRenderer<CreativeEngineTileEntity>(
        dispatcher
    ) {
    companion object {
        val model = CreativeEngineModel()
        val texture: ResourceLocation =
            modResourcesLocation("textures/tile_entity/engines/creative_engine/creative_engine.png")
    }

    override fun render(
        tileEntityIn: CreativeEngineTileEntity,
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

class CreativeEngineModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val body: ModelRenderer
    private val stand: ModelRenderer
    private val side_zpos: ModelRenderer
    private val side_ypos: ModelRenderer
    private val side_xneg: ModelRenderer
    private val side_xpos: ModelRenderer
    private val rotatable: ModelRenderer
    private val cube_r1: ModelRenderer

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
        body = ModelRenderer(this)
        body.setRotationPoint(0.0f, 0.0f, -0.5f)
        shell.addChild(body)
        body.setTextureOffset(0, 18).addBox(-4.0f, -11.0f, -5.5f, 8.0f, 8.0f, 12.0f, 0.0f, false)
        body.setTextureOffset(0, 18).addBox(-2.5f, -11.5f, -6.0f, 5.0f, 5.0f, 1.0f, 0.0f, false)
        body.setTextureOffset(38, 43).addBox(-2.0f, -11.0f, -7.0f, 4.0f, 4.0f, 1.0f, 0.0f, false)
        stand = ModelRenderer(this)
        stand.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(stand)
        stand.setTextureOffset(28, 18).addBox(-6.0f, -4.5f, -5.0f, 12.0f, 4.0f, 2.0f, 0.0f, false)
        stand.setTextureOffset(42, 24).addBox(-6.0f, -4.5f, 3.0f, 12.0f, 4.0f, 2.0f, 0.0f, false)
        stand.setTextureOffset(0, 0).addBox(-8.0f, -2.0f, -8.0f, 16.0f, 2.0f, 16.0f, 0.0f, false)
        side_zpos = ModelRenderer(this)
        side_zpos.setRotationPoint(0.0f, 0.0f, 1.0f)
        shell.addChild(side_zpos)
        side_zpos.setTextureOffset(28, 24).addBox(-3.0f, -8.0f, 4.5f, 6.0f, 4.0f, 1.0f, 0.0f, false)
        side_ypos = ModelRenderer(this)
        side_ypos.setRotationPoint(0.0f, -8.0f, 5.5f)
        shell.addChild(side_ypos)
        side_ypos.setTextureOffset(0, 7).addBox(-3.0f, -4.0f, -6.0f, 1.0f, 1.0f, 6.0f, 0.0f, false)
        side_ypos.setTextureOffset(42, 30).addBox(-3.0f, -4.0f, -11.0f, 6.0f, 1.0f, 5.0f, 0.0f, false)
        side_ypos.setTextureOffset(0, 0).addBox(2.0f, -4.0f, -6.0f, 1.0f, 1.0f, 6.0f, 0.0f, false)
        side_ypos.setTextureOffset(29, 38).addBox(-2.0f, -4.0f, -5.0f, 4.0f, 1.0f, 1.0f, 0.0f, false)
        side_ypos.setTextureOffset(19, 38).addBox(-2.0f, -4.0f, -3.0f, 4.0f, 1.0f, 1.0f, 0.0f, false)
        side_ypos.setTextureOffset(0, 14).addBox(-2.0f, -4.0f, -1.0f, 4.0f, 1.0f, 1.0f, 0.0f, false)
        side_xneg = ModelRenderer(this)
        side_xneg.setRotationPoint(8.0f, -3.0f, 0.5f)
        shell.addChild(side_xneg)
        side_xneg.setTextureOffset(13, 41).addBox(-4.0f, -7.0f, -6.0f, 1.0f, 1.0f, 11.0f, 0.0f, false)
        side_xneg.setTextureOffset(0, 38).addBox(-4.0f, -6.0f, -6.0f, 1.0f, 2.0f, 4.0f, 0.0f, false)
        side_xneg.setTextureOffset(29, 29).addBox(-4.0f, -4.0f, -6.0f, 1.0f, 3.0f, 11.0f, 0.0f, false)
        side_xneg.setTextureOffset(8, 0).addBox(-4.0f, -6.0f, -1.0f, 1.0f, 2.0f, 1.0f, 0.0f, false)
        side_xneg.setTextureOffset(8, 8).addBox(-4.0f, -6.0f, 1.0f, 1.0f, 2.0f, 1.0f, 0.0f, false)
        side_xneg.setTextureOffset(0, 0).addBox(-4.0f, -6.0f, 3.0f, 1.0f, 2.0f, 2.0f, 0.0f, false)
        side_xpos = ModelRenderer(this)
        side_xpos.setRotationPoint(-1.0f, -3.0f, -7.5f)
        shell.addChild(side_xpos)
        side_xpos.setTextureOffset(0, 38).addBox(-4.0f, -4.0f, 2.0f, 1.0f, 3.0f, 11.0f, 0.0f, false)
        side_xpos.setTextureOffset(0, 7).addBox(-4.0f, -6.0f, 11.0f, 1.0f, 2.0f, 2.0f, 0.0f, false)
        side_xpos.setTextureOffset(42, 42).addBox(-4.0f, -7.0f, 2.0f, 1.0f, 1.0f, 11.0f, 0.0f, false)
        side_xpos.setTextureOffset(11, 10).addBox(-4.0f, -6.0f, 9.0f, 1.0f, 2.0f, 1.0f, 0.0f, false)
        side_xpos.setTextureOffset(8, 3).addBox(-4.0f, -6.0f, 7.0f, 1.0f, 2.0f, 1.0f, 0.0f, false)
        side_xpos.setTextureOffset(13, 38).addBox(-4.0f, -6.0f, 2.0f, 1.0f, 2.0f, 4.0f, 0.0f, false)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, -8.0f, 0.0f)
        shell.addChild(rotatable)
        rotatable.setTextureOffset(26, 43).addBox(-1.0f, -2.0f, -8.49f, 2.0f, 2.0f, 4.0f, 0.0f, false)
        cube_r1 = ModelRenderer(this)
        cube_r1.setRotationPoint(0.0f, -1.0f, -5.5f)
        rotatable.addChild(cube_r1)
        setRotationAngle(cube_r1, 0.0f, 0.0f, 0.7854f)
        cube_r1.setTextureOffset(0, 24).addBox(-1.0f, -1.0f, -3.0f, 2.0f, 2.0f, 4.0f, 0.0f, false)
    }
}
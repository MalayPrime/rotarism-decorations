package com.github.malayP.decorations.block.machine.engine

import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.gasolineEngineType
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


class GasolineEngine : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = GasolineEngineTileEntity()
}

class GasolineEngineTileEntity : TileEntity(gasolineEngineType.get())

class GasolineEngineTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    TileEntityRenderer<GasolineEngineTileEntity>(
        dispatcher
    ) {
    companion object {
        val model = GasolineEngineModel()
        val texture = modResourcesLocation("textures/tile_entity/engines/gasoline_engine/gasoline_engine.png")
    }

    override fun render(
        tileEntityIn: GasolineEngineTileEntity,
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

class GasolineEngineModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val pos: ModelRenderer
    private val rot: ModelRenderer
    private val side1rot: ModelRenderer
    private val side1rot2: ModelRenderer
    private val exh: ModelRenderer
    private val cube_r1: ModelRenderer
    private val rotatable: ModelRenderer
    private val pos2: ModelRenderer
    private val rot2: ModelRenderer
    private val cube_r2: ModelRenderer

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
        pos = ModelRenderer(this)
        pos.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(pos)
        pos.setTextureOffset(0, 0).addBox(-8.0f, -2.0f, -8.0f, 16.0f, 2.0f, 16.0f, 0.0f, false)
        pos.setTextureOffset(0, 19).addBox(-4.0f, -11.0f, -7.5f, 8.0f, 9.0f, 12.0f, 0.0f, false)
        pos.setTextureOffset(49, 0).addBox(-5.0f, -13.0f, 4.0f, 10.0f, 11.0f, 4.0f, 0.0f, false)
        pos.setTextureOffset(50, 19).addBox(-6.0f, -6.0f, -7.0f, 3.0f, 4.0f, 11.0f, 0.0f, false)
        pos.setTextureOffset(49, 49).addBox(3.0f, -6.0f, -7.0f, 3.0f, 4.0f, 11.0f, 0.0f, false)
        pos.setTextureOffset(0, 41).addBox(-1.5f, -15.0f, -7.0f, 3.0f, 2.0f, 12.0f, 0.0f, false)
        rot = ModelRenderer(this)
        rot.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(rot)
        side1rot = ModelRenderer(this)
        side1rot.setRotationPoint(0.0f, -1.0f, 0.0f)
        rot.addChild(side1rot)
        setRotationAngle(side1rot, 0.0f, 0.0f, -0.3927f)
        side1rot.setTextureOffset(31, 31).addBox(-1.0f, -15.0f, -6.0f, 4.0f, 12.0f, 10.0f, 0.0f, false)
        side1rot.setTextureOffset(36, 63).addBox(0.0f, -15.5f, -5.0f, 2.0f, 1.0f, 8.0f, 0.0f, false)
        side1rot.setTextureOffset(29, 19).addBox(3.0f, -13.0f, -5.0f, 2.0f, 2.0f, 8.0f, 0.0f, false)
        side1rot.setTextureOffset(23, 54).addBox(-3.0f, -13.0f, -5.0f, 2.0f, 8.0f, 8.0f, 0.0f, false)
        side1rot2 = ModelRenderer(this)
        side1rot2.setRotationPoint(0.0f, -1.0f, 0.0f)
        rot.addChild(side1rot2)
        setRotationAngle(side1rot2, 0.0f, 0.0f, 0.3927f)
        side1rot2.setTextureOffset(31, 31).addBox(-3.0f, -15.0f, -6.0f, 4.0f, 12.0f, 10.0f, 0.0f, true)
        side1rot2.setTextureOffset(36, 63).addBox(-2.0f, -15.5f, -5.0f, 2.0f, 1.0f, 8.0f, 0.0f, true)
        side1rot2.setTextureOffset(29, 19).addBox(-5.0f, -13.0f, -5.0f, 2.0f, 2.0f, 8.0f, 0.0f, true)
        side1rot2.setTextureOffset(23, 54).addBox(1.0f, -13.0f, -5.0f, 2.0f, 8.0f, 8.0f, 0.0f, true)
        exh = ModelRenderer(this)
        exh.setRotationPoint(8.0f, -5.0f, 0.0f)
        rot.addChild(exh)
        exh.setTextureOffset(0, 0).addBox(-9.5f, -11.4121f, 4.4111f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        cube_r1 = ModelRenderer(this)
        cube_r1.setRotationPoint(-8.5f, -9.7678f, 4.6464f)
        exh.addChild(cube_r1)
        setRotationAngle(cube_r1, 0.7854f, 0.0f, 0.0f)
        cube_r1.setTextureOffset(0, 5).addBox(-0.5f, -0.75f, -1.0f, 2.0f, 2.0f, 2.0f, 0.0f, false)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        pos2 = ModelRenderer(this)
        pos2.setRotationPoint(0.0f, 0.0f, -0.5f)
        rotatable.addChild(pos2)
        pos2.setTextureOffset(60, 35).addBox(-1.0f, -1.0f, -8.0f, 2.0f, 2.0f, 9.0f, 0.0f, false)
        rot2 = ModelRenderer(this)
        rot2.setRotationPoint(0.0f, 0.0f, -0.5f)
        rotatable.addChild(rot2)
        cube_r2 = ModelRenderer(this)
        cube_r2.setRotationPoint(0.0f, 0.0f, 0.0f)
        rot2.addChild(cube_r2)
        setRotationAngle(cube_r2, 0.0f, 0.0f, 0.7854f)
        cube_r2.setTextureOffset(0, 56).addBox(-1.0f, -1.0f, -7.99f, 2.0f, 2.0f, 9.0f, 0.0f, false)
    }
}
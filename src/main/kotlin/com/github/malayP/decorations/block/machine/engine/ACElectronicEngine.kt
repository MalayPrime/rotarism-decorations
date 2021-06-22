package com.github.malayP.decorations.block.machine.engine

import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.acElectronicEngineType
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


class ACElectronicEngine : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = ACElectronicEngineTileEntity()
}

class ACElectronicEngineTileEntity : TileEntity(acElectronicEngineType.get())

class ACElectronicEngineTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    TileEntityRenderer<ACElectronicEngineTileEntity>(
        dispatcher
    ) {
    companion object {
        val model = ACElectronicEngineModel()
        val texture = modResourcesLocation("textures/tile_entity/engines/ac_electronic_engine/ac_electronic_engine.png")
    }

    override fun render(
        tileEntityIn: ACElectronicEngineTileEntity,
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

class ACElectronicEngineModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val pos: ModelRenderer
    private val rot: ModelRenderer
    private val cube_r1: ModelRenderer
    private val coil: ModelRenderer
    private val coilChild1: ModelRenderer
    private val coilChild2: ModelRenderer
    private val coilChild3: ModelRenderer
    private val coilChild4: ModelRenderer
    private val coilChild5: ModelRenderer
    private val coilChild6: ModelRenderer
    private val coilChild7: ModelRenderer
    private val coilChild8: ModelRenderer
    private val rotatable: ModelRenderer
    private val pos2: ModelRenderer
    private val rot2: ModelRenderer

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
        pos.setRotationPoint(0.0f, 8.0f, 0.0f)
        fixed.addChild(pos)
        pos.setTextureOffset(0, 0).addBox(-8.0f, -2.0f, -8.0f, 16.0f, 2.0f, 16.0f, 0.0f, false)
        pos.setTextureOffset(28, 28).addBox(-3.0f, -11.0f, -8.0f, 6.0f, 6.0f, 15.0f, 0.0f, false)
        pos.setTextureOffset(28, 19).addBox(-2.0f, -4.0f, 3.0f, 4.0f, 2.0f, 5.0f, 0.0f, false)
        pos.setTextureOffset(49, 0).addBox(-6.0f, -6.0f, -5.0f, 12.0f, 4.0f, 9.0f, 0.0f, false)
        rot = ModelRenderer(this)
        rot.setRotationPoint(0.0f, 8.0f, 0.0f)
        fixed.addChild(rot)
        cube_r1 = ModelRenderer(this)
        cube_r1.setRotationPoint(0.0f, -8.0f, 0.0f)
        rot.addChild(cube_r1)
        setRotationAngle(cube_r1, 0.0f, 0.0f, 0.7854f)
        cube_r1.setTextureOffset(0, 19).addBox(-3.0f, -3.0f, -7.95f, 6.0f, 6.0f, 15.0f, 0.0f, false)
        coil = ModelRenderer(this)
        coil.setRotationPoint(0.0f, 8.0f, 0.0f)
        fixed.addChild(coil)
        coilChild1 = ModelRenderer(this)
        coilChild1.setRotationPoint(0.0f, -8.0f, 0.0f)
        coil.addChild(coilChild1)
        coilChild1.setTextureOffset(0, 41).addBox(0.0f, -1.0f, -7.01f, 6.0f, 2.0f, 13.0f, 0.0f, false)
        coilChild1.setTextureOffset(28, 50).addBox(3.0f, -2.0f, -6.0f, 2.0f, 4.0f, 11.0f, 0.0f, false)
        coilChild2 = ModelRenderer(this)
        coilChild2.setRotationPoint(0.0f, -8.0f, 0.0f)
        coil.addChild(coilChild2)
        setRotationAngle(coilChild2, 0.0f, 0.0f, -0.7854f)
        coilChild2.setTextureOffset(0, 41).addBox(0.0f, -1.0f, -6.99f, 6.0f, 2.0f, 13.0f, 0.0f, false)
        coilChild2.setTextureOffset(28, 50).addBox(3.0f, -2.0f, -5.99f, 2.0f, 4.0f, 11.0f, 0.0f, false)
        coilChild3 = ModelRenderer(this)
        coilChild3.setRotationPoint(0.0f, -8.0f, 0.0f)
        coil.addChild(coilChild3)
        setRotationAngle(coilChild3, 0.0f, 0.0f, -1.5708f)
        coilChild3.setTextureOffset(0, 41).addBox(0.0f, -1.0f, -7.0f, 6.0f, 2.0f, 13.0f, 0.0f, false)
        coilChild3.setTextureOffset(28, 50).addBox(3.0f, -2.0f, -6.0f, 2.0f, 4.0f, 11.0f, 0.0f, false)
        coilChild4 = ModelRenderer(this)
        coilChild4.setRotationPoint(0.0f, -8.0f, 0.0f)
        coil.addChild(coilChild4)
        setRotationAngle(coilChild4, 0.0f, 0.0f, -2.3562f)
        coilChild4.setTextureOffset(0, 41).addBox(0.0f, -1.0f, -6.99f, 6.0f, 2.0f, 13.0f, 0.0f, false)
        coilChild4.setTextureOffset(28, 50).addBox(3.0f, -2.0f, -5.99f, 2.0f, 4.0f, 11.0f, 0.0f, false)
        coilChild5 = ModelRenderer(this)
        coilChild5.setRotationPoint(0.0f, -8.0f, 0.0f)
        coil.addChild(coilChild5)
        setRotationAngle(coilChild5, 0.0f, 0.0f, -3.1416f)
        coilChild5.setTextureOffset(0, 41).addBox(0.0f, -1.0f, -7.01f, 6.0f, 2.0f, 13.0f, 0.0f, false)
        coilChild5.setTextureOffset(28, 50).addBox(3.0f, -2.0f, -6.0f, 2.0f, 4.0f, 11.0f, 0.0f, false)
        coilChild6 = ModelRenderer(this)
        coilChild6.setRotationPoint(0.0f, -8.0f, 0.0f)
        coil.addChild(coilChild6)
        setRotationAngle(coilChild6, 0.0f, 0.0f, 2.3562f)
        coilChild6.setTextureOffset(0, 41).addBox(0.0f, -1.0f, -6.99f, 6.0f, 2.0f, 13.0f, 0.0f, false)
        coilChild6.setTextureOffset(28, 50).addBox(3.0f, -2.0f, -5.99f, 2.0f, 4.0f, 11.0f, 0.0f, false)
        coilChild7 = ModelRenderer(this)
        coilChild7.setRotationPoint(0.0f, -8.0f, 0.0f)
        coil.addChild(coilChild7)
        setRotationAngle(coilChild7, 0.0f, 0.0f, 1.5708f)
        coilChild7.setTextureOffset(0, 41).addBox(0.0f, -1.0f, -7.0f, 6.0f, 2.0f, 13.0f, 0.0f, false)
        coilChild7.setTextureOffset(28, 50).addBox(3.0f, -2.0f, -6.0f, 2.0f, 4.0f, 11.0f, 0.0f, false)
        coilChild8 = ModelRenderer(this)
        coilChild8.setRotationPoint(0.0f, -8.0f, 0.0f)
        coil.addChild(coilChild8)
        setRotationAngle(coilChild8, 0.0f, 0.0f, 0.7854f)
        coilChild8.setTextureOffset(0, 41).addBox(0.0f, -1.0f, -6.99f, 6.0f, 2.0f, 13.0f, 0.0f, false)
        coilChild8.setTextureOffset(28, 50).addBox(3.0f, -2.0f, -5.99f, 2.0f, 4.0f, 11.0f, 0.0f, false)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        pos2 = ModelRenderer(this)
        pos2.setRotationPoint(0.0f, 0.0f, -4.0f)
        rotatable.addChild(pos2)
        pos2.setTextureOffset(56, 14).addBox(-1.0f, -1.0f, -4.5f, 2.0f, 2.0f, 9.0f, 0.0f, false)
        rot2 = ModelRenderer(this)
        rot2.setRotationPoint(0.0f, 0.0f, -4.0f)
        rotatable.addChild(rot2)
        setRotationAngle(rot2, 0.0f, 0.0f, 0.7854f)
        rot2.setTextureOffset(55, 55).addBox(-1.0f, -1.0f, -4.49f, 2.0f, 2.0f, 9.0f, 0.0f, false)
    }
}
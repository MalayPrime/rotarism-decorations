package com.github.malayP.decorations.block.machine.relay


import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.multiDirectionalClutchType
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


class MultiDirectionalClutch : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity =
        MultiDirectionalClutchTileEntity()
}

class MultiDirectionalClutchTileEntity : TileEntity(multiDirectionalClutchType.get()) {

}

class MultiDirectionalClutchTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    TileEntityRenderer<MultiDirectionalClutchTileEntity>(dispatcher) {
    companion object {
        val model = MultiDirectionalClutchModel()
        val texture =
            modResourcesLocation("textures/tile_entity/transmission/multi_directional_clutch/multi_directional_clutch.png")
    }

    override fun render(
        tileEntityIn: MultiDirectionalClutchTileEntity,
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

class MultiDirectionalClutchModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val pos: ModelRenderer
    private val rotatable: ModelRenderer
    private val Zpos: ModelRenderer
    private val pos3: ModelRenderer
    private val rot3: ModelRenderer
    private val Znag: ModelRenderer
    private val pos1: ModelRenderer
    private val rot1: ModelRenderer
    private val Ypos: ModelRenderer
    private val pos5: ModelRenderer
    private val rot5: ModelRenderer
    private val Ynag: ModelRenderer
    private val pos6: ModelRenderer
    private val rot6: ModelRenderer
    private val Xpos: ModelRenderer
    private val pos2: ModelRenderer
    private val rot2: ModelRenderer
    private val Xnag: ModelRenderer
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
        pos.setTextureOffset(17, 50).addBox(-8.0f, 6.0f, -8.0f, 16.0f, 2.0f, 2.0f, 0.0f, false)
        pos.setTextureOffset(44, 35).addBox(-8.0f, -8.0f, -8.0f, 16.0f, 2.0f, 2.0f, 0.0f, false)
        pos.setTextureOffset(18, 85).addBox(-8.0f, -6.0f, -8.0f, 2.0f, 12.0f, 2.0f, 0.0f, false)
        pos.setTextureOffset(0, 83).addBox(6.0f, -6.0f, -8.0f, 2.0f, 12.0f, 2.0f, 0.0f, false)
        pos.setTextureOffset(48, 5).addBox(-8.0f, 6.0f, 6.0f, 16.0f, 2.0f, 2.0f, 0.0f, false)
        pos.setTextureOffset(48, 0).addBox(-8.0f, -8.0f, 6.0f, 16.0f, 2.0f, 2.0f, 0.0f, false)
        pos.setTextureOffset(9, 83).addBox(-8.0f, -6.0f, 6.0f, 2.0f, 12.0f, 2.0f, 0.0f, false)
        pos.setTextureOffset(76, 79).addBox(6.0f, -6.0f, 6.0f, 2.0f, 12.0f, 2.0f, 0.0f, false)
        pos.setTextureOffset(0, 48).addBox(6.0f, 6.0f, -6.0f, 2.0f, 2.0f, 12.0f, 0.0f, false)
        pos.setTextureOffset(42, 17).addBox(6.0f, -8.0f, -6.0f, 2.0f, 2.0f, 12.0f, 0.0f, false)
        pos.setTextureOffset(44, 44).addBox(-8.0f, 6.0f, -6.0f, 2.0f, 2.0f, 12.0f, 0.0f, false)
        pos.setTextureOffset(27, 35).addBox(-8.0f, -8.0f, -6.0f, 2.0f, 2.0f, 12.0f, 0.0f, false)
        pos.setTextureOffset(0, 0).addBox(-4.0f, -4.0f, -4.0f, 8.0f, 8.0f, 8.0f, 0.0f, false)
        pos.setTextureOffset(33, 0).addBox(-8.0f, -2.0f, -6.0f, 1.0f, 4.0f, 12.0f, 0.0f, false)
        pos.setTextureOffset(0, 31).addBox(7.0f, -2.0f, -6.0f, 1.0f, 4.0f, 12.0f, 0.0f, false)
        pos.setTextureOffset(59, 22).addBox(-6.0f, -2.0f, 7.0f, 12.0f, 4.0f, 1.0f, 0.0f, false)
        pos.setTextureOffset(59, 16).addBox(-6.0f, -2.0f, -8.0f, 12.0f, 4.0f, 1.0f, 0.0f, false)
        pos.setTextureOffset(58, 59).addBox(-6.0f, -8.0f, -2.0f, 12.0f, 1.0f, 4.0f, 0.0f, false)
        pos.setTextureOffset(25, 59).addBox(-6.0f, 7.0f, -2.0f, 12.0f, 1.0f, 4.0f, 0.0f, false)
        pos.setTextureOffset(21, 21).addBox(-2.0f, -7.99f, -6.0f, 4.0f, 1.0f, 12.0f, 0.0f, false)
        pos.setTextureOffset(0, 17).addBox(-2.0f, 6.99f, -6.0f, 4.0f, 1.0f, 12.0f, 0.0f, false)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        Zpos = ModelRenderer(this)
        Zpos.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(Zpos)
        setRotationAngle(Zpos, 0.0f, 3.1416f, 0.0f)
        pos3 = ModelRenderer(this)
        pos3.setRotationPoint(0.0f, 0.0f, 0.0f)
        Zpos.addChild(pos3)
        pos3.setTextureOffset(73, 43).addBox(-1.0f, -1.0f, -8.5f, 2.0f, 2.0f, 7.0f, 0.0f, false)
        rot3 = ModelRenderer(this)
        rot3.setRotationPoint(0.0f, 0.0f, 0.0f)
        Zpos.addChild(rot3)
        setRotationAngle(rot3, 0.0f, 0.0f, 0.7854f)
        rot3.setTextureOffset(0, 73).addBox(-1.0f, -1.0f, -8.49f, 2.0f, 2.0f, 7.0f, 0.0f, false)
        Znag = ModelRenderer(this)
        Znag.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(Znag)
        pos1 = ModelRenderer(this)
        pos1.setRotationPoint(0.0f, 0.0f, 0.0f)
        Znag.addChild(pos1)
        pos1.setTextureOffset(57, 75).addBox(-1.0f, -1.0f, -8.5f, 2.0f, 2.0f, 7.0f, 0.0f, false)
        rot1 = ModelRenderer(this)
        rot1.setRotationPoint(0.0f, 0.0f, 0.0f)
        Znag.addChild(rot1)
        setRotationAngle(rot1, 0.0f, 0.0f, 0.7854f)
        rot1.setTextureOffset(38, 75).addBox(-1.0f, -1.0f, -8.49f, 2.0f, 2.0f, 7.0f, 0.0f, false)
        Ypos = ModelRenderer(this)
        Ypos.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(Ypos)
        setRotationAngle(Ypos, -1.5708f, 0.0f, 0.0f)
        pos5 = ModelRenderer(this)
        pos5.setRotationPoint(0.0f, 0.0f, 0.0f)
        Ypos.addChild(pos5)
        pos5.setTextureOffset(38, 65).addBox(-1.0f, -1.0f, -8.5f, 2.0f, 2.0f, 7.0f, 0.0f, false)
        rot5 = ModelRenderer(this)
        rot5.setRotationPoint(0.0f, 0.0f, 0.0f)
        Ypos.addChild(rot5)
        setRotationAngle(rot5, 0.0f, 0.0f, 0.7854f)
        rot5.setTextureOffset(19, 65).addBox(-1.0f, -1.0f, -8.49f, 2.0f, 2.0f, 7.0f, 0.0f, false)
        Ynag = ModelRenderer(this)
        Ynag.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(Ynag)
        setRotationAngle(Ynag, 1.5708f, 0.0f, 0.0f)
        pos6 = ModelRenderer(this)
        pos6.setRotationPoint(0.0f, 0.0f, 0.0f)
        Ynag.addChild(pos6)
        pos6.setTextureOffset(0, 63).addBox(-1.0f, -1.0f, -8.5f, 2.0f, 2.0f, 7.0f, 0.0f, false)
        rot6 = ModelRenderer(this)
        rot6.setRotationPoint(0.0f, 0.0f, 0.0f)
        Ynag.addChild(rot6)
        setRotationAngle(rot6, 0.0f, 0.0f, 0.7854f)
        rot6.setTextureOffset(61, 40).addBox(-1.0f, -1.0f, -8.49f, 2.0f, 2.0f, 7.0f, 0.0f, false)
        Xpos = ModelRenderer(this)
        Xpos.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(Xpos)
        setRotationAngle(Xpos, 0.0f, 1.5708f, 0.0f)
        pos2 = ModelRenderer(this)
        pos2.setRotationPoint(0.0f, 0.0f, 0.0f)
        Xpos.addChild(pos2)
        pos2.setTextureOffset(19, 75).addBox(-1.0f, -1.0f, -8.5f, 2.0f, 2.0f, 7.0f, 0.0f, false)
        rot2 = ModelRenderer(this)
        rot2.setRotationPoint(0.0f, 0.0f, 0.0f)
        Xpos.addChild(rot2)
        setRotationAngle(rot2, 0.0f, 0.0f, 0.7854f)
        rot2.setTextureOffset(74, 33).addBox(-1.0f, -1.0f, -8.49f, 2.0f, 2.0f, 7.0f, 0.0f, false)
        Xnag = ModelRenderer(this)
        Xnag.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(Xnag)
        setRotationAngle(Xnag, 0.0f, -1.5708f, 0.0f)
        pos4 = ModelRenderer(this)
        pos4.setRotationPoint(0.0f, 0.0f, 0.0f)
        Xnag.addChild(pos4)
        pos4.setTextureOffset(69, 69).addBox(-1.0f, -1.0f, -8.5f, 2.0f, 2.0f, 7.0f, 0.0f, false)
        rot4 = ModelRenderer(this)
        rot4.setRotationPoint(0.0f, 0.0f, 0.0f)
        Xnag.addChild(rot4)
        setRotationAngle(rot4, 0.0f, 0.0f, 0.7854f)
        rot4.setTextureOffset(57, 65).addBox(-1.0f, -1.0f, -8.49f, 2.0f, 2.0f, 7.0f, 0.0f, false)
    }
}
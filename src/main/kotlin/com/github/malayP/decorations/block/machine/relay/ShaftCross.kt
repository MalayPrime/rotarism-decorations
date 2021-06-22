package com.github.malayP.decorations.block.machine.relay


import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.shaftCrossType
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


class ShaftCross : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = ShaftCrossTileEntity()
}

class ShaftCrossTileEntity : TileEntity(shaftCrossType.get()) {

}

class ShaftCrossTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    TileEntityRenderer<ShaftCrossTileEntity>(dispatcher) {
    companion object {
        val model = ShaftCrossModel()
        val texture = modResourcesLocation("textures/tile_entity/transmission/shaft_cross/shaft_cross.png")
    }

    override fun render(
        tileEntityIn: ShaftCrossTileEntity,
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

class ShaftCrossModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val pos2: ModelRenderer
    private val rot2: ModelRenderer
    private val rotatable: ModelRenderer
    private val z: ModelRenderer
    private val pos: ModelRenderer
    private val rot: ModelRenderer
    private val x: ModelRenderer
    private val side1: ModelRenderer
    private val pos3: ModelRenderer
    private val rot3: ModelRenderer
    private val side2: ModelRenderer
    private val pos4: ModelRenderer
    private val rot4: ModelRenderer
    private val trans: ModelRenderer
    private val pos5: ModelRenderer
    private val rot5: ModelRenderer

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
        pos2 = ModelRenderer(this)
        pos2.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(pos2)
        pos2.setTextureOffset(0, 0).addBox(-8.0f, 7.0f, -8.0f, 16.0f, 1.0f, 16.0f, 0.0f, false)
        pos2.setTextureOffset(0, 18).addBox(-4.0f, 2.0f, -1.0f, 1.0f, 6.0f, 4.0f, 0.0f, false)
        pos2.setTextureOffset(0, 0).addBox(3.0f, 2.0f, -1.0f, 1.0f, 6.0f, 4.0f, 0.0f, false)
        pos2.setTextureOffset(31, 42).addBox(-8.0f, -2.0f, -7.0f, 1.0f, 9.0f, 14.0f, 0.0f, false)
        pos2.setTextureOffset(0, 62).addBox(-8.0f, -5.0f, -7.0f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        pos2.setTextureOffset(29, 18).addBox(-8.0f, -5.0f, 4.0f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        pos2.setTextureOffset(0, 38).addBox(7.0f, -2.0f, -7.0f, 1.0f, 9.0f, 14.0f, 0.0f, false)
        pos2.setTextureOffset(30, 28).addBox(7.0f, -5.0f, -7.0f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        pos2.setTextureOffset(8, 26).addBox(7.0f, -5.0f, 4.0f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        pos2.setTextureOffset(48, 42).addBox(-8.0f, -5.0f, 7.0f, 16.0f, 12.0f, 1.0f, 0.0f, false)
        pos2.setTextureOffset(17, 47).addBox(-5.0f, -8.0f, 7.0f, 10.0f, 3.0f, 1.0f, 0.0f, false)
        pos2.setTextureOffset(44, 18).addBox(-8.0f, -5.0f, -8.0f, 16.0f, 12.0f, 1.0f, 0.0f, false)
        pos2.setTextureOffset(49, 0).addBox(-5.0f, -8.0f, -8.0f, 10.0f, 3.0f, 1.0f, 0.0f, false)
        rot2 = ModelRenderer(this)
        rot2.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(rot2)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        z = ModelRenderer(this)
        z.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(z)
        pos = ModelRenderer(this)
        pos.setRotationPoint(0.0f, 0.0f, 0.0f)
        z.addChild(pos)
        pos.setTextureOffset(0, 18).addBox(-1.0f, -1.0f, -8.49f, 2.0f, 2.0f, 17.0f, 0.0f, false)
        rot = ModelRenderer(this)
        rot.setRotationPoint(0.0f, 0.0f, 0.0f)
        z.addChild(rot)
        setRotationAngle(rot, 0.0f, 0.0f, 0.7854f)
        rot.setTextureOffset(22, 22).addBox(-1.0f, -1.0f, -8.5f, 2.0f, 2.0f, 17.0f, 0.0f, false)
        x = ModelRenderer(this)
        x.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(x)
        side1 = ModelRenderer(this)
        side1.setRotationPoint(0.0f, 0.0f, 0.0f)
        x.addChild(side1)
        pos3 = ModelRenderer(this)
        pos3.setRotationPoint(0.0f, 0.0f, 0.0f)
        side1.addChild(pos3)
        pos3.setTextureOffset(62, 56).addBox(5.51f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        pos3.setTextureOffset(24, 66).addBox(5.48f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        rot3 = ModelRenderer(this)
        rot3.setRotationPoint(0.0f, 0.0f, 0.0f)
        side1.addChild(rot3)
        setRotationAngle(rot3, -0.7854f, 0.0f, 0.0f)
        rot3.setTextureOffset(61, 37).addBox(5.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        rot3.setTextureOffset(62, 62).addBox(5.49f, -1.5303f, -1.5303f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        side2 = ModelRenderer(this)
        side2.setRotationPoint(-12.0f, 0.0f, 0.0f)
        x.addChild(side2)
        pos4 = ModelRenderer(this)
        pos4.setRotationPoint(0.0f, 0.0f, 0.0f)
        side2.addChild(pos4)
        pos4.setTextureOffset(0, 47).addBox(3.49f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        pos4.setTextureOffset(18, 62).addBox(5.52f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        rot4 = ModelRenderer(this)
        rot4.setRotationPoint(0.0f, 0.0f, 0.0f)
        side2.addChild(rot4)
        setRotationAngle(rot4, -0.7854f, 0.0f, 0.0f)
        rot4.setTextureOffset(0, 11).addBox(3.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        rot4.setTextureOffset(9, 62).addBox(5.51f, -1.5303f, -1.5303f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        trans = ModelRenderer(this)
        trans.setRotationPoint(0.0f, 4.0f, 1.0f)
        x.addChild(trans)
        pos5 = ModelRenderer(this)
        pos5.setRotationPoint(-12.0f, 2.5f, -0.5f)
        trans.addChild(pos5)
        pos5.setTextureOffset(44, 32).addBox(6.49f, -3.5f, -0.5f, 11.0f, 2.0f, 2.0f, 0.0f, false)
        pos5.setTextureOffset(60, 5).addBox(17.46f, -4.5f, -1.5f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        pos5.setTextureOffset(0, 38).addBox(5.46f, -4.5f, -1.5f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        rot5 = ModelRenderer(this)
        rot5.setRotationPoint(-12.0f, 2.5f, -0.5f)
        trans.addChild(rot5)
        setRotationAngle(rot5, -0.7854f, 0.0f, 0.0f)
        rot5.setTextureOffset(17, 42).addBox(6.5f, -3.1213f, -2.4142f, 11.0f, 2.0f, 2.0f, 0.0f, false)
        rot5.setTextureOffset(49, 5).addBox(17.47f, -4.1213f, -3.4142f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        rot5.setTextureOffset(22, 22).addBox(5.47f, -4.1213f, -3.4142f, 1.0f, 4.0f, 4.0f, 0.0f, false)
    }
}
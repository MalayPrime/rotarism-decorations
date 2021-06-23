package com.github.malayP.decorations.block.machine.consumer

import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.centrifugeType
import com.github.zomb_676.fantasySoup.block.HorizonBlockWithTileEntity
import com.mojang.blaze3d.matrix.MatrixStack
import com.mojang.blaze3d.vertex.IVertexBuilder
import net.minecraft.block.BlockState
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.IRenderTypeBuffer
import net.minecraft.client.renderer.RenderType
import net.minecraft.client.renderer.entity.model.EntityModel
import net.minecraft.client.renderer.model.Model
import net.minecraft.client.renderer.model.ModelRenderer
import net.minecraft.client.renderer.tileentity.TileEntityRenderer
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher
import net.minecraft.state.properties.BlockStateProperties
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.math.vector.Vector3f
import net.minecraft.world.IBlockReader


class Centrifuge : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = CentrifugeTileEntity()
}

class CentrifugeTileEntity : TileEntity(centrifugeType.get())

class CentrifugeTileEntityRender(dispatcher: TileEntityRendererDispatcher) : TileEntityRenderer<CentrifugeTileEntity>(
    dispatcher
) {
    companion object{
        val texture = modResourcesLocation("textures/tile_entity/processing/centrifuge/centrifuge.png")
        val model = CentrifugeModel()
    }
    override fun render(
        tileEntityIn: CentrifugeTileEntity,
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

class CentrifugeModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val base: ModelRenderer
    private val bone9: ModelRenderer
    private val bone10: ModelRenderer
    private val bone11: ModelRenderer
    private val bone12: ModelRenderer
    private val bone13: ModelRenderer
    private val drum: ModelRenderer
    private val body: ModelRenderer
    private val bone8: ModelRenderer
    private val bone7: ModelRenderer
    private val bone5: ModelRenderer
    private val bone6: ModelRenderer
    private val bone4: ModelRenderer
    private val bone3: ModelRenderer
    private val bone2: ModelRenderer
    private val bone: ModelRenderer
    private val spt: ModelRenderer
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
        setRotationAngle(shell, 0.0f, 1.5708f, 0.0f)
        fixed = ModelRenderer(this)
        fixed.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(fixed)
        base = ModelRenderer(this)
        base.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(base)
        base.setTextureOffset(0, 0).addBox(-8.0f, 6.0f, -8.0f, 16.0f, 2.0f, 16.0f, 0.0f, false)
        base.setTextureOffset(0, 37).addBox(-8.0f, 1.0f, -8.0f, 4.0f, 5.0f, 16.0f, 0.0f, false)
        base.setTextureOffset(57, 76).addBox(-4.0f, -4.0f, 7.0f, 8.0f, 9.0f, 1.0f, 0.0f, false)
        base.setTextureOffset(41, 22).addBox(-4.0f, -4.0f, -8.0f, 8.0f, 9.0f, 1.0f, 0.0f, false)
        base.setTextureOffset(0, 19).addBox(-4.0f, 5.0f, -8.0f, 12.0f, 1.0f, 16.0f, 0.0f, false)
        base.setTextureOffset(49, 3).addBox(6.0f, 3.0f, -8.0f, 2.0f, 2.0f, 16.0f, 0.0f, false)
        bone9 = ModelRenderer(this)
        bone9.setRotationPoint(0.0f, 0.0f, 0.0f)
        base.addChild(bone9)
        setRotationAngle(bone9, 0.0f, 0.0f, -0.7854f)
        bone9.setTextureOffset(24, 61).addBox(-7.5f, 1.0f, -7.5f, 1.0f, 1.0f, 15.0f, 0.0f, false)
        bone9.setTextureOffset(41, 37).addBox(-6.5f, -4.0f, -7.5f, 3.0f, 8.0f, 15.0f, 0.0f, false)
        bone9.setTextureOffset(0, 73).addBox(-3.5f, -7.0f, 5.5f, 7.0f, 11.0f, 2.0f, 0.0f, false)
        bone9.setTextureOffset(78, 51).addBox(-3.25f, 4.0f, 5.5f, 6.0f, 4.0f, 2.0f, 0.0f, false)
        bone9.setTextureOffset(36, 78).addBox(-3.25f, 4.0f, -7.5f, 6.0f, 4.0f, 2.0f, 0.0f, false)
        bone9.setTextureOffset(70, 0).addBox(-3.5f, -7.0f, -7.5f, 7.0f, 11.0f, 2.0f, 0.0f, false)
        bone10 = ModelRenderer(this)
        bone10.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone9.addChild(bone10)
        setRotationAngle(bone10, 0.7854f, 0.0f, 0.0f)
        bone10.setTextureOffset(19, 78).addBox(-3.5f, -8.8388f, 1.0607f, 7.0f, 5.0f, 1.0f, 0.0f, false)
        bone11 = ModelRenderer(this)
        bone11.setRotationPoint(0.0f, -2.0f, -2.0f)
        bone9.addChild(bone11)
        setRotationAngle(bone11, -0.7854f, 0.0f, 0.0f)
        bone11.setTextureOffset(76, 76).addBox(-3.5f, -8.8388f, 0.7678f, 7.0f, 5.0f, 1.0f, 0.0f, false)
        bone12 = ModelRenderer(this)
        bone12.setRotationPoint(4.9497f, -1.2929f, -2.0f)
        bone9.addChild(bone12)
        setRotationAngle(bone12, 0.0f, 0.0f, -0.7854f)
        bone12.setTextureOffset(0, 59).addBox(-3.5f, -5.8388f, -4.0f, 7.0f, 1.0f, 12.0f, 0.0f, false)
        bone13 = ModelRenderer(this)
        bone13.setRotationPoint(2.1213f, -4.1213f, -2.0f)
        bone9.addChild(bone13)
        setRotationAngle(bone13, 0.0f, 0.0f, -1.5708f)
        bone13.setTextureOffset(57, 22).addBox(-3.5f, -5.8388f, -4.0f, 7.0f, 1.0f, 12.0f, 0.0f, false)
        bone13.setTextureOffset(42, 37).addBox(-0.9f, -4.8388f, 0.0f, 1.0f, 3.0f, 4.0f, 0.0f, false)
        drum = ModelRenderer(this)
        drum.setRotationPoint(2.0f, -1.0f, 0.0f)
        fixed.addChild(drum)
        setRotationAngle(drum, 0.0f, 0.0f, -0.7854f)
        body = ModelRenderer(this)
        body.setRotationPoint(0.0f, 4.0f, 0.0f)
        drum.addChild(body)
        bone8 = ModelRenderer(this)
        bone8.setRotationPoint(0.0f, -4.0f, 0.0f)
        body.addChild(bone8)
        setRotationAngle(bone8, 0.0f, 0.7854f, 0.0f)
        bone8.setTextureOffset(0, 19).addBox(-2.0024f, -4.0f, -4.826f, 4.0f, 1.0f, 1.0f, 0.0f, false)
        bone8.setTextureOffset(0, 87).addBox(-2.0024f, -3.0f, -4.826f, 4.0f, 5.0f, 0.0f, 0.0f, false)
        bone8.setTextureOffset(0, 19).addBox(-2.0024f, 2.0f, -4.826f, 4.0f, 1.0f, 1.0f, 0.0f, false)
        bone7 = ModelRenderer(this)
        bone7.setRotationPoint(0.0f, -4.0f, 0.0f)
        body.addChild(bone7)
        setRotationAngle(bone7, 0.0f, 1.5708f, 0.0f)
        bone7.setTextureOffset(0, 37).addBox(-2.0034f, -4.0f, -4.8284f, 4.0f, 1.0f, 1.0f, 0.0f, false)
        bone7.setTextureOffset(0, 87).addBox(-2.0034f, -3.0f, -4.8284f, 4.0f, 5.0f, 0.0f, 0.0f, false)
        bone7.setTextureOffset(0, 37).addBox(-2.0034f, 2.0f, -4.8284f, 4.0f, 1.0f, 1.0f, 0.0f, false)
        bone5 = ModelRenderer(this)
        bone5.setRotationPoint(0.0f, -4.0f, 0.0f)
        body.addChild(bone5)
        setRotationAngle(bone5, 0.0f, 3.1416f, 0.0f)
        bone5.setTextureOffset(0, 59).addBox(-2.0f, -4.0f, -4.8319f, 4.0f, 1.0f, 1.0f, 0.0f, false)
        bone5.setTextureOffset(0, 87).addBox(-2.0f, -3.0f, -4.8319f, 4.0f, 5.0f, 0.0f, 0.0f, false)
        bone5.setTextureOffset(0, 59).addBox(-2.0f, 2.0f, -4.8319f, 4.0f, 1.0f, 1.0f, 0.0f, false)
        bone6 = ModelRenderer(this)
        bone6.setRotationPoint(0.0f, -4.0f, 0.0f)
        body.addChild(bone6)
        setRotationAngle(bone6, 0.0f, 2.3562f, 0.0f)
        bone6.setTextureOffset(49, 0).addBox(-2.0024f, -4.0f, -4.8309f, 4.0f, 1.0f, 1.0f, 0.0f, false)
        bone6.setTextureOffset(0, 87).addBox(-2.0024f, -3.0f, -4.8309f, 4.0f, 5.0f, 0.0f, 0.0f, false)
        bone6.setTextureOffset(49, 0).addBox(-2.0024f, 2.0f, -4.8309f, 4.0f, 1.0f, 1.0f, 0.0f, false)
        bone4 = ModelRenderer(this)
        bone4.setRotationPoint(0.0f, -4.0f, 0.0f)
        body.addChild(bone4)
        setRotationAngle(bone4, 0.0f, -2.3562f, 0.0f)
        bone4.setTextureOffset(27, 59).addBox(-1.9976f, -4.0f, -4.8309f, 4.0f, 1.0f, 1.0f, 0.0f, false)
        bone4.setTextureOffset(0, 87).addBox(-1.9976f, -3.0f, -4.8309f, 4.0f, 5.0f, 0.0f, 0.0f, false)
        bone4.setTextureOffset(27, 59).addBox(-1.9976f, 2.0f, -4.8309f, 4.0f, 1.0f, 1.0f, 0.0f, false)
        bone4.setTextureOffset(42, 61).addBox(-1.9976f, 2.4f, -4.0809f, 4.0f, 0.0f, 8.0f, 0.0f, false)
        bone4.setTextureOffset(42, 61).addBox(-1.9976f, -3.5f, -4.0809f, 4.0f, 0.0f, 8.0f, 0.0f, false)
        bone3 = ModelRenderer(this)
        bone3.setRotationPoint(0.0f, -4.0f, 0.0f)
        body.addChild(bone3)
        setRotationAngle(bone3, 0.0f, -1.5708f, 0.0f)
        bone3.setTextureOffset(76, 83).addBox(-1.9966f, -4.0f, -4.8284f, 4.0f, 1.0f, 1.0f, 0.0f, false)
        bone3.setTextureOffset(0, 87).addBox(-1.9966f, -3.0f, -4.8284f, 4.0f, 5.0f, 0.0f, 0.0f, false)
        bone3.setTextureOffset(76, 83).addBox(-1.9966f, 2.0f, -4.8284f, 4.0f, 1.0f, 1.0f, 0.0f, false)
        bone3.setTextureOffset(63, 36).addBox(-1.9966f, 2.5f, -3.8284f, 4.0f, 0.0f, 8.0f, 0.0f, false)
        bone3.setTextureOffset(63, 36).addBox(-1.9966f, -3.7f, -3.8284f, 4.0f, 0.0f, 8.0f, 0.0f, false)
        bone2 = ModelRenderer(this)
        bone2.setRotationPoint(0.0f, -4.0f, 0.0f)
        body.addChild(bone2)
        setRotationAngle(bone2, 0.0f, -0.7854f, 0.0f)
        bone2.setTextureOffset(84, 22).addBox(-1.9976f, -4.0f, -4.826f, 4.0f, 1.0f, 1.0f, 0.0f, false)
        bone2.setTextureOffset(0, 87).addBox(-1.9976f, -3.0f, -4.826f, 4.0f, 5.0f, 0.0f, 0.0f, false)
        bone2.setTextureOffset(84, 22).addBox(-1.9976f, 2.0f, -4.826f, 4.0f, 1.0f, 1.0f, 0.0f, false)
        bone2.setTextureOffset(25, 37).addBox(-1.9976f, 2.6f, -3.826f, 4.0f, 0.0f, 8.0f, 0.0f, false)
        bone2.setTextureOffset(25, 37).addBox(-1.9976f, -3.6f, -3.826f, 4.0f, 0.0f, 8.0f, 0.0f, false)
        bone = ModelRenderer(this)
        bone.setRotationPoint(0.0f, -4.0f, 0.0f)
        body.addChild(bone)
        bone.setTextureOffset(84, 58).addBox(-2.0f, -4.0f, -4.825f, 4.0f, 1.0f, 1.0f, 0.0f, false)
        bone.setTextureOffset(0, 87).addBox(-2.0f, -3.0f, -4.825f, 4.0f, 5.0f, 0.0f, 0.0f, false)
        bone.setTextureOffset(84, 58).addBox(-2.0f, 2.0f, -4.825f, 4.0f, 1.0f, 1.0f, 0.0f, false)
        bone.setTextureOffset(67, 61).addBox(-2.0f, 2.3f, -4.075f, 4.0f, 0.0f, 8.0f, 0.0f, false)
        bone.setTextureOffset(67, 61).addBox(-2.0f, -3.4f, -4.075f, 4.0f, 0.0f, 8.0f, 0.0f, false)
        spt = ModelRenderer(this)
        spt.setRotationPoint(0.0f, 0.0f, 0.0f)
        drum.addChild(spt)
        spt.setTextureOffset(0, 0).addBox(-1.0f, -6.0f, -1.0f, 2.0f, 13.0f, 2.0f, 0.0f, false)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        pos = ModelRenderer(this)
        pos.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(pos)
        pos.setTextureOffset(7, 30).addBox(-1.0f, 7.5f, -1.0f, 2.0f, 1.0f, 2.0f, 0.0f, false)
        rot = ModelRenderer(this)
        rot.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(rot)
        setRotationAngle(rot, 0.0f, -0.7854f, 0.0f)
        rot.setTextureOffset(0, 28).addBox(-1.0f, 7.5f, -1.0f, 2.0f, 1.0f, 2.0f, 0.0f, false)
    }
}
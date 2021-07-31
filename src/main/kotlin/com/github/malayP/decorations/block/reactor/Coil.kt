package com.github.malayP.decorations.block.reactor

import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllItems
import com.github.malayP.decorations.register.AllTileEntity.coilType
import com.github.zomb_676.fantasySoup.block.BlockWithTileEntity
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
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.nbt.CompoundNBT
import net.minecraft.nbt.IntNBT
import net.minecraft.network.NetworkManager
import net.minecraft.network.play.server.SUpdateTileEntityPacket
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.ActionResultType
import net.minecraft.util.Hand
import net.minecraft.util.Util
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.BlockRayTraceResult
import net.minecraft.util.math.shapes.VoxelShape
import net.minecraft.util.math.vector.Vector3f
import net.minecraft.util.text.ITextComponent
import net.minecraft.util.text.StringTextComponent
import net.minecraft.world.IBlockReader
import net.minecraft.world.World
import net.minecraftforge.common.util.Constants.BlockFlags.NO_NEIGHBOR_DROPS
import net.minecraftforge.common.util.Constants.BlockFlags.RERENDER_MAIN_THREAD
import kotlin.math.abs


class Coil : BlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = CoilTileEntity()

    override fun onBlockActivated(
        state: BlockState,
        worldIn: World,
        pos: BlockPos,
        player: PlayerEntity,
        handIn: Hand,
        hit: BlockRayTraceResult
    ): ActionResultType {
        if (!worldIn.isRemote) {
            if (player.getHeldItem(handIn).item == AllItems.wrench.get()) {
                (worldIn.getTileEntity(pos) as? CoilTileEntity)?.apply {
                    rotate(if (player.isSneaking) -5 else 5)
                    player.sendMessage(StringTextComponent("degree set to ${this.degree}"),Util.DUMMY_UUID)
                }
                return ActionResultType.SUCCESS
            }
        }
        return ActionResultType.CONSUME
    }
    
    override fun getRenderShape(state: BlockState, worldIn: IBlockReader, pos: BlockPos): VoxelShape =
        makeCuboidShape(-16.0,0.0,-16.0,32.0,32.0,48.0)
}

class CoilTileEntity : TileEntity(coilType.get()) {
    fun rotate(rotateDegree: Int) {
        degree = abs((degree + rotateDegree) % 360)
        world?.notifyBlockUpdate(pos,blockState,blockState, RERENDER_MAIN_THREAD.or(NO_NEIGHBOR_DROPS))
        markDirty()
    }

    var degree: Int = 0

    override fun getUpdateTag(): CompoundNBT =super.getUpdateTag().apply { put("degree",IntNBT.valueOf(degree)) }

    override fun handleUpdateTag(state: BlockState?, tag: CompoundNBT?) {
        tag?.getInt("degree")?.apply { degree=this }
    }

    override fun getUpdatePacket(): SUpdateTileEntityPacket =
        SUpdateTileEntityPacket(pos,-1,CompoundNBT().apply { put("degree",IntNBT.valueOf(degree)) })

    override fun onDataPacket(net: NetworkManager?, pkt: SUpdateTileEntityPacket?) {
        pkt?.nbtCompound?.getInt("degree")?.apply { degree=this }
    }

    override fun read(state: BlockState, nbt: CompoundNBT) {
        degree=nbt.getInt("degree")
        super.read(state, nbt)
    }

    override fun write(compound: CompoundNBT): CompoundNBT {
        compound.put("degree", IntNBT.valueOf(degree))
        return super.write(compound)
    }


}

class CoilTileEntityRender(rendererDispatcherIn: TileEntityRendererDispatcher) : TileEntityRenderer<CoilTileEntity>(
    rendererDispatcherIn
) {
    companion object {
        val texture = modResourcesLocation("textures/tile_entity/reactor/coil/coil.png")
        val model = CoilModel()
    }

    override fun render(
        tileEntityIn: CoilTileEntity,
        partialTicks: Float,
        matrixStackIn: MatrixStack,
        bufferIn: IRenderTypeBuffer,
        combinedLightIn: Int,
        combinedOverlayIn: Int
    ) {
        matrixStackIn.push()
        val renderType = RenderType.getEntityTranslucent(texture)
        val buffer = bufferIn.getBuffer(renderType)
        matrixStackIn.scale(1f, -1f, -1f)
        matrixStackIn.translate(0.5, -1.5, -0.5)
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(tileEntityIn.degree.toFloat()))
        matrixStackIn.translate(0.0,-1.0,0.0)
        model.render(matrixStackIn, buffer, combinedLightIn, combinedOverlayIn, 1f, 1f, 1f, 1f)
        matrixStackIn.pop()
    }

}

class CoilModel : Model(RenderType::getEntitySolid) {
    private val main_frame: ModelRenderer
    private val cube_r3: ModelRenderer
    private val cube_r8: ModelRenderer
    private val cube_r9: ModelRenderer
    private val cube_r4: ModelRenderer
    private val sup: ModelRenderer
    private val bone11: ModelRenderer
    private val cube_r11_r1: ModelRenderer
    private val cube_r10_r1: ModelRenderer
    private val cube_r10_r2: ModelRenderer
    private val cube_r9_r1: ModelRenderer
    private val casing: ModelRenderer
    private val cube_r5: ModelRenderer
    private val coil: ModelRenderer
    private val cube_r23: ModelRenderer
    private val cube_r25: ModelRenderer
    private val cube_r7: ModelRenderer
    private val cube_r2: ModelRenderer
    private val cube_r6: ModelRenderer
    private val cube_r27: ModelRenderer

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
        main_frame.render(matrixStack, buffer, packedLight, packedOverlay)
        sup.render(matrixStack, buffer, packedLight, packedOverlay)
        casing.render(matrixStack, buffer, packedLight, packedOverlay)
        coil.render(matrixStack, buffer, packedLight, packedOverlay)
    }

    fun setRotationAngle(modelRenderer: ModelRenderer, x: Float, y: Float, z: Float) {
        modelRenderer.rotateAngleX = x
        modelRenderer.rotateAngleY = y
        modelRenderer.rotateAngleZ = z
    }

    init {
        textureWidth = 256
        textureHeight = 256
        main_frame = ModelRenderer(this)
        main_frame.setRotationPoint(0.0f, -5.0f, 0.0f)
        main_frame.setTextureOffset(0, 34).addBox(-9.0f, 42.0f, -8.0f, 18.0f, 1.0f, 16.0f, 0.0f, false)
        main_frame.setTextureOffset(34, 95).addBox(-22.0f, 12.0f, -8.0f, 1.0f, 18.0f, 16.0f, 0.0f, false)
        main_frame.setTextureOffset(0, 17).addBox(-9.0f, -1.0f, -8.0f, 18.0f, 1.0f, 16.0f, 0.0f, false)
        main_frame.setTextureOffset(90, 92).addBox(21.0f, 12.0f, -8.0f, 1.0f, 18.0f, 16.0f, 0.0f, false)
        cube_r3 = ModelRenderer(this)
        cube_r3.setRotationPoint(0.1924f, 21.0797f, 0.0f)
        main_frame.addChild(cube_r3)
        setRotationAngle(cube_r3, 0.0f, 0.0f, -0.7854f)
        cube_r3.setTextureOffset(0, 92).addBox(-22.0f, -9.3848f, -8.0f, 1.0f, 18.0f, 16.0f, 0.0f, false)
        cube_r8 = ModelRenderer(this)
        cube_r8.setRotationPoint(0.1924f, 20.9203f, 0.0f)
        main_frame.addChild(cube_r8)
        setRotationAngle(cube_r8, 0.0f, 0.0f, 0.7854f)
        cube_r8.setTextureOffset(0, 92).addBox(-22.0f, -8.9999f, -8.0f, 1.0f, 18.0f, 16.0f, 0.0f, false)
        cube_r9 = ModelRenderer(this)
        cube_r9.setRotationPoint(-0.1924f, 20.9203f, 0.0f)
        main_frame.addChild(cube_r9)
        setRotationAngle(cube_r9, 0.0f, 0.0f, -0.7854f)
        cube_r9.setTextureOffset(0, 92).addBox(21.0f, -8.9999f, -8.0f, 1.0f, 18.0f, 16.0f, 0.0f, true)
        cube_r4 = ModelRenderer(this)
        cube_r4.setRotationPoint(0.0797f, 20.8076f, 0.0f)
        main_frame.addChild(cube_r4)
        setRotationAngle(cube_r4, 0.0f, 0.0f, -0.7854f)
        cube_r4.setTextureOffset(0, 0).addBox(-9.3848f, 21.0f, -8.0f, 18.0f, 1.0f, 16.0f, 0.0f, false)
        sup = ModelRenderer(this)
        sup.setRotationPoint(0.0f, 24.0f, 0.0f)
        bone11 = ModelRenderer(this)
        bone11.setRotationPoint(0.0f, 0.0f, 0.0f)
        sup.addChild(bone11)
        bone11.setTextureOffset(0, 17).addBox(-22.5f, -12.0f, -9.0f, 1.0f, 8.0f, 1.0f, 0.0f, false)
        bone11.setTextureOffset(0, 17).addBox(-22.5f, -12.0f, 8.0f, 1.0f, 8.0f, 1.0f, 0.0f, false)
        bone11.setTextureOffset(0, 17).addBox(-22.5f, -12.0f, -9.0f, 1.0f, 8.0f, 1.0f, 0.0f, false)
        bone11.setTextureOffset(0, 17).addBox(-22.5f, -12.0f, 8.0f, 1.0f, 8.0f, 1.0f, 0.0f, false)
        bone11.setTextureOffset(0, 17).addBox(21.5f, -12.0f, -9.0f, 1.0f, 8.0f, 1.0f, 0.0f, true)
        bone11.setTextureOffset(0, 17).addBox(21.5f, -12.0f, 8.0f, 1.0f, 8.0f, 1.0f, 0.0f, true)
        bone11.setTextureOffset(0, 17).addBox(21.5f, -12.0f, -9.0f, 1.0f, 8.0f, 1.0f, 0.0f, true)
        bone11.setTextureOffset(0, 17).addBox(21.5f, -12.0f, 8.0f, 1.0f, 8.0f, 1.0f, 0.0f, true)
        bone11.setTextureOffset(0, 0).addBox(-24.5f, -12.0f, -7.0f, 3.0f, 8.0f, 1.0f, 0.0f, false)
        bone11.setTextureOffset(0, 0).addBox(-24.5f, -12.0f, 6.0f, 3.0f, 8.0f, 1.0f, 0.0f, false)
        bone11.setTextureOffset(0, 0).addBox(-24.5f, -12.0f, -7.0f, 3.0f, 8.0f, 1.0f, 0.0f, false)
        bone11.setTextureOffset(0, 0).addBox(-24.5f, -12.0f, 6.0f, 3.0f, 8.0f, 1.0f, 0.0f, false)
        bone11.setTextureOffset(0, 0).addBox(21.5f, -12.0f, -7.0f, 3.0f, 8.0f, 1.0f, 0.0f, true)
        bone11.setTextureOffset(0, 0).addBox(21.5f, -12.0f, 6.0f, 3.0f, 8.0f, 1.0f, 0.0f, true)
        bone11.setTextureOffset(0, 0).addBox(21.5f, -12.0f, -7.0f, 3.0f, 8.0f, 1.0f, 0.0f, true)
        bone11.setTextureOffset(0, 0).addBox(21.5f, -12.0f, 6.0f, 3.0f, 8.0f, 1.0f, 0.0f, true)
        cube_r11_r1 = ModelRenderer(this)
        cube_r11_r1.setRotationPoint(22.7929f, -8.0f, 7.2929f)
        bone11.addChild(cube_r11_r1)
        setRotationAngle(cube_r11_r1, 0.0f, 0.7854f, 0.0f)
        cube_r11_r1.setTextureOffset(8, 0).addBox(-1.4142f, -4.0f, -1.0f, 2.0f, 8.0f, 1.0f, 0.0f, true)
        cube_r11_r1.setTextureOffset(8, 0).addBox(-1.4142f, -4.0f, -1.0f, 2.0f, 8.0f, 1.0f, 0.0f, true)
        cube_r10_r1 = ModelRenderer(this)
        cube_r10_r1.setRotationPoint(22.7929f, -8.0f, -7.2929f)
        bone11.addChild(cube_r10_r1)
        setRotationAngle(cube_r10_r1, 0.0f, -0.7854f, 0.0f)
        cube_r10_r1.setTextureOffset(8, 0).addBox(-1.4142f, -4.0f, -1.0f, 2.0f, 8.0f, 1.0f, 0.0f, true)
        cube_r10_r1.setTextureOffset(8, 0).addBox(-1.4142f, -4.0f, -1.0f, 2.0f, 8.0f, 1.0f, 0.0f, true)
        cube_r10_r2 = ModelRenderer(this)
        cube_r10_r2.setRotationPoint(-22.7929f, -8.0f, 7.2929f)
        bone11.addChild(cube_r10_r2)
        setRotationAngle(cube_r10_r2, 0.0f, -0.7854f, 0.0f)
        cube_r10_r2.setTextureOffset(8, 0).addBox(-1.4142f, -4.0f, -1.0f, 2.0f, 8.0f, 1.0f, 0.0f, false)
        cube_r10_r2.setTextureOffset(8, 0).addBox(-1.4142f, -4.0f, -1.0f, 2.0f, 8.0f, 1.0f, 0.0f, false)
        cube_r9_r1 = ModelRenderer(this)
        cube_r9_r1.setRotationPoint(-22.7929f, -8.0f, -7.2929f)
        bone11.addChild(cube_r9_r1)
        setRotationAngle(cube_r9_r1, 0.0f, 0.7854f, 0.0f)
        cube_r9_r1.setTextureOffset(8, 0).addBox(-1.4142f, -4.0f, -1.0f, 2.0f, 8.0f, 1.0f, 0.0f, false)
        cube_r9_r1.setTextureOffset(8, 0).addBox(-1.4142f, -4.0f, -1.0f, 2.0f, 8.0f, 1.0f, 0.0f, false)
        casing = ModelRenderer(this)
        casing.setRotationPoint(-8.0f, 16.0f, 8.0f)
        casing.setTextureOffset(46, 80).addBox(0.0f, 23.0f, -15.0f, 16.0f, 1.0f, 14.0f, 0.0f, false)
        casing.setTextureOffset(68, 95).addBox(-16.0f, -9.5f, -3.0f, 1.0f, 19.0f, 1.0f, 0.0f, false)
        casing.setTextureOffset(68, 95).addBox(31.0f, -9.5f, -3.0f, 1.0f, 19.0f, 1.0f, 0.0f, false)
        casing.setTextureOffset(68, 95).addBox(-16.0f, -9.5f, -14.0f, 1.0f, 19.0f, 1.0f, 0.0f, false)
        casing.setTextureOffset(68, 95).addBox(31.0f, -9.5f, -14.0f, 1.0f, 19.0f, 1.0f, 0.0f, false)
        casing.setTextureOffset(0, 77).addBox(0.0f, -24.0f, -15.0f, 16.0f, 1.0f, 14.0f, 0.0f, false)
        cube_r5 = ModelRenderer(this)
        cube_r5.setRotationPoint(8.0f, 0.0f, -8.0f)
        casing.addChild(cube_r5)
        setRotationAngle(cube_r5, 0.0f, 0.0f, 0.7854f)
        cube_r5.setTextureOffset(110, 112).addBox(23.0f, -8.0f, -7.0f, 1.0f, 16.0f, 14.0f, 0.0f, false)
        cube_r5.setTextureOffset(74, 2).addBox(-8.0f, -24.0f, -7.0f, 16.0f, 1.0f, 14.0f, 0.0f, false)
        cube_r5.setTextureOffset(68, 112).addBox(-24.0f, -8.0f, -7.0f, 1.0f, 16.0f, 14.0f, 0.0f, false)
        cube_r5.setTextureOffset(48, 65).addBox(-8.0f, 23.0f, -7.0f, 16.0f, 1.0f, 14.0f, 0.0f, false)
        coil = ModelRenderer(this)
        coil.setRotationPoint(-30.0f, 7.5f, 1.0f)
        coil.setTextureOffset(0, 64).addBox(20.5f, 30.5f, -7.0f, 19.0f, 1.0f, 12.0f, 0.0f, false)
        coil.setTextureOffset(50, 52).addBox(20.5f, -14.5f, -7.0f, 19.0f, 1.0f, 12.0f, 0.0f, false)
        cube_r23 = ModelRenderer(this)
        cube_r23.setRotationPoint(53.0f, 0.0f, 3.0f)
        coil.addChild(cube_r23)
        setRotationAngle(cube_r23, 0.0f, 0.0f, -1.5708f)
        cube_r23.setTextureOffset(52, 34).addBox(-18.0f, -1.0f, -10.0f, 19.0f, 1.0f, 12.0f, 0.0f, false)
        cube_r25 = ModelRenderer(this)
        cube_r25.setRotationPoint(71.3848f, 61.8406f, 3.0f)
        coil.addChild(cube_r25)
        setRotationAngle(cube_r25, 0.0f, 0.0f, 2.3562f)
        cube_r25.setTextureOffset(52, 17).addBox(-18.0f, 44.0f, -10.0f, 19.0f, 1.0f, 12.0f, 0.0f, false)
        cube_r7 = ModelRenderer(this)
        cube_r7.setRotationPoint(71.3848f, -44.8406f, 3.0f)
        coil.addChild(cube_r7)
        setRotationAngle(cube_r7, 0.0f, 0.0f, -2.3562f)
        cube_r7.setTextureOffset(52, 17).addBox(-18.0f, -45.0f, -10.0f, 19.0f, 1.0f, 12.0f, 0.0f, false)
        cube_r2 = ModelRenderer(this)
        cube_r2.setRotationPoint(-11.3848f, 61.8406f, -5.0f)
        coil.addChild(cube_r2)
        setRotationAngle(cube_r2, 0.0f, 0.0f, -2.3562f)
        cube_r2.setTextureOffset(52, 17).addBox(-1.0922f, 44.0f, -2.0f, 19.0f, 1.0f, 12.0f, 0.0f, true)
        cube_r6 = ModelRenderer(this)
        cube_r6.setRotationPoint(-11.3848f, -44.8406f, -5.0f)
        coil.addChild(cube_r6)
        setRotationAngle(cube_r6, 0.0f, 0.0f, 2.3562f)
        cube_r6.setTextureOffset(52, 17).addBox(-1.0922f, -45.0f, -2.0f, 19.0f, 1.0f, 12.0f, 0.0f, true)
        cube_r27 = ModelRenderer(this)
        cube_r27.setRotationPoint(8.0f, 0.0f, 3.0f)
        coil.addChild(cube_r27)
        setRotationAngle(cube_r27, 0.0f, 0.0f, -1.5708f)
        cube_r27.setTextureOffset(0, 51).addBox(-18.0f, -1.0f, -10.0f, 19.0f, 1.0f, 12.0f, 0.0f, false)
    }
}

package com.github.malayP.decorations.block.machine

import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.gunTurretType
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


class GunTurret : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = GunTurretTileEntity()
}

class GunTurretTileEntity : TileEntity(gunTurretType.get()) {

}

class GunTurretTileEntityRender(rendererDispatcherIn: TileEntityRendererDispatcher) :
    TileEntityRenderer<GunTurretTileEntity>(
        rendererDispatcherIn
    ) {
    companion object {
        val texture = modResourcesLocation("textures/tile_entity/gun_turret/gun_turret.png")
        val model = GunTurretModel()
    }

    override fun render(
        tileEntityIn: GunTurretTileEntity,
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
        val f: Float =
            if (tileEntityIn.world != null) tileEntityIn.blockState.get(BlockStateProperties.HORIZONTAL_FACING).horizontalAngle else 90f
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f))
        model.render(matrixStackIn, buffer, combinedLightIn, combinedOverlayIn, 1f, 1f, 1f, 1f)
        matrixStackIn.pop()
    }

}

class GunTurretModel : Model(RenderType::getEntitySolid) {
    private val horizontal_rot: ModelRenderer
    private val vertical_rot: ModelRenderer
    private val magezine_clip2: ModelRenderer
    private val bone4: ModelRenderer
    private val cube_r1: ModelRenderer
    private val cube_r2: ModelRenderer
    private val cube_r3: ModelRenderer
    private val magezine_clip: ModelRenderer
    private val bone7: ModelRenderer
    private val cube_r4: ModelRenderer
    private val cube_r5: ModelRenderer
    private val cube_r6: ModelRenderer
    private val gun_barrel_indi_rotating: ModelRenderer
    private val cube_r7: ModelRenderer
    private val cube_r8: ModelRenderer
    private val cube_r9: ModelRenderer
    private val bone2: ModelRenderer
    private val cube_r10: ModelRenderer
    private val cube_r11: ModelRenderer
    private val cube_r12: ModelRenderer
    private val cube_r13: ModelRenderer
    private val bone: ModelRenderer
    private val cube_r14: ModelRenderer
    private val cube_r15: ModelRenderer
    private val cube_r16: ModelRenderer
    private val cube_r17: ModelRenderer
    private val gun_main: ModelRenderer
    private val cube_r18: ModelRenderer
    private val cube_r19: ModelRenderer
    private val bone6: ModelRenderer
    private val bone9: ModelRenderer
    private val cube_r20: ModelRenderer
    private val cube_r21: ModelRenderer
    private val bone8: ModelRenderer
    private val cube_r22: ModelRenderer
    private val cube_r23: ModelRenderer
    private val shaft: ModelRenderer
    private val cube_r24: ModelRenderer
    private val cube_r25: ModelRenderer
    private val cube_r26: ModelRenderer
    private val supporting: ModelRenderer
    private val cube_r27: ModelRenderer
    private val cube_r28: ModelRenderer
    private val bb_main: ModelRenderer

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
        horizontal_rot.render(matrixStack, buffer, packedLight, packedOverlay)
        bb_main.render(matrixStack, buffer, packedLight, packedOverlay)
    }

    fun setRotationAngle(modelRenderer: ModelRenderer, x: Float, y: Float, z: Float) {
        modelRenderer.rotateAngleX = x
        modelRenderer.rotateAngleY = y
        modelRenderer.rotateAngleZ = z
    }

    init {
        textureWidth = 128
        textureHeight = 128
        horizontal_rot = ModelRenderer(this)
        horizontal_rot.setRotationPoint(0.0f, 26.0f, 0.0f)
        vertical_rot = ModelRenderer(this)
        vertical_rot.setRotationPoint(0.0f, -11.0f, 2.0f)
        horizontal_rot.addChild(vertical_rot)
        magezine_clip2 = ModelRenderer(this)
        magezine_clip2.setRotationPoint(0.0f, 11.5f, -1.0f)
        vertical_rot.addChild(magezine_clip2)
        magezine_clip2.setTextureOffset(30, 50).addBox(-7.5f, -12.0f, -1.0f, 5.0f, 3.0f, 5.0f, 0.0f, false)
        bone4 = ModelRenderer(this)
        bone4.setRotationPoint(-6.0f, -11.5f, 0.0f)
        magezine_clip2.addChild(bone4)
        bone4.setTextureOffset(48, 0).addBox(-1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 3.0f, 0.0f, false)
        bone4.setTextureOffset(0, 43).addBox(1.0f, -3.0f, 0.0f, 1.0f, 1.0f, 3.0f, 0.0f, false)
        bone4.setTextureOffset(0, 39).addBox(3.0f, -3.0f, 0.0f, 1.0f, 1.0f, 3.0f, 0.0f, false)
        bone4.setTextureOffset(0, 53).addBox(2.0f, -3.0f, 0.5f, 1.0f, 1.0f, 2.0f, 0.0f, false)
        cube_r1 = ModelRenderer(this)
        cube_r1.setRotationPoint(0.0898f, -2.631f, 0.5f)
        bone4.addChild(cube_r1)
        setRotationAngle(cube_r1, 0.0f, 0.0f, 1.1781f)
        cube_r1.setTextureOffset(10, 11).addBox(0.0f, -1.0f, 0.0f, 1.0f, 1.0f, 2.0f, 0.0f, false)
        cube_r2 = ModelRenderer(this)
        cube_r2.setRotationPoint(-0.6173f, -1.9239f, 0.0f)
        bone4.addChild(cube_r2)
        setRotationAngle(cube_r2, 0.0f, 0.0f, 0.7854f)
        cube_r2.setTextureOffset(7, 0).addBox(0.0f, -1.0f, 0.0f, 1.0f, 1.0f, 3.0f, 0.0f, false)
        cube_r3 = ModelRenderer(this)
        cube_r3.setRotationPoint(-1.0f, -1.0f, 0.5f)
        bone4.addChild(cube_r3)
        setRotationAngle(cube_r3, 0.0f, 0.0f, 0.3927f)
        cube_r3.setTextureOffset(30, 40).addBox(0.0f, -1.0f, 0.0f, 1.0f, 1.0f, 2.0f, 0.0f, false)
        magezine_clip = ModelRenderer(this)
        magezine_clip.setRotationPoint(0.0f, 11.5f, -1.0f)
        vertical_rot.addChild(magezine_clip)
        magezine_clip.setTextureOffset(50, 51).addBox(2.5f, -12.0f, -1.0f, 5.0f, 3.0f, 5.0f, 0.0f, false)
        bone7 = ModelRenderer(this)
        bone7.setRotationPoint(6.0f, -11.5f, 0.0f)
        magezine_clip.addChild(bone7)
        bone7.setTextureOffset(41, 58).addBox(0.0f, -1.0f, 0.0f, 1.0f, 1.0f, 3.0f, 0.0f, false)
        bone7.setTextureOffset(49, 40).addBox(-2.0f, -3.0f, 0.0f, 1.0f, 1.0f, 3.0f, 0.0f, false)
        bone7.setTextureOffset(48, 4).addBox(-4.0f, -3.0f, 0.0f, 1.0f, 1.0f, 3.0f, 0.0f, false)
        bone7.setTextureOffset(0, 56).addBox(-3.0f, -3.0f, 0.5f, 1.0f, 1.0f, 2.0f, 0.0f, false)
        cube_r4 = ModelRenderer(this)
        cube_r4.setRotationPoint(-0.0898f, -2.631f, 0.5f)
        bone7.addChild(cube_r4)
        setRotationAngle(cube_r4, 0.0f, 0.0f, -1.1781f)
        cube_r4.setTextureOffset(60, 29).addBox(-1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 2.0f, 0.0f, false)
        cube_r5 = ModelRenderer(this)
        cube_r5.setRotationPoint(0.6173f, -1.9239f, 0.0f)
        bone7.addChild(cube_r5)
        setRotationAngle(cube_r5, 0.0f, 0.0f, -0.7854f)
        cube_r5.setTextureOffset(49, 44).addBox(-1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 3.0f, 0.0f, false)
        cube_r6 = ModelRenderer(this)
        cube_r6.setRotationPoint(1.0f, -1.0f, 0.5f)
        bone7.addChild(cube_r6)
        setRotationAngle(cube_r6, 0.0f, 0.0f, -0.3927f)
        cube_r6.setTextureOffset(60, 32).addBox(-1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 2.0f, 0.0f, false)
        gun_barrel_indi_rotating = ModelRenderer(this)
        gun_barrel_indi_rotating.setRotationPoint(0.0f, 18.9f, 0.0f)
        vertical_rot.addChild(gun_barrel_indi_rotating)
        cube_r7 = ModelRenderer(this)
        cube_r7.setRotationPoint(-1.317f, -19.333f, -18.5f)
        gun_barrel_indi_rotating.addChild(cube_r7)
        setRotationAngle(cube_r7, 0.0f, 0.0f, -0.5236f)
        cube_r7.setTextureOffset(49, 41).addBox(0.0f, -0.5f, 1.5f, 1.0f, 1.0f, 9.0f, 0.0f, false)
        cube_r8 = ModelRenderer(this)
        cube_r8.setRotationPoint(0.0009f, -21.1126f, -18.5f)
        gun_barrel_indi_rotating.addChild(cube_r8)
        setRotationAngle(cube_r8, 0.0f, 0.0f, 1.5708f)
        cube_r8.setTextureOffset(19, 50).addBox(-0.5f, -0.5f, 1.5f, 1.0f, 1.0f, 9.0f, 0.0f, false)
        cube_r9 = ModelRenderer(this)
        cube_r9.setRotationPoint(1.5f, -18.65f, -18.0f)
        gun_barrel_indi_rotating.addChild(cube_r9)
        setRotationAngle(cube_r9, 0.0f, 0.0f, -1.0472f)
        cube_r9.setTextureOffset(48, 0).addBox(0.0f, -1.5f, 1.0f, 1.0f, 1.0f, 9.0f, 0.0f, false)
        bone2 = ModelRenderer(this)
        bone2.setRotationPoint(1.866f, -0.7481f, 9.0f)
        gun_barrel_indi_rotating.addChild(bone2)
        bone2.setTextureOffset(54, 59).addBox(-3.366f, -18.9019f, -17.0f, 3.0f, 1.0f, 3.0f, 0.0f, false)
        bone2.setTextureOffset(60, 21).addBox(-2.3652f, -21.3645f, -17.0f, 1.0f, 1.0f, 3.0f, 0.0f, false)
        bone2.setTextureOffset(30, 29).addBox(-2.8652f, -20.3645f, -17.0f, 2.0f, 2.0f, 3.0f, 0.0f, false)
        cube_r10 = ModelRenderer(this)
        cube_r10.setRotationPoint(0.9991f, -19.2674f, -19.0f)
        bone2.addChild(cube_r10)
        setRotationAngle(cube_r10, 0.0f, 0.0f, 1.0472f)
        cube_r10.setTextureOffset(58, 10).addBox(-3.0f, 1.0f, 2.0f, 3.0f, 1.0f, 3.0f, 0.0f, false)
        cube_r11 = ModelRenderer(this)
        cube_r11.setRotationPoint(2.0f, -20.0f, -19.0f)
        bone2.addChild(cube_r11)
        setRotationAngle(cube_r11, 0.0f, 0.0f, -1.0472f)
        cube_r11.setTextureOffset(17, 60).addBox(-3.0f, -2.0f, 2.0f, 1.0f, 1.0f, 3.0f, 0.0f, false)
        cube_r12 = ModelRenderer(this)
        cube_r12.setRotationPoint(-2.3652f, -21.3645f, -19.0f)
        bone2.addChild(cube_r12)
        setRotationAngle(cube_r12, 0.0f, 0.0f, -1.0472f)
        cube_r12.setTextureOffset(59, 5).addBox(-3.0f, 0.0f, 2.0f, 3.0f, 1.0f, 3.0f, 0.0f, false)
        cube_r13 = ModelRenderer(this)
        cube_r13.setRotationPoint(-3.366f, -17.9019f, -19.0f)
        bone2.addChild(cube_r13)
        setRotationAngle(cube_r13, 0.0f, 0.0f, 1.0472f)
        cube_r13.setTextureOffset(60, 17).addBox(-1.0f, -1.0f, 2.0f, 1.0f, 1.0f, 3.0f, 0.0f, false)
        bone = ModelRenderer(this)
        bone.setRotationPoint(1.866f, -0.7481f, 2.5f)
        gun_barrel_indi_rotating.addChild(bone)
        bone.setTextureOffset(45, 51).addBox(-3.366f, -18.9019f, -19.0f, 3.0f, 1.0f, 2.0f, 0.0f, false)
        bone.setTextureOffset(33, 60).addBox(-2.3652f, -21.3645f, -19.0f, 1.0f, 1.0f, 2.0f, 0.0f, false)
        bone.setTextureOffset(25, 60).addBox(-2.8652f, -20.3645f, -19.0f, 2.0f, 2.0f, 2.0f, 0.0f, false)
        cube_r14 = ModelRenderer(this)
        cube_r14.setRotationPoint(0.9991f, -19.2674f, -19.0f)
        bone.addChild(cube_r14)
        setRotationAngle(cube_r14, 0.0f, 0.0f, 1.0472f)
        cube_r14.setTextureOffset(0, 13).addBox(-3.0f, 1.0f, 0.0f, 3.0f, 1.0f, 2.0f, 0.0f, false)
        cube_r15 = ModelRenderer(this)
        cube_r15.setRotationPoint(2.0f, -20.0f, -19.0f)
        bone.addChild(cube_r15)
        setRotationAngle(cube_r15, 0.0f, 0.0f, -1.0472f)
        cube_r15.setTextureOffset(60, 35).addBox(-3.0f, -2.0f, 0.0f, 1.0f, 1.0f, 2.0f, 0.0f, false)
        cube_r16 = ModelRenderer(this)
        cube_r16.setRotationPoint(-2.3652f, -21.3645f, -19.0f)
        bone.addChild(cube_r16)
        setRotationAngle(cube_r16, 0.0f, 0.0f, -1.0472f)
        cube_r16.setTextureOffset(30, 34).addBox(-3.0f, 0.0f, 0.0f, 3.0f, 1.0f, 2.0f, 0.0f, false)
        cube_r17 = ModelRenderer(this)
        cube_r17.setRotationPoint(-3.366f, -17.9019f, -19.0f)
        bone.addChild(cube_r17)
        setRotationAngle(cube_r17, 0.0f, 0.0f, 1.0472f)
        cube_r17.setTextureOffset(60, 40).addBox(-1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 2.0f, 0.0f, false)
        gun_main = ModelRenderer(this)
        gun_main.setRotationPoint(0.0f, -2.0f, 8.0f)
        vertical_rot.addChild(gun_main)
        gun_main.setTextureOffset(0, 39).addBox(-2.5f, -2.0f, -13.0f, 5.0f, 5.0f, 9.0f, 0.0f, false)
        gun_main.setTextureOffset(59, 0).addBox(-2.5f, -2.0f, -4.0f, 5.0f, 3.0f, 2.0f, 0.0f, false)
        gun_main.setTextureOffset(60, 25).addBox(-4.5f, -1.0f, -13.0f, 2.0f, 1.0f, 2.0f, 0.0f, false)
        gun_main.setTextureOffset(28, 46).addBox(2.5f, -1.0f, -13.0f, 2.0f, 1.0f, 2.0f, 0.0f, false)
        gun_main.setTextureOffset(19, 39).addBox(-1.5f, -3.5f, -14.0f, 3.0f, 2.0f, 5.0f, 0.0f, false)
        cube_r18 = ModelRenderer(this)
        cube_r18.setRotationPoint(1.5f, -3.5f, -9.0f)
        gun_main.addChild(cube_r18)
        setRotationAngle(cube_r18, -0.3927f, 0.0f, 0.0f)
        cube_r18.setTextureOffset(48, 10).addBox(-3.0f, 0.0f, 0.0f, 3.0f, 2.0f, 4.0f, 0.0f, false)
        cube_r19 = ModelRenderer(this)
        cube_r19.setRotationPoint(0.0f, 1.0f, -3.4142f)
        gun_main.addChild(cube_r19)
        setRotationAngle(cube_r19, -0.7854f, 0.0f, 0.0f)
        cube_r19.setTextureOffset(14, 53).addBox(-2.5f, -1.0f, -1.0f, 5.0f, 3.0f, 2.0f, 0.0f, false)
        bone6 = ModelRenderer(this)
        bone6.setRotationPoint(0.0f, 1.0f, -2.0f)
        gun_main.addChild(bone6)
        bone9 = ModelRenderer(this)
        bone9.setRotationPoint(-2.5f, -3.0f, -12.0f)
        bone6.addChild(bone9)
        setRotationAngle(bone9, 0.0f, 0.3927f, 0.0f)
        bone9.setTextureOffset(0, 28).addBox(-4.0f, 0.0f, 0.0f, 4.0f, 5.0f, 1.0f, 0.0f, false)
        cube_r20 = ModelRenderer(this)
        cube_r20.setRotationPoint(-3.0f, 26.0f, 0.0f)
        bone9.addChild(cube_r20)
        setRotationAngle(cube_r20, 0.3927f, 0.0f, 0.0f)
        cube_r20.setTextureOffset(0, 34).addBox(-1.0f, -19.4015f, 8.0364f, 4.0f, 3.0f, 1.0f, 0.0f, false)
        cube_r21 = ModelRenderer(this)
        cube_r21.setRotationPoint(-3.0f, 0.0f, 0.0f)
        bone9.addChild(cube_r21)
        setRotationAngle(cube_r21, -0.3927f, 0.0f, 0.0f)
        cube_r21.setTextureOffset(30, 22).addBox(-1.0f, -4.0f, 0.0f, 4.0f, 4.0f, 1.0f, 0.0f, false)
        bone8 = ModelRenderer(this)
        bone8.setRotationPoint(2.5f, -3.0f, -12.0f)
        bone6.addChild(bone8)
        setRotationAngle(bone8, 0.0f, -0.3927f, 0.0f)
        bone8.setTextureOffset(0, 17).addBox(0.0f, 0.0f, 0.0f, 4.0f, 5.0f, 1.0f, 0.0f, false)
        cube_r22 = ModelRenderer(this)
        cube_r22.setRotationPoint(-6.9651f, 26.0f, 1.6756f)
        bone8.addChild(cube_r22)
        setRotationAngle(cube_r22, 0.3927f, 0.0f, 0.0f)
        cube_r22.setTextureOffset(0, 23).addBox(6.9651f, -20.0427f, 6.4883f, 4.0f, 3.0f, 1.0f, 0.0f, false)
        cube_r23 = ModelRenderer(this)
        cube_r23.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone8.addChild(cube_r23)
        setRotationAngle(cube_r23, -0.3927f, 0.0f, 0.0f)
        cube_r23.setTextureOffset(30, 17).addBox(0.0f, -4.0f, 0.0f, 4.0f, 4.0f, 1.0f, 0.0f, false)
        shaft = ModelRenderer(this)
        shaft.setRotationPoint(0.0f, -2.0f, 0.0f)
        horizontal_rot.addChild(shaft)
        shaft.setTextureOffset(0, 28).addBox(-5.0f, -2.0f, -5.0f, 10.0f, 1.0f, 10.0f, 0.0f, false)
        cube_r24 = ModelRenderer(this)
        cube_r24.setRotationPoint(0.0f, 0.2f, 0.0f)
        shaft.addChild(cube_r24)
        setRotationAngle(cube_r24, 0.0f, -0.3927f, 0.0f)
        cube_r24.setTextureOffset(0, 17).addBox(-5.0f, -2.0f, -5.0f, 10.0f, 1.0f, 10.0f, 0.0f, false)
        cube_r25 = ModelRenderer(this)
        cube_r25.setRotationPoint(0.0f, 0.2f, 0.0f)
        shaft.addChild(cube_r25)
        setRotationAngle(cube_r25, 0.0f, 0.3927f, 0.0f)
        cube_r25.setTextureOffset(30, 18).addBox(-5.0f, -2.0f, -5.0f, 10.0f, 1.0f, 10.0f, 0.0f, false)
        cube_r26 = ModelRenderer(this)
        cube_r26.setRotationPoint(0.0f, 0.1f, 0.0f)
        shaft.addChild(cube_r26)
        setRotationAngle(cube_r26, 0.0f, 0.7854f, 0.0f)
        cube_r26.setTextureOffset(30, 29).addBox(-5.0f, -2.0f, -5.0f, 10.0f, 1.0f, 10.0f, 0.0f, false)
        supporting = ModelRenderer(this)
        supporting.setRotationPoint(0.0f, 0.0f, 0.0f)
        horizontal_rot.addChild(supporting)
        supporting.setTextureOffset(28, 40).addBox(-3.0f, -5.0f, -4.0f, 6.0f, 1.0f, 9.0f, 0.0f, false)
        supporting.setTextureOffset(0, 54).addBox(-2.0f, -10.0f, -1.0f, 4.0f, 1.0f, 6.0f, 0.0f, false)
        cube_r27 = ModelRenderer(this)
        cube_r27.setRotationPoint(-2.0f, -6.0f, -2.0f)
        supporting.addChild(cube_r27)
        setRotationAngle(cube_r27, -0.3927f, 0.0f, 0.0f)
        cube_r27.setTextureOffset(34, 58).addBox(0.0f, -6.0f, 0.0f, 1.0f, 8.0f, 5.0f, 0.0f, false)
        cube_r27.setTextureOffset(0, 0).addBox(3.0f, -6.0f, 0.0f, 1.0f, 8.0f, 5.0f, 0.0f, false)
        cube_r28 = ModelRenderer(this)
        cube_r28.setRotationPoint(-1.0f, -5.0f, 3.5f)
        supporting.addChild(cube_r28)
        setRotationAngle(cube_r28, -0.7854f, 0.0f, 0.0f)
        cube_r28.setTextureOffset(46, 59).addBox(0.0f, -1.0f, -3.0f, 2.0f, 2.0f, 4.0f, 0.0f, false)
        bb_main = ModelRenderer(this)
        bb_main.setRotationPoint(0.0f, 24.0f, 0.0f)
        bb_main.setTextureOffset(0, 0).addBox(-8.0f, -1.0f, -8.0f, 16.0f, 1.0f, 16.0f, 0.0f, false)
    }
}
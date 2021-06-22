package com.github.malayP.decorations.block.machine.machine

import com.github.malayP.decorations.block.machine.engine.ACElectronicEngineTileEntityRender
import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.bedrockBreakerType
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
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.vector.Vector3f
import net.minecraft.world.IBlockReader


class BedrockBreaker : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = BedrockBreakerTileEntity()
}

class BedrockBreakerTileEntity : TileEntity(bedrockBreakerType.get()) {}
class BedrockBreakerTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    TileEntityRenderer<BedrockBreakerTileEntity>(dispatcher) {
    companion object {
        val model = BedrockBreakerModel()
        val texture: ResourceLocation = modResourcesLocation("textures/tile_entity/production/bedrock_breaker/bedrock_breaker.png")
    }

    override fun render(
        tileEntityIn: BedrockBreakerTileEntity,
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

class BedrockBreakerModel :Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val legs: ModelRenderer
    private val bone12: ModelRenderer
    private val cube_r1: ModelRenderer
    private val cube_r2: ModelRenderer
    private val cube_r3: ModelRenderer
    private val bone14: ModelRenderer
    private val cube_r4: ModelRenderer
    private val cube_r5: ModelRenderer
    private val cube_r6: ModelRenderer
    private val bone15: ModelRenderer
    private val cube_r7: ModelRenderer
    private val cube_r8: ModelRenderer
    private val cube_r9: ModelRenderer
    private val bone13: ModelRenderer
    private val cube_r10: ModelRenderer
    private val cube_r11: ModelRenderer
    private val cube_r12: ModelRenderer
    private val blade_base: ModelRenderer
    private val cube_r13: ModelRenderer
    private val cube_r14: ModelRenderer
    private val cube_r15: ModelRenderer
    private val bone: ModelRenderer
    private val cube_r16: ModelRenderer
    private val turbo_base: ModelRenderer
    private val cube_r17: ModelRenderer
    private val cube_r18: ModelRenderer
    private val cube_r19: ModelRenderer
    private val base: ModelRenderer
    private val lower: ModelRenderer
    private val bone4: ModelRenderer
    private val bone5: ModelRenderer
    private val bone6: ModelRenderer
    private val bone7: ModelRenderer
    private val rotatable: ModelRenderer
    private val shaft: ModelRenderer
    private val bone2: ModelRenderer
    private val turbo: ModelRenderer
    private val bone17: ModelRenderer
    private val bone3: ModelRenderer
    private val cube_r20: ModelRenderer
    private val cube_r21: ModelRenderer
    private val bone18: ModelRenderer
    private val cube_r22: ModelRenderer
    private val cube_r23: ModelRenderer
    private val bone30: ModelRenderer
    private val cube_r24: ModelRenderer
    private val cube_r25: ModelRenderer
    private val bone31: ModelRenderer
    private val cube_r26: ModelRenderer
    private val cube_r27: ModelRenderer
    private val bone32: ModelRenderer
    private val cube_r28: ModelRenderer
    private val cube_r29: ModelRenderer
    private val bone33: ModelRenderer
    private val cube_r30: ModelRenderer
    private val cube_r31: ModelRenderer
    private val turbo2: ModelRenderer
    private val bone8: ModelRenderer
    private val cube_r32: ModelRenderer
    private val cube_r33: ModelRenderer
    private val cube_r34: ModelRenderer
    private val cube_r35: ModelRenderer
    private val cube_r36: ModelRenderer
    private val cube_r37: ModelRenderer
    private val cube_r38: ModelRenderer
    private val cube_r39: ModelRenderer
    private val cube_r40: ModelRenderer
    private val cube_r41: ModelRenderer
    private val cube_r42: ModelRenderer
    private val cube_r43: ModelRenderer
    private val bladepart: ModelRenderer
    private val bone10: ModelRenderer
    private val cube_r44: ModelRenderer
    private val cube_r45: ModelRenderer
    private val cube_r46: ModelRenderer
    private val bone20: ModelRenderer
    private val bone16: ModelRenderer
    private val cube_r47: ModelRenderer
    private val bone19: ModelRenderer
    private val cube_r48: ModelRenderer
    private val bone21: ModelRenderer
    private val bone22: ModelRenderer
    private val cube_r49: ModelRenderer
    private val bone23: ModelRenderer
    private val cube_r50: ModelRenderer
    private val bone24: ModelRenderer
    private val bone25: ModelRenderer
    private val cube_r51: ModelRenderer
    private val bone26: ModelRenderer
    private val cube_r52: ModelRenderer
    private val bone27: ModelRenderer
    private val bone28: ModelRenderer
    private val cube_r53: ModelRenderer
    private val bone29: ModelRenderer
    private val cube_r54: ModelRenderer

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
        legs = ModelRenderer(this)
        legs.setRotationPoint(0.0f, 8.0f, -8.0f)
        fixed.addChild(legs)
        bone12 = ModelRenderer(this)
        bone12.setRotationPoint(3.5f, -17.0f, 4.0f)
        legs.addChild(bone12)
        cube_r1 = ModelRenderer(this)
        cube_r1.setRotationPoint(-3.5f, 9.0f, -0.5f)
        bone12.addChild(cube_r1)
        setRotationAngle(cube_r1, 0.0f, 0.0f, -0.7854f)
        cube_r1.setTextureOffset(56, 49).addBox(4.0f, -1.0f, -0.5f, 2.0f, 2.0f, 2.0f, 0.0f, true)
        cube_r1.setTextureOffset(19, 49).addBox(4.0f, -1.0f, 1.5f, 1.0f, 2.0f, 6.0f, 0.0f, true)
        cube_r1.setTextureOffset(56, 49).addBox(4.0f, -1.0f, 7.5f, 2.0f, 2.0f, 2.0f, 0.0f, true)
        cube_r2 = ModelRenderer(this)
        cube_r2.setRotationPoint(0.2426f, 5.2574f, 1.0f)
        bone12.addChild(cube_r2)
        setRotationAngle(cube_r2, 0.0f, 0.7854f, -0.7854f)
        cube_r2.setTextureOffset(46, 22).addBox(-1.5f, -0.9f, -0.5f, 2.0f, 2.0f, 1.0f, 0.0f, true)
        cube_r3 = ModelRenderer(this)
        cube_r3.setRotationPoint(0.2426f, 5.2574f, 7.0f)
        bone12.addChild(cube_r3)
        setRotationAngle(cube_r3, 0.0f, -0.7854f, -0.7854f)
        cube_r3.setTextureOffset(46, 22).addBox(-1.5f, -0.9f, -0.5f, 2.0f, 2.0f, 1.0f, 0.0f, true)
        bone14 = ModelRenderer(this)
        bone14.setRotationPoint(3.5f, -17.0f, 4.0f)
        legs.addChild(bone14)
        cube_r4 = ModelRenderer(this)
        cube_r4.setRotationPoint(-3.5f, 9.0f, -0.5f)
        bone14.addChild(cube_r4)
        setRotationAngle(cube_r4, 0.0f, 0.0f, 0.7854f)
        cube_r4.setTextureOffset(56, 49).addBox(4.0f, -1.0f, -0.5f, 2.0f, 2.0f, 2.0f, 0.0f, true)
        cube_r4.setTextureOffset(19, 49).addBox(4.0f, -1.0f, 1.5f, 1.0f, 2.0f, 6.0f, 0.0f, true)
        cube_r4.setTextureOffset(56, 49).addBox(4.0f, -1.0f, 7.5f, 2.0f, 2.0f, 2.0f, 0.0f, true)
        cube_r5 = ModelRenderer(this)
        cube_r5.setRotationPoint(0.2426f, 12.7426f, 1.0f)
        bone14.addChild(cube_r5)
        setRotationAngle(cube_r5, 0.0f, 0.7854f, 0.7854f)
        cube_r5.setTextureOffset(46, 22).addBox(-1.5f, -1.1f, -0.5f, 2.0f, 2.0f, 1.0f, 0.0f, true)
        cube_r6 = ModelRenderer(this)
        cube_r6.setRotationPoint(0.2426f, 12.7426f, 7.0f)
        bone14.addChild(cube_r6)
        setRotationAngle(cube_r6, 0.0f, -0.7854f, 0.7854f)
        cube_r6.setTextureOffset(46, 22).addBox(-1.5f, -1.1f, -0.5f, 2.0f, 2.0f, 1.0f, 0.0f, true)
        bone15 = ModelRenderer(this)
        bone15.setRotationPoint(-3.5f, -17.0f, 4.0f)
        legs.addChild(bone15)
        cube_r7 = ModelRenderer(this)
        cube_r7.setRotationPoint(3.5f, 9.0f, -0.5f)
        bone15.addChild(cube_r7)
        setRotationAngle(cube_r7, 0.0f, 0.0f, -0.7854f)
        cube_r7.setTextureOffset(56, 49).addBox(-6.0f, -1.0f, -0.5f, 2.0f, 2.0f, 2.0f, 0.0f, false)
        cube_r7.setTextureOffset(19, 49).addBox(-5.0f, -1.0f, 1.5f, 1.0f, 2.0f, 6.0f, 0.0f, false)
        cube_r7.setTextureOffset(56, 49).addBox(-6.0f, -1.0f, 7.5f, 2.0f, 2.0f, 2.0f, 0.0f, false)
        cube_r8 = ModelRenderer(this)
        cube_r8.setRotationPoint(-0.2426f, 12.7426f, 1.0f)
        bone15.addChild(cube_r8)
        setRotationAngle(cube_r8, 0.0f, -0.7854f, -0.7854f)
        cube_r8.setTextureOffset(46, 22).addBox(-0.5f, -1.1f, -0.5f, 2.0f, 2.0f, 1.0f, 0.0f, false)
        cube_r9 = ModelRenderer(this)
        cube_r9.setRotationPoint(-0.2426f, 12.7426f, 7.0f)
        bone15.addChild(cube_r9)
        setRotationAngle(cube_r9, 0.0f, 0.7854f, -0.7854f)
        cube_r9.setTextureOffset(46, 22).addBox(-0.5f, -1.1f, -0.5f, 2.0f, 2.0f, 1.0f, 0.0f, false)
        bone13 = ModelRenderer(this)
        bone13.setRotationPoint(-3.5f, -17.0f, 4.0f)
        legs.addChild(bone13)
        cube_r10 = ModelRenderer(this)
        cube_r10.setRotationPoint(3.5f, 9.0f, -0.5f)
        bone13.addChild(cube_r10)
        setRotationAngle(cube_r10, 0.0f, 0.0f, 0.7854f)
        cube_r10.setTextureOffset(56, 49).addBox(-6.0f, -1.0f, -0.5f, 2.0f, 2.0f, 2.0f, 0.0f, false)
        cube_r10.setTextureOffset(19, 49).addBox(-5.0f, -1.0f, 1.5f, 1.0f, 2.0f, 6.0f, 0.0f, false)
        cube_r10.setTextureOffset(56, 49).addBox(-6.0f, -1.0f, 7.5f, 2.0f, 2.0f, 2.0f, 0.0f, false)
        cube_r11 = ModelRenderer(this)
        cube_r11.setRotationPoint(-0.2426f, 5.2574f, 1.0f)
        bone13.addChild(cube_r11)
        setRotationAngle(cube_r11, 0.0f, -0.7854f, 0.7854f)
        cube_r11.setTextureOffset(46, 22).addBox(-0.5f, -0.9f, -0.5f, 2.0f, 2.0f, 1.0f, 0.0f, false)
        cube_r12 = ModelRenderer(this)
        cube_r12.setRotationPoint(-0.2426f, 5.2574f, 7.0f)
        bone13.addChild(cube_r12)
        setRotationAngle(cube_r12, 0.0f, 0.7854f, 0.7854f)
        cube_r12.setTextureOffset(46, 22).addBox(-0.5f, -0.9f, -0.5f, 2.0f, 2.0f, 1.0f, 0.0f, false)
        blade_base = ModelRenderer(this)
        blade_base.setRotationPoint(0.0f, 0.0f, 6.5f)
        fixed.addChild(blade_base)
        blade_base.setTextureOffset(31, 33).addBox(-6.0f, -3.0f, -1.6f, 12.0f, 6.0f, 2.0f, 0.0f, false)
        blade_base.setTextureOffset(0, 49).addBox(-4.0f, -4.0f, -11.5f, 8.0f, 8.0f, 1.0f, 0.0f, false)
        cube_r13 = ModelRenderer(this)
        cube_r13.setRotationPoint(0.0f, 0.0f, -1.0f)
        blade_base.addChild(cube_r13)
        setRotationAngle(cube_r13, 0.0f, 0.0f, 1.5708f)
        cube_r13.setTextureOffset(45, 49).addBox(-6.0f, -3.0f, -0.6f, 3.0f, 6.0f, 2.0f, 0.0f, false)
        cube_r13.setTextureOffset(45, 49).addBox(3.0f, -3.0f, -0.6f, 3.0f, 6.0f, 2.0f, 0.0f, false)
        cube_r14 = ModelRenderer(this)
        cube_r14.setRotationPoint(0.0f, 0.0f, -1.0f)
        blade_base.addChild(cube_r14)
        setRotationAngle(cube_r14, 0.0f, 0.0f, 0.7854f)
        cube_r14.setTextureOffset(31, 42).addBox(-6.364f, -2.1213f, -0.5f, 12.0f, 4.0f, 2.0f, 0.0f, true)
        cube_r14.setTextureOffset(46, 42).addBox(-0.636f, 6.3787f, -0.5f, 1.0f, 4.0f, 2.0f, 0.0f, false)
        cube_r15 = ModelRenderer(this)
        cube_r15.setRotationPoint(0.0f, 0.0f, -1.0f)
        blade_base.addChild(cube_r15)
        setRotationAngle(cube_r15, 0.0f, 0.0f, -0.7854f)
        cube_r15.setTextureOffset(42, 42).addBox(-0.636f, 6.3787f, -0.5f, 1.0f, 4.0f, 2.0f, 0.0f, false)
        cube_r15.setTextureOffset(31, 42).addBox(-6.364f, -2.1213f, -0.5f, 12.0f, 4.0f, 2.0f, 0.0f, false)
        bone = ModelRenderer(this)
        bone.setRotationPoint(0.0f, 0.0f, 0.5f)
        blade_base.addChild(bone)
        bone.setTextureOffset(49, 10).addBox(-2.0f, -6.25f, -1.75f, 4.0f, 1.0f, 2.0f, 0.0f, false)
        bone.setTextureOffset(49, 10).addBox(-2.0f, 5.25f, -1.75f, 4.0f, 1.0f, 2.0f, 0.0f, false)
        cube_r16 = ModelRenderer(this)
        cube_r16.setRotationPoint(0.0f, 0.0f, 0.25f)
        bone.addChild(cube_r16)
        setRotationAngle(cube_r16, 0.0f, 0.0f, 1.5708f)
        cube_r16.setTextureOffset(49, 10).addBox(-2.0f, 5.25f, -2.0f, 4.0f, 1.0f, 2.0f, 0.0f, false)
        cube_r16.setTextureOffset(49, 10).addBox(-2.0f, -6.25f, -2.0f, 4.0f, 1.0f, 2.0f, 0.0f, false)
        turbo_base = ModelRenderer(this)
        turbo_base.setRotationPoint(0.0f, 0.0f, 3.5f)
        fixed.addChild(turbo_base)
        turbo_base.setTextureOffset(0, 18).addBox(-2.0f, -5.0f, -1.6f, 4.0f, 10.0f, 1.0f, 0.0f, false)
        cube_r17 = ModelRenderer(this)
        cube_r17.setRotationPoint(0.0f, 0.0f, -1.0f)
        turbo_base.addChild(cube_r17)
        setRotationAngle(cube_r17, 0.0f, 0.0f, -0.7854f)
        cube_r17.setTextureOffset(34, 49).addBox(-2.1213f, -4.9497f, -0.5f, 4.0f, 9.0f, 1.0f, 0.0f, true)
        cube_r18 = ModelRenderer(this)
        cube_r18.setRotationPoint(-0.1213f, -0.0503f, -1.0f)
        turbo_base.addChild(cube_r18)
        setRotationAngle(cube_r18, 0.0f, 0.0f, 0.7854f)
        cube_r18.setTextureOffset(34, 49).addBox(-2.0f, -5.0f, -0.5f, 4.0f, 9.0f, 1.0f, 0.0f, false)
        cube_r19 = ModelRenderer(this)
        cube_r19.setRotationPoint(0.0f, 0.0f, -1.0f)
        turbo_base.addChild(cube_r19)
        setRotationAngle(cube_r19, 0.0f, 0.0f, 1.5708f)
        cube_r19.setTextureOffset(0, 18).addBox(-2.0f, -5.0f, -0.6f, 4.0f, 10.0f, 1.0f, 0.0f, false)
        base = ModelRenderer(this)
        base.setRotationPoint(0.0f, 8.0f, -6.0f)
        fixed.addChild(base)
        base.setTextureOffset(0, 33).addBox(-6.0f, -14.0f, -2.0f, 12.0f, 12.0f, 3.0f, 0.0f, false)
        base.setTextureOffset(0, 0).addBox(-1.0f, -4.0f, 7.0f, 2.0f, 3.0f, 5.0f, 0.0f, false)
        base.setTextureOffset(0, 0).addBox(-8.0f, -1.0f, -2.0f, 16.0f, 1.0f, 16.0f, 0.0f, false)
        base.setTextureOffset(0, 18).addBox(-8.0f, -2.0f, -2.0f, 16.0f, 1.0f, 13.0f, 0.0f, false)
        lower = ModelRenderer(this)
        lower.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(lower)
        bone4 = ModelRenderer(this)
        bone4.setRotationPoint(0.0f, 0.0f, 0.0f)
        lower.addChild(bone4)
        bone4.setTextureOffset(0, 59).addBox(3.0f, -3.0f, -4.0f, 1.0f, 6.0f, 9.0f, 0.0f, false)
        bone5 = ModelRenderer(this)
        bone5.setRotationPoint(0.0f, 0.0f, 0.0f)
        lower.addChild(bone5)
        setRotationAngle(bone5, 0.0f, 0.0f, -1.5708f)
        bone5.setTextureOffset(0, 59).addBox(3.0f, -3.0f, -4.0f, 1.0f, 6.0f, 9.0f, 0.0f, false)
        bone6 = ModelRenderer(this)
        bone6.setRotationPoint(0.0f, 0.0f, 0.0f)
        lower.addChild(bone6)
        setRotationAngle(bone6, 0.0f, 0.0f, -3.1416f)
        bone6.setTextureOffset(0, 59).addBox(3.0f, -3.0f, -4.0f, 1.0f, 6.0f, 9.0f, 0.0f, false)
        bone7 = ModelRenderer(this)
        bone7.setRotationPoint(0.0f, 0.0f, 0.0f)
        lower.addChild(bone7)
        setRotationAngle(bone7, 0.0f, 0.0f, 1.5708f)
        bone7.setTextureOffset(0, 59).addBox(3.0f, -3.0f, -4.0f, 1.0f, 6.0f, 9.0f, 0.0f, false)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        shaft = ModelRenderer(this)
        shaft.setRotationPoint(0.0f, 1.0f, -8.5f)
        rotatable.addChild(shaft)
        shaft.setTextureOffset(46, 18).addBox(-1.0f, -2.0f, 0.0f, 2.0f, 2.0f, 1.0f, 0.0f, false)
        bone2 = ModelRenderer(this)
        bone2.setRotationPoint(0.0f, -1.0f, 0.5f)
        shaft.addChild(bone2)
        setRotationAngle(bone2, 0.0f, 0.0f, 0.7854f)
        bone2.setTextureOffset(46, 18).addBox(-1.0f, -1.0f, -0.5f, 2.0f, 2.0f, 1.0f, 0.0f, false)
        turbo = ModelRenderer(this)
        turbo.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(turbo)
        bone17 = ModelRenderer(this)
        bone17.setRotationPoint(0.0f, 0.0f, -1.0f)
        turbo.addChild(bone17)
        bone3 = ModelRenderer(this)
        bone3.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone17.addChild(bone3)
        cube_r20 = ModelRenderer(this)
        cube_r20.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone3.addChild(cube_r20)
        setRotationAngle(cube_r20, 0.0f, -0.3927f, 0.0f)
        cube_r20.setTextureOffset(46, 18).addBox(-0.5f, 1.5f, -4.0f, 1.0f, 1.0f, 8.0f, 0.0f, true)
        cube_r21 = ModelRenderer(this)
        cube_r21.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone3.addChild(cube_r21)
        setRotationAngle(cube_r21, 0.0f, 0.3927f, 0.0f)
        cube_r21.setTextureOffset(46, 18).addBox(-0.5f, -2.5f, -4.0f, 1.0f, 1.0f, 8.0f, 0.0f, false)
        bone18 = ModelRenderer(this)
        bone18.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone17.addChild(bone18)
        setRotationAngle(bone18, 0.0f, 0.0f, 0.5236f)
        cube_r22 = ModelRenderer(this)
        cube_r22.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone18.addChild(cube_r22)
        setRotationAngle(cube_r22, 0.0f, -0.3927f, 0.0f)
        cube_r22.setTextureOffset(46, 18).addBox(-0.5f, 1.5f, -4.0f, 1.0f, 1.0f, 8.0f, 0.0f, true)
        cube_r23 = ModelRenderer(this)
        cube_r23.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone18.addChild(cube_r23)
        setRotationAngle(cube_r23, 0.0f, 0.3927f, 0.0f)
        cube_r23.setTextureOffset(46, 18).addBox(-0.5f, -2.5f, -4.0f, 1.0f, 1.0f, 8.0f, 0.0f, false)
        bone30 = ModelRenderer(this)
        bone30.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone17.addChild(bone30)
        setRotationAngle(bone30, 0.0f, 0.0f, 1.0472f)
        cube_r24 = ModelRenderer(this)
        cube_r24.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone30.addChild(cube_r24)
        setRotationAngle(cube_r24, 0.0f, -0.3927f, 0.0f)
        cube_r24.setTextureOffset(46, 18).addBox(-0.5f, 1.5f, -4.0f, 1.0f, 1.0f, 8.0f, 0.0f, true)
        cube_r25 = ModelRenderer(this)
        cube_r25.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone30.addChild(cube_r25)
        setRotationAngle(cube_r25, 0.0f, 0.3927f, 0.0f)
        cube_r25.setTextureOffset(46, 18).addBox(-0.5f, -2.5f, -4.0f, 1.0f, 1.0f, 8.0f, 0.0f, false)
        bone31 = ModelRenderer(this)
        bone31.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone17.addChild(bone31)
        setRotationAngle(bone31, 0.0f, 0.0f, 1.5708f)
        cube_r26 = ModelRenderer(this)
        cube_r26.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone31.addChild(cube_r26)
        setRotationAngle(cube_r26, 0.0f, -0.3927f, 0.0f)
        cube_r26.setTextureOffset(46, 18).addBox(-0.5f, 1.5f, -4.0f, 1.0f, 1.0f, 8.0f, 0.0f, true)
        cube_r27 = ModelRenderer(this)
        cube_r27.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone31.addChild(cube_r27)
        setRotationAngle(cube_r27, 0.0f, 0.3927f, 0.0f)
        cube_r27.setTextureOffset(46, 18).addBox(-0.5f, -2.5f, -4.0f, 1.0f, 1.0f, 8.0f, 0.0f, false)
        bone32 = ModelRenderer(this)
        bone32.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone17.addChild(bone32)
        setRotationAngle(bone32, 0.0f, 0.0f, 2.0944f)
        cube_r28 = ModelRenderer(this)
        cube_r28.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone32.addChild(cube_r28)
        setRotationAngle(cube_r28, 0.0f, -0.3927f, 0.0f)
        cube_r28.setTextureOffset(46, 18).addBox(-0.5f, 1.5f, -4.0f, 1.0f, 1.0f, 8.0f, 0.0f, true)
        cube_r29 = ModelRenderer(this)
        cube_r29.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone32.addChild(cube_r29)
        setRotationAngle(cube_r29, 0.0f, 0.3927f, 0.0f)
        cube_r29.setTextureOffset(46, 18).addBox(-0.5f, -2.5f, -4.0f, 1.0f, 1.0f, 8.0f, 0.0f, false)
        bone33 = ModelRenderer(this)
        bone33.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone17.addChild(bone33)
        setRotationAngle(bone33, 0.0f, 0.0f, 2.618f)
        cube_r30 = ModelRenderer(this)
        cube_r30.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone33.addChild(cube_r30)
        setRotationAngle(cube_r30, 0.0f, -0.3927f, 0.0f)
        cube_r30.setTextureOffset(46, 18).addBox(-0.5f, 1.5f, -4.0f, 1.0f, 1.0f, 8.0f, 0.0f, true)
        cube_r31 = ModelRenderer(this)
        cube_r31.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone33.addChild(cube_r31)
        setRotationAngle(cube_r31, 0.0f, 0.3927f, 0.0f)
        cube_r31.setTextureOffset(46, 18).addBox(-0.5f, -2.5f, -4.0f, 1.0f, 1.0f, 8.0f, 0.0f, false)
        turbo2 = ModelRenderer(this)
        turbo2.setRotationPoint(0.0f, -11.0f, 4.5f)
        rotatable.addChild(turbo2)
        bone8 = ModelRenderer(this)
        bone8.setRotationPoint(0.0f, 11.0f, -1.25f)
        turbo2.addChild(bone8)
        cube_r32 = ModelRenderer(this)
        cube_r32.setRotationPoint(0.1768f, 0.0f, 1.0f)
        bone8.addChild(cube_r32)
        setRotationAngle(cube_r32, 0.7854f, 0.0f, -2.0944f)
        cube_r32.setTextureOffset(52, 54).addBox(-3.0f, -0.625f, -2.125f, 1.0f, 1.0f, 4.0f, 0.0f, false)
        cube_r33 = ModelRenderer(this)
        cube_r33.setRotationPoint(0.1768f, 0.0f, 1.0f)
        bone8.addChild(cube_r33)
        setRotationAngle(cube_r33, 0.7854f, 0.0f, -2.618f)
        cube_r33.setTextureOffset(52, 54).addBox(-3.0f, -0.625f, -2.125f, 1.0f, 1.0f, 4.0f, 0.0f, false)
        cube_r34 = ModelRenderer(this)
        cube_r34.setRotationPoint(-0.8232f, 0.0f, 1.0f)
        bone8.addChild(cube_r34)
        setRotationAngle(cube_r34, 0.7854f, 0.0f, -3.1416f)
        cube_r34.setTextureOffset(52, 54).addBox(-4.0f, -0.625f, -2.125f, 1.0f, 1.0f, 4.0f, 0.0f, false)
        cube_r35 = ModelRenderer(this)
        cube_r35.setRotationPoint(0.1768f, 0.0f, 1.0f)
        bone8.addChild(cube_r35)
        setRotationAngle(cube_r35, 0.7854f, 0.0f, 2.618f)
        cube_r35.setTextureOffset(52, 54).addBox(-3.0f, -0.625f, -2.125f, 1.0f, 1.0f, 4.0f, 0.0f, false)
        cube_r36 = ModelRenderer(this)
        cube_r36.setRotationPoint(0.1768f, 0.0f, 1.0f)
        bone8.addChild(cube_r36)
        setRotationAngle(cube_r36, 0.7854f, 0.0f, 2.0944f)
        cube_r36.setTextureOffset(52, 54).addBox(-3.0f, -0.625f, -2.125f, 1.0f, 1.0f, 4.0f, 0.0f, false)
        cube_r37 = ModelRenderer(this)
        cube_r37.setRotationPoint(0.0f, 0.0f, 1.0f)
        bone8.addChild(cube_r37)
        setRotationAngle(cube_r37, 0.7854f, 0.0f, 1.5708f)
        cube_r37.setTextureOffset(52, 54).addBox(-3.0f, -0.75f, -2.0f, 1.0f, 1.0f, 4.0f, 0.0f, false)
        cube_r38 = ModelRenderer(this)
        cube_r38.setRotationPoint(0.1768f, 0.0f, 1.0f)
        bone8.addChild(cube_r38)
        setRotationAngle(cube_r38, -0.7854f, 0.0f, -2.0944f)
        cube_r38.setTextureOffset(52, 54).addBox(2.0f, -0.625f, -1.875f, 1.0f, 1.0f, 4.0f, 0.0f, true)
        cube_r39 = ModelRenderer(this)
        cube_r39.setRotationPoint(0.1768f, 0.0f, 1.0f)
        bone8.addChild(cube_r39)
        setRotationAngle(cube_r39, -0.7854f, 0.0f, -2.618f)
        cube_r39.setTextureOffset(52, 54).addBox(2.0f, -0.625f, -1.875f, 1.0f, 1.0f, 4.0f, 0.0f, true)
        cube_r40 = ModelRenderer(this)
        cube_r40.setRotationPoint(0.1768f, 0.0f, 1.0f)
        bone8.addChild(cube_r40)
        setRotationAngle(cube_r40, -0.7854f, 0.0f, -3.1416f)
        cube_r40.setTextureOffset(52, 54).addBox(2.0f, -0.625f, -1.875f, 1.0f, 1.0f, 4.0f, 0.0f, true)
        cube_r41 = ModelRenderer(this)
        cube_r41.setRotationPoint(0.1768f, 0.0f, 1.0f)
        bone8.addChild(cube_r41)
        setRotationAngle(cube_r41, -0.7854f, 0.0f, 2.618f)
        cube_r41.setTextureOffset(52, 54).addBox(2.0f, -0.625f, -1.875f, 1.0f, 1.0f, 4.0f, 0.0f, true)
        cube_r42 = ModelRenderer(this)
        cube_r42.setRotationPoint(0.1768f, 0.0f, 1.0f)
        bone8.addChild(cube_r42)
        setRotationAngle(cube_r42, -0.7854f, 0.0f, 2.0944f)
        cube_r42.setTextureOffset(52, 54).addBox(2.0f, -0.625f, -1.875f, 1.0f, 1.0f, 4.0f, 0.0f, true)
        cube_r43 = ModelRenderer(this)
        cube_r43.setRotationPoint(0.0f, 0.0f, 1.0f)
        bone8.addChild(cube_r43)
        setRotationAngle(cube_r43, -0.7854f, 0.0f, 1.5708f)
        cube_r43.setTextureOffset(52, 54).addBox(2.0f, -0.75f, -2.0f, 1.0f, 1.0f, 4.0f, 0.0f, true)
        bladepart = ModelRenderer(this)
        bladepart.setRotationPoint(0.0f, 0.0f, 7.0f)
        rotatable.addChild(bladepart)
        bone10 = ModelRenderer(this)
        bone10.setRotationPoint(0.0f, 0.0f, -0.5f)
        bladepart.addChild(bone10)
        bone10.setTextureOffset(49, 0).addBox(-5.0f, -2.0f, 0.55f, 10.0f, 4.0f, 0.0f, 0.0f, false)
        cube_r44 = ModelRenderer(this)
        cube_r44.setRotationPoint(0.0f, 0.0f, -1.0f)
        bone10.addChild(cube_r44)
        setRotationAngle(cube_r44, 0.0f, 0.0f, 1.5708f)
        cube_r44.setTextureOffset(0, 0).addBox(3.0f, -2.0f, 1.5f, 2.0f, 4.0f, 0.0f, 0.0f, false)
        cube_r44.setTextureOffset(0, 0).addBox(-5.0f, -2.0f, 1.55f, 2.0f, 4.0f, 0.0f, 0.0f, false)
        cube_r45 = ModelRenderer(this)
        cube_r45.setRotationPoint(0.0f, 0.0f, -0.95f)
        bone10.addChild(cube_r45)
        setRotationAngle(cube_r45, 0.0f, 0.0f, 0.7854f)
        cube_r45.setTextureOffset(49, 5).addBox(-4.9497f, -2.1213f, 1.5f, 9.0f, 4.0f, 0.0f, 0.0f, true)
        cube_r46 = ModelRenderer(this)
        cube_r46.setRotationPoint(0.0f, 0.0f, -0.95f)
        bone10.addChild(cube_r46)
        setRotationAngle(cube_r46, 0.0f, 0.0f, -0.7854f)
        cube_r46.setTextureOffset(49, 5).addBox(-4.9497f, -2.1213f, 1.5f, 9.0f, 4.0f, 0.0f, 0.0f, false)
        bone20 = ModelRenderer(this)
        bone20.setRotationPoint(0.0f, 0.0f, 2.0f)
        bladepart.addChild(bone20)
        bone16 = ModelRenderer(this)
        bone16.setRotationPoint(2.5f, -1.0f, -1.75f)
        bone20.addChild(bone16)
        setRotationAngle(bone16, 0.0f, -0.3927f, 0.0f)
        cube_r47 = ModelRenderer(this)
        cube_r47.setRotationPoint(0.0f, 0.5f, 0.5f)
        bone16.addChild(cube_r47)
        setRotationAngle(cube_r47, 0.7854f, 0.0f, 0.0f)
        cube_r47.setTextureOffset(0, 9).addBox(-2.8827f, -2.1533f, -2.1533f, 5.0f, 2.0f, 2.0f, 0.0f, false)
        bone19 = ModelRenderer(this)
        bone19.setRotationPoint(-2.5f, -16.5f, -1.25f)
        bone20.addChild(bone19)
        setRotationAngle(bone19, 0.0f, 0.3927f, 0.0f)
        cube_r48 = ModelRenderer(this)
        cube_r48.setRotationPoint(0.0f, 17.0f, 0.0f)
        bone19.addChild(cube_r48)
        setRotationAngle(cube_r48, -0.7854f, 0.0f, 0.0f)
        cube_r48.setTextureOffset(0, 9).addBox(-2.1173f, 0.1533f, -2.1533f, 5.0f, 2.0f, 2.0f, 0.0f, true)
        bone21 = ModelRenderer(this)
        bone21.setRotationPoint(0.0f, 0.0f, 2.0f)
        bladepart.addChild(bone21)
        setRotationAngle(bone21, 0.0f, 0.0f, -1.5708f)
        bone22 = ModelRenderer(this)
        bone22.setRotationPoint(2.5f, -1.0f, -1.75f)
        bone21.addChild(bone22)
        setRotationAngle(bone22, 0.0f, -0.3927f, 0.0f)
        cube_r49 = ModelRenderer(this)
        cube_r49.setRotationPoint(0.0f, 0.5f, 0.5f)
        bone22.addChild(cube_r49)
        setRotationAngle(cube_r49, 0.7854f, 0.0f, 0.0f)
        cube_r49.setTextureOffset(0, 9).addBox(-2.8827f, -2.1533f, -2.1533f, 5.0f, 2.0f, 2.0f, 0.0f, false)
        bone23 = ModelRenderer(this)
        bone23.setRotationPoint(-2.5f, -16.5f, -1.25f)
        bone21.addChild(bone23)
        setRotationAngle(bone23, 0.0f, 0.3927f, 0.0f)
        cube_r50 = ModelRenderer(this)
        cube_r50.setRotationPoint(0.0f, 17.0f, 0.0f)
        bone23.addChild(cube_r50)
        setRotationAngle(cube_r50, -0.7854f, 0.0f, 0.0f)
        cube_r50.setTextureOffset(0, 9).addBox(-2.1173f, 0.1533f, -2.1533f, 5.0f, 2.0f, 2.0f, 0.0f, true)
        bone24 = ModelRenderer(this)
        bone24.setRotationPoint(0.0f, 0.0f, 2.0f)
        bladepart.addChild(bone24)
        setRotationAngle(bone24, 0.0f, 0.0f, 2.3562f)
        bone25 = ModelRenderer(this)
        bone25.setRotationPoint(2.5f, -1.0f, -1.75f)
        bone24.addChild(bone25)
        setRotationAngle(bone25, 0.0f, -0.3927f, 0.0f)
        cube_r51 = ModelRenderer(this)
        cube_r51.setRotationPoint(0.0f, 0.5f, 0.5f)
        bone25.addChild(cube_r51)
        setRotationAngle(cube_r51, 0.7854f, 0.0f, 0.0f)
        cube_r51.setTextureOffset(0, 9).addBox(-2.8827f, -2.1533f, -2.1533f, 5.0f, 2.0f, 2.0f, 0.0f, false)
        bone26 = ModelRenderer(this)
        bone26.setRotationPoint(-2.5f, -16.5f, -1.25f)
        bone24.addChild(bone26)
        setRotationAngle(bone26, 0.0f, 0.3927f, 0.0f)
        cube_r52 = ModelRenderer(this)
        cube_r52.setRotationPoint(0.0f, 17.0f, 0.0f)
        bone26.addChild(cube_r52)
        setRotationAngle(cube_r52, -0.7854f, 0.0f, 0.0f)
        cube_r52.setTextureOffset(0, 9).addBox(-2.1173f, 0.1533f, -2.1533f, 5.0f, 2.0f, 2.0f, 0.0f, true)
        bone27 = ModelRenderer(this)
        bone27.setRotationPoint(0.0f, 0.0f, 2.0f)
        bladepart.addChild(bone27)
        setRotationAngle(bone27, 0.0f, 0.0f, 0.7854f)
        bone28 = ModelRenderer(this)
        bone28.setRotationPoint(2.5f, -1.0f, -1.75f)
        bone27.addChild(bone28)
        setRotationAngle(bone28, 0.0f, -0.3927f, 0.0f)
        cube_r53 = ModelRenderer(this)
        cube_r53.setRotationPoint(0.0f, 0.5f, 0.5f)
        bone28.addChild(cube_r53)
        setRotationAngle(cube_r53, 0.7854f, 0.0f, 0.0f)
        cube_r53.setTextureOffset(0, 9).addBox(-2.8827f, -2.1533f, -2.1533f, 5.0f, 2.0f, 2.0f, 0.0f, false)
        bone29 = ModelRenderer(this)
        bone29.setRotationPoint(-2.5f, -16.5f, -1.25f)
        bone27.addChild(bone29)
        setRotationAngle(bone29, 0.0f, 0.3927f, 0.0f)
        cube_r54 = ModelRenderer(this)
        cube_r54.setRotationPoint(0.0f, 17.0f, 0.0f)
        bone29.addChild(cube_r54)
        setRotationAngle(cube_r54, -0.7854f, 0.0f, 0.0f)
        cube_r54.setTextureOffset(0, 9).addBox(-2.1173f, 0.1533f, -2.1533f, 5.0f, 2.0f, 2.0f, 0.0f, true)
    }
}
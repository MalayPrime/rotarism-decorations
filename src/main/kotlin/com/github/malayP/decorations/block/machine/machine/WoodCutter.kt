package com.github.malayP.decorations.block.machine.machine

import com.github.malayP.decorations.block.machine.engine.ACElectronicEngineTileEntityRender
import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.woodCutterType
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


class WoodCutter : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = WoodCutterTileEntity()
}

class WoodCutterTileEntity : TileEntity(woodCutterType.get()) {}
class WoodCutterTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    TileEntityRenderer<WoodCutterTileEntity>(dispatcher) {
    companion object {
        val model = WoodCutterModel()
        val texture: ResourceLocation= modResourcesLocation("textures/tile_entity/farming/woodcutter/woodcutter.png")
    }

    override fun render(
        tileEntityIn: WoodCutterTileEntity,
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

class WoodCutterModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val base: ModelRenderer
    private val bone2: ModelRenderer
    private val bone11: ModelRenderer
    private val bone: ModelRenderer
    private val rotatable: ModelRenderer
    private val X: ModelRenderer
    private val rot: ModelRenderer
    private val pos: ModelRenderer
    private val blade: ModelRenderer
    private val bone3: ModelRenderer
    private val bone4: ModelRenderer
    private val bone5: ModelRenderer
    private val bone6: ModelRenderer
    private val blade3: ModelRenderer
    private val bone12: ModelRenderer
    private val bone13: ModelRenderer
    private val bone14: ModelRenderer
    private val bone15: ModelRenderer
    private val blade4: ModelRenderer
    private val bone16: ModelRenderer
    private val bone17: ModelRenderer
    private val bone18: ModelRenderer
    private val bone19: ModelRenderer
    private val blade5: ModelRenderer
    private val bone20: ModelRenderer
    private val bone21: ModelRenderer
    private val bone22: ModelRenderer
    private val bone23: ModelRenderer
    private val blade6: ModelRenderer
    private val bone24: ModelRenderer
    private val bone25: ModelRenderer
    private val bone26: ModelRenderer
    private val bone27: ModelRenderer
    private val blade2: ModelRenderer
    private val bone44: ModelRenderer
    private val bone45: ModelRenderer
    private val bone46: ModelRenderer
    private val bone47: ModelRenderer
    private val bladesmall1: ModelRenderer
    private val bone7: ModelRenderer
    private val bone8: ModelRenderer
    private val bone9: ModelRenderer
    private val bone10: ModelRenderer
    private val bladesmall2: ModelRenderer
    private val bone28: ModelRenderer
    private val bone29: ModelRenderer
    private val bone30: ModelRenderer
    private val bone31: ModelRenderer
    private val bladesmall3: ModelRenderer
    private val bone32: ModelRenderer
    private val bone33: ModelRenderer
    private val bone34: ModelRenderer
    private val bone35: ModelRenderer
    private val bladesmall4: ModelRenderer
    private val bone36: ModelRenderer
    private val bone37: ModelRenderer
    private val bone38: ModelRenderer
    private val bone39: ModelRenderer
    private val bladesmall5: ModelRenderer
    private val bone40: ModelRenderer
    private val bone41: ModelRenderer
    private val bone42: ModelRenderer
    private val bone43: ModelRenderer
    private val Z: ModelRenderer
    private val bone48: ModelRenderer
    private val bone49: ModelRenderer

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
        base = ModelRenderer(this)
        base.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(base)
        base.setTextureOffset(0, 0).addBox(-8.0f, 6.0f, -8.0f, 16.0f, 2.0f, 16.0f, 0.0f, false)
        base.setTextureOffset(72, 49).addBox(-8.0f, -6.0f, -8.0f, 2.0f, 3.0f, 9.0f, 0.0f, false)
        base.setTextureOffset(9, 0).addBox(-8.0f, -3.0f, -8.0f, 2.0f, 3.0f, 1.0f, 0.0f, false)
        base.setTextureOffset(38, 70).addBox(6.0f, -6.0f, -8.0f, 2.0f, 3.0f, 9.0f, 0.0f, false)
        base.setTextureOffset(0, 10).addBox(6.0f, -3.0f, -8.0f, 2.0f, 3.0f, 1.0f, 0.0f, false)
        base.setTextureOffset(0, 61).addBox(-8.0f, -8.0f, 1.0f, 2.0f, 14.0f, 7.0f, 0.0f, false)
        base.setTextureOffset(19, 61).addBox(6.0f, -8.0f, 1.0f, 2.0f, 14.0f, 7.0f, 0.0f, false)
        base.setTextureOffset(49, 0).addBox(-6.0f, -8.0f, 7.0f, 12.0f, 14.0f, 1.0f, 0.0f, false)
        base.setTextureOffset(70, 7).addBox(-8.0f, 0.0f, -8.0f, 2.0f, 6.0f, 9.0f, 0.0f, false)
        base.setTextureOffset(15, 40).addBox(-7.5f, -3.0f, -7.0f, 1.0f, 3.0f, 8.0f, 0.0f, false)
        base.setTextureOffset(15, 19).addBox(6.5f, -3.0f, -7.0f, 1.0f, 3.0f, 8.0f, 0.0f, false)
        base.setTextureOffset(58, 61).addBox(6.0f, 0.0f, -8.0f, 2.0f, 6.0f, 9.0f, 0.0f, false)
        base.setTextureOffset(61, 77).addBox(-7.5f, 4.9853f, -12.9289f, 1.0f, 3.0f, 5.0f, 0.0f, false)
        base.setTextureOffset(61, 77).addBox(6.5f, 4.9853f, -12.9289f, 1.0f, 3.0f, 5.0f, 0.0f, false)
        bone2 = ModelRenderer(this)
        bone2.setRotationPoint(0.0f, -2.0f, 5.0f)
        base.addChild(bone2)
        setRotationAngle(bone2, 0.3927f, 0.0f, 0.0f)
        bone2.setTextureOffset(42, 19).addBox(-7.5f, -7.074f, -7.3994f, 1.0f, 3.0f, 6.0f, 0.0f, false)
        bone2.setTextureOffset(0, 0).addBox(6.5f, -7.0701f, -7.3994f, 1.0f, 3.0f, 6.0f, 0.0f, false)
        bone11 = ModelRenderer(this)
        bone11.setRotationPoint(0.0f, 0.0f, 0.0f)
        base.addChild(bone11)
        setRotationAngle(bone11, 0.7854f, 0.0f, 0.0f)
        bone11.setTextureOffset(74, 70).addBox(-7.4f, -5.0375f, -13.2017f, 1.0f, 3.0f, 7.0f, 0.0f, false)
        bone11.setTextureOffset(74, 70).addBox(6.4f, -5.0375f, -13.2017f, 1.0f, 3.0f, 7.0f, 0.0f, false)
        bone = ModelRenderer(this)
        bone.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(bone)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, -1.5f, -0.5f)
        shell.addChild(rotatable)
        X = ModelRenderer(this)
        X.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(X)
        rot = ModelRenderer(this)
        rot.setRotationPoint(0.0f, 0.5f, 0.0f)
        X.addChild(rot)
        setRotationAngle(rot, -0.7854f, 0.0f, 0.0f)
        rot.setTextureOffset(70, 35).addBox(-7.0f, -1.3536f, -1.3536f, 14.0f, 2.0f, 2.0f, 0.0f, false)
        pos = ModelRenderer(this)
        pos.setRotationPoint(0.0f, 0.5f, 0.0f)
        X.addChild(pos)
        pos.setTextureOffset(70, 40).addBox(-7.0f, -1.5f, -1.0f, 14.0f, 2.0f, 2.0f, 0.0f, false)
        blade = ModelRenderer(this)
        blade.setRotationPoint(-0.5f, -0.5f, 0.0f)
        X.addChild(blade)
        bone3 = ModelRenderer(this)
        bone3.setRotationPoint(-8.0f, 0.0f, 0.0f)
        blade.addChild(bone3)
        bone3.setTextureOffset(27, 40).addBox(3.0f, -3.5f, -6.0f, 1.0f, 8.0f, 12.0f, 0.0f, false)
        bone4 = ModelRenderer(this)
        bone4.setRotationPoint(-8.0f, 0.0f, 0.0f)
        blade.addChild(bone4)
        setRotationAngle(bone4, 0.7854f, 0.0f, 0.0f)
        bone4.setTextureOffset(0, 40).addBox(3.0f, -3.6464f, -6.3536f, 1.0f, 8.0f, 12.0f, 0.0f, false)
        bone5 = ModelRenderer(this)
        bone5.setRotationPoint(-8.0f, 0.0f, 0.0f)
        blade.addChild(bone5)
        setRotationAngle(bone5, 1.5708f, 0.0f, 0.0f)
        bone5.setTextureOffset(27, 19).addBox(3.0f, -4.0f, -6.5f, 1.0f, 8.0f, 12.0f, 0.0f, false)
        bone6 = ModelRenderer(this)
        bone6.setRotationPoint(-8.0f, 0.0f, 0.0f)
        blade.addChild(bone6)
        setRotationAngle(bone6, 2.3562f, 0.0f, 0.0f)
        bone6.setTextureOffset(0, 19).addBox(3.0f, -4.3536f, -6.3536f, 1.0f, 8.0f, 12.0f, 0.0f, false)
        blade3 = ModelRenderer(this)
        blade3.setRotationPoint(1.5f, -0.5f, 0.0f)
        X.addChild(blade3)
        bone12 = ModelRenderer(this)
        bone12.setRotationPoint(-8.0f, 0.0f, 0.0f)
        blade3.addChild(bone12)
        bone12.setTextureOffset(27, 40).addBox(3.0f, -3.5f, -6.0f, 1.0f, 8.0f, 12.0f, 0.0f, false)
        bone13 = ModelRenderer(this)
        bone13.setRotationPoint(-8.0f, 0.0f, 0.0f)
        blade3.addChild(bone13)
        setRotationAngle(bone13, 0.7854f, 0.0f, 0.0f)
        bone13.setTextureOffset(0, 40).addBox(3.0f, -3.6464f, -6.3536f, 1.0f, 8.0f, 12.0f, 0.0f, false)
        bone14 = ModelRenderer(this)
        bone14.setRotationPoint(-8.0f, 0.0f, 0.0f)
        blade3.addChild(bone14)
        setRotationAngle(bone14, 1.5708f, 0.0f, 0.0f)
        bone14.setTextureOffset(27, 19).addBox(3.0f, -4.0f, -6.5f, 1.0f, 8.0f, 12.0f, 0.0f, false)
        bone15 = ModelRenderer(this)
        bone15.setRotationPoint(-8.0f, 0.0f, 0.0f)
        blade3.addChild(bone15)
        setRotationAngle(bone15, 2.3562f, 0.0f, 0.0f)
        bone15.setTextureOffset(0, 19).addBox(3.0f, -4.3536f, -6.3536f, 1.0f, 8.0f, 12.0f, 0.0f, false)
        blade4 = ModelRenderer(this)
        blade4.setRotationPoint(3.5f, -0.5f, 0.0f)
        X.addChild(blade4)
        bone16 = ModelRenderer(this)
        bone16.setRotationPoint(-8.0f, 0.0f, 0.0f)
        blade4.addChild(bone16)
        bone16.setTextureOffset(27, 40).addBox(3.0f, -3.5f, -6.0f, 1.0f, 8.0f, 12.0f, 0.0f, false)
        bone17 = ModelRenderer(this)
        bone17.setRotationPoint(-8.0f, 0.0f, 0.0f)
        blade4.addChild(bone17)
        setRotationAngle(bone17, 0.7854f, 0.0f, 0.0f)
        bone17.setTextureOffset(0, 40).addBox(3.0f, -3.6464f, -6.3536f, 1.0f, 8.0f, 12.0f, 0.0f, false)
        bone18 = ModelRenderer(this)
        bone18.setRotationPoint(-8.0f, 0.0f, 0.0f)
        blade4.addChild(bone18)
        setRotationAngle(bone18, 1.5708f, 0.0f, 0.0f)
        bone18.setTextureOffset(27, 19).addBox(3.0f, -4.0f, -6.5f, 1.0f, 8.0f, 12.0f, 0.0f, false)
        bone19 = ModelRenderer(this)
        bone19.setRotationPoint(-8.0f, 0.0f, 0.0f)
        blade4.addChild(bone19)
        setRotationAngle(bone19, 2.3562f, 0.0f, 0.0f)
        bone19.setTextureOffset(0, 19).addBox(3.0f, -4.3536f, -6.3536f, 1.0f, 8.0f, 12.0f, 0.0f, false)
        blade5 = ModelRenderer(this)
        blade5.setRotationPoint(5.5f, -0.5f, 0.0f)
        X.addChild(blade5)
        bone20 = ModelRenderer(this)
        bone20.setRotationPoint(-8.0f, 0.0f, 0.0f)
        blade5.addChild(bone20)
        bone20.setTextureOffset(27, 40).addBox(3.0f, -3.5f, -6.0f, 1.0f, 8.0f, 12.0f, 0.0f, false)
        bone21 = ModelRenderer(this)
        bone21.setRotationPoint(-8.0f, 0.0f, 0.0f)
        blade5.addChild(bone21)
        setRotationAngle(bone21, 0.7854f, 0.0f, 0.0f)
        bone21.setTextureOffset(0, 40).addBox(3.0f, -3.6464f, -6.3536f, 1.0f, 8.0f, 12.0f, 0.0f, false)
        bone22 = ModelRenderer(this)
        bone22.setRotationPoint(-8.0f, 0.0f, 0.0f)
        blade5.addChild(bone22)
        setRotationAngle(bone22, 1.5708f, 0.0f, 0.0f)
        bone22.setTextureOffset(27, 19).addBox(3.0f, -4.0f, -6.5f, 1.0f, 8.0f, 12.0f, 0.0f, false)
        bone23 = ModelRenderer(this)
        bone23.setRotationPoint(-8.0f, 0.0f, 0.0f)
        blade5.addChild(bone23)
        setRotationAngle(bone23, 2.3562f, 0.0f, 0.0f)
        bone23.setTextureOffset(0, 19).addBox(3.0f, -4.3536f, -6.3536f, 1.0f, 8.0f, 12.0f, 0.0f, false)
        blade6 = ModelRenderer(this)
        blade6.setRotationPoint(7.5f, -0.5f, 0.0f)
        X.addChild(blade6)
        bone24 = ModelRenderer(this)
        bone24.setRotationPoint(-8.0f, 0.0f, 0.0f)
        blade6.addChild(bone24)
        bone24.setTextureOffset(27, 40).addBox(3.0f, -3.5f, -6.0f, 1.0f, 8.0f, 12.0f, 0.0f, false)
        bone25 = ModelRenderer(this)
        bone25.setRotationPoint(-8.0f, 0.0f, 0.0f)
        blade6.addChild(bone25)
        setRotationAngle(bone25, 0.7854f, 0.0f, 0.0f)
        bone25.setTextureOffset(0, 40).addBox(3.0f, -3.6464f, -6.3536f, 1.0f, 8.0f, 12.0f, 0.0f, false)
        bone26 = ModelRenderer(this)
        bone26.setRotationPoint(-8.0f, 0.0f, 0.0f)
        blade6.addChild(bone26)
        setRotationAngle(bone26, 1.5708f, 0.0f, 0.0f)
        bone26.setTextureOffset(27, 19).addBox(3.0f, -4.0f, -6.5f, 1.0f, 8.0f, 12.0f, 0.0f, false)
        bone27 = ModelRenderer(this)
        bone27.setRotationPoint(-8.0f, 0.0f, 0.0f)
        blade6.addChild(bone27)
        setRotationAngle(bone27, 2.3562f, 0.0f, 0.0f)
        bone27.setTextureOffset(0, 19).addBox(3.0f, -4.3536f, -6.3536f, 1.0f, 8.0f, 12.0f, 0.0f, false)
        blade2 = ModelRenderer(this)
        blade2.setRotationPoint(9.5f, -0.5f, 0.0f)
        X.addChild(blade2)
        bone44 = ModelRenderer(this)
        bone44.setRotationPoint(-8.0f, 0.0f, 0.0f)
        blade2.addChild(bone44)
        bone44.setTextureOffset(27, 40).addBox(3.0f, -3.5f, -6.0f, 1.0f, 8.0f, 12.0f, 0.0f, false)
        bone45 = ModelRenderer(this)
        bone45.setRotationPoint(-8.0f, 0.0f, 0.0f)
        blade2.addChild(bone45)
        setRotationAngle(bone45, 0.7854f, 0.0f, 0.0f)
        bone45.setTextureOffset(0, 40).addBox(3.0f, -3.6464f, -6.3536f, 1.0f, 8.0f, 12.0f, 0.0f, false)
        bone46 = ModelRenderer(this)
        bone46.setRotationPoint(-8.0f, 0.0f, 0.0f)
        blade2.addChild(bone46)
        setRotationAngle(bone46, 1.5708f, 0.0f, 0.0f)
        bone46.setTextureOffset(27, 19).addBox(3.0f, -4.0f, -6.5f, 1.0f, 8.0f, 12.0f, 0.0f, false)
        bone47 = ModelRenderer(this)
        bone47.setRotationPoint(-8.0f, 0.0f, 0.0f)
        blade2.addChild(bone47)
        setRotationAngle(bone47, 2.3562f, 0.0f, 0.0f)
        bone47.setTextureOffset(0, 19).addBox(3.0f, -4.3536f, -6.3536f, 1.0f, 8.0f, 12.0f, 0.0f, false)
        bladesmall1 = ModelRenderer(this)
        bladesmall1.setRotationPoint(0.5f, -0.5f, 0.0f)
        X.addChild(bladesmall1)
        setRotationAngle(bladesmall1, -0.3927f, 0.0f, 0.0f)
        bone7 = ModelRenderer(this)
        bone7.setRotationPoint(-8.0f, 0.0f, 0.0f)
        bladesmall1.addChild(bone7)
        bone7.setTextureOffset(57, 39).addBox(3.0f, -3.5381f, -4.8087f, 1.0f, 8.0f, 10.0f, 0.0f, false)
        bone8 = ModelRenderer(this)
        bone8.setRotationPoint(-8.0f, 0.0f, 0.0f)
        bladesmall1.addChild(bone8)
        setRotationAngle(bone8, 0.7854f, 0.0f, 0.0f)
        bone8.setTextureOffset(57, 16).addBox(3.0f, -3.5381f, -5.1913f, 1.0f, 8.0f, 10.0f, 0.0f, false)
        bone9 = ModelRenderer(this)
        bone9.setRotationPoint(-8.0f, 0.0f, 0.0f)
        bladesmall1.addChild(bone9)
        setRotationAngle(bone9, 1.5708f, 0.0f, 0.0f)
        bone9.setTextureOffset(44, 51).addBox(3.0f, -3.8087f, -5.4619f, 1.0f, 8.0f, 10.0f, 0.0f, false)
        bone10 = ModelRenderer(this)
        bone10.setRotationPoint(-8.0f, 0.0f, 0.0f)
        bladesmall1.addChild(bone10)
        setRotationAngle(bone10, 2.3562f, 0.0f, 0.0f)
        bone10.setTextureOffset(44, 30).addBox(3.0f, -4.1913f, -5.4619f, 1.0f, 8.0f, 10.0f, 0.0f, false)
        bladesmall2 = ModelRenderer(this)
        bladesmall2.setRotationPoint(2.5f, -0.5f, 0.0f)
        X.addChild(bladesmall2)
        setRotationAngle(bladesmall2, -0.3927f, 0.0f, 0.0f)
        bone28 = ModelRenderer(this)
        bone28.setRotationPoint(-8.0f, 0.0f, 0.0f)
        bladesmall2.addChild(bone28)
        bone28.setTextureOffset(57, 39).addBox(3.0f, -3.5381f, -4.8087f, 1.0f, 8.0f, 10.0f, 0.0f, false)
        bone29 = ModelRenderer(this)
        bone29.setRotationPoint(-8.0f, 0.0f, 0.0f)
        bladesmall2.addChild(bone29)
        setRotationAngle(bone29, 0.7854f, 0.0f, 0.0f)
        bone29.setTextureOffset(57, 16).addBox(3.0f, -3.5381f, -5.1913f, 1.0f, 8.0f, 10.0f, 0.0f, false)
        bone30 = ModelRenderer(this)
        bone30.setRotationPoint(-8.0f, 0.0f, 0.0f)
        bladesmall2.addChild(bone30)
        setRotationAngle(bone30, 1.5708f, 0.0f, 0.0f)
        bone30.setTextureOffset(44, 51).addBox(3.0f, -3.8087f, -5.4619f, 1.0f, 8.0f, 10.0f, 0.0f, false)
        bone31 = ModelRenderer(this)
        bone31.setRotationPoint(-8.0f, 0.0f, 0.0f)
        bladesmall2.addChild(bone31)
        setRotationAngle(bone31, 2.3562f, 0.0f, 0.0f)
        bone31.setTextureOffset(44, 30).addBox(3.0f, -4.1913f, -5.4619f, 1.0f, 8.0f, 10.0f, 0.0f, false)
        bladesmall3 = ModelRenderer(this)
        bladesmall3.setRotationPoint(4.5f, -0.5f, 0.0f)
        X.addChild(bladesmall3)
        setRotationAngle(bladesmall3, -0.3927f, 0.0f, 0.0f)
        bone32 = ModelRenderer(this)
        bone32.setRotationPoint(-8.0f, 0.0f, 0.0f)
        bladesmall3.addChild(bone32)
        bone32.setTextureOffset(57, 39).addBox(3.0f, -3.5381f, -4.8087f, 1.0f, 8.0f, 10.0f, 0.0f, false)
        bone33 = ModelRenderer(this)
        bone33.setRotationPoint(-8.0f, 0.0f, 0.0f)
        bladesmall3.addChild(bone33)
        setRotationAngle(bone33, 0.7854f, 0.0f, 0.0f)
        bone33.setTextureOffset(57, 16).addBox(3.0f, -3.5381f, -5.1913f, 1.0f, 8.0f, 10.0f, 0.0f, false)
        bone34 = ModelRenderer(this)
        bone34.setRotationPoint(-8.0f, 0.0f, 0.0f)
        bladesmall3.addChild(bone34)
        setRotationAngle(bone34, 1.5708f, 0.0f, 0.0f)
        bone34.setTextureOffset(44, 51).addBox(3.0f, -3.8087f, -5.4619f, 1.0f, 8.0f, 10.0f, 0.0f, false)
        bone35 = ModelRenderer(this)
        bone35.setRotationPoint(-8.0f, 0.0f, 0.0f)
        bladesmall3.addChild(bone35)
        setRotationAngle(bone35, 2.3562f, 0.0f, 0.0f)
        bone35.setTextureOffset(44, 30).addBox(3.0f, -4.1913f, -5.4619f, 1.0f, 8.0f, 10.0f, 0.0f, false)
        bladesmall4 = ModelRenderer(this)
        bladesmall4.setRotationPoint(6.5f, -0.5f, 0.0f)
        X.addChild(bladesmall4)
        setRotationAngle(bladesmall4, -0.3927f, 0.0f, 0.0f)
        bone36 = ModelRenderer(this)
        bone36.setRotationPoint(-8.0f, 0.0f, 0.0f)
        bladesmall4.addChild(bone36)
        bone36.setTextureOffset(57, 39).addBox(3.0f, -3.5381f, -4.8087f, 1.0f, 8.0f, 10.0f, 0.0f, false)
        bone37 = ModelRenderer(this)
        bone37.setRotationPoint(-8.0f, 0.0f, 0.0f)
        bladesmall4.addChild(bone37)
        setRotationAngle(bone37, 0.7854f, 0.0f, 0.0f)
        bone37.setTextureOffset(57, 16).addBox(3.0f, -3.5381f, -5.1913f, 1.0f, 8.0f, 10.0f, 0.0f, false)
        bone38 = ModelRenderer(this)
        bone38.setRotationPoint(-8.0f, 0.0f, 0.0f)
        bladesmall4.addChild(bone38)
        setRotationAngle(bone38, 1.5708f, 0.0f, 0.0f)
        bone38.setTextureOffset(44, 51).addBox(3.0f, -3.8087f, -5.4619f, 1.0f, 8.0f, 10.0f, 0.0f, false)
        bone39 = ModelRenderer(this)
        bone39.setRotationPoint(-8.0f, 0.0f, 0.0f)
        bladesmall4.addChild(bone39)
        setRotationAngle(bone39, 2.3562f, 0.0f, 0.0f)
        bone39.setTextureOffset(44, 30).addBox(3.0f, -4.1913f, -5.4619f, 1.0f, 8.0f, 10.0f, 0.0f, false)
        bladesmall5 = ModelRenderer(this)
        bladesmall5.setRotationPoint(8.5f, -0.5f, 0.0f)
        X.addChild(bladesmall5)
        setRotationAngle(bladesmall5, -0.3927f, 0.0f, 0.0f)
        bone40 = ModelRenderer(this)
        bone40.setRotationPoint(-8.0f, 0.0f, 0.0f)
        bladesmall5.addChild(bone40)
        bone40.setTextureOffset(57, 39).addBox(3.0f, -3.5381f, -4.8087f, 1.0f, 8.0f, 10.0f, 0.0f, false)
        bone41 = ModelRenderer(this)
        bone41.setRotationPoint(-8.0f, 0.0f, 0.0f)
        bladesmall5.addChild(bone41)
        setRotationAngle(bone41, 0.7854f, 0.0f, 0.0f)
        bone41.setTextureOffset(57, 16).addBox(3.0f, -3.5381f, -5.1913f, 1.0f, 8.0f, 10.0f, 0.0f, false)
        bone42 = ModelRenderer(this)
        bone42.setRotationPoint(-8.0f, 0.0f, 0.0f)
        bladesmall5.addChild(bone42)
        setRotationAngle(bone42, 1.5708f, 0.0f, 0.0f)
        bone42.setTextureOffset(44, 51).addBox(3.0f, -3.8087f, -5.4619f, 1.0f, 8.0f, 10.0f, 0.0f, false)
        bone43 = ModelRenderer(this)
        bone43.setRotationPoint(-8.0f, 0.0f, 0.0f)
        bladesmall5.addChild(bone43)
        setRotationAngle(bone43, 2.3562f, 0.0f, 0.0f)
        bone43.setTextureOffset(44, 30).addBox(3.0f, -4.1913f, -5.4619f, 1.0f, 8.0f, 10.0f, 0.0f, false)
        Z = ModelRenderer(this)
        Z.setRotationPoint(0.0f, 0.5f, 0.0f)
        rotatable.addChild(Z)
        bone48 = ModelRenderer(this)
        bone48.setRotationPoint(0.0f, 0.0f, 0.0f)
        Z.addChild(bone48)
        bone48.setTextureOffset(0, 0).addBox(-1.0f, -1.0f, 8.0f, 2.0f, 2.0f, 1.0f, 0.0f, false)
        bone49 = ModelRenderer(this)
        bone49.setRotationPoint(0.0f, 0.0f, 0.0f)
        Z.addChild(bone49)
        setRotationAngle(bone49, 0.0f, 0.0f, 0.7854f)
        bone49.setTextureOffset(0, 0).addBox(-1.0f, -1.0f, 8.0f, 2.0f, 2.0f, 1.0f, 0.0f, false)
    }
}
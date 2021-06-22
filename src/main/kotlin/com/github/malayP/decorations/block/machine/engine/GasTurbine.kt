package com.github.malayP.decorations.block.machine.engine

import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.gasTurbineType
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


class GasTurbine : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = GasTurbineTileEntity()
}

class GasTurbineTileEntity : TileEntity(gasTurbineType.get())
class GasTurbineTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    TileEntityRenderer<GasTurbineTileEntity>(dispatcher) {
    companion object {
        val model = GasTurbineModel()
        val texture = modResourcesLocation("textures/tile_entity/engines/gas_turbine/gas_turbine.png")
    }

    override fun render(
        tileEntityIn: GasTurbineTileEntity,
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

class GasTurbineModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val pos: ModelRenderer
    private val rot: ModelRenderer
    private val dis1: ModelRenderer
    private val dis2: ModelRenderer
    private val dis3: ModelRenderer
    private val tube1: ModelRenderer
    private val bone: ModelRenderer
    private val bone2: ModelRenderer
    private val bone3: ModelRenderer
    private val bone4: ModelRenderer
    private val bone5: ModelRenderer
    private val bone6: ModelRenderer
    private val tube2: ModelRenderer
    private val bone7: ModelRenderer
    private val bone24: ModelRenderer
    private val bone8: ModelRenderer
    private val bone23: ModelRenderer
    private val bone9: ModelRenderer
    private val bone19: ModelRenderer
    private val bone10: ModelRenderer
    private val bone20: ModelRenderer
    private val bone11: ModelRenderer
    private val bone21: ModelRenderer
    private val bone12: ModelRenderer
    private val bone22: ModelRenderer
    private val tube3: ModelRenderer
    private val bone13: ModelRenderer
    private val bone14: ModelRenderer
    private val bone15: ModelRenderer
    private val bone16: ModelRenderer
    private val bone17: ModelRenderer
    private val bone18: ModelRenderer
    private val spt1: ModelRenderer
    private val spt2: ModelRenderer
    private val rotatable: ModelRenderer
    private val pos2: ModelRenderer
    private val rot2: ModelRenderer
    private val infan1: ModelRenderer
    private val blade1: ModelRenderer
    private val blade2: ModelRenderer
    private val blade3: ModelRenderer
    private val blade4: ModelRenderer
    private val blade5: ModelRenderer
    private val blade6: ModelRenderer
    private val blade7: ModelRenderer
    private val blade8: ModelRenderer
    private val infan2: ModelRenderer
    private val blade16: ModelRenderer
    private val blade18: ModelRenderer
    private val blade19: ModelRenderer
    private val blade20: ModelRenderer
    private val blade21: ModelRenderer
    private val blade22: ModelRenderer
    private val blade23: ModelRenderer
    private val blade24: ModelRenderer
    private val outfan1: ModelRenderer
    private val blade17: ModelRenderer
    private val blade9: ModelRenderer
    private val blade10: ModelRenderer
    private val blade11: ModelRenderer
    private val blade12: ModelRenderer
    private val blade13: ModelRenderer
    private val blade14: ModelRenderer
    private val blade15: ModelRenderer
    private val outfan2: ModelRenderer
    private val blade25: ModelRenderer
    private val blade26: ModelRenderer
    private val blade27: ModelRenderer
    private val blade28: ModelRenderer
    private val blade29: ModelRenderer
    private val blade30: ModelRenderer
    private val blade31: ModelRenderer
    private val blade32: ModelRenderer

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
        pos.setTextureOffset(0, 0).addBox(-8.0f, 6.0f, -8.0f, 16.0f, 2.0f, 16.0f, 0.0f, false)
        pos.setTextureOffset(39, 77).addBox(-7.0f, 3.0f, -3.95f, 3.0f, 3.0f, 3.0f, 0.0f, false)
        pos.setTextureOffset(26, 76).addBox(4.0f, 3.0f, -3.95f, 3.0f, 3.0f, 3.0f, 0.0f, false)
        pos.setTextureOffset(78, 22).addBox(4.75f, 2.0f, 5.0f, 3.0f, 4.0f, 2.0f, 0.0f, false)
        pos.setTextureOffset(77, 12).addBox(-7.75f, 2.0f, 5.0f, 3.0f, 4.0f, 2.0f, 0.0f, false)
        rot = ModelRenderer(this)
        rot.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(rot)
        dis1 = ModelRenderer(this)
        dis1.setRotationPoint(0.0f, 0.0f, 0.5f)
        rot.addChild(dis1)
        dis1.setTextureOffset(21, 21).addBox(-2.0f, -4.0f, 0.5f, 4.0f, 8.0f, 1.0f, 0.0f, false)
        dis2 = ModelRenderer(this)
        dis2.setRotationPoint(0.0f, 0.0f, 0.5f)
        rot.addChild(dis2)
        setRotationAngle(dis2, 0.0f, 0.0f, -1.0472f)
        dis2.setTextureOffset(0, 19).addBox(-2.0f, -4.0f, 0.49f, 4.0f, 8.0f, 1.0f, 0.0f, false)
        dis3 = ModelRenderer(this)
        dis3.setRotationPoint(0.0f, 0.0f, 0.5f)
        rot.addChild(dis3)
        setRotationAngle(dis3, 0.0f, 0.0f, -2.0944f)
        dis3.setTextureOffset(0, 0).addBox(-2.0f, -4.0f, 0.48f, 4.0f, 8.0f, 1.0f, 0.0f, false)
        tube1 = ModelRenderer(this)
        tube1.setRotationPoint(-1.0f, 2.65f, -12.0f)
        rot.addChild(tube1)
        bone = ModelRenderer(this)
        bone.setRotationPoint(0.0f, 0.0f, 0.0f)
        tube1.addChild(bone)
        bone.setTextureOffset(72, 6).addBox(-1.5f, 0.6699f, 3.95f, 5.0f, 1.0f, 4.0f, 0.0f, false)
        bone2 = ModelRenderer(this)
        bone2.setRotationPoint(0.0f, 0.0f, 0.0f)
        tube1.addChild(bone2)
        setRotationAngle(bone2, 0.0f, 0.0f, 1.0472f)
        bone2.setTextureOffset(40, 71).addBox(-4.3038f, 1.134f, 4.0f, 5.0f, 1.0f, 4.0f, 0.0f, false)
        bone3 = ModelRenderer(this)
        bone3.setRotationPoint(0.0f, 0.0f, 0.0f)
        tube1.addChild(bone3)
        setRotationAngle(bone3, 0.0f, 0.0f, 2.0944f)
        bone3.setTextureOffset(21, 70).addBox(-5.3038f, 3.7942f, 3.95f, 5.0f, 1.0f, 4.0f, 0.0f, false)
        bone4 = ModelRenderer(this)
        bone4.setRotationPoint(0.0f, 0.0f, 0.0f)
        tube1.addChild(bone4)
        setRotationAngle(bone4, 0.0f, 0.0f, -3.1416f)
        bone4.setTextureOffset(69, 54).addBox(-3.5f, 5.9904f, 4.0f, 5.0f, 1.0f, 4.0f, 0.0f, false)
        bone5 = ModelRenderer(this)
        bone5.setRotationPoint(0.0f, 0.0f, 0.0f)
        tube1.addChild(bone5)
        setRotationAngle(bone5, 0.0f, 0.0f, -2.0944f)
        bone5.setTextureOffset(69, 0).addBox(-0.6962f, 5.5263f, 3.95f, 5.0f, 1.0f, 4.0f, 0.0f, false)
        bone6 = ModelRenderer(this)
        bone6.setRotationPoint(0.0f, 0.0f, 0.0f)
        tube1.addChild(bone6)
        setRotationAngle(bone6, 0.0f, 0.0f, -1.0472f)
        bone6.setTextureOffset(49, 10).addBox(0.3038f, 2.866f, 4.0f, 5.0f, 1.0f, 4.0f, 0.0f, false)
        tube2 = ModelRenderer(this)
        tube2.setRotationPoint(0.0f, -0.8f, -5.0f)
        rot.addChild(tube2)
        bone7 = ModelRenderer(this)
        bone7.setRotationPoint(0.0f, 0.0f, 0.0f)
        tube2.addChild(bone7)
        bone7.setTextureOffset(49, 0).addBox(-3.0f, 4.0f, 1.01f, 6.0f, 2.0f, 7.0f, 0.0f, false)
        bone24 = ModelRenderer(this)
        bone24.setRotationPoint(0.0f, 0.8f, 5.0f)
        bone7.addChild(bone24)
        setRotationAngle(bone24, -0.3491f, 0.0f, 0.0f)
        bone24.setTextureOffset(62, 13).addBox(-2.0f, 3.2f, 0.01f, 4.0f, 2.0f, 6.0f, 0.0f, false)
        bone8 = ModelRenderer(this)
        bone8.setRotationPoint(0.0f, 0.0f, 0.0f)
        tube2.addChild(bone8)
        setRotationAngle(bone8, 0.0f, 0.0f, 1.0472f)
        bone8.setTextureOffset(0, 48).addBox(-2.3038f, 3.5981f, 1.0f, 6.0f, 2.0f, 7.0f, 0.0f, false)
        bone23 = ModelRenderer(this)
        bone23.setRotationPoint(0.0f, 0.8f, 5.0f)
        bone8.addChild(bone23)
        setRotationAngle(bone23, -0.3491f, 0.0f, 0.0f)
        bone23.setTextureOffset(63, 23).addBox(-1.3038f, 2.7981f, 0.0f, 4.0f, 2.0f, 6.0f, 0.0f, false)
        bone9 = ModelRenderer(this)
        bone9.setRotationPoint(0.0f, 0.0f, 0.0f)
        tube2.addChild(bone9)
        setRotationAngle(bone9, 0.0f, 0.0f, 2.0944f)
        bone9.setTextureOffset(40, 44).addBox(-2.3038f, 2.7942f, 1.01f, 6.0f, 2.0f, 7.0f, 0.0f, false)
        bone19 = ModelRenderer(this)
        bone19.setRotationPoint(0.0f, 0.8f, 5.0f)
        bone9.addChild(bone19)
        setRotationAngle(bone19, -0.3491f, 0.0f, 0.0f)
        bone19.setTextureOffset(48, 62).addBox(-1.3038f, 1.9942f, 0.01f, 4.0f, 2.0f, 6.0f, 0.0f, false)
        bone10 = ModelRenderer(this)
        bone10.setRotationPoint(0.0f, 0.0f, 0.0f)
        tube2.addChild(bone10)
        setRotationAngle(bone10, 0.0f, 0.0f, -3.1416f)
        bone10.setTextureOffset(42, 19).addBox(-3.0f, 2.3923f, 1.0f, 6.0f, 2.0f, 7.0f, 0.0f, false)
        bone20 = ModelRenderer(this)
        bone20.setRotationPoint(0.0f, 0.8f, 5.0f)
        bone10.addChild(bone20)
        setRotationAngle(bone20, -0.3491f, 0.0f, 0.0f)
        bone20.setTextureOffset(67, 45).addBox(-2.0f, 1.5923f, 0.0f, 4.0f, 2.0f, 6.0f, 0.0f, false)
        bone11 = ModelRenderer(this)
        bone11.setRotationPoint(0.0f, 0.0f, 0.0f)
        tube2.addChild(bone11)
        setRotationAngle(bone11, 0.0f, 0.0f, -2.0944f)
        bone11.setTextureOffset(20, 41).addBox(-3.6962f, 2.7942f, 1.01f, 6.0f, 2.0f, 7.0f, 0.0f, false)
        bone21 = ModelRenderer(this)
        bone21.setRotationPoint(0.0f, 0.8f, 5.0f)
        bone11.addChild(bone21)
        setRotationAngle(bone21, -0.3491f, 0.0f, 0.0f)
        bone21.setTextureOffset(0, 66).addBox(-2.6962f, 1.9942f, 0.01f, 4.0f, 2.0f, 6.0f, 0.0f, false)
        bone12 = ModelRenderer(this)
        bone12.setRotationPoint(0.0f, 0.0f, 0.0f)
        tube2.addChild(bone12)
        setRotationAngle(bone12, 0.0f, 0.0f, -1.0472f)
        bone12.setTextureOffset(0, 38).addBox(-3.6962f, 3.5981f, 1.0f, 6.0f, 2.0f, 7.0f, 0.0f, false)
        bone22 = ModelRenderer(this)
        bone22.setRotationPoint(0.0f, 0.8f, 5.0f)
        bone12.addChild(bone22)
        setRotationAngle(bone22, -0.3491f, 0.0f, 0.0f)
        bone22.setTextureOffset(63, 65).addBox(-2.6962f, 2.7981f, 0.0f, 4.0f, 2.0f, 6.0f, 0.0f, false)
        tube3 = ModelRenderer(this)
        tube3.setRotationPoint(0.0f, 0.05f, 0.0f)
        rot.addChild(tube3)
        bone13 = ModelRenderer(this)
        bone13.setRotationPoint(0.0f, 0.0f, 0.0f)
        tube3.addChild(bone13)
        bone13.setTextureOffset(21, 62).addBox(-3.5f, 5.0f, 2.05f, 7.0f, 1.0f, 6.0f, 0.0f, false)
        bone14 = ModelRenderer(this)
        bone14.setRotationPoint(0.0f, 0.0f, 0.0f)
        tube3.addChild(bone14)
        setRotationAngle(bone14, 0.0f, 0.0f, 1.0472f)
        bone14.setTextureOffset(60, 37).addBox(-3.5538f, 5.0311f, 2.0f, 7.0f, 1.0f, 6.0f, 0.0f, false)
        bone14.setTextureOffset(56, 74).addBox(-2.5538f, 6.0311f, 4.5f, 5.0f, 2.0f, 3.0f, 0.0f, false)
        bone15 = ModelRenderer(this)
        bone15.setRotationPoint(0.0f, 0.0f, 0.0f)
        tube3.addChild(bone15)
        setRotationAngle(bone15, 0.0f, 0.0f, 2.0944f)
        bone15.setTextureOffset(0, 58).addBox(-3.5538f, 5.0933f, 2.05f, 7.0f, 1.0f, 6.0f, 0.0f, false)
        bone16 = ModelRenderer(this)
        bone16.setRotationPoint(0.0f, 0.0f, 0.0f)
        tube3.addChild(bone16)
        setRotationAngle(bone16, 0.0f, 0.0f, -3.1416f)
        bone16.setTextureOffset(48, 54).addBox(-3.5f, 5.1244f, 2.0f, 7.0f, 1.0f, 6.0f, 0.0f, false)
        bone17 = ModelRenderer(this)
        bone17.setRotationPoint(0.0f, 0.0f, 0.0f)
        tube3.addChild(bone17)
        setRotationAngle(bone17, 0.0f, 0.0f, -2.0944f)
        bone17.setTextureOffset(21, 54).addBox(-3.4462f, 5.0933f, 2.05f, 7.0f, 1.0f, 6.0f, 0.0f, false)
        bone18 = ModelRenderer(this)
        bone18.setRotationPoint(0.0f, 0.0f, 0.0f)
        tube3.addChild(bone18)
        setRotationAngle(bone18, 0.0f, 0.0f, -1.0472f)
        bone18.setTextureOffset(42, 29).addBox(-3.4462f, 5.0311f, 2.0f, 7.0f, 1.0f, 6.0f, 0.0f, false)
        bone18.setTextureOffset(73, 74).addBox(-2.4462f, 5.7811f, 4.5f, 5.0f, 2.0f, 3.0f, 0.0f, false)
        spt1 = ModelRenderer(this)
        spt1.setRotationPoint(-5.5f, 4.5f, -2.5f)
        rot.addChild(spt1)
        setRotationAngle(spt1, 0.0f, 0.0f, 1.0472f)
        spt1.setTextureOffset(13, 76).addBox(-2.049f, -2.451f, -1.49f, 3.0f, 3.0f, 3.0f, 0.0f, false)
        spt2 = ModelRenderer(this)
        spt2.setRotationPoint(5.5f, 4.5f, -2.5f)
        rot.addChild(spt2)
        setRotationAngle(spt2, 0.0f, 0.0f, -1.0472f)
        spt2.setTextureOffset(0, 75).addBox(-0.951f, -2.451f, -1.49f, 3.0f, 3.0f, 3.0f, 0.0f, false)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        pos2 = ModelRenderer(this)
        pos2.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(pos2)
        pos2.setTextureOffset(21, 22).addBox(-1.0f, -1.0f, -8.5f, 2.0f, 2.0f, 16.0f, 0.0f, false)
        rot2 = ModelRenderer(this)
        rot2.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(rot2)
        setRotationAngle(rot2, 0.0f, 0.0f, 0.7854f)
        rot2.setTextureOffset(0, 19).addBox(-1.0f, -1.0f, -8.49f, 2.0f, 2.0f, 16.0f, 0.0f, false)
        infan1 = ModelRenderer(this)
        infan1.setRotationPoint(0.0f, 0.0f, 6.5f)
        rotatable.addChild(infan1)
        blade1 = ModelRenderer(this)
        blade1.setRotationPoint(0.0f, 0.0f, 0.0f)
        infan1.addChild(blade1)
        setRotationAngle(blade1, 0.0f, -0.7854f, 0.0f)
        blade1.setTextureOffset(11, 0).addBox(-0.5f, -5.0f, -0.5f, 1.0f, 10.0f, 1.0f, 0.0f, false)
        blade2 = ModelRenderer(this)
        blade2.setRotationPoint(0.0f, 0.0f, 0.0f)
        infan1.addChild(blade2)
        setRotationAngle(blade2, 0.0f, -0.7854f, -0.3927f)
        blade2.setTextureOffset(11, 0).addBox(-0.5f, -5.0f, -0.5f, 1.0f, 10.0f, 1.0f, 0.0f, false)
        blade3 = ModelRenderer(this)
        blade3.setRotationPoint(0.0f, 0.0f, 0.0f)
        infan1.addChild(blade3)
        setRotationAngle(blade3, 0.0f, -0.7854f, -0.7854f)
        blade3.setTextureOffset(11, 0).addBox(-0.5f, -5.0f, -0.5f, 1.0f, 10.0f, 1.0f, 0.0f, false)
        blade4 = ModelRenderer(this)
        blade4.setRotationPoint(0.0f, 0.0f, 0.0f)
        infan1.addChild(blade4)
        setRotationAngle(blade4, 0.0f, -0.7854f, -1.1781f)
        blade4.setTextureOffset(11, 0).addBox(-0.5f, -5.0f, -0.5f, 1.0f, 10.0f, 1.0f, 0.0f, false)
        blade5 = ModelRenderer(this)
        blade5.setRotationPoint(0.0f, 0.0f, 0.0f)
        infan1.addChild(blade5)
        setRotationAngle(blade5, 0.0f, -0.7854f, -1.5708f)
        blade5.setTextureOffset(11, 0).addBox(-0.5f, -5.0f, -0.5f, 1.0f, 10.0f, 1.0f, 0.0f, false)
        blade6 = ModelRenderer(this)
        blade6.setRotationPoint(0.0f, 0.0f, 0.0f)
        infan1.addChild(blade6)
        setRotationAngle(blade6, 0.0f, -0.7854f, -1.9635f)
        blade6.setTextureOffset(11, 0).addBox(-0.5f, -5.0f, -0.5f, 1.0f, 10.0f, 1.0f, 0.0f, false)
        blade7 = ModelRenderer(this)
        blade7.setRotationPoint(0.0f, 0.0f, 0.0f)
        infan1.addChild(blade7)
        setRotationAngle(blade7, 0.0f, -0.7854f, -2.3562f)
        blade7.setTextureOffset(11, 0).addBox(-0.5f, -5.0f, -0.5f, 1.0f, 10.0f, 1.0f, 0.0f, false)
        blade8 = ModelRenderer(this)
        blade8.setRotationPoint(0.0f, 0.0f, 0.0f)
        infan1.addChild(blade8)
        setRotationAngle(blade8, 0.0f, -0.7854f, -2.7489f)
        blade8.setTextureOffset(11, 0).addBox(-0.5f, -5.0f, -0.5f, 1.0f, 10.0f, 1.0f, 0.0f, false)
        infan2 = ModelRenderer(this)
        infan2.setRotationPoint(0.0f, 0.0f, 4.75f)
        rotatable.addChild(infan2)
        setRotationAngle(infan2, 0.0f, 0.0f, -0.2007f)
        blade16 = ModelRenderer(this)
        blade16.setRotationPoint(0.0f, 0.0f, 0.0f)
        infan2.addChild(blade16)
        setRotationAngle(blade16, 0.0f, -0.7854f, 0.0f)
        blade16.setTextureOffset(11, 0).addBox(-0.5f, -5.0f, -0.5f, 1.0f, 10.0f, 1.0f, 0.0f, false)
        blade18 = ModelRenderer(this)
        blade18.setRotationPoint(0.0f, 0.0f, 0.0f)
        infan2.addChild(blade18)
        setRotationAngle(blade18, 0.0f, -0.7854f, -0.3927f)
        blade18.setTextureOffset(11, 0).addBox(-0.5f, -5.0f, -0.5f, 1.0f, 10.0f, 1.0f, 0.0f, false)
        blade19 = ModelRenderer(this)
        blade19.setRotationPoint(0.0f, 0.0f, 0.0f)
        infan2.addChild(blade19)
        setRotationAngle(blade19, 0.0f, -0.7854f, -0.7854f)
        blade19.setTextureOffset(11, 0).addBox(-0.5f, -5.0f, -0.5f, 1.0f, 10.0f, 1.0f, 0.0f, false)
        blade20 = ModelRenderer(this)
        blade20.setRotationPoint(0.0f, 0.0f, 0.0f)
        infan2.addChild(blade20)
        setRotationAngle(blade20, 0.0f, -0.7854f, -1.1781f)
        blade20.setTextureOffset(11, 0).addBox(-0.5f, -5.0f, -0.5f, 1.0f, 10.0f, 1.0f, 0.0f, false)
        blade21 = ModelRenderer(this)
        blade21.setRotationPoint(0.0f, 0.0f, 0.0f)
        infan2.addChild(blade21)
        setRotationAngle(blade21, 0.0f, -0.7854f, -1.5708f)
        blade21.setTextureOffset(11, 0).addBox(-0.5f, -5.0f, -0.5f, 1.0f, 10.0f, 1.0f, 0.0f, false)
        blade22 = ModelRenderer(this)
        blade22.setRotationPoint(0.0f, 0.0f, 0.0f)
        infan2.addChild(blade22)
        setRotationAngle(blade22, 0.0f, -0.7854f, -1.9635f)
        blade22.setTextureOffset(11, 0).addBox(-0.5f, -5.0f, -0.5f, 1.0f, 10.0f, 1.0f, 0.0f, false)
        blade23 = ModelRenderer(this)
        blade23.setRotationPoint(0.0f, 0.0f, 0.0f)
        infan2.addChild(blade23)
        setRotationAngle(blade23, 0.0f, -0.7854f, -2.3562f)
        blade23.setTextureOffset(11, 0).addBox(-0.5f, -5.0f, -0.5f, 1.0f, 10.0f, 1.0f, 0.0f, false)
        blade24 = ModelRenderer(this)
        blade24.setRotationPoint(0.0f, 0.0f, 0.0f)
        infan2.addChild(blade24)
        setRotationAngle(blade24, 0.0f, -0.7854f, -2.7489f)
        blade24.setTextureOffset(11, 0).addBox(-0.5f, -5.0f, -0.5f, 1.0f, 10.0f, 1.0f, 0.0f, false)
        outfan1 = ModelRenderer(this)
        outfan1.setRotationPoint(0.0f, 0.0f, -7.0f)
        rotatable.addChild(outfan1)
        blade17 = ModelRenderer(this)
        blade17.setRotationPoint(0.0f, 0.0f, 0.0f)
        outfan1.addChild(blade17)
        setRotationAngle(blade17, 0.0f, -0.7854f, 0.0f)
        blade17.setTextureOffset(11, 19).addBox(-0.5f, -3.5f, -0.5f, 1.0f, 7.0f, 1.0f, -0.15f, false)
        blade9 = ModelRenderer(this)
        blade9.setRotationPoint(0.0f, 0.0f, 0.0f)
        outfan1.addChild(blade9)
        setRotationAngle(blade9, 0.0f, -0.7854f, 0.3927f)
        blade9.setTextureOffset(11, 19).addBox(-0.5f, -3.5f, -0.5f, 1.0f, 7.0f, 1.0f, -0.15f, false)
        blade10 = ModelRenderer(this)
        blade10.setRotationPoint(0.0f, 0.0f, 0.0f)
        outfan1.addChild(blade10)
        setRotationAngle(blade10, 0.0f, -0.7854f, 0.7854f)
        blade10.setTextureOffset(11, 19).addBox(-0.5f, -3.5f, -0.5f, 1.0f, 7.0f, 1.0f, -0.15f, false)
        blade11 = ModelRenderer(this)
        blade11.setRotationPoint(0.0f, 0.0f, 0.0f)
        outfan1.addChild(blade11)
        setRotationAngle(blade11, 0.0f, -0.7854f, 1.1781f)
        blade11.setTextureOffset(11, 19).addBox(-0.5f, -3.5f, -0.5f, 1.0f, 7.0f, 1.0f, -0.15f, false)
        blade12 = ModelRenderer(this)
        blade12.setRotationPoint(0.0f, 0.0f, 0.0f)
        outfan1.addChild(blade12)
        setRotationAngle(blade12, 0.0f, -0.7854f, 1.5708f)
        blade12.setTextureOffset(11, 19).addBox(-0.5f, -3.5f, -0.5f, 1.0f, 7.0f, 1.0f, -0.15f, false)
        blade13 = ModelRenderer(this)
        blade13.setRotationPoint(0.0f, 0.0f, 0.0f)
        outfan1.addChild(blade13)
        setRotationAngle(blade13, 0.0f, -0.7854f, 1.9635f)
        blade13.setTextureOffset(11, 19).addBox(-0.5f, -3.5f, -0.5f, 1.0f, 7.0f, 1.0f, -0.15f, false)
        blade14 = ModelRenderer(this)
        blade14.setRotationPoint(0.0f, 0.0f, 0.0f)
        outfan1.addChild(blade14)
        setRotationAngle(blade14, 0.0f, -0.7854f, 2.3562f)
        blade14.setTextureOffset(11, 19).addBox(-0.5f, -3.5f, -0.5f, 1.0f, 7.0f, 1.0f, -0.15f, false)
        blade15 = ModelRenderer(this)
        blade15.setRotationPoint(0.0f, 0.0f, 0.0f)
        outfan1.addChild(blade15)
        setRotationAngle(blade15, 0.0f, -0.7854f, 2.7489f)
        blade15.setTextureOffset(11, 19).addBox(-0.5f, -3.5f, -0.5f, 1.0f, 7.0f, 1.0f, -0.15f, false)
        outfan2 = ModelRenderer(this)
        outfan2.setRotationPoint(0.0f, 0.0f, -5.75f)
        rotatable.addChild(outfan2)
        setRotationAngle(outfan2, 0.0f, 0.0f, 0.2007f)
        blade25 = ModelRenderer(this)
        blade25.setRotationPoint(0.0f, 0.0f, 0.0f)
        outfan2.addChild(blade25)
        setRotationAngle(blade25, 0.0f, -0.7854f, 0.0f)
        blade25.setTextureOffset(11, 19).addBox(-0.5f, -3.5f, -0.5f, 1.0f, 7.0f, 1.0f, -0.15f, false)
        blade26 = ModelRenderer(this)
        blade26.setRotationPoint(0.0f, 0.0f, 0.0f)
        outfan2.addChild(blade26)
        setRotationAngle(blade26, 0.0f, -0.7854f, 0.3927f)
        blade26.setTextureOffset(11, 19).addBox(-0.5f, -3.5f, -0.5f, 1.0f, 7.0f, 1.0f, -0.15f, false)
        blade27 = ModelRenderer(this)
        blade27.setRotationPoint(0.0f, 0.0f, 0.0f)
        outfan2.addChild(blade27)
        setRotationAngle(blade27, 0.0f, -0.7854f, 0.7854f)
        blade27.setTextureOffset(11, 19).addBox(-0.5f, -3.5f, -0.5f, 1.0f, 7.0f, 1.0f, -0.15f, false)
        blade28 = ModelRenderer(this)
        blade28.setRotationPoint(0.0f, 0.0f, 0.0f)
        outfan2.addChild(blade28)
        setRotationAngle(blade28, 0.0f, -0.7854f, 1.1781f)
        blade28.setTextureOffset(11, 19).addBox(-0.5f, -3.5f, -0.5f, 1.0f, 7.0f, 1.0f, -0.15f, false)
        blade29 = ModelRenderer(this)
        blade29.setRotationPoint(0.0f, 0.0f, 0.0f)
        outfan2.addChild(blade29)
        setRotationAngle(blade29, 0.0f, -0.7854f, 1.5708f)
        blade29.setTextureOffset(11, 19).addBox(-0.5f, -3.5f, -0.5f, 1.0f, 7.0f, 1.0f, -0.15f, false)
        blade30 = ModelRenderer(this)
        blade30.setRotationPoint(0.0f, 0.0f, 0.0f)
        outfan2.addChild(blade30)
        setRotationAngle(blade30, 0.0f, -0.7854f, 1.9635f)
        blade30.setTextureOffset(11, 19).addBox(-0.5f, -3.5f, -0.5f, 1.0f, 7.0f, 1.0f, -0.15f, false)
        blade31 = ModelRenderer(this)
        blade31.setRotationPoint(0.0f, 0.0f, 0.0f)
        outfan2.addChild(blade31)
        setRotationAngle(blade31, 0.0f, -0.7854f, 2.3562f)
        blade31.setTextureOffset(11, 19).addBox(-0.5f, -3.5f, -0.5f, 1.0f, 7.0f, 1.0f, -0.15f, false)
        blade32 = ModelRenderer(this)
        blade32.setRotationPoint(0.0f, 0.0f, 0.0f)
        outfan2.addChild(blade32)
        setRotationAngle(blade32, 0.0f, -0.7854f, 2.7489f)
        blade32.setTextureOffset(11, 19).addBox(-0.5f, -3.5f, -0.5f, 1.0f, 7.0f, 1.0f, -0.15f, false)
    }
}
package com.github.malayP.decorations.block.machine.machine

import com.github.malayP.decorations.block.machine.engine.ACElectronicEngineTileEntityRender
import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.pumpType
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


class Pump : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = PumpTileEntity()
}

class PumpTileEntity : TileEntity(pumpType.get()) {}
class PumpTileEntityRender(dispatcher: TileEntityRendererDispatcher) : TileEntityRenderer<PumpTileEntity>(dispatcher) {
    companion object {
        val model = PumpModel()
        val texture: ResourceLocation= modResourcesLocation("textures/tile_entity/production/pump/pump.png")
    }

    override fun render(
        tileEntityIn: PumpTileEntity,
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

class PumpModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val base: ModelRenderer
    private val nail: ModelRenderer
    private val casting: ModelRenderer
    private val bone: ModelRenderer
    private val bone2: ModelRenderer
    private val bone3: ModelRenderer
    private val bone4: ModelRenderer
    private val bone5: ModelRenderer
    private val bone6: ModelRenderer
    private val bone7: ModelRenderer
    private val bone8: ModelRenderer
    private val casting2: ModelRenderer
    private val bone9: ModelRenderer
    private val bone10: ModelRenderer
    private val bone11: ModelRenderer
    private val bone12: ModelRenderer
    private val bone13: ModelRenderer
    private val bone14: ModelRenderer
    private val bone15: ModelRenderer
    private val bone16: ModelRenderer
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
        fixed = ModelRenderer(this)
        fixed.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(fixed)
        fixed.setTextureOffset(46, 59).addBox(-3.0f, 7.0f, -3.0f, 6.0f, 3.0f, 6.0f, 0.0f, false)
        fixed.setTextureOffset(0, 19).addBox(-5.0f, -8.0f, -5.0f, 10.0f, 1.0f, 10.0f, 0.0f, false)
        fixed.setTextureOffset(49, 0).addBox(-3.0f, -5.0f, 3.0f, 6.0f, 11.0f, 4.0f, 0.0f, false)
        base = ModelRenderer(this)
        base.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(base)
        base.setTextureOffset(0, 0).addBox(-8.0f, 6.0f, -8.0f, 16.0f, 2.0f, 16.0f, 0.0f, false)
        nail = ModelRenderer(this)
        nail.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(nail)
        nail.setTextureOffset(24, 78).addBox(5.0f, 4.0f, 5.0f, 2.0f, 5.0f, 2.0f, 0.0f, false)
        nail.setTextureOffset(24, 78).addBox(-7.0f, 4.0f, 5.0f, 2.0f, 5.0f, 2.0f, 0.0f, false)
        nail.setTextureOffset(24, 78).addBox(5.0f, 4.0f, -7.0f, 2.0f, 5.0f, 2.0f, 0.0f, false)
        nail.setTextureOffset(24, 78).addBox(-7.0f, 4.0f, -7.0f, 2.0f, 5.0f, 2.0f, 0.0f, false)
        nail.setTextureOffset(71, 18).addBox(4.5f, 3.0f, 4.5f, 3.0f, 1.0f, 3.0f, 0.0f, false)
        nail.setTextureOffset(71, 18).addBox(-7.5f, 3.0f, 4.5f, 3.0f, 1.0f, 3.0f, 0.0f, false)
        nail.setTextureOffset(71, 18).addBox(4.5f, 3.0f, -7.5f, 3.0f, 1.0f, 3.0f, 0.0f, false)
        nail.setTextureOffset(71, 18).addBox(-7.5f, 3.0f, -7.5f, 3.0f, 1.0f, 3.0f, 0.0f, false)
        casting = ModelRenderer(this)
        casting.setRotationPoint(0.0f, 0.0f, 1.025f)
        fixed.addChild(casting)
        bone = ModelRenderer(this)
        bone.setRotationPoint(0.0f, 0.0f, 0.0f)
        casting.addChild(bone)
        bone.setTextureOffset(71, 51).addBox(-2.5f, -6.0f, 3.0f, 5.0f, 10.0f, 2.0f, 0.0f, false)
        bone2 = ModelRenderer(this)
        bone2.setRotationPoint(0.0f, 0.0f, 0.0f)
        casting.addChild(bone2)
        setRotationAngle(bone2, 0.0f, -0.7854f, 0.0f)
        bone2.setTextureOffset(71, 38).addBox(-3.2322f, -6.0f, 3.3033f, 5.0f, 10.0f, 2.0f, 0.0f, false)
        bone3 = ModelRenderer(this)
        bone3.setRotationPoint(0.0f, 0.0f, 0.0f)
        casting.addChild(bone3)
        setRotationAngle(bone3, 0.0f, -1.5708f, 0.0f)
        bone3.setTextureOffset(70, 0).addBox(-3.5355f, -6.0f, 4.0355f, 5.0f, 10.0f, 2.0f, 0.0f, false)
        bone4 = ModelRenderer(this)
        bone4.setRotationPoint(0.0f, 0.0f, 0.0f)
        casting.addChild(bone4)
        setRotationAngle(bone4, 0.0f, -2.3562f, 0.0f)
        bone4.setTextureOffset(69, 67).addBox(-3.2322f, -6.0f, 4.7678f, 5.0f, 10.0f, 2.0f, 0.0f, false)
        bone4.setTextureOffset(31, 19).addBox(-2.2322f, 0.0f, 5.5178f, 3.0f, 6.0f, 2.0f, 0.0f, false)
        bone5 = ModelRenderer(this)
        bone5.setRotationPoint(0.0f, 0.0f, 0.0f)
        casting.addChild(bone5)
        setRotationAngle(bone5, 0.0f, 3.1416f, 0.0f)
        bone5.setTextureOffset(53, 69).addBox(-2.5f, -6.0f, 5.0711f, 5.0f, 10.0f, 2.0f, 0.0f, false)
        bone6 = ModelRenderer(this)
        bone6.setRotationPoint(0.0f, 0.0f, 0.0f)
        casting.addChild(bone6)
        setRotationAngle(bone6, 0.0f, 2.3562f, 0.0f)
        bone6.setTextureOffset(38, 69).addBox(-1.7678f, -6.0f, 4.7678f, 5.0f, 10.0f, 2.0f, 0.0f, false)
        bone6.setTextureOffset(19, 50).addBox(-0.7678f, 0.0f, 5.5178f, 3.0f, 6.0f, 2.0f, 0.0f, false)
        bone7 = ModelRenderer(this)
        bone7.setRotationPoint(0.0f, 0.0f, 0.0f)
        casting.addChild(bone7)
        setRotationAngle(bone7, 0.0f, 1.5708f, 0.0f)
        bone7.setTextureOffset(0, 69).addBox(-1.4645f, -6.0f, 4.0355f, 5.0f, 10.0f, 2.0f, 0.0f, false)
        bone8 = ModelRenderer(this)
        bone8.setRotationPoint(0.0f, 0.0f, 0.0f)
        casting.addChild(bone8)
        setRotationAngle(bone8, 0.0f, 0.7854f, 0.0f)
        bone8.setTextureOffset(0, 0).addBox(-1.7678f, -6.0f, 3.3033f, 5.0f, 10.0f, 2.0f, 0.0f, false)
        casting2 = ModelRenderer(this)
        casting2.setRotationPoint(0.5f, 0.0f, 0.825f)
        fixed.addChild(casting2)
        bone9 = ModelRenderer(this)
        bone9.setRotationPoint(0.0f, 0.0f, 0.0f)
        casting2.addChild(bone9)
        bone9.setTextureOffset(19, 59).addBox(-2.5f, -7.0f, -1.0f, 4.0f, 13.0f, 5.0f, 0.0f, false)
        bone10 = ModelRenderer(this)
        bone10.setRotationPoint(0.0f, 0.0f, 0.0f)
        casting2.addChild(bone10)
        setRotationAngle(bone10, 0.0f, -0.7854f, 0.0f)
        bone10.setTextureOffset(57, 19).addBox(-2.9393f, -7.0f, -0.4038f, 4.0f, 13.0f, 5.0f, 0.0f, false)
        bone11 = ModelRenderer(this)
        bone11.setRotationPoint(0.0f, 0.0f, 0.0f)
        casting2.addChild(bone11)
        setRotationAngle(bone11, 0.0f, -1.5708f, 0.0f)
        bone11.setTextureOffset(52, 40).addBox(-2.8284f, -7.0f, 0.3284f, 4.0f, 13.0f, 5.0f, 0.0f, false)
        bone12 = ModelRenderer(this)
        bone12.setRotationPoint(0.0f, 0.0f, 0.0f)
        casting2.addChild(bone12)
        setRotationAngle(bone12, 0.0f, -2.3562f, 0.0f)
        bone12.setTextureOffset(0, 50).addBox(-2.2322f, -7.0f, 0.7678f, 4.0f, 13.0f, 5.0f, 0.0f, false)
        bone13 = ModelRenderer(this)
        bone13.setRotationPoint(0.0f, 0.0f, 0.0f)
        casting2.addChild(bone13)
        setRotationAngle(bone13, 0.0f, 3.1416f, 0.0f)
        bone13.setTextureOffset(33, 45).addBox(-1.5f, -7.0f, 0.6569f, 4.0f, 13.0f, 5.0f, 0.0f, false)
        bone14 = ModelRenderer(this)
        bone14.setRotationPoint(0.0f, 0.0f, 0.0f)
        casting2.addChild(bone14)
        setRotationAngle(bone14, 0.0f, 2.3562f, 0.0f)
        bone14.setTextureOffset(38, 26).addBox(-1.0607f, -7.0f, 0.0607f, 4.0f, 13.0f, 5.0f, 0.0f, false)
        bone15 = ModelRenderer(this)
        bone15.setRotationPoint(0.0f, 0.0f, 0.0f)
        casting2.addChild(bone15)
        setRotationAngle(bone15, 0.0f, 1.5708f, 0.0f)
        bone15.setTextureOffset(19, 31).addBox(-1.1716f, -7.0f, -0.6716f, 4.0f, 13.0f, 5.0f, 0.0f, false)
        bone16 = ModelRenderer(this)
        bone16.setRotationPoint(0.0f, 0.0f, 0.0f)
        casting2.addChild(bone16)
        setRotationAngle(bone16, 0.0f, 0.7854f, 0.0f)
        bone16.setTextureOffset(0, 31).addBox(-1.7678f, -7.0f, -1.1109f, 4.0f, 13.0f, 5.0f, 0.0f, false)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        pos = ModelRenderer(this)
        pos.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(pos)
        pos.setTextureOffset(80, 13).addBox(-1.0f, -1.0f, 6.5f, 2.0f, 2.0f, 2.0f, 0.0f, false)
        rot = ModelRenderer(this)
        rot.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(rot)
        setRotationAngle(rot, 0.0f, 0.0f, 0.7854f)
        rot.setTextureOffset(14, 31).addBox(-1.0f, -1.0f, 6.5f, 2.0f, 2.0f, 2.0f, 0.0f, false)
    }
}
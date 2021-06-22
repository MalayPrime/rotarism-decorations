package com.github.malayP.decorations.block.machine.machine

import com.github.malayP.decorations.block.machine.engine.ACElectronicEngineTileEntityRender
import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.blastFurnaceType
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


class BlastFurnace : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = BlastFurnaceTileEntity()
}

class BlastFurnaceTileEntity : TileEntity(blastFurnaceType.get()) {}
class BlastFurnaceTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    TileEntityRenderer<BlastFurnaceTileEntity>(dispatcher) {
    companion object {
        val model = BlastFurnaceModel()
        val texture: ResourceLocation= modResourcesLocation("textures/tile_entity/production/blast_furnace/blast_furnace.png")
    }

    override fun render(
        tileEntityIn: BlastFurnaceTileEntity,
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

class BlastFurnaceModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val base: ModelRenderer
    private val bone2: ModelRenderer
    private val bone3: ModelRenderer
    private val bone4: ModelRenderer
    private val bone5: ModelRenderer
    private val bone: ModelRenderer
    private val pipe: ModelRenderer
    private val bone14: ModelRenderer
    private val `in`: ModelRenderer
    private val bone6: ModelRenderer
    private val bone7: ModelRenderer
    private val bone8: ModelRenderer
    private val bone9: ModelRenderer
    private val bone10: ModelRenderer
    private val bone11: ModelRenderer
    private val bone12: ModelRenderer
    private val bone13: ModelRenderer
    private val rotatable: ModelRenderer
    private val draw: ModelRenderer

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
        fixed.setTextureOffset(7, 25).addBox(-5.0f, -1.5f, -7.5f, 2.0f, 1.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(7, 19).addBox(3.0f, -1.5f, -7.5f, 2.0f, 1.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(69, 47).addBox(-7.0f, -8.0f, 6.0f, 14.0f, 7.0f, 2.0f, 0.0f, false)
        base = ModelRenderer(this)
        base.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(base)
        base.setTextureOffset(0, 0).addBox(-8.0f, 6.0f, -8.0f, 16.0f, 2.0f, 16.0f, 0.0f, false)
        base.setTextureOffset(0, 36).addBox(-6.0f, 5.0f, -7.0f, 12.0f, 1.0f, 12.0f, 0.0f, false)
        base.setTextureOffset(0, 50).addBox(-8.0f, 0.0f, -7.0f, 2.0f, 6.0f, 15.0f, 0.0f, false)
        base.setTextureOffset(77, 0).addBox(-6.0f, 0.0f, 8.0f, 12.0f, 6.0f, 0.0f, 0.0f, false)
        base.setTextureOffset(74, 16).addBox(-6.0f, -0.1213f, 4.4645f, 12.0f, 4.0f, 1.0f, 0.0f, false)
        base.setTextureOffset(34, 36).addBox(6.0f, 0.0f, -7.0f, 2.0f, 6.0f, 15.0f, 0.0f, false)
        base.setTextureOffset(0, 19).addBox(-8.0f, -1.0f, -7.0f, 16.0f, 1.0f, 15.0f, 0.0f, false)
        base.setTextureOffset(84, 7).addBox(-2.0f, -0.5f, -2.0f, 4.0f, 2.0f, 4.0f, 0.0f, false)
        base.setTextureOffset(81, 66).addBox(-5.0f, -15.0f, 6.3284f, 10.0f, 14.0f, 1.0f, 0.0f, false)
        base.setTextureOffset(0, 72).addBox(-5.0f, -15.0f, -5.5f, 10.0f, 14.0f, 1.0f, 0.0f, false)
        base.setTextureOffset(58, 58).addBox(-6.4142f, -15.0f, -4.0858f, 1.0f, 14.0f, 10.0f, 0.0f, false)
        base.setTextureOffset(35, 58).addBox(5.4142f, -15.0f, -4.0858f, 1.0f, 14.0f, 10.0f, 0.0f, false)
        base.setTextureOffset(49, 0).addBox(-0.5858f, -14.75f, -4.62f, 6.0f, 1.0f, 11.0f, 0.0f, false)
        base.setTextureOffset(54, 34).addBox(-5.4108f, -14.75f, -4.62f, 6.0f, 1.0f, 11.0f, 0.0f, false)
        bone2 = ModelRenderer(this)
        bone2.setRotationPoint(0.0f, 0.0f, 0.0f)
        base.addChild(bone2)
        setRotationAngle(bone2, 0.0f, -0.7854f, 0.0f)
        bone2.setTextureOffset(44, 95).addBox(-0.3536f, -14.9f, -7.4246f, 2.0f, 14.0f, 1.0f, 0.0f, false)
        bone3 = ModelRenderer(this)
        bone3.setRotationPoint(0.0f, 0.0f, 0.0f)
        base.addChild(bone3)
        setRotationAngle(bone3, 0.0f, -2.3562f, 0.0f)
        bone3.setTextureOffset(37, 95).addBox(-0.3536f, -14.9f, -8.7175f, 2.0f, 14.0f, 1.0f, 0.0f, false)
        bone4 = ModelRenderer(this)
        bone4.setRotationPoint(0.0f, 0.0f, 0.0f)
        base.addChild(bone4)
        setRotationAngle(bone4, 0.0f, 2.3562f, 0.0f)
        bone4.setTextureOffset(7, 0).addBox(-1.6464f, -14.9f, -8.7175f, 2.0f, 14.0f, 1.0f, 0.0f, false)
        bone5 = ModelRenderer(this)
        bone5.setRotationPoint(0.0f, 0.0f, 0.0f)
        base.addChild(bone5)
        setRotationAngle(bone5, 0.0f, 0.7854f, 0.0f)
        bone5.setTextureOffset(0, 0).addBox(-1.6464f, -14.9f, -7.4246f, 2.0f, 14.0f, 1.0f, 0.0f, false)
        bone = ModelRenderer(this)
        bone.setRotationPoint(0.0f, 0.0f, 0.0f)
        base.addChild(bone)
        setRotationAngle(bone, 0.7854f, 0.0f, 0.0f)
        bone.setTextureOffset(74, 22).addBox(-6.0f, 5.8995f, 0.4142f, 12.0f, 4.0f, 1.0f, 0.0f, false)
        pipe = ModelRenderer(this)
        pipe.setRotationPoint(0.0f, 0.0f, 0.5f)
        base.addChild(pipe)
        pipe.setTextureOffset(5, 36).addBox(-5.0f, -18.0f, -7.5f, 1.0f, 9.0f, 1.0f, 0.0f, false)
        pipe.setTextureOffset(0, 36).addBox(4.0f, -18.0f, -7.5f, 1.0f, 9.0f, 1.0f, 0.0f, false)
        pipe.setTextureOffset(0, 25).addBox(-5.0f, -18.0f, -6.5f, 1.0f, 1.0f, 4.0f, 0.0f, false)
        pipe.setTextureOffset(0, 19).addBox(4.0f, -18.0f, -6.5f, 1.0f, 1.0f, 4.0f, 0.0f, false)
        pipe.setTextureOffset(0, 31).addBox(-5.0f, -9.0f, -6.5f, 1.0f, 1.0f, 1.0f, 0.0f, false)
        pipe.setTextureOffset(10, 30).addBox(4.0f, -9.0f, -6.5f, 1.0f, 1.0f, 1.0f, 0.0f, false)
        pipe.setTextureOffset(49, 13).addBox(-8.0f, -9.0f, -7.5f, 16.0f, 1.0f, 1.0f, 0.0f, false)
        pipe.setTextureOffset(78, 28).addBox(7.0f, -3.0f, -1.5f, 1.0f, 1.0f, 8.0f, 0.0f, false)
        pipe.setTextureOffset(48, 58).addBox(-8.0f, -3.0f, -1.5f, 1.0f, 1.0f, 8.0f, 0.0f, false)
        bone14 = ModelRenderer(this)
        bone14.setRotationPoint(0.0f, 0.0f, 0.0f)
        pipe.addChild(bone14)
        setRotationAngle(bone14, -0.7854f, 0.0f, 0.0f)
        bone14.setTextureOffset(20, 50).addBox(-7.9f, -1.7678f, -10.9602f, 1.0f, 1.0f, 9.0f, 0.0f, false)
        bone14.setTextureOffset(23, 74).addBox(6.9f, -1.7678f, -10.9602f, 1.0f, 1.0f, 9.0f, 0.0f, false)
        `in` = ModelRenderer(this)
        `in`.setRotationPoint(0.0f, 0.1f, 0.0f)
        fixed.addChild(`in`)
        `in`.setTextureOffset(48, 19).addBox(-4.0f, -20.0f, -3.5f, 8.0f, 0.0f, 9.0f, 0.0f, false)
        bone6 = ModelRenderer(this)
        bone6.setRotationPoint(0.5f, 0.0f, 0.0f)
        `in`.addChild(bone6)
        bone6.setTextureOffset(72, 94).addBox(-3.0f, -22.75f, -5.1f, 5.0f, 8.0f, 3.0f, 0.0f, false)
        bone7 = ModelRenderer(this)
        bone7.setRotationPoint(0.5f, 0.0f, 0.0f)
        `in`.addChild(bone7)
        setRotationAngle(bone7, 0.0f, -0.7854f, 0.0f)
        bone7.setTextureOffset(94, 35).addBox(-2.192f, -22.85f, -5.0205f, 5.0f, 8.0f, 3.0f, 0.0f, false)
        bone8 = ModelRenderer(this)
        bone8.setRotationPoint(0.5f, 0.0f, 0.0f)
        `in`.addChild(bone8)
        setRotationAngle(bone8, 0.0f, -1.5708f, 0.0f)
        bone8.setTextureOffset(92, 91).addBox(-1.5645f, -22.75f, -5.5355f, 5.0f, 8.0f, 3.0f, 0.0f, false)
        bone9 = ModelRenderer(this)
        bone9.setRotationPoint(0.5f, 0.0f, 0.0f)
        `in`.addChild(bone9)
        setRotationAngle(bone9, 0.0f, -2.3562f, 0.0f)
        bone9.setTextureOffset(0, 88).addBox(-1.4849f, -22.85f, -6.3435f, 5.0f, 8.0f, 3.0f, 0.0f, false)
        bone10 = ModelRenderer(this)
        bone10.setRotationPoint(0.5f, 0.0f, 0.0f)
        `in`.addChild(bone10)
        setRotationAngle(bone10, 0.0f, 3.1416f, 0.0f)
        bone10.setTextureOffset(20, 85).addBox(-2.0f, -22.75f, -6.9711f, 5.0f, 8.0f, 3.0f, 0.0f, false)
        bone11 = ModelRenderer(this)
        bone11.setRotationPoint(0.5f, 0.0f, 0.0f)
        `in`.addChild(bone11)
        setRotationAngle(bone11, 0.0f, 2.3562f, 0.0f)
        bone11.setTextureOffset(58, 83).addBox(-2.808f, -22.85f, -7.0506f, 5.0f, 8.0f, 3.0f, 0.0f, false)
        bone12 = ModelRenderer(this)
        bone12.setRotationPoint(0.5f, 0.0f, 0.0f)
        `in`.addChild(bone12)
        setRotationAngle(bone12, 0.0f, 1.5708f, 0.0f)
        bone12.setTextureOffset(41, 83).addBox(-3.4355f, -22.75f, -6.5355f, 5.0f, 8.0f, 3.0f, 0.0f, false)
        bone13 = ModelRenderer(this)
        bone13.setRotationPoint(0.5f, 0.0f, 0.0f)
        `in`.addChild(bone13)
        setRotationAngle(bone13, 0.0f, 0.7854f, 0.0f)
        bone13.setTextureOffset(78, 82).addBox(-3.5151f, -22.85f, -5.7276f, 5.0f, 8.0f, 3.0f, 0.0f, false)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        draw = ModelRenderer(this)
        draw.setRotationPoint(0.0f, -1.0f, -7.0f)
        rotatable.addChild(draw)
        draw.setTextureOffset(71, 57).addBox(-7.5f, 0.0f, -1.0f, 15.0f, 7.0f, 1.0f, 0.0f, false)
    }
}
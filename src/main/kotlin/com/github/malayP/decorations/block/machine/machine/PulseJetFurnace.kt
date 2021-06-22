package com.github.malayP.decorations.block.machine.machine

import com.github.malayP.decorations.block.machine.engine.ACElectronicEngineTileEntityRender
import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.pulseJetFurnaceType
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


class PulseJetFurnace : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = PulseJetFurnaceTileEntity()
}

class PulseJetFurnaceTileEntity : TileEntity(pulseJetFurnaceType.get()) {}
class PulseJetFurnaceTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    TileEntityRenderer<PulseJetFurnaceTileEntity>(dispatcher) {
    companion object {
        val model = PulseJetFurnaceModel()
        val texture: ResourceLocation= modResourcesLocation("textures/tile_entity/processing/pulse_jet_furnace/pulse_jet_furnace.png")
    }

    override fun render(
        tileEntityIn: PulseJetFurnaceTileEntity,
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

class PulseJetFurnaceModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val tube1: ModelRenderer
    private val tube2: ModelRenderer
    private val furnace: ModelRenderer
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
        fixed.setTextureOffset(0, 0).addBox(-8.0f, 6.0f, -8.0f, 16.0f, 2.0f, 16.0f, 0.0f, false)
        tube1 = ModelRenderer(this)
        tube1.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(tube1)
        tube1.setTextureOffset(13, 61).addBox(-6.0f, 0.0f, 5.0f, 3.0f, 3.0f, 3.0f, 0.0f, false)
        tube1.setTextureOffset(46, 60).addBox(-6.0f, -3.0f, 3.0f, 3.0f, 3.0f, 5.0f, 0.0f, false)
        tube1.setTextureOffset(0, 41).addBox(-6.0f, 3.0f, -8.0f, 3.0f, 3.0f, 16.0f, 0.0f, false)
        tube1.setTextureOffset(58, 12).addBox(-7.0f, 2.0f, -6.0f, 5.0f, 4.0f, 7.0f, 0.0f, false)
        tube2 = ModelRenderer(this)
        tube2.setRotationPoint(9.0f, 0.0f, 0.0f)
        fixed.addChild(tube2)
        tube2.setTextureOffset(0, 61).addBox(-6.0f, 0.0f, 5.0f, 3.0f, 3.0f, 3.0f, 0.0f, false)
        tube2.setTextureOffset(34, 56).addBox(-6.0f, -3.0f, 3.0f, 3.0f, 3.0f, 5.0f, 0.0f, false)
        tube2.setTextureOffset(39, 25).addBox(-6.0f, 3.0f, -8.0f, 3.0f, 3.0f, 16.0f, 0.0f, false)
        tube2.setTextureOffset(47, 48).addBox(-7.0f, 2.0f, -6.0f, 5.0f, 4.0f, 7.0f, 0.0f, false)
        furnace = ModelRenderer(this)
        furnace.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(furnace)
        furnace.setTextureOffset(0, 19).addBox(-8.0f, -8.0f, -7.75f, 16.0f, 10.0f, 11.0f, 0.0f, false)
        furnace.setTextureOffset(23, 45).addBox(-7.0f, -7.0f, -8.0f, 14.0f, 8.0f, 1.0f, 0.0f, false)
        furnace.setTextureOffset(49, 0).addBox(-7.0f, -7.0f, 3.25f, 14.0f, 8.0f, 1.0f, 0.0f, false)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        pos = ModelRenderer(this)
        pos.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(pos)
        pos.setTextureOffset(0, 41).addBox(-1.0f, -0.5f, -1.0f, 2.0f, 9.0f, 2.0f, 0.0f, false)
        rot = ModelRenderer(this)
        rot.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(rot)
        setRotationAngle(rot, 0.0f, -0.7854f, 0.0f)
        rot.setTextureOffset(0, 0).addBox(-1.0f, -0.5f, -1.0f, 2.0f, 9.0f, 2.0f, 0.0f, false)
    }
}
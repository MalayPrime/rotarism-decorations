package com.github.malayP.decorations.block.machine.machine

import com.github.malayP.decorations.block.machine.engine.ACElectronicEngineTileEntityRender
import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.reverseGearType
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


class ReverseGear : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = ReverseGearTileEntity()
}

class ReverseGearTileEntity : TileEntity(reverseGearType.get()) {}
class ReverseGearTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    TileEntityRenderer<ReverseGearTileEntity>(dispatcher) {
    companion object {
        val model = ReverseGearModel()
        val texture: ResourceLocation= modResourcesLocation("textures/tile_entity/utility/reservoir/reservoir.png")
    }

    override fun render(
        tileEntityIn: ReverseGearTileEntity,
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

class ReverseGearModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val rotfixed: ModelRenderer
    private val rotatable: ModelRenderer
    private val input: ModelRenderer
    private val pos: ModelRenderer
    private val rot: ModelRenderer
    private val output: ModelRenderer
    private val pos2: ModelRenderer
    private val rot2: ModelRenderer

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
        rotfixed = ModelRenderer(this)
        rotfixed.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotfixed)
        setRotationAngle(rotfixed, 0.0f, -1.5708f, 0.0f)
        rotfixed.setTextureOffset(54, 9).addBox(-8.0f, -8.0f, -5.0f, 1.0f, 3.0f, 10.0f, 0.0f, false)
        rotfixed.setTextureOffset(0, 52).addBox(7.0f, -8.0f, -5.0f, 1.0f, 3.0f, 10.0f, 0.0f, false)
        rotfixed.setTextureOffset(19, 32).addBox(-8.0f, -5.0f, -8.0f, 1.0f, 13.0f, 16.0f, 0.0f, false)
        rotfixed.setTextureOffset(0, 18).addBox(7.0f, -5.0f, -8.0f, 1.0f, 13.0f, 16.0f, 0.0f, false)
        rotfixed.setTextureOffset(0, 0).addBox(-7.0f, 7.0f, -8.0f, 14.0f, 1.0f, 16.0f, 0.0f, false)
        rotfixed.setTextureOffset(54, 47).addBox(-7.0f, 0.0f, -8.0f, 14.0f, 7.0f, 1.0f, 0.0f, false)
        rotfixed.setTextureOffset(45, 0).addBox(-7.0f, 0.0f, 7.0f, 14.0f, 7.0f, 1.0f, 0.0f, false)
        rotfixed.setTextureOffset(8, 0).addBox(6.0f, -3.0f, 7.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        rotfixed.setTextureOffset(0, 0).addBox(6.0f, -3.0f, -8.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        rotfixed.setTextureOffset(0, 8).addBox(-7.0f, -3.0f, 7.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        rotfixed.setTextureOffset(4, 4).addBox(-7.0f, -3.0f, -8.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        rotfixed.setTextureOffset(19, 18).addBox(-7.0f, -3.0f, -3.0f, 14.0f, 6.0f, 6.0f, 0.0f, false)
        rotfixed.setTextureOffset(48, 56).addBox(-3.0f, 3.0f, -3.0f, 6.0f, 4.0f, 6.0f, 0.0f, false)
        rotfixed.setTextureOffset(38, 31).addBox(-1.0f, 0.0f, -7.0f, 2.0f, 1.0f, 14.0f, 0.0f, false)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        input = ModelRenderer(this)
        input.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(input)
        pos = ModelRenderer(this)
        pos.setRotationPoint(0.0f, 0.0f, 0.0f)
        input.addChild(pos)
        pos.setTextureOffset(57, 23).addBox(-1.0f, -1.0f, 0.5f, 2.0f, 2.0f, 8.0f, 0.0f, false)
        rot = ModelRenderer(this)
        rot.setRotationPoint(0.0f, 0.0f, 0.0f)
        input.addChild(rot)
        setRotationAngle(rot, 0.0f, 0.0f, 0.7854f)
        rot.setTextureOffset(57, 23).addBox(-1.0f, -1.0f, 0.5f, 2.0f, 2.0f, 8.0f, 0.0f, false)
        output = ModelRenderer(this)
        output.setRotationPoint(0.0f, 0.0f, -9.25f)
        rotatable.addChild(output)
        pos2 = ModelRenderer(this)
        pos2.setRotationPoint(0.0f, 0.0f, 0.0f)
        output.addChild(pos2)
        pos2.setTextureOffset(57, 23).addBox(-1.0f, -1.0f, 0.75f, 2.0f, 2.0f, 8.0f, 0.0f, false)
        rot2 = ModelRenderer(this)
        rot2.setRotationPoint(0.0f, 0.0f, 0.0f)
        output.addChild(rot2)
        setRotationAngle(rot2, 0.0f, 0.0f, 0.7854f)
        rot2.setTextureOffset(57, 23).addBox(-1.0f, -1.0f, 0.75f, 2.0f, 2.0f, 8.0f, 0.0f, false)
    }
}
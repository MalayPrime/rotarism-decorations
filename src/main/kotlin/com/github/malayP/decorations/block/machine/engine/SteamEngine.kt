package com.github.malayP.decorations.block.machine.engine

import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.stemEngineType
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


class SteamEngine : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = SteamEngineTileEntity()
}

class SteamEngineTileEntity : TileEntity(stemEngineType.get())
class SteamEngineTileEntityRender(dispatcher: TileEntityRendererDispatcher) : TileEntityRenderer<SteamEngineTileEntity>(
    dispatcher
) {
    companion object {
        val model = SteamEngineModel()
        val texture = modResourcesLocation("textures/tile_entity/engines/steam_engine/steam_engine.png")
    }

    override fun render(
        tileEntityIn: SteamEngineTileEntity,
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

class SteamEngineModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val rotatable: ModelRenderer
    private val pos: ModelRenderer
    private val diff3: ModelRenderer
    private val diff4: ModelRenderer
    private val support: ModelRenderer
    private val rot: ModelRenderer
    private val diff2: ModelRenderer
    private val diff: ModelRenderer
    private val support2: ModelRenderer

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
        fixed.setTextureOffset(0, 0).addBox(-8.0f, 7.0f, -8.0f, 16.0f, 1.0f, 16.0f, 0.0f, false)
        fixed.setTextureOffset(0, 18).addBox(-8.0f, 5.95f, -8.0f, 16.0f, 0.0f, 16.0f, 0.0f, false)
        fixed.setTextureOffset(0, 35).addBox(-8.0f, 6.0f, -3.0f, 16.0f, 1.0f, 11.0f, 0.0f, false)
        fixed.setTextureOffset(44, 35).addBox(-8.0f, 6.0f, -8.0f, 16.0f, 1.0f, 2.0f, 0.0f, false)
        fixed.setTextureOffset(14, 59).addBox(-8.0f, 6.0f, -6.0f, 3.0f, 1.0f, 3.0f, 0.0f, false)
        fixed.setTextureOffset(49, 29).addBox(5.0f, 6.0f, -6.0f, 3.0f, 1.0f, 3.0f, 0.0f, false)
        fixed.setTextureOffset(49, 0).addBox(-5.0f, 5.01f, 1.0f, 10.0f, 3.0f, 6.0f, 0.0f, false)
        fixed.setTextureOffset(0, 48).addBox(-6.0f, 3.0f, 0.99f, 12.0f, 3.0f, 7.0f, 0.0f, false)
        fixed.setTextureOffset(44, 44).addBox(-3.0f, -3.0f, -3.0f, 6.0f, 5.0f, 11.0f, 0.0f, false)
        fixed.setTextureOffset(53, 61).addBox(-4.0f, -4.0f, -1.0f, 8.0f, 10.0f, 2.0f, 0.0f, false)
        fixed.setTextureOffset(0, 0).addBox(-2.0f, -2.0f, -8.0f, 4.0f, 8.0f, 2.0f, 0.0f, false)
        fixed.setTextureOffset(49, 18).addBox(-5.0f, -2.0f, 2.0f, 10.0f, 5.0f, 5.0f, 0.0f, false)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        pos = ModelRenderer(this)
        pos.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(pos)
        pos.setTextureOffset(0, 59).addBox(-1.0f, -1.0f, -8.5f, 2.0f, 2.0f, 9.0f, 0.0f, false)
        diff3 = ModelRenderer(this)
        diff3.setRotationPoint(0.0f, 0.0f, 0.0f)
        pos.addChild(diff3)
        diff3.setTextureOffset(0, 59).addBox(-6.0104f, -2.5251f, -5.45f, 1.0f, 5.0f, 2.0f, 0.0f, false)
        diff3.setTextureOffset(0, 35).addBox(5.0607f, -2.5251f, -5.45f, 1.0f, 5.0f, 2.0f, 0.0f, false)
        diff4 = ModelRenderer(this)
        diff4.setRotationPoint(0.0f, 0.0f, 0.0f)
        pos.addChild(diff4)
        diff4.setTextureOffset(0, 11).addBox(-2.4749f, 5.0104f, -5.45f, 5.0f, 1.0f, 2.0f, 0.0f, false)
        diff4.setTextureOffset(0, 18).addBox(-2.4749f, -6.0607f, -5.45f, 5.0f, 1.0f, 2.0f, 0.0f, false)
        support = ModelRenderer(this)
        support.setRotationPoint(0.0f, 0.0f, 0.0f)
        pos.addChild(support)
        support.setTextureOffset(32, 48).addBox(-5.0f, -0.5f, -5.0f, 10.0f, 1.0f, 1.0f, 0.0f, false)
        support.setTextureOffset(31, 64).addBox(-0.5f, -5.0f, -5.0f, 1.0f, 10.0f, 1.0f, 0.0f, false)
        rot = ModelRenderer(this)
        rot.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(rot)
        setRotationAngle(rot, 0.0f, 0.0f, 0.7854f)
        rot.setTextureOffset(30, 52).addBox(-1.0f, -1.0f, -8.49f, 2.0f, 2.0f, 9.0f, 0.0f, false)
        diff2 = ModelRenderer(this)
        diff2.setRotationPoint(0.0f, 0.0f, 0.0f)
        rot.addChild(diff2)
        diff2.setTextureOffset(49, 10).addBox(-2.5f, 5.0f, -5.5f, 5.0f, 1.0f, 2.0f, 0.0f, false)
        diff2.setTextureOffset(0, 30).addBox(-2.5f, -6.0711f, -5.5f, 5.0f, 1.0f, 2.0f, 0.0f, false)
        diff = ModelRenderer(this)
        diff.setRotationPoint(0.0f, 0.0f, 0.0f)
        rot.addChild(diff)
        setRotationAngle(diff, 0.0f, 0.0f, 1.5708f)
        diff.setTextureOffset(0, 26).addBox(-2.5355f, 5.0355f, -5.5f, 5.0f, 1.0f, 2.0f, 0.0f, false)
        diff.setTextureOffset(0, 22).addBox(-2.5355f, -6.0355f, -5.5f, 5.0f, 1.0f, 2.0f, 0.0f, false)
        support2 = ModelRenderer(this)
        support2.setRotationPoint(0.0f, 0.0f, 0.0f)
        rot.addChild(support2)
        support2.setTextureOffset(44, 39).addBox(-5.0f, -0.5f, -4.99f, 10.0f, 1.0f, 1.0f, 0.0f, false)
        support2.setTextureOffset(26, 63).addBox(-0.5f, -5.0f, -4.99f, 1.0f, 10.0f, 1.0f, 0.0f, false)
    }
}
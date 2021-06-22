package com.github.malayP.decorations.block.machine.relay


import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.clutchType
import com.github.zomb_676.fantasySoup.block.HorizonBlockWithTileEntity
import com.mojang.blaze3d.matrix.MatrixStack
import com.mojang.blaze3d.vertex.IVertexBuilder
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.IRenderTypeBuffer
import net.minecraft.client.renderer.RenderType
import net.minecraft.client.renderer.model.Model
import net.minecraft.client.renderer.model.ModelRenderer
import net.minecraft.client.renderer.tileentity.TileEntityRenderer
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher
import net.minecraft.state.BooleanProperty
import net.minecraft.state.StateContainer
import net.minecraft.state.properties.BlockStateProperties
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.vector.Vector3f
import net.minecraft.world.IBlockReader


class Clutch : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    companion object {
        val clutchActivated: BooleanProperty = BooleanProperty.create("is_activated")
    }

    init {
        this.defaultState = this.defaultState.with(clutchActivated, false)
    }

    override fun fillStateContainer(builder: StateContainer.Builder<Block, BlockState>) {
        super.fillStateContainer(builder.add(clutchActivated))
    }

    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = ClutchTileEntity()
}

class ClutchTileEntity : TileEntity(clutchType.get()) {

}

class ClutchTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    TileEntityRenderer<ClutchTileEntity>(dispatcher) {
    companion object {
        val model = ClutchModel()
        val clutch = modResourcesLocation("textures/tile_entity/transmission/clutch/clutch.png")
        val clutchActivated = modResourcesLocation("textures/tile_entity/transmission/clutch/clutch_activated.png")
    }

    override fun render(
        tileEntityIn: ClutchTileEntity,
        partialTicks: Float,
        matrixStackIn: MatrixStack,
        bufferIn: IRenderTypeBuffer,
        combinedLightIn: Int,
        combinedOverlayIn: Int,
    ) {
        matrixStackIn.push()
        val texture: ResourceLocation =
            if (tileEntityIn.world != null && tileEntityIn.blockState.get(Clutch.clutchActivated)) {
                clutchActivated
            } else {
                clutch
            }
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

class ClutchModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val pos2: ModelRenderer
    private val rot2: ModelRenderer
    private val rotatable: ModelRenderer
    private val input: ModelRenderer
    private val pos: ModelRenderer
    private val rot: ModelRenderer
    private val output: ModelRenderer
    private val pos3: ModelRenderer
    private val rot3: ModelRenderer
    private val activable: ModelRenderer
    private val pos4: ModelRenderer

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
        pos2 = ModelRenderer(this)
        pos2.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(pos2)
        pos2.setTextureOffset(0, 0).addBox(-8.0f, 7.0f, -8.0f, 16.0f, 1.0f, 16.0f, 0.0f, false)
        pos2.setTextureOffset(0, 18).addBox(-8.0f, -2.0f, -7.0f, 1.0f, 9.0f, 14.0f, 0.0f, false)
        pos2.setTextureOffset(0, 18).addBox(7.0f, -2.0f, -7.0f, 1.0f, 9.0f, 14.0f, 0.0f, false)
        pos2.setTextureOffset(0, 25).addBox(-8.0f, -5.0f, -7.0f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        pos2.setTextureOffset(0, 18).addBox(-8.0f, -5.0f, 4.0f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        pos2.setTextureOffset(6, 6).addBox(7.0f, -5.0f, -7.0f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        pos2.setTextureOffset(0, 0).addBox(7.0f, -5.0f, 4.0f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        pos2.setTextureOffset(35, 47).addBox(-8.0f, -5.0f, 7.0f, 16.0f, 12.0f, 1.0f, 0.0f, false)
        pos2.setTextureOffset(51, 18).addBox(-5.0f, -8.0f, 7.0f, 10.0f, 3.0f, 1.0f, 0.0f, false)
        pos2.setTextureOffset(0, 47).addBox(-8.0f, -5.0f, -8.0f, 16.0f, 12.0f, 1.0f, 0.0f, false)
        pos2.setTextureOffset(0, 42).addBox(-5.0f, -8.0f, -8.0f, 10.0f, 3.0f, 1.0f, 0.0f, false)
        pos2.setTextureOffset(31, 31).addBox(-4.0f, 2.0f, -5.0f, 8.0f, 5.0f, 10.0f, 0.0f, false)
        rot2 = ModelRenderer(this)
        rot2.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(rot2)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        input = ModelRenderer(this)
        input.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(input)
        pos = ModelRenderer(this)
        pos.setRotationPoint(0.0f, 0.0f, 0.0f)
        input.addChild(pos)
        pos.setTextureOffset(38, 18).addBox(-1.0f, -1.0f, 0.51f, 2.0f, 2.0f, 8.0f, 0.0f, false)
        rot = ModelRenderer(this)
        rot.setRotationPoint(0.0f, 0.0f, 0.0f)
        input.addChild(rot)
        setRotationAngle(rot, 0.0f, 0.0f, 0.7854f)
        rot.setTextureOffset(17, 18).addBox(-1.0f, -1.0f, 0.5f, 2.0f, 2.0f, 8.0f, 0.0f, false)
        output = ModelRenderer(this)
        output.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(output)
        pos3 = ModelRenderer(this)
        pos3.setRotationPoint(0.0f, 0.0f, 0.0f)
        output.addChild(pos3)
        pos3.setTextureOffset(38, 18).addBox(-1.0f, -1.0f, -8.49f, 2.0f, 2.0f, 8.0f, 0.0f, false)
        rot3 = ModelRenderer(this)
        rot3.setRotationPoint(0.0f, 0.0f, 0.0f)
        output.addChild(rot3)
        setRotationAngle(rot3, 0.0f, 0.0f, 0.7854f)
        rot3.setTextureOffset(17, 18).addBox(-1.0f, -1.0f, -8.5f, 2.0f, 2.0f, 8.0f, 0.0f, false)
        activable = ModelRenderer(this)
        activable.setRotationPoint(0.0f, 8.0f, 0.0f)
        shell.addChild(activable)
        pos4 = ModelRenderer(this)
        pos4.setRotationPoint(0.0f, 0.0f, 0.0f)
        activable.addChild(pos4)
        pos4.setTextureOffset(49, 0).addBox(-3.0f, -11.0f, -4.0f, 6.0f, 5.0f, 8.0f, 0.0f, false)
    }
}
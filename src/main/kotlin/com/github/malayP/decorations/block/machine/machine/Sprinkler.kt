package com.github.malayP.decorations.block.machine.machine

import com.github.malayP.decorations.block.machine.consumer.CentrifugeTileEntityRender
import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity
import com.github.malayP.decorations.register.AllTileEntity.sprinklerType
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
import net.minecraft.client.renderer.model.ModelResourceLocation
import net.minecraft.client.renderer.tileentity.TileEntityRenderer
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher
import net.minecraft.state.properties.BlockStateProperties
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.shapes.ISelectionContext
import net.minecraft.util.math.shapes.VoxelShape
import net.minecraft.util.math.vector.Vector3f
import net.minecraft.world.IBlockReader

class Sprinkler : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = SprinklerTileEntity()

    companion object{
        private val shape = makeCuboidShape(4.0,0.0,4.0,12.0,16.0,12.0)
    }
    override fun getCollisionShape(state: BlockState, reader: IBlockReader, pos: BlockPos): VoxelShape = shape

    override fun getCollisionShape(
        state: BlockState,
        worldIn: IBlockReader,
        pos: BlockPos,
        context: ISelectionContext
    ): VoxelShape = shape
    override fun getShape(
        state: BlockState?,
        worldIn: IBlockReader?,
        pos: BlockPos?,
        context: ISelectionContext?
    ): VoxelShape = shape
}

class SprinklerTileEntity:TileEntity(sprinklerType.get()){

}

class SprinklerTileEntityRender(rendererDispatcherIn: TileEntityRendererDispatcher?) :TileEntityRenderer<SprinklerTileEntity>(
    rendererDispatcherIn
) {
    companion object{
        val texture = modResourcesLocation("textures/tile_entity/farming/sprinkler/sprinkler.png")
        val model = SprinklerModel()
    }
    override fun render(
        tileEntityIn: SprinklerTileEntity,
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

class SprinklerModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val bone3: ModelRenderer
    private val bone: ModelRenderer
    private val bone2: ModelRenderer
    private val rotatable: ModelRenderer
    private val pos: ModelRenderer
    private val rot: ModelRenderer

    override fun render(
        matrixStack: MatrixStack?,
        buffer: IVertexBuilder?,
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
        textureWidth = 64
        textureHeight = 64
        shell = ModelRenderer(this)
        shell.setRotationPoint(0.0f, 24.0f, 0.0f)
        fixed = ModelRenderer(this)
        fixed.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(fixed)
        fixed.setTextureOffset(0, 0).addBox(-4.0f, -17.0f, -4.0f, 8.0f, 2.0f, 8.0f, 0.0f, false)
        fixed.setTextureOffset(0, 11).addBox(-3.0f, -15.0f, -3.0f, 6.0f, 8.0f, 6.0f, 0.0f, false)
        fixed.setTextureOffset(35, 34).addBox(2.5f, -11.0f, -1.0f, 1.0f, 7.0f, 2.0f, 0.0f, false)
        fixed.setTextureOffset(17, 28).addBox(2.5f, -15.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        fixed.setTextureOffset(28, 34).addBox(-3.5f, -11.0f, -1.0f, 1.0f, 7.0f, 2.0f, 0.0f, false)
        fixed.setTextureOffset(25, 11).addBox(-3.5f, -15.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        fixed.setTextureOffset(7, 39).addBox(-1.0f, -11.0f, -3.5f, 2.0f, 7.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(33, 8).addBox(-2.0f, -15.0f, -3.5f, 4.0f, 4.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(0, 39).addBox(-1.0f, -11.0f, 2.5f, 2.0f, 7.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(28, 28).addBox(-2.0f, -15.0f, 2.5f, 4.0f, 4.0f, 1.0f, 0.0f, false)
        bone3 = ModelRenderer(this)
        bone3.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(bone3)
        setRotationAngle(bone3, 0.0f, -0.7854f, 0.0f)
        bone3.setTextureOffset(0, 26).addBox(-2.0f, -14.0f, -2.0f, 4.0f, 8.0f, 4.0f, 0.0f, false)
        bone = ModelRenderer(this)
        bone.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(bone)
        setRotationAngle(bone, 0.0f, -0.7854f, 0.0f)
        bone.setTextureOffset(25, 0).addBox(-3.0f, -4.0f, -3.0f, 6.0f, 1.0f, 6.0f, 0.0f, false)
        bone2 = ModelRenderer(this)
        bone2.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(bone2)
        bone2.setTextureOffset(19, 20).addBox(-3.0f, -3.9f, -3.0f, 6.0f, 1.0f, 6.0f, 0.0f, false)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        pos = ModelRenderer(this)
        pos.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(pos)
        pos.setTextureOffset(38, 14).addBox(-1.0f, -10.0f, -1.0f, 2.0f, 5.0f, 2.0f, 0.0f, false)
        rot = ModelRenderer(this)
        rot.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(rot)
        setRotationAngle(rot, 0.0f, -0.7854f, 0.0f)
        rot.setTextureOffset(15, 37).addBox(-1.0f, -10.0f, -1.0f, 2.0f, 5.0f, 2.0f, 0.0f, false)
    }
}
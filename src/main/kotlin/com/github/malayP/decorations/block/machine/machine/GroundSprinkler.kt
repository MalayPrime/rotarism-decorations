package com.github.malayP.decorations.block.machine.machine

import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.groundSprinklerType
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
import net.minecraft.state.properties.BlockStateProperties
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.shapes.ISelectionContext
import net.minecraft.util.math.shapes.VoxelShape
import net.minecraft.util.math.shapes.VoxelShapes
import net.minecraft.util.math.vector.Vector3f
import net.minecraft.world.IBlockReader


class GroundSprinkler : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = GroundSprinklerTileEntity()
    companion object{
        private val base:VoxelShape = makeCuboidShape(2.0,0.0,2.0,14.0,1.0,14.0)
        private val rod:VoxelShape = makeCuboidShape(5.5,0.8,5.5,11.5,45.0,11.5)
        private val shape:VoxelShape = VoxelShapes.or(base, rod)
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

class GroundSprinklerTileEntity : TileEntity(groundSprinklerType.get()) {}
class GroundSprinklerTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    TileEntityRenderer<GroundSprinklerTileEntity>(dispatcher) {
    companion object {
        val model = GroundSprinklerModel()
        val texture: ResourceLocation= modResourcesLocation("textures/tile_entity/farming/ground_sprinkler/ground_sprinkler.png")
    }

    override fun render(
        tileEntityIn: GroundSprinklerTileEntity,
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

class GroundSprinklerModel : Model(RenderType::getEntitySolid){
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val support: ModelRenderer
    private val rotport: ModelRenderer
    private val fixbone: ModelRenderer
    private val bone2: ModelRenderer
    private val fixbone2: ModelRenderer
    private val bone3: ModelRenderer
    private val fixbone3: ModelRenderer
    private val bone4: ModelRenderer
    private val fixbone4: ModelRenderer
    private val bone5: ModelRenderer
    private val rotatable: ModelRenderer
    private val roter: ModelRenderer
    private val diff: ModelRenderer
    private val pos2: ModelRenderer
    private val rot2: ModelRenderer
    private val bone: ModelRenderer
    private val spread: ModelRenderer
    private val deroter: ModelRenderer
    private val cube_r1: ModelRenderer
    private val inside: ModelRenderer
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
        textureWidth = 64
        textureHeight = 64
        shell = ModelRenderer(this)
        shell.setRotationPoint(0.0f, 16.0f, 0.0f)
        fixed = ModelRenderer(this)
        fixed.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(fixed)
        support = ModelRenderer(this)
        support.setRotationPoint(0.0f, 8.0f, 0.0f)
        fixed.addChild(support)
        support.setTextureOffset(0, 0).addBox(-6.0f, -1.0f, -6.0f, 12.0f, 1.0f, 12.0f, 0.0f, false)
        support.setTextureOffset(17, 33).addBox(-2.5f, -9.0f, -2.5f, 5.0f, 8.0f, 5.0f, 0.0f, false)
        support.setTextureOffset(0, 30).addBox(-2.0f, -22.0f, -2.0f, 4.0f, 13.0f, 4.0f, 0.0f, false)
        rotport = ModelRenderer(this)
        rotport.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(rotport)
        fixbone = ModelRenderer(this)
        fixbone.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotport.addChild(fixbone)
        bone2 = ModelRenderer(this)
        bone2.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixbone.addChild(bone2)
        setRotationAngle(bone2, -0.3927f, 0.0f, 0.0f)
        bone2.setTextureOffset(24, 47).addBox(-1.0f, -5.0f, -4.0f, 2.0f, 15.0f, 2.0f, 0.0f, false)
        fixbone2 = ModelRenderer(this)
        fixbone2.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotport.addChild(fixbone2)
        setRotationAngle(fixbone2, 0.0f, 1.5708f, 0.0f)
        bone3 = ModelRenderer(this)
        bone3.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixbone2.addChild(bone3)
        setRotationAngle(bone3, -0.3927f, 0.0f, 0.0f)
        bone3.setTextureOffset(15, 47).addBox(-1.0f, -5.0f, -4.0f, 2.0f, 15.0f, 2.0f, 0.0f, false)
        fixbone3 = ModelRenderer(this)
        fixbone3.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotport.addChild(fixbone3)
        setRotationAngle(fixbone3, 0.0f, 3.1416f, 0.0f)
        bone4 = ModelRenderer(this)
        bone4.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixbone3.addChild(bone4)
        setRotationAngle(bone4, -0.3927f, 0.0f, 0.0f)
        bone4.setTextureOffset(46, 14).addBox(-1.0f, -5.0f, -4.0f, 2.0f, 15.0f, 2.0f, 0.0f, false)
        fixbone4 = ModelRenderer(this)
        fixbone4.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotport.addChild(fixbone4)
        setRotationAngle(fixbone4, 0.0f, -1.5708f, 0.0f)
        bone5 = ModelRenderer(this)
        bone5.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixbone4.addChild(bone5)
        setRotationAngle(bone5, -0.3927f, 0.0f, 0.0f)
        bone5.setTextureOffset(38, 33).addBox(-1.0f, -5.0f, -4.0f, 2.0f, 15.0f, 2.0f, 0.0f, false)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        roter = ModelRenderer(this)
        roter.setRotationPoint(0.0f, -22.5f, 0.0f)
        rotatable.addChild(roter)
        setRotationAngle(roter, 0.3927f, 0.0f, 0.0f)
        diff = ModelRenderer(this)
        diff.setRotationPoint(0.0f, 22.5f, 0.0f)
        roter.addChild(diff)
        diff.setTextureOffset(0, 48).addBox(-1.0f, -28.75f, -1.0f, 2.0f, 3.0f, 2.0f, 0.0f, false)
        diff.setTextureOffset(19, 18).addBox(-0.5f, -27.75f, -6.0f, 1.0f, 2.0f, 12.0f, 0.0f, false)
        diff.setTextureOffset(33, 49).addBox(0.5f, -27.75f, -7.0f, 1.0f, 4.0f, 2.0f, 0.0f, false)
        diff.setTextureOffset(0, 21).addBox(-0.5f, -27.25f, 6.0f, 1.0f, 1.0f, 4.0f, 0.0f, false)
        diff.setTextureOffset(47, 44).addBox(-0.5f, -26.25f, 9.0f, 1.0f, 2.0f, 3.0f, 0.0f, false)
        pos2 = ModelRenderer(this)
        pos2.setRotationPoint(0.0f, 0.0f, 0.0f)
        diff.addChild(pos2)
        pos2.setTextureOffset(7, 21).addBox(-0.5f, -26.75f, -0.5f, 1.0f, 2.0f, 1.0f, 0.0f, false)
        rot2 = ModelRenderer(this)
        rot2.setRotationPoint(0.0f, -25.0f, -0.5f)
        diff.addChild(rot2)
        setRotationAngle(rot2, 0.0f, -0.7854f, 0.0f)
        rot2.setTextureOffset(8, 14).addBox(-0.1464f, -1.75f, -0.1464f, 1.0f, 2.0f, 1.0f, 0.0f, false)
        bone = ModelRenderer(this)
        bone.setRotationPoint(0.0f, -26.5f, 10.0f)
        diff.addChild(bone)
        setRotationAngle(bone, -0.7854f, 0.0f, 0.0f)
        bone.setTextureOffset(27, 14).addBox(-0.4f, -0.5303f, -0.5303f, 1.0f, 1.0f, 2.0f, 0.0f, false)
        spread = ModelRenderer(this)
        spread.setRotationPoint(0.0f, 22.5f, 0.0f)
        roter.addChild(spread)
        spread.setTextureOffset(0, 14).addBox(-1.0f, -25.0f, -5.0f, 2.0f, 2.0f, 13.0f, 0.0f, false)
        spread.setTextureOffset(45, 50).addBox(-1.5f, -25.0f, -7.0f, 2.0f, 2.0f, 2.0f, 0.0f, false)
        spread.setTextureOffset(0, 14).addBox(-0.5f, -23.0f, 2.0f, 1.0f, 1.0f, 5.0f, 0.0f, false)
        spread.setTextureOffset(47, 38).addBox(-1.5f, -25.5f, 4.75f, 3.0f, 1.0f, 4.0f, 0.0f, false)
        spread.setTextureOffset(47, 32).addBox(-1.5f, -23.5f, 4.75f, 3.0f, 1.0f, 4.0f, 0.0f, false)
        spread.setTextureOffset(34, 20).addBox(-1.5f, -24.5f, 4.75f, 1.0f, 1.0f, 4.0f, 0.0f, false)
        spread.setTextureOffset(34, 14).addBox(0.5f, -24.5f, 4.75f, 1.0f, 1.0f, 4.0f, 0.0f, false)
        deroter = ModelRenderer(this)
        deroter.setRotationPoint(0.0f, 0.0f, 0.0f)
        roter.addChild(deroter)
        cube_r1 = ModelRenderer(this)
        cube_r1.setRotationPoint(0.0f, 0.0f, 0.0f)
        deroter.addChild(cube_r1)
        setRotationAngle(cube_r1, -0.3927f, 0.0f, 0.0f)
        cube_r1.setTextureOffset(0, 14).addBox(-0.5f, 0.75f, -4.75f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        inside = ModelRenderer(this)
        inside.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(inside)
        inside.setTextureOffset(37, 0).addBox(-2.0f, -24.0f, -2.0f, 4.0f, 5.0f, 4.0f, 0.0f, false)
        pos = ModelRenderer(this)
        pos.setRotationPoint(0.0f, 0.0f, 0.0f)
        inside.addChild(pos)
        pos.setTextureOffset(18, 14).addBox(-1.0f, -20.0f, -1.0f, 2.0f, 7.0f, 2.0f, 0.0f, false)
        rot = ModelRenderer(this)
        rot.setRotationPoint(0.0f, 0.0f, 0.0f)
        inside.addChild(rot)
        setRotationAngle(rot, 0.0f, -0.7854f, 0.0f)
        rot.setTextureOffset(0, 0).addBox(-1.0f, -20.0f, -1.0f, 2.0f, 7.0f, 2.0f, 0.0f, false)
    }
}
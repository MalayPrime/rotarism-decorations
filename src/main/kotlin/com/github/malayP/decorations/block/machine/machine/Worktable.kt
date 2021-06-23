package com.github.malayP.decorations.block.machine.machine

import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.worktableType
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
import net.minecraft.util.Direction
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.shapes.ISelectionContext
import net.minecraft.util.math.shapes.VoxelShape
import net.minecraft.util.math.vector.Vector3f
import net.minecraft.world.IBlockReader


class Worktable : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = WorktableTileEntity()

    companion object{
        private val south : VoxelShape = makeCuboidShape(0.0,0.0,0.0,32.0,32.0,16.0)
        private val west :VoxelShape = makeCuboidShape(0.0,0.0,0.0,16.0,32.0,32.0)
        private val north :VoxelShape = makeCuboidShape(-16.0,0.0,0.0,16.0,32.0,16.0)
        private val east :VoxelShape = makeCuboidShape(0.0,0.0,-16.0,16.0,32.0,16.0)
    }

    override fun getCollisionShape(state: BlockState, reader: IBlockReader, pos: BlockPos): VoxelShape = getShape(state)

    override fun getCollisionShape(
        state: BlockState,
        worldIn: IBlockReader,
        pos: BlockPos,
        context: ISelectionContext
    ): VoxelShape = getShape(state)
    override fun getShape(
        state: BlockState,
        worldIn: IBlockReader?,
        pos: BlockPos?,
        context: ISelectionContext?
    ): VoxelShape = getShape(state)



    @Throws(RuntimeException::class)
    private fun getShape(state: BlockState):VoxelShape=
        when(state.get(BlockStateProperties.HORIZONTAL_FACING)){
            Direction.NORTH -> north
            Direction.SOUTH -> south
            Direction.WEST -> west
            Direction.EAST -> east
            else -> throw RuntimeException("get up/down from horizon face block")
        }

    override fun getRayTraceShape(
        state: BlockState,
        reader: IBlockReader,
        pos: BlockPos,
        context: ISelectionContext
    ): VoxelShape =getShape(state)

    override fun getRaytraceShape(state: BlockState, worldIn: IBlockReader, pos: BlockPos): VoxelShape =getShape(state)

    override fun getRenderShape(state: BlockState, worldIn: IBlockReader, pos: BlockPos): VoxelShape =getShape(state)


}

class WorktableTileEntity : TileEntity(worktableType.get()) {}
class WorktableTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    TileEntityRenderer<WorktableTileEntity>(dispatcher) {
    companion object {
        val model = WorktableModel()
        val texture: ResourceLocation= modResourcesLocation("textures/tile_entity/production/worktable/worktable_design2.png")
    }

    override fun render(
        tileEntityIn: WorktableTileEntity,
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

class WorktableModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val engine: ModelRenderer
    private val fixer: ModelRenderer
    private val rotated: ModelRenderer
    private val bone2: ModelRenderer
    private val bone3: ModelRenderer
    private val bone4: ModelRenderer
    private val cube_r1: ModelRenderer
    private val bone5: ModelRenderer
    private val blend: ModelRenderer
    private val bone: ModelRenderer
    private val cube_r2: ModelRenderer
    private val tools: ModelRenderer
    private val wrench: ModelRenderer
    private val bone6: ModelRenderer
    private val screwdriver: ModelRenderer
    private val placeholder: ModelRenderer

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
        fixed.setTextureOffset(0, 17).addBox(-8.0f, -8.0f, -8.0f, 12.0f, 16.0f, 16.0f, 0.0f, false)
        fixed.setTextureOffset(95, 76).addBox(21.0f, -3.0f, -7.0f, 2.0f, 1.0f, 14.0f, 0.0f, false)
        fixed.setTextureOffset(41, 93).addBox(21.0f, -16.0f, -7.0f, 2.0f, 1.0f, 14.0f, 0.0f, false)
        fixed.setTextureOffset(0, 17).addBox(21.0f, -2.0f, -7.0f, 2.0f, 10.0f, 2.0f, 0.0f, false)
        fixed.setTextureOffset(37, 56).addBox(21.0f, -15.0f, -7.0f, 2.0f, 7.0f, 2.0f, 0.0f, false)
        fixed.setTextureOffset(0, 0).addBox(21.0f, -2.0f, 5.0f, 2.0f, 10.0f, 2.0f, 0.0f, false)
        fixed.setTextureOffset(41, 17).addBox(21.0f, -15.0f, 5.0f, 2.0f, 7.0f, 2.0f, 0.0f, false)
        fixed.setTextureOffset(41, 34).addBox(4.0f, -8.0f, -8.0f, 10.0f, 5.0f, 16.0f, 0.0f, false)
        fixed.setTextureOffset(0, 50).addBox(14.0f, -8.0f, -8.0f, 10.0f, 5.0f, 16.0f, 0.0f, false)
        fixed.setTextureOffset(0, 92).addBox(20.0f, -12.5f, -8.0f, 4.0f, 1.0f, 16.0f, 0.0f, false)
        fixed.setTextureOffset(70, 77).addBox(20.0f, -18.0f, -8.0f, 4.0f, 2.0f, 16.0f, 0.0f, false)
        fixed.setTextureOffset(41, 17).addBox(-3.8284f, -22.1569f, -6.0f, 19.0f, 1.0f, 12.0f, 0.0f, false)
        fixed.setTextureOffset(0, 0).addBox(-4.8284f, -23.6569f, -7.0f, 22.0f, 2.0f, 14.0f, 0.0f, false)
        engine = ModelRenderer(this)
        engine.setRotationPoint(10.0f, 16.0f, 0.0f)
        fixed.addChild(engine)
        engine.setTextureOffset(37, 56).addBox(-6.0f, -9.0f, -8.0f, 8.0f, 1.0f, 16.0f, 0.0f, false)
        engine.setTextureOffset(0, 72).addBox(-6.0f, -14.0f, -7.0f, 7.0f, 5.0f, 14.0f, 0.0f, false)
        engine.setTextureOffset(59, 0).addBox(-5.0f, -16.0f, 1.0f, 2.0f, 2.0f, 3.0f, 0.0f, false)
        engine.setTextureOffset(59, 6).addBox(-2.0f, -15.0f, -5.0f, 2.0f, 1.0f, 3.0f, 0.0f, false)
        engine.setTextureOffset(0, 56).addBox(-6.0f, -18.0f, 1.0f, 3.0f, 2.0f, 3.0f, 0.0f, false)
        engine.setTextureOffset(91, 53).addBox(-6.0f, -17.0f, -5.0f, 6.0f, 2.0f, 3.0f, 0.0f, false)
        fixer = ModelRenderer(this)
        fixer.setRotationPoint(-1.0f, 0.0f, -0.5f)
        fixed.addChild(fixer)
        fixer.setTextureOffset(71, 59).addBox(-6.0f, -9.0f, -7.0f, 8.0f, 1.0f, 15.0f, 0.0f, false)
        fixer.setTextureOffset(78, 31).addBox(-6.0f, -10.0f, -7.0f, 6.0f, 1.0f, 15.0f, 0.0f, false)
        fixer.setTextureOffset(25, 92).addBox(-6.0f, -12.0f, 4.0f, 6.0f, 2.0f, 2.0f, 0.0f, false)
        fixer.setTextureOffset(73, 12).addBox(-6.0f, -12.0f, 0.0f, 6.0f, 2.0f, 2.0f, 0.0f, false)
        fixer.setTextureOffset(0, 62).addBox(-5.0f, -12.0f, -1.0f, 4.0f, 2.0f, 1.0f, 0.0f, false)
        fixer.setTextureOffset(70, 56).addBox(-5.0f, -12.0f, -7.0f, 4.0f, 2.0f, 2.0f, 0.0f, false)
        rotated = ModelRenderer(this)
        rotated.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixer.addChild(rotated)
        bone2 = ModelRenderer(this)
        bone2.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotated.addChild(bone2)
        bone2.setTextureOffset(40, 76).addBox(-3.5f, -11.5f, -9.0f, 1.0f, 1.0f, 8.0f, 0.0f, false)
        bone2.setTextureOffset(0, 30).addBox(-3.5f, -11.5f, -10.0f, 5.0f, 1.0f, 1.0f, 0.0f, false)
        bone3 = ModelRenderer(this)
        bone3.setRotationPoint(-3.0f, -11.0f, -5.0f)
        rotated.addChild(bone3)
        setRotationAngle(bone3, 0.0f, 0.0f, 0.7854f)
        bone3.setTextureOffset(29, 74).addBox(-0.5f, -0.5f, -4.0f, 1.0f, 1.0f, 8.0f, 0.0f, false)
        bone4 = ModelRenderer(this)
        bone4.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotated.addChild(bone4)
        cube_r1 = ModelRenderer(this)
        cube_r1.setRotationPoint(-5.0f, 0.7279f, 7.4142f)
        bone4.addChild(cube_r1)
        setRotationAngle(cube_r1, 0.7854f, 0.0f, 0.0f)
        cube_r1.setTextureOffset(0, 50).addBox(-0.5f, -10.0f, 6.0f, 5.0f, 3.0f, 2.0f, 0.0f, false)
        bone5 = ModelRenderer(this)
        bone5.setRotationPoint(0.0f, -11.0f, -5.5f)
        rotated.addChild(bone5)
        setRotationAngle(bone5, 0.0f, 0.0f, 0.7854f)
        blend = ModelRenderer(this)
        blend.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(blend)
        bone = ModelRenderer(this)
        bone.setRotationPoint(0.0f, 0.0f, 0.0f)
        blend.addChild(bone)
        cube_r2 = ModelRenderer(this)
        cube_r2.setRotationPoint(-2.6274f, -29.3137f, -8.0f)
        bone.addChild(cube_r2)
        setRotationAngle(cube_r2, 0.0f, 0.0f, 0.7854f)
        cube_r2.setTextureOffset(43, 74).addBox(18.0f, -10.0f, 0.0f, 5.0f, 2.0f, 16.0f, 0.0f, false)
        cube_r2.setTextureOffset(92, 12).addBox(23.0f, -9.5f, 1.0f, 3.0f, 1.0f, 14.0f, 0.0f, false)
        tools = ModelRenderer(this)
        tools.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(tools)
        wrench = ModelRenderer(this)
        wrench.setRotationPoint(2.0f, 0.0f, 17.0f)
        tools.addChild(wrench)
        wrench.setTextureOffset(9, 17).addBox(17.0f, -18.0f, -14.0f, 1.0f, 8.0f, 1.0f, 0.0f, false)
        wrench.setTextureOffset(0, 72).addBox(17.0f, -11.5f, -13.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        wrench.setTextureOffset(70, 67).addBox(17.0f, -11.5f, -15.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        bone6 = ModelRenderer(this)
        bone6.setRotationPoint(17.5f, -10.75f, -13.75f)
        wrench.addChild(bone6)
        setRotationAngle(bone6, 0.0f, 0.0f, 0.7854f)
        bone6.setTextureOffset(9, 10).addBox(-0.5f, -0.5f, -0.75f, 1.0f, 1.0f, 1.0f, 0.0f, false)
        screwdriver = ModelRenderer(this)
        screwdriver.setRotationPoint(0.0f, 0.0f, 2.25f)
        tools.addChild(screwdriver)
        screwdriver.setTextureOffset(70, 61).addBox(18.5f, -17.0f, -2.5f, 1.0f, 4.0f, 1.0f, 0.0f, false)
        screwdriver.setTextureOffset(70, 61).addBox(18.5f, -17.0f, -3.0f, 1.0f, 4.0f, 1.0f, 0.0f, false)
        screwdriver.setTextureOffset(46, 56).addBox(18.75f, -13.0f, -2.75f, 1.0f, 4.0f, 1.0f, 0.0f, false)
        screwdriver.setTextureOffset(70, 61).addBox(19.0f, -17.0f, -2.5f, 1.0f, 4.0f, 1.0f, 0.0f, false)
        screwdriver.setTextureOffset(70, 61).addBox(19.0f, -17.0f, -3.0f, 1.0f, 4.0f, 1.0f, 0.0f, false)
        placeholder = ModelRenderer(this)
        placeholder.setRotationPoint(0.0f, 0.0f, 0.0f)
        tools.addChild(placeholder)
        placeholder.setTextureOffset(9, 0).addBox(19.0f, -18.0f, -4.0f, 1.0f, 8.0f, 1.0f, 0.0f, false)
    }
}
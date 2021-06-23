package com.github.malayP.decorations.block.machine.relay


import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.bevelGearType
import com.github.zomb_676.fantasySoup.block.AllFaceBlockWithTileEntity
import com.github.zomb_676.fantasySoup.block.FourSide
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
import net.minecraft.item.BlockItemUseContext
import net.minecraft.state.StateContainer
import net.minecraft.state.properties.BlockStateProperties
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.Direction.*
import net.minecraft.util.math.vector.Vector3f
import net.minecraft.world.IBlockReader


class BevelGear : AllFaceBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = BevelGearTileEntity()
    override fun fillStateContainer(builder: StateContainer.Builder<Block, BlockState>) {
        super.fillStateContainer(builder.add(FourSide.fourSides))
    }

    override fun getStateForPlacement(context: BlockItemUseContext): BlockState? {
        val state = super.getStateForPlacement(context)!!
        return when (state.get(BlockStateProperties.FACING)!!) {
            UP -> state.with(FourSide.fourSides, FourSide.DOWN)
            else -> state.with(FourSide.fourSides, FourSide.UP)
        }
    }

}

class BevelGearTileEntity : TileEntity(bevelGearType.get()) {

}

class BevelGearTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    TileEntityRenderer<BevelGearTileEntity>(dispatcher) {
    companion object {
        val model = BevelGearModel()
        val texture = modResourcesLocation("textures/tile_entity/transmission/bevel_gear/bevel_gear.png")
    }

    override fun render(
        tileEntityIn: BevelGearTileEntity,
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
        val blockState = tileEntityIn.blockState
        when (blockState.get(BlockStateProperties.FACING)!!) {
            DOWN -> {
            }
            UP -> {
            }
            NORTH -> when (blockState.get(FourSide.fourSides)!!) {
                FourSide.UP -> matrixStackIn.rotate(Vector3f.ZN.rotationDegrees(90f))
                FourSide.DOWN -> matrixStackIn.rotate(Vector3f.ZN.rotationDegrees(-90f))
                FourSide.LEFT -> {
                }
                FourSide.RIGHT -> matrixStackIn.rotate(Vector3f.ZN.rotationDegrees(180f))
            }
            SOUTH -> when (blockState.get(FourSide.fourSides)!!) {
                FourSide.UP -> matrixStackIn.rotate(Vector3f.ZN.rotationDegrees(90f))
                FourSide.DOWN -> {
                }
                FourSide.LEFT -> {
                }
                FourSide.RIGHT -> {
                }
            }
            WEST -> when (blockState.get(FourSide.fourSides)!!) {
                FourSide.UP -> matrixStackIn.rotate(Vector3f.ZN.rotationDegrees(90f))
                FourSide.DOWN -> {
                }
                FourSide.LEFT -> {
                }
                FourSide.RIGHT -> {
                }
            }
            EAST -> {
            }
        }
//        val f: Float =
//            if (tileEntityIn.world != null) tileEntityIn.blockState.get(BlockStateProperties.HORIZONTAL_FACING).horizontalAngle else 90f
//        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f))
        model.render(matrixStackIn, buffer, combinedLightIn, combinedOverlayIn, 1f, 1f, 1f, 1f)
        matrixStackIn.pop()
    }
}

class BevelGearModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val rotateable: ModelRenderer
    private val part1: ModelRenderer
    private val pos1: ModelRenderer
    private val rot1: ModelRenderer
    private val part2: ModelRenderer
    private val pos2: ModelRenderer
    private val rot2: ModelRenderer
    private val fixed: ModelRenderer

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
        shell.setRotationPoint(0.0f, 24.0f, 0.0f)
        rotateable = ModelRenderer(this)
        rotateable.setRotationPoint(0.0f, -8.0f, 0.0f)
        shell.addChild(rotateable)
        part1 = ModelRenderer(this)
        part1.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotateable.addChild(part1)
        pos1 = ModelRenderer(this)
        pos1.setRotationPoint(0.0f, 0.0f, 0.0f)
        part1.addChild(pos1)
        pos1.setTextureOffset(34, 34).addBox(-1.0f, -1.0f, 3.5f, 2.0f, 2.0f, 5.0f, 0.0f, false)
        pos1.setTextureOffset(33, 4).addBox(-3.0f, -3.0f, 3.0f, 6.0f, 6.0f, 1.0f, 0.0f, false)
        pos1.setTextureOffset(47, 9).addBox(-2.0f, -2.0f, 2.0f, 4.0f, 4.0f, 1.0f, 0.0f, false)
        rot1 = ModelRenderer(this)
        rot1.setRotationPoint(0.0f, 0.0f, 0.0f)
        part1.addChild(rot1)
        setRotationAngle(rot1, 0.0f, 0.0f, 0.7854f)
        rot1.setTextureOffset(32, 22).addBox(-1.0f, -1.0f, 3.5f, 2.0f, 2.0f, 5.0f, 0.0f, false)
        rot1.setTextureOffset(32, 15).addBox(-3.0f, -3.0f, 3.01f, 6.0f, 6.0f, 1.0f, 0.0f, false)
        rot1.setTextureOffset(47, 4).addBox(-2.0f, -2.0f, 2.01f, 4.0f, 4.0f, 1.0f, 0.0f, false)
        part2 = ModelRenderer(this)
        part2.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotateable.addChild(part2)
        pos2 = ModelRenderer(this)
        pos2.setRotationPoint(0.0f, 0.0f, 0.0f)
        part2.addChild(pos2)
        pos2.setTextureOffset(44, 41).addBox(3.5f, -1.0f, -1.0f, 5.0f, 2.0f, 2.0f, 0.0f, false)
        pos2.setTextureOffset(44, 30).addBox(2.0f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        pos2.setTextureOffset(17, 0).addBox(3.0f, -3.0f, -3.0f, 1.0f, 6.0f, 6.0f, 0.0f, false)
        rot2 = ModelRenderer(this)
        rot2.setRotationPoint(0.0f, 0.0f, 0.0f)
        part2.addChild(rot2)
        setRotationAngle(rot2, -0.7854f, 0.0f, 0.0f)
        rot2.setTextureOffset(34, 30).addBox(3.5f, -1.0f, -1.0f, 5.0f, 2.0f, 2.0f, 0.0f, false)
        rot2.setTextureOffset(38, 41).addBox(1.99f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        rot2.setTextureOffset(0, 0).addBox(2.99f, -3.0f, -3.0f, 1.0f, 6.0f, 6.0f, 0.0f, false)
        fixed = ModelRenderer(this)
        fixed.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(fixed)
        fixed.setTextureOffset(33, 2).addBox(-7.0f, -1.0f, -8.0f, 14.0f, 1.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(32, 15).addBox(-8.0f, -1.0f, -7.0f, 1.0f, 1.0f, 14.0f, 0.0f, false)
        fixed.setTextureOffset(33, 0).addBox(-7.0f, -16.0f, -8.0f, 14.0f, 1.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(34, 41).addBox(-8.0f, -16.0f, -8.0f, 1.0f, 16.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(17, 0).addBox(-8.0f, -16.0f, -7.0f, 1.0f, 1.0f, 14.0f, 0.0f, false)
        fixed.setTextureOffset(0, 31).addBox(-8.0f, -16.0f, 7.0f, 16.0f, 16.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(0, 0).addBox(7.0f, -16.0f, -8.0f, 1.0f, 16.0f, 15.0f, 0.0f, false)
    }
}
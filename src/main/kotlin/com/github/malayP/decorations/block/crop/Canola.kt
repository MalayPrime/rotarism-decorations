package com.github.malayP.decorations.block.crop

import com.github.malayP.decorations.register.AllBlocks
import com.github.zomb_676.fantasySoup.dataGen.IDataHandle
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.CropsBlock
import net.minecraft.block.material.Material
import net.minecraft.state.IntegerProperty
import net.minecraft.state.StateContainer
import net.minecraft.util.IItemProvider
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.shapes.ISelectionContext
import net.minecraft.util.math.shapes.VoxelShape
import net.minecraft.util.math.shapes.VoxelShapes
import net.minecraft.world.IBlockReader
import net.minecraft.world.server.ServerWorld
import net.minecraftforge.client.model.generators.BlockStateProvider
import net.minecraftforge.client.model.generators.ConfiguredModel
import net.minecraftforge.common.ForgeHooks
import java.util.*

class Canola : CropsBlock(Properties.create(Material.PLANTS).notSolid()) {
    companion object {
        val growStage: IntegerProperty = IntegerProperty.create(
            "stage",
            0,
            5
        ) // extends from CropsBlock , so must start from zero , see CropBlock's constructor
        val model: (IDataHandle) -> Lazy<(BlockStateProvider) -> Unit> = { handle: IDataHandle ->
            lazy {
                handle.dataHandle.variantBlockState(AllBlocks.canola.block) {
                    forAllStates { state ->
                        ConfiguredModel.builder()
                            .modelFile(CropModels.CanolaCrop.getCombineModelFromState(state).value)
                            .build()
                    }
                }
            }
        }
    }

    init {
        defaultState = defaultState.with(growStage, 0)
    }

    override fun fillStateContainer(builder: StateContainer.Builder<Block, BlockState>) {
        builder.add(growStage)
    }

    override fun getAge(state: BlockState): Int = state.get(growStage)

    override fun getMaxAge(): Int = 5

    override fun withAge(targetAge: Int): BlockState = defaultState.with(growStage, targetAge)

    override fun getAgeProperty(): IntegerProperty = growStage

    override fun randomTick(state: BlockState, worldIn: ServerWorld, pos: BlockPos, random: Random) {
        if (!worldIn.isAreaLoaded(
                pos,
                1
            )
        ) {
            return
        }
        if (worldIn.getLightSubtracted(pos, 0) >= 9) {
            val i: Int = this.getAge(state)
            if (i < this.maxAge) {
                val f = getGrowthChance(this, worldIn, pos)
                if (ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt((25.0f / f).toInt() + 1) == 0)) {
                    worldIn.setBlockState(pos, this.withAge(i + 1), 2)
                    ForgeHooks.onCropsGrowPost(worldIn, pos, state)
                }
            }
        }
    }

    override fun getSeedsItem(): IItemProvider = AllBlocks.canola.item.get()

    override fun getCollisionShape(
        state: BlockState, worldIn: IBlockReader, pos: BlockPos, context: ISelectionContext
    ): VoxelShape = VoxelShapes.empty()

}
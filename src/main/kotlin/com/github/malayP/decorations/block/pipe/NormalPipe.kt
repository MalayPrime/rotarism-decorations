package com.github.malayP.decorations.block.pipe

import com.github.malayP.decorations.block.pipe.PipeConnectState.*
import com.github.malayP.decorations.block.pipe.PipeModels.Transparent.air
import com.github.malayP.decorations.block.pipe.PipeModels.Transparent.container
import com.github.malayP.decorations.block.pipe.PipeModels.Transparent.noConnect
import com.github.malayP.decorations.block.pipe.PipeModels.Transparent.pipe
import com.github.malayP.decorations.register.AllBlocks
import com.github.zomb_676.fantasySoup.autoRotation
import com.github.zomb_676.fantasySoup.dataGen.IDataHandle
import com.github.zomb_676.fantasySoup.toProperties
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.material.Material
import net.minecraft.item.BlockItemUseContext
import net.minecraft.state.EnumProperty
import net.minecraft.state.StateContainer
import net.minecraft.util.Direction
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IWorld
import net.minecraftforge.client.model.generators.BlockStateProvider

class NormalPipe : Block(Properties.create(Material.IRON).notSolid()) {
    companion object {
        private val propertyMap: Map<Direction, EnumProperty<PipeConnectState>> =
            Direction.values().associateWith { PipeConnectState.pipeConnectState }
        private val property = propertyMap.keys.zip(propertyMap.toProperties()).toMap()
        val TransparentModel: (IDataHandle) -> Lazy<(BlockStateProvider) -> Unit> = { handle: IDataHandle ->
            lazy {
                handle.dataHandle.multiPartBlockState(AllBlocks.normalPipe.block) {
                    property.forEach { (direction, property) ->
                        part().modelFile(noConnect.value).autoRotation(direction)
                            .addModel().condition(property, NO_CONNECT).end()
                            .part().modelFile(pipe.value).autoRotation(direction)
                            .addModel().condition(property, PIPE).end()
                            .part().modelFile(air.value).autoRotation(direction)
                            .addModel().condition(property, AIR).end()
                            .part().modelFile(container.value).autoRotation(direction).addModel()
                            .condition(property, CONTAINER).end()
                    }
                }
            }
        }
    }

    override fun fillStateContainer(builder: StateContainer.Builder<Block, BlockState>) {
        builder.add(*property.values.toTypedArray())
    }

    init {
        var state = defaultState
        property.values.map { state = state.with(it, NO_CONNECT) }
        this.defaultState = state
    }

    override fun getStateForPlacement(context: BlockItemUseContext): BlockState? {
        var state = defaultState
        property.map { (direction, property) ->
            val world = context.world
            val pos = context.pos.offset(direction)
            val facingState = world.getBlockState(pos)
            val pipeState = PipeConnectState.getConnectStateFromBlockState(facingState)
            state = state.with(property, pipeState)
        }
        return state
    }

    override fun updatePostPlacement(
        stateIn: BlockState,
        facing: Direction,
        facingState: BlockState,
        worldIn: IWorld,
        currentPos: BlockPos,
        facingPos: BlockPos
    ): BlockState {
        return stateIn.with(property[facing], PipeConnectState.getConnectStateFromBlockState(facingState))
    }


}
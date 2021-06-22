package com.github.malayP.decorations.block.pipe

import net.minecraft.block.AirBlock
import net.minecraft.block.BlockState
import net.minecraft.block.ChestBlock
import net.minecraft.state.EnumProperty
import net.minecraft.util.IStringSerializable

enum class PipeConnectState(private val state: String) : IStringSerializable {
    NO_CONNECT("no_connect"),
    PIPE("pipe"),
    AIR("air"),
    CONTAINER("container");

    override fun toString(): String = this.string
    override fun getString(): String = state

    companion object {
        val pipeConnectState: EnumProperty<PipeConnectState> = EnumProperty
            .create("pipe_connect_state", PipeConnectState::class.java, NO_CONNECT, PIPE, AIR, CONTAINER)

        fun getConnectStateFromBlockState(state: BlockState): PipeConnectState {
            return when (state.block) {
                is AirBlock -> NO_CONNECT
                is NormalPipe -> PIPE
                is ChestBlock -> CONTAINER // just for test
                else -> NO_CONNECT
            }
        }
    }

}
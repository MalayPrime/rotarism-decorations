package com.github.malayP.decorations.block.machine.engine

import net.minecraft.tileentity.TileEntity
import net.minecraft.tileentity.TileEntityType

abstract class EngineTileEntity(tileEntityTypeIn: TileEntityType<*>) : TileEntity(tileEntityTypeIn) {
    abstract fun canProduceEnergy(): Boolean
    abstract fun getOutputTorque(): Int
    abstract fun getOutputSpeed(): Int

    var isWorking = false
}

class EnergySource constructor() : MutableList<EngineTileEntity> by mutableListOf() {
    constructor(engine: EngineTileEntity) : this() {
        this.add(engine)
    }

    override fun toString(): String {
        if (isEmpty()) return "no energy source"
        val stringBuilder = StringBuilder().append("[")
        this.map {
            stringBuilder.append(it.type.registryName)
                .append(":{")
                .append("torque").append(":").append(it.getOutputTorque())
                .append(",")
                .append("speed").append(":").append(it.getOutputSpeed())
                .append("}")
                .append("\n")
        }
        stringBuilder.deleteCharAt(stringBuilder.length - 1).append("]")
        return stringBuilder.toString()
    }
}
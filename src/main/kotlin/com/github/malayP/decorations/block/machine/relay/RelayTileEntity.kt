package com.github.malayP.decorations.block.machine.relay

import com.github.malayP.decorations.block.machine.Detectable
import com.github.malayP.decorations.block.machine.engine.EnergySource
import com.github.zomb_676.fantasySoup.safeReturn
import net.minecraft.client.renderer.model.Model
import net.minecraft.tileentity.TileEntity
import net.minecraft.tileentity.TileEntityType
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.api.distmarker.OnlyIn

abstract class RelayTileEntity(tileEntityTypeIn: TileEntityType<*>) : TileEntity(tileEntityTypeIn), Detectable {
    @OnlyIn(Dist.CLIENT)
    var torque: Int = 0

    @OnlyIn(Dist.CLIENT)
    var speed: Int = 0

    @OnlyIn(Dist.CLIENT)
    val model: Model? = null

    var energySource: EnergySource? = null
    //TODO update energy system after this is destroyed
    //TODO detect input data when place this block

    override fun getDetectorUseInfo(): String = "Status : torque : ${torque}N/m , speed : ${speed}rad/s ," +
            " \nEnergySource : ${energySource?.toString()?.safeReturn { "unbind" }}"
}
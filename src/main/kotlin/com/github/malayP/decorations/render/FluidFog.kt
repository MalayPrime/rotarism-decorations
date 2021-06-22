package com.github.malayP.decorations.render

import com.github.malayP.decorations.register.AllBlocks
import com.github.malayP.decorations.register.AllFluid.jetFuelLiquid
import com.github.malayP.decorations.register.AllFluid.lubricantLiquid
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.client.event.EntityViewRenderEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber(Dist.CLIENT,bus = Mod.EventBusSubscriber.Bus.FORGE)
object FluidFog {
    @JvmStatic
    @SubscribeEvent
    fun waterFogSet(event: EntityViewRenderEvent.FogColors) {
        val blockState = event.info.fluidState.blockState
        when (blockState.fluidState.fluid) {
            lubricantLiquid.still.get(), lubricantLiquid.flowing.get() -> setRGB(event, 187, 202, 160)
            jetFuelLiquid.still.get(), jetFuelLiquid.flowing.get() -> setRGB(event, 198, 138, 171)
            AllBlocks.alcohol.get() -> {
            }
        }

    }

    private fun setRGB(event: EntityViewRenderEvent.FogColors, red: Int, green: Int, blue: Int) {
        event.red = red.toFloat() / 255
        event.green = green.toFloat() / 255
        event.blue = blue.toFloat() / 255
    }

}
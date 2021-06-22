package com.github.malayP.decorations.register

import net.minecraft.client.renderer.RenderType

@Suppress("MemberVisibilityCanBePrivate")
object AllFluid {
    val liquid = RegisterCenter.registerHandleInstance.registerFluid()
    val alcoholLiquid = liquid.fluid("alcohol", "block/alcohol/alcohol_still", "block/alcohol/alcohol_flow", {
        density(3)
    }, {
        block { AllBlocks.alcohol.get() }
    })
        .blindRenderType{{RenderType.getTranslucent()}}

    val lubricantLiquid =
        liquid.fluid("lubricant", "block/lubricant/lubricant_still", "block/lubricant/lubricant_flow", {
            density(3)
        }, {
            block { AllBlocks.lubricant.get() }
        }).blindRenderType{{RenderType.getTranslucent()}}

    val jetFuelLiquid = liquid.fluid("jet_fuel", "block/jet_fuel/jet_fuel_still", "block/jet_fuel/jet_fuel_flow", {
        density(3)
    }, {
        block { AllBlocks.jetFuel.get() }
    }).blindRenderType{{RenderType.getTranslucent()}}
}

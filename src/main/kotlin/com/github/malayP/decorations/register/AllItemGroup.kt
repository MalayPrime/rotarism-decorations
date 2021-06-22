package com.github.malayP.decorations.register

import com.github.malayP.decorations.Decorations
import com.github.malayP.decorations.register.RegisterCenter.registerHandleInstance
import net.minecraft.item.Items

object AllItemGroup {
    init {
        Decorations.logger.info("item group added")
    }

    val transformersGroup = registerHandleInstance.itemGroup("transformers", Items.DIAMOND)
    val generatorsGroup = registerHandleInstance.itemGroup("generators", Items.DIAMOND)
    val machinesGroup = registerHandleInstance.itemGroup("machines", Items.DIAMOND)
    val materialGroup = registerHandleInstance.itemGroup("materials", Items.IRON_INGOT)
    val toolsGroup = registerHandleInstance.itemGroup("tools", Items.DIAMOND_PICKAXE)
    val crops = registerHandleInstance.itemGroup("crops", Items.WHEAT)
}
package com.github.malayP.decorations.register

import com.github.malayP.decorations.Decorations
import com.github.malayP.decorations.register.RegisterCenter.registerHandleInstance
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items

object AllItemGroup {
    init {
        Decorations.logger.info("item group added")
    }
    val decorations = object :ItemGroup("decorations"){
        override fun createIcon(): ItemStack =
            ItemStack(AllBlocks.hydrokineticEngineBlock.item.get())
    }

}
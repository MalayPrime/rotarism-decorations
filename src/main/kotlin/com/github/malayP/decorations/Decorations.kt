package com.github.malayP.decorations

import com.github.malayP.decorations.register.RegisterCenter
import com.github.zomb_676.fantasySoup.manuallyInitClass
import com.github.zomb_676.fantasySoup.register.RegisterHandle
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.RegistryObject
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent
import net.minecraftforge.registries.DeferredRegister
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import java.io.File

@Mod(Decorations.modId)
class Decorations {

    init {
        RegisterCenter::class.manuallyInitClass()
    }

    companion object {
        const val modId = "decorations"
        const val modName = "Decorations"
        val logger: Logger = LogManager.getLogger(modName)
    }

}
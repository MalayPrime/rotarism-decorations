package com.github.malayP.decorations.register

import com.github.malayP.decorations.Decorations
import com.github.zomb_676.fantasySoup.manuallyInitClass
import com.github.zomb_676.fantasySoup.register.RegisterHandle
import net.minecraft.util.ResourceLocationException
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext


object RegisterCenter {
    val registerHandleInstance = RegisterHandle.getInstance(Decorations.modId)

    init {
        registerHandleInstance.registerAllRegistersToEvent(FMLJavaModLoadingContext.get().modEventBus)
        try {
            AllItemGroup::class.manuallyInitClass()
            Decorations.logger.info("adding itemGroup to handle , ${AllItemGroup::class::simpleName.get()} loaded")
            AllBlocks::class.manuallyInitClass()
            Decorations.logger.info("adding blocks to handle , ${AllBlocks::class::simpleName.get()} loaded")
            AllItems::class.manuallyInitClass()
            Decorations.logger.info("adding items to handle , ${AllItems::class::simpleName.get()} loaded")
            AllTileEntity::class.manuallyInitClass()
            Decorations.logger.info("adding tileEntity and render to handle , ${AllTileEntity::class::simpleName.get()} loaded")
            AllFluid::class.manuallyInitClass()
            Decorations.logger.info("fluid")
        } catch (e: ResourceLocationException) {
            Decorations.logger.fatal("error resource location : ${e.cause}")
            throw e
        }
    }
}



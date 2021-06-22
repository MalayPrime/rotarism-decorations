package com.github.malayP.decorations.dataGen

import com.github.malayP.decorations.Decorations
import com.github.malayP.decorations.register.RegisterCenter
import com.github.zomb_676.fantasySoup.dataGen.IDataHandle
import com.github.zomb_676.fantasySoup.manuallyInitClass
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
object DataGenCenter : IDataHandle(Decorations.modId) {
    init {
        Decorations.logger.info("DataHandleCenter init")
        RegisterCenter::class.manuallyInitClass()
    }

    @SubscribeEvent
    @JvmStatic
    fun dataGen(event: GatherDataEvent) {
        dataHandle.init(event)
        toInitTask.forEach { it.invoke() }
    }
//
//    @SubscribeEvent
//    @JvmStatic
//    //TODO add support for setRenderType at RegisterSystem
//    fun setRenderType(event:FMLClientSetupEvent){
//        event.enqueueWork {
//            RenderTypeLookup.setRenderLayer(
//                AllBlocks.normalPipe.block.get(),
//                RenderType.getTranslucent()
//            )
//            RenderTypeLookup.setRenderLayer(
//                AllBlocks.canola.block.get(),
//                RenderType.getTranslucent()
//            )
//        }
//
//    }

}
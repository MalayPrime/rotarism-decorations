package com.github.malayP.decorations

import com.github.malayP.decorations.register.RegisterCenter
import com.github.zomb_676.fantasySoup.manuallyInitClass
import net.minecraftforge.fml.common.Mod
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
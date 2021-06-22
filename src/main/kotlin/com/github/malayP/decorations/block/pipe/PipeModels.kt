package com.github.malayP.decorations.block.pipe

import com.github.malayP.decorations.dataGen.DataGenCenter

object PipeModels {
    val helper = DataGenCenter.ModelChecker("block/pipe")

    object Transparent {
        val air = helper.set("air_transparent")
        val container = helper.set("container_transparent")
        val noConnect = helper.set("no_connect_transparent")
        val pipe = helper.set("pipe_transparent")
    }

    object Opaque {
        val air = helper.set("air_opaque")
        val container = helper.set("container_opaque")
        val noConnect = helper.set("no_connect_opaque")
        val pipe = helper.set("pipe_opaque")
    }

    object Generic {

    }
}


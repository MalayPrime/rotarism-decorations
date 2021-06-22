package com.github.malayP.decorations.block.crop

import com.github.malayP.decorations.dataGen.DataGenCenter
import net.minecraft.block.BlockState
import net.minecraftforge.client.model.generators.ModelFile

object CropModels {
    val helper = DataGenCenter.ModelChecker("block/canola_crop")

    object CanolaCrop {
        val stage1 = helper.set("canola_crop_stage_1")
        val stage2 = helper.set("canola_crop_stage_2")
        val stage3 = helper.set("canola_crop_stage_3")
        val stage4 = helper.set("canola_crop_stage_4")
        val stage5 = helper.set("canola_crop_stage_5")
        val stage6 = helper.set("canola_crop_stage_6")
        fun getCombineModelFromState(blockState: BlockState): Lazy<ModelFile.ExistingModelFile> =
            when (blockState.get(Canola.growStage)) {
                0 -> stage1
                1 -> stage2
                2 -> stage3
                3 -> stage4
                4 -> stage5
                5 -> stage6
                else -> throw RuntimeException("canola grow stage only ranges from 0 to 5")
            }
    }
}
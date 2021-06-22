package com.github.malayP.decorations.specification.items.tools

import com.github.malayP.decorations.block.machine.Detectable
import com.github.malayP.decorations.register.AllItemGroup
import net.minecraft.item.Item
import net.minecraft.item.ItemUseContext
import net.minecraft.util.ActionResultType
import net.minecraft.util.Util
import net.minecraft.util.text.StringTextComponent
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.api.distmarker.OnlyIn


class Detector : Item(Properties().group(AllItemGroup.toolsGroup)) {

    @OnlyIn(Dist.CLIENT)
    override fun onItemUse(context: ItemUseContext): ActionResultType {
        if (!context.world.isRemote) {
            context.world.getTileEntity(context.rayTraceResult.pos)?.takeIf { it is Detectable }?.apply {
                context.player?.sendMessage(
                    StringTextComponent((this as Detectable).getDetectorUseInfo()),
                    Util.DUMMY_UUID
                )
            }
        }
        return ActionResultType.CONSUME
    }
}
package com.github.malayP.decorations

import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraft.state.properties.BlockStateProperties
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.vector.Vector3f

fun modResourcesLocation(path: String) = ResourceLocation(Decorations.modId, path)

inline fun MatrixStack.newStack(block: () -> Unit) {
    this.push()
    block()
    this.pop()
}

inline fun MatrixStack.HorizonRotate(tileEntityIn: TileEntity, block: () -> Unit) {
    newStack {
        scale(1f, -1f, -1f)
        translate(0.5, -1.5, -0.5)
        val f: Float =
            if (tileEntityIn.world != null) tileEntityIn.blockState.get(BlockStateProperties.HORIZONTAL_FACING).horizontalAngle else 90f
        rotate(Vector3f.YP.rotationDegrees(f))
    }
}
package com.github.malayP.decorations.block.machine.consumer

import com.github.malayP.decorations.register.AllTileEntity.centrifugeType
import com.github.zomb_676.fantasySoup.block.BlockWithTileEntity
import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.IRenderTypeBuffer
import net.minecraft.client.renderer.tileentity.TileEntityRenderer
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher
import net.minecraft.tileentity.TileEntity

class Centrifuge : BlockWithTileEntity(Properties.create(Material.IRON)) {

}

class CentrifugeTileEntity : TileEntity(centrifugeType.get())

class CentrifugeTileEntityRender(dispatcher: TileEntityRendererDispatcher) : TileEntityRenderer<CentrifugeTileEntity>(
    dispatcher
) {
    override fun render(
        tileEntityIn: CentrifugeTileEntity,
        partialTicks: Float,
        matrixStackIn: MatrixStack,
        bufferIn: IRenderTypeBuffer,
        combinedLightIn: Int,
        combinedOverlayIn: Int,
    ) {
        TODO("Not yet implemented")
    }


}
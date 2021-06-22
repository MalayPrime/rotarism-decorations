package com.github.malayP.decorations.block.machine.relay


import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.chainDriveType
import com.github.zomb_676.fantasySoup.block.HorizonBlockWithTileEntity
import com.mojang.blaze3d.matrix.MatrixStack
import com.mojang.blaze3d.vertex.IVertexBuilder
import net.minecraft.block.BlockState
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.IRenderTypeBuffer
import net.minecraft.client.renderer.RenderType
import net.minecraft.client.renderer.model.Model
import net.minecraft.client.renderer.model.ModelRenderer
import net.minecraft.client.renderer.tileentity.TileEntityRenderer
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher
import net.minecraft.state.properties.BlockStateProperties
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.math.vector.Vector3f
import net.minecraft.world.IBlockReader


class ChainDrive : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = ChainDriveTileEntity()
}

class ChainDriveTileEntity : TileEntity(chainDriveType.get()) {

}

class ChainDriveTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    TileEntityRenderer<ChainDriveTileEntity>(dispatcher) {
    companion object {
        val model = ChainDriveModel()
        val texture = modResourcesLocation("textures/tile_entity/transmission/chain_drive/chain_drive.png")
    }

    override fun render(
        tileEntityIn: ChainDriveTileEntity,
        partialTicks: Float,
        matrixStackIn: MatrixStack,
        bufferIn: IRenderTypeBuffer,
        combinedLightIn: Int,
        combinedOverlayIn: Int,
    ) {
        matrixStackIn.push()
        val renderType = RenderType.getEntityTranslucent(texture)
        val buffer = bufferIn.getBuffer(renderType)
        matrixStackIn.scale(1f, -1f, -1f)
        matrixStackIn.translate(0.5, -1.5, -0.5)
        val f: Float =
            if (tileEntityIn.world != null) tileEntityIn.blockState.get(BlockStateProperties.HORIZONTAL_FACING).horizontalAngle else 90f
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f))
        model.render(matrixStackIn, buffer, combinedLightIn, combinedOverlayIn, 1f, 1f, 1f, 1f)
        matrixStackIn.pop()
    }
}

class ChainDriveModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val pos2: ModelRenderer
    private val rot2: ModelRenderer
    private val rotatable: ModelRenderer
    private val pos: ModelRenderer
    private val rot: ModelRenderer
    private val plate: ModelRenderer
    private val bone: ModelRenderer
    private val bone2: ModelRenderer
    private val bone3: ModelRenderer
    private val bone4: ModelRenderer
    private val bone5: ModelRenderer
    private val bone6: ModelRenderer
    private val bone7: ModelRenderer
    private val bone8: ModelRenderer

    override fun render(
        matrixStack: MatrixStack,
        buffer: IVertexBuilder,
        packedLight: Int,
        packedOverlay: Int,
        red: Float,
        green: Float,
        blue: Float,
        alpha: Float
    ) {
        shell.render(matrixStack, buffer, packedLight, packedOverlay)
    }

    fun setRotationAngle(modelRenderer: ModelRenderer, x: Float, y: Float, z: Float) {
        modelRenderer.rotateAngleX = x
        modelRenderer.rotateAngleY = y
        modelRenderer.rotateAngleZ = z
    }

    init {
        textureWidth = 128
        textureHeight = 128
        shell = ModelRenderer(this)
        shell.setRotationPoint(0.0f, 16.0f, 0.0f)
        fixed = ModelRenderer(this)
        fixed.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(fixed)
        pos2 = ModelRenderer(this)
        pos2.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(pos2)
        pos2.setTextureOffset(0, 21).addBox(-8.0f, -8.0f, -8.0f, 16.0f, 16.0f, 4.0f, 0.0f, false)
        pos2.setTextureOffset(0, 0).addBox(-8.0f, -8.0f, 4.0f, 16.0f, 16.0f, 4.0f, 0.0f, false)
        pos2.setTextureOffset(46, 24).addBox(-5.0f, -5.0f, 3.0f, 10.0f, 10.0f, 1.0f, 0.0f, false)
        pos2.setTextureOffset(23, 45).addBox(-5.0f, -5.0f, -4.0f, 10.0f, 10.0f, 1.0f, 0.0f, false)
        rot2 = ModelRenderer(this)
        rot2.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(rot2)
        setRotationAngle(rot2, 0.0f, 0.0f, 0.7854f)
        rot2.setTextureOffset(46, 46).addBox(-5.0f, -5.0f, 3.05f, 10.0f, 10.0f, 1.0f, 0.0f, false)
        rot2.setTextureOffset(0, 42).addBox(-5.0f, -5.0f, -4.05f, 10.0f, 10.0f, 1.0f, 0.0f, false)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        pos = ModelRenderer(this)
        pos.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(pos)
        pos.setTextureOffset(37, 4).addBox(-1.0f, -1.0f, -8.5f, 2.0f, 2.0f, 17.0f, 0.0f, false)
        rot = ModelRenderer(this)
        rot.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(rot)
        setRotationAngle(rot, 0.0f, 0.0f, 0.7854f)
        rot.setTextureOffset(24, 25).addBox(-1.0f, -1.0f, -8.5f, 2.0f, 2.0f, 17.0f, 0.0f, false)
        plate = ModelRenderer(this)
        plate.setRotationPoint(0.0f, 0.625f, 0.0f)
        rotatable.addChild(plate)
        bone = ModelRenderer(this)
        bone.setRotationPoint(0.0f, 0.0f, 0.0f)
        plate.addChild(bone)
        bone.setTextureOffset(0, 63).addBox(-1.5f, 2.0f, -3.55f, 3.0f, 1.0f, 7.0f, 0.0f, false)
        bone2 = ModelRenderer(this)
        bone2.setRotationPoint(0.0f, 0.0f, 0.0f)
        plate.addChild(bone2)
        setRotationAngle(bone2, 0.0f, 0.0f, 0.7854f)
        bone2.setTextureOffset(62, 29).addBox(-1.9393f, 2.182f, -3.45f, 3.0f, 1.0f, 7.0f, 0.0f, false)
        bone3 = ModelRenderer(this)
        bone3.setRotationPoint(0.0f, 0.0f, 0.0f)
        plate.addChild(bone3)
        setRotationAngle(bone3, 0.0f, 0.0f, 1.5708f)
        bone3.setTextureOffset(59, 9).addBox(-2.1213f, 2.6213f, -3.55f, 3.0f, 1.0f, 7.0f, 0.0f, false)
        bone4 = ModelRenderer(this)
        bone4.setRotationPoint(0.0f, 0.0f, 0.0f)
        plate.addChild(bone4)
        setRotationAngle(bone4, 0.0f, 0.0f, 2.3562f)
        bone4.setTextureOffset(59, 0).addBox(-1.9393f, 3.0607f, -3.45f, 3.0f, 1.0f, 7.0f, 0.0f, false)
        bone5 = ModelRenderer(this)
        bone5.setRotationPoint(0.0f, 0.0f, 0.0f)
        plate.addChild(bone5)
        setRotationAngle(bone5, 0.0f, 0.0f, -3.1416f)
        bone5.setTextureOffset(56, 58).addBox(-1.5f, 3.2426f, -3.55f, 3.0f, 1.0f, 7.0f, 0.0f, false)
        bone6 = ModelRenderer(this)
        bone6.setRotationPoint(0.0f, 0.0f, 0.0f)
        plate.addChild(bone6)
        setRotationAngle(bone6, 0.0f, 0.0f, -2.3562f)
        bone6.setTextureOffset(35, 58).addBox(-1.0607f, 3.0607f, -3.45f, 3.0f, 1.0f, 7.0f, 0.0f, false)
        bone7 = ModelRenderer(this)
        bone7.setRotationPoint(0.0f, 0.0f, 0.0f)
        plate.addChild(bone7)
        setRotationAngle(bone7, 0.0f, 0.0f, -1.5708f)
        bone7.setTextureOffset(14, 57).addBox(-0.8787f, 2.6213f, -3.55f, 3.0f, 1.0f, 7.0f, 0.0f, false)
        bone8 = ModelRenderer(this)
        bone8.setRotationPoint(0.0f, 0.0f, 0.0f)
        plate.addChild(bone8)
        setRotationAngle(bone8, 0.0f, 0.0f, -0.7854f)
        bone8.setTextureOffset(0, 54).addBox(-1.0607f, 2.182f, -3.45f, 3.0f, 1.0f, 7.0f, 0.0f, false)
    }
}
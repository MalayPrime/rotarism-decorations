package com.github.malayP.decorations.block.machine.consumer

import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.frictionHeaterType
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


class FrictionHeater : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = FrictionHeaterTileEntity()
}

class FrictionHeaterTileEntity : TileEntity(frictionHeaterType.get())

class FrictionHeaterTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    TileEntityRenderer<FrictionHeaterTileEntity>(dispatcher) {
    companion object {
        val texture = modResourcesLocation("textures/tile_entity/accessory/friction_heater/friction_heater.png")
        val model = FrictionHeaterModel()
    }

    override fun render(
        tileEntityIn: FrictionHeaterTileEntity,
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

class FrictionHeaterModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val pos: ModelRenderer
    private val rot: ModelRenderer
    private val rotatable: ModelRenderer
    private val pos2: ModelRenderer
    private val rot2: ModelRenderer
    private val fan: ModelRenderer
    private val blade1: ModelRenderer
    private val blade2: ModelRenderer
    private val blade3: ModelRenderer
    private val blade4: ModelRenderer
    private val fan2: ModelRenderer
    private val blade5: ModelRenderer
    private val blade6: ModelRenderer
    private val blade7: ModelRenderer
    private val blade8: ModelRenderer

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
        pos = ModelRenderer(this)
        pos.setRotationPoint(1.0f, 8.0f, 0.0f)
        fixed.addChild(pos)
        pos.setTextureOffset(0, 0).addBox(-9.0f, -1.0f, -8.0f, 16.0f, 1.0f, 16.0f, 0.0f, false)
        pos.setTextureOffset(0, 35).addBox(-9.0f, -2.0f, -6.0f, 16.0f, 1.0f, 14.0f, 0.0f, false)
        pos.setTextureOffset(54, 35).addBox(-9.0f, -2.0f, -8.0f, 4.0f, 1.0f, 2.0f, 0.0f, false)
        pos.setTextureOffset(46, 51).addBox(3.0f, -2.0f, -8.0f, 4.0f, 1.0f, 2.0f, 0.0f, false)
        pos.setTextureOffset(0, 51).addBox(-9.0f, -14.0f, 7.0f, 16.0f, 12.0f, 1.0f, 0.0f, false)
        pos.setTextureOffset(35, 51).addBox(-3.0f, -10.0f, 3.0f, 4.0f, 8.0f, 1.0f, 0.0f, false)
        pos.setTextureOffset(49, 21).addBox(-3.0f, -10.0f, -4.0f, 4.0f, 8.0f, 1.0f, 0.0f, false)
        rot = ModelRenderer(this)
        rot.setRotationPoint(0.0f, 8.0f, 0.0f)
        fixed.addChild(rot)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        pos2 = ModelRenderer(this)
        pos2.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(pos2)
        pos2.setTextureOffset(49, 2).addBox(-1.0f, -1.0f, -7.5f, 2.0f, 2.0f, 16.0f, 0.0f, false)
        rot2 = ModelRenderer(this)
        rot2.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(rot2)
        setRotationAngle(rot2, 0.0f, 0.0f, 0.7854f)
        rot2.setTextureOffset(45, 45).addBox(-1.0f, -1.0f, -7.51f, 2.0f, 2.0f, 16.0f, 0.0f, false)
        fan = ModelRenderer(this)
        fan.setRotationPoint(0.0f, 0.0f, 0.5f)
        rotatable.addChild(fan)
        blade1 = ModelRenderer(this)
        blade1.setRotationPoint(0.0f, 0.0f, -0.5f)
        fan.addChild(blade1)
        blade1.setTextureOffset(7, 18).addBox(-1.0f, -6.5f, -7.5f, 2.0f, 13.0f, 1.0f, 0.0f, false)
        blade2 = ModelRenderer(this)
        blade2.setRotationPoint(0.0f, 0.0f, -0.5f)
        fan.addChild(blade2)
        setRotationAngle(blade2, 0.0f, 0.0f, 0.7854f)
        blade2.setTextureOffset(0, 18).addBox(-1.0f, -6.5f, -7.47f, 2.0f, 13.0f, 1.0f, 0.0f, false)
        blade3 = ModelRenderer(this)
        blade3.setRotationPoint(0.0f, 0.0f, -0.5f)
        fan.addChild(blade3)
        setRotationAngle(blade3, 0.0f, 0.0f, 1.5708f)
        blade3.setTextureOffset(7, 0).addBox(-1.0f, -6.5f, -7.48f, 2.0f, 13.0f, 1.0f, 0.0f, false)
        blade4 = ModelRenderer(this)
        blade4.setRotationPoint(0.0f, 0.0f, -0.5f)
        fan.addChild(blade4)
        setRotationAngle(blade4, 0.0f, 0.0f, 2.3562f)
        blade4.setTextureOffset(0, 0).addBox(-1.0f, -6.5f, -7.49f, 2.0f, 13.0f, 1.0f, 0.0f, false)
        fan2 = ModelRenderer(this)
        fan2.setRotationPoint(0.0f, 0.0f, 0.75f)
        rotatable.addChild(fan2)
        blade5 = ModelRenderer(this)
        blade5.setRotationPoint(0.0f, 0.0f, -0.5f)
        fan2.addChild(blade5)
        blade5.setTextureOffset(49, 0).addBox(-1.0f, -6.0f, -8.5f, 2.0f, 12.0f, 1.0f, -0.1f, false)
        blade6 = ModelRenderer(this)
        blade6.setRotationPoint(0.0f, 0.0f, -0.5f)
        fan2.addChild(blade6)
        setRotationAngle(blade6, 0.0f, 0.0f, 0.7854f)
        blade6.setTextureOffset(47, 35).addBox(-1.0f, -6.0f, -8.47f, 2.0f, 12.0f, 1.0f, -0.1f, false)
        blade7 = ModelRenderer(this)
        blade7.setRotationPoint(0.0f, 0.0f, -0.5f)
        fan2.addChild(blade7)
        setRotationAngle(blade7, 0.0f, 0.0f, 1.5708f)
        blade7.setTextureOffset(7, 35).addBox(-1.0f, -6.0f, -8.4f, 2.0f, 12.0f, 1.0f, -0.1f, false)
        blade8 = ModelRenderer(this)
        blade8.setRotationPoint(0.0f, 0.0f, -0.5f)
        fan2.addChild(blade8)
        setRotationAngle(blade8, 0.0f, 0.0f, 2.3562f)
        blade8.setTextureOffset(0, 35).addBox(-1.0f, -6.0f, -8.45f, 2.0f, 12.0f, 1.0f, -0.1f, false)
    }
}
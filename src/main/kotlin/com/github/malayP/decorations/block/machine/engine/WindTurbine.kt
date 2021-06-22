package com.github.malayP.decorations.block.machine.engine

import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.windTurbineType
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


class WindTurbine : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = WindTurbineTileEntity()
}

class WindTurbineTileEntity : TileEntity(windTurbineType.get())

class WindTurbineTileEntityRender(dispatcher: TileEntityRendererDispatcher) : TileEntityRenderer<WindTurbineTileEntity>(
    dispatcher
) {
    companion object {
        val model = WindTurbineModel()
        val texture = modResourcesLocation("textures/tile_entity/engines/wind_turbine/wind_turbine.png")
    }

    override fun render(
        tileEntityIn: WindTurbineTileEntity,
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

class WindTurbineModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val pos: ModelRenderer
    private val rot: ModelRenderer
    private val diff: ModelRenderer
    private val diff2: ModelRenderer
    private val rotatable: ModelRenderer
    private val output: ModelRenderer
    private val rot2: ModelRenderer
    private val pos2: ModelRenderer
    private val input: ModelRenderer
    private val rot3: ModelRenderer
    private val pos3: ModelRenderer
    private val fan: ModelRenderer
    private val blade: ModelRenderer
    private val blade2: ModelRenderer
    private val blade3: ModelRenderer
    private val blade4: ModelRenderer
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
        fixed.setRotationPoint(0.0f, 8.0f, 0.0f)
        shell.addChild(fixed)
        pos = ModelRenderer(this)
        pos.setRotationPoint(23.0f, -2.0f, 0.0f)
        fixed.addChild(pos)
        pos.setTextureOffset(0, 0).addBox(-31.0f, 0.0f, -8.0f, 16.0f, 2.0f, 16.0f, 0.0f, false)
        pos.setTextureOffset(0, 19).addBox(-31.0f, -14.0f, 7.0f, 1.0f, 14.0f, 1.0f, 0.0f, false)
        pos.setTextureOffset(0, 0).addBox(-31.0f, -14.0f, -8.0f, 1.0f, 14.0f, 1.0f, 0.0f, false)
        pos.setTextureOffset(10, 0).addBox(-16.0f, -14.0f, 7.0f, 1.0f, 14.0f, 1.0f, 0.0f, false)
        pos.setTextureOffset(29, 26).addBox(-30.0f, -14.0f, 7.0f, 14.0f, 1.0f, 1.0f, 0.0f, false)
        pos.setTextureOffset(29, 23).addBox(-30.0f, -14.0f, -8.0f, 14.0f, 1.0f, 1.0f, 0.0f, false)
        pos.setTextureOffset(0, 42).addBox(-31.0f, -14.0f, -7.0f, 2.0f, 2.0f, 14.0f, 0.0f, false)
        pos.setTextureOffset(31, 31).addBox(-17.0f, -14.0f, -7.0f, 2.0f, 2.0f, 14.0f, 0.0f, false)
        pos.setTextureOffset(5, 0).addBox(-16.0f, -14.0f, -8.0f, 1.0f, 14.0f, 1.0f, 0.0f, false)
        pos.setTextureOffset(0, 19).addBox(-26.0f, -9.0f, -7.95f, 6.0f, 6.0f, 16.0f, 0.0f, false)
        rot = ModelRenderer(this)
        rot.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(rot)
        diff = ModelRenderer(this)
        diff.setRotationPoint(0.0f, -8.0f, 7.5f)
        rot.addChild(diff)
        setRotationAngle(diff, 0.0f, 0.0f, 0.7854f)
        diff.setTextureOffset(38, 57).addBox(-0.5f, -10.5f, -0.51f, 1.0f, 7.0f, 1.0f, 0.0f, false)
        diff.setTextureOffset(50, 38).addBox(3.5f, -0.5f, -0.51f, 7.0f, 1.0f, 1.0f, 0.0f, false)
        diff.setTextureOffset(33, 57).addBox(-0.5f, 3.5f, -0.51f, 1.0f, 7.0f, 1.0f, 0.0f, false)
        diff.setTextureOffset(50, 35).addBox(-10.5f, -0.5f, -0.51f, 7.0f, 1.0f, 1.0f, 0.0f, false)
        diff2 = ModelRenderer(this)
        diff2.setRotationPoint(0.0f, -8.0f, -7.5f)
        rot.addChild(diff2)
        setRotationAngle(diff2, 0.0f, 0.0f, 0.7854f)
        diff2.setTextureOffset(5, 42).addBox(-0.5f, -10.5f, -0.49f, 1.0f, 7.0f, 1.0f, 0.0f, false)
        diff2.setTextureOffset(50, 32).addBox(3.5f, -0.5f, -0.49f, 7.0f, 1.0f, 1.0f, 0.0f, false)
        diff2.setTextureOffset(0, 42).addBox(-0.5f, 3.5f, -0.49f, 1.0f, 7.0f, 1.0f, 0.0f, false)
        diff2.setTextureOffset(50, 29).addBox(-10.5f, -0.5f, -0.49f, 7.0f, 1.0f, 1.0f, 0.0f, false)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        output = ModelRenderer(this)
        output.setRotationPoint(0.0f, 0.0f, -4.0f)
        rotatable.addChild(output)
        rot2 = ModelRenderer(this)
        rot2.setRotationPoint(0.0f, 0.0f, 0.0f)
        output.addChild(rot2)
        setRotationAngle(rot2, 0.0f, 0.0f, 0.7854f)
        rot2.setTextureOffset(49, 0).addBox(-1.0f, -1.0f, -4.49f, 2.0f, 2.0f, 6.0f, 0.0f, false)
        pos2 = ModelRenderer(this)
        pos2.setRotationPoint(0.0f, 8.0f, 4.0f)
        output.addChild(pos2)
        pos2.setTextureOffset(50, 50).addBox(-1.0f, -9.0f, -8.5f, 2.0f, 2.0f, 6.0f, 0.0f, false)
        input = ModelRenderer(this)
        input.setRotationPoint(0.0f, 0.0f, 9.0f)
        rotatable.addChild(input)
        rot3 = ModelRenderer(this)
        rot3.setRotationPoint(0.0f, 0.0f, 0.0f)
        input.addChild(rot3)
        setRotationAngle(rot3, 0.0f, 0.0f, 0.7854f)
        rot3.setTextureOffset(33, 48).addBox(-1.0f, -1.0f, -4.49f, 2.0f, 2.0f, 6.0f, 0.0f, false)
        rot3.setTextureOffset(5, 25).addBox(-1.5f, -1.5f, 0.51f, 3.0f, 3.0f, 2.0f, 0.0f, false)
        pos3 = ModelRenderer(this)
        pos3.setRotationPoint(0.0f, 8.0f, 4.0f)
        input.addChild(pos3)
        pos3.setTextureOffset(19, 42).addBox(-1.0f, -9.0f, -8.5f, 2.0f, 2.0f, 6.0f, 0.0f, false)
        pos3.setTextureOffset(5, 19).addBox(-1.5f, -9.5f, -3.5f, 3.0f, 3.0f, 2.0f, 0.0f, false)
        fan = ModelRenderer(this)
        fan.setRotationPoint(0.0f, 8.0f, 0.0f)
        rotatable.addChild(fan)
        blade = ModelRenderer(this)
        blade.setRotationPoint(0.0f, -8.0f, 0.0f)
        fan.addChild(blade)
        blade.setTextureOffset(29, 19).addBox(-15.5f, -1.0f, 9.0f, 16.0f, 2.0f, 1.0f, 0.0f, false)
        blade.setTextureOffset(49, 12).addBox(-7.5f, -0.99f, 10.0f, 8.0f, 1.0f, 1.0f, 0.0f, false)
        blade.setTextureOffset(49, 9).addBox(-15.5f, -0.99f, 9.5f, 8.0f, 1.0f, 1.0f, 0.0f, false)
        blade2 = ModelRenderer(this)
        blade2.setRotationPoint(0.0f, -8.0f, 0.0f)
        fan.addChild(blade2)
        setRotationAngle(blade2, 0.0f, 0.0f, 0.7854f)
        blade2.setTextureOffset(29, 19).addBox(-15.5f, -1.0f, 9.0f, 16.0f, 2.0f, 1.0f, 0.0f, false)
        blade2.setTextureOffset(49, 12).addBox(-7.5f, -0.99f, 10.0f, 8.0f, 1.0f, 1.0f, 0.0f, false)
        blade2.setTextureOffset(49, 9).addBox(-15.5f, -0.99f, 9.5f, 8.0f, 1.0f, 1.0f, 0.0f, false)
        blade3 = ModelRenderer(this)
        blade3.setRotationPoint(0.0f, -8.0f, 0.0f)
        fan.addChild(blade3)
        setRotationAngle(blade3, 0.0f, 0.0f, 1.5708f)
        blade3.setTextureOffset(29, 19).addBox(-15.5f, -1.0f, 9.0f, 16.0f, 2.0f, 1.0f, 0.0f, false)
        blade3.setTextureOffset(49, 12).addBox(-7.5f, -0.99f, 10.0f, 8.0f, 1.0f, 1.0f, 0.0f, false)
        blade3.setTextureOffset(49, 9).addBox(-15.5f, -0.99f, 9.5f, 8.0f, 1.0f, 1.0f, 0.0f, false)
        blade4 = ModelRenderer(this)
        blade4.setRotationPoint(0.0f, -8.0f, 0.0f)
        fan.addChild(blade4)
        setRotationAngle(blade4, 0.0f, 0.0f, 2.3562f)
        blade4.setTextureOffset(29, 19).addBox(-15.5f, -1.0f, 9.0f, 16.0f, 2.0f, 1.0f, 0.0f, false)
        blade4.setTextureOffset(49, 12).addBox(-7.5f, -0.99f, 10.0f, 8.0f, 1.0f, 1.0f, 0.0f, false)
        blade4.setTextureOffset(49, 9).addBox(-15.5f, -0.99f, 9.5f, 8.0f, 1.0f, 1.0f, 0.0f, false)
        blade5 = ModelRenderer(this)
        blade5.setRotationPoint(0.0f, -8.0f, 0.0f)
        fan.addChild(blade5)
        setRotationAngle(blade5, 0.0f, 0.0f, -3.1416f)
        blade5.setTextureOffset(29, 19).addBox(-15.5f, -1.0f, 9.0f, 16.0f, 2.0f, 1.0f, 0.0f, false)
        blade5.setTextureOffset(49, 12).addBox(-7.5f, -0.99f, 10.0f, 8.0f, 1.0f, 1.0f, 0.0f, false)
        blade5.setTextureOffset(49, 9).addBox(-15.5f, -0.99f, 9.5f, 8.0f, 1.0f, 1.0f, 0.0f, false)
        blade6 = ModelRenderer(this)
        blade6.setRotationPoint(0.0f, -8.0f, 0.0f)
        fan.addChild(blade6)
        setRotationAngle(blade6, 0.0f, 0.0f, -2.3562f)
        blade6.setTextureOffset(29, 19).addBox(-15.5f, -1.0f, 9.0f, 16.0f, 2.0f, 1.0f, 0.0f, false)
        blade6.setTextureOffset(49, 12).addBox(-7.5f, -0.99f, 10.0f, 8.0f, 1.0f, 1.0f, 0.0f, false)
        blade6.setTextureOffset(49, 9).addBox(-15.5f, -0.99f, 9.5f, 8.0f, 1.0f, 1.0f, 0.0f, false)
        blade7 = ModelRenderer(this)
        blade7.setRotationPoint(0.0f, -8.0f, 0.0f)
        fan.addChild(blade7)
        setRotationAngle(blade7, 0.0f, 0.0f, -1.5708f)
        blade7.setTextureOffset(29, 19).addBox(-15.5f, -1.0f, 9.0f, 16.0f, 2.0f, 1.0f, 0.0f, false)
        blade7.setTextureOffset(49, 12).addBox(-7.5f, -0.99f, 10.0f, 8.0f, 1.0f, 1.0f, 0.0f, false)
        blade7.setTextureOffset(49, 9).addBox(-15.5f, -0.99f, 9.5f, 8.0f, 1.0f, 1.0f, 0.0f, false)
        blade8 = ModelRenderer(this)
        blade8.setRotationPoint(0.0f, -8.0f, 0.0f)
        fan.addChild(blade8)
        setRotationAngle(blade8, 0.0f, 0.0f, -0.7854f)
        blade8.setTextureOffset(29, 19).addBox(-15.5f, -1.0f, 9.0f, 16.0f, 2.0f, 1.0f, 0.0f, false)
        blade8.setTextureOffset(49, 12).addBox(-7.5f, -0.99f, 10.0f, 8.0f, 1.0f, 1.0f, 0.0f, false)
        blade8.setTextureOffset(49, 9).addBox(-15.5f, -0.99f, 9.5f, 8.0f, 1.0f, 1.0f, 0.0f, false)
    }
}
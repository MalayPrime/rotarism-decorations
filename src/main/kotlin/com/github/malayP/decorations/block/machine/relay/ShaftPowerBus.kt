package com.github.malayP.decorations.block.machine.relay


import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.shaftPowerBusType
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

class ShaftPowerBus : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = ShaftPowerBusTileEntity()
}

class ShaftPowerBusTileEntity : TileEntity(shaftPowerBusType.get()) {

}

class ShaftPowerBusTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    TileEntityRenderer<ShaftPowerBusTileEntity>(
        dispatcher
    ) {
    companion object {
        val model = ShaftPowerBusModel()
        val texture = modResourcesLocation("textures/tile_entity/transmission/shaft_power_bus/shaft_power_bus.png")
    }

    override fun render(
        tileEntityIn: ShaftPowerBusTileEntity,
        partialTicks: Float,
        matrixStackIn: MatrixStack,
        bufferIn: IRenderTypeBuffer,
        combinedLightIn: Int,
        combinedOverlayIn: Int
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

class ShaftPowerBusModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val pos: ModelRenderer
    private val input: ModelRenderer
    private val bone: ModelRenderer
    private val bone2: ModelRenderer
    private val bone3: ModelRenderer
    private val bone4: ModelRenderer
    private val bone5: ModelRenderer
    private val bone6: ModelRenderer
    private val bone7: ModelRenderer
    private val bone8: ModelRenderer
    private val input3: ModelRenderer
    private val bone17: ModelRenderer
    private val bone18: ModelRenderer
    private val bone19: ModelRenderer
    private val bone20: ModelRenderer
    private val bone21: ModelRenderer
    private val bone22: ModelRenderer
    private val bone23: ModelRenderer
    private val bone24: ModelRenderer
    private val input2: ModelRenderer
    private val bone9: ModelRenderer
    private val bone10: ModelRenderer
    private val bone11: ModelRenderer
    private val bone12: ModelRenderer
    private val bone13: ModelRenderer
    private val bone14: ModelRenderer
    private val bone15: ModelRenderer
    private val bone16: ModelRenderer
    private val rotatable: ModelRenderer
    private val pos2: ModelRenderer
    private val rot2: ModelRenderer

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
        pos.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(pos)
        pos.setTextureOffset(0, 0).addBox(-5.0f, -13.0f, -5.0f, 10.0f, 10.0f, 10.0f, 0.0f, false)
        pos.setTextureOffset(50, 106).addBox(2.0f, -16.0f, 2.0f, 6.0f, 16.0f, 6.0f, 0.0f, false)
        pos.setTextureOffset(95, 97).addBox(2.0f, -16.0f, -8.0f, 6.0f, 16.0f, 6.0f, 0.0f, false)
        pos.setTextureOffset(25, 95).addBox(-8.0f, -16.0f, 2.0f, 6.0f, 16.0f, 6.0f, 0.0f, false)
        pos.setTextureOffset(0, 92).addBox(-8.0f, -16.0f, -8.0f, 6.0f, 16.0f, 6.0f, 0.0f, false)
        pos.setTextureOffset(100, 56).addBox(-2.0f, -16.0f, 2.0f, 4.0f, 6.0f, 6.0f, 0.0f, false)
        pos.setTextureOffset(100, 38).addBox(-2.0f, -6.0f, 2.0f, 4.0f, 6.0f, 6.0f, 0.0f, false)
        pos.setTextureOffset(100, 17).addBox(-2.0f, -16.0f, -8.0f, 4.0f, 6.0f, 6.0f, 0.0f, false)
        pos.setTextureOffset(66, 20).addBox(-2.0f, -6.0f, -8.0f, 4.0f, 6.0f, 6.0f, 0.0f, false)
        pos.setTextureOffset(0, 115).addBox(2.0f, -6.0f, -2.0f, 6.0f, 6.0f, 4.0f, 0.0f, false)
        pos.setTextureOffset(106, 0).addBox(-8.0f, -6.0f, -2.0f, 6.0f, 6.0f, 4.0f, 0.0f, false)
        pos.setTextureOffset(100, 74).addBox(2.0f, -16.0f, -2.0f, 6.0f, 6.0f, 4.0f, 0.0f, false)
        pos.setTextureOffset(51, 93).addBox(-8.0f, -16.0f, -2.0f, 6.0f, 6.0f, 4.0f, 0.0f, false)
        input = ModelRenderer(this)
        input.setRotationPoint(0.0f, -8.0f, 0.0f)
        fixed.addChild(input)
        bone = ModelRenderer(this)
        bone.setRotationPoint(0.0f, -5.575f, -1.0f)
        input.addChild(bone)
        bone.setTextureOffset(60, 89).addBox(-1.0f, 7.0f, -6.5f, 2.0f, 1.0f, 15.0f, 0.0f, false)
        bone2 = ModelRenderer(this)
        bone2.setRotationPoint(0.0f, -5.575f, -1.0f)
        input.addChild(bone2)
        setRotationAngle(bone2, 0.0f, 0.0f, 0.7854f)
        bone2.setTextureOffset(60, 54).addBox(2.9497f, 5.364f, -6.5f, 2.0f, 2.0f, 15.0f, 0.0f, false)
        bone3 = ModelRenderer(this)
        bone3.setRotationPoint(0.0f, -5.575f, -1.0f)
        input.addChild(bone3)
        setRotationAngle(bone3, 0.0f, 0.0f, 1.5708f)
        bone3.setTextureOffset(86, 0).addBox(4.5858f, 1.4142f, -6.5f, 2.0f, 1.0f, 15.0f, 0.0f, false)
        bone4 = ModelRenderer(this)
        bone4.setRotationPoint(0.0f, -5.575f, -1.0f)
        input.addChild(bone4)
        setRotationAngle(bone4, 0.0f, 0.0f, 2.3562f)
        bone4.setTextureOffset(60, 36).addBox(2.9497f, -2.5355f, -6.5f, 2.0f, 2.0f, 15.0f, 0.0f, false)
        bone5 = ModelRenderer(this)
        bone5.setRotationPoint(0.0f, -5.575f, -1.0f)
        input.addChild(bone5)
        setRotationAngle(bone5, 0.0f, 0.0f, -3.1416f)
        bone5.setTextureOffset(80, 57).addBox(-1.0f, -4.1716f, -6.5f, 2.0f, 1.0f, 15.0f, 0.0f, false)
        bone6 = ModelRenderer(this)
        bone6.setRotationPoint(0.0f, -5.575f, -1.0f)
        input.addChild(bone6)
        setRotationAngle(bone6, 0.0f, 0.0f, -2.3562f)
        bone6.setTextureOffset(40, 58).addBox(-4.9497f, -2.5355f, -6.5f, 2.0f, 2.0f, 15.0f, 0.0f, false)
        bone7 = ModelRenderer(this)
        bone7.setRotationPoint(0.0f, -5.575f, -1.0f)
        input.addChild(bone7)
        setRotationAngle(bone7, 0.0f, 0.0f, -1.5708f)
        bone7.setTextureOffset(80, 39).addBox(-6.5858f, 1.4142f, -6.5f, 2.0f, 1.0f, 15.0f, 0.0f, false)
        bone8 = ModelRenderer(this)
        bone8.setRotationPoint(0.0f, -5.575f, -1.0f)
        input.addChild(bone8)
        setRotationAngle(bone8, 0.0f, 0.0f, -0.7854f)
        bone8.setTextureOffset(0, 57).addBox(-4.9497f, 5.364f, -6.5f, 2.0f, 2.0f, 15.0f, 0.0f, false)
        input3 = ModelRenderer(this)
        input3.setRotationPoint(0.0f, -8.0f, 0.0f)
        fixed.addChild(input3)
        setRotationAngle(input3, 1.5708f, 0.0f, 0.0f)
        bone17 = ModelRenderer(this)
        bone17.setRotationPoint(0.0f, -5.575f, -1.0f)
        input3.addChild(bone17)
        bone17.setTextureOffset(80, 21).addBox(-1.0f, 7.0f, -6.5f, 2.0f, 1.0f, 15.0f, 0.0f, false)
        bone18 = ModelRenderer(this)
        bone18.setRotationPoint(0.0f, -5.575f, -1.0f)
        input3.addChild(bone18)
        setRotationAngle(bone18, 0.0f, 0.0f, 0.7854f)
        bone18.setTextureOffset(46, 18).addBox(2.9497f, 5.364f, -6.5f, 2.0f, 2.0f, 15.0f, 0.0f, false)
        bone19 = ModelRenderer(this)
        bone19.setRotationPoint(0.0f, -5.575f, -1.0f)
        input3.addChild(bone19)
        setRotationAngle(bone19, 0.0f, 0.0f, 1.5708f)
        bone19.setTextureOffset(80, 80).addBox(4.5858f, 1.4142f, -6.5f, 2.0f, 1.0f, 15.0f, 0.0f, false)
        bone20 = ModelRenderer(this)
        bone20.setRotationPoint(0.0f, -5.575f, -1.0f)
        input3.addChild(bone20)
        setRotationAngle(bone20, 0.0f, 0.0f, 2.3562f)
        bone20.setTextureOffset(46, 0).addBox(2.9497f, -2.5355f, -6.5f, 2.0f, 2.0f, 15.0f, 0.0f, false)
        bone21 = ModelRenderer(this)
        bone21.setRotationPoint(0.0f, -5.575f, -1.0f)
        input3.addChild(bone21)
        setRotationAngle(bone21, 0.0f, 0.0f, -3.1416f)
        bone21.setTextureOffset(20, 78).addBox(-1.0f, -4.1716f, -6.5f, 2.0f, 1.0f, 15.0f, 0.0f, false)
        bone22 = ModelRenderer(this)
        bone22.setRotationPoint(0.0f, -5.575f, -1.0f)
        input3.addChild(bone22)
        setRotationAngle(bone22, 0.0f, 0.0f, -2.3562f)
        bone22.setTextureOffset(20, 43).addBox(-4.9497f, -2.5355f, -6.5f, 2.0f, 2.0f, 15.0f, 0.0f, false)
        bone23 = ModelRenderer(this)
        bone23.setRotationPoint(0.0f, -5.575f, -1.0f)
        input3.addChild(bone23)
        setRotationAngle(bone23, 0.0f, 0.0f, -1.5708f)
        bone23.setTextureOffset(40, 76).addBox(-6.5858f, 1.4142f, -6.5f, 2.0f, 1.0f, 15.0f, 0.0f, false)
        bone24 = ModelRenderer(this)
        bone24.setRotationPoint(0.0f, -5.575f, -1.0f)
        input3.addChild(bone24)
        setRotationAngle(bone24, 0.0f, 0.0f, -0.7854f)
        bone24.setTextureOffset(40, 40).addBox(-4.9497f, 5.364f, -6.5f, 2.0f, 2.0f, 15.0f, 0.0f, false)
        input2 = ModelRenderer(this)
        input2.setRotationPoint(0.0f, -8.0f, 0.0f)
        fixed.addChild(input2)
        setRotationAngle(input2, 0.0f, -1.5708f, 0.0f)
        bone9 = ModelRenderer(this)
        bone9.setRotationPoint(0.0f, -5.575f, -1.0f)
        input2.addChild(bone9)
        bone9.setTextureOffset(0, 75).addBox(-1.0f, 7.0f, -6.5f, 2.0f, 1.0f, 15.0f, 0.0f, false)
        bone10 = ModelRenderer(this)
        bone10.setRotationPoint(0.0f, -5.575f, -1.0f)
        input2.addChild(bone10)
        setRotationAngle(bone10, 0.0f, 0.0f, 0.7854f)
        bone10.setTextureOffset(0, 39).addBox(2.9497f, 5.364f, -6.5f, 2.0f, 2.0f, 15.0f, 0.0f, false)
        bone11 = ModelRenderer(this)
        bone11.setRotationPoint(0.0f, -5.575f, -1.0f)
        input2.addChild(bone11)
        setRotationAngle(bone11, 0.0f, 0.0f, 1.5708f)
        bone11.setTextureOffset(60, 72).addBox(4.5858f, 1.4142f, -6.5f, 2.0f, 1.0f, 15.0f, 0.0f, false)
        bone12 = ModelRenderer(this)
        bone12.setRotationPoint(0.0f, -5.575f, -1.0f)
        input2.addChild(bone12)
        setRotationAngle(bone12, 0.0f, 0.0f, 2.3562f)
        bone12.setTextureOffset(26, 6).addBox(2.9497f, -2.5355f, -6.5f, 2.0f, 2.0f, 15.0f, 0.0f, false)
        bone13 = ModelRenderer(this)
        bone13.setRotationPoint(0.0f, -5.575f, -1.0f)
        input2.addChild(bone13)
        setRotationAngle(bone13, 0.0f, 0.0f, -3.1416f)
        bone13.setTextureOffset(66, 3).addBox(-1.0f, -4.1716f, -6.5f, 2.0f, 1.0f, 15.0f, 0.0f, false)
        bone14 = ModelRenderer(this)
        bone14.setRotationPoint(0.0f, -5.575f, -1.0f)
        input2.addChild(bone14)
        setRotationAngle(bone14, 0.0f, 0.0f, -2.3562f)
        bone14.setTextureOffset(20, 24).addBox(-4.9497f, -2.5355f, -6.5f, 2.0f, 2.0f, 15.0f, 0.0f, false)
        bone15 = ModelRenderer(this)
        bone15.setRotationPoint(0.0f, -5.575f, -1.0f)
        input2.addChild(bone15)
        setRotationAngle(bone15, 0.0f, 0.0f, -1.5708f)
        bone15.setTextureOffset(20, 61).addBox(-6.5858f, 1.4142f, -6.5f, 2.0f, 1.0f, 15.0f, 0.0f, false)
        bone16 = ModelRenderer(this)
        bone16.setRotationPoint(0.0f, -5.575f, -1.0f)
        input2.addChild(bone16)
        setRotationAngle(bone16, 0.0f, 0.0f, -0.7854f)
        bone16.setTextureOffset(0, 21).addBox(-4.9497f, 5.364f, -6.5f, 2.0f, 2.0f, 15.0f, 0.0f, false)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        pos2 = ModelRenderer(this)
        pos2.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(pos2)
        pos2.setTextureOffset(0, 6).addBox(-1.0f, -1.0f, 5.5f, 2.0f, 2.0f, 3.0f, 0.0f, false)
        rot2 = ModelRenderer(this)
        rot2.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(rot2)
        setRotationAngle(rot2, 0.0f, 0.0f, 0.7854f)
        rot2.setTextureOffset(0, 0).addBox(-1.0f, -1.0f, 5.5f, 2.0f, 2.0f, 3.0f, 0.0f, false)
    }
}
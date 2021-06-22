package com.github.malayP.decorations.block.machine.engine

import com.github.malayP.decorations.block.machine.Detectable
import com.github.malayP.decorations.capability.RotaryCapability.RotaryCapabilityContentImpl
import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.dcElectronicEngineType
import com.github.zomb_676.fantasySoup.EnumShaftMaterial
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
import net.minecraft.tileentity.ITickableTileEntity
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.Direction
import net.minecraft.util.math.vector.Vector3f
import net.minecraft.world.IBlockReader
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.api.distmarker.OnlyIn


class DCElectronicEngine : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState, world: IBlockReader): TileEntity = DCElectronicEngineTileEntity()
}

class DCElectronicEngineTileEntity : EngineTileEntity(dcElectronicEngineType.get()), Detectable, ITickableTileEntity {
    private val rotaryCapability = object : RotaryCapabilityContentImpl(EnumShaftMaterial.BEDROCK, this) {
        override fun calculate() {
        }
    }

    companion object {
        const val torque: Int = 4
        const val speed: Int = 256
    }

    override fun remove() {
        rotaryCapability.invalid()
    }

    override fun updateContainingBlockInfo() {
        super.updateContainingBlockInfo()
        rotaryCapability.indexOutArray[blockState.get(BlockStateProperties.HORIZONTAL_FACING).index] = true
    }

    override fun canProduceEnergy(): Boolean = world!!.getRedstonePowerFromNeighbors(pos) != 0

    override fun getOutputTorque(): Int = torque

    override fun getOutputSpeed(): Int = speed

    override fun tick() {
        if (world!!.isBlockPowered(pos)) {
            if (!isWorking) {
                isWorking = true
                val direction = blockState.get(BlockStateProperties.HORIZONTAL_FACING)
                rotaryCapability.indexTorqueArray[direction.index] = torque
                rotaryCapability.indexSpeedArray[direction.index] = speed
                rotaryCapability.indexOutArray[direction.index] = true
                rotaryCapability.energySource.add(this)
                rotaryCapability.updateOutputData(direction)
            }
        } else if (isWorking) {
            isWorking = false
            val direction = blockState.get(BlockStateProperties.HORIZONTAL_FACING)
            rotaryCapability.indexTorqueArray[direction.index] = 0
            rotaryCapability.indexSpeedArray[direction.index] = 0
            rotaryCapability.indexOutArray[direction.index] = false
            rotaryCapability.energySource.remove(this)
            rotaryCapability.updateOutputData(direction)
        }
    }

    override fun getDetectorUseInfo(): String {
        return if (isWorking) {
            "status : working , torque output : ${torque}N/m , speed output : ${speed}rad/s"
        } else {
            "status : not working , reason : no redstone signal detected "
        }
    }

    @OnlyIn(Dist.CLIENT)
    val model = DCElectronicEngineModel()

}

class DCElectronicEngineTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    TileEntityRenderer<DCElectronicEngineTileEntity>(
        dispatcher
    ) {
    companion object {
        val texture = modResourcesLocation("textures/tile_entity/engines/dc_electronic_engine/dc_electronic_engine.png")
    }

    override fun render(
        tileEntityIn: DCElectronicEngineTileEntity,
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
        if (tileEntityIn.world != null && tileEntityIn.isWorking) {
            tileEntityIn.model
        }
        if (tileEntityIn.isWorking) {
            tileEntityIn.model.rotate(
                tileEntityIn.getOutputSpeed() * partialTicks,
                Direction.Axis.X
            )
        }
        tileEntityIn.model.render(matrixStackIn, buffer, combinedLightIn, combinedOverlayIn, 1f, 1f, 1f, 1f)
        matrixStackIn.pop()
    }


}

class DCElectronicEngineModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val pos2: ModelRenderer
    private val rot2: ModelRenderer
    private val rotatable: ModelRenderer
    private val pos: ModelRenderer
    private val rot: ModelRenderer

    fun rotate(speed: Float, axisDirection: Direction.Axis) {
        rotatable.rotateAngleZ += speed / 20
    }

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
        pos2 = ModelRenderer(this)
        pos2.setRotationPoint(0.0f, -2.0f, -1.0f)
        fixed.addChild(pos2)
        pos2.setTextureOffset(0, 0).addBox(-8.0f, 0.0f, -7.0f, 16.0f, 2.0f, 16.0f, 0.0f, false)
        pos2.setTextureOffset(0, 19).addBox(-4.0f, -10.0f, -3.0f, 8.0f, 8.0f, 11.0f, 0.0f, false)
        pos2.setTextureOffset(0, 39).addBox(-2.0f, -2.01f, 0.0f, 4.0f, 2.0f, 9.0f, 0.0f, false)
        pos2.setTextureOffset(27, 48).addBox(-6.0f, -4.0f, -2.0f, 12.0f, 4.0f, 2.0f, 0.0f, false)
        pos2.setTextureOffset(28, 19).addBox(-6.0f, -4.0f, 5.0f, 12.0f, 4.0f, 2.0f, 0.0f, false)
        pos2.setTextureOffset(0, 0).addBox(-2.0f, -8.0f, -6.0f, 4.0f, 8.0f, 1.0f, 0.0f, false)
        rot2 = ModelRenderer(this)
        rot2.setRotationPoint(0.0f, -8.0f, 0.0f)
        fixed.addChild(rot2)
        setRotationAngle(rot2, 0.0f, 0.0f, 0.7854f)
        rot2.setTextureOffset(29, 29).addBox(-4.0f, -4.0f, -3.95f, 8.0f, 8.0f, 10.0f, 0.0f, false)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        setRotationAngle(rotatable, 0.0f, 0.0f, 1.0908f)
        pos = ModelRenderer(this)
        pos.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(pos)
        pos.setTextureOffset(49, 0).addBox(-1.0f, -1.0f, -8.5f, 2.0f, 2.0f, 9.0f, 0.0f, false)
        rot = ModelRenderer(this)
        rot.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(rot)
        setRotationAngle(rot, 0.0f, 0.0f, 0.7854f)
        rot.setTextureOffset(47, 48).addBox(-1.0f, -1.0f, -8.49f, 2.0f, 2.0f, 9.0f, 0.0f, false)
    }
}
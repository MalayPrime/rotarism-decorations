package com.github.malayP.decorations.block.machine.relay


import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.cvtUnitType
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


class CVTUnit : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = CVTUnitTileEntity()
}

class CVTUnitTileEntity : TileEntity(cvtUnitType.get())

class CVTUnitTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    TileEntityRenderer<CVTUnitTileEntity>(dispatcher) {
    companion object {
        val model = CVTUnitModel()
        val texture = modResourcesLocation("textures/tile_entity/transmission/cvt_unit/cvt_unit.png")
    }

    override fun render(
        tileEntityIn: CVTUnitTileEntity,
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

class CVTUnitModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val pos: ModelRenderer
    private val rot: ModelRenderer
    private val bone: ModelRenderer
    private val bone2: ModelRenderer
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
        fixed.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(fixed)
        pos = ModelRenderer(this)
        pos.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(pos)
        pos.setTextureOffset(0, 0).addBox(-8.0f, -3.0f, -8.0f, 16.0f, 11.0f, 16.0f, 0.0f, false)
        pos.setTextureOffset(0, 28).addBox(-3.0f, -8.0f, -8.0f, 6.0f, 5.0f, 16.0f, 0.0f, false)
        rot = ModelRenderer(this)
        rot.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(rot)
        bone = ModelRenderer(this)
        bone.setRotationPoint(0.0f, 0.0f, 0.0f)
        rot.addChild(bone)
        setRotationAngle(bone, 0.0f, 0.0f, -0.7854f)
        bone.setTextureOffset(0, 50).addBox(-3.4645f, -6.7782f, -7.5f, 7.0f, 4.0f, 15.0f, 0.0f, false)
        bone.setTextureOffset(60, 31).addBox(-3.4645f, -7.2782f, -5.0f, 7.0f, 1.0f, 10.0f, 0.0f, false)
        bone.setTextureOffset(60, 43).addBox(-3.4645f, -7.5282f, 4.5f, 7.0f, 1.0f, 1.0f, 0.0f, false)
        bone.setTextureOffset(46, 31).addBox(-3.4645f, -7.5282f, -5.5f, 7.0f, 1.0f, 1.0f, 0.0f, false)
        bone.setTextureOffset(70, 70).addBox(2.5355f, -7.5282f, -4.5f, 1.0f, 1.0f, 9.0f, 0.0f, false)
        bone.setTextureOffset(0, 70).addBox(-3.4645f, -7.5282f, -4.5f, 1.0f, 1.0f, 9.0f, 0.0f, false)
        bone2 = ModelRenderer(this)
        bone2.setRotationPoint(0.0f, 0.0f, 0.0f)
        rot.addChild(bone2)
        setRotationAngle(bone2, 0.0f, 0.0f, 0.7854f)
        bone2.setTextureOffset(30, 35).addBox(-3.5355f, -6.7782f, -7.5f, 7.0f, 4.0f, 15.0f, 0.0f, false)
        bone2.setTextureOffset(50, 55).addBox(-3.5355f, -7.2782f, -5.0f, 7.0f, 1.0f, 10.0f, 0.0f, false)
        bone2.setTextureOffset(29, 32).addBox(-3.5355f, -7.5282f, 4.5f, 7.0f, 1.0f, 1.0f, 0.0f, false)
        bone2.setTextureOffset(58, 67).addBox(-3.5355f, -7.5282f, -4.5f, 1.0f, 1.0f, 9.0f, 0.0f, false)
        bone2.setTextureOffset(49, 0).addBox(2.4645f, -7.5282f, -4.5f, 1.0f, 1.0f, 9.0f, 0.0f, false)
        bone2.setTextureOffset(29, 29).addBox(-3.5355f, -7.5282f, -5.5f, 7.0f, 1.0f, 1.0f, 0.0f, false)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        pos2 = ModelRenderer(this)
        pos2.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(pos2)
        pos2.setTextureOffset(28, 55).addBox(-1.0f, -1.0f, -8.5f, 2.0f, 2.0f, 17.0f, 0.0f, false)
        rot2 = ModelRenderer(this)
        rot2.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(rot2)
        setRotationAngle(rot2, 0.0f, 0.0f, 0.7854f)
        rot2.setTextureOffset(48, 11).addBox(-1.0f, -1.0f, -8.5f, 2.0f, 2.0f, 17.0f, 0.0f, false)
    }
}
package com.github.malayP.decorations.block.machine.machine

import com.github.malayP.decorations.block.machine.engine.ACElectronicEngineTileEntityRender
import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.remeltingTableType
import com.github.zomb_676.fantasySoup.block.HorizonBlockWithTileEntity
import com.mojang.blaze3d.matrix.MatrixStack
import com.mojang.blaze3d.vertex.IVertexBuilder
import net.minecraft.block.BlockState
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.IRenderTypeBuffer
import net.minecraft.client.renderer.RenderType
import net.minecraft.client.renderer.entity.model.EntityModel
import net.minecraft.client.renderer.model.Model
import net.minecraft.client.renderer.model.ModelRenderer
import net.minecraft.client.renderer.tileentity.TileEntityRenderer
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher
import net.minecraft.state.properties.BlockStateProperties
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.vector.Vector3f
import net.minecraft.world.IBlockReader


class RemeltingTable : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = RemeltingTableTileEntity()
}

class RemeltingTableTileEntity : TileEntity(remeltingTableType.get()) {}
class RemeltingTableTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    TileEntityRenderer<RemeltingTableTileEntity>(dispatcher) {
    companion object {
        val model = RemeltingTableModel()
        val texture: ResourceLocation= modResourcesLocation("textures/tile_entity/production/remelting_table/remelting_table.png")
    }

    override fun render(
        tileEntityIn: RemeltingTableTileEntity,
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

class RemeltingTableModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val barrel: ModelRenderer
    private val bone2: ModelRenderer
    private val bone3: ModelRenderer
    private val bone4: ModelRenderer
    private val bone5: ModelRenderer
    private val bone6: ModelRenderer
    private val bone7: ModelRenderer
    private val bone8: ModelRenderer
    private val bone9: ModelRenderer
    private val rotated: ModelRenderer
    private val connector: ModelRenderer
    private val hammer: ModelRenderer
    private val bone: ModelRenderer

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
        fixed.setTextureOffset(0, 19).addBox(-8.0f, -7.0f, -8.0f, 16.0f, 2.0f, 16.0f, 0.0f, false)
        fixed.setTextureOffset(0, 38).addBox(-7.0f, -18.7f, -7.0f, 14.0f, 0.0f, 14.0f, 0.0f, false)
        fixed.setTextureOffset(25, 72).addBox(-3.0f, -22.7f, -3.0f, 6.0f, 4.0f, 6.0f, 0.0f, false)
        fixed.setTextureOffset(0, 0).addBox(8.0f, -7.0f, -8.0f, 16.0f, 2.0f, 16.0f, 0.0f, false)
        fixed.setTextureOffset(40, 69).addBox(9.0f, -8.0f, -7.0f, 1.0f, 1.0f, 14.0f, 0.0f, false)
        fixed.setTextureOffset(0, 38).addBox(7.0f, -11.0f, -2.0f, 3.0f, 3.0f, 3.0f, 0.0f, false)
        fixed.setTextureOffset(23, 56).addBox(22.0f, -8.0f, -7.0f, 1.0f, 1.0f, 14.0f, 0.0f, false)
        fixed.setTextureOffset(86, 0).addBox(10.0f, -8.0f, -7.0f, 12.0f, 1.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(82, 77).addBox(10.0f, -8.0f, 6.0f, 12.0f, 1.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(49, 0).addBox(10.0f, -7.5f, -6.0f, 12.0f, 1.0f, 12.0f, 0.0f, false)
        fixed.setTextureOffset(95, 93).addBox(-7.0f, -5.0f, -7.0f, 2.0f, 13.0f, 2.0f, 0.0f, false)
        fixed.setTextureOffset(43, 38).addBox(6.0f, 2.0f, -7.0f, 2.0f, 6.0f, 2.0f, 0.0f, false)
        fixed.setTextureOffset(43, 38).addBox(6.0f, 2.0f, 5.0f, 2.0f, 6.0f, 2.0f, 0.0f, false)
        fixed.setTextureOffset(0, 70).addBox(-7.0f, -4.0f, -5.0f, 2.0f, 2.0f, 10.0f, 0.0f, false)
        fixed.setTextureOffset(57, 69).addBox(21.0f, -4.0f, -5.0f, 2.0f, 2.0f, 10.0f, 0.0f, false)
        fixed.setTextureOffset(0, 19).addBox(-7.0f, -5.0f, 5.0f, 2.0f, 13.0f, 2.0f, 0.0f, false)
        fixed.setTextureOffset(85, 95).addBox(21.0f, -5.0f, -7.0f, 2.0f, 13.0f, 2.0f, 0.0f, false)
        fixed.setTextureOffset(0, 0).addBox(21.0f, -5.0f, 5.0f, 2.0f, 13.0f, 2.0f, 0.0f, false)
        fixed.setTextureOffset(72, 73).addBox(-5.0f, -5.0f, -7.0f, 13.0f, 1.0f, 2.0f, 0.0f, false)
        fixed.setTextureOffset(65, 34).addBox(-5.0f, -5.0f, 5.0f, 13.0f, 1.0f, 2.0f, 0.0f, false)
        fixed.setTextureOffset(72, 69).addBox(8.0f, -5.0f, -7.0f, 13.0f, 1.0f, 2.0f, 0.0f, false)
        fixed.setTextureOffset(65, 14).addBox(8.0f, -5.0f, 5.0f, 13.0f, 1.0f, 2.0f, 0.0f, false)
        fixed.setTextureOffset(49, 19).addBox(-8.0f, -5.0f, 7.0f, 16.0f, 13.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(0, 53).addBox(-6.5f, -3.1f, 2.0f, 13.0f, 11.0f, 5.0f, 0.0f, false)
        fixed.setTextureOffset(43, 38).addBox(-6.9f, 1.0f, -6.9f, 15.0f, 1.0f, 12.0f, 0.0f, false)
        fixed.setTextureOffset(49, 0).addBox(6.1f, 1.0f, 5.1f, 2.0f, 1.0f, 2.0f, 0.0f, false)
        fixed.setTextureOffset(53, 58).addBox(-4.0f, -20.5f, -4.0f, 8.0f, 2.0f, 8.0f, 0.0f, false)
        barrel = ModelRenderer(this)
        barrel.setRotationPoint(-2.0f, 0.0f, -1.25f)
        fixed.addChild(barrel)
        bone2 = ModelRenderer(this)
        bone2.setRotationPoint(0.0f, 0.0f, 0.0f)
        barrel.addChild(bone2)
        bone2.setTextureOffset(68, 95).addBox(-1.0f, -19.0f, -6.0f, 6.0f, 12.0f, 2.0f, 0.0f, false)
        bone3 = ModelRenderer(this)
        bone3.setRotationPoint(0.0f, 0.0f, 0.0f)
        barrel.addChild(bone3)
        setRotationAngle(bone3, 0.0f, -0.7854f, 0.0f)
        bone3.setTextureOffset(91, 52).addBox(-0.7071f, -18.9f, -7.7782f, 6.0f, 12.0f, 2.0f, 0.0f, false)
        bone4 = ModelRenderer(this)
        bone4.setRotationPoint(0.0f, 0.0f, 0.0f)
        barrel.addChild(bone4)
        setRotationAngle(bone4, 0.0f, -1.5708f, 0.0f)
        bone4.setTextureOffset(51, 85).addBox(-1.7574f, -19.0f, -9.2426f, 6.0f, 12.0f, 2.0f, 0.0f, false)
        bone5 = ModelRenderer(this)
        bone5.setRotationPoint(0.0f, 0.0f, 0.0f)
        barrel.addChild(bone5)
        setRotationAngle(bone5, 0.0f, -2.3562f, 0.0f)
        bone5.setTextureOffset(34, 85).addBox(-3.5355f, -18.9f, -9.5355f, 6.0f, 12.0f, 2.0f, 0.0f, false)
        bone6 = ModelRenderer(this)
        bone6.setRotationPoint(0.0f, 0.0f, 0.0f)
        barrel.addChild(bone6)
        setRotationAngle(bone6, 0.0f, 3.1416f, 0.0f)
        bone6.setTextureOffset(84, 18).addBox(-5.0f, -19.0f, -8.4853f, 6.0f, 12.0f, 2.0f, 0.0f, false)
        bone7 = ModelRenderer(this)
        bone7.setRotationPoint(0.0f, 0.0f, 0.0f)
        barrel.addChild(bone7)
        setRotationAngle(bone7, 0.0f, 2.3562f, 0.0f)
        bone7.setTextureOffset(17, 83).addBox(-5.2929f, -18.9f, -6.7071f, 6.0f, 12.0f, 2.0f, 0.0f, false)
        bone8 = ModelRenderer(this)
        bone8.setRotationPoint(0.0f, 0.0f, 0.0f)
        barrel.addChild(bone8)
        setRotationAngle(bone8, 0.0f, 1.5708f, 0.0f)
        bone8.setTextureOffset(0, 83).addBox(-4.2426f, -19.0f, -5.2426f, 6.0f, 12.0f, 2.0f, 0.0f, false)
        bone9 = ModelRenderer(this)
        bone9.setRotationPoint(0.0f, 0.0f, 0.0f)
        barrel.addChild(bone9)
        setRotationAngle(bone9, 0.0f, 0.7854f, 0.0f)
        bone9.setTextureOffset(80, 80).addBox(-2.4645f, -18.9f, -4.9497f, 6.0f, 12.0f, 2.0f, 0.0f, false)
        rotated = ModelRenderer(this)
        rotated.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(rotated)
        connector = ModelRenderer(this)
        connector.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotated.addChild(connector)
        setRotationAngle(connector, -0.7854f, 0.0f, 0.0f)
        connector.setTextureOffset(48, 52).addBox(-6.0f, -7.7071f, -6.8787f, 12.0f, 7.0f, 9.0f, 0.0f, false)
        connector.setTextureOffset(0, 45).addBox(8.0f, -6.9071f, -11.3787f, 1.0f, 1.0f, 4.0f, 0.0f, false)
        hammer = ModelRenderer(this)
        hammer.setRotationPoint(0.0f, 0.0f, -5.0f)
        rotated.addChild(hammer)
        bone = ModelRenderer(this)
        bone.setRotationPoint(0.0f, 0.0f, 5.0f)
        hammer.addChild(bone)
        setRotationAngle(bone, 0.048f, 0.434f, 0.0639f)
        bone.setTextureOffset(86, 3).addBox(-2.0f, -1.0f, -7.0f, 2.0f, 2.0f, 5.0f, 0.0f, false)
        bone.setTextureOffset(32, 53).addBox(-1.0f, -0.5f, -5.0f, 9.0f, 1.0f, 1.0f, 0.0f, false)
    }
}
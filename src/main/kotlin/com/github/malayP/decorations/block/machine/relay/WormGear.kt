package com.github.malayP.decorations.block.machine.relay


import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.wormGearType
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


class WormGear : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = WormGearTileEntity()
}

class WormGearTileEntity : TileEntity(wormGearType.get()) {

}

class WormGearTileEntityRender(dispatcher: TileEntityRendererDispatcher) : TileEntityRenderer<WormGearTileEntity>(
    dispatcher
) {
    companion object {
        val model = WormGearModel()
        val texture = modResourcesLocation("textures/tile_entity/transmission/worm_gear/worm_gear.png")
    }

    override fun render(
        tileEntityIn: WormGearTileEntity,
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

class WormGearModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val rotatable: ModelRenderer
    private val worm: ModelRenderer
    private val bone: ModelRenderer
    private val pos2: ModelRenderer
    private val rot2: ModelRenderer
    private val cube_r1: ModelRenderer
    private val bone2: ModelRenderer
    private val pos3: ModelRenderer
    private val rot3: ModelRenderer
    private val cube_r2: ModelRenderer
    private val bone3: ModelRenderer
    private val pos4: ModelRenderer
    private val rot4: ModelRenderer
    private val cube_r3: ModelRenderer
    private val bone4: ModelRenderer
    private val pos5: ModelRenderer
    private val rot5: ModelRenderer
    private val cube_r4: ModelRenderer
    private val bone5: ModelRenderer
    private val pos6: ModelRenderer
    private val rot6: ModelRenderer
    private val cube_r5: ModelRenderer
    private val bone6: ModelRenderer
    private val pos7: ModelRenderer
    private val rot7: ModelRenderer
    private val cube_r6: ModelRenderer
    private val input: ModelRenderer
    private val rot: ModelRenderer
    private val cube_r7: ModelRenderer
    private val pos: ModelRenderer
    private val trans1: ModelRenderer
    private val pos8: ModelRenderer
    private val rot9: ModelRenderer
    private val trans2: ModelRenderer
    private val rot8: ModelRenderer
    private val cube_r8: ModelRenderer
    private val pos9: ModelRenderer
    private val output: ModelRenderer
    private val rot10: ModelRenderer
    private val cube_r9: ModelRenderer
    private val pos10: ModelRenderer

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
        setRotationAngle(shell, 0.0f, 1.5708f, 0.0f)
        fixed = ModelRenderer(this)
        fixed.setRotationPoint(8.0f, -5.0f, 0.0f)
        shell.addChild(fixed)
        fixed.setTextureOffset(19, 32).addBox(-16.0f, 0.0f, -8.0f, 1.0f, 13.0f, 16.0f, 0.0f, false)
        fixed.setTextureOffset(0, 18).addBox(-1.0f, 0.0f, -8.0f, 1.0f, 13.0f, 16.0f, 0.0f, false)
        fixed.setTextureOffset(0, 0).addBox(-15.0f, 12.0f, -8.0f, 14.0f, 1.0f, 16.0f, 0.0f, false)
        fixed.setTextureOffset(38, 38).addBox(-15.0f, 5.0f, -8.0f, 14.0f, 7.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(19, 19).addBox(-15.0f, 5.0f, 7.0f, 14.0f, 7.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(11, 18).addBox(-2.0f, 2.0f, 7.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(11, 11).addBox(-2.0f, 2.0f, -8.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(11, 5).addBox(-15.0f, 2.0f, 7.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(11, 0).addBox(-15.0f, 2.0f, -8.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(44, 52).addBox(-16.0f, -3.0f, -5.0f, 1.0f, 3.0f, 10.0f, 0.0f, false)
        fixed.setTextureOffset(0, 52).addBox(-1.0f, -3.0f, -5.0f, 1.0f, 3.0f, 10.0f, 0.0f, false)
        fixed.setTextureOffset(0, 26).addBox(-11.0f, 6.0f, -6.0f, 4.0f, 6.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(0, 18).addBox(-11.0f, 6.0f, 5.0f, 4.0f, 6.0f, 1.0f, 0.0f, false)
        fixed.setTextureOffset(0, 0).addBox(-5.5f, 6.0f, -4.0f, 1.0f, 6.0f, 4.0f, 0.0f, false)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        worm = ModelRenderer(this)
        worm.setRotationPoint(1.0f, 0.0f, 0.0f)
        rotatable.addChild(worm)
        bone = ModelRenderer(this)
        bone.setRotationPoint(1.0f, 0.0f, 0.0f)
        worm.addChild(bone)
        setRotationAngle(bone, -0.2618f, 0.0f, 0.0f)
        pos2 = ModelRenderer(this)
        pos2.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone.addChild(pos2)
        pos2.setTextureOffset(66, 47).addBox(-7.5f, -1.0f, -1.0f, 1.0f, 2.0f, 2.0f, 0.0f, false)
        rot2 = ModelRenderer(this)
        rot2.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone.addChild(rot2)
        cube_r1 = ModelRenderer(this)
        cube_r1.setRotationPoint(-0.5f, 0.0f, 0.0f)
        rot2.addChild(cube_r1)
        setRotationAngle(cube_r1, -0.7854f, 0.0f, 0.0f)
        cube_r1.setTextureOffset(66, 57).addBox(-7.0f, -1.0f, -1.0f, 1.0f, 2.0f, 2.0f, 0.0f, false)
        bone2 = ModelRenderer(this)
        bone2.setRotationPoint(2.0f, 0.0f, 0.0f)
        worm.addChild(bone2)
        setRotationAngle(bone2, -0.5236f, 0.0f, 0.0f)
        pos3 = ModelRenderer(this)
        pos3.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone2.addChild(pos3)
        pos3.setTextureOffset(53, 66).addBox(-7.5f, -1.0f, -1.0f, 1.0f, 2.0f, 2.0f, 0.0f, false)
        rot3 = ModelRenderer(this)
        rot3.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone2.addChild(rot3)
        cube_r2 = ModelRenderer(this)
        cube_r2.setRotationPoint(-0.5f, 0.0f, 0.0f)
        rot3.addChild(cube_r2)
        setRotationAngle(cube_r2, -0.7854f, 0.0f, 0.0f)
        cube_r2.setTextureOffset(46, 66).addBox(-7.0f, -1.0f, -1.0f, 1.0f, 2.0f, 2.0f, 0.0f, false)
        bone3 = ModelRenderer(this)
        bone3.setRotationPoint(3.0f, 0.0f, 0.0f)
        worm.addChild(bone3)
        setRotationAngle(bone3, -0.7854f, 0.0f, 0.0f)
        pos4 = ModelRenderer(this)
        pos4.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone3.addChild(pos4)
        pos4.setTextureOffset(14, 66).addBox(-7.5f, -1.0f, -1.0f, 1.0f, 2.0f, 2.0f, 0.0f, false)
        rot4 = ModelRenderer(this)
        rot4.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone3.addChild(rot4)
        cube_r3 = ModelRenderer(this)
        cube_r3.setRotationPoint(-0.5f, 0.0f, 0.0f)
        rot4.addChild(cube_r3)
        setRotationAngle(cube_r3, -0.7854f, 0.0f, 0.0f)
        cube_r3.setTextureOffset(7, 66).addBox(-7.0f, -1.0f, -1.0f, 1.0f, 2.0f, 2.0f, 0.0f, false)
        bone4 = ModelRenderer(this)
        bone4.setRotationPoint(4.0f, 0.0f, 0.0f)
        worm.addChild(bone4)
        setRotationAngle(bone4, -1.0472f, 0.0f, 0.0f)
        pos5 = ModelRenderer(this)
        pos5.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone4.addChild(pos5)
        pos5.setTextureOffset(0, 66).addBox(-7.5f, -1.0f, -1.0f, 1.0f, 2.0f, 2.0f, 0.0f, false)
        rot5 = ModelRenderer(this)
        rot5.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone4.addChild(rot5)
        cube_r4 = ModelRenderer(this)
        cube_r4.setRotationPoint(-0.5f, 0.0f, 0.0f)
        rot5.addChild(cube_r4)
        setRotationAngle(cube_r4, -0.7854f, 0.0f, 0.0f)
        cube_r4.setTextureOffset(65, 21).addBox(-7.0f, -1.0f, -1.0f, 1.0f, 2.0f, 2.0f, 0.0f, false)
        bone5 = ModelRenderer(this)
        bone5.setRotationPoint(5.0f, 0.0f, 0.0f)
        worm.addChild(bone5)
        setRotationAngle(bone5, -1.309f, 0.0f, 0.0f)
        pos6 = ModelRenderer(this)
        pos6.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone5.addChild(pos6)
        pos6.setTextureOffset(65, 65).addBox(-7.5f, -1.0f, -1.0f, 1.0f, 2.0f, 2.0f, 0.0f, false)
        rot6 = ModelRenderer(this)
        rot6.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone5.addChild(rot6)
        cube_r5 = ModelRenderer(this)
        cube_r5.setRotationPoint(-0.5f, 0.0f, 0.0f)
        rot6.addChild(cube_r5)
        setRotationAngle(cube_r5, -0.7854f, 0.0f, 0.0f)
        cube_r5.setTextureOffset(39, 65).addBox(-7.0f, -1.0f, -1.0f, 1.0f, 2.0f, 2.0f, 0.0f, false)
        bone6 = ModelRenderer(this)
        bone6.setRotationPoint(6.0f, 0.0f, 0.0f)
        worm.addChild(bone6)
        pos7 = ModelRenderer(this)
        pos7.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone6.addChild(pos7)
        pos7.setTextureOffset(64, 52).addBox(-7.5f, -1.0f, -1.0f, 1.0f, 2.0f, 2.0f, 0.0f, false)
        rot7 = ModelRenderer(this)
        rot7.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone6.addChild(rot7)
        cube_r6 = ModelRenderer(this)
        cube_r6.setRotationPoint(-0.5f, 0.0f, 0.0f)
        rot7.addChild(cube_r6)
        setRotationAngle(cube_r6, -0.7854f, 0.0f, 0.0f)
        cube_r6.setTextureOffset(63, 5).addBox(-7.05f, -1.0f, -1.0f, 1.0f, 2.0f, 2.0f, 0.0f, false)
        input = ModelRenderer(this)
        input.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(input)
        rot = ModelRenderer(this)
        rot.setRotationPoint(0.0f, 0.0f, 0.0f)
        input.addChild(rot)
        cube_r7 = ModelRenderer(this)
        cube_r7.setRotationPoint(-0.5f, 0.0f, 0.0f)
        rot.addChild(cube_r7)
        setRotationAngle(cube_r7, -0.7854f, 0.0f, 0.0f)
        cube_r7.setTextureOffset(45, 7).addBox(-7.95f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        pos = ModelRenderer(this)
        pos.setRotationPoint(0.0f, 0.0f, 0.0f)
        input.addChild(pos)
        pos.setTextureOffset(56, 25).addBox(-8.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        trans1 = ModelRenderer(this)
        trans1.setRotationPoint(-1.0f, 3.0f, 0.0f)
        rotatable.addChild(trans1)
        pos8 = ModelRenderer(this)
        pos8.setRotationPoint(0.0f, 0.0f, 0.0f)
        trans1.addChild(pos8)
        pos8.setTextureOffset(63, 0).addBox(-1.5f, -1.5f, -0.5f, 3.0f, 3.0f, 1.0f, 0.0f, false)
        pos8.setTextureOffset(45, 0).addBox(-1.0f, -1.0f, -6.5f, 2.0f, 2.0f, 13.0f, 0.0f, false)
        rot9 = ModelRenderer(this)
        rot9.setRotationPoint(0.0f, 0.0f, 0.0f)
        trans1.addChild(rot9)
        setRotationAngle(rot9, 0.0f, 0.0f, -0.7854f)
        rot9.setTextureOffset(62, 16).addBox(-1.5f, -1.5f, -0.45f, 3.0f, 3.0f, 1.0f, 0.0f, false)
        rot9.setTextureOffset(38, 18).addBox(-1.0f, -1.0f, -6.45f, 2.0f, 2.0f, 13.0f, 0.0f, false)
        trans2 = ModelRenderer(this)
        trans2.setRotationPoint(1.0f, 3.0f, -2.0f)
        rotatable.addChild(trans2)
        rot8 = ModelRenderer(this)
        rot8.setRotationPoint(7.0f, 0.0f, 0.0f)
        trans2.addChild(rot8)
        cube_r8 = ModelRenderer(this)
        cube_r8.setRotationPoint(0.5f, 0.0f, 0.0f)
        rot8.addChild(cube_r8)
        setRotationAngle(cube_r8, -0.7854f, 0.0f, 0.0f)
        cube_r8.setTextureOffset(0, 11).addBox(-6.95f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        cube_r8.setTextureOffset(0, 55).addBox(-3.95f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        cube_r8.setTextureOffset(57, 47).addBox(-7.95f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        pos9 = ModelRenderer(this)
        pos9.setRotationPoint(7.0f, 0.0f, 0.0f)
        trans2.addChild(pos9)
        pos9.setTextureOffset(57, 54).addBox(-7.5f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        pos9.setTextureOffset(56, 18).addBox(-3.5f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        pos9.setTextureOffset(19, 28).addBox(-6.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        output = ModelRenderer(this)
        output.setRotationPoint(7.0f, 0.0f, 0.0f)
        rotatable.addChild(output)
        rot10 = ModelRenderer(this)
        rot10.setRotationPoint(6.0f, 0.0f, 0.0f)
        output.addChild(rot10)
        cube_r9 = ModelRenderer(this)
        cube_r9.setRotationPoint(-0.5f, 0.0f, 0.0f)
        rot10.addChild(cube_r9)
        setRotationAngle(cube_r9, -0.7854f, 0.0f, 0.0f)
        cube_r9.setTextureOffset(0, 48).addBox(-7.95f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        cube_r9.setTextureOffset(32, 62).addBox(-5.05f, -1.0f, -1.0f, 1.0f, 2.0f, 2.0f, 0.0f, false)
        cube_r9.setTextureOffset(32, 62).addBox(-7.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f, 0.0f, false)
        pos10 = ModelRenderer(this)
        pos10.setRotationPoint(6.0f, 0.0f, 0.0f)
        output.addChild(pos10)
        pos10.setTextureOffset(23, 62).addBox(-7.5f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f, 0.0f, false)
        pos10.setTextureOffset(23, 62).addBox(-5.5f, -1.0f, -1.0f, 1.0f, 2.0f, 2.0f, 0.0f, false)
        pos10.setTextureOffset(45, 0).addBox(-8.5f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
    }
}
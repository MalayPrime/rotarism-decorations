package com.github.malayP.decorations.block.machine.machine

import com.github.malayP.decorations.block.machine.engine.ACElectronicEngineTileEntityRender
import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.extractorType
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


class Extractor : HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = ExtractorTileEntity()
}

class ExtractorTileEntity : TileEntity(extractorType.get()) {}
class ExtractorTileEntityRender(dispatcher: TileEntityRendererDispatcher) :
    TileEntityRenderer<ExtractorTileEntity>(dispatcher) {
    companion object {
        val model = ExtractorModel()
        val texture: ResourceLocation= modResourcesLocation("textures/tile_entity/processing/extractor/extractor.png")
    }

    override fun render(
        tileEntityIn: ExtractorTileEntity,
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

class ExtractorModel : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val fixed: ModelRenderer
    private val frame: ModelRenderer
    private val bone12: ModelRenderer
    private val hopper: ModelRenderer
    private val bone2: ModelRenderer
    private val bone: ModelRenderer
    private val cube_r1: ModelRenderer
    private val grinder: ModelRenderer
    private val bone11: ModelRenderer
    private val mixer: ModelRenderer
    private val bone3: ModelRenderer
    private val bone4: ModelRenderer
    private val bone5: ModelRenderer
    private val bone6: ModelRenderer
    private val bone7: ModelRenderer
    private val bone8: ModelRenderer
    private val bone9: ModelRenderer
    private val bone10: ModelRenderer
    private val presseser: ModelRenderer
    private val bone13: ModelRenderer
    private val burner: ModelRenderer
    private val rotatable: ModelRenderer
    private val pos: ModelRenderer
    private val rot: ModelRenderer
    private val plugganble: ModelRenderer
    private val presseser2: ModelRenderer


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
        frame = ModelRenderer(this)
        frame.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(frame)
        frame.setTextureOffset(0, 0).addBox(-8.0f, 6.0f, -7.0f, 16.0f, 2.0f, 16.0f, 0.0f, false)
        frame.setTextureOffset(11, 33).addBox(-7.0f, -5.0f, 6.0f, 1.0f, 11.0f, 1.0f, 0.0f, false)
        frame.setTextureOffset(11, 0).addBox(-7.0f, -13.0f, -7.0f, 1.0f, 12.0f, 1.0f, 0.0f, false)
        frame.setTextureOffset(22, 84).addBox(6.0f, -13.0f, 6.0f, 1.0f, 19.0f, 1.0f, 0.0f, false)
        frame.setTextureOffset(19, 33).addBox(6.0f, -13.0f, -7.0f, 1.0f, 4.0f, 1.0f, 0.0f, false)
        frame.setTextureOffset(0, 99).addBox(-5.0f, -4.0f, 8.0f, 10.0f, 10.0f, 1.0f, 0.0f, false)
        bone12 = ModelRenderer(this)
        bone12.setRotationPoint(-1.0f, 0.0f, 0.0f)
        frame.addChild(bone12)
        setRotationAngle(bone12, 0.0f, 1.5708f, 0.0f)
        bone12.setTextureOffset(0, 99).addBox(-5.0f, -4.0f, 8.0f, 10.0f, 10.0f, 1.0f, 0.0f, false)
        hopper = ModelRenderer(this)
        hopper.setRotationPoint(0.0f, -8.0f, 0.0f)
        fixed.addChild(hopper)
        hopper.setTextureOffset(70, 44).addBox(-7.0f, -13.0f, -8.0f, 14.0f, 7.0f, 1.0f, 0.0f, false)
        hopper.setTextureOffset(0, 19).addBox(-8.0f, -6.0f, -8.0f, 16.0f, 1.0f, 12.0f, 0.0f, false)
        hopper.setTextureOffset(72, 75).addBox(-4.0f, -6.0f, 4.0f, 12.0f, 1.0f, 4.0f, 0.0f, false)
        hopper.setTextureOffset(35, 33).addBox(7.0f, -13.0f, -8.0f, 1.0f, 7.0f, 16.0f, 0.0f, false)
        hopper.setTextureOffset(0, 33).addBox(-8.0f, -13.0f, -8.0f, 1.0f, 7.0f, 16.0f, 0.0f, false)
        hopper.setTextureOffset(65, 14).addBox(-7.0f, -13.0f, 7.0f, 14.0f, 7.0f, 1.0f, 0.0f, false)
        bone2 = ModelRenderer(this)
        bone2.setRotationPoint(0.0f, 0.0f, 0.0f)
        hopper.addChild(bone2)
        setRotationAngle(bone2, 0.0f, 0.0f, -0.3927f)
        bone2.setTextureOffset(21, 57).addBox(-1.0f, -8.0f, 0.0f, 12.0f, 1.0f, 7.0f, 0.0f, false)
        bone2.setTextureOffset(48, 75).addBox(3.0f, -8.0f, -7.0f, 8.0f, 1.0f, 7.0f, 0.0f, false)
        bone = ModelRenderer(this)
        bone.setRotationPoint(0.0f, 0.0f, 0.0f)
        hopper.addChild(bone)
        cube_r1 = ModelRenderer(this)
        cube_r1.setRotationPoint(0.0f, 0.0f, 0.0f)
        bone.addChild(cube_r1)
        setRotationAngle(cube_r1, -0.3927f, 0.0f, 0.0f)
        cube_r1.setTextureOffset(19, 33).addBox(0.0f, -8.0f, -11.0f, 7.0f, 1.0f, 8.0f, 0.0f, false)
        cube_r1.setTextureOffset(49, 0).addBox(-7.0f, -8.0f, -11.0f, 7.0f, 1.0f, 12.0f, 0.0f, false)
        grinder = ModelRenderer(this)
        grinder.setRotationPoint(0.0f, -18.0f, 0.0f)
        fixed.addChild(grinder)
        grinder.setTextureOffset(54, 24).addBox(-7.6f, 3.0f, -1.4f, 8.0f, 10.0f, 9.0f, 0.0f, false)
        bone11 = ModelRenderer(this)
        bone11.setRotationPoint(2.5f, 11.5f, 3.1f)
        grinder.addChild(bone11)
        setRotationAngle(bone11, 0.0f, 0.0f, 0.7854f)
        bone11.setTextureOffset(76, 0).addBox(-4.5f, -1.5f, -1.5f, 6.0f, 3.0f, 3.0f, 0.0f, false)
        mixer = ModelRenderer(this)
        mixer.setRotationPoint(3.1f, -1.0f, 2.25f)
        fixed.addChild(mixer)
        mixer.setTextureOffset(22, 66).addBox(-2.7f, -5.5f, -3.6f, 7.0f, 1.0f, 9.0f, 0.0f, false)
        mixer.setTextureOffset(0, 19).addBox(-5.25f, 3.0f, -3.0f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        bone3 = ModelRenderer(this)
        bone3.setRotationPoint(0.0f, 0.0f, 0.0f)
        mixer.addChild(bone3)
        bone3.setTextureOffset(49, 84).addBox(-2.0f, -6.0f, -4.0f, 4.0f, 13.0f, 1.0f, 0.0f, false)
        bone4 = ModelRenderer(this)
        bone4.setRotationPoint(0.0f, 0.0f, 0.0f)
        mixer.addChild(bone4)
        setRotationAngle(bone4, 0.0f, -0.7854f, 0.0f)
        bone4.setTextureOffset(11, 84).addBox(-1.4142f, -6.0f, -4.2426f, 4.0f, 13.0f, 1.0f, 0.0f, false)
        bone5 = ModelRenderer(this)
        bone5.setRotationPoint(0.0f, 0.0f, 0.0f)
        mixer.addChild(bone5)
        setRotationAngle(bone5, 0.0f, -1.5708f, 0.0f)
        bone5.setTextureOffset(0, 84).addBox(-1.1716f, -6.0f, -4.8284f, 4.0f, 13.0f, 1.0f, 0.0f, false)
        bone6 = ModelRenderer(this)
        bone6.setRotationPoint(0.0f, 0.0f, 0.0f)
        mixer.addChild(bone6)
        setRotationAngle(bone6, 0.0f, -2.3562f, 0.0f)
        bone6.setTextureOffset(38, 83).addBox(-1.4142f, -6.0f, -5.4142f, 4.0f, 13.0f, 1.0f, 0.0f, false)
        bone7 = ModelRenderer(this)
        bone7.setRotationPoint(0.0f, 0.0f, 0.0f)
        mixer.addChild(bone7)
        setRotationAngle(bone7, 0.0f, 3.1416f, 0.0f)
        bone7.setTextureOffset(79, 81).addBox(-2.0f, -6.0f, -5.6569f, 4.0f, 13.0f, 1.0f, 0.0f, false)
        bone8 = ModelRenderer(this)
        bone8.setRotationPoint(0.0f, 0.0f, 0.0f)
        mixer.addChild(bone8)
        setRotationAngle(bone8, 0.0f, 2.3562f, 0.0f)
        bone8.setTextureOffset(27, 77).addBox(-2.5858f, -6.0f, -5.4142f, 4.0f, 13.0f, 1.0f, 0.0f, false)
        bone9 = ModelRenderer(this)
        bone9.setRotationPoint(0.0f, 0.0f, 0.0f)
        mixer.addChild(bone9)
        setRotationAngle(bone9, 0.0f, 1.5708f, 0.0f)
        bone9.setTextureOffset(0, 33).addBox(-2.8284f, -6.0f, -4.8284f, 4.0f, 13.0f, 1.0f, 0.0f, false)
        bone10 = ModelRenderer(this)
        bone10.setRotationPoint(0.0f, 0.0f, 0.0f)
        mixer.addChild(bone10)
        setRotationAngle(bone10, 0.0f, 0.7854f, 0.0f)
        bone10.setTextureOffset(0, 0).addBox(-2.5858f, -6.0f, -4.2426f, 4.0f, 13.0f, 1.0f, 0.0f, false)
        presseser = ModelRenderer(this)
        presseser.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(presseser)
        presseser.setTextureOffset(0, 57).addBox(-7.0f, -1.0f, -7.0f, 5.0f, 7.0f, 10.0f, 0.0f, false)
        bone13 = ModelRenderer(this)
        bone13.setRotationPoint(0.0f, 0.0f, 0.0f)
        presseser.addChild(bone13)
        bone13.setTextureOffset(42, 33).addBox(-2.0f, 0.0f, -6.0f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        burner = ModelRenderer(this)
        burner.setRotationPoint(0.0f, 0.0f, 0.0f)
        fixed.addChild(burner)
        burner.setTextureOffset(60, 57).addBox(-1.0f, -9.0f, -7.0f, 8.0f, 12.0f, 5.0f, 0.0f, false)
        burner.setTextureOffset(0, 75).addBox(-1.0f, 3.0f, -7.0f, 8.0f, 3.0f, 5.0f, 0.0f, false)
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        pos = ModelRenderer(this)
        pos.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(pos)
        pos.setTextureOffset(19, 43).addBox(-1.0f, 6.5f, -1.0f, 2.0f, 2.0f, 2.0f, 0.0f, false)
        rot = ModelRenderer(this)
        rot.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(rot)
        setRotationAngle(rot, 0.0f, -0.7854f, 0.0f)
        rot.setTextureOffset(0, 26).addBox(-1.0f, 6.5f, -1.0f, 2.0f, 2.0f, 2.0f, 0.0f, false)
        plugganble = ModelRenderer(this)
        plugganble.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(plugganble)
        presseser2 = ModelRenderer(this)
        presseser2.setRotationPoint(0.0f, 0.0f, 0.0f)
        plugganble.addChild(presseser2)
        presseser2.setTextureOffset(45, 19).addBox(-6.0f, 0.0f, 3.0f, 3.0f, 5.0f, 5.0f, 0.0f, false)
    }
}
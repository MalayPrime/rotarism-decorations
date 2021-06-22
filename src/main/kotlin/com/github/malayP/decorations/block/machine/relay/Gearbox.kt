package com.github.malayP.decorations.block.machine.relay


import com.github.malayP.decorations.modResourcesLocation
import com.github.malayP.decorations.register.AllTileEntity.GEARBOX_TYPE
import com.github.zomb_676.fantasySoup.EnumShaftMaterial
import com.github.zomb_676.fantasySoup.block.HorizonBlockWithTileEntity
import com.github.zomb_676.fantasySoup.render.RenderWithTextureAndModel
import com.mojang.blaze3d.matrix.MatrixStack
import com.mojang.blaze3d.vertex.IVertexBuilder
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.IRenderTypeBuffer
import net.minecraft.client.renderer.RenderType
import net.minecraft.client.renderer.model.Model
import net.minecraft.client.renderer.model.ModelRenderer
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher
import net.minecraft.state.EnumProperty
import net.minecraft.state.StateContainer
import net.minecraft.state.properties.BlockStateProperties
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.IStringSerializable
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.vector.Vector3f
import net.minecraft.world.IBlockReader


abstract class Gearbox(val shaftMaterial: EnumShaftMaterial, val rate: Int, material: Material) :
    HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {
    override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = GearboxTileEntity()

    companion object {
        val gearboxMaterial = EnumProperty.create("gearbox_material", EnumShaftMaterial::class.java)
        val gearboxRate = EnumProperty.create("gearbox_rate", GearboxRate::class.java)
    }

    enum class GearboxRate(private val gearboxRate: Int) : IStringSerializable {
        TWO(2),
        FOUR(4),
        EIGHT(8),
        SIXTEEN(16);


        override fun toString(): String {
            return this.string
        }

        override fun getString(): String {
            return gearboxRate.toString()
        }
    }

    override fun fillStateContainer(builder: StateContainer.Builder<Block, BlockState>) {
        super.fillStateContainer(builder.add(gearboxMaterial, gearboxRate))
    }
}

class WoodenGearBox2 : Gearbox(EnumShaftMaterial.WOODEN, 2, Material.WOOD) {
    init {
        this.defaultState =
            defaultState.with(gearboxMaterial, EnumShaftMaterial.WOODEN).with(gearboxRate, GearboxRate.TWO)
    }
}

class WoodenGearBox4 : Gearbox(EnumShaftMaterial.WOODEN, 4, Material.WOOD) {
    init {
        this.defaultState =
            defaultState.with(gearboxMaterial, EnumShaftMaterial.WOODEN).with(gearboxRate, GearboxRate.FOUR)
    }
}

class WoodenGearBox8 : Gearbox(EnumShaftMaterial.WOODEN, 8, Material.WOOD) {
    init {
        this.defaultState =
            defaultState.with(gearboxMaterial, EnumShaftMaterial.WOODEN).with(gearboxRate, GearboxRate.EIGHT)
    }
}

class WoodenGearBox16 : Gearbox(EnumShaftMaterial.WOODEN, 16, Material.WOOD) {
    init {
        this.defaultState =
            defaultState.with(gearboxMaterial, EnumShaftMaterial.WOODEN).with(gearboxRate, GearboxRate.SIXTEEN)
    }
}

class StoneGearBox2 : Gearbox(EnumShaftMaterial.STONE, 2, Material.ROCK) {
    init {
        this.defaultState =
            defaultState.with(gearboxMaterial, EnumShaftMaterial.STONE).with(gearboxRate, GearboxRate.TWO)
    }
}

class StoneGearBox4 : Gearbox(EnumShaftMaterial.STONE, 4, Material.ROCK) {
    init {
        this.defaultState =
            defaultState.with(gearboxMaterial, EnumShaftMaterial.STONE).with(gearboxRate, GearboxRate.FOUR)
    }
}

class StoneGearBox8 : Gearbox(EnumShaftMaterial.STONE, 8, Material.ROCK) {
    init {
        this.defaultState =
            defaultState.with(gearboxMaterial, EnumShaftMaterial.STONE).with(gearboxRate, GearboxRate.EIGHT)
    }
}

class StoneGearBox16 : Gearbox(EnumShaftMaterial.STONE, 16, Material.ROCK) {
    init {
        this.defaultState =
            defaultState.with(gearboxMaterial, EnumShaftMaterial.STONE).with(gearboxRate, GearboxRate.SIXTEEN)
    }
}

class SteelGearBox2 : Gearbox(EnumShaftMaterial.STEEL, 2, Material.IRON) {
    init {
        this.defaultState =
            defaultState.with(gearboxMaterial, EnumShaftMaterial.STEEL).with(gearboxRate, GearboxRate.TWO)
    }
}

class SteelGearBox4 : Gearbox(EnumShaftMaterial.STEEL, 4, Material.IRON) {
    init {
        this.defaultState =
            defaultState.with(gearboxMaterial, EnumShaftMaterial.STEEL).with(gearboxRate, GearboxRate.FOUR)
    }
}

class SteelGearBox8 : Gearbox(EnumShaftMaterial.STEEL, 8, Material.IRON) {
    init {
        this.defaultState =
            defaultState.with(gearboxMaterial, EnumShaftMaterial.STEEL).with(gearboxRate, GearboxRate.EIGHT)
    }
}

class SteelGearBox16 : Gearbox(EnumShaftMaterial.STEEL, 16, Material.IRON) {
    init {
        this.defaultState =
            defaultState.with(gearboxMaterial, EnumShaftMaterial.STEEL).with(gearboxRate, GearboxRate.SIXTEEN)
    }
}

class DiamondGearBox2 : Gearbox(EnumShaftMaterial.DIAMOND, 2, Material.IRON) {
    init {
        this.defaultState =
            defaultState.with(gearboxMaterial, EnumShaftMaterial.DIAMOND).with(gearboxRate, GearboxRate.TWO)
    }
}

class DiamondGearBox4 : Gearbox(EnumShaftMaterial.DIAMOND, 4, Material.IRON) {
    init {
        this.defaultState =
            defaultState.with(gearboxMaterial, EnumShaftMaterial.DIAMOND).with(gearboxRate, GearboxRate.FOUR)
    }
}

class DiamondGearBox8 : Gearbox(EnumShaftMaterial.DIAMOND, 8, Material.IRON) {
    init {
        this.defaultState =
            defaultState.with(gearboxMaterial, EnumShaftMaterial.DIAMOND).with(gearboxRate, GearboxRate.EIGHT)
    }
}

class DiamondGearBox16 : Gearbox(EnumShaftMaterial.DIAMOND, 16, Material.IRON) {
    init {
        this.defaultState =
            defaultState.with(gearboxMaterial, EnumShaftMaterial.DIAMOND).with(gearboxRate, GearboxRate.SIXTEEN)
    }
}

class BedrockGearBox2 : Gearbox(EnumShaftMaterial.BEDROCK, 2, Material.ROCK) {
    init {
        this.defaultState =
            defaultState.with(gearboxMaterial, EnumShaftMaterial.BEDROCK).with(gearboxRate, GearboxRate.TWO)
    }
}

class BedrockGearBox4 : Gearbox(EnumShaftMaterial.BEDROCK, 4, Material.ROCK) {
    init {
        this.defaultState =
            defaultState.with(gearboxMaterial, EnumShaftMaterial.BEDROCK).with(gearboxRate, GearboxRate.FOUR)
    }
}

class BedrockGearBox8 : Gearbox(EnumShaftMaterial.BEDROCK, 8, Material.ROCK) {
    init {
        this.defaultState =
            defaultState.with(gearboxMaterial, EnumShaftMaterial.BEDROCK).with(gearboxRate, GearboxRate.EIGHT)
    }
}

class BedrockGearBox16 : Gearbox(EnumShaftMaterial.BEDROCK, 16, Material.ROCK) {
    init {
        this.defaultState =
            defaultState.with(gearboxMaterial, EnumShaftMaterial.BEDROCK).with(gearboxRate, GearboxRate.SIXTEEN)
    }
}


class GearboxTileEntity : TileEntity(GEARBOX_TYPE.get()) {

}

class GearboxTileEntityRender(dispatcher: TileEntityRendererDispatcher) : RenderWithTextureAndModel<GearboxTileEntity>(
    dispatcher
) {
    companion object {
        val gearboxModel2x = GearboxModel2x()
        val gearboxModel4x = GearboxModel4x()
        val gearboxModel8x = GearboxModel8x()
        val gearboxModel16x = GearboxModel16x()
        val texture = modResourcesLocation("textures/tile_entity/transmission")
        val woodenGearBox2 =
            modResourcesLocation("textures/tile_entity/transmission/gearbox/wooden/wooden_2to1_gearbox/wooden_2to1_gearbox.png")
        val woodenGearBox4 =
            modResourcesLocation("textures/tile_entity/transmission/gearbox/wooden/wooden_4to1_gearbox/wooden_4to1_gearbox.png")
        val woodenGearBox8 =
            modResourcesLocation("textures/tile_entity/transmission/gearbox/wooden/wooden_8to1_gearbox//wooden_8to1_gearbox.png")
        val woodenGearBox16 =
            modResourcesLocation("textures/tile_entity/transmission/gearbox/wooden/wooden_16to1_gearbox/wooden_16to1_gearbox.png")
        val stoneGearBox2 =
            modResourcesLocation("textures/tile_entity/transmission/gearbox/stone/stone_2to1_gearbox/stone_2to1_gearbox.png")
        val stoneGearBox4 =
            modResourcesLocation("textures/tile_entity/transmission/gearbox/stone/stone_4to1_gearbox/stone_4to1_gearbox.png")
        val stoneGearBox8 =
            modResourcesLocation("textures/tile_entity/transmission/gearbox/stone/stone_8to1_gearbox/stone_8to1_gearbox.png")
        val stoneGearBox16 =
            modResourcesLocation("textures/tile_entity/transmission/gearbox/stone/stone_16to1_gearbox/stone_16to1_gearbox.png")
        val steelGearBox2 =
            modResourcesLocation("textures/tile_entity/transmission/gearbox/steel/steel_2to1_gearbox/steel_2to1_gearbox.png")
        val steelGearBox4 =
            modResourcesLocation("textures/tile_entity/transmission/gearbox/steel/steel_4to1_gearbox/steel_4to1_gearbox.png")
        val steelGearBox8 =
            modResourcesLocation("textures/tile_entity/transmission/gearbox/steel/steel_8to1_gearbox/steel_8to1_gearbox.png")
        val steelGearBox16 =
            modResourcesLocation("textures/tile_entity/transmission/gearbox/steel/steel_16to1_gearbox/steel_16to1_gearbox.png")
        val diamondGearBox2 =
            modResourcesLocation("textures/tile_entity/transmission/gearbox/diamond/diamond_2to1_gearbox/diamond_2to1_gearbox.png")
        val diamondGearBox4 =
            modResourcesLocation("textures/tile_entity/transmission/gearbox/diamond/diamond_4to1_gearbox/diamond_4to1_gearbox.png")
        val diamondGearBox8 =
            modResourcesLocation("textures/tile_entity/transmission/gearbox/diamond/diamond_8to1_gearbox/diamond_8to1_gearbox.png")
        val diamondGearBox16 =
            modResourcesLocation("textures/tile_entity/transmission/gearbox/diamond/diamond_16to1_gearbox/diamond_16to1_gearbox.png")
        val bedrockGearBox2 =
            modResourcesLocation("textures/tile_entity/transmission/gearbox/bedrock/bedrock_2to1_gearbox/bedrock_2to1_gearbox.png")
        val bedrockGearBox4 =
            modResourcesLocation("textures/tile_entity/transmission/gearbox/bedrock/bedrock_4to1_gearbox/bedrock_4to1_gearbox.png")
        val bedrockGearBox8 =
            modResourcesLocation("textures/tile_entity/transmission/gearbox/bedrock/bedrock_8to1_gearbox/bedrock_8to1_gearbox.png")
        val bedrockGearBox16 =
            modResourcesLocation("textures/tile_entity/transmission/gearbox/bedrock/bedrock_16to1_gearbox/bedrock_16to1_gearbox.png")

    }

    override fun render(
        tileEntityIn: GearboxTileEntity,
        partialTicks: Float,
        matrixStackIn: MatrixStack,
        bufferIn: IRenderTypeBuffer,
        combinedLightIn: Int,
        combinedOverlayIn: Int,
    ) {
        val texture: ResourceLocation
        val model: Model
        when (tileEntityIn.blockState.get(Gearbox.gearboxRate)!!) {
            Gearbox.GearboxRate.TWO -> {
                model = gearboxModel2x
                texture = when (tileEntityIn.blockState.get(Gearbox.gearboxMaterial)!!) {
                    EnumShaftMaterial.WOODEN -> woodenGearBox2
                    EnumShaftMaterial.STONE -> stoneGearBox2
                    EnumShaftMaterial.STEEL -> steelGearBox2
                    EnumShaftMaterial.DIAMOND -> diamondGearBox2
                    EnumShaftMaterial.BEDROCK -> bedrockGearBox2
                }
            }
            Gearbox.GearboxRate.FOUR -> {
                model = gearboxModel4x
                texture = when (tileEntityIn.blockState.get(Gearbox.gearboxMaterial)!!) {
                    EnumShaftMaterial.WOODEN -> woodenGearBox4
                    EnumShaftMaterial.STONE -> stoneGearBox4
                    EnumShaftMaterial.STEEL -> steelGearBox4
                    EnumShaftMaterial.DIAMOND -> diamondGearBox4
                    EnumShaftMaterial.BEDROCK -> bedrockGearBox4
                }
            }
            Gearbox.GearboxRate.EIGHT -> {
                model = gearboxModel8x
                texture = when (tileEntityIn.blockState.get(Gearbox.gearboxMaterial)!!) {
                    EnumShaftMaterial.WOODEN -> woodenGearBox8
                    EnumShaftMaterial.STONE -> stoneGearBox8
                    EnumShaftMaterial.STEEL -> steelGearBox8
                    EnumShaftMaterial.DIAMOND -> diamondGearBox8
                    EnumShaftMaterial.BEDROCK -> bedrockGearBox8
                }
            }
            Gearbox.GearboxRate.SIXTEEN -> {
                model = gearboxModel16x
                texture = when (tileEntityIn.blockState.get(Gearbox.gearboxMaterial)!!) {
                    EnumShaftMaterial.WOODEN -> woodenGearBox16
                    EnumShaftMaterial.STONE -> stoneGearBox16
                    EnumShaftMaterial.STEEL -> steelGearBox16
                    EnumShaftMaterial.DIAMOND -> diamondGearBox16
                    EnumShaftMaterial.BEDROCK -> bedrockGearBox16
                }
            }
        }
        renderWithTextureAndModel(
            tileEntityIn,
            texture,
            model,
            partialTicks,
            matrixStackIn,
            bufferIn,
            combinedLightIn,
            combinedOverlayIn
        )
    }

    override fun renderWithTextureAndModel(
        tileEntityIn: GearboxTileEntity,
        texture: ResourceLocation,
        model: Model,
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

class GearboxModel2x : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val rotatable: ModelRenderer
    private val side1: ModelRenderer
    private val pos1: ModelRenderer
    private val rot1: ModelRenderer
    private val passer1: ModelRenderer
    private val pos2: ModelRenderer
    private val rot2: ModelRenderer
    private val side2: ModelRenderer
    private val pos3: ModelRenderer
    private val rot3: ModelRenderer
    private val box: ModelRenderer

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
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        side1 = ModelRenderer(this)
        side1.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(side1)
        pos1 = ModelRenderer(this)
        pos1.setRotationPoint(0.0f, 0.0f, 0.0f)
        side1.addChild(pos1)
        pos1.setTextureOffset(10, 46).addBox(5.01f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        pos1.setTextureOffset(48, 21).addBox(5.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        rot1 = ModelRenderer(this)
        rot1.setRotationPoint(0.0f, 0.0f, 0.0f)
        side1.addChild(rot1)
        setRotationAngle(rot1, -0.7854f, 0.0f, 0.0f)
        rot1.setTextureOffset(8, 0).addBox(5.02f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        rot1.setTextureOffset(6, 17).addBox(5.49f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        passer1 = ModelRenderer(this)
        passer1.setRotationPoint(0.0f, -1.0f, -4.0f)
        rotatable.addChild(passer1)
        pos2 = ModelRenderer(this)
        pos2.setRotationPoint(0.0f, 0.0f, 0.0f)
        passer1.addChild(pos2)
        pos2.setTextureOffset(0, 46).addBox(5.0f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        pos2.setTextureOffset(44, 0).addBox(-5.99f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        pos2.setTextureOffset(48, 17).addBox(-5.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f, 0.0f, false)
        rot2 = ModelRenderer(this)
        rot2.setRotationPoint(0.0f, 0.0f, 0.0f)
        passer1.addChild(rot2)
        setRotationAngle(rot2, -0.7854f, 0.0f, 0.0f)
        rot2.setTextureOffset(6, 21).addBox(4.99f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        rot2.setTextureOffset(0, 17).addBox(-5.98f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        rot2.setTextureOffset(36, 41).addBox(-5.0f, -1.0f, -1.0f, 10.0f, 2.0f, 2.0f, 0.0f, false)
        side2 = ModelRenderer(this)
        side2.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(side2)
        pos3 = ModelRenderer(this)
        pos3.setRotationPoint(0.0f, 0.0f, 0.0f)
        side2.addChild(pos3)
        pos3.setTextureOffset(18, 28).addBox(-8.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        pos3.setTextureOffset(36, 28).addBox(-6.0f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        rot3 = ModelRenderer(this)
        rot3.setRotationPoint(0.0f, 0.0f, 0.0f)
        side2.addChild(rot3)
        setRotationAngle(rot3, 0.7854f, 0.0f, 0.0f)
        rot3.setTextureOffset(6, 11).addBox(-8.49f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        rot3.setTextureOffset(0, 25).addBox(-6.01f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        box = ModelRenderer(this)
        box.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(box)
        box.setTextureOffset(36, 28).addBox(7.0f, -8.0f, -5.0f, 1.0f, 3.0f, 10.0f, 0.0f, false)
        box.setTextureOffset(18, 30).addBox(-8.0f, -5.0f, -8.0f, 1.0f, 13.0f, 16.0f, 0.0f, false)
        box.setTextureOffset(0, 17).addBox(7.0f, -5.0f, -8.0f, 1.0f, 13.0f, 16.0f, 0.0f, false)
        box.setTextureOffset(0, 0).addBox(-7.0f, 7.0f, -8.0f, 14.0f, 1.0f, 16.0f, 0.0f, false)
        box.setTextureOffset(18, 23).addBox(-7.0f, 3.0f, -8.0f, 14.0f, 4.0f, 1.0f, 0.0f, false)
        box.setTextureOffset(18, 18).addBox(-7.0f, 3.0f, 7.0f, 14.0f, 4.0f, 1.0f, 0.0f, false)
        box.setTextureOffset(12, 21).addBox(6.0f, 0.0f, 7.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        box.setTextureOffset(8, 6).addBox(6.0f, 0.0f, -8.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        box.setTextureOffset(0, 17).addBox(-7.0f, 0.0f, 7.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        box.setTextureOffset(12, 6).addBox(-7.0f, 0.0f, -8.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        box.setTextureOffset(44, 0).addBox(-8.0f, -8.0f, -5.0f, 1.0f, 3.0f, 10.0f, 0.0f, false)
        box.setTextureOffset(0, 0).addBox(-0.5f, -3.0f, -5.5f, 1.0f, 10.0f, 3.0f, 0.0f, false)
    }
}

class GearboxModel4x : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val rotatable: ModelRenderer
    private val side1: ModelRenderer
    private val pos1: ModelRenderer
    private val rot1: ModelRenderer
    private val passer1: ModelRenderer
    private val pos2: ModelRenderer
    private val rot2: ModelRenderer
    private val passer3: ModelRenderer
    private val pos5: ModelRenderer
    private val rot5: ModelRenderer
    private val passer2: ModelRenderer
    private val pos4: ModelRenderer
    private val rot4: ModelRenderer
    private val side2: ModelRenderer
    private val pos3: ModelRenderer
    private val rot3: ModelRenderer
    private val box: ModelRenderer

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
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        side1 = ModelRenderer(this)
        side1.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(side1)
        pos1 = ModelRenderer(this)
        pos1.setRotationPoint(0.0f, 0.0f, 0.0f)
        side1.addChild(pos1)
        pos1.setTextureOffset(28, 59).addBox(5.01f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        pos1.setTextureOffset(36, 59).addBox(5.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        rot1 = ModelRenderer(this)
        rot1.setRotationPoint(0.0f, 0.0f, 0.0f)
        side1.addChild(rot1)
        setRotationAngle(rot1, -0.7854f, 0.0f, 0.0f)
        rot1.setTextureOffset(20, 59).addBox(5.02f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        rot1.setTextureOffset(58, 21).addBox(5.49f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        passer1 = ModelRenderer(this)
        passer1.setRotationPoint(8.5f, -1.0f, -4.0f)
        rotatable.addChild(passer1)
        pos2 = ModelRenderer(this)
        pos2.setRotationPoint(-8.5f, 0.0f, 0.0f)
        passer1.addChild(pos2)
        pos2.setTextureOffset(10, 55).addBox(4.99f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        pos2.setTextureOffset(36, 28).addBox(-0.48f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        pos2.setTextureOffset(54, 17).addBox(0.0f, -1.0f, -1.0f, 5.0f, 2.0f, 2.0f, 0.0f, false)
        rot2 = ModelRenderer(this)
        rot2.setRotationPoint(-8.5f, 0.0f, 0.0f)
        passer1.addChild(rot2)
        setRotationAngle(rot2, 0.7854f, 0.0f, 0.0f)
        rot2.setTextureOffset(52, 52).addBox(4.98f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        rot2.setTextureOffset(44, 0).addBox(-0.47f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        rot2.setTextureOffset(0, 50).addBox(0.0f, -1.0f, -1.0f, 5.0f, 2.0f, 2.0f, 0.0f, false)
        passer3 = ModelRenderer(this)
        passer3.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(passer3)
        pos5 = ModelRenderer(this)
        pos5.setRotationPoint(-5.5f, 0.0f, 0.0f)
        passer3.addChild(pos5)
        pos5.setTextureOffset(58, 29).addBox(5.0f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        pos5.setTextureOffset(0, 46).addBox(2.0f, -1.0f, -1.0f, 7.0f, 2.0f, 2.0f, 0.0f, false)
        rot5 = ModelRenderer(this)
        rot5.setRotationPoint(-5.5f, 0.0f, 0.0f)
        passer3.addChild(rot5)
        setRotationAngle(rot5, -0.7854f, 0.0f, 0.0f)
        rot5.setTextureOffset(56, 0).addBox(5.01f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        rot5.setTextureOffset(36, 41).addBox(1.99f, -1.0f, -1.0f, 7.0f, 2.0f, 2.0f, 0.0f, false)
        passer2 = ModelRenderer(this)
        passer2.setRotationPoint(3.0f, 1.0f, 4.25f)
        rotatable.addChild(passer2)
        pos4 = ModelRenderer(this)
        pos4.setRotationPoint(-8.5f, 0.0f, 0.0f)
        passer2.addChild(pos4)
        pos4.setTextureOffset(48, 29).addBox(4.99f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        pos4.setTextureOffset(58, 49).addBox(-0.48f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        pos4.setTextureOffset(48, 25).addBox(0.0f, -1.0f, -1.0f, 5.0f, 2.0f, 2.0f, 0.0f, false)
        rot4 = ModelRenderer(this)
        rot4.setRotationPoint(-8.5f, 0.0f, 0.0f)
        passer2.addChild(rot4)
        setRotationAngle(rot4, 0.7854f, 0.0f, 0.0f)
        rot4.setTextureOffset(48, 17).addBox(4.98f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        rot4.setTextureOffset(58, 35).addBox(-0.49f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        rot4.setTextureOffset(18, 28).addBox(0.0f, -1.0f, -1.0f, 5.0f, 2.0f, 2.0f, 0.0f, false)
        side2 = ModelRenderer(this)
        side2.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(side2)
        pos3 = ModelRenderer(this)
        pos3.setRotationPoint(0.0f, 0.0f, 0.0f)
        side2.addChild(pos3)
        pos3.setTextureOffset(58, 41).addBox(-8.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        pos3.setTextureOffset(0, 54).addBox(-6.0f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        rot3 = ModelRenderer(this)
        rot3.setRotationPoint(0.0f, 0.0f, 0.0f)
        side2.addChild(rot3)
        setRotationAngle(rot3, 0.7854f, 0.0f, 0.0f)
        rot3.setTextureOffset(56, 6).addBox(-8.49f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        rot3.setTextureOffset(52, 41).addBox(-6.01f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        box = ModelRenderer(this)
        box.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(box)
        box.setTextureOffset(36, 28).addBox(7.0f, -8.0f, -5.0f, 1.0f, 3.0f, 10.0f, 0.0f, false)
        box.setTextureOffset(18, 30).addBox(-8.0f, -5.0f, -8.0f, 1.0f, 13.0f, 16.0f, 0.0f, false)
        box.setTextureOffset(0, 17).addBox(7.0f, -5.0f, -8.0f, 1.0f, 13.0f, 16.0f, 0.0f, false)
        box.setTextureOffset(0, 0).addBox(-7.0f, 7.0f, -8.0f, 14.0f, 1.0f, 16.0f, 0.0f, false)
        box.setTextureOffset(18, 23).addBox(-7.0f, 3.0f, -8.0f, 14.0f, 4.0f, 1.0f, 0.0f, false)
        box.setTextureOffset(18, 18).addBox(-7.0f, 3.0f, 7.0f, 14.0f, 4.0f, 1.0f, 0.0f, false)
        box.setTextureOffset(48, 17).addBox(6.0f, 0.0f, 7.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        box.setTextureOffset(36, 28).addBox(6.0f, 0.0f, -8.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        box.setTextureOffset(44, 0).addBox(-7.0f, 0.0f, 7.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        box.setTextureOffset(42, 28).addBox(-7.0f, 0.0f, -8.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        box.setTextureOffset(44, 0).addBox(-8.0f, -8.0f, -5.0f, 1.0f, 3.0f, 10.0f, 0.0f, false)
        box.setTextureOffset(8, 17).addBox(2.25f, -3.0f, -5.5f, 1.0f, 10.0f, 3.0f, 0.0f, false)
        box.setTextureOffset(0, 17).addBox(2.25f, -2.0f, -1.5f, 1.0f, 9.0f, 3.0f, 0.0f, false)
        box.setTextureOffset(8, 0).addBox(-3.25f, -2.0f, -1.5f, 1.0f, 9.0f, 3.0f, 0.0f, false)
        box.setTextureOffset(0, 0).addBox(-3.25f, -1.0f, 2.75f, 1.0f, 8.0f, 3.0f, 0.0f, false)
    }
}

class GearboxModel8x : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val rotatable: ModelRenderer
    private val side1: ModelRenderer
    private val pos1: ModelRenderer
    private val rot1: ModelRenderer
    private val passer1: ModelRenderer
    private val pos2: ModelRenderer
    private val rot2: ModelRenderer
    private val passer3: ModelRenderer
    private val pos5: ModelRenderer
    private val rot5: ModelRenderer
    private val passer2: ModelRenderer
    private val pos4: ModelRenderer
    private val rot4: ModelRenderer
    private val side2: ModelRenderer
    private val pos3: ModelRenderer
    private val rot3: ModelRenderer
    private val box: ModelRenderer

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
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        side1 = ModelRenderer(this)
        side1.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(side1)
        pos1 = ModelRenderer(this)
        pos1.setRotationPoint(0.0f, 0.0f, 0.0f)
        side1.addChild(pos1)
        pos1.setTextureOffset(7, 59).addBox(5.01f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        pos1.setTextureOffset(31, 59).addBox(5.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        rot1 = ModelRenderer(this)
        rot1.setRotationPoint(0.0f, 0.0f, 0.0f)
        side1.addChild(rot1)
        setRotationAngle(rot1, -0.7854f, 0.0f, 0.0f)
        rot1.setTextureOffset(58, 36).addBox(5.02f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        rot1.setTextureOffset(56, 4).addBox(5.49f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        passer1 = ModelRenderer(this)
        passer1.setRotationPoint(8.5f, -1.0f, -4.0f)
        rotatable.addChild(passer1)
        pos2 = ModelRenderer(this)
        pos2.setRotationPoint(-8.5f, 0.0f, 0.0f)
        passer1.addChild(pos2)
        pos2.setTextureOffset(54, 21).addBox(5.0f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        pos2.setTextureOffset(0, 46).addBox(1.51f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        pos2.setTextureOffset(21, 59).addBox(2.0f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        rot2 = ModelRenderer(this)
        rot2.setRotationPoint(-8.5f, 0.0f, 0.0f)
        passer1.addChild(rot2)
        setRotationAngle(rot2, 0.7854f, 0.0f, 0.0f)
        rot2.setTextureOffset(52, 52).addBox(4.99f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        rot2.setTextureOffset(48, 17).addBox(1.52f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        rot2.setTextureOffset(54, 17).addBox(2.0f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        passer3 = ModelRenderer(this)
        passer3.setRotationPoint(-5.5f, 0.0f, 0.0f)
        rotatable.addChild(passer3)
        pos5 = ModelRenderer(this)
        pos5.setRotationPoint(0.0f, 0.0f, 0.0f)
        passer3.addChild(pos5)
        pos5.setTextureOffset(44, 0).addBox(7.01f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        pos5.setTextureOffset(8, 17).addBox(3.0f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        pos5.setTextureOffset(36, 41).addBox(2.5f, -1.0f, -1.0f, 6.0f, 2.0f, 2.0f, 0.0f, false)
        rot5 = ModelRenderer(this)
        rot5.setRotationPoint(0.0f, 0.0f, 0.0f)
        passer3.addChild(rot5)
        setRotationAngle(rot5, -0.7854f, 0.0f, 0.0f)
        rot5.setTextureOffset(8, 23).addBox(2.99f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        rot5.setTextureOffset(18, 28).addBox(2.49f, -1.0f, -1.0f, 6.0f, 2.0f, 2.0f, 0.0f, false)
        rot5.setTextureOffset(36, 28).addBox(7.02f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        passer2 = ModelRenderer(this)
        passer2.setRotationPoint(3.0f, 1.0f, 4.25f)
        rotatable.addChild(passer2)
        pos4 = ModelRenderer(this)
        pos4.setRotationPoint(-8.5f, 0.0f, 0.0f)
        passer2.addChild(pos4)
        pos4.setTextureOffset(6, 50).addBox(3.0f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        pos4.setTextureOffset(13, 56).addBox(-0.49f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        pos4.setTextureOffset(6, 46).addBox(0.0f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        rot4 = ModelRenderer(this)
        rot4.setRotationPoint(-8.5f, 0.0f, 0.0f)
        passer2.addChild(rot4)
        setRotationAngle(rot4, 0.7854f, 0.0f, 0.0f)
        rot4.setTextureOffset(48, 25).addBox(2.99f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        rot4.setTextureOffset(55, 30).addBox(-0.48f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        rot4.setTextureOffset(6, 29).addBox(0.0f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        side2 = ModelRenderer(this)
        side2.setRotationPoint(-5.5f, 0.0f, 0.0f)
        rotatable.addChild(side2)
        pos3 = ModelRenderer(this)
        pos3.setRotationPoint(5.5f, 0.0f, 0.0f)
        side2.addChild(pos3)
        pos3.setTextureOffset(58, 49).addBox(-8.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        pos3.setTextureOffset(0, 54).addBox(-6.0f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        rot3 = ModelRenderer(this)
        rot3.setRotationPoint(5.5f, 0.0f, 0.0f)
        side2.addChild(rot3)
        setRotationAngle(rot3, 0.7854f, 0.0f, 0.0f)
        rot3.setTextureOffset(56, 0).addBox(-8.49f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        rot3.setTextureOffset(52, 41).addBox(-6.01f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        box = ModelRenderer(this)
        box.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(box)
        box.setTextureOffset(36, 28).addBox(7.0f, -8.0f, -5.0f, 1.0f, 3.0f, 10.0f, 0.0f, false)
        box.setTextureOffset(18, 30).addBox(-8.0f, -5.0f, -8.0f, 1.0f, 13.0f, 16.0f, 0.0f, false)
        box.setTextureOffset(0, 17).addBox(7.0f, -5.0f, -8.0f, 1.0f, 13.0f, 16.0f, 0.0f, false)
        box.setTextureOffset(0, 0).addBox(-7.0f, 7.0f, -8.0f, 14.0f, 1.0f, 16.0f, 0.0f, false)
        box.setTextureOffset(18, 23).addBox(-7.0f, 3.0f, -8.0f, 14.0f, 4.0f, 1.0f, 0.0f, false)
        box.setTextureOffset(18, 18).addBox(-7.0f, 3.0f, 7.0f, 14.0f, 4.0f, 1.0f, 0.0f, false)
        box.setTextureOffset(0, 46).addBox(6.0f, 0.0f, 7.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        box.setTextureOffset(36, 28).addBox(6.0f, 0.0f, -8.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        box.setTextureOffset(44, 0).addBox(-7.0f, 0.0f, 7.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        box.setTextureOffset(42, 28).addBox(-7.0f, 0.0f, -8.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        box.setTextureOffset(44, 0).addBox(-8.0f, -8.0f, -5.0f, 1.0f, 3.0f, 10.0f, 0.0f, false)
        box.setTextureOffset(0, 17).addBox(3.25f, -3.0f, -5.5f, 1.0f, 10.0f, 3.0f, 0.0f, false)
        box.setTextureOffset(8, 0).addBox(-4.25f, -3.0f, 2.75f, 1.0f, 10.0f, 3.0f, 0.0f, false)
        box.setTextureOffset(0, 0).addBox(-0.5f, -3.0f, -1.5f, 1.0f, 10.0f, 3.0f, 0.0f, false)
    }
}

class GearboxModel16x : Model(RenderType::getEntitySolid) {
    private val shell: ModelRenderer
    private val rotatable: ModelRenderer
    private val side1: ModelRenderer
    private val pos1: ModelRenderer
    private val rot1: ModelRenderer
    private val passer1: ModelRenderer
    private val pos2: ModelRenderer
    private val rot2: ModelRenderer
    private val passer5: ModelRenderer
    private val pos7: ModelRenderer
    private val rot7: ModelRenderer
    private val passer3: ModelRenderer
    private val pos5: ModelRenderer
    private val rot5: ModelRenderer
    private val passer2: ModelRenderer
    private val pos4: ModelRenderer
    private val rot4: ModelRenderer
    private val passer4: ModelRenderer
    private val pos6: ModelRenderer
    private val rot6: ModelRenderer
    private val side2: ModelRenderer
    private val pos3: ModelRenderer
    private val rot3: ModelRenderer
    private val box: ModelRenderer

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
        rotatable = ModelRenderer(this)
        rotatable.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(rotatable)
        side1 = ModelRenderer(this)
        side1.setRotationPoint(0.0f, 0.0f, 0.0f)
        rotatable.addChild(side1)
        pos1 = ModelRenderer(this)
        pos1.setRotationPoint(0.0f, 0.0f, 0.0f)
        side1.addChild(pos1)
        pos1.setTextureOffset(58, 49).addBox(5.01f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        pos1.setTextureOffset(21, 59).addBox(5.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        rot1 = ModelRenderer(this)
        rot1.setRotationPoint(0.0f, 0.0f, 0.0f)
        side1.addChild(rot1)
        setRotationAngle(rot1, -0.7854f, 0.0f, 0.0f)
        rot1.setTextureOffset(5, 58).addBox(5.02f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        rot1.setTextureOffset(56, 4).addBox(5.49f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        passer1 = ModelRenderer(this)
        passer1.setRotationPoint(2.0f, -1.0f, -4.0f)
        rotatable.addChild(passer1)
        pos2 = ModelRenderer(this)
        pos2.setRotationPoint(-2.0f, 0.0f, 0.0f)
        passer1.addChild(pos2)
        pos2.setTextureOffset(52, 41).addBox(5.0f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        pos2.setTextureOffset(58, 40).addBox(2.0f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        pos2.setTextureOffset(0, 55).addBox(1.5f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        rot2 = ModelRenderer(this)
        rot2.setRotationPoint(-2.0f, 0.0f, 0.0f)
        passer1.addChild(rot2)
        setRotationAngle(rot2, 0.7854f, 0.0f, 0.0f)
        rot2.setTextureOffset(48, 25).addBox(4.99f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        rot2.setTextureOffset(54, 17).addBox(2.0f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        rot2.setTextureOffset(55, 22).addBox(1.49f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        passer5 = ModelRenderer(this)
        passer5.setRotationPoint(2.0f, 1.0f, 4.0f)
        rotatable.addChild(passer5)
        pos7 = ModelRenderer(this)
        pos7.setRotationPoint(-2.0f, 0.0f, 0.0f)
        passer5.addChild(pos7)
        pos7.setTextureOffset(52, 41).addBox(5.0f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        pos7.setTextureOffset(58, 40).addBox(2.0f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        pos7.setTextureOffset(0, 55).addBox(1.5f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        rot7 = ModelRenderer(this)
        rot7.setRotationPoint(-2.0f, 0.0f, 0.0f)
        passer5.addChild(rot7)
        setRotationAngle(rot7, 0.7854f, 0.0f, 0.0f)
        rot7.setTextureOffset(48, 25).addBox(4.99f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        rot7.setTextureOffset(54, 17).addBox(2.0f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        rot7.setTextureOffset(55, 22).addBox(1.49f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        passer3 = ModelRenderer(this)
        passer3.setRotationPoint(-5.5f, 0.0f, 0.0f)
        rotatable.addChild(passer3)
        pos5 = ModelRenderer(this)
        pos5.setRotationPoint(0.0f, 0.0f, 0.0f)
        passer3.addChild(pos5)
        pos5.setTextureOffset(36, 28).addBox(7.01f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        pos5.setTextureOffset(8, 17).addBox(3.01f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        pos5.setTextureOffset(36, 41).addBox(2.5f, -1.0f, -1.0f, 6.0f, 2.0f, 2.0f, 0.0f, false)
        rot5 = ModelRenderer(this)
        rot5.setRotationPoint(0.0f, 0.0f, 0.0f)
        passer3.addChild(rot5)
        setRotationAngle(rot5, -0.7854f, 0.0f, 0.0f)
        rot5.setTextureOffset(44, 0).addBox(7.02f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        rot5.setTextureOffset(8, 23).addBox(3.02f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        rot5.setTextureOffset(18, 28).addBox(2.49f, -1.0f, -1.0f, 6.0f, 2.0f, 2.0f, 0.0f, false)
        passer2 = ModelRenderer(this)
        passer2.setRotationPoint(0.0f, -1.0f, 4.25f)
        rotatable.addChild(passer2)
        pos4 = ModelRenderer(this)
        pos4.setRotationPoint(-5.5f, 0.0f, 0.0f)
        passer2.addChild(pos4)
        pos4.setTextureOffset(48, 17).addBox(3.0f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        pos4.setTextureOffset(13, 56).addBox(-0.49f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        pos4.setTextureOffset(6, 46).addBox(0.0f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        rot4 = ModelRenderer(this)
        rot4.setRotationPoint(-5.5f, 0.0f, 0.0f)
        passer2.addChild(rot4)
        setRotationAngle(rot4, 0.7854f, 0.0f, 0.0f)
        rot4.setTextureOffset(0, 46).addBox(2.99f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        rot4.setTextureOffset(55, 30).addBox(-0.48f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        rot4.setTextureOffset(6, 29).addBox(0.0f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        passer4 = ModelRenderer(this)
        passer4.setRotationPoint(0.0f, 1.0f, -3.75f)
        rotatable.addChild(passer4)
        pos6 = ModelRenderer(this)
        pos6.setRotationPoint(-5.5f, 0.0f, 0.0f)
        passer4.addChild(pos6)
        pos6.setTextureOffset(48, 17).addBox(3.0f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        pos6.setTextureOffset(13, 56).addBox(-0.49f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        pos6.setTextureOffset(6, 46).addBox(0.0f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        rot6 = ModelRenderer(this)
        rot6.setRotationPoint(-5.5f, 0.0f, 0.0f)
        passer4.addChild(rot6)
        setRotationAngle(rot6, 0.7854f, 0.0f, 0.0f)
        rot6.setTextureOffset(0, 46).addBox(2.99f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        rot6.setTextureOffset(55, 30).addBox(-0.48f, -1.5f, -1.5f, 1.0f, 3.0f, 3.0f, 0.0f, false)
        rot6.setTextureOffset(6, 29).addBox(0.0f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        side2 = ModelRenderer(this)
        side2.setRotationPoint(-5.5f, 0.0f, 0.0f)
        rotatable.addChild(side2)
        pos3 = ModelRenderer(this)
        pos3.setRotationPoint(5.5f, 0.0f, 0.0f)
        side2.addChild(pos3)
        pos3.setTextureOffset(58, 36).addBox(-8.5f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        pos3.setTextureOffset(52, 52).addBox(-6.0f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        rot3 = ModelRenderer(this)
        rot3.setRotationPoint(5.5f, 0.0f, 0.0f)
        side2.addChild(rot3)
        setRotationAngle(rot3, 0.7854f, 0.0f, 0.0f)
        rot3.setTextureOffset(56, 0).addBox(-8.49f, -1.0f, -1.0f, 3.0f, 2.0f, 2.0f, 0.0f, false)
        rot3.setTextureOffset(6, 50).addBox(-6.01f, -2.0f, -2.0f, 1.0f, 4.0f, 4.0f, 0.0f, false)
        box = ModelRenderer(this)
        box.setRotationPoint(0.0f, 0.0f, 0.0f)
        shell.addChild(box)
        box.setTextureOffset(36, 28).addBox(7.0f, -8.0f, -5.0f, 1.0f, 3.0f, 10.0f, 0.0f, false)
        box.setTextureOffset(18, 30).addBox(-8.0f, -5.0f, -8.0f, 1.0f, 13.0f, 16.0f, 0.0f, false)
        box.setTextureOffset(0, 17).addBox(7.0f, -5.0f, -8.0f, 1.0f, 13.0f, 16.0f, 0.0f, false)
        box.setTextureOffset(0, 0).addBox(-7.0f, 7.0f, -8.0f, 14.0f, 1.0f, 16.0f, 0.0f, false)
        box.setTextureOffset(18, 23).addBox(-7.0f, 3.0f, -8.0f, 14.0f, 4.0f, 1.0f, 0.0f, false)
        box.setTextureOffset(18, 18).addBox(-7.0f, 3.0f, 7.0f, 14.0f, 4.0f, 1.0f, 0.0f, false)
        box.setTextureOffset(0, 46).addBox(6.0f, 0.0f, 7.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        box.setTextureOffset(36, 28).addBox(6.0f, 0.0f, -8.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        box.setTextureOffset(44, 0).addBox(-7.0f, 0.0f, 7.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        box.setTextureOffset(42, 28).addBox(-7.0f, 0.0f, -8.0f, 1.0f, 3.0f, 1.0f, 0.0f, false)
        box.setTextureOffset(44, 0).addBox(-8.0f, -8.0f, -5.0f, 1.0f, 3.0f, 10.0f, 0.0f, false)
        box.setTextureOffset(0, 17).addBox(3.25f, -3.0f, -5.5f, 1.0f, 10.0f, 3.0f, 0.0f, false)
        box.setTextureOffset(0, 17).addBox(3.25f, -3.0f, 2.5f, 1.0f, 10.0f, 3.0f, 0.0f, false)
        box.setTextureOffset(0, 17).addBox(3.25f, -3.0f, -5.5f, 1.0f, 10.0f, 3.0f, 0.0f, false)
        box.setTextureOffset(8, 0).addBox(-4.25f, -3.0f, 2.75f, 1.0f, 10.0f, 3.0f, 0.0f, false)
        box.setTextureOffset(8, 0).addBox(-4.25f, -3.0f, -5.25f, 1.0f, 10.0f, 3.0f, 0.0f, false)
        box.setTextureOffset(0, 0).addBox(-0.5f, -3.0f, -1.5f, 1.0f, 10.0f, 3.0f, 0.0f, false)
    }
}
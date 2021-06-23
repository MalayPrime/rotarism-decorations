package com.github.malayP.decorations

import com.github.malayP.decorations.register.RegisterCenter
import com.github.zomb_676.fantasySoup.manuallyInitClass
import net.minecraftforge.fml.common.Mod
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import java.io.File

@Mod(Decorations.modId)
class Decorations {

    init {
        RegisterCenter::class.manuallyInitClass()
    }

    companion object {
        const val modId = "decorations"
        const val modName = "Decorations"
        val logger: Logger = LogManager.getLogger(modName)
    }

}

//fun main() {
//    val items = """
//        com.github.malayP.decorations.block.machine.machine.PulseJetFurnace
//        com.github.malayP.decorations.block.machine.machine.WoodCutter
//        com.github.malayP.decorations.block.machine.machine.Extractor
//        com.github.malayP.decorations.block.machine.machine.ReverseGear
//        com.github.malayP.decorations.block.machine.machine.Pump
//        com.github.malayP.decorations.block.machine.machine.BlastFurnace
//        com.github.malayP.decorations.block.machine.machine.RemeltingTable
//        com.github.malayP.decorations.block.machine.machine.Worktable
//        com.github.malayP.decorations.block.machine.machine.BedrockBreaker
//        com.github.malayP.decorations.block.machine.machine.EnhancedBedrockBreaker
//        com.github.malayP.decorations.block.machine.machine.GroundSprinkler
//        com.github.malayP.decorations.block.machine.machine.GroundSprinkler
//    """.trimIndent().split("\n")
//    items.forEach(genTEISR())
//}

val template="{\n" +
        "  \"variants\": {\n" +
        "    \"\": {\n" +
        "    }\n" +
        "  }\n" +
        "}"

private fun extractClass() = { item:String ->
    val sb = StringBuilder()
    sb.append(
        "import com.github.malayP.decorations.modResourcesLocation\n" +
                "import com.github.malayP.decorations.register.AllTileEntity.${lowerFirst(item).plus("Type")}\n" +
                "import com.github.zomb_676.fantasySoup.block.HorizonBlockWithTileEntity\n" +
                "import com.mojang.blaze3d.matrix.MatrixStack\n" +
                "import com.mojang.blaze3d.vertex.IVertexBuilder\n" +
                "import net.minecraft.block.BlockState\n" +
                "import net.minecraft.block.material.Material\n" +
                "import net.minecraft.client.renderer.IRenderTypeBuffer\n" +
                "import net.minecraft.client.renderer.RenderType\n" +
                "import net.minecraft.client.renderer.model.Model\n" +
                "import net.minecraft.client.renderer.model.ModelRenderer\n" +
                "import net.minecraft.client.renderer.tileentity.TileEntityRenderer\n" +
                "import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher\n" +
                "import net.minecraft.state.properties.BlockStateProperties\n" +
                "import net.minecraft.tileentity.TileEntity\n" +
                "import net.minecraft.util.ResourceLocation\n" +
                "import net.minecraft.util.math.vector.Vector3f\n" +
                "import net.minecraft.world.IBlockReader\n"
    )
    sb.append("class").append(" ").append(item).append(":")
        .append("HorizonBlockWithTileEntity(Properties.create(Material.IRON)) {")
        .append("\n")
        .append("override fun createTileEntity(state: BlockState?, world: IBlockReader?): TileEntity = ${item.plus("TileEntity")}()")
        .append("}").append("\n")
        .append("class").append(" ").append(item.plus("TileEntity")).append(":TileEntity")
        .append("(${lowerFirst(item).plus("Type")}.get()) {}").append("\n")
        .append("class").append(" ").append(item.plus("TileEntityRender"))
        .append("(dispatcher: TileEntityRendererDispatcher) :")
        .append("TileEntityRenderer").append("<${item.plus("TileEntity")}>").append("(dispatcher)")
        .append("{").append("companion object{\nval model= ${item.plus("Model()")}")
        .append("\n").append("val texture:ResourceLocation").append("}").append("\n")
        .append(
            " override fun render(\n" +
                    "        tileEntityIn: ${item.plus("TileEntity")},\n" +
                    "        partialTicks: Float,\n" +
                    "        matrixStackIn: MatrixStack,\n" +
                    "        bufferIn: IRenderTypeBuffer,\n" +
                    "        combinedLightIn: Int,\n" +
                    "        combinedOverlayIn: Int,\n" +
                    "    ) {}"
        ).append("}")
    File("src/main/kotlin/com/github/malayP/decorations/block/temp/${item.plus(".kt")}").writeText(sb.toString())
}
private fun genBlocks()={ item:String->
    val sb = StringBuilder()
    sb.append("val ${lowerFirst(item).plus("Block")}").append(":BlockItemPair<BlockItem,$item> ").append("=").append("\n")
        .append("block().blockWithItem(").append("\n")
        .append("$item::new.java, itemGroup = transformerGroup,").append("\n")
        .append("ister=RenderWithTextureAndModelISTER(").append("\n")
        .append("${item.plus("TileEntityRender")}.texture").append("\n")
        .append("${item.plus("TileEntityRender")}.model").append("\n")
        .append(")").append("\n")
        .append(")").append("\n")
    println(sb.toString())
}
private fun genTe()={item:String ->
    val sb = StringBuilder()
    sb.append("val ${lowerFirst(item).plus("Type")}").append(":")
        .append("RegistryObject<TileEntityType<${item.plus("TileEntity")}>> ").append("=")
        .append("tileEntityType().tileEntityBlind(\n")
        .append("\"${fixer(item)}\"").append(",\n")
        .append("${item.plus("TileEntity")}::class.java,\n")
        .append("${item.plus("TileEntityRender")}::class.java,\n")
        .append(".block\n")
        .append(")")
    println(sb.toString())
}
private fun genTEISR()={item:String->
    val content ="{\n" +
            "  \"parent\": \"minecraft:builtin/entity\",\n" +
            "  \"display\": {\n" +
            "    \"gui\": {\n" +
            "      \"rotation\": [\n" +
            "        30,\n" +
            "        45,\n" +
            "        0\n" +
            "      ],\n" +
            "      \"scale\": [\n" +
            "        0.625,\n" +
            "        0.625,\n" +
            "        0.625\n" +
            "      ]\n" +
            "    },\n" +
            "    \"ground\": {\n" +
            "      \"translation\": [\n" +
            "        0,\n" +
            "        3,\n" +
            "        0\n" +
            "      ],\n" +
            "      \"scale\": [\n" +
            "        0.25,\n" +
            "        0.25,\n" +
            "        0.25\n" +
            "      ]\n" +
            "    },\n" +
            "    \"head\": {\n" +
            "      \"rotation\": [\n" +
            "        0,\n" +
            "        180,\n" +
            "        0\n" +
            "      ],\n" +
            "      \"scale\": [\n" +
            "        0,\n" +
            "        0,\n" +
            "        0\n" +
            "      ]\n" +
            "    },\n" +
            "    \"fixed\": {\n" +
            "      \"rotation\": [\n" +
            "        0,\n" +
            "        180,\n" +
            "        0\n" +
            "      ],\n" +
            "      \"scale\": [\n" +
            "        0.5,\n" +
            "        0.5,\n" +
            "        0.5\n" +
            "      ]\n" +
            "    },\n" +
            "    \"thirdperson_righthand\": {\n" +
            "      \"rotation\": [\n" +
            "        75,\n" +
            "        315,\n" +
            "        0\n" +
            "      ],\n" +
            "      \"translation\": [\n" +
            "        0,\n" +
            "        2.5,\n" +
            "        0\n" +
            "      ],\n" +
            "      \"scale\": [\n" +
            "        0.375,\n" +
            "        0.375,\n" +
            "        0.375\n" +
            "      ]\n" +
            "    },\n" +
            "    \"firstperson_righthand\": {\n" +
            "      \"rotation\": [\n" +
            "        0,\n" +
            "        315,\n" +
            "        0\n" +
            "      ],\n" +
            "      \"scale\": [\n" +
            "        0.4,\n" +
            "        0.4,\n" +
            "        0.4\n" +
            "      ]\n" +
            "    }\n" +
            "  }\n" +
            "}"
    File("src/generated/resources/assets/decorations/models/temp/${fixer(item).plus(".json")}").writeText(content)

}
fun lowerFirst(string: String):String{
    val toCharArray = string.toCharArray()
    toCharArray[0]=toCharArray[0].lowercaseChar()
    return toCharArray.joinToString("")
}

private fun fixer(string: String): String {
    if (string.any { it.isUpperCase() and !it.isDigit() and (it != '_') }) {
        val stringBuilder = StringBuilder()
        string.mapIndexed { index: Int, char: Char ->
            if (char.isLowerCase()) {
                stringBuilder.append(char)
            } else if (char.isDigit()) {
                if (index == 0) {
                    stringBuilder.append(char)
                } else {
                    stringBuilder.append("_".plus(char))
                }
            } else {
                if (index == 0) {
                    stringBuilder.append(char.lowercaseChar())
                } else if (index == string.length - 1) {
                    stringBuilder.append(char.lowercaseChar())
                } else if (string[index + 1].isLowerCase()) {
                    stringBuilder.append("_".plus(char.lowercaseChar()))
                } else if (string[index - 1].isLowerCase() and string[index + 1].isUpperCase()) {
                    stringBuilder.append("_".plus(char.lowercaseChar()))
                } else if (string[index - 1].isUpperCase() and (string[index + 1].isUpperCase() or string[index + 1].isDigit())) {
                    stringBuilder.append(char.lowercaseChar())
                } else {
                    stringBuilder.append(char)
                }
            }
        }
        return stringBuilder.toString()
    } else {
        return string
    }

}

fun main() {
    val files : MutableList<File> = mutableListOf()
    val path = "src/generated/resources/assets/decorations/models"
    files.addAll(File(path.plus("/block")).listFiles()!!)
    files.addAll(File(path.plus("/item")).listFiles()!!)
    files.map { it.name }.map { "src/generated/resources/assets/decorations/blockstates/$it" }.map { File(it) }.forEach {
        it.writeText(template)
    }
}
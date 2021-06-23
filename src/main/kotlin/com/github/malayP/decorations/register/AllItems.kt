package com.github.malayP.decorations.register

import com.github.malayP.decorations.dataGen.generatedModelWithOneTexture
import com.github.malayP.decorations.register.AllItemGroup.decorations
import com.github.malayP.decorations.register.RegisterCenter.registerHandleInstance
import com.github.malayP.decorations.specification.items.tools.Detector
import com.github.malayP.decorations.specification.items.tools.Wrench
import com.github.zomb_676.fantasySoup.register.ItemRegisterInstance


object AllItems {
    val item: () -> ItemRegisterInstance = registerHandleInstance::registerItem

    // material
    val aluminumAlloyIngot = item()
        .simpleItem("aluminum_alloy_ingot", decorations)
        .generatedModelWithOneTexture("item/ingots/aluminum_alloy/aluminum_alloy_ingot")
    val aluminumIngot = item()
        .simpleItem("aluminum_ingot", decorations)
        .generatedModelWithOneTexture("item/ingots/aluminum_ingot/aluminum_ingot")
    val bedrockAlloyIngot = item()
        .simpleItem("bedrock_alloy_ingot", decorations)
        .generatedModelWithOneTexture("item/ingots/bedrock_alloy/bedrock_alloy_ingot")
    val HSLASteelIngot = item()
        .simpleItem("hsla_steel_ingot", decorations)
        .generatedModelWithOneTexture("item/ingots/hsla_steel/hsla_steel_ingot")
    val HSLASteelPlate = item()
        .simpleItem("hsla_steel_plate", decorations)
        .generatedModelWithOneTexture("item/ingots/hsla_steel/hsla_steel_plate")
    val HSLASteelStick = item()
        .simpleItem("hsla_steel_stick", decorations)
        .generatedModelWithOneTexture("item/ingots/hsla_steel/hsla_steel_stick")
    val inductiveIngot = item()
        .simpleItem("inductive_ingot", decorations)
        .generatedModelWithOneTexture("item/ingots/inductive_ingot/inductive_ingot")
    val silverIngot = item()
        .simpleItem("silver_ingot", decorations)
        .generatedModelWithOneTexture("item/ingots/silver_ingot/silver_ingot")
    val sinteredTungstenIngot = item()
        .simpleItem("sintered_tungsten", decorations)
        .generatedModelWithOneTexture("item/ingots/sintered_tungsten/sintered_tungsten_ingot")
    val springSteelIngot = item()
        .simpleItem("spring_steel", decorations)
        .generatedModelWithOneTexture("item/ingots/spring_steel/spring_steel_ingot")
    val tungstenAlloyIngot = item()
        .simpleItem("tungsten_alloy", decorations)
        .generatedModelWithOneTexture("item/ingots/tungsten_alloy/tungsten_alloy_ingot")

    //tools
    val detector = item()
        .item(Detector::class.java)
        .generatedModelWithOneTexture("item/tools/detector/detector")
    val wrench = item()
        .item(Wrench::class.java)
        .generatedModelWithOneTexture("item/tools/wrench/wrench")

}
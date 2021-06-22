package com.github.malayP.decorations.dataGen

import com.github.malayP.decorations.Decorations
import com.github.zomb_676.fantasySoup.dataGen.*
import com.github.zomb_676.fantasySoup.register.BlockItemPair
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraftforge.client.model.generators.BlockModelBuilder
import net.minecraftforge.client.model.generators.BlockStateProvider
import net.minecraftforge.client.model.generators.ModelFile
import net.minecraftforge.fml.RegistryObject


// for item model

fun <T : Item> RegistryObject<T>.generatedModelWithOneTexture(
    texture: String
): RegistryObject<T> = this.generatedModelWithOneTexture(DataGenCenter, texture)

fun <T : Item> RegistryObject<T>.heldModelWithOneTexture(texture: String): RegistryObject<T> =
    this.heldModelWithOneTexture(DataGenCenter, texture)

fun <T : Item> RegistryObject<T>.generatedModelModelWithMultiTexture(
    vararg texture: String
): RegistryObject<T> = this.generatedModelModelWithMultiTexture(DataGenCenter, *texture)

//for block model

fun <T : Block> RegistryObject<T>.allSameModel(path: String): () -> () -> BlockModelBuilder? =
    this.allSameModel(DataGenCenter, path)

fun <T : Block> RegistryObject<T>.allDifferModel(
    down: String, up: String, north: String, south: String, west: String, east: String
): () -> () -> BlockModelBuilder? = this.allDifferModel(DataGenCenter, down, up, north, south, west, east)

fun <B : Block> RegistryObject<B>.setCustomModel(model: (IDataHandle) -> Lazy<(BlockStateProvider) -> Unit>): RegistryObject<B> {
    setCustomModel(DataGenCenter, model)
    return this
}

// for ISTER item  from vanilla
fun <T : Item> RegistryObject<T>.isterModel(): RegistryObject<T> = this.isterModel(DataGenCenter)

// for block state

fun <T : Block> RegistryObject<T>.noVariantState(modelFile: () -> () -> () -> ModelFile?): RegistryObject<T> =
    this.noVariantState(DataGenCenter, run(modelFile))

//for BlockItem

fun <T : BlockItem, B : Block> BlockItemPair<T, B>.useBlockModel(): BlockItemPair<T, B> =
    this.useBlockModel(DataGenCenter, Decorations.modId)

// add support for pair BlockItemPair.class
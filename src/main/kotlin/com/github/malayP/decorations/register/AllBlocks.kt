package com.github.malayP.decorations.register

import com.github.malayP.decorations.block.crop.Canola
import com.github.malayP.decorations.block.machine.consumer.Centrifuge
import com.github.malayP.decorations.block.machine.consumer.CentrifugeTileEntityRender
import com.github.malayP.decorations.block.machine.consumer.FrictionHeater
import com.github.malayP.decorations.block.machine.consumer.FrictionHeaterTileEntityRender
import com.github.malayP.decorations.block.machine.engine.*
import com.github.malayP.decorations.block.machine.machine.*
import com.github.malayP.decorations.block.machine.relay.*
import com.github.malayP.decorations.block.pipe.NormalPipe
import com.github.malayP.decorations.block.reactor.Coil
import com.github.malayP.decorations.block.reactor.CoilTileEntityRender
import com.github.malayP.decorations.dataGen.*
import com.github.malayP.decorations.register.AllFluid.alcoholLiquid
import com.github.malayP.decorations.register.AllFluid.jetFuelLiquid
import com.github.malayP.decorations.register.AllFluid.lubricantLiquid
import com.github.malayP.decorations.register.AllItemGroup.decorations
import com.github.malayP.decorations.register.RegisterCenter.registerHandleInstance
import com.github.zomb_676.fantasySoup.register.BlockItemPair
import com.github.zomb_676.fantasySoup.register.BlockRegisterInstance
import com.github.zomb_676.fantasySoup.register.blindBlockRenderType
import com.github.zomb_676.fantasySoup.render.RenderWithTextureAndModelISTER
import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraft.block.Block
import net.minecraft.block.FlowingFluidBlock
import net.minecraft.client.renderer.IRenderTypeBuffer
import net.minecraft.client.renderer.RenderType
import net.minecraft.client.renderer.model.ItemCameraTransforms
import net.minecraft.item.BlockItem
import net.minecraft.item.ItemStack
import net.minecraft.util.math.vector.Vector3f
import net.minecraftforge.client.model.generators.ModelFile
import net.minecraftforge.fml.RegistryObject

object AllBlocks {
    val block: () -> BlockRegisterInstance = registerHandleInstance::registerBlock

    // material block
    val aluminumBlock: BlockItemPair<BlockItem, Block> =
        block().simpleBlockAndItem("aluminum_block", itemItemGroup = decorations)
            .blockFile { allSameModel("block/aluminum_block/aluminum_block") }
            .useModel {
                it.block { noVariantState { this@useModel } }
                it.useBlockModel()
            }
    val bedrockAlloyBlock: BlockItemPair<BlockItem, Block> =
        block().simpleBlockAndItem("bedrock_alloy_block", itemItemGroup = decorations)
            .blockFile { allSameModel("block/bedrock_alloy_block/bedrock_alloy_block") }
            .useModel {
                it.block { noVariantState { this@useModel } }
                it.useBlockModel()
            }
    val hslaBlock: BlockItemPair<BlockItem, Block> =
        block().simpleBlockAndItem("hsla_block", itemItemGroup = decorations)
            .blockFile { allSameModel("block/hsla_block/hsla_block") }
            .useModel {
                it.block { noVariantState { this@useModel } }
                it.useBlockModel()
            }
    val inductiveBlock: BlockItemPair<BlockItem, Block> =
        block().simpleBlockAndItem("inductive_block", itemItemGroup = decorations)
            .blockFile { allSameModel("block/inductive_block/inductive_block") }
            .useModel {
                it.block { noVariantState { this@useModel } }
                it.useBlockModel()
            }
    val silverBlock: BlockItemPair<BlockItem, Block> =
        block().simpleBlockAndItem("silver_block", itemItemGroup = decorations)
            .blockFile { allSameModel("block/silver_block/silver_block") }
            .useModel {
                it.block { noVariantState { this@useModel } }
                it.useBlockModel()
            }
    val sinteredTungstenBlock: BlockItemPair<BlockItem, Block> =
        block().simpleBlockAndItem("sintered_tungsten_block", itemItemGroup = decorations)
            .blockFile { allSameModel("block/sintered_tungsten_block/sintered_tungsten_block") }
            .useModel {
                it.block { noVariantState { this@useModel } }
                it.useBlockModel()
            }
    val springSteelBlock: BlockItemPair<BlockItem, Block> =
        block().simpleBlockAndItem("spring_steel_block", itemItemGroup = decorations)
            .blockFile { allSameModel("block/spring_steel_block/spring_steel_block") }
            .useModel {
                it.block { noVariantState { this@useModel } }
                it.useBlockModel()
            }
    val tungstenAlloyBlock: BlockItemPair<BlockItem, Block> =
        block().simpleBlockAndItem("tungsten_alloy_block", itemItemGroup = decorations)
            .blockFile { allSameModel("block/tungsten_alloy_block/tungsten_alloy_block") }
            .useModel {
                it.block { noVariantState { this@useModel } }
                it.useBlockModel()
            }

    //consumer
    val frictionHeaterBlock: BlockItemPair<BlockItem, FrictionHeater> =
        block().blockWithItem(
            FrictionHeater::class.java,
            itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                FrictionHeaterTileEntityRender.texture,
                FrictionHeaterTileEntityRender.model
            )}}
        )
            .item { isterModel() }

    val centrifugeBlock: BlockItemPair<BlockItem, Centrifuge> =
        block().blockWithItem(Centrifuge::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                CentrifugeTileEntityRender.texture,
                CentrifugeTileEntityRender.model
            )}}).item { isterModel() }

    //engine
    val acElectronicEngineBlock: BlockItemPair<BlockItem, ACElectronicEngine> =
        block().blockWithItem(
            ACElectronicEngine::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                ACElectronicEngineTileEntityRender.texture,
                ACElectronicEngineTileEntityRender.model
            )}}
        )
            .item { isterModel() }
    val creativeEngineBlock: BlockItemPair<BlockItem, CreativeEngine> =
        block().blockWithItem(
            CreativeEngine::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                CreativeEngineTileEntityRender.texture,
                CreativeEngineTileEntityRender.model
            )}}
        )
            .item { isterModel() }
    val dcElectronicEngineBlock: BlockItemPair<BlockItem, DCElectronicEngine> =
        block().blockWithItem(
            DCElectronicEngine::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                DCElectronicEngineTileEntityRender.texture,
                DCElectronicEngineModel()
            )}}
        )
            .item { isterModel() }
    val GasolineEngineBlock: BlockItemPair<BlockItem, GasolineEngine> =
        block().blockWithItem(
            GasolineEngine::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                GasolineEngineTileEntityRender.texture,
                GasolineEngineTileEntityRender.model
            )}}
        )
            .item { isterModel() }
    val gasTurbine: BlockItemPair<BlockItem, GasTurbine> =
        block().blockWithItem(
            GasTurbine::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                GasTurbineTileEntityRender.texture,
                GasTurbineTileEntityRender.model
            )}}
        )
            .item { isterModel() }
    val hydrokineticEngineBlock: BlockItemPair<BlockItem, HydrokineticEngine> =
        block().blockWithItem(
            HydrokineticEngine::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                HydrokineticEngineTileEntityRender.texture,
                HydrokineticEngineTileEntityRender.model
            )}}
        )
            .item { isterModel() }
    val microturbineBlock: BlockItemPair<BlockItem, Microturbine> =
        block().blockWithItem(
            Microturbine::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                MicroturbineTileEntityRender.texture,
                MicroturbineTileEntityRender.model
            )}}
        )
            .item { isterModel() }
    val performanceEngineBlock: BlockItemPair<BlockItem, PerformanceEngine> =
        block().blockWithItem(
            PerformanceEngine::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                PerformanceEngineTileEntityRender.texture,
                PerformanceEngineTileEntityRender.model
            )}}
        )
            .item { isterModel() }
    val steamEngineBlock: BlockItemPair<BlockItem, SteamEngine> =
        block().blockWithItem(
            SteamEngine::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                SteamEngineTileEntityRender.texture,
                SteamEngineTileEntityRender.model
            )}}
        )
            .item { isterModel() }
    val windTurbineBlock: BlockItemPair<BlockItem, WindTurbine> =
        block().blockWithItem(
            WindTurbine::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                WindTurbineTileEntityRender.texture,
                WindTurbineTileEntityRender.model
            )}}
        )
            .item { isterModel() }


    // relay
    val beltHubBlock: BlockItemPair<BlockItem, BeltHub> =
        block().blockWithItem(
            BeltHub::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                BeltHubTileEntityRender.texture,
                BeltHubTileEntityRender.model
            )}}
        )
            .item { isterModel() }
    val bevelGearBlock: BlockItemPair<BlockItem, BevelGear> =
        block().blockWithItem(
            BevelGear::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                BevelGearTileEntityRender.texture,
                BevelGearTileEntityRender.model
            )}}
        )
            .item { isterModel() }
    val chainDriveBlock: BlockItemPair<BlockItem, ChainDrive> =
        block().blockWithItem(
            ChainDrive::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                ChainDriveTileEntityRender.texture,
                ChainDriveTileEntityRender.model
            )}}
        )
            .item { isterModel() }
    val clutchBlock: BlockItemPair<BlockItem, Clutch> =
        block().blockWithItem(
            Clutch::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                ClutchTileEntityRender.clutch,
                ClutchTileEntityRender.model
            )}}
        )
            .item { isterModel() }
    val cvtUnitBlock: BlockItemPair<BlockItem, CVTUnit> =
        block().blockWithItem(
            CVTUnit::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                CVTUnitTileEntityRender.texture,
                CVTUnitTileEntityRender.model
            )}}
        )
            .item { isterModel() }
    val dynamometerBlock: BlockItemPair<BlockItem, Dynamometer> =
        block().blockWithItem(
            Dynamometer::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                DynamometerTileEntityRender.texture,
                DynamometerTileEntityRender.model
            )}}
        )
            .item { isterModel() }
    val woodenFlywheelBlock: BlockItemPair<BlockItem, WoodenFlyWheel> =
        block().blockWithItem(
            WoodenFlyWheel::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                FlywheelTileEntityRender.woodenFlyWheel,
                FlywheelTileEntityRender.model
            )}}
        )
            .item { isterModel() }
    val stoneFlywheelBlock: BlockItemPair<BlockItem, StoneFlyWheel> =
        block().blockWithItem(
            StoneFlyWheel::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                FlywheelTileEntityRender.stoneFlyWheel,
                FlywheelTileEntityRender.model
            )}}
        )
            .item { isterModel() }
    val ironFlywheelBlock: BlockItemPair<BlockItem, IronFlyWheel> =
        block().blockWithItem(
            IronFlyWheel::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                FlywheelTileEntityRender.ironFlyWheel,
                FlywheelTileEntityRender.model
            )}}
        )
            .item { isterModel() }
    val goldFlywheelBlock: BlockItemPair<BlockItem, GoldFlyWheel> =
        block().blockWithItem(
            GoldFlyWheel::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                FlywheelTileEntityRender.goldFlyWheel,
                FlywheelTileEntityRender.model
            )}}
        )
            .item { isterModel() }

    //// gearbox
    val woodenGearBox2Block: BlockItemPair<BlockItem, WoodenGearBox2> =
        block().blockWithItem(
            WoodenGearBox2::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                GearboxTileEntityRender.woodenGearBox2,
                GearboxTileEntityRender.gearboxModel2x
            )}}
        )
            .item { isterModel() }
    val woodenGearBox4Block: BlockItemPair<BlockItem, WoodenGearBox4> =
        block().blockWithItem(
            WoodenGearBox4::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                GearboxTileEntityRender.woodenGearBox4,
                GearboxTileEntityRender.gearboxModel4x
            )}}
        )
            .item { isterModel() }
    val woodenGearBox8Block: BlockItemPair<BlockItem, WoodenGearBox8> =
        block().blockWithItem(
            WoodenGearBox8::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                GearboxTileEntityRender.woodenGearBox8,
                GearboxTileEntityRender.gearboxModel8x
            )}}
        )
            .item { isterModel() }
    val woodenGearBox16Block: BlockItemPair<BlockItem, WoodenGearBox16> =
        block().blockWithItem(
            WoodenGearBox16::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                GearboxTileEntityRender.woodenGearBox16,
                GearboxTileEntityRender.gearboxModel16x
            )}}
        )
            .item { isterModel() }
    val stoneGearBox2Block: BlockItemPair<BlockItem, StoneGearBox2> =
        block().blockWithItem(
            StoneGearBox2::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                GearboxTileEntityRender.stoneGearBox2,
                GearboxTileEntityRender.gearboxModel2x
            )}}
        )
            .item { isterModel() }
    val stoneGearBox4Block: BlockItemPair<BlockItem, StoneGearBox4> =
        block().blockWithItem(
            StoneGearBox4::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                GearboxTileEntityRender.stoneGearBox4,
                GearboxTileEntityRender.gearboxModel4x
            )}}
        )
            .item { isterModel() }
    val stoneGearBox8Block: BlockItemPair<BlockItem, StoneGearBox8> =
        block().blockWithItem(
            StoneGearBox8::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                GearboxTileEntityRender.stoneGearBox8,
                GearboxTileEntityRender.gearboxModel8x
            )}}
        )
            .item { isterModel() }
    val stoneGearBox16Block: BlockItemPair<BlockItem, StoneGearBox16> =
        block().blockWithItem(
            StoneGearBox16::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                GearboxTileEntityRender.stoneGearBox16,
                GearboxTileEntityRender.gearboxModel16x
            )}}
        )
            .item { isterModel() }
    val steelGearBox2Block: BlockItemPair<BlockItem, SteelGearBox2> =
        block().blockWithItem(
            SteelGearBox2::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                GearboxTileEntityRender.steelGearBox2,
                GearboxTileEntityRender.gearboxModel2x
            )}}
        )
            .item { isterModel() }
    val steelGearBox4Block: BlockItemPair<BlockItem, SteelGearBox4> =
        block().blockWithItem(
            SteelGearBox4::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                GearboxTileEntityRender.steelGearBox4,
                GearboxTileEntityRender.gearboxModel4x
            )}}
        )
            .item { isterModel() }
    val steelGearBox8Block: BlockItemPair<BlockItem, SteelGearBox8> =
        block().blockWithItem(
            SteelGearBox8::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                GearboxTileEntityRender.steelGearBox8,
                GearboxTileEntityRender.gearboxModel8x
            )}}
        )
            .item { isterModel() }
    val steelGearBox16Block: BlockItemPair<BlockItem, SteelGearBox16> =
        block().blockWithItem(
            SteelGearBox16::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                GearboxTileEntityRender.steelGearBox16,
                GearboxTileEntityRender.gearboxModel16x
            )}}
        )
            .item { isterModel() }
    val diamondGearBox2Block: BlockItemPair<BlockItem, DiamondGearBox2> =
        block().blockWithItem(
            DiamondGearBox2::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                GearboxTileEntityRender.diamondGearBox2,
                GearboxTileEntityRender.gearboxModel2x
            )}}
        )
            .item { isterModel() }
    val diamondGearBox4Block: BlockItemPair<BlockItem, DiamondGearBox4> =
        block().blockWithItem(
            DiamondGearBox4::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                GearboxTileEntityRender.diamondGearBox4,
                GearboxTileEntityRender.gearboxModel4x
            )}}
        )
            .item { isterModel() }
    val diamondGearBox8Block: BlockItemPair<BlockItem, DiamondGearBox8> =
        block().blockWithItem(
            DiamondGearBox8::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                GearboxTileEntityRender.diamondGearBox8,
                GearboxTileEntityRender.gearboxModel8x
            )}}
        )
            .item { isterModel() }
    val diamondGearBox16Block: BlockItemPair<BlockItem, DiamondGearBox16> =
        block().blockWithItem(
            DiamondGearBox16::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                GearboxTileEntityRender.diamondGearBox16,
                GearboxTileEntityRender.gearboxModel16x
            )}}
        )
            .item { isterModel() }
    val bedrockGearBox2Block: BlockItemPair<BlockItem, BedrockGearBox2> =
        block().blockWithItem(
            BedrockGearBox2::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                GearboxTileEntityRender.bedrockGearBox2,
                GearboxTileEntityRender.gearboxModel2x
            )}}
        )
            .item { isterModel() }
    val bedrockGearBox4Block: BlockItemPair<BlockItem, BedrockGearBox4> =
        block().blockWithItem(
            BedrockGearBox4::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                GearboxTileEntityRender.bedrockGearBox4,
                GearboxTileEntityRender.gearboxModel4x
            )}}
        )
            .item { isterModel() }
    val bedrockGearBox8Block: BlockItemPair<BlockItem, BedrockGearBox8> =
        block().blockWithItem(
            BedrockGearBox8::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                GearboxTileEntityRender.bedrockGearBox8,
                GearboxTileEntityRender.gearboxModel8x
            )}}
        )
            .item { isterModel() }
    val bedrockGearBox16Block: BlockItemPair<BlockItem, BedrockGearBox16> =
        block().blockWithItem(
            BedrockGearBox16::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                GearboxTileEntityRender.bedrockGearBox16,
                GearboxTileEntityRender.gearboxModel16x
            )}}
        )
            .item { isterModel() }

    ////
    val steelIndustrialCoilBlock: BlockItemPair<BlockItem, SteelIndustrialCoil> =
        block().blockWithItem(
            SteelIndustrialCoil::class.java, itemGroup = decorations,
            ister ={{ RenderWithTextureAndModelISTER(
                IndustrialCoilTileEntityRender.steelIndustrialCoil,
                IndustrialCoilTileEntityRender.model
            )}}
        )
            .item { isterModel() }
    val bedrockIndustrialCoilBlock: BlockItemPair<BlockItem, BedrockIndustrialCoil> =
        block().blockWithItem(
            BedrockIndustrialCoil::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                IndustrialCoilTileEntityRender.bedrockIndustrialCoil,
                IndustrialCoilTileEntityRender.model
            )}}
        )
            .item { isterModel() }
    val multiDirectionalClutch: BlockItemPair<BlockItem, MultiDirectionalClutch> =
        block().blockWithItem(
            MultiDirectionalClutch::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                MultiDirectionalClutchTileEntityRender.texture,
                MultiDirectionalClutchTileEntityRender.model
            )}}
        )
            .item { isterModel() }

    ////shaft
    val woodenShaftBlock: BlockItemPair<BlockItem, WoodenShaft> =
        block().blockWithItem(
            WoodenShaft::class.java,
            itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                ShaftTileEntityRender.horizonWoodenShaft,
                HorizonShaftModel()
            )}}
        )
            .item { isterModel() }
    val stoneShaftBlock: BlockItemPair<BlockItem, StoneShaft> =
        block().blockWithItem(
            StoneShaft::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                ShaftTileEntityRender.horizonStoneShaft,
                HorizonShaftModel()
            )}}
        )
            .item { isterModel() }
    val steelShaftBlock: BlockItemPair<BlockItem, SteelShaft> =
        block().blockWithItem(
            SteelShaft::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                ShaftTileEntityRender.horizonSteelShaft,
                HorizonShaftModel()
            )}}
        )
            .item { isterModel() }
    val diamondShaftBlock: BlockItemPair<BlockItem, DiamondShaft> =
        block().blockWithItem(
            DiamondShaft::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                ShaftTileEntityRender.horizonDiamondShaft,
                HorizonShaftModel()
            )}}
        )
            .item { isterModel() }
    val bedrockShaftBlock: BlockItemPair<BlockItem, BedrockShaft> =
        block().blockWithItem(
            BedrockShaft::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                ShaftTileEntityRender.horizonBedrockShaft,
                HorizonShaftModel()
            )}}
        )
            .item { isterModel() }

    ////
    val shaftCrossBlock: BlockItemPair<BlockItem, ShaftCross> =
        block().blockWithItem(
            ShaftCross::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                ShaftCrossTileEntityRender.texture,
                ShaftCrossTileEntityRender.model
            )}}
        )
            .item { isterModel() }
    val shaftDistributionClutchBlock: BlockItemPair<BlockItem, ShaftDistributionClutch> =
        block().blockWithItem(
            ShaftDistributionClutch::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                ShaftDistributionClutchTileEntityRender.texture,
                ShaftDistributionClutchTileEntityRender.model
            )}}
        )
            .item { isterModel() }
    val steelShaftJunctionBlock: BlockItemPair<BlockItem, SteelShaftJunction> =
        block().blockWithItem(
            SteelShaftJunction::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                ShaftJunctionTileEntityRender.steelSideShaftJunction,
                ShaftJunctionTileEntityRender.model
            )}}
        )
            .item { isterModel() }
    val bedrockShaftJunctionBlock: BlockItemPair<BlockItem, BedrockShaftJunction> =
        block().blockWithItem(
            BedrockShaftJunction::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                ShaftJunctionTileEntityRender.bedrockCenterShaftJunction,
                ShaftJunctionTileEntityRender.model
            )}}
        )
            .item { isterModel() }
    val shaftPowerBusBlock: BlockItemPair<BlockItem, ShaftPowerBus> =
        block().blockWithItem(
            ShaftPowerBus::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                ShaftPowerBusTileEntityRender.texture,
                ShaftPowerBusTileEntityRender.model
            )}}
        )
            .item { isterModel() }
    val shaftPowerBusControllerBlock: BlockItemPair<BlockItem, ShaftPowerBusController> =
        block().blockWithItem(
            ShaftPowerBusController::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                ShaftPowerBusControllerTileEntityRender.texture,
                ShaftPowerBusControllerTileEntityRender.model
            )}}
        )
            .item { isterModel() }
    val wormGearBlock: BlockItemPair<BlockItem, WormGear> =
        block().blockWithItem(
            WormGear::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                WormGearTileEntityRender.texture,
                WormGearTileEntityRender.model
            )}}
        )
            .item { isterModel() }

    //pipes
    val normalPipe = block().blockWithItem(
        NormalPipe::class.java, itemGroup = decorations
    ).block { setCustomModel(NormalPipe.TransparentModel) }
        .block { blindBlockRenderType{{RenderType.getTranslucent()}} }

    //decorations
    val canola = block().blockWithItem(
        Canola::class.java, itemGroup = decorations
    ).block { setCustomModel(Canola.model) }
        .item { generatedModelWithOneTexture("item/material/canola_seeds/canola_seeds") }
        .block { blindBlockRenderType { { RenderType.getTranslucent() } } }

    //liquid block
    val alcohol: RegistryObject<FlowingFluidBlock> = block().liquidBlock("alcohol", alcoholLiquid.still)
        .blockFile { allSameModel("") }.useModel {
            this.noVariantState { it }
        }

    val lubricant: RegistryObject<FlowingFluidBlock> = block().liquidBlock("lubricant", lubricantLiquid.still)

    val jetFuel: RegistryObject<FlowingFluidBlock> = block().liquidBlock("jet_fuel", jetFuelLiquid.still)

    val pulseJetFurnaceBlock: BlockItemPair<BlockItem, PulseJetFurnace> =
        block().blockWithItem(
            PulseJetFurnace::class.java,
            itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                PulseJetFurnaceTileEntityRender.texture,
                PulseJetFurnaceTileEntityRender.model
            )}}
        ).item { isterModel() }

    val woodCutterBlock: BlockItemPair<BlockItem, WoodCutter> =
        block().blockWithItem(
            WoodCutter::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                WoodCutterTileEntityRender.texture,
                WoodCutterTileEntityRender.model
            )}}
        ).item { isterModel() }

    val extractorBlock: BlockItemPair<BlockItem, Extractor> =
        block().blockWithItem(
            Extractor::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                ExtractorTileEntityRender.texture,
                ExtractorTileEntityRender.model
            )}}
        ).item { isterModel() }

    val reverseGearBlock: BlockItemPair<BlockItem, ReverseGear> =
        block().blockWithItem(
            ReverseGear::class.java, itemGroup = decorations,
            ister ={{ RenderWithTextureAndModelISTER(
                ReverseGearTileEntityRender.texture,
                ReverseGearTileEntityRender.model
            )}}
        ).item { isterModel() }

    val pumpBlock: BlockItemPair<BlockItem, Pump> =
        block().blockWithItem(
            Pump::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                PumpTileEntityRender.texture,
                PumpTileEntityRender.model
            )}}
        ).item { isterModel() }

    val blastFurnaceBlock: BlockItemPair<BlockItem, BlastFurnace> =
        block().blockWithItem(
            BlastFurnace::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                BlastFurnaceTileEntityRender.texture,
                BlastFurnaceTileEntityRender.model
            )}}
        ).item { isterModel() }

    val remeltingTableBlock: BlockItemPair<BlockItem, RemeltingTable> =
        block().blockWithItem(
            RemeltingTable::class.java,
            itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                RemeltingTableTileEntityRender.texture,
                RemeltingTableTileEntityRender.model
            )}}
        ).item { isterModel() }

    val worktableBlock: BlockItemPair<BlockItem, Worktable> =
        block().blockWithItem(
            Worktable::class.java, itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                WorktableTileEntityRender.texture,
                WorktableTileEntityRender.model
            )}}
        ).item { isterModel() }

    val bedrockBreakerBlock: BlockItemPair<BlockItem, BedrockBreaker> =
        block().blockWithItem(
            BedrockBreaker::class.java,
            itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                BedrockBreakerTileEntityRender.texture,
                BedrockBreakerTileEntityRender.model
            )}}
        ).item { isterModel() }

    val enhancedBedrockBreakerBlock: BlockItemPair<BlockItem, EnhancedBedrockBreaker> =
        block().blockWithItem(
            EnhancedBedrockBreaker::class.java,
            itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                EnhancedBedrockBreakerTileEntityRender.texture,
                EnhancedBedrockBreakerTileEntityRender.model
            )}}
        ).item { isterModel() }

    val groundSprinklerBlock: BlockItemPair<BlockItem, GroundSprinkler> =
        block().blockWithItem(
            GroundSprinkler::class.java,
            itemGroup = decorations,
            ister = {{RenderWithTextureAndModelISTER(
                GroundSprinklerTileEntityRender.texture,
                GroundSprinklerTileEntityRender.model
            )}}
        ).item { isterModel() }

    val sprinklerBlock: BlockItemPair<BlockItem, Sprinkler> =
        block().blockWithItem(
            Sprinkler::class.java,
            itemGroup = decorations,
            ister = {{
                RenderWithTextureAndModelISTER(
                    SprinklerTileEntityRender.texture,
                    SprinklerTileEntityRender.model
                )}}
        ).item { isterModel() }

    val coilBlock: BlockItemPair<BlockItem, Coil> = block().blockWithItem(
        Coil::class.java,
        itemGroup = decorations,
        ister = {{object :
            RenderWithTextureAndModelISTER(
                CoilTileEntityRender.texture,
                CoilTileEntityRender.model
            ){
            override fun func_239207_a_(
                stack: ItemStack,
                p_239207_2_: ItemCameraTransforms.TransformType,
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
                matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90f))
                matrixStackIn.scale(0.5f,0.5f,0.5f)
                model.render(matrixStackIn, buffer, combinedLightIn, combinedOverlayIn, 1f, 1f, 1f, 1f)
                matrixStackIn.pop()
            }
        }}}
    ).item { isterModel() }
}


inline fun <B : Block> RegistryObject<B>.blockFile(crossinline codeBlock: (RegistryObject<B>).() -> () -> () -> ModelFile?) =
    BlockModelFile(this, codeBlock(this))

data class BlockModelFile<B : Block>(val block: RegistryObject<B>, val modelFile: () -> () -> ModelFile?) {

    fun block(codeBlock: (RegistryObject<B>).() -> Unit): BlockModelFile<B> {
        return this
    }

    fun useModel(codeBlock: ((RegistryObject<B>)).(() -> () -> ModelFile?) -> Unit): RegistryObject<B> {
        return block
    }
}
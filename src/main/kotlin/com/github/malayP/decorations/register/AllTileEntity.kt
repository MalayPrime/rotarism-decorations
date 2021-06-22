package com.github.malayP.decorations.register

import com.github.malayP.decorations.block.machine.consumer.CentrifugeTileEntity
import com.github.malayP.decorations.block.machine.consumer.CentrifugeTileEntityRender
import com.github.malayP.decorations.block.machine.consumer.FrictionHeaterTileEntity
import com.github.malayP.decorations.block.machine.consumer.FrictionHeaterTileEntityRender
import com.github.malayP.decorations.block.machine.engine.*
import com.github.malayP.decorations.block.machine.machine.*
import com.github.malayP.decorations.block.machine.relay.*
import com.github.malayP.decorations.register.AllBlocks.GasolineEngineBlock
import com.github.malayP.decorations.register.AllBlocks.acElectronicEngineBlock
import com.github.malayP.decorations.register.AllBlocks.bedrockBreakerBlock
import com.github.malayP.decorations.register.AllBlocks.bedrockGearBox16Block
import com.github.malayP.decorations.register.AllBlocks.bedrockGearBox2Block
import com.github.malayP.decorations.register.AllBlocks.bedrockGearBox4Block
import com.github.malayP.decorations.register.AllBlocks.bedrockGearBox8Block
import com.github.malayP.decorations.register.AllBlocks.bedrockIndustrialCoilBlock
import com.github.malayP.decorations.register.AllBlocks.bedrockShaftBlock
import com.github.malayP.decorations.register.AllBlocks.bedrockShaftJunctionBlock
import com.github.malayP.decorations.register.AllBlocks.beltHubBlock
import com.github.malayP.decorations.register.AllBlocks.bevelGearBlock
import com.github.malayP.decorations.register.AllBlocks.blastFurnaceBlock
import com.github.malayP.decorations.register.AllBlocks.centrifugeBlock
import com.github.malayP.decorations.register.AllBlocks.chainDriveBlock
import com.github.malayP.decorations.register.AllBlocks.clutchBlock
import com.github.malayP.decorations.register.AllBlocks.creativeEngineBlock
import com.github.malayP.decorations.register.AllBlocks.cvtUnitBlock
import com.github.malayP.decorations.register.AllBlocks.dcElectronicEngineBlock
import com.github.malayP.decorations.register.AllBlocks.diamondGearBox16Block
import com.github.malayP.decorations.register.AllBlocks.diamondGearBox2Block
import com.github.malayP.decorations.register.AllBlocks.diamondGearBox4Block
import com.github.malayP.decorations.register.AllBlocks.diamondGearBox8Block
import com.github.malayP.decorations.register.AllBlocks.diamondShaftBlock
import com.github.malayP.decorations.register.AllBlocks.dynamometerBlock
import com.github.malayP.decorations.register.AllBlocks.enhancedBedrockBreakerBlock
import com.github.malayP.decorations.register.AllBlocks.extractorBlock
import com.github.malayP.decorations.register.AllBlocks.frictionHeaterBlock
import com.github.malayP.decorations.register.AllBlocks.gasTurbine
import com.github.malayP.decorations.register.AllBlocks.goldFlywheelBlock
import com.github.malayP.decorations.register.AllBlocks.groundSprinklerBlock
import com.github.malayP.decorations.register.AllBlocks.hydrokineticEngineBlock
import com.github.malayP.decorations.register.AllBlocks.ironFlywheelBlock
import com.github.malayP.decorations.register.AllBlocks.microturbineBlock
import com.github.malayP.decorations.register.AllBlocks.multiDirectionalClutch
import com.github.malayP.decorations.register.AllBlocks.performanceEngineBlock
import com.github.malayP.decorations.register.AllBlocks.pulseJetFurnaceBlock
import com.github.malayP.decorations.register.AllBlocks.pumpBlock
import com.github.malayP.decorations.register.AllBlocks.remeltingTableBlock
import com.github.malayP.decorations.register.AllBlocks.reverseGearBlock
import com.github.malayP.decorations.register.AllBlocks.shaftCrossBlock
import com.github.malayP.decorations.register.AllBlocks.shaftDistributionClutchBlock
import com.github.malayP.decorations.register.AllBlocks.shaftPowerBusBlock
import com.github.malayP.decorations.register.AllBlocks.shaftPowerBusControllerBlock
import com.github.malayP.decorations.register.AllBlocks.steamEngineBlock
import com.github.malayP.decorations.register.AllBlocks.steelGearBox16Block
import com.github.malayP.decorations.register.AllBlocks.steelGearBox2Block
import com.github.malayP.decorations.register.AllBlocks.steelGearBox4Block
import com.github.malayP.decorations.register.AllBlocks.steelGearBox8Block
import com.github.malayP.decorations.register.AllBlocks.steelIndustrialCoilBlock
import com.github.malayP.decorations.register.AllBlocks.steelShaftBlock
import com.github.malayP.decorations.register.AllBlocks.steelShaftJunctionBlock
import com.github.malayP.decorations.register.AllBlocks.stoneFlywheelBlock
import com.github.malayP.decorations.register.AllBlocks.stoneGearBox16Block
import com.github.malayP.decorations.register.AllBlocks.stoneGearBox2Block
import com.github.malayP.decorations.register.AllBlocks.stoneGearBox4Block
import com.github.malayP.decorations.register.AllBlocks.stoneGearBox8Block
import com.github.malayP.decorations.register.AllBlocks.stoneShaftBlock
import com.github.malayP.decorations.register.AllBlocks.windTurbineBlock
import com.github.malayP.decorations.register.AllBlocks.woodCutterBlock
import com.github.malayP.decorations.register.AllBlocks.woodenFlywheelBlock
import com.github.malayP.decorations.register.AllBlocks.woodenGearBox16Block
import com.github.malayP.decorations.register.AllBlocks.woodenGearBox2Block
import com.github.malayP.decorations.register.AllBlocks.woodenGearBox4Block
import com.github.malayP.decorations.register.AllBlocks.woodenGearBox8Block
import com.github.malayP.decorations.register.AllBlocks.woodenShaftBlock
import com.github.malayP.decorations.register.AllBlocks.worktableBlock
import com.github.malayP.decorations.register.AllBlocks.wormGearBlock
import com.github.malayP.decorations.register.RegisterCenter.registerHandleInstance
import com.github.zomb_676.fantasySoup.register.TileEntityTypeRegisterInstance
import net.minecraft.tileentity.TileEntityType
import net.minecraftforge.fml.RegistryObject

object AllTileEntity {
    val tileEntityType: () -> TileEntityTypeRegisterInstance = registerHandleInstance::registerTileEntityType

    //consumer
    val centrifugeType: RegistryObject<TileEntityType<CentrifugeTileEntity>> = tileEntityType().tileEntityBlind(
        "centrifuge",
        CentrifugeTileEntity::class.java,
        {{CentrifugeTileEntityRender::class.java}},
        centrifugeBlock.block
    )
    val frictionHeaterType: RegistryObject<TileEntityType<FrictionHeaterTileEntity>> = tileEntityType().tileEntityBlind(
        "friction_heater",
        FrictionHeaterTileEntity::class.java,
        {{FrictionHeaterTileEntityRender::class.java}},
        frictionHeaterBlock.block
    )

    //engine
    val acElectronicEngineType: RegistryObject<TileEntityType<ACElectronicEngineTileEntity>> =
        tileEntityType().tileEntityBlind(
            "ac_electrical_engine",
            ACElectronicEngineTileEntity::class.java,
            {{ACElectronicEngineTileEntityRender::class.java}},
            acElectronicEngineBlock.block
        )
    val creativeEngineType: RegistryObject<TileEntityType<CreativeEngineTileEntity>> = tileEntityType().tileEntityBlind(
        "creative_engine",
        CreativeEngineTileEntity::class.java,
        {{ CreativeEngineTileEntityRender::class.java}},
        creativeEngineBlock.block
    )
    val dcElectronicEngineType: RegistryObject<TileEntityType<DCElectronicEngineTileEntity>> =
        tileEntityType().tileEntityBlind(
            "dc_electrical_engine",
            DCElectronicEngineTileEntity::class.java,
            {{DCElectronicEngineTileEntityRender::class.java}},
            dcElectronicEngineBlock.block
        )
    val gasolineEngineType: RegistryObject<TileEntityType<GasolineEngineTileEntity>> = tileEntityType().tileEntityBlind(
        "gasoline_engine",
        GasolineEngineTileEntity::class.java,
        {{GasolineEngineTileEntityRender::class.java}},
        GasolineEngineBlock.block
    )
    val gasTurbineType = tileEntityType().tileEntityBlind(
        "gas_turbine",
        GasTurbineTileEntity::class.java,
        {{GasTurbineTileEntityRender::class.java}},
        gasTurbine.block
    )
    val hydrokineticEngineType: RegistryObject<TileEntityType<HydrokineticEngineTileEntity>> =
        tileEntityType().tileEntityBlind(
            "hydrokinetic_engine",
            HydrokineticEngineTileEntity::class.java,
            {{HydrokineticEngineTileEntityRender::class.java}},
            hydrokineticEngineBlock.block
        )
    val microturbineType: RegistryObject<TileEntityType<MicroturbineTileEntity>> = tileEntityType().tileEntityBlind(
        "microturbine",
        MicroturbineTileEntity::class.java,
        {{MicroturbineTileEntityRender::class.java}},
        microturbineBlock.block
    )
    val performanceEngineType: RegistryObject<TileEntityType<PerformanceEngineTileEntity>> =
        tileEntityType().tileEntityBlind(
            "performance_engine",
            PerformanceEngineTileEntity::class.java,
            {{PerformanceEngineTileEntityRender::class.java}},
            performanceEngineBlock.block
        )
    val stemEngineType = tileEntityType().tileEntityBlind(
        "steam_engine",
        SteamEngineTileEntity::class.java,
        {{SteamEngineTileEntityRender::class.java}},
        steamEngineBlock.block
    )
    val windTurbineType: RegistryObject<TileEntityType<WindTurbineTileEntity>> = tileEntityType().tileEntityBlind(
        "wind_turbine",
        WindTurbineTileEntity::class.java,
        {{WindTurbineTileEntityRender::class.java}},
        windTurbineBlock.block
    )


    //relay
    val beltHubType: RegistryObject<TileEntityType<BeltHubTileEntity>> = tileEntityType().tileEntityBlind(
        "belt_hub",
        BeltHubTileEntity::class.java,
        {{BeltHubTileEntityRender::class.java}},
        beltHubBlock.block
    )
    val bevelGearType: RegistryObject<TileEntityType<BevelGearTileEntity>> = tileEntityType().tileEntityBlind(
        "bevel_gear",
        BevelGearTileEntity::class.java,
        {{BevelGearTileEntityRender::class.java}},
        bevelGearBlock.block
    )
    val chainDriveType: RegistryObject<TileEntityType<ChainDriveTileEntity>> = tileEntityType().tileEntityBlind(
        "chain_drive",
        ChainDriveTileEntity::class.java,
        {{ChainDriveTileEntityRender::class.java}},
        chainDriveBlock.block
    )
    val clutchType: RegistryObject<TileEntityType<ClutchTileEntity>> = tileEntityType().tileEntityBlind(
        "clutch",
        ClutchTileEntity::class.java,
        {{ClutchTileEntityRender::class.java}},
        clutchBlock.block
    )
    val cvtUnitType: RegistryObject<TileEntityType<CVTUnitTileEntity>> = tileEntityType().tileEntityBlind(
        "cvt_unit",
        CVTUnitTileEntity::class.java,
        {{CVTUnitTileEntityRender::class.java}},
        cvtUnitBlock.block
    )
    val dynamometerType: RegistryObject<TileEntityType<DynamometerTileEntity>> = tileEntityType().tileEntityBlind(
        "dynamometer",
        DynamometerTileEntity::class.java,
        {{DynamometerTileEntityRender::class.java}},
        dynamometerBlock.block
    )
    val flywheelType: RegistryObject<TileEntityType<FlywheelTileEntity>> = tileEntityType().tileEntityBlind(
        "flywheel",
        FlywheelTileEntity::class.java,
        {{ FlywheelTileEntityRender::class.java}},
        woodenFlywheelBlock.block,
        stoneFlywheelBlock.block,
        ironFlywheelBlock.block,
        goldFlywheelBlock.block
    )
    val GEARBOX_TYPE: RegistryObject<TileEntityType<GearboxTileEntity>> = tileEntityType().tileEntityBlind(
        "gear_box",
        GearboxTileEntity::class.java,
        {{GearboxTileEntityRender::class.java}},
        woodenGearBox2Block.block,
        woodenGearBox4Block.block,
        woodenGearBox8Block.block,
        woodenGearBox16Block.block,
        stoneGearBox2Block.block,
        stoneGearBox4Block.block,
        stoneGearBox8Block.block,
        stoneGearBox16Block.block,
        steelGearBox2Block.block,
        steelGearBox4Block.block,
        steelGearBox8Block.block,
        steelGearBox16Block.block,
        diamondGearBox2Block.block,
        diamondGearBox4Block.block,
        diamondGearBox8Block.block,
        diamondGearBox16Block.block,
        bedrockGearBox2Block.block,
        bedrockGearBox4Block.block,
        bedrockGearBox8Block.block,
        bedrockGearBox16Block.block
    )
    val industrialCoilType: RegistryObject<TileEntityType<IndustrialCoilTileEntity>> = tileEntityType().tileEntityBlind(
        "industrial_coil",
        IndustrialCoilTileEntity::class.java,
        {{IndustrialCoilTileEntityRender::class.java}},
        steelIndustrialCoilBlock.block,
        bedrockIndustrialCoilBlock.block
    )
    val multiDirectionalClutchType: RegistryObject<TileEntityType<MultiDirectionalClutchTileEntity>> =
        tileEntityType().tileEntityBlind(
            "multi_direction_clutch",
            MultiDirectionalClutchTileEntity::class.java,
            {{MultiDirectionalClutchTileEntityRender::class.java}},
            multiDirectionalClutch.block
        )
    val shaftType: RegistryObject<TileEntityType<ShaftTileEntity>> = tileEntityType().tileEntityBlind(
        "shaft",
        ShaftTileEntity::class.java,
        {{ShaftTileEntityRender::class.java}},
        woodenShaftBlock.block,
        stoneShaftBlock.block,
        steelShaftBlock.block,
        diamondShaftBlock.block,
        bedrockShaftBlock.block
    )
    val shaftCrossType: RegistryObject<TileEntityType<ShaftCrossTileEntity>> = tileEntityType().tileEntityBlind(
        "shaft_cross",
        ShaftCrossTileEntity::class.java,
        {{ShaftCrossTileEntityRender::class.java}},
        shaftCrossBlock.block
    )
    val shaftDistributionClutchType: RegistryObject<TileEntityType<ShaftDistributionClutchTileEntity>> =
        tileEntityType().tileEntityBlind(
            "shaft_distribution_clutch",
            ShaftDistributionClutchTileEntity::class.java,
            {{ShaftDistributionClutchTileEntityRender::class.java}},
            shaftDistributionClutchBlock.block
        )
    val ShaftJunctionType: RegistryObject<TileEntityType<ShaftJunctionTileEntity>> = tileEntityType().tileEntityBlind(
        "shaft_junction",
        ShaftJunctionTileEntity::class.java,
        {{ShaftJunctionTileEntityRender::class.java}},
        steelShaftJunctionBlock.block,
        bedrockShaftJunctionBlock.block
    )
    val shaftPowerBusType: RegistryObject<TileEntityType<ShaftPowerBusTileEntity>> = tileEntityType().tileEntityBlind(
        "shaft_power_bus",
        ShaftPowerBusTileEntity::class.java,
        {{ShaftPowerBusTileEntityRender::class.java}},
        shaftPowerBusBlock.block
    )
    val shaftPowerBusControllerType: RegistryObject<TileEntityType<ShaftPowerBusControllerTileEntity>> =
        tileEntityType().tileEntityBlind(
            "shaft_power_bus_controller",
            ShaftPowerBusControllerTileEntity::class.java,
            {{ShaftPowerBusControllerTileEntityRender::class.java}},
            shaftPowerBusControllerBlock.block
        )
    val wormGearType: RegistryObject<TileEntityType<WormGearTileEntity>> = tileEntityType().tileEntityBlind(
        "worm_gear",
        WormGearTileEntity::class.java,
        {{WormGearTileEntityRender::class.java}},
        wormGearBlock.block
    )

    val pulseJetFurnaceType:RegistryObject<TileEntityType<PulseJetFurnaceTileEntity>> =tileEntityType().tileEntityBlind(
        "pulse_jet_furnace",
        PulseJetFurnaceTileEntity::class.java,
        {{PulseJetFurnaceTileEntityRender::class.java}},
        pulseJetFurnaceBlock.block
    )
    val woodCutterType:RegistryObject<TileEntityType<WoodCutterTileEntity>> =tileEntityType().tileEntityBlind(
        "wood_cutter",
        WoodCutterTileEntity::class.java,
        {{WoodCutterTileEntityRender::class.java}},
        woodCutterBlock.block
    )
    val extractorType:RegistryObject<TileEntityType<ExtractorTileEntity>> =tileEntityType().tileEntityBlind(
        "extractor",
        ExtractorTileEntity::class.java,
        {{ExtractorTileEntityRender::class.java}},
        extractorBlock.block
    )
    val reverseGearType:RegistryObject<TileEntityType<ReverseGearTileEntity>> =tileEntityType().tileEntityBlind(
        "reverse_gear",
        ReverseGearTileEntity::class.java,
        {{ReverseGearTileEntityRender::class.java}},
        reverseGearBlock.block
    )
    val pumpType:RegistryObject<TileEntityType<PumpTileEntity>> =tileEntityType().tileEntityBlind(
        "pump",
        PumpTileEntity::class.java,
        {{PumpTileEntityRender::class.java}},
        pumpBlock.block
    )
    val blastFurnaceType:RegistryObject<TileEntityType<BlastFurnaceTileEntity>> =tileEntityType().tileEntityBlind(
        "blast_furnace",
        BlastFurnaceTileEntity::class.java,
        {{BlastFurnaceTileEntityRender::class.java}},
        blastFurnaceBlock.block
    )
    val remeltingTableType:RegistryObject<TileEntityType<RemeltingTableTileEntity>> =tileEntityType().tileEntityBlind(
        "remelting_table",
        RemeltingTableTileEntity::class.java,
        {{RemeltingTableTileEntityRender::class.java}},
        remeltingTableBlock.block
    )
    val worktableType:RegistryObject<TileEntityType<WorktableTileEntity>> =tileEntityType().tileEntityBlind(
        "worktable",
        WorktableTileEntity::class.java,
        {{WorktableTileEntityRender::class.java}},
        worktableBlock.block
    )
    val bedrockBreakerType:RegistryObject<TileEntityType<BedrockBreakerTileEntity>> =tileEntityType().tileEntityBlind(
        "bedrock_breaker",
        BedrockBreakerTileEntity::class.java,
        {{BedrockBreakerTileEntityRender::class.java}},
        bedrockBreakerBlock.block
    )
    val enhancedBedrockBreakerType:RegistryObject<TileEntityType<EnhancedBedrockBreakerTileEntity>> =tileEntityType().tileEntityBlind(
        "enhanced_bedrock_breaker",
        EnhancedBedrockBreakerTileEntity::class.java,
        {{EnhancedBedrockBreakerTileEntityRender::class.java}},
        enhancedBedrockBreakerBlock.block
    )
    val groundSprinklerType:RegistryObject<TileEntityType<GroundSprinklerTileEntity>> =tileEntityType().tileEntityBlind(
        "ground_sprinkler",
        GroundSprinklerTileEntity::class.java,
        {{GroundSprinklerTileEntityRender::class.java}},
        groundSprinklerBlock.block
    )

}
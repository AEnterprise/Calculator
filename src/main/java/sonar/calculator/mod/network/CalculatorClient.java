package sonar.calculator.mod.network;

import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import sonar.calculator.mod.Calculator;
import sonar.calculator.mod.client.renderers.ItemAxe;
import sonar.calculator.mod.client.renderers.ItemCalculatorPlug;
import sonar.calculator.mod.client.renderers.ItemConductorMask;
import sonar.calculator.mod.client.renderers.ItemHoe;
import sonar.calculator.mod.client.renderers.ItemLantern;
import sonar.calculator.mod.client.renderers.ItemPickaxe;
import sonar.calculator.mod.client.renderers.ItemResearchChamber;
import sonar.calculator.mod.client.renderers.ItemScarecrow;
import sonar.calculator.mod.client.renderers.ItemShovel;
import sonar.calculator.mod.client.renderers.ItemSickle;
import sonar.calculator.mod.client.renderers.ItemStarchExtractor;
import sonar.calculator.mod.client.renderers.ItemSword;
import sonar.calculator.mod.client.renderers.ItemTransmitter;
import sonar.calculator.mod.client.renderers.ItemWeatherStation;
import sonar.calculator.mod.client.renderers.ItemWrench;
import sonar.calculator.mod.client.renderers.RenderCalculatorLocator;
import sonar.calculator.mod.client.renderers.RenderCalculatorPlug;
import sonar.calculator.mod.client.renderers.RenderCalculatorScreen;
import sonar.calculator.mod.client.renderers.RenderChamber;
import sonar.calculator.mod.client.renderers.RenderCrank;
import sonar.calculator.mod.client.renderers.RenderDockingStation;
import sonar.calculator.mod.client.renderers.RenderFlawlessCapacitor;
import sonar.calculator.mod.client.renderers.RenderFluxPlug;
import sonar.calculator.mod.client.renderers.RenderFluxPoint;
import sonar.calculator.mod.client.renderers.RenderHandlers;
import sonar.calculator.mod.client.renderers.RenderLantern;
import sonar.calculator.mod.client.renderers.RenderMagneticFlux;
import sonar.calculator.mod.client.renderers.RenderResearchChamber;
import sonar.calculator.mod.client.renderers.RenderAnalysingChamber;
import sonar.calculator.mod.client.renderers.RenderStorageChamber;
import sonar.calculator.mod.client.renderers.RenderTransmitter;
import sonar.calculator.mod.client.renderers.RenderWeatherStation;
import sonar.calculator.mod.common.entities.EntityBabyGrenade;
import sonar.calculator.mod.common.entities.EntityGrenade;
import sonar.calculator.mod.common.entities.EntitySmallStone;
import sonar.calculator.mod.common.entities.EntitySoil;
import sonar.calculator.mod.common.tileentity.TileEntityMachines;
import sonar.calculator.mod.common.tileentity.generators.TileEntityCalculatorLocator;
import sonar.calculator.mod.common.tileentity.generators.TileEntityCalculatorPlug;
import sonar.calculator.mod.common.tileentity.generators.TileEntityConductorMast;
import sonar.calculator.mod.common.tileentity.generators.TileEntityCrankHandle;
import sonar.calculator.mod.common.tileentity.generators.TileEntityGenerator;
import sonar.calculator.mod.common.tileentity.machines.TileEntityAnalysingChamber;
import sonar.calculator.mod.common.tileentity.machines.TileEntityAssimilator;
import sonar.calculator.mod.common.tileentity.machines.TileEntityAtomicMultiplier;
import sonar.calculator.mod.common.tileentity.machines.TileEntityDockingStation;
import sonar.calculator.mod.common.tileentity.machines.TileEntityFlawlessCapacitor;
import sonar.calculator.mod.common.tileentity.machines.TileEntityResearchChamber;
import sonar.calculator.mod.common.tileentity.machines.TileEntityStorageChamber;
import sonar.calculator.mod.common.tileentity.machines.TileEntityTransmitter;
import sonar.calculator.mod.common.tileentity.machines.TileEntityWeatherStation;
import sonar.calculator.mod.common.tileentity.misc.TileEntityBasicLantern;
import sonar.calculator.mod.common.tileentity.misc.TileEntityCalculatorScreen;
import sonar.calculator.mod.common.tileentity.misc.TileEntityFluxController;
import sonar.calculator.mod.common.tileentity.misc.TileEntityFluxPlug;
import sonar.calculator.mod.common.tileentity.misc.TileEntityFluxPoint;
import sonar.calculator.mod.common.tileentity.misc.TileEntityGasLantern;
import sonar.calculator.mod.common.tileentity.misc.TileEntityMagneticFlux;
import sonar.calculator.mod.common.tileentity.misc.TileEntityScarecrow;
import sonar.calculator.mod.common.tileentity.misc.TileEntityTeleporter;
import sonar.core.utils.ItemModelRender;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class CalculatorClient extends CalculatorCommon {
	@Override
	public void registerRenderThings() {
		RenderingRegistry.registerEntityRenderingHandler(EntityBabyGrenade.class, new RenderSnowball(Calculator.baby_grenade));
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new RenderSnowball(Calculator.grenade));
		RenderingRegistry.registerEntityRenderingHandler(EntitySmallStone.class, new RenderSnowball(Calculator.small_stone));
		RenderingRegistry.registerEntityRenderingHandler(EntitySoil.class, new RenderSnowball(Calculator.soil));

		TileEntitySpecialRenderer plug = new RenderCalculatorPlug();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCalculatorPlug.class, plug);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.calculatorplug), new ItemCalculatorPlug(plug, new TileEntityCalculatorPlug()));

		TileEntitySpecialRenderer locator = new RenderCalculatorLocator();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCalculatorLocator.class, locator);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.calculatorlocator), new ItemModelRender(locator, new TileEntityCalculatorLocator()));

		TileEntitySpecialRenderer starch = new RenderHandlers.StarchExtractor();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGenerator.StarchExtractor.class, starch);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.starchextractor), new ItemStarchExtractor(starch, new TileEntityGenerator.StarchExtractor()));

		TileEntitySpecialRenderer crank = new RenderCrank();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrankHandle.class, crank);

		TileEntitySpecialRenderer glowstone = new RenderHandlers.GlowstoneExtractor();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGenerator.GlowstoneExtractor.class, glowstone);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.glowstoneextractor), new ItemStarchExtractor(glowstone, new TileEntityGenerator.GlowstoneExtractor()));

		TileEntitySpecialRenderer redstone = new RenderHandlers.RedstoneExtractor();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGenerator.RedstoneExtractor.class, redstone);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.redstoneextractor), new ItemStarchExtractor(redstone, new TileEntityGenerator.RedstoneExtractor()));

		TileEntitySpecialRenderer atomic = new RenderHandlers.AtomicMultiplier();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAtomicMultiplier.class, atomic);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.atomicMultiplier), new ItemModelRender(atomic, new TileEntityAtomicMultiplier()));

		TileEntitySpecialRenderer conductor = new RenderHandlers.ConductorMast();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityConductorMast.class, conductor);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.conductorMast), new ItemConductorMask(conductor, new TileEntityConductorMast()));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.conductormastBlock), new ItemConductorMask(conductor, new TileEntityConductorMast()));

		TileEntitySpecialRenderer lantern = new RenderLantern();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGasLantern.class, lantern);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBasicLantern.class, lantern);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.gas_lantern_off), new ItemLantern(lantern, new TileEntityGasLantern()));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.gas_lantern_on), new ItemLantern(lantern, new TileEntityGasLantern()));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.basic_lantern), new ItemLantern(lantern, new TileEntityBasicLantern()));

		TileEntitySpecialRenderer scarecrow = new RenderHandlers.Scarecrow();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityScarecrow.class, scarecrow);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.scarecrow), new ItemScarecrow(scarecrow, new TileEntityScarecrow()));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.scarecrowBlock), new ItemScarecrow(scarecrow, new TileEntityScarecrow()));

		// TileEntitySpecialRenderer research = new RenderResearchChamber();
		// ClientRegistry.bindTileEntitySpecialRenderer(TileEntityResearchChamber.class,
		// research);
		// MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.researchChamber),
		// new ItemResearchChamber(research, new TileEntityResearchChamber()));

		TileEntitySpecialRenderer weather = new RenderWeatherStation();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWeatherStation.class, weather);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.weatherStation), new ItemWeatherStation(weather, new TileEntityWeatherStation()));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.weatherStationBlock), new ItemWeatherStation(weather, new TileEntityWeatherStation()));

		TileEntitySpecialRenderer transmitter = new RenderTransmitter();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTransmitter.class, transmitter);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.transmitter), new ItemTransmitter(transmitter, new TileEntityTransmitter()));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.transmitterBlock), new ItemTransmitter(transmitter, new TileEntityTransmitter()));

		MinecraftForgeClient.registerItemRenderer(Calculator.endforged_sword, new ItemSword("Calculator:textures/model/end_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.electric_sword, new ItemSword("Calculator:textures/model/electric_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.firediamond_sword, new ItemSword("Calculator:textures/model/firediamond_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.flawlessdiamond_sword, new ItemSword("Calculator:textures/model/flawless_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.redstone_sword, new ItemSword("Calculator:textures/model/redstone_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.weakeneddiamond_sword, new ItemSword("Calculator:textures/model/weakeneddiamond_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.enrichedgold_sword, new ItemSword("Calculator:textures/model/gold_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.reinforcediron_sword, new ItemSword("Calculator:textures/model/iron_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.reinforced_sword, new ItemSword("Calculator:textures/model/stone_sword.png"));

		MinecraftForgeClient.registerItemRenderer(Calculator.endforged_shovel, new ItemShovel("Calculator:textures/model/end_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.electric_shovel, new ItemShovel("Calculator:textures/model/electric_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.firediamond_shovel, new ItemShovel("Calculator:textures/model/firediamond_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.flawlessdiamond_shovel, new ItemShovel("Calculator:textures/model/flawless_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.redstone_shovel, new ItemShovel("Calculator:textures/model/redstone_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.weakeneddiamond_shovel, new ItemShovel("Calculator:textures/model/weakeneddiamond_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.enrichedgold_shovel, new ItemShovel("Calculator:textures/model/gold_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.reinforcediron_shovel, new ItemShovel("Calculator:textures/model/iron_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.reinforced_shovel, new ItemShovel("Calculator:textures/model/stone_sword.png"));

		MinecraftForgeClient.registerItemRenderer(Calculator.endforged_axe, new ItemAxe("Calculator:textures/model/end_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.electric_axe, new ItemAxe("Calculator:textures/model/electric_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.firediamond_axe, new ItemAxe("Calculator:textures/model/firediamond_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.flawlessdiamond_axe, new ItemAxe("Calculator:textures/model/flawless_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.redstone_axe, new ItemAxe("Calculator:textures/model/redstone_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.weakeneddiamond_axe, new ItemAxe("Calculator:textures/model/weakeneddiamond_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.enrichedgold_axe, new ItemAxe("Calculator:textures/model/gold_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.reinforcediron_axe, new ItemAxe("Calculator:textures/model/iron_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.reinforced_axe, new ItemAxe("Calculator:textures/model/stone_sword.png"));

		MinecraftForgeClient.registerItemRenderer(Calculator.endforged_pickaxe, new ItemPickaxe("Calculator:textures/model/end_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.electric_pickaxe, new ItemPickaxe("Calculator:textures/model/electric_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.firediamond_pickaxe, new ItemPickaxe("Calculator:textures/model/firediamond_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.flawlessdiamond_pickaxe, new ItemPickaxe("Calculator:textures/model/flawless_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.redstone_pickaxe, new ItemPickaxe("Calculator:textures/model/redstone_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.weakeneddiamond_pickaxe, new ItemPickaxe("Calculator:textures/model/weakeneddiamond_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.enrichedgold_pickaxe, new ItemPickaxe("Calculator:textures/model/gold_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.reinforcediron_pickaxe, new ItemPickaxe("Calculator:textures/model/iron_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.reinforced_pickaxe, new ItemPickaxe("Calculator:textures/model/stone_sword.png"));

		MinecraftForgeClient.registerItemRenderer(Calculator.endforged_hoe, new ItemHoe("Calculator:textures/model/end_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.electric_hoe, new ItemHoe("Calculator:textures/model/electric_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.firediamond_hoe, new ItemHoe("Calculator:textures/model/firediamond_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.flawlessdiamond_hoe, new ItemHoe("Calculator:textures/model/flawless_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.redstone_hoe, new ItemHoe("Calculator:textures/model/redstone_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.weakeneddiamond_hoe, new ItemHoe("Calculator:textures/model/weakeneddiamond_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.enrichedgold_hoe, new ItemHoe("Calculator:textures/model/gold_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.reinforcediron_hoe, new ItemHoe("Calculator:textures/model/iron_sword.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.reinforced_hoe, new ItemHoe("Calculator:textures/model/stone_sword.png"));

		MinecraftForgeClient.registerItemRenderer(Calculator.wrench, new ItemWrench("Calculator:textures/model/tool.png"));
		MinecraftForgeClient.registerItemRenderer(Calculator.sickle, new ItemSickle("Calculator:textures/model/tool.png"));

		TileEntitySpecialRenderer capacitor = new RenderFlawlessCapacitor();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFlawlessCapacitor.class, capacitor);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.flawlessCapacitor), new ItemModelRender(capacitor, new TileEntityFlawlessCapacitor()));

		TileEntitySpecialRenderer fluxPlug = new RenderFluxPlug();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFluxPlug.class, fluxPlug);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.fluxPlug), new ItemModelRender(fluxPlug, new TileEntityFluxPlug()));

		TileEntitySpecialRenderer fluxPoint = new RenderFluxPoint();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFluxPoint.class, fluxPoint);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.fluxPoint), new ItemModelRender(fluxPoint, new TileEntityFluxPoint()));

		TileEntitySpecialRenderer fluxController = new RenderHandlers.FluxController();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFluxController.class, fluxController);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.fluxController), new ItemModelRender(fluxController, new TileEntityFluxController()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCalculatorScreen.class, new RenderCalculatorScreen());

		TileEntitySpecialRenderer processing = new RenderChamber.Processing();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMachines.ProcessingChamber.class, processing);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.processingChamber), new ItemModelRender(processing, new TileEntityMachines.ProcessingChamber()));

		TileEntitySpecialRenderer extraction = new RenderChamber.Extraction();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMachines.ExtractionChamber.class, extraction);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.extractionChamber), new ItemModelRender(extraction, new TileEntityMachines.ExtractionChamber()));

		TileEntitySpecialRenderer precision = new RenderChamber.Precision();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMachines.PrecisionChamber.class, precision);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.precisionChamber), new ItemModelRender(precision, new TileEntityMachines.PrecisionChamber()));

		TileEntitySpecialRenderer removal = new RenderChamber.Removal();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMachines.ReassemblyChamber.class, removal);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.reassemblyChamber), new ItemModelRender(removal, new TileEntityMachines.ReassemblyChamber()));
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMachines.RestorationChamber.class, removal);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.restorationChamber), new ItemModelRender(removal, new TileEntityMachines.RestorationChamber()));

		TileEntitySpecialRenderer analysing = new RenderAnalysingChamber();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnalysingChamber.class, analysing);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.analysingChamber), new ItemModelRender(analysing, new TileEntityAnalysingChamber()));

		TileEntitySpecialRenderer storage = new RenderStorageChamber();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStorageChamber.class, storage);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.storageChamber), new ItemModelRender(storage, new TileEntityStorageChamber()));

		TileEntitySpecialRenderer magnetic = new RenderMagneticFlux();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMagneticFlux.class, magnetic);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.magneticFlux), new ItemModelRender(magnetic, new TileEntityMagneticFlux()));

		TileEntitySpecialRenderer docking = new RenderDockingStation();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDockingStation.class, docking);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.dockingStation), new ItemModelRender(docking, new TileEntityDockingStation()));

		TileEntitySpecialRenderer teleporter = new RenderHandlers.Teleporter();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTeleporter.class, teleporter);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.teleporter), new ItemModelRender(teleporter, new TileEntityTeleporter()));

		TileEntitySpecialRenderer sAssimilator = new RenderHandlers.StoneAssimilator();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAssimilator.Stone.class, sAssimilator);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.stoneAssimilator), new ItemModelRender(sAssimilator, new TileEntityAssimilator.Stone()));

		TileEntitySpecialRenderer aAssimilator = new RenderHandlers.AlgorithmAssimilator();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAssimilator.Algorithm.class, aAssimilator);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Calculator.algorithmAssimilator), new ItemModelRender(aAssimilator, new TileEntityAssimilator.Algorithm()));

	}
}

package io.github.mcneilkimberly.cubetroidmod;

import io.github.mcneilkimberly.cubetroidmod.data.generator.CubetroidModWorldGenerator;
import io.github.mcneilkimberly.cubetroidmod.data.provider.CubetroidModBlockLootTableProvider;
import io.github.mcneilkimberly.cubetroidmod.data.provider.CubetroidModBlockTagProvider;
import io.github.mcneilkimberly.cubetroidmod.data.provider.CubetroidModEnglishLanguageProvider;
import io.github.mcneilkimberly.cubetroidmod.data.provider.CubetroidModModelProvider;
import io.github.mcneilkimberly.cubetroidmod.init.worldgen.ConfiguredFeatureInit;
import io.github.mcneilkimberly.cubetroidmod.init.worldgen.PlacedFeatureInit;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class CubetroidDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(CubetroidModModelProvider::new);
		pack.addProvider(CubetroidModEnglishLanguageProvider::new);
		pack.addProvider(CubetroidModBlockLootTableProvider::new);
		pack.addProvider(CubetroidModBlockTagProvider::new);
		pack.addProvider(CubetroidModWorldGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, PlacedFeatureInit::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ConfiguredFeatureInit::bootstrap);
	}
}

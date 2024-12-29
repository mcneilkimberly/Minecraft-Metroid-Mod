package io.github.mcneilkimberly.cubetroidmod;

import io.github.mcneilkimberly.cubetroidmod.init.ArmorMaterialInit;
import io.github.mcneilkimberly.cubetroidmod.init.Blockinit;
import io.github.mcneilkimberly.cubetroidmod.init.ItemGroupinit;
import io.github.mcneilkimberly.cubetroidmod.init.ItemInit;
import io.github.mcneilkimberly.cubetroidmod.init.worldgen.BiomeModificationInit;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cubetroid implements ModInitializer {
	public static final String MOD_ID = "cubetroidmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Loading...");
		ItemInit.load();
		Blockinit.load();
		ArmorMaterialInit.load();
		ItemGroupinit.load();
		BiomeModificationInit.load();

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
			entries.add(ItemInit.EXAMPLE_HELMET);
			entries.add(ItemInit.EXAMPLE_CHESTPLATE);
			entries.add(ItemInit.EXAMPLE_LEGGINGS);
			entries.add(ItemInit.EXAMPLE_BOOTS);
		});
	}

	public static Identifier id(String path){
		return Identifier.of(MOD_ID, path);
	}
}
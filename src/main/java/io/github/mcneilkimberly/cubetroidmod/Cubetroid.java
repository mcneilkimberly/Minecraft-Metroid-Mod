package io.github.mcneilkimberly.cubetroidmod;

import io.github.mcneilkimberly.cubetroidmod.init.ItemInit;
import net.fabricmc.api.ModInitializer;

import net.minecraft.item.Item;
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
	}

	public static Identifier id(String path){
		return Identifier.of(MOD_ID, path);
	}
}
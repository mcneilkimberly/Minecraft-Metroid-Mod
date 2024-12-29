package io.github.mcneilkimberly.cubetroidmod.data.provider;

import io.github.mcneilkimberly.cubetroidmod.init.Blockinit;
import io.github.mcneilkimberly.cubetroidmod.init.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;


public class CubetroidModBlockLootTableProvider extends FabricBlockLootTableProvider {

    public CubetroidModBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    /**
     *
     */
    @Override
    public void generate() {
        oreDrops(Blockinit.CHOZITE_ORE, ItemInit.CHOZITE_CHUNK);
    }
}

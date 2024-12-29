package io.github.mcneilkimberly.cubetroidmod.data.provider;

import io.github.mcneilkimberly.cubetroidmod.init.Blockinit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class CubetroidModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public CubetroidModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(Blockinit.CHOZITE_ORE);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(Blockinit.CHOZITE_ORE);
    }
}

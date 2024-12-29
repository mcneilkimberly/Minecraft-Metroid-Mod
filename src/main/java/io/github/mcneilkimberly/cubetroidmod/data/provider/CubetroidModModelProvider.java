package io.github.mcneilkimberly.cubetroidmod.data.provider;

import io.github.mcneilkimberly.cubetroidmod.init.Blockinit;
import io.github.mcneilkimberly.cubetroidmod.init.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class CubetroidModModelProvider extends FabricModelProvider {

    public CubetroidModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(Blockinit.CHOZITE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ItemInit.EXAMPLE_HELMET, Models.GENERATED);
        itemModelGenerator.register(ItemInit.EXAMPLE_BOOTS, Models.GENERATED);
        itemModelGenerator.register(ItemInit.EXAMPLE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ItemInit.EXAMPLE_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ItemInit.CHOZITE_BAR, Models.GENERATED);
        itemModelGenerator.register(ItemInit.CHOZITE_CHUNK, Models.GENERATED);
    }
}

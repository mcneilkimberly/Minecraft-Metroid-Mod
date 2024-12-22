package io.github.mcneilkimberly.cubetroidmod.init;

import io.github.mcneilkimberly.cubetroidmod.Cubetroid;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class Blockinit {
    public static final Block CHOZITE_ORE = registerWithItem("chozite_ore", new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE)));

    public static <T extends Block> T register(String name, T block){
        return Registry.register(Registries.BLOCK, Cubetroid.id(name), block);
    }

    public static <T extends Block> T registerWithItem(String name, T block, Item.Settings settings){
        T registered = register(name, block);
        ItemInit.register(name, new BlockItem(registered, settings));
        return registered;
    }

    public static <T extends Block> T registerWithItem(String name, T block){
        return registerWithItem(name, block, new Item.Settings());
    }

    public static void load(){}
}

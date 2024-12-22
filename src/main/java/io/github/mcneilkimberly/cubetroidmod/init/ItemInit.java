package io.github.mcneilkimberly.cubetroidmod.init;

import io.github.mcneilkimberly.cubetroidmod.Cubetroid;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ItemInit {
    public  static final Item CHOZITE_BAR = register("chozite_bar", new Item(new Item.Settings()));

    public static final Item CHOZITE_CHUNK = register("chozite_chunk", new Item(new Item.Settings()));

    public static final ArmorItem EXAMPLE_HELMET = register("example_helmet", new ArmorItem(ArmorMaterialInit.EXAMPLE,
            ArmorItem.Type.HELMET, new Item.Settings().fireproof().maxCount(1)));

    public static final ArmorItem EXAMPLE_CHESTPLATE = register("example_chestplate", new ArmorItem(ArmorMaterialInit.EXAMPLE,
            ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof().maxCount(1)));
    
    public static final ArmorItem EXAMPLE_LEGGINGS = register("example_leggings", new ArmorItem(ArmorMaterialInit.EXAMPLE,
            ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof().maxCount(1)));

    public static final ArmorItem EXAMPLE_BOOTS = register("example_boots", new ArmorItem(ArmorMaterialInit.EXAMPLE,
            ArmorItem.Type.BOOTS, new Item.Settings().fireproof().maxCount(1)));

    public static <T extends Item> T register(String name, T item){
        return Registry.register(Registries.ITEM, Cubetroid.id(name), item);
    }

    public static void load() {

    }
}

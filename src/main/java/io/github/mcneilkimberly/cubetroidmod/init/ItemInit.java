package io.github.mcneilkimberly.cubetroidmod.init;

import io.github.mcneilkimberly.cubetroidmod.Cubetroid;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ItemInit {
    public  static final Item EXAMPLE_ITEM = register("example_item", new Item(new Item.Settings()));

    public static <T extends Item> T register(String name, T item){
        return Registry.register(Registries.ITEM, Cubetroid.id(name), item);
    }

    public static void load() {

    }
}

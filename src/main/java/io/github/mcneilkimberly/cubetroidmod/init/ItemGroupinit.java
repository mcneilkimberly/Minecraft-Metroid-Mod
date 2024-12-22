package io.github.mcneilkimberly.cubetroidmod.init;

import io.github.mcneilkimberly.cubetroidmod.Cubetroid;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

import java.util.Optional;

public class ItemGroupinit {
    private static final Text CUBETROID_TITLE = Text.translatable("itemGroup." + Cubetroid.MOD_ID + ".cubetroid_group");

    public static final ItemGroup CUBETROID_GROUP = register("cubetroid_group", FabricItemGroup.builder()
            .displayName(CUBETROID_TITLE)
            .icon(ItemInit.EXAMPLE_HELMET::getDefaultStack)
            .entries((displayContext, entries) -> Registries.ITEM.getIds()
                    .stream()
                    .filter(key -> key.getNamespace().equals(Cubetroid.MOD_ID))
                    .map(Registries.ITEM::getOrEmpty)
                    .map(Optional::orElseThrow)
                    .forEach(entries::add))
            .build());

    public static void load(){}

    public static <T extends ItemGroup> T register(String name, T itemGroup){
        return Registry.register(Registries.ITEM_GROUP, Cubetroid.id(name), itemGroup);
    }
}

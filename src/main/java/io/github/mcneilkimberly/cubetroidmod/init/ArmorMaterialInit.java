package io.github.mcneilkimberly.cubetroidmod.init;

import io.github.mcneilkimberly.cubetroidmod.Cubetroid;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ArmorMaterialInit {
    public static final RegistryEntry<ArmorMaterial> EXAMPLE = register("example", Map.of(
            ArmorItem.Type.HELMET, 3,
            ArmorItem.Type.CHESTPLATE, 8,
            ArmorItem.Type.LEGGINGS, 6,
            ArmorItem.Type.BOOTS, 3
            ),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD,
            () -> Ingredient.ofItems(ItemInit.CHOZITE_BAR),
            0.7F,
            0.1F,
            false);


    public static RegistryEntry<ArmorMaterial> register(String id, Map<ArmorItem.Type, Integer> defensePoints,
                                                        int enchantability, RegistryEntry<SoundEvent> equipSound,
                                                        Supplier<Ingredient> repairIngredient, float toughness,
                                                        float knockbackResistance, boolean dyeable) {
        List<ArmorMaterial.Layer> layers = List.of(
                new ArmorMaterial.Layer(Cubetroid.id(id), "", dyeable)
        );

        var material = new ArmorMaterial(defensePoints, enchantability, equipSound, repairIngredient, layers,
                toughness, knockbackResistance);

        material = Registry.register(Registries.ARMOR_MATERIAL, Cubetroid.id(id), material);

        return RegistryEntry.of(material);
    }
    public static void load(){}
}

package io.github.mcneilkimberly.cubetroidmod.init.worldgen;

import io.github.mcneilkimberly.cubetroidmod.Cubetroid;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class PlacedFeatureInit {
    public static final RegistryKey<PlacedFeature> CHOZITE_ORE = registerKey("chozite_ore");

    public static void bootstrap(Registerable<PlacedFeature> context){
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryLookup = context
                .getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, CHOZITE_ORE, registryLookup.getOrThrow(ConfiguredFeatureInit.CHOZITE_ORE),
                Modifiers.modifiersWithCount(9,
                        HeightRangePlacementModifier
                                .uniform(YOffset.fixed(16), YOffset.TOP)
        ));
    }

    private static RegistryKey<PlacedFeature> registerKey(String name){
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Cubetroid.id(name));
    }

    private static void register(Registerable<PlacedFeature> context,
                                 RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> config,
                                 List<PlacementModifier> modifiers){
        context.register(key, new PlacedFeature(config, List.copyOf(modifiers)));
    }

    public static class Modifiers{
        public static List<PlacementModifier> modifiers(PlacementModifier countModifier,
                                                        PlacementModifier heightModifier) {
            return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
        }

        public static List<PlacementModifier> modifiersWithCount(int count,
                                                                 PlacementModifier heightModifier) {
            return modifiers(CountPlacementModifier.of(count), heightModifier);
        }

        public static List<PlacementModifier> modifiersWithRarity(int chance,
                                                                  PlacementModifier heightModifier) {
            return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
        }
    }
}

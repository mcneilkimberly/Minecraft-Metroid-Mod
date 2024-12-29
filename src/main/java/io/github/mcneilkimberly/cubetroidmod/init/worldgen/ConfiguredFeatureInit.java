package io.github.mcneilkimberly.cubetroidmod.init.worldgen;

import io.github.mcneilkimberly.cubetroidmod.Cubetroid;
import io.github.mcneilkimberly.cubetroidmod.init.Blockinit;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ConfiguredFeatureInit {
    public static final RegistryKey<ConfiguredFeature<?, ?>> CHOZITE_ORE = registerKey("chozite_ore");

    private static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Cubetroid.id(name));
    }

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        RuleTest stoneOreReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateOreReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> OverworldTargets =List.of(
                OreFeatureConfig.createTarget(stoneOreReplaceables, Blockinit.CHOZITE_ORE.getDefaultState())
        );

        register(context, CHOZITE_ORE, Feature.ORE, new OreFeatureConfig(OverworldTargets, 9));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key,
                                                                                   F feature,
                                                                                   FC featureConfig){
        context.register(key, new ConfiguredFeature<>(feature, featureConfig));
    }
}

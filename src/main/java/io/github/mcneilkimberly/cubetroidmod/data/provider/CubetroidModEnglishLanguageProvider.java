package io.github.mcneilkimberly.cubetroidmod.data.provider;

import io.github.mcneilkimberly.cubetroidmod.Cubetroid;
import io.github.mcneilkimberly.cubetroidmod.init.ItemGroupinit;
import io.github.mcneilkimberly.cubetroidmod.init.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class CubetroidModEnglishLanguageProvider extends FabricLanguageProvider {
    public CubetroidModEnglishLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    private static void addText(@NotNull TranslationBuilder builder, @NotNull Text text, @NotNull String value){
        if (text.getContent() instanceof TranslatableTextContent translatableTextContent){
            builder.add(translatableTextContent.getKey(), value);
        } else {
            Cubetroid.LOGGER.warn("Failed to add translation for text: {}", text.getString());
        }
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ItemInit.CHOZITE_BAR, "Chozite Bar");
        translationBuilder.add(ItemInit.CHOZITE_CHUNK, "Chozite Chunk");
        translationBuilder.add(ItemInit.EXAMPLE_HELMET, "Example Helmet");
        translationBuilder.add(ItemInit.EXAMPLE_CHESTPLATE, "Example Chestplate");
        translationBuilder.add(ItemInit.EXAMPLE_LEGGINGS, "Example Leggings");
        translationBuilder.add(ItemInit.EXAMPLE_BOOTS, "Example Boots");

        addText( translationBuilder, ItemGroupinit.CUBETROID_TITLE, "Cubetroid Mod");
    }
}

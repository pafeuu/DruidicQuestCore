package net.pafeuu.DruidicQuestMod;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraftforge.registries.IForgeRegistry;

public class DruidicQuestModUtils {

    //straight from my mod for now
    public static <T> Codec<Either<T, TagKey<T>>> elementOrTagCodec(IForgeRegistry<T> forgeRegistry, ResourceKey<Registry<T>> registryKey) {
        return Codec.STRING.comapFlatMap(str -> {
                    if (str.startsWith("#")) {
                        ResourceLocation tagId = ResourceLocation.tryParse(str.substring(1));
                        if (tagId != null) return DataResult.success(Either.right(TagKey.create(registryKey, tagId)));
                        return DataResult.error(() -> "Invalid Tag: '" + str + "'");
                    }
                    ResourceLocation elementId = ResourceLocation.tryParse(str);
                    if (elementId != null && forgeRegistry.containsKey(elementId)) return DataResult.success(Either.left(forgeRegistry.getValue(elementId)));
                    return DataResult.error(() -> "Unknown Registry ID: '" + str + "'");
                },
                either -> either.map(
                        element -> forgeRegistry.getKey(element).toString(),
                        tag -> "#" + tag.location()
                )
        );
    }

    public static final Codec<Integer> INT_KEY = Codec.STRING.comapFlatMap(s -> {
        try {
            return DataResult.success(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return DataResult.error(() -> "Expected integer key but got '" + s + "'");
        }
    }, i -> Integer.toString(i));
}

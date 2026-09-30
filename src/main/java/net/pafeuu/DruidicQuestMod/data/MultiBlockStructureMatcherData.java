package net.pafeuu.DruidicQuestMod.data;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.pafeuu.DruidicQuestMod.DruidicQuestModUtils;
import vazkii.patchouli.api.PatchouliAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

import static net.pafeuu.DruidicQuestMod.DruidicQuestMod.DQ_LOGGER;

public record MultiBlockStructureMatcherData(
        String structureId,
        Map<Integer, Map<Integer, String>> structure3DLayeredMap,
        Map<String, Either<Block, TagKey<Block>>> symbolToBlockMap
) {
    public static final Codec<MultiBlockStructureMatcherData> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.STRING.fieldOf("structure").forGetter(MultiBlockStructureMatcherData::structureId),
                    Codec.unboundedMap(Codec.INT, Codec.unboundedMap(Codec.INT, Codec.STRING))
                            .fieldOf("layout").forGetter(MultiBlockStructureMatcherData::structure3DLayeredMap),
                    Codec.unboundedMap(Codec.STRING, DruidicQuestModUtils.elementOrTagCodec(ForgeRegistries.BLOCKS, Registries.BLOCK))
                            .fieldOf("symbol_map").forGetter(MultiBlockStructureMatcherData::symbolToBlockMap)
            ).apply(instance, MultiBlockStructureMatcherData::new)
    );

    public String[][] assembleLayerMap(String errorMsg) {
        int layerCount = structure3DLayeredMap.size();
        OptionalInt optionalMaxRowCountPerLayer = structure3DLayeredMap.values().stream().mapToInt(Map::size).max();
        if (optionalMaxRowCountPerLayer.isEmpty()) {
            DQ_LOGGER.error(errorMsg);
            return new String[0][0];
        }

        String[][] layerMap = new String[layerCount][optionalMaxRowCountPerLayer.getAsInt()];
        for (int i = 0; i < layerCount; i++) {
            for (int j = 0; j < structure3DLayeredMap.get(i).size(); j++) {
                layerMap[i][j] = structure3DLayeredMap.get(i).get(j);
            }
        }

        return layerMap;
    }

    public Object[] assembleSymbolMap() {
        List<Object> symbolMap = new ArrayList<>();
        for (String symbol : symbolToBlockMap.keySet()) {
            symbolMap.add(symbol);
            symbolToBlockMap.get(symbol)
                    .ifRight(blockTag -> PatchouliAPI.get().tagMatcher(blockTag))
                    .ifLeft(symbolMap::add);
        }

        return symbolMap.toArray();
    }
}

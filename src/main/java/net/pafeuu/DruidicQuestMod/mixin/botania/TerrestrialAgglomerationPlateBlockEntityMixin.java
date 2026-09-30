package net.pafeuu.DruidicQuestMod.mixin.botania;

import com.google.common.base.Suppliers;
import net.minecraft.resources.ResourceLocation;
import net.pafeuu.DruidicQuestMod.data.MultiBlockStructureMatcherData;
import net.pafeuu.DruidicQuestMod.registries.TagsRegistry;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.botania.common.block.BotaniaBlocks;
import vazkii.botania.common.block.block_entity.TerrestrialAgglomerationPlateBlockEntity;
import vazkii.botania.common.lib.BotaniaTags;
import vazkii.patchouli.api.IMultiblock;
import vazkii.patchouli.api.PatchouliAPI;

import java.util.function.Supplier;

import static net.pafeuu.DruidicQuestMod.data.ReloadableData.MultiBlockStructureMatcherDataMap;

@Mixin(TerrestrialAgglomerationPlateBlockEntity.class)
public class TerrestrialAgglomerationPlateBlockEntityMixin {

    @Shadow(remap = false) @Mutable @Final
    public static Supplier<IMultiblock> MULTIBLOCK;

    @Unique
    private static MultiBlockStructureMatcherData druidic_quest_core$plateStructureData =
            MultiBlockStructureMatcherDataMap.get(ResourceLocation.parse("druidic_quest_core:terrestrial_agglomeration_plate"));
    @Unique
    private static String[][] druidic_quest_core$layerMap = druidic_quest_core$plateStructureData == null ? null :
            druidic_quest_core$plateStructureData.assembleLayerMap(
                    "[DruidicQuestMod] Error in assembling 3D layer map for terrestrial agglomeration plate.");
    @Unique
    private static Object[] druidic_quest_core$symbolMap = druidic_quest_core$plateStructureData == null ? null :
            druidic_quest_core$plateStructureData.assembleSymbolMap();

    @Inject(
            method = "<clinit>",
            at = @At("RETURN")
    )
    private static void druidic_quest_core$replaceMultiblock(CallbackInfo ci) {
        MULTIBLOCK = Suppliers.memoize(() -> PatchouliAPI.get().makeMultiblock(
                new String[][] {
                        {
                                "_____",
                                "_____",
                                "__P__",
                                "_____",
                                "_____"
                        },
                        {
                                "XXLXX",
                                "XLLLX",
                                "LL0LL",
                                "XLLLX",
                                "XXLXX"
                        }
                },
                'P', BotaniaBlocks.terraPlate,
                'X', PatchouliAPI.get().tagMatcher(TagsRegistry.Blocks.TERRA_PLATE_BASE_ALT),
                '0', PatchouliAPI.get().tagMatcher(BotaniaTags.Blocks.TERRA_PLATE_BASE),
                'L', PatchouliAPI.get().tagMatcher(BotaniaTags.Blocks.TERRA_PLATE_BASE)
        ));

        if (druidic_quest_core$plateStructureData == null)
            return;

        MULTIBLOCK = Suppliers.memoize(() -> PatchouliAPI.get().makeMultiblock(druidic_quest_core$layerMap, druidic_quest_core$symbolMap));
    }

    @Inject(
            method = "serverTick",
            at = @At("RETURN"),
            remap = false
    )
    private static void druidic_quest_core$setPlateStructureData(CallbackInfo ci) {
        if (druidic_quest_core$plateStructureData != null)
            return;
        druidic_quest_core$setPlateStructureData();
    }

    @Unique
    private static void druidic_quest_core$setPlateStructureData() {
        druidic_quest_core$plateStructureData = MultiBlockStructureMatcherDataMap.get(
                ResourceLocation.parse("druidic_quest_core:terrestrial_agglomeration_plate")
        );
        druidic_quest_core$layerMap();
        druidic_quest_core$symbolMap();

        MULTIBLOCK = Suppliers.memoize(() -> PatchouliAPI.get().makeMultiblock(druidic_quest_core$layerMap, druidic_quest_core$symbolMap));
    }
    @Unique
    private static void druidic_quest_core$layerMap() {
        druidic_quest_core$layerMap = druidic_quest_core$plateStructureData
                .assembleLayerMap("[DruidicQuestMod] Error in assembling 3D layer map for terrestrial agglomeration plate.");
    }
    @Unique
    private static void druidic_quest_core$symbolMap() {
        druidic_quest_core$symbolMap = druidic_quest_core$plateStructureData.assembleSymbolMap();
    }
}


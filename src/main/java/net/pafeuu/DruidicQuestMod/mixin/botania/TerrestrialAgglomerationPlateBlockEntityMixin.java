package net.pafeuu.DruidicQuestMod.mixin.botania;

import com.google.common.base.Suppliers;
import net.minecraft.resources.ResourceLocation;
import net.pafeuu.DruidicQuestMod.data.MultiBlockStructureMatcherData;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.botania.common.block.block_entity.TerrestrialAgglomerationPlateBlockEntity;
import vazkii.patchouli.api.IMultiblock;
import vazkii.patchouli.api.PatchouliAPI;

import java.util.function.Supplier;

import static net.pafeuu.DruidicQuestMod.data.ReloadableData.MultiBlockStructureMatcherDataMap;

@Mixin(TerrestrialAgglomerationPlateBlockEntity.class)
public class TerrestrialAgglomerationPlateBlockEntityMixin {

    @Shadow
    @Mutable
    @Final
    public static Supplier<IMultiblock> MULTIBLOCK;

    @Unique
    private static final MultiBlockStructureMatcherData druidic_quest_core$plateStructureData =
            MultiBlockStructureMatcherDataMap.get(ResourceLocation.parse("botania:terrestrial_agglomeration_plate"));
    @Unique
    private static final String[][] druidic_quest_core$layerMap = druidic_quest_core$plateStructureData
            .assembleLayerMap("[DruidicQuestMod] Error in assembling 3D layer map for terrestrial agglomeration plate.");
    @Unique
    private static final Object[] druidic_quest_core$symbolMap = druidic_quest_core$plateStructureData.assembleSymbolMap();
    //Currently, incorrect structure JSON files have no explicit safety nets built to catch errors or crashes. Happy pack dev-ing!

    @Inject(
            method = "<clinit>",
            at = @At("RETURN")
    )
    private static void druidic_quest_core$replaceMultiblock(CallbackInfo ci) {
//        MULTIBLOCK = Suppliers.memoize(() -> PatchouliAPI.get().makeMultiblock(
//                new String[][] {
//                        {
//                                "_____",
//                                "_____",
//                                "__P__",
//                                "_____",
//                                "_____"
//                        },
//                        {
//                                "XXLXX",
//                                "XLLLX",
//                                "LL0LL",
//                                "XLLLX",
//                                "XXLXX"
//                        }
//                },
//                'P', BotaniaBlocks.terraPlate,
//                'X', PatchouliAPI.get().tagMatcher(TagsRegistry.Blocks.TERRA_PLATE_BASE_ALT),
//                '0', PatchouliAPI.get().tagMatcher(BotaniaTags.Blocks.TERRA_PLATE_BASE),
//                'L', PatchouliAPI.get().tagMatcher(BotaniaTags.Blocks.TERRA_PLATE_BASE)
//        ));

        MULTIBLOCK = Suppliers.memoize(() -> PatchouliAPI.get().makeMultiblock(druidic_quest_core$layerMap, druidic_quest_core$symbolMap));
    }
}


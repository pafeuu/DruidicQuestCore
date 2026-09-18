package net.pafeuu.DruidicQuestMod.mixin.botania;

import com.google.common.base.Suppliers;
import net.pafeuu.DruidicQuestMod.registries.TagsRegistry;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.botania.common.block.BotaniaBlocks;
import vazkii.botania.common.block.block_entity.TerrestrialAgglomerationPlateBlockEntity;
import vazkii.botania.common.lib.BotaniaTags;
import vazkii.patchouli.api.IMultiblock;
import vazkii.patchouli.api.PatchouliAPI;

import java.util.function.Supplier;

@Mixin(TerrestrialAgglomerationPlateBlockEntity.class)
public class TerrestrialAgglomerationPlateBlockEntityMixin {

    @Shadow
    @Mutable
    @Final
    public static Supplier<IMultiblock> MULTIBLOCK;

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void replaceMultiblock(CallbackInfo ci) {
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
    }
}


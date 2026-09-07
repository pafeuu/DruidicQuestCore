package net.pafeuu.DruidicQuestMod.mixin.botania.RunicAltar;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import vazkii.botania.api.recipe.RunicAltarRecipe;
import vazkii.botania.common.block.block_entity.RunicAltarBlockEntity;

@Mixin(RunicAltarBlockEntity.Hud.class)
public abstract class RunicAltarBlockEntityHudMixin {

    @WrapOperation(
            method = "lambda$render$0",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/GuiGraphics;renderFakeItem(Lnet/minecraft/world/item/ItemStack;II)V",
                    ordinal = 0
            )
    )
    private static void druidic_quest_core$renderCustomCatalyst(GuiGraphics instance, ItemStack pStack, int pX,
                                                                int pY, Operation<Void> original,
                                                                @Local(argsOnly = true) RunicAltarRecipe recipe) {
        original.call(instance, recipe.getReagent().getItems()[0] , pX, pY);
    }
}

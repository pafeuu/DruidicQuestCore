package net.pafeuu.DruidicQuestMod.mixin.arsenchantlimit;

import com.hollingsworth.arsnouveau.api.enchanting_apparatus.EnchantmentRecipe;
import com.hollingsworth.arsnouveau.api.enchanting_apparatus.IEnchantingRecipe;
import com.hollingsworth.arsnouveau.common.block.tile.EnchantingApparatusTile;
import com.hollingsworth.arsnouveau.common.block.tile.SingleItemTile;
import com.llamalad7.mixinextras.sugar.Local;
import jackiecrazy.enchantlimiter.EnchantLimiter;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantingApparatusTile.class)
public abstract class EnchantingApparatusTileMixin extends SingleItemTile {
    public EnchantingApparatusTileMixin(BlockEntityType<?> tileEntityTypeIn, BlockPos pos, BlockState state) {
        super(tileEntityTypeIn, pos, state);
    }

    @Inject(
            method = "craftingPossible",
            at = @At(
                    value = "RETURN",
                    ordinal = 1
            ),
            cancellable = true,
            remap = false
    )
    private void druidic_quest_core$limitEnchantingApparatusEnchanting(
            ItemStack stack, Player player, CallbackInfoReturnable<Boolean> cir,
            @Local(name = "recipe") IEnchantingRecipe recipe) {
        if (this.level == null || !(recipe instanceof EnchantmentRecipe enchRecipe))
            return;
        double totalEnchPts = EnchantLimiter.getTotalEnchantPoints(stack);
        double newEnchPts = EnchantLimiter.getRequiredEnchantPoints(enchRecipe.enchantment, enchRecipe.enchantLevel);
        int enchLevelCur = EnchantmentHelper.getEnchantments(stack).getOrDefault(enchRecipe.enchantment, 0);
        if (enchLevelCur > 0)
            newEnchPts -= EnchantLimiter.getRequiredEnchantPoints(enchRecipe.enchantment, enchLevelCur);
        double usedEnchPts = EnchantLimiter.getUsedEnchantPoints(stack) + newEnchPts;
        if (totalEnchPts - usedEnchPts >= 0)
            return;
        cir.setReturnValue(false);
        cir.cancel();
        if (player == null)
            return;
        player.displayClientMessage(Component.translatable("info.druidic_quest_core.ench_limit_reached")
                .withStyle(Style.EMPTY.withColor(16733525)), true);
    }
}

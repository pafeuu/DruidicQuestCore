package net.pafeuu.DruidicQuestMod.mixin.sophisticated;

import net.minecraft.advancements.Advancement;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.p3pp3rf1y.sophisticateditemactions.common.ItemTransferHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;

import static net.pafeuu.DruidicQuestMod.config.CommonConfig.*;

@Mixin(value = ItemTransferHandler.class, remap = false)
public abstract class GateDepositOrExtractMixin {

    @Inject(
            method = "handleDeposit",
            at = @At("HEAD"),
            cancellable = true,
            remap = false
    )
    private static void druidic_quest_core$gateDepositActionBehindAdvancement(
            Player player, int minSlot, int maxSlot, Map<ResourceLocation, List<BlockPos>> storagePositions,
            Map<ResourceLocation, List<Integer>> entities, boolean onlyMatching, CallbackInfo ci) {
        if (ENABLE_SOPH_ACTION_GATING_DEPOSIT.get() == false)
            return;
        if (player == null)
            return;
        MinecraftServer server = player.getServer();
        if (server == null)
            return;
        Advancement advancement = server.getAdvancements().getAdvancement(ResourceLocation.parse(ADV_ID_FOR_SOPH_GATE_DEPOSIT.get()));
        if (advancement == null)
            return;
        if (((ServerPlayer) player).getAdvancements().getOrStartProgress(advancement).isDone())
            return;

        ci.cancel();
        player.displayClientMessage(Component.translatable("info.druidic_quest_core.not_qualified_for_soph_action")
                        .withStyle(Style.EMPTY.withColor(16733525)), true);
        player.playSound(SoundEvents.NOTE_BLOCK_BASS.value(), 1.0F, 0.35F + player.level().random.nextFloat() * 0.2F);
    }

    @Inject(
            method = "restockItem(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/item/ItemStack;IIZZ)V",
            at = @At("HEAD"),
            cancellable = true,
            remap = false
    )
    private static void druidic_quest_core$gateRestockActionBehindAdvancement(
            Player player, ItemStack filter, int minSlot, int maxSlot, boolean fillEmpty, boolean refillSingle, CallbackInfo ci) {
        if (ENABLE_SOPH_ACTION_GATING_RESTOCK.get() == false)
            return;
        if (player == null)
            return;
        MinecraftServer server = player.getServer();
        if (server == null)
            return;
        Advancement advancement = server.getAdvancements().getAdvancement(ResourceLocation.parse(ADV_ID_FOR_SOPH_GATE_RESTOCK.get()));
        if (advancement == null)
            return;
        if (((ServerPlayer) player).getAdvancements().getOrStartProgress(advancement).isDone())
            return;

        ci.cancel();
        player.displayClientMessage(Component.translatable("info.druidic_quest_core.not_qualified_for_soph_action")
                .withStyle(Style.EMPTY.withColor(16733525)), true);
        player.playSound(SoundEvents.NOTE_BLOCK_BASS.value(), 1.0F, 0.35F + player.level().random.nextFloat() * 0.2F);
    }
}

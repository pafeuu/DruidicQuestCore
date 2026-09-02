package net.pafeuu.DruidicQuestMod.registries.tiers;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.pafeuu.DruidicQuestMod.DruidicQuestMod;
import net.pafeuu.DruidicQuestMod.registries.ItemRegistry;

import java.util.List;

public class ToolTierRegistry {

    public static final Tier STEEL = TierSortingRegistry.registerTier(
            new ForgeTier(2, -1,5f,0,25, BlockTags.NEEDS_IRON_TOOL,
                    ()-> Ingredient.of(ItemRegistry.STEEL_INGOT.get())),
            ResourceLocation.fromNamespaceAndPath(DruidicQuestMod.MODID,"steel"),
            List.of(Tiers.IRON),
            List.of()
    );

    public static final Tier PLATINUM = TierSortingRegistry.registerTier(
            new ForgeTier(4, 16384,12f,6,25, BlockTags.NEEDS_DIAMOND_TOOL,
                    ()-> Ingredient.of(ItemRegistry.PLATINUM_INGOT.get())),
            ResourceLocation.fromNamespaceAndPath(DruidicQuestMod.MODID,"platinum"),
            List.of(Tiers.NETHERITE),
            List.of()
    );

}

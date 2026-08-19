package net.pafeuu.DruidicQuestMod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.pafeuu.DruidicQuestMod.DruidicQuestMod;
import net.pafeuu.DruidicQuestMod.registries.BlockRegistry;
import net.pafeuu.DruidicQuestMod.registries.ItemRegistry;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {


    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, DruidicQuestMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "ingots/steel")))
                .add(ItemRegistry.STEEL_INGOT.get());

        tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "nuggets/steel")))
                .add(ItemRegistry.STEEL_NUGGET.get());

        tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "rods/steel")))
                .add(ItemRegistry.STEEL_ROD.get());

        tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "gears/steel")))
                .add(ItemRegistry.STEEL_GEAR.get());

        tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "plates/steel")))
                .add(ItemRegistry.STEEL_PLATE.get());


        tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge","plates")))
                .add(ItemRegistry.STEEL_PLATE.get())
                .add(ItemRegistry.URANIUM_PLATE.get())
                .add(ItemRegistry.PLATINUM_PLATE.get());

        tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge","rods")))
                .add(ItemRegistry.STEEL_ROD.get())
                .add(ItemRegistry.URANIUM_ROD.get())
                .add(ItemRegistry.PLATINUM_ROD.get());

        tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge","gears")))
                .add(ItemRegistry.STEEL_GEAR.get())
                .add(ItemRegistry.URANIUM_GEAR.get())
                .add(ItemRegistry.PLATINUM_GEAR.get());

        tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge","nuggets")))
                .add(ItemRegistry.STEEL_NUGGET.get())
                .add(ItemRegistry.URANIUM_NUGGET.get())
                .add(ItemRegistry.PLATINUM_NUGGET.get());

        tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge","ingots")))
                .add(ItemRegistry.STEEL_INGOT.get())
                .add(ItemRegistry.URANIUM_INGOT.get())
                .add(ItemRegistry.PLATINUM_INGOT.get());


        tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "storage_blocks/steel")))
                .add(Item.byBlock(BlockRegistry.STEEL_BLOCK.get()));

        tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "storage_blocks")))
                .add(Item.byBlock(BlockRegistry.STEEL_BLOCK.get()));


        copy(BlockTags.LOGS,ItemTags.LOGS);
        copy(BlockTags.PLANKS,ItemTags.PLANKS);
    }
}

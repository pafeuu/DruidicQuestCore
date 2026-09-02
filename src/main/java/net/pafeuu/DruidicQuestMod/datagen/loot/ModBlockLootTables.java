package net.pafeuu.DruidicQuestMod.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.registries.RegistryObject;
import net.pafeuu.DruidicQuestMod.registries.BlockRegistry;
import net.pafeuu.DruidicQuestMod.registries.ItemRegistry;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(BlockRegistry.IVY_BLOCK.get());
        this.dropSelf(BlockRegistry.GOLD_LEAF_BLOCK.get());
        this.dropSelf(BlockRegistry.PRIMITIVE_MACHINE.get());
        this.dropSelf(BlockRegistry.STURDY_DEEPSLATE.get());
        this.dropSelf(BlockRegistry.ALLOY_BRICKS.get());
        this.dropSelf(BlockRegistry.ROTTEN_FLESH_BLOCK.get());
        this.dropSelf(BlockRegistry.STURDY_DEEPSLATE_SLAB.get());
        this.dropSelf(BlockRegistry.PACKED_PLANKS.get());
        this.dropSelf(BlockRegistry.STACKED_PLANKS.get());
        this.dropSelf(BlockRegistry.POLISHED_PLANKS.get());
        this.dropSelf(BlockRegistry.STEEL_BLOCK.get());
        this.dropSelf(BlockRegistry.URANIUM_BLOCK.get());
        this.dropSelf(BlockRegistry.RAW_URANIUM_BLOCK.get());
        this.dropSelf(BlockRegistry.PLATINUM_BLOCK.get());
        this.dropSelf(BlockRegistry.RAW_PLATINUM_BLOCK.get());
        /*this.dropSelf(BlockRegistry.TREATED_WOOD.get());
        this.dropSelf(BlockRegistry.TREATED_PLANKS.get());
        this.dropSelf(BlockRegistry.TREATED_SLAB.get());
        this.dropSelf(BlockRegistry.TREATED_STAIRS.get());
        this.dropSelf(BlockRegistry.TREATED_FENCE.get());
        this.dropSelf(BlockRegistry.TREATED_FENCE_GATE.get());
        this.dropSelf(BlockRegistry.TREATED_DOOR.get());
        this.dropSelf(BlockRegistry.TREATED_TRAPDOOR.get());
        this.dropSelf(BlockRegistry.TREATED_LOG.get());
        this.dropSelf(BlockRegistry.STRIPPED_TREATED_LOG.get());
        this.dropSelf(BlockRegistry.STRIPPED_TREATED_WOOD.get());*/

        this.add(BlockRegistry.PLATINUM_ORE.get(),
                block -> createOreDrop(BlockRegistry.PLATINUM_ORE.get(),ItemRegistry.RAW_PLATINUM.get()));

        this.add(BlockRegistry.URANIUM_ORE.get(),
                block -> createOreDrop(BlockRegistry.URANIUM_ORE.get(),ItemRegistry.RAW_URANIUM.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

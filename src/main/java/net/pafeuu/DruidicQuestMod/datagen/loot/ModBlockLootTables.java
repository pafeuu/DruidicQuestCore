package net.pafeuu.DruidicQuestMod.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.pafeuu.DruidicQuestMod.registries.BlockRegistry;

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
        this.dropSelf(BlockRegistry.ROTTEN_FLESH_BLOCK.get());
        this.dropSelf(BlockRegistry.STURDY_DEEPSLATE_SLAB.get());
        this.dropSelf(BlockRegistry.PACKED_PLANKS.get());
        this.dropSelf(BlockRegistry.STACKED_PLANKS.get());
        this.dropSelf(BlockRegistry.POLISHED_PLANKS.get());
        this.dropSelf(BlockRegistry.STEEL_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

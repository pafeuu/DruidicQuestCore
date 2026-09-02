package net.pafeuu.DruidicQuestMod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.pafeuu.DruidicQuestMod.DruidicQuestMod;
import net.pafeuu.DruidicQuestMod.registries.BlockRegistry;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DruidicQuestMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(BlockRegistry.PRIMITIVE_MACHINE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(BlockRegistry.STURDY_DEEPSLATE_SLAB.get(),
                        BlockRegistry.ALLOY_BRICKS.get(),
                        BlockRegistry.STURDY_DEEPSLATE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(BlockRegistry.STEEL_BLOCK.get(),
                        BlockRegistry.URANIUM_BLOCK.get(),
                        BlockRegistry.RAW_URANIUM_BLOCK.get(),
                        BlockRegistry.URANIUM_ORE.get(),
                        BlockRegistry.PLATINUM_ORE.get(),
                        BlockRegistry.RAW_PLATINUM_BLOCK.get(),
                        BlockRegistry.PLATINUM_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(BlockRegistry.PACKED_PLANKS.get(),
                        BlockRegistry.STACKED_PLANKS.get(),
                        /*BlockRegistry.TREATED_PLANKS.get(),
                        BlockRegistry.TREATED_SLAB.get(),
                        BlockRegistry.TREATED_STAIRS.get(),
                        BlockRegistry.TREATED_DOOR.get(),
                        BlockRegistry.TREATED_FENCE.get(),
                        BlockRegistry.TREATED_FENCE_GATE.get(),
                        BlockRegistry.TREATED_TRAPDOOR.get(),
                        BlockRegistry.TREATED_LOG.get(),
                        BlockRegistry.TREATED_WOOD.get(),
                        BlockRegistry.STRIPPED_TREATED_LOG.get(),
                        BlockRegistry.STRIPPED_TREATED_WOOD.get(),*/
                        BlockRegistry.POLISHED_PLANKS.get());

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(BlockRegistry.SUSPICIOUS_SNOW.get(),
                        BlockRegistry.SUSPICIOUS_CLAY.get(),
                        BlockRegistry.SUSPICIOUS_MUD.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockRegistry.PRIMITIVE_MACHINE.get(),
                        BlockRegistry.STURDY_DEEPSLATE.get(),
                        BlockRegistry.ALLOY_BRICKS.get(),
                        BlockRegistry.STEEL_BLOCK.get(),
                        BlockRegistry.URANIUM_BLOCK.get(),
                        BlockRegistry.RAW_URANIUM_BLOCK.get(),
                        BlockRegistry.URANIUM_ORE.get(),
                        BlockRegistry.PLATINUM_BLOCK.get(),
                        BlockRegistry.RAW_PLATINUM_BLOCK.get(),
                        BlockRegistry.PLATINUM_ORE.get(),
                        BlockRegistry.STURDY_DEEPSLATE_SLAB.get());

        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(BlockRegistry.IVY_BLOCK.get(),
                        BlockRegistry.ROTTEN_FLESH_BLOCK.get(),
                        BlockRegistry.GOLD_LEAF_BLOCK.get());

        this.tag(BlockTags.PLANKS)
                .add(//BlockRegistry.TREATED_PLANKS.get(),
                        BlockRegistry.POLISHED_PLANKS.get(),
                        BlockRegistry.STACKED_PLANKS.get(),
                        BlockRegistry.PACKED_PLANKS.get());

        /*this.tag(BlockTags.LOGS)
                .add(BlockRegistry.TREATED_LOG.get(),
                        BlockRegistry.STRIPPED_TREATED_LOG.get(),
                        BlockRegistry.TREATED_WOOD.get(),
                        BlockRegistry.STRIPPED_TREATED_WOOD.get());
        this.tag(BlockTags.FENCES)
                .add(BlockRegistry.TREATED_FENCE.get());

        this.tag(BlockTags.FENCE_GATES)
                .add(BlockRegistry.TREATED_FENCE_GATE.get());*/


    }
}

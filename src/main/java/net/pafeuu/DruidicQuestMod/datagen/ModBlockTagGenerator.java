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
                        BlockRegistry.STURDY_DEEPSLATE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);

        this.tag(BlockTags.MINEABLE_WITH_AXE);

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(BlockRegistry.SUSPICIOUS_SNOW.get(),
                        BlockRegistry.SUSPICIOUS_CLAY.get(),
                        BlockRegistry.SUSPICIOUS_MUD.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockRegistry.PRIMITIVE_MACHINE.get(),
                        BlockRegistry.STURDY_DEEPSLATE.get(),
                        BlockRegistry.STURDY_DEEPSLATE_SLAB.get());

        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(BlockRegistry.IVY_BLOCK.get(),
                        BlockRegistry.GOLD_LEAF_BLOCK.get());

    }
}

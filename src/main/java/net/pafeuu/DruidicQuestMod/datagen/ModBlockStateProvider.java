package net.pafeuu.DruidicQuestMod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.pafeuu.DruidicQuestMod.DruidicQuestMod;
import net.pafeuu.DruidicQuestMod.registries.BlockRegistry;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DruidicQuestMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(BlockRegistry.GOLD_LEAF_BLOCK);
        blockWithItem(BlockRegistry.IVY_BLOCK);
        blockWithItem(BlockRegistry.PRIMITIVE_MACHINE);
        blockWithItem(BlockRegistry.ROTTEN_FLESH_BLOCK);
        //blockWithItem(BlockRegistry.STURDY_DEEPSLATE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject)   {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}

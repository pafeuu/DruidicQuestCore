package net.pafeuu.DruidicQuestMod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
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
        blockWithItem(BlockRegistry.ALLOY_BRICKS);
        blockWithItem(BlockRegistry.ARCANE_BRICKS);
        blockWithItem(BlockRegistry.ROTTEN_FLESH_BLOCK);
        blockWithItem(BlockRegistry.STEEL_BLOCK);
        blockWithItem(BlockRegistry.PLATINUM_BLOCK);
        blockWithItem(BlockRegistry.RAW_PLATINUM_BLOCK);
        blockWithItem(BlockRegistry.PLATINUM_ORE);
        blockWithItem(BlockRegistry.URANIUM_BLOCK);
        blockWithItem(BlockRegistry.RAW_URANIUM_BLOCK);
        blockWithItem(BlockRegistry.URANIUM_ORE);
        /*blockWithItem(BlockRegistry.TREATED_PLANKS);
        logBlock((RotatedPillarBlock) BlockRegistry.TREATED_LOG.get());
        logBlock((RotatedPillarBlock) BlockRegistry.STRIPPED_TREATED_LOG.get());
        axisBlock((RotatedPillarBlock) BlockRegistry.TREATED_WOOD.get(),
                blockTexture(BlockRegistry.TREATED_LOG.get()),blockTexture(BlockRegistry.TREATED_LOG.get()));
        axisBlock((RotatedPillarBlock) BlockRegistry.STRIPPED_TREATED_WOOD.get(),
                blockTexture(BlockRegistry.STRIPPED_TREATED_LOG.get()),blockTexture(BlockRegistry.STRIPPED_TREATED_LOG.get()));
        blockItem(BlockRegistry.TREATED_LOG);
        blockItem(BlockRegistry.STRIPPED_TREATED_LOG);
        blockItem(BlockRegistry.TREATED_WOOD);
        blockItem(BlockRegistry.STRIPPED_TREATED_WOOD);
        stairsBlock((StairBlock) BlockRegistry.TREATED_STAIRS.get(),blockTexture(BlockRegistry.TREATED_PLANKS.get()));
        fenceBlock((FenceBlock) BlockRegistry.TREATED_FENCE.get(),blockTexture(BlockRegistry.TREATED_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) BlockRegistry.TREATED_FENCE_GATE.get(),blockTexture(BlockRegistry.TREATED_PLANKS.get()));
        slabBlock((SlabBlock) BlockRegistry.TREATED_SLAB.get(),blockTexture(BlockRegistry.TREATED_PLANKS.get()),blockTexture(BlockRegistry.TREATED_PLANKS.get()));
        doorBlockWithRenderType((DoorBlock) BlockRegistry.TREATED_DOOR.get(),modLoc("block/treated_wood_door_bottom"),modLoc("block/treated_wood_door_top"),"cutout");
        trapdoorBlock((TrapDoorBlock) BlockRegistry.TREATED_TRAPDOOR.get(),modLoc("block/treated_wood_trapdoor"),true);*/



    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(DruidicQuestMod.MODID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject)   {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }


}

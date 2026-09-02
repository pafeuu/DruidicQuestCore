package net.pafeuu.DruidicQuestMod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import net.pafeuu.DruidicQuestMod.DruidicQuestMod;
import net.pafeuu.DruidicQuestMod.registries.BlockRegistry;
import net.pafeuu.DruidicQuestMod.registries.ItemRegistry;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        nineBlockStorageRecipesFixed(pWriter, RecipeCategory.BUILDING_BLOCKS, Blocks.DEEPSLATE, RecipeCategory.BUILDING_BLOCKS, BlockRegistry.STURDY_DEEPSLATE.get());
        nineBlockStorageRecipesFixed(pWriter, RecipeCategory.BUILDING_BLOCKS, Items.ROTTEN_FLESH, RecipeCategory.BUILDING_BLOCKS, BlockRegistry.ROTTEN_FLESH_BLOCK.get());
        nineBlockStorageRecipesFixed(pWriter, RecipeCategory.BUILDING_BLOCKS, ItemRegistry.STEEL_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, BlockRegistry.STEEL_BLOCK.get());
        nineBlockStorageRecipesFixed(pWriter, RecipeCategory.MISC, ItemRegistry.STEEL_NUGGET.get(), RecipeCategory.MISC, ItemRegistry.STEEL_INGOT.get());
        nineBlockStorageRecipesFixed(pWriter, RecipeCategory.BUILDING_BLOCKS, ItemRegistry.PLATINUM_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, BlockRegistry.PLATINUM_BLOCK.get());
        nineBlockStorageRecipesFixed(pWriter, RecipeCategory.BUILDING_BLOCKS, ItemRegistry.RAW_PLATINUM.get(), RecipeCategory.BUILDING_BLOCKS, BlockRegistry.RAW_PLATINUM_BLOCK.get());
        nineBlockStorageRecipesFixed(pWriter, RecipeCategory.MISC, ItemRegistry.PLATINUM_NUGGET.get(), RecipeCategory.MISC, ItemRegistry.PLATINUM_INGOT.get());
        nineBlockStorageRecipesFixed(pWriter, RecipeCategory.BUILDING_BLOCKS, ItemRegistry.URANIUM_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, BlockRegistry.URANIUM_BLOCK.get());
        nineBlockStorageRecipesFixed(pWriter, RecipeCategory.BUILDING_BLOCKS, ItemRegistry.RAW_URANIUM.get(), RecipeCategory.BUILDING_BLOCKS, BlockRegistry.RAW_URANIUM_BLOCK.get());
        nineBlockStorageRecipesFixed(pWriter, RecipeCategory.MISC, ItemRegistry.URANIUM_NUGGET.get(), RecipeCategory.MISC, ItemRegistry.URANIUM_INGOT.get());
        slabBuilder(RecipeCategory.BUILDING_BLOCKS,BlockRegistry.STURDY_DEEPSLATE_SLAB.get(), Ingredient.of(BlockRegistry.STURDY_DEEPSLATE.get()));
        toolRecipes(pWriter,"steel",Items.STICK);
        toolRecipes(pWriter,"platinum",Items.STICK);
        armorRecipes(pWriter,"steel");
        /*stickRecipe(pWriter,ItemRegistry.TREATED_STICK.get(),BlockRegistry.TREATED_PLANKS.get(),4);

        betterTrapdoorBuilder(pWriter,BlockRegistry.TREATED_TRAPDOOR.get(),BlockRegistry.TREATED_PLANKS.get());
        betterDoorBuilder(pWriter,BlockRegistry.TREATED_DOOR.get(),BlockRegistry.TREATED_PLANKS.get());
        betterFenceBuilder(pWriter, BlockRegistry.TREATED_FENCE.get(),BlockRegistry.TREATED_PLANKS.get(),ItemRegistry.TREATED_STICK.get());
        betterFenceGateBuilder(pWriter, BlockRegistry.TREATED_FENCE_GATE.get(),BlockRegistry.TREATED_PLANKS.get(),ItemRegistry.TREATED_STICK.get());
        betterSlabBuilder(pWriter, BlockRegistry.TREATED_SLAB.get(),BlockRegistry.TREATED_PLANKS.get());
        betterStairsBuilder(pWriter, BlockRegistry.TREATED_STAIRS.get(),BlockRegistry.TREATED_PLANKS.get());*/


    }

    protected static void nineBlockStorageRecipesFixed(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeCategory pUnpackedCategory, ItemLike pUnpacked, RecipeCategory pPackedCategory, ItemLike pPacked) {

        nineBlockStorageRecipesFixed(pFinishedRecipeConsumer, pUnpackedCategory, pUnpacked, pPackedCategory, pPacked, getSimpleRecipeName(pPacked), (String)null, getSimpleRecipeName(pUnpacked), (String)null);

    }

    protected static void nineBlockStorageRecipesFixed(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeCategory pUnpackedCategory, ItemLike pUnpacked, RecipeCategory pPackedCategory, ItemLike pPacked, String pPackedName, @Nullable String pPackedGroup, String pUnpackedName, @Nullable String pUnpackedGroup) {

        ShapelessRecipeBuilder.shapeless(pUnpackedCategory, pUnpacked, 9)
                .requires(pPacked).group(pUnpackedGroup).unlockedBy(getHasName(pPacked), has(pPacked))
                .save(pFinishedRecipeConsumer, DruidicQuestMod.MODID+":unpacking_"+ getItemName(pPacked));

        ShapedRecipeBuilder.shaped(pPackedCategory, pPacked)
                .define('#', pUnpacked).pattern("###")
                .pattern("###").pattern("###")
                .group(pPackedGroup).unlockedBy(getHasName(pUnpacked), has(pUnpacked))
                .save(pFinishedRecipeConsumer, DruidicQuestMod.MODID+":packing_"+ getItemName(pUnpacked));
    }

    protected static void stickRecipe(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pOutput, ItemLike pInput, int count){
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,pOutput,count)
                .define('X',pInput)
                .pattern("X")
                .pattern("X")
                .unlockedBy(getHasName(pInput),has(pInput))
                .save(pFinishedRecipeConsumer);
    }

    protected static void betterStairsBuilder(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pStairs, ItemLike pMaterial) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, pStairs, 4)
                .define('W', pMaterial)
                .pattern("W  ")
                .pattern("WW ")
                .pattern("WWW")
                .unlockedBy(getHasName(pMaterial),has(pMaterial))
                .save(pFinishedRecipeConsumer);
    }
    protected static void betterSlabBuilder(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pSlab, ItemLike pMaterial) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, pSlab, 5)
                .define('W', pMaterial)
                .pattern("WWW")
                .unlockedBy(getHasName(pMaterial),has(pMaterial))
                .save(pFinishedRecipeConsumer);
    }

    protected static void betterTrapdoorBuilder(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pTrapdoor, ItemLike pMaterial) {
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, pTrapdoor, 2)
                .define('#', pMaterial)
                .pattern("###")
                .pattern("###")
                .unlockedBy(getHasName(pMaterial),has(pMaterial))
                .save(pFinishedRecipeConsumer);
    }

    protected static void betterDoorBuilder(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pDoor, ItemLike pMaterial) {
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, pDoor, 3)
                .define('#', pMaterial)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(pMaterial),has(pMaterial))
                .save(pFinishedRecipeConsumer);
    }

    protected static void betterFenceBuilder(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pFence, ItemLike pMaterial, ItemLike pStick) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, pFence, 6)
                .define('W', pMaterial)
                .define('#', pStick)
                .pattern("W#W")
                .pattern("W#W")
                .unlockedBy(getHasName(pMaterial),has(pMaterial))
                .save(pFinishedRecipeConsumer);
    }

    protected static void betterFenceGateBuilder(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pFenceGate, ItemLike pMaterial, ItemLike pStick) {
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, pFenceGate)
                .define('#', pStick).define('W', pMaterial)
                .pattern("#W#")
                .pattern("#W#")
                .unlockedBy(getHasName(pMaterial),has(pMaterial))
                .save(pFinishedRecipeConsumer);
    }

    protected static void toolRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer, String materialType, ItemLike rod){

        ItemLike ingot = ForgeRegistries.ITEMS.getValue(ResourceLocation.tryParse(DruidicQuestMod.MODID+":"+materialType+"_ingot"));
        ItemLike pickaxe = ForgeRegistries.ITEMS.getValue(ResourceLocation.tryParse(DruidicQuestMod.MODID+":"+materialType+"_pickaxe"));
        ItemLike axe = ForgeRegistries.ITEMS.getValue(ResourceLocation.tryParse(DruidicQuestMod.MODID+":"+materialType+"_axe"));
        ItemLike hoe = ForgeRegistries.ITEMS.getValue(ResourceLocation.tryParse(DruidicQuestMod.MODID+":"+materialType+"_hoe"));
        ItemLike shovel = ForgeRegistries.ITEMS.getValue(ResourceLocation.tryParse(DruidicQuestMod.MODID+":"+materialType+"_shovel"));
        ItemLike sword = ForgeRegistries.ITEMS.getValue(ResourceLocation.tryParse(DruidicQuestMod.MODID+":"+materialType+"_sword"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pickaxe)
                .define('M', ingot)
                .define('S',rod)
                .pattern("MMM")
                .pattern(" S ")
                .pattern(" S ")
                .group(materialType+"pickaxe").unlockedBy(getHasName(ingot), has(ingot))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, axe)
                .define('M', ingot)
                .define('S',rod)
                .pattern("MM ")
                .pattern("MS ")
                .pattern(" S ").unlockedBy(getHasName(ingot), has(ingot))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, hoe)
                .define('M', ingot)
                .define('S', rod)
                .pattern("MM ")
                .pattern(" S ")
                .pattern(" S ").unlockedBy(getHasName(ingot), has(ingot))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, shovel)
                .define('M', ingot)
                .define('S', rod)
                .pattern(" M ")
                .pattern(" S ")
                .pattern(" S ").unlockedBy(getHasName(ingot), has(ingot))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, sword)
                .define('M', ingot)
                .define('S', rod)
                .pattern(" M ")
                .pattern(" M ")
                .pattern(" S ").unlockedBy(getHasName(ingot), has(ingot))
                .save(pFinishedRecipeConsumer);
    }

    protected static void armorRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer, String materialType){

        ItemLike plate = ForgeRegistries.ITEMS.getValue(ResourceLocation.tryParse(DruidicQuestMod.MODID+":"+materialType+"_plate"));
        ItemLike helmet = ForgeRegistries.ITEMS.getValue(ResourceLocation.tryParse(DruidicQuestMod.MODID+":"+materialType+"_helmet"));
        ItemLike chestplate = ForgeRegistries.ITEMS.getValue(ResourceLocation.tryParse(DruidicQuestMod.MODID+":"+materialType+"_chestplate"));
        ItemLike leggings = ForgeRegistries.ITEMS.getValue(ResourceLocation.tryParse(DruidicQuestMod.MODID+":"+materialType+"_leggings"));
        ItemLike boots = ForgeRegistries.ITEMS.getValue(ResourceLocation.tryParse(DruidicQuestMod.MODID+":"+materialType+"_boots"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, helmet)
                .define('M', plate)
                .pattern("MMM")
                .pattern("M M")
                .group(materialType+"helmet").unlockedBy(getHasName(plate), has(plate))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, chestplate)
                .define('M', plate)
                .pattern("M M")
                .pattern("MMM")
                .pattern("MMM")
                .group(materialType+"chestplate").unlockedBy(getHasName(plate), has(plate))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, leggings)
                .define('M', plate)
                .pattern("MMM")
                .pattern("M M")
                .pattern("M M")
                .group(materialType+"leggings").unlockedBy(getHasName(plate), has(plate))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, boots)
                .define('M', plate)
                .pattern("M M")
                .pattern("M M")
                .group(materialType+"boots").unlockedBy(getHasName(plate), has(plate))
                .save(pFinishedRecipeConsumer);
    }
}

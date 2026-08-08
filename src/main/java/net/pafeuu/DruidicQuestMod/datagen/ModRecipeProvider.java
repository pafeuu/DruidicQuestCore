package net.pafeuu.DruidicQuestMod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.pafeuu.DruidicQuestMod.DruidicQuestMod;
import net.pafeuu.DruidicQuestMod.registries.BlockRegistry;

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
}

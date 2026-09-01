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
import net.minecraftforge.registries.ForgeRegistries;
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

        String [] materialTypes = {"steel","platinum","uranium"};

        for(String material : materialTypes)
        {

            addMaterialIngredientTag("nugget",material);
            addMaterialIngredientTag("ingot",material);
            storageBlocksTag(material);
            addMaterialIngredientTag("plate",material);
            addMaterialIngredientTag("rod",material);
            addMaterialIngredientTag("gear",material);
        }

        storageBlocksTag("raw_uranium");
        storageBlocksTag("raw_platinum");

        /*tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge","stripped_logs")))
                .add(Item.byBlock(BlockRegistry.STRIPPED_TREATED_LOG.get()));

        tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge","stripped_wood")))
                .add(Item.byBlock(BlockRegistry.STRIPPED_TREATED_WOOD.get()));

        tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge","treated_wood")))
                .add(Item.byBlock(BlockRegistry.TREATED_PLANKS.get()));
        tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge","treated_wood_slabs")))
                .add(Item.byBlock(BlockRegistry.TREATED_PLANKS.get()));

        tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge","rods/treated_wood")))
                .add(ItemRegistry.TREATED_STICK.get());*/

        tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge","tools/hammers")))
                .add(ItemRegistry.ARCANIST_HAMMER.get());

        //copy(BlockTags.LOGS,ItemTags.LOGS);
        //copy(BlockTags.PLANKS,ItemTags.PLANKS);
    }

    protected void addMaterialIngredientTag(String ingredientType, String materialType){
        Item id = ForgeRegistries.ITEMS.getValue(ResourceLocation.fromNamespaceAndPath(DruidicQuestMod.MODID,materialType+"_"+ingredientType));
        tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", ingredientType+"s/"+materialType))).add(id);
        tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", ingredientType+"s"))).add(id);
    }

    protected void storageBlocksTag(String materialType){

        tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "storage_blocks")))
                .add(Item.byBlock(ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(DruidicQuestMod.MODID,materialType+"_block"))));

        tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "storage_blocks/"+materialType)))
                .add(Item.byBlock(ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(DruidicQuestMod.MODID,materialType+"_block"))));
    }

}

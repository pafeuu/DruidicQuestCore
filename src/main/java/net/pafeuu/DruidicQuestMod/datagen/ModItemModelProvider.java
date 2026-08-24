package net.pafeuu.DruidicQuestMod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.pafeuu.DruidicQuestMod.DruidicQuestMod;
import net.pafeuu.DruidicQuestMod.registries.ItemRegistry;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DruidicQuestMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ItemRegistry.NATURE_ESSENCE);
        simpleItem(ItemRegistry.TREATED_STICK);
        simpleItem(ItemRegistry.STEEL_INGOT);
        simpleItem(ItemRegistry.STEEL_NUGGET);
        simpleItem(ItemRegistry.STEEL_GEAR);
        simpleItem(ItemRegistry.STEEL_ROD);
        simpleItem(ItemRegistry.STEEL_HELMET);
        simpleItem(ItemRegistry.STEEL_CHESTPLATE);
        simpleItem(ItemRegistry.STEEL_LEGGINGS);
        simpleItem(ItemRegistry.STEEL_BOOTS);
        simpleItem(ItemRegistry.PLATINUM_INGOT);
        simpleItem(ItemRegistry.PLATINUM_NUGGET);
        simpleItem(ItemRegistry.PLATINUM_GEAR);
        simpleItem(ItemRegistry.PLATINUM_ROD);
        simpleItem(ItemRegistry.RAW_PLATINUM);
        simpleItem(ItemRegistry.URANIUM_INGOT);
        simpleItem(ItemRegistry.URANIUM_NUGGET);
        simpleItem(ItemRegistry.URANIUM_GEAR);
        simpleItem(ItemRegistry.URANIUM_ROD);
        simpleItem(ItemRegistry.RAW_URANIUM);
        simpleItem(ItemRegistry.EBONY_FLOWER_STAFF);
        simpleItem(ItemRegistry.COBALT_FLOWER_STAFF);
        simpleItem(ItemRegistry.CRIMSON_FLOWER_STAFF);
        simpleItem(ItemRegistry.LUSH_FLOWER_STAFF);
        simpleItem(ItemRegistry.PURE_FLOWER_STAFF);
        simpleItem(ItemRegistry.GOLDEN_FLOWER_STAFF);

        countedItem(ItemRegistry.STEEL_PLATE);
        countedItem(ItemRegistry.URANIUM_PLATE);
        countedItem(ItemRegistry.PLATINUM_PLATE);

        handheldItem(ItemRegistry.ARCANIST_HAMMER);
        handheldItem(ItemRegistry.STEEL_PICKAXE);
        handheldItem(ItemRegistry.STEEL_AXE);
        handheldItem(ItemRegistry.STEEL_SHOVEL);
        handheldItem(ItemRegistry.STEEL_HOE);
        handheldItem(ItemRegistry.STEEL_SWORD);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item)  {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.tryParse("item/generated"))
                .texture("layer0", ResourceLocation.tryBuild(DruidicQuestMod.MODID,"item/" + item.getId().getPath()));

    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item)  {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.tryParse("item/handheld"))
                .texture("layer0", ResourceLocation.tryBuild(DruidicQuestMod.MODID,"item/" + item.getId().getPath()));

    }

    private void countedItemVariant(String variantName) {
        withExistingParent(variantName, ResourceLocation.tryParse("item/generated"))
                .texture("layer0", modLoc("item/" + variantName));
    }

    private ItemModelBuilder countedItem(RegistryObject<Item> item)  {

        String path = item.getId().getPath();

        countedItemVariant(path + "_a");
        countedItemVariant(path + "_b");
        countedItemVariant(path + "_c");
        countedItemVariant(path + "_d");

        return withExistingParent(item.getId().getPath(),
                ResourceLocation.tryParse("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(DruidicQuestMod.MODID,"item/" + item.getId().getPath()+"_a"))
                .override()
                .predicate(ResourceLocation.tryParse("count"),0.00f)
                .model(getExistingFile(modLoc("item/"+item.getId().getPath()+"_a")))
                .end()
                .override()
                .predicate(ResourceLocation.tryParse("count"),0.25f)
                .model(getExistingFile(modLoc("item/"+item.getId().getPath()+"_b")))
                .end()
                .override()
                .predicate(ResourceLocation.tryParse("count"),0.50f)
                .model(getExistingFile(modLoc("item/"+item.getId().getPath()+"_c")))
                .end()
                .override()
                .predicate(ResourceLocation.tryParse("count"),1.00f)
                .model(getExistingFile(modLoc("item/"+item.getId().getPath()+"_d")))
                .end();
    }
}

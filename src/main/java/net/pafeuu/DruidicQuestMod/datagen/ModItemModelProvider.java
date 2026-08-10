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
        simpleItem(ItemRegistry.STEEL_INGOT);
        simpleItem(ItemRegistry.STEEL_NUGGET);
        simpleItem(ItemRegistry.STEEL_GEAR);
        simpleItem(ItemRegistry.STEEL_ROD);
        countedItem(ItemRegistry.STEEL_PLATE);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item)  {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.tryParse("item/generated"))
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

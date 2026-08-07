package net.pafeuu.DruidicQuestMod.registries;

import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pafeuu.DruidicQuestMod.DruidicQuestMod;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DruidicQuestMod.MODID);

    public static final RegistryObject<Item> NATURE_ESSENCE = ITEMS.register("nature_essence",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PHOENIX_BRUSH = ITEMS.register("phoenix_brush",
            ()-> new BrushItem(new Item.Properties().defaultDurability(2048)));

    public static final RegistryObject<Item> STEEL_BRUSH = ITEMS.register("steel_brush",
            ()-> new BrushItem(new Item.Properties().defaultDurability(-1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

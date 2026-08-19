package net.pafeuu.DruidicQuestMod.registries;

import cofh.core.common.item.CountedItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pafeuu.DruidicQuestMod.DruidicQuestMod;
import net.pafeuu.DruidicQuestMod.registries.tiers.ToolTierRegistry;
import net.pafeuu.DruidicQuestMod.registries.tiers.WeaponTierRegistry;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DruidicQuestMod.MODID);

    public static final RegistryObject<Item> NATURE_ESSENCE = ITEMS.register("nature_essence",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_URANIUM = ITEMS.register("raw_uranium",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> URANIUM_NUGGET = ITEMS.register("uranium_nugget",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> URANIUM_GEAR = ITEMS.register("uranium_gear",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> URANIUM_ROD = ITEMS.register("uranium_rod",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> URANIUM_PLATE = ITEMS.register("uranium_plate",
            ()-> new CountedItem(new Item.Properties()));

    public static final RegistryObject<Item> RAW_PLATINUM= ITEMS.register("raw_platinum",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PLATINUM_NUGGET = ITEMS.register("platinum_nugget",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PLATINUM_GEAR = ITEMS.register("platinum_gear",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PLATINUM_ROD = ITEMS.register("platinum_rod",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PLATINUM_PLATE = ITEMS.register("platinum_plate",
            ()-> new CountedItem(new Item.Properties()));

    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STEEL_GEAR = ITEMS.register("steel_gear",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STEEL_ROD = ITEMS.register("steel_rod",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STEEL_PLATE = ITEMS.register("steel_plate",
            ()-> new CountedItem(new Item.Properties()));

    public static final RegistryObject<Item> PHOENIX_BRUSH = ITEMS.register("phoenix_brush",
            ()-> new BrushItem(new Item.Properties().defaultDurability(2048)));

    public static final RegistryObject<Item> STEEL_BRUSH = ITEMS.register("steel_brush",
            ()-> new BrushItem(new Item.Properties().defaultDurability(-1)));

    public static final RegistryObject<Item> STEEL_PICKAXE = ITEMS.register("steel_pickaxe",
            ()-> new PickaxeItem(ToolTierRegistry.STEEL,3,-2.8f, new Item.Properties()));

    public static final RegistryObject<Item> STEEL_AXE = ITEMS.register("steel_axe",
            ()-> new AxeItem(ToolTierRegistry.STEEL,8,-3.1f, new Item.Properties()));

    public static final RegistryObject<Item> STEEL_SHOVEL = ITEMS.register("steel_shovel",
            ()-> new ShovelItem(ToolTierRegistry.STEEL,3.5f,-3.0f, new Item.Properties()));

    public static final RegistryObject<Item> STEEL_HOE = ITEMS.register("steel_hoe",
            ()-> new HoeItem(ToolTierRegistry.STEEL,0,-1.0f, new Item.Properties()));

    public static final RegistryObject<Item> STEEL_SWORD = ITEMS.register("steel_sword",
            ()-> new SwordItem(ToolTierRegistry.STEEL, 6,-2.4f, new Item.Properties()));


    public static final RegistryObject<Item> CRIMSON_FLOWER_STAFF = ITEMS.register("crimson_flower_staff",
            ()-> new MagicSwordItem(WeaponTierRegistry.FLOWER_STAFF, new Item.Properties(),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.FIREBOLT_SPELL,1))));

    public static final RegistryObject<Item> PURE_FLOWER_STAFF = ITEMS.register("pure_flower_staff",
            ()-> new MagicSwordItem(WeaponTierRegistry.FLOWER_STAFF, new Item.Properties(),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.BALL_LIGHTNING_SPELL,1))));

    public static final RegistryObject<Item> GOLDEN_FLOWER_STAFF = ITEMS.register("golden_flower_staff",
            ()-> new MagicSwordItem(WeaponTierRegistry.FLOWER_STAFF, new Item.Properties(),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.FIRECRACKER_SPELL,1))));

    public static final RegistryObject<Item> LUSH_FLOWER_STAFF = ITEMS.register("lush_flower_staff",
            ()-> new MagicSwordItem(WeaponTierRegistry.FLOWER_STAFF, new Item.Properties(),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(net.pafeuu.DruidicQuestMod.registries.SpellRegistry.NATURE_MISSILE,1))));

    public static final RegistryObject<Item> COBALT_FLOWER_STAFF = ITEMS.register("cobalt_flower_staff",
            ()-> new MagicSwordItem(WeaponTierRegistry.FLOWER_STAFF, new Item.Properties(),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.ICICLE_SPELL,1))));

    public static final RegistryObject<Item> EBONY_FLOWER_STAFF = ITEMS.register("ebony_flower_staff",
            ()-> new MagicSwordItem(WeaponTierRegistry.FLOWER_STAFF, new Item.Properties(),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.MAGIC_MISSILE_SPELL,1))));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

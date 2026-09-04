package net.pafeuu.DruidicQuestMod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.pafeuu.DruidicQuestMod.config.CommonConfig;
import net.pafeuu.DruidicQuestMod.registries.*;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DruidicQuestMod.MODID)
public class DruidicQuestMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "druidic_quest_core";
    // Directly reference a logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public DruidicQuestMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        CreativeTabRegistry.register(modEventBus);
        ItemRegistry.register(modEventBus);
        BlockRegistry.register(modEventBus);
        EntityRegistry.register(modEventBus);
        SpellRegistry.register(modEventBus);


        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::registerDispenserBehaviors);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        context.registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC, "druidic_quest_core/common_config.toml"); //yes I made a separate config
    }

    private void registerDispenserBehaviors(final FMLCommonSetupEvent event)
    {
        //event.enqueueWork(DispenserBehaviourRegistry::registerDispenserBehaviour);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ItemRegistry.NATURE_ESSENCE);
            event.accept(ItemRegistry.ARCANE_BRICK);
            event.accept(ItemRegistry.ARCANE_CLAY_BLEND);
            //event.accept(ItemRegistry.TREATED_STICK);
            event.accept(ItemRegistry.STEEL_INGOT);
            event.accept(ItemRegistry.STEEL_GEAR);
            event.accept(ItemRegistry.STEEL_NUGGET);
            event.accept(ItemRegistry.STEEL_ROD);
            event.accept(ItemRegistry.STEEL_PLATE);
            event.accept(ItemRegistry.RAW_PLATINUM);
            event.accept(ItemRegistry.PLATINUM_INGOT);
            event.accept(ItemRegistry.PLATINUM_GEAR);
            event.accept(ItemRegistry.PLATINUM_NUGGET);
            event.accept(ItemRegistry.PLATINUM_ROD);
            event.accept(ItemRegistry.PLATINUM_PLATE);
            event.accept(ItemRegistry.RAW_URANIUM);
            event.accept(ItemRegistry.URANIUM_INGOT);
            event.accept(ItemRegistry.URANIUM_GEAR);
            event.accept(ItemRegistry.URANIUM_NUGGET);
            event.accept(ItemRegistry.URANIUM_ROD);
            event.accept(ItemRegistry.URANIUM_PLATE);
        }

        if(event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(BlockRegistry.SUSPICIOUS_SNOW);
            event.accept(BlockRegistry.SUSPICIOUS_MUD);
            event.accept(BlockRegistry.SUSPICIOUS_CLAY);
        }

        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ItemRegistry.ARCANIST_HAMMER);
            event.accept(ItemRegistry.PHOENIX_BRUSH);
            event.accept(ItemRegistry.STEEL_BRUSH);
            event.accept(ItemRegistry.STEEL_SHOVEL);
            event.accept(ItemRegistry.STEEL_PICKAXE);
            event.accept(ItemRegistry.STEEL_HOE);
            event.accept(ItemRegistry.STEEL_AXE);
            event.accept(ItemRegistry.PLATINUM_SHOVEL);
            event.accept(ItemRegistry.PLATINUM_PICKAXE);
            event.accept(ItemRegistry.PLATINUM_HOE);
            event.accept(ItemRegistry.PLATINUM_AXE);
        }

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(BlockRegistry.IVY_BLOCK);
            event.accept(BlockRegistry.GOLD_LEAF_BLOCK);
            event.accept(BlockRegistry.STEEL_BLOCK);
            event.accept(BlockRegistry.PLATINUM_BLOCK);
            event.accept(BlockRegistry.RAW_PLATINUM_BLOCK);
            event.accept(BlockRegistry.URANIUM_BLOCK);
            event.accept(BlockRegistry.RAW_URANIUM_BLOCK);
            event.accept(BlockRegistry.STURDY_DEEPSLATE);
            event.accept(BlockRegistry.STURDY_DEEPSLATE_SLAB);
            event.accept(BlockRegistry.PRIMITIVE_MACHINE);
            event.accept(BlockRegistry.ALLOY_BRICKS);
            event.accept(BlockRegistry.ARCANE_BRICKS);
            event.accept(BlockRegistry.STACKED_PLANKS);
            event.accept(BlockRegistry.PACKED_PLANKS);
            event.accept(BlockRegistry.POLISHED_PLANKS);
            /*event.accept(BlockRegistry.TREATED_PLANKS);
            event.accept(BlockRegistry.TREATED_SLAB);
            event.accept(BlockRegistry.TREATED_STAIRS);
            event.accept(BlockRegistry.TREATED_DOOR);
            event.accept(BlockRegistry.TREATED_TRAPDOOR);
            event.accept(BlockRegistry.TREATED_FENCE);
            event.accept(BlockRegistry.TREATED_FENCE_GATE);
            event.accept(BlockRegistry.TREATED_LOG);
            event.accept(BlockRegistry.STRIPPED_TREATED_LOG);
            event.accept(BlockRegistry.TREATED_WOOD);
            event.accept(BlockRegistry.STRIPPED_TREATED_WOOD);*/
        }

        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ItemRegistry.LUSH_FLOWER_STAFF);
            event.accept(ItemRegistry.PURE_FLOWER_STAFF);
            event.accept(ItemRegistry.COBALT_FLOWER_STAFF);
            event.accept(ItemRegistry.CRIMSON_FLOWER_STAFF);
            event.accept(ItemRegistry.EBONY_FLOWER_STAFF);
            event.accept(ItemRegistry.GOLDEN_FLOWER_STAFF);
            event.accept(ItemRegistry.IMPROVED_LUSH_FLOWER_STAFF);
            event.accept(ItemRegistry.IMPROVED_PURE_FLOWER_STAFF);
            event.accept(ItemRegistry.IMPROVED_COBALT_FLOWER_STAFF);
            event.accept(ItemRegistry.IMPROVED_CRIMSON_FLOWER_STAFF);
            event.accept(ItemRegistry.IMPROVED_EBONY_FLOWER_STAFF);
            event.accept(ItemRegistry.IMPROVED_GOLDEN_FLOWER_STAFF);
            event.accept(ItemRegistry.PLATINUM_AXE);
            event.accept(ItemRegistry.PLATINUM_SWORD);
            event.accept(ItemRegistry.STEEL_AXE);
            event.accept(ItemRegistry.STEEL_SWORD);
            event.accept(ItemRegistry.STEEL_HELMET);
            event.accept(ItemRegistry.STEEL_CHESTPLATE);
            event.accept(ItemRegistry.STEEL_LEGGINGS);
            event.accept(ItemRegistry.STEEL_BOOTS);
        }

        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(BlockRegistry.PLATINUM_ORE);
            event.accept(BlockRegistry.URANIUM_ORE);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            event.enqueueWork(() -> {
                ItemProperties.register(ItemRegistry.PRIMITIVE_SHIELD.get(),
                        ResourceLocation.tryParse("blocking"),
                        (stack, level, entity, seed) ->
                                entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F);
            });
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}

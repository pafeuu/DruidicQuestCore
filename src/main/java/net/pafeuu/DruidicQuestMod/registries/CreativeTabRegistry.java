package net.pafeuu.DruidicQuestMod.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.pafeuu.DruidicQuestMod.DruidicQuestMod;

import java.util.function.Supplier;

public class CreativeTabRegistry {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DruidicQuestMod.MODID);

    public static final RegistryObject<CreativeModeTab> DRUIDIC_QUEST_TAB = CREATIVE_MODE_TAB.register("druidic_quest_tab",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ItemRegistry.NATURE_ESSENCE.get()))
                    .title(Component.translatable("creativetab.druidic_quest"))
                    .displayItems((pParametersm,pOutput)->{
                        pOutput.accept(ItemRegistry.ARCANIST_HAMMER.get());
                        pOutput.accept(ItemRegistry.NATURE_ESSENCE.get());
                        pOutput.accept(ItemRegistry.ARCANE_BRICK.get());
                        pOutput.accept(ItemRegistry.ARCANE_CLAY_BLEND.get());
                        pOutput.accept(ItemRegistry.LIVINGROCK_PLATE.get());
                        pOutput.accept(ItemRegistry.LIVINGROCK_GEAR.get());
                        pOutput.accept(ItemRegistry.LIVINGWOOD_PLATE.get());
                        pOutput.accept(ItemRegistry.LIVINGWOOD_GEAR.get());
                        //pOutput.accept(ItemRegistry.TREATED_STICK.get());
                        pOutput.accept(ItemRegistry.PHOENIX_BRUSH.get());
                        pOutput.accept(ItemRegistry.STEEL_BRUSH.get());
                        pOutput.accept(ItemRegistry.STEEL_INGOT.get());
                        pOutput.accept(ItemRegistry.STEEL_NUGGET.get());
                        pOutput.accept(ItemRegistry.STEEL_GEAR.get());
                        pOutput.accept(ItemRegistry.STEEL_ROD.get());
                        pOutput.accept(ItemRegistry.STEEL_PLATE.get());
                        pOutput.accept(ItemRegistry.RAW_URANIUM.get());
                        pOutput.accept(ItemRegistry.URANIUM_INGOT.get());
                        pOutput.accept(ItemRegistry.URANIUM_NUGGET.get());
                        pOutput.accept(ItemRegistry.URANIUM_GEAR.get());
                        pOutput.accept(ItemRegistry.URANIUM_ROD.get());
                        pOutput.accept(ItemRegistry.URANIUM_PLATE.get());
                        pOutput.accept(ItemRegistry.RAW_PLATINUM.get());
                        pOutput.accept(ItemRegistry.PLATINUM_INGOT.get());
                        pOutput.accept(ItemRegistry.PLATINUM_NUGGET.get());
                        pOutput.accept(ItemRegistry.PLATINUM_GEAR.get());
                        pOutput.accept(ItemRegistry.PLATINUM_ROD.get());
                        pOutput.accept(ItemRegistry.PLATINUM_PLATE.get());
                        pOutput.accept(ItemRegistry.PLATINUM_PICKAXE.get());
                        pOutput.accept(ItemRegistry.PLATINUM_AXE.get());
                        pOutput.accept(ItemRegistry.PLATINUM_SHOVEL.get());
                        pOutput.accept(ItemRegistry.PLATINUM_HOE.get());
                        pOutput.accept(ItemRegistry.PLATINUM_SWORD.get());
                        pOutput.accept(ItemRegistry.STEEL_PICKAXE.get());
                        pOutput.accept(ItemRegistry.STEEL_AXE.get());
                        pOutput.accept(ItemRegistry.STEEL_SHOVEL.get());
                        pOutput.accept(ItemRegistry.STEEL_HOE.get());
                        pOutput.accept(ItemRegistry.STEEL_SWORD.get());
                        pOutput.accept(ItemRegistry.STEEL_HELMET.get());
                        pOutput.accept(ItemRegistry.STEEL_CHESTPLATE.get());
                        pOutput.accept(ItemRegistry.STEEL_LEGGINGS.get());
                        pOutput.accept(ItemRegistry.STEEL_BOOTS.get());
                        pOutput.accept(ItemRegistry.COBALT_FLOWER_STAFF.get());
                        pOutput.accept(ItemRegistry.EBONY_FLOWER_STAFF.get());
                        pOutput.accept(ItemRegistry.CRIMSON_FLOWER_STAFF.get());
                        pOutput.accept(ItemRegistry.LUSH_FLOWER_STAFF.get());
                        pOutput.accept(ItemRegistry.GOLDEN_FLOWER_STAFF.get());
                        pOutput.accept(ItemRegistry.PURE_FLOWER_STAFF.get());
                        pOutput.accept(ItemRegistry.PRIMITIVE_SHIELD.get());

                        pOutput.accept(BlockRegistry.PRIMITIVE_MACHINE.get());
                        pOutput.accept(BlockRegistry.ALLOY_BRICKS.get());
                        pOutput.accept(BlockRegistry.ARCANE_BRICKS.get());
                        pOutput.accept(BlockRegistry.IVY_BLOCK.get());
                        pOutput.accept(BlockRegistry.STURDY_DEEPSLATE.get());
                        pOutput.accept(BlockRegistry.STURDY_DEEPSLATE_SLAB.get());
                        pOutput.accept(BlockRegistry.GOLD_LEAF_BLOCK.get());
                        pOutput.accept(BlockRegistry.SUSPICIOUS_SNOW.get());
                        pOutput.accept(BlockRegistry.SUSPICIOUS_CLAY.get());
                        pOutput.accept(BlockRegistry.SUSPICIOUS_MUD.get());
                        pOutput.accept(BlockRegistry.ROTTEN_FLESH_BLOCK.get());
                        pOutput.accept(BlockRegistry.STACKED_PLANKS.get());
                        pOutput.accept(BlockRegistry.PACKED_PLANKS.get());
                        pOutput.accept(BlockRegistry.POLISHED_PLANKS.get());
                        pOutput.accept(BlockRegistry.STEEL_BLOCK.get());
                        pOutput.accept(BlockRegistry.PLATINUM_BLOCK.get());
                        pOutput.accept(BlockRegistry.RAW_PLATINUM_BLOCK.get());
                        pOutput.accept(BlockRegistry.URANIUM_BLOCK.get());
                        pOutput.accept(BlockRegistry.RAW_URANIUM_BLOCK.get());
                        pOutput.accept(BlockRegistry.BIG_SOURCE_JAR.get());
                        pOutput.accept(BlockRegistry.HUGE_SOURCE_JAR.get());
                        /*pOutput.accept(BlockRegistry.TREATED_LOG.get());
                        pOutput.accept(BlockRegistry.STRIPPED_TREATED_LOG.get());
                        pOutput.accept(BlockRegistry.TREATED_PLANKS.get());
                        pOutput.accept(BlockRegistry.TREATED_SLAB.get());
                        pOutput.accept(BlockRegistry.TREATED_STAIRS.get());
                        pOutput.accept(BlockRegistry.TREATED_FENCE.get());
                        pOutput.accept(BlockRegistry.TREATED_FENCE_GATE.get());
                        pOutput.accept(BlockRegistry.TREATED_DOOR.get());
                        pOutput.accept(BlockRegistry.TREATED_TRAPDOOR.get());
                        pOutput.accept(BlockRegistry.TREATED_WOOD.get());
                        pOutput.accept(BlockRegistry.STRIPPED_TREATED_WOOD.get());*/
                        pOutput.accept(BlockRegistry.PLATINUM_ORE.get());
                        pOutput.accept(BlockRegistry.URANIUM_ORE.get());
                    })
            .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {

        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ItemRegistry.NATURE_ESSENCE);
            //event.accept(ItemRegistry.TREATED_STICK);
            event.accept(ItemRegistry.LIVINGROCK_PLATE);
            event.accept(ItemRegistry.LIVINGROCK_GEAR);
            event.accept(ItemRegistry.LIVINGWOOD_PLATE);
            event.accept(ItemRegistry.LIVINGWOOD_GEAR);
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
            event.accept((Supplier<? extends ItemLike>) BlockRegistry.BIG_SOURCE_JAR);
            event.accept((Supplier<? extends ItemLike>) BlockRegistry.HUGE_SOURCE_JAR);
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
}

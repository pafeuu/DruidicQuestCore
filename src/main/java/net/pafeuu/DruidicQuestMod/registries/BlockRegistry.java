package net.pafeuu.DruidicQuestMod.registries;

import cofh.lib.common.block.OreBlockCoFH;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pafeuu.DruidicQuestMod.DruidicQuestMod;
//import net.pafeuu.DruidicQuestMod.block.customLogBlock;

import java.util.function.Supplier;

public class BlockRegistry {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DruidicQuestMod.MODID);

    public static final RegistryObject<Block> PRIMITIVE_MACHINE = registerBlock("primitive_machine",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> ALLOY_BRICKS = registerBlock("alloy_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> GOLD_LEAF_BLOCK = registerBlock("gold_leaf_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK)));

    public static final RegistryObject<Block> IVY_BLOCK = registerBlock("ivy_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK)));

    public static final RegistryObject<Block> POLISHED_PLANKS = registerBlock("polished_planks",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));

    /*public static final RegistryObject<Block> TREATED_PLANKS = registerBlock("treated_planks",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));

    public static final RegistryObject<Block> TREATED_SLAB = registerBlock("treated_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));

    public static final RegistryObject<Block> TREATED_FENCE = registerBlock("treated_fence",
            ()-> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));

    public static final RegistryObject<Block> TREATED_FENCE_GATE = registerBlock("treated_fence_gate",
            ()-> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS),SoundEvents.FENCE_GATE_OPEN,SoundEvents.FENCE_GATE_CLOSE));

    public static final RegistryObject<Block> TREATED_DOOR = registerBlock("treated_door",
            ()-> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS), BlockSetType.ACACIA));

    public static final RegistryObject<Block> TREATED_TRAPDOOR = registerBlock("treated_trapdoor",
            ()-> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS), BlockSetType.ACACIA));

    public static final RegistryObject<Block> TREATED_STAIRS = registerBlock("treated_stairs",
            ()-> new StairBlock(()-> BlockRegistry.TREATED_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));

    public static final RegistryObject<Block> TREATED_LOG = registerBlock("treated_log",
            ()-> new customLogBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));

    public static final RegistryObject<Block> STRIPPED_TREATED_LOG = registerBlock("stripped_treated_log",
            ()-> new customLogBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));

    public static final RegistryObject<Block> TREATED_WOOD = registerBlock("treated_wood",
            ()-> new customLogBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));

    public static final RegistryObject<Block> STRIPPED_TREATED_WOOD = registerBlock("stripped_treated_wood",
            ()-> new customLogBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));*/

    public static final RegistryObject<Block> PACKED_PLANKS = registerBlock("packed_planks",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));

    public static final RegistryObject<Block> STACKED_PLANKS = registerBlock("stacked_planks",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));

    public static final RegistryObject<Block> ROTTEN_FLESH_BLOCK = registerBlock("rotten_flesh_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK).destroyTime(1.0F).sound(SoundType.HONEY_BLOCK)));

    public static final RegistryObject<Block> STURDY_DEEPSLATE = registerBlock("sturdy_deepslate",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).pushReaction(PushReaction.BLOCK)));

    public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> URANIUM_BLOCK = registerBlock("uranium_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> RAW_URANIUM_BLOCK = registerBlock("raw_uranium_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));

    public static final RegistryObject<Block> PLATINUM_BLOCK = registerBlock("platinum_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> RAW_PLATINUM_BLOCK = registerBlock("raw_platinum_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));

    public static final RegistryObject<Block> STURDY_DEEPSLATE_SLAB = registerBlock("sturdy_deepslate_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).pushReaction(PushReaction.BLOCK)));

    public static final RegistryObject<Block> URANIUM_ORE = registerBlock("uranium_ore",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)));

    public static final RegistryObject<Block> PLATINUM_ORE = registerBlock("platinum_ore",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE)));

    public static final RegistryObject<Block> SUSPICIOUS_SNOW = registerBlock("suspicious_snow",
            ()-> new BrushableBlock(Blocks.SNOW_BLOCK,BlockBehaviour.Properties.copy(Blocks.SUSPICIOUS_SAND).noLootTable(), SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED));

    public static final RegistryObject<Block> SUSPICIOUS_CLAY = registerBlock("suspicious_clay",
            ()-> new BrushableBlock(Blocks.CLAY,BlockBehaviour.Properties.copy(Blocks.SUSPICIOUS_SAND).noLootTable(), SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED));

    public static final RegistryObject<Block> SUSPICIOUS_MUD = registerBlock("suspicious_mud",
            ()-> new BrushableBlock(Blocks.MUD,BlockBehaviour.Properties.copy(Blocks.SUSPICIOUS_SAND).noLootTable(), SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ItemRegistry.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

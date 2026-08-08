package net.pafeuu.DruidicQuestMod.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.pafeuu.DruidicQuestMod.DruidicQuestMod;

public class CreativeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DruidicQuestMod.MODID);

    public static final RegistryObject<CreativeModeTab> DRUIDIC_QUEST_TAB = CREATIVE_MODE_TAB.register("druidic_quest_tab",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ItemRegistry.NATURE_ESSENCE.get()))
                    .title(Component.translatable("creativetab.druidic_quest"))
                    .displayItems((pParametersm,pOutput)->{
                        pOutput.accept(ItemRegistry.NATURE_ESSENCE.get());
                        pOutput.accept(ItemRegistry.PHOENIX_BRUSH.get());
                        pOutput.accept(ItemRegistry.STEEL_BRUSH.get());
                        pOutput.accept(BlockRegistry.PRIMITIVE_MACHINE.get());
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
                    })
            .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}

package net.pafeuu.DruidicQuestMod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.pafeuu.DruidicQuestMod.config.CommonConfig;
import net.pafeuu.DruidicQuestMod.registries.*;
import org.slf4j.Logger;

import java.util.function.Supplier;

@Mod(DruidicQuestMod.MODID)
public class DruidicQuestMod
{
    public static final String MODID = "druidic_quest_core";
    private static final Logger LOGGER = LogUtils.getLogger();

    public DruidicQuestMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        CreativeTabRegistry.register(modEventBus);
        ItemRegistry.register(modEventBus);
        BlockRegistry.register(modEventBus);
        EntityRegistry.register(modEventBus);
        SpellRegistry.register(modEventBus);

        modEventBus.addListener(this::registerDispenserBehaviors);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(CreativeTabRegistry::addCreative);

        context.registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC,  DruidicQuestMod.MODID + "/common_config.toml");
    }

    //pafeu why is this here
    private void registerDispenserBehaviors(final FMLCommonSetupEvent event) {
        //event.enqueueWork(DispenserBehaviourRegistry::registerDispenserBehaviour);
    }
}

package net.pafeuu.DruidicQuestMod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.pafeuu.DruidicQuestMod.config.CommonConfig;
import net.pafeuu.DruidicQuestMod.registries.*;
import org.slf4j.Logger;

import static com.mojang.logging.LogUtils.getLogger;

@Mod(DruidicQuestMod.MODID)
public class DruidicQuestMod
{
    public static final String MODID = "druidic_quest_core";
    public static final Logger DQ_LOGGER = getLogger();

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

package net.pafeuu.DruidicQuestMod.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.pafeuu.DruidicQuestMod.DruidicQuestMod;

@Mod.EventBusSubscriber(modid = DruidicQuestMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Luminizer
    public static final ForgeConfigSpec.DoubleValue LUMINIZER_ITEM_SPEED;

    static {
        BUILDER.comment("Config for Luminizer from Botania").push("Luminizer");
        LUMINIZER_ITEM_SPEED = BUILDER
                .comment("Speed of items ejected by luminizer in blocks per tick. (Default: 0.5)")
                .defineInRange("luminizerItemSpeed", 0.5D, 0D, Double.MAX_VALUE);
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        if (event.getConfig().getSpec() != SPEC) return;

    }
}
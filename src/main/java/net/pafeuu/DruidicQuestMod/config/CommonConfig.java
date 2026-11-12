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
    
    //Sophisticated Item Actions
    public static final ForgeConfigSpec.BooleanValue ENABLE_SOPH_ACTION_GATING_RESTOCK;
    public static final ForgeConfigSpec.BooleanValue ENABLE_SOPH_ACTION_GATING_DEPOSIT;
    public static final ForgeConfigSpec.ConfigValue<String> ADV_ID_FOR_SOPH_GATE_RESTOCK;
    public static final ForgeConfigSpec.ConfigValue<String> ADV_ID_FOR_SOPH_GATE_DEPOSIT;

    static {
        BUILDER.comment("Config for Sophisticated Item Actions").push("SophisticatedItemActions");
        ENABLE_SOPH_ACTION_GATING_RESTOCK = BUILDER
                .comment("Whether to make Sophisticated Item Actions (Restock) be gated behind an advancement. (Default: false)")
                .define("enableSophActionGating", false);
        ADV_ID_FOR_SOPH_GATE_RESTOCK = BUILDER
                .comment("The advancement id for the advancement-gating for Sophisticated Item Actions' restock. (Ex: \"minecraft:adventure/kill_a_mob\"")
                .define("advIdForSophAction", "");
        ENABLE_SOPH_ACTION_GATING_DEPOSIT = BUILDER
                .comment("Whether to make Sophisticated Item Actions (Deposit) be gated behind an advancement. (Default: false)")
                .define("enableSophActionGating", false);
        ADV_ID_FOR_SOPH_GATE_DEPOSIT = BUILDER
                .comment("The advancement id for the advancement-gating for Sophisticated Item Actions' deposit. (Ex: \"minecraft:adventure/kill_a_mob\"")
                .define("advIdForSophAction", "");
        BUILDER.pop();


        SPEC = BUILDER.build();
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        if (event.getConfig().getSpec() != SPEC) return;

    }
}
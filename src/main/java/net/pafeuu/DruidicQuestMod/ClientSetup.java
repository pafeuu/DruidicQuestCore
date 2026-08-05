package net.pafeuu.DruidicQuestMod;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.pafeuu.DruidicQuestMod.entity.spells.nature_missile.NatureMissileRenderer;
import net.pafeuu.DruidicQuestMod.registries.EntityRegistry;

@Mod.EventBusSubscriber(modid = DruidicQuestMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityRegistry.NATURE_MISSILE_PROJECTILE.get(), NatureMissileRenderer::new);
    }
}

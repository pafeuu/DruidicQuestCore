package net.pafeuu.DruidicQuestMod.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.pafeuu.DruidicQuestMod.DruidicQuestMod;
import net.pafeuu.DruidicQuestMod.entity.spells.nature_missile.NatureMissileProjectile;

public class EntityRegistry {
    private static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(Registries.ENTITY_TYPE, DruidicQuestMod.MODID);

    public static final RegistryObject<EntityType<NatureMissileProjectile>> NATURE_MISSILE_PROJECTILE =
            ENTITIES.register("nature_missile", () -> EntityType.Builder.<NatureMissileProjectile>of(NatureMissileProjectile::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(ResourceLocation.fromNamespaceAndPath(DruidicQuestMod.MODID, "nature_missile").toString()));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}

package net.pafeuu.DruidicQuestMod.mixin.botania;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import vazkii.botania.common.block.block_entity.LuminizerBlockEntity;

import static net.pafeuu.DruidicQuestMod.config.CommonConfig.LUMINIZER_ITEM_SPEED;

@Mixin(LuminizerBlockEntity.PlayerMoverEntity.class)
public abstract class PlayerMoverEntityMixin extends Entity {
    public PlayerMoverEntityMixin(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Unique
    private double druidic_quest_core$remainingDistance;

    @WrapOperation(
            method = "tick",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/phys/Vec3;normalize()Lnet/minecraft/world/phys/Vec3;"
            )
    )
    private Vec3 druidic_quest_core$captureDistanceToExit(Vec3 instance, Operation<Vec3> original) {
        druidic_quest_core$remainingDistance = instance.length();
        return original.call(instance);
    }

    @WrapOperation(
            method = "tick",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/phys/Vec3;scale(D)Lnet/minecraft/world/phys/Vec3;"
            )
    )
    private Vec3 druidic_quest_core$configurableLuminizerItemSpeed(Vec3 instance, double pFactor, Operation<Vec3> original) {
        return original.call(instance, Math.min(LUMINIZER_ITEM_SPEED.get(), druidic_quest_core$remainingDistance));
    }
}

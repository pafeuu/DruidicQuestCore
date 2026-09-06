package net.pafeuu.DruidicQuestMod.mixin.quark;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.violetmoon.quark.content.client.tooltip.AttributeTooltips;

@Mixin(AttributeTooltips.class)
public class AttributeTooltipsMixin {

    @WrapOperation(
            method = "getAttribute",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/ai/attributes/AttributeInstance;getBaseValue()D"
            )
    )
    private static double druidic_quest_core$correctNaN(AttributeInstance instance, Operation<Double> original) {
        double value = original.call(instance);
        if (Double.isNaN(value))
            value = 0;
        return value;
    }
}

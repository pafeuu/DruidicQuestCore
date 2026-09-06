package net.pafeuu.DruidicQuestMod.registries.tiers;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.item.weapons.ExtendedWeaponTier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class WeaponTierRegistry {

    public static ExtendedWeaponTier FLOWER_STAFF = new ExtendedWeaponTier(128, 2.0f, -2.6f,0, ()-> Ingredient.of(Items.STICK),
            new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, -1, AttributeModifier.Operation.MULTIPLY_BASE));

    public static ExtendedWeaponTier IMPROVED_FLOWER_STAFF = new ExtendedWeaponTier(128, 3.5f, -2.6f,0, ()-> Ingredient.of(Items.STICK),
            new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, -1, AttributeModifier.Operation.MULTIPLY_BASE),
            new AttributeContainer(AttributeRegistry.MANA_REGEN, 0.2, AttributeModifier.Operation.MULTIPLY_TOTAL));


}

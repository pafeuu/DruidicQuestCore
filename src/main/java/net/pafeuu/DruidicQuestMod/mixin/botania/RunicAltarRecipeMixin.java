package net.pafeuu.DruidicQuestMod.mixin.botania;

import net.minecraft.world.item.ItemStack;
import net.pafeuu.DruidicQuestMod.data.duckfaces.ICatalystRunicAltarRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import vazkii.botania.common.crafting.RunicAltarRecipe;

@Mixin(RunicAltarRecipe.class)
public abstract class RunicAltarRecipeMixin implements ICatalystRunicAltarRecipe {
    @Unique
    private ItemStack druidic_quest_core$catalyst = ItemStack.EMPTY;

    @Override
    public ItemStack druidic_quest_core$getCatalyst() {
        return druidic_quest_core$catalyst;
    }

    @Override
    public void druidic_quest_core$setCatalyst(ItemStack catalyst) {
        this.druidic_quest_core$catalyst = catalyst;
    }
}

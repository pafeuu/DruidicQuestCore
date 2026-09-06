package net.pafeuu.DruidicQuestMod.mixin.botania.RunicAltar;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;
import net.pafeuu.DruidicQuestMod.data.duckfaces.ICatalystRunicAltarRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import vazkii.botania.common.crafting.RunicAltarRecipe;

@Mixin(RunicAltarRecipe.class)
public abstract class RunicAltarRecipeMixin implements ICatalystRunicAltarRecipe, vazkii.botania.api.recipe.RunicAltarRecipe {
    @Unique
    private ItemStack druidic_quest_core$catalyst = ItemStack.EMPTY;

    @Override
    public Ingredient getReagent() {
        return druidic_quest_core$catalyst.isEmpty() ?
                Ingredient.of(ForgeRegistries.ITEMS.getValue(ResourceLocation.fromNamespaceAndPath("botania", "livingrock"))) :
                Ingredient.of(druidic_quest_core$catalyst);
    }

    @Override
    public ItemStack druidic_quest_core$getCatalyst() {
        return druidic_quest_core$catalyst;
    }

    @Override
    public void druidic_quest_core$setCatalyst(ItemStack catalyst) {
        this.druidic_quest_core$catalyst = catalyst;
    }
}

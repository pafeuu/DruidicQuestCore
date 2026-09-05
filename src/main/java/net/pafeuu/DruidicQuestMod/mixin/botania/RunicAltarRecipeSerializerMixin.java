package net.pafeuu.DruidicQuestMod.mixin.botania;

import com.google.gson.JsonObject;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;
import net.pafeuu.DruidicQuestMod.data.duckfaces.ICatalystRunicAltarRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import vazkii.botania.common.crafting.RunicAltarRecipe;

@Mixin(RunicAltarRecipe.Serializer.class)
public abstract class RunicAltarRecipeSerializerMixin {
    @Unique
    private Ingredient druidic_quest_core$catalystIngredient;

    @WrapMethod(
            method = "fromJson(Lnet/minecraft/resources/ResourceLocation;Lcom/google/gson/JsonObject;)Lvazkii/botania/common/crafting/RunicAltarRecipe;",
            remap = false
    )
    private RunicAltarRecipe druidic_quest_core$getCatalystFromJson(ResourceLocation id, JsonObject json, Operation<RunicAltarRecipe> original) {
        ResourceLocation livingrockLocation = ResourceLocation.fromNamespaceAndPath("botania", "livingrock");
        druidic_quest_core$catalystIngredient = json.has("catalyst") ?
                Ingredient.fromJson(json.get("catalyst")) : Ingredient.of(ForgeRegistries.ITEMS.getValue(livingrockLocation));
        return original.call(id, json);
    }

    @ModifyReturnValue(
            method = "fromJson(Lnet/minecraft/resources/ResourceLocation;Lcom/google/gson/JsonObject;)Lvazkii/botania/common/crafting/RunicAltarRecipe;",
            at = @At(value = "RETURN"),
            remap = false
    )
    private RunicAltarRecipe druidic_quest_core$fromJsonCatalystCompat(RunicAltarRecipe original) {
        ((ICatalystRunicAltarRecipe) original).druidic_quest_core$setCatalyst(druidic_quest_core$catalystIngredient.getItems()[0]);
        return original;
    }
}

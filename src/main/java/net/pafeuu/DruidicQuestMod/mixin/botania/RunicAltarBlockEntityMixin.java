package net.pafeuu.DruidicQuestMod.mixin.botania;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.pafeuu.DruidicQuestMod.data.duckfaces.ICatalystRunicAltarRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import vazkii.botania.api.recipe.RunicAltarRecipe;
import vazkii.botania.common.block.block_entity.RunicAltarBlockEntity;
import vazkii.botania.common.block.block_entity.SimpleInventoryBlockEntity;

import static net.pafeuu.DruidicQuestMod.tag.ModTags.Items.RUNE_ITEM;

@Mixin(RunicAltarBlockEntity.class)
public abstract class RunicAltarBlockEntityMixin extends SimpleInventoryBlockEntity {
    protected RunicAltarBlockEntityMixin(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @WrapOperation(
            method = "onUsedByWand",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/Block;asItem()Lnet/minecraft/world/item/Item;"
            )
    )
    private Item druidic_quest_core$allowUseAnyBaseIngredientForAltar(Block instance, Operation<Item> original,
                                                                      @Local(name = "recipe") RunicAltarRecipe recipe) {
        return ((ICatalystRunicAltarRecipe) recipe).druidic_quest_core$getCatalyst().getItem();
    }

    @WrapOperation(
            method = "onUsedByWand",
            at = @At(
                    value = "CONSTANT",
                    args = "classValue=vazkii/botania/common/item/material/RuneItem"
            ),
            remap = false
    )
    private boolean druidic_quest_core$allowVariableRuneMaterial(Object object, Operation<Boolean> original) {
        return ((Item) object).getDefaultInstance().is(RUNE_ITEM); //|| original.call(object);
    }


}

package net.pafeuu.DruidicQuestMod.mixin.enigmatic;

import com.aizistral.enigmaticlegacy.items.generic.ItemBase;
import com.aizistral.enigmaticlegacy.items.generic.ItemBaseCurio;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

@Mixin(ItemBaseCurio.class)
public abstract class ItemBaseCurioMixin extends ItemBase {

    @WrapMethod(
            method = "canEquip",
            remap = false
    )
    private boolean druidic_quest_core$forceCheckCurioEquip(SlotContext context, ItemStack stack, Operation<Boolean> original) {
        return ((ICurioItem) this).canEquip(context.identifier(), context.entity(), stack);
    }
}

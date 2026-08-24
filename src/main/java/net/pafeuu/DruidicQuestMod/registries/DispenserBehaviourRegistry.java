package net.pafeuu.DruidicQuestMod.registries;

import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class DispenserBehaviourRegistry {

    /*public static void registerDispenserBehaviour(){
        DispenserBlock.registerBehavior(Items.BUCKET, new OptionalDispenseItemBehavior()    {
            @Override
            protected ItemStack execute(BlockSource pSource, ItemStack pStack) {
                Level level = pSource.getLevel();
                Direction facing = pSource.getBlockState().getValue(DispenserBlock.FACING);
                BlockPos pos = pSource.getPos().relative(facing);
                List<Cow> cows = level.getEntitiesOfClass(Cow.class, new AABB(pos));


                return pStack;
            }
        });
    }*/
}

package net.pafeuu.DruidicQuestMod.registries;

import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.world.Containers;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.entity.DispenserBlockEntity;
import net.minecraft.world.level.block.state.BlockState;


public class DispenserBehaviourRegistry {

    public static void registerDispenserBehaviour(){
        DispenserBlock.registerBehavior(FluidRegistry.LIQUID_COAL_ESSENCE_BUCKET.get(), new OptionalDispenseItemBehavior()    {
            @Override
            protected ItemStack execute(BlockSource pSource, ItemStack pStack) {
                Level level = pSource.getLevel();
                Direction facing = pSource.getBlockState().getValue(DispenserBlock.FACING);
                BlockPos pos = pSource.getPos().relative(facing);

                DispenserBlockEntity dispenser = pSource.getEntity();
                ItemStack emptyBucket = new ItemStack(Items.BUCKET);
                BlockState newState = FluidRegistry.COAL_ESSENCE.get().defaultBlockState();

                level.setBlockAndUpdate(pos, newState);
                dispenser.addItem(emptyBucket);
                pStack.shrink(1);

                setSuccess(true);
                return pStack;


            }
        });
    }
}

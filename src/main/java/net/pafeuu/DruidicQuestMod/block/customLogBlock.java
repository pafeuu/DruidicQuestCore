package net.pafeuu.DruidicQuestMod.block;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.pafeuu.DruidicQuestMod.registries.BlockRegistry;
import org.jetbrains.annotations.Nullable;

public class customLogBlock extends RotatedPillarBlock {

    public customLogBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if(context.getItemInHand().getItem() instanceof AxeItem){
            if(state.is(BlockRegistry.TREATED_LOG.get())){
                return BlockRegistry.STRIPPED_TREATED_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }
        if(context.getItemInHand().getItem() instanceof AxeItem){
            if(state.is(BlockRegistry.TREATED_WOOD.get())){
                return BlockRegistry.STRIPPED_TREATED_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}

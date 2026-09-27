package net.pafeuu.DruidicQuestMod.blockClasses;

import com.hollingsworth.arsnouveau.common.block.SourceJar;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.pafeuu.DruidicQuestMod.config.CommonConfig;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HugeSourceJar extends SourceJar {
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new HugeSourceJarTile(pos,state);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag flagIn) {
            //super.appendHoverText(stack, worldIn, tooltip, flagIn);
            if (stack.getTag() != null) {
                int mana = stack.getTag().getCompound("BlockEntityTag").getInt("source");
                tooltip.add(Component.literal(mana * 100 / CommonConfig.HUGE_JAR_CAPACITY.get() + "% full"));
            }
    }
}

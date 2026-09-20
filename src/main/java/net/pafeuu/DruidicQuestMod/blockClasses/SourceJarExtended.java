package net.pafeuu.DruidicQuestMod.blockClasses;

import com.hollingsworth.arsnouveau.common.block.SourceJar;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SourceJarExtended extends SourceJar {
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SourceJarTileExtended(pos,state);
    }
}

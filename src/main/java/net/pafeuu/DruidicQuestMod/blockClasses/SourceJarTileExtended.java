package net.pafeuu.DruidicQuestMod.blockClasses;

import com.hollingsworth.arsnouveau.common.block.SourceJar;
import com.hollingsworth.arsnouveau.common.block.tile.SourceJarTile;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.pafeuu.DruidicQuestMod.registries.BlockRegistry;

public class SourceJarTileExtended extends SourceJarTile {

    public SourceJarTileExtended(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public int getMaxSource() {
        return 100000;
    }

    @Override
    public BlockEntityType<?> getType() {
        return BlockRegistry.BIG_SOURCE_JAR_TILE.get();
    }

    @Override
    public boolean updateBlock() {
        if (level == null) {
            return false;
        }

        BlockState state = level.getBlockState(worldPosition);
        level.sendBlockUpdated(
                worldPosition,
                state,
                state,
                3
        );
        setChanged();

        int fillState = 0;
        if (this.getSource() > 0 && this.getSource() < 10000)
            fillState = 1;
        else if (this.getSource() != 0) {
            fillState = (this.getSource() / 10000) + 1;
        }
        if (state.hasProperty(SourceJar.fill))
            level.setBlock(worldPosition, state.setValue(SourceJar.fill, fillState), 3);
        return true;
    }
}

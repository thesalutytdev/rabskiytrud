package org.thesalutyt.dedaebutrabi.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.thesalutyt.dedaebutrabi.SitUtil;

import javax.annotation.ParametersAreNonnullByDefault;

public class Dildo extends Block {
    public Dildo(Properties properties) {
        super(properties);
    }

    @Override
    @ParametersAreNonnullByDefault
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult ray) {
        if (player.isShiftKeyDown()) return InteractionResult.PASS;

        SitUtil.sitDown(player, world, pos, 0.25D);
        return InteractionResult.CONSUME;
    }
}

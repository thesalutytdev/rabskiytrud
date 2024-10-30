package org.thesalutyt.dedaebutrabi.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.thesalutyt.dedaebutrabi.SitUtil;

import javax.annotation.ParametersAreNonnullByDefault;

public class Spring extends Block {
    public Spring(Properties properties) {
        super(properties);
    }

    @Override
    @ParametersAreNonnullByDefault
    public void fallOn(Level world, BlockState state, BlockPos pos, Entity entity, float damage) {
        if (entity instanceof Player) {
            ((Player) entity).setJumping(true);
        }
    }

    @Override
    @ParametersAreNonnullByDefault
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult ray) {
        if (player.isShiftKeyDown()) return InteractionResult.PASS;

        SitUtil.sitDown(player, world, pos, 0.25D);
        return InteractionResult.CONSUME;
    }
}

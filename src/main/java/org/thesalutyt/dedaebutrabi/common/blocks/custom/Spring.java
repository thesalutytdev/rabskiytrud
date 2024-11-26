package org.thesalutyt.dedaebutrabi.common.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.thesalutyt.dedaebutrabi.SitUtil;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.stream.Stream;

public class Spring extends Block {
    private static final VoxelShape SHAPE = Stream.of(
            Block.box(0, 5.199999999999999, 14, 16, 6.400000000000001, 16),
            Block.box(0, 5.199999999999999, 0, 16, 6.400000000000001, 2),
            Block.box(0, 5.199999999999999, 2, 2, 6.400000000000001, 14),
            Block.box(14, 5.199999999999999, 2, 16, 6.400000000000001, 14),
            Block.box(0.10000000000000142, 5.799999999999998, 2, 14.800000000000002, 5.799999999999998, 14),
            Block.box(0.5, 0, 0.2999999999999998, 2, 5.300000000000001, 2),
            Block.box(0.5, 0, 13.8, 2, 5.300000000000001, 15.5),
            Block.box(14, 0, 13.8, 15.5, 5.300000000000001, 15.5),
            Block.box(14, 0, 0.3000000000000007, 15.5, 5.300000000000001, 2)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public Spring(Properties properties) {
        super(properties);
    }

    @Override
    @ParametersAreNonnullByDefault
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPE;
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

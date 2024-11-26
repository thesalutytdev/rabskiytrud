package org.thesalutyt.dedaebutrabi.common.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Sheep;
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

public class Dildo extends Block {
    private static final VoxelShape SHAPE = Stream.of(
            Block.box(3, 0, 3, 13, 1, 13),
            Block.box(7.2, 0.5999999999999996, 7.1, 8.9, 7, 8.9),
            Block.box(6.2, 0.30000000000000004, 6.8, 7.8, 2, 9.2),
            Block.box(8.2, 0.19999999999999996, 6.8, 9.9, 2, 9.2),
            Block.box(8.7, 5.8, 6.8, 9.7, 8, 9),
            Block.box(6.3, 5.8, 6.9, 7.3, 8, 9.1)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public Dildo(Properties properties) {
        super(properties);
    }

    @Override
    @ParametersAreNonnullByDefault
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    @ParametersAreNonnullByDefault
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult ray) {
        if (player.isShiftKeyDown()) return InteractionResult.PASS;

        SitUtil.sitDown(player, world, pos, 0.25D);
        return InteractionResult.CONSUME;
    }

    @Override
    @ParametersAreNonnullByDefault
    public void fallOn(Level world, BlockState state, BlockPos pos, Entity entity, float damage) {
        if (!((entity instanceof Player) || (entity instanceof Sheep))) {
            entity.causeFallDamage(damage, 1.0F, world.damageSources().fall());
        }
        return;
    }
}

package org.thesalutyt.dedaebutrabi.common.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import org.thesalutyt.dedaebutrabi.common.blocks.entity.WoodenBoxEntity;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.stream.Stream;

public class WoodenBox extends BaseEntityBlock {
    private static final VoxelShape SHAPE = Stream.of(
            Block.box(0, 0, 0, 16, 2, 16),
            Block.box(14, 5, 2, 16, 7, 14),
            Block.box(14, 10, 2, 16, 12, 14),
            Block.box(0, 10, 2, 2, 12, 14),
            Block.box(2, 5, 14, 14, 7, 16),
            Block.box(2, 5, 0, 14, 7, 2),
            Block.box(2, 10, 0, 14, 12, 2),
            Block.box(2, 10, 14, 14, 12, 16),
            Block.box(14, 2, 14, 16, 14, 16),
            Block.box(0, 2, 0, 2, 14, 2),
            Block.box(0, 2, 14, 2, 14, 16),
            Block.box(14, 2, 0, 16, 14, 2),
            Block.box(0, 5, 2, 2, 7, 14)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public WoodenBox(Properties pProperties) {
        super(pProperties);
    }

    @Override
    @ParametersAreNonnullByDefault
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new WoodenBoxEntity(pPos, pState);
    }
}

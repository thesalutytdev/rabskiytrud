package org.thesalutyt.dedaebutrabi.common.blocks.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.thesalutyt.dedaebutrabi.common.blocks.ModBlockEntities;

public class WoodenBoxEntity extends BlockEntity {
    protected final ContainerData data;

    public WoodenBoxEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.WOODEN_BOX_BE.get(), pPos, pBlockState);

        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return 0;
            }

            @Override
            public void set(int pIndex, int pValue) {

            }

            @Override
            public int getCount() {
                return 0;
            }
        };
    }

}

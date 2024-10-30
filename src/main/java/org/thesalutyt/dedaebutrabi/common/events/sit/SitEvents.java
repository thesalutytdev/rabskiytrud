package org.thesalutyt.dedaebutrabi.common.events.sit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import org.thesalutyt.dedaebutrabi.Rabskiytrud;
import org.thesalutyt.dedaebutrabi.SitUtil;
import org.thesalutyt.dedaebutrabi.common.entities.sit.SitEntity;

@Mod.EventBusSubscriber(
        modid = Rabskiytrud.MODID
)
public class SitEvents {
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        Level level = player.level();

        if (event.getFace() == Direction.UP && !SitUtil.isPlayerSitting(player) && !player.isShiftKeyDown()) {
            BlockPos pos = event.getPos();
            BlockState state = level.getBlockState(pos);
            Block block = state.getBlock();

            if (isValidBlock(level, pos, state, block)
                    && isPlayerInRange(player, pos)
                    && !SitUtil.isOccupied(level, pos)
                    && player.getMainHandItem().isEmpty()
                    && level.getBlockState(pos.above()).isAir()) {
                SitUtil.sitDown(player, level, pos, 0.25D);
            }
        }
    }

    @SubscribeEvent
    public static void onBreak(BlockEvent.BreakEvent event) {
        //BreakEvent gets a Level in its constructor, so the cast is safe
        Level level = (Level) event.getLevel();

        if (!level.isClientSide()) {
            BlockPos pos = event.getPos();
            SitEntity entity = SitUtil.getSitEntity(level, pos);

            if (entity != null) {
                SitUtil.removeSitEntity(level, pos);
                entity.ejectPassengers();
            }
        }
    }

    /**
     * Returns whether or not the given block can be sat on
     *
     * @param level The level to check in
     * @param pos The position to check at
     * @param state The block state at the given position in the given level
     * @param block The block to check
     * @return true if the given block can be sat one, false otherwhise
     */
    private static boolean isValidBlock(Level level, BlockPos pos, BlockState state, Block block) {
        boolean isValid = block instanceof SlabBlock
                || block instanceof StairBlock
                || state.is(BlockTags.SLABS)
                || state.is(BlockTags.STAIRS);

        if (!isValid && block instanceof BedBlock) {
            state = level.getBlockState(pos.relative(state.getValue(BedBlock.PART) == BedPart.HEAD ? state.getValue(HorizontalDirectionalBlock.FACING).getOpposite() : state.getValue(HorizontalDirectionalBlock.FACING)));

            if (!(state.getBlock() instanceof BedBlock)) //it's half a bed!
                isValid = true;
        }

        return isValid;
    }

    /**
     * Returns whether or not the player is close enough to the block to be able to sit on it
     *
     * @param player The player
     * @param pos The position of the block to sit on
     * @return true if the player is close enough, false otherwhise
     */
    private static boolean isPlayerInRange(Player player, BlockPos pos) {
        BlockPos playerPos = player.blockPosition();
        int blockReachDistance = player.getAbilities().flying ? 4 : 5;

        pos = BlockPos.containing(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D);

        AABB range = new AABB(pos.getX() + blockReachDistance, pos.getY() + blockReachDistance, pos.getZ() + blockReachDistance, pos.getX() - blockReachDistance, pos.getY() - blockReachDistance, pos.getZ() - blockReachDistance);

        playerPos = BlockPos.containing(playerPos.getX() + 0.5D, playerPos.getY() + 0.5D, playerPos.getZ() + 0.5D);
        return range.minX <= playerPos.getX() && range.minY <= playerPos.getY() && range.minZ <= playerPos.getZ() && range.maxX >= playerPos.getX() && range.maxY >= playerPos.getY() && range.maxZ >= playerPos.getZ();
    }
}

package org.thesalutyt.dedaebutrabi.common.entities.sit;

public class SitEntity extends Entity {
	public SitEntity(EntityType<SitEntity> type, Level level) {
		super(type, level);
	}

	public SitEntity(Level level, BlockPos pos, double yOffset) {
		super(Sit.SIT_ENTITY_TYPE.get(), level);
		setPos(pos.getX() + 0.5D, pos.getY() + yOffset, pos.getZ() + 0.5D);
		noPhysics = true;
	}

	@Override
	public Vec3 getDismountLocationForPassenger(LivingEntity passenger) {
		if (passenger instanceof Player player) {
			Vec3 resetPosition = SitUtil.getPreviousPlayerPosition(player, this);

			if (resetPosition != null) {
				BlockPos belowResetPos = BlockPos.containing(resetPosition.x, resetPosition.y - 1, resetPosition.z);

				discard();

				if (!player.level().getBlockState(belowResetPos).isFaceSturdy(level(), belowResetPos, Direction.UP, SupportType.FULL))
					return new Vec3(resetPosition.x, resetPosition.y + 1, resetPosition.z);
				else
					return resetPosition;
			}
		}

		discard();
		return super.getDismountLocationForPassenger(passenger);
	}

	@Override
	public void remove(RemovalReason reason) {
		super.remove(reason);

		SitUtil.removeSitEntity(level(), blockPosition());
	}

	@Override
	protected void defineSynchedData() {}

	@Override
	protected void readAdditionalSaveData(CompoundTag tag) {}

	@Override
	protected void addAdditionalSaveData(CompoundTag tag) {}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return new ClientboundAddEntityPacket(this);
	}
}
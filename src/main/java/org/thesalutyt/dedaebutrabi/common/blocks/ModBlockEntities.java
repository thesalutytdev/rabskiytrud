package org.thesalutyt.dedaebutrabi.common.blocks;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.thesalutyt.dedaebutrabi.Rabskiytrud;
import org.thesalutyt.dedaebutrabi.common.blocks.entity.WoodenBoxEntity;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Rabskiytrud.MODID);

    public static final RegistryObject<BlockEntityType<WoodenBoxEntity>> WOODEN_BOX_BE =
            BLOCK_ENTITIES.register("wooden_box_be", () ->
                    BlockEntityType.Builder.of(WoodenBoxEntity::new,
                            ModBlocks.WOODEN_BOX.get()).build(null));
}

package org.thesalutyt.dedaebutrabi.common.blocks;

import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.client.model.obj.ObjMaterialLibrary;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.thesalutyt.dedaebutrabi.Rabskiytrud;
import org.thesalutyt.dedaebutrabi.common.blocks.custom.WoodenBox;
import org.thesalutyt.dedaebutrabi.common.blocks.custom.Dildo;
import org.thesalutyt.dedaebutrabi.common.blocks.custom.Spring;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Rabskiytrud.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Rabskiytrud.MODID);


    public static final RegistryObject<Block> DILDO =
            BLOCKS.register("dildo",
            () -> new Dildo(BlockBehaviour.Properties.of()
                    .dynamicShape()
                    .instabreak()
                    .noLootTable()
                    .explosionResistance(100000.0F)
                    .jumpFactor(100.0F)
                    .speedFactor(0.0F)
            ));
    public static final RegistryObject<Block> SPRING =
            BLOCKS.register("spring",
            () -> new Spring(BlockBehaviour.Properties.of()
                    .dynamicShape()
                    .instabreak()
                    .noLootTable()
                    .explosionResistance(1.0F)
                    .jumpFactor(2.0F)
                    .speedFactor(0.3F)
            ));

    public static final RegistryObject<Block> WOODEN_BOX =
            BLOCKS.register("wooden_box",
            () -> new WoodenBox(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .dynamicShape().explosionResistance(1.0F)));
}

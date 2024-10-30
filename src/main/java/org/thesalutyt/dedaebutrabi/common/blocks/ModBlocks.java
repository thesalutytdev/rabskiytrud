package org.thesalutyt.dedaebutrabi.common.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.thesalutyt.dedaebutrabi.Rabskiytrud;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Rabskiytrud.MODID);
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

}

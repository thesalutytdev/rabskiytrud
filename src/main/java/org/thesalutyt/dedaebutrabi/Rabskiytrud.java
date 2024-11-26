package org.thesalutyt.dedaebutrabi;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.slf4j.Logger;
import org.thesalutyt.dedaebutrabi.common.blocks.ModBlocks;
import org.thesalutyt.dedaebutrabi.common.blocks.ModBlockEntities;
import org.thesalutyt.dedaebutrabi.common.entities.EntityTypes;
import org.thesalutyt.dedaebutrabi.common.items.ModCreativeTabs;
import org.thesalutyt.dedaebutrabi.common.items.ModItems;

@Mod(Rabskiytrud.MODID)
@SuppressWarnings({"unused", "deprecated", "removal"})
public class Rabskiytrud {
    public static final String MODID = "rabskiytrud";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Rabskiytrud() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        if (FMLEnvironment.dist.isDedicatedServer()) {
            // Loading all needed stuff
        } else {
            LOGGER.warn("[ RabskiyTrud ]: Loading RabskiyTrud in Client");
        }

        EntityTypes.ENTITY_TYPES.register(modEventBus);

        ModBlocks.BLOCKS.register(modEventBus);
        ModBlockEntities.BLOCK_ENTITIES.register(modEventBus);

        ModItems.ITEMS.register(modEventBus);


        ModCreativeTabs.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}

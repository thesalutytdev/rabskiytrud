package org.thesalutyt.dedaebutrabi;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import org.thesalutyt.dedaebutrabi.common.blocks.ModBlocks;
import org.thesalutyt.dedaebutrabi.common.entities.EntityTypes;
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
        ModItems.ITEMS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}

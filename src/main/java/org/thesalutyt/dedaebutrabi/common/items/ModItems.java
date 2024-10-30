package org.thesalutyt.dedaebutrabi.common.items;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import org.thesalutyt.dedaebutrabi.Rabskiytrud;
import org.thesalutyt.dedaebutrabi.common.blocks.Dildo;
import org.thesalutyt.dedaebutrabi.common.blocks.ModBlocks;

import java.util.function.Supplier;


@Mod.EventBusSubscriber(modid = Rabskiytrud.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Rabskiytrud.MODID);

    @SubscribeEvent
    public static void onRegisterItems(final RegisterEvent event) {
        if (event.getRegistryKey().equals(ForgeRegistries.Keys.ITEMS)){
            ModBlocks.BLOCKS.getEntries().forEach( (blockRegistryObject) -> {
                Block block = blockRegistryObject.get();

                if (block instanceof Dildo) {
                    Item.Properties properties = new Item.Properties()
                            .food(new FoodProperties.Builder()
                                    .nutrition(100)
                                    .saturationMod(10.0F)
                                    .alwaysEat()
                                    .build())
                            .fireResistant();

                    Supplier<Item> blockItemFactory = () -> new BlockItem(block, properties);
                    event.register(ForgeRegistries.Keys.ITEMS, blockRegistryObject.getId(), blockItemFactory);

                    return;
                }

                Item.Properties properties = new Item.Properties();
                Supplier<Item> blockItemFactory = () -> new BlockItem(block, properties);
                event.register(ForgeRegistries.Keys.ITEMS, blockRegistryObject.getId(), blockItemFactory);
            });
        }
    }
}

package org.thesalutyt.dedaebutrabi.common.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;
import org.thesalutyt.dedaebutrabi.Rabskiytrud;
import org.thesalutyt.dedaebutrabi.common.blocks.ModBlocks;

public class ModCreativeTabs {
    public static DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Rabskiytrud.MODID);

    public static final RegistryObject<CreativeModeTab> RABSKIYTRUD = CREATIVE_MOD_TABS.register("rabskiytrud_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.WOODEN_BOX.get()))
                    .title(Component.translatable("creativetab.rabskiytrud"))
                    .displayItems((ctx, items) -> {
                        items.accept(ModBlocks.DILDO.get());
                        items.accept(ModBlocks.SPRING.get());
                        items.accept(ModBlocks.WOODEN_BOX.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MOD_TABS.register(eventBus);
    }
}

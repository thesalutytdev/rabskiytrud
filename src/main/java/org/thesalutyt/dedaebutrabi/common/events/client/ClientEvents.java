package org.thesalutyt.dedaebutrabi.common.events.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.thesalutyt.dedaebutrabi.Rabskiytrud;
import org.thesalutyt.dedaebutrabi.common.commands.GetStats;

@Mod.EventBusSubscriber(
        modid = Rabskiytrud.MODID,
        value = Dist.CLIENT
)
public class ClientEvents {
    @SubscribeEvent
    public static void onCommandRegistering(RegisterCommandsEvent event) {
        new GetStats(event.getDispatcher());
    }

    @Mod.EventBusSubscriber(
            modid = Rabskiytrud.MODID,
            bus = Mod.EventBusSubscriber.Bus.MOD,
            value = Dist.CLIENT
    )
    public static class ClientBusEvents {}
}

package org.thesalutyt.dedaebutrabi.common.events.server;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.event.server.ServerStoppingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.thesalutyt.dedaebutrabi.Rabskiytrud;
import org.thesalutyt.dedaebutrabi.common.commands.GetStats;
import org.thesalutyt.dedaebutrabi.data.PlayerStat;
import org.thesalutyt.dedaebutrabi.server.Server;

@Mod.EventBusSubscriber(
        modid = Rabskiytrud.MODID,
        value = Dist.DEDICATED_SERVER
)
public class ServerEvents {
    @SubscribeEvent
    public static void onCommandRegistering(RegisterCommandsEvent event) {
        new GetStats(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onServerStarting(ServerStartingEvent event) {
        Server.onServerStarting(event);
    }

    @SubscribeEvent
    public static void onServerStopping(ServerStoppingEvent event) {
        Server.onServerStopping(event);
    }

    @SubscribeEvent
    public static void onPlayerJoining(PlayerEvent.PlayerLoggedInEvent event) {
        Server.onPlayerJoining((ServerPlayer) event.getEntity());
    }

    @Mod.EventBusSubscriber(
            modid = Rabskiytrud.MODID,
            bus = Mod.EventBusSubscriber.Bus.MOD,
            value = Dist.DEDICATED_SERVER
    )
    public static class ServerBusEvents {}
}

package org.thesalutyt.dedaebutrabi.server;

import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.event.server.ServerStoppingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.thesalutyt.dedaebutrabi.data.PlayerStat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@OnlyIn(Dist.DEDICATED_SERVER)
public class Server {
    private static Server instance;
    private final MinecraftServer server;
    private final HashMap<UUID, PlayerStat> players = new HashMap<>();

    public Server(MinecraftServer server) {
        this.server = server;

        for (PlayerStat stat : PlayerStat.players) {
            players.put(stat.uuid(), stat);
        }
    }

    public static void onPlayerJoining(ServerPlayer player) {
        if (instance == null) return;

        if (!instance.players.containsKey(player.getUUID())) {
            instance.players.put(player.getUUID(), new PlayerStat(player));
        }
    }

    public static void onServerStarting(ServerStartingEvent event) {
        PlayerStat.load();
        instance = new Server(event.getServer());
    }

    public static void onServerStopping(ServerStoppingEvent event) {
        PlayerStat.save();
        instance = null;
    }
}

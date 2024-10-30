package org.thesalutyt.dedaebutrabi.data;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.server.ServerLifecycleHooks;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class PlayerStat {
    public static ArrayList<PlayerStat> players = new ArrayList<>();

    public int blocksPlaced;
    public int blocksBroken;
    public int mobsKilled;
    public int itemsCrafted;
    public int xpGained;
    public int messagesSent;

    protected final Player player;

    public PlayerStat(Player player) {
        this.player = player;

        AtomicBoolean found = new AtomicBoolean(false);
        players.forEach((PlayerStat stat) -> {
            if (stat.uuid() == player.getUUID()) {
                this.blocksPlaced = stat.blocksPlaced;
                this.blocksBroken = stat.blocksBroken;
                this.mobsKilled = stat.mobsKilled;
                this.itemsCrafted = stat.itemsCrafted;
                this.xpGained = stat.xpGained;
                this.messagesSent = stat.messagesSent;

                found.set(true);
            }
        });
        if (found.get()) {
            return;
        }

        this.blocksPlaced = 0;
        this.blocksBroken = 0;
        this.mobsKilled = 0;
        this.itemsCrafted = 0;
        this.xpGained = 0;
        this.messagesSent = 0;
    }

    public PlayerStat(String load) {
        String[] split = load.split(",");

        this.player = ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayer(UUID.fromString(split[0]));
        this.blocksPlaced = Integer.parseInt(split[1]);
        this.blocksBroken = Integer.parseInt(split[2]);
        this.mobsKilled = Integer.parseInt(split[3]);
        this.itemsCrafted = Integer.parseInt(split[4]);
        this.xpGained = Integer.parseInt(split[5]);
        this.messagesSent = Integer.parseInt(split[6]);
    }

    public PlayerStat(PlayerStat stat) {
        this.player = stat.player();

        this.blocksPlaced = stat.blocksPlaced;
        this.blocksBroken = stat.blocksBroken;
        this.mobsKilled = stat.mobsKilled;
        this.itemsCrafted = stat.itemsCrafted;
        this.xpGained = stat.xpGained;
        this.messagesSent = stat.messagesSent;
    }

    public Player player() {
        return player;
    }

    public String name() {
        return player().getName().getString();
    }

    public UUID uuid() {
        return player().getUUID();
    }

    public String dump() {
        return (uuid() +
                "," +
                blocksPlaced +
                "," + blocksBroken +
                "," + mobsKilled +
                "," + itemsCrafted +
                "," + xpGained + "," +
                messagesSent);
    }

    @Override
    public String toString() {
        return (
                "=====[ " + Translation.STATS_FOR.translation() + " " + name() + " ]=====\n" +
                "| " + Translation.BLOCKS_PLACED.translation() + ": " + blocksPlaced + "\n" +
                "| " + Translation.BLOCKS_BROKEN.translation() + ": " + blocksBroken + "\n" +
                "| " + Translation.ITEMS_CRAFTED.translation() + ": " + itemsCrafted + "\n" +
                "| " + Translation.XP_GAINED.translation() + ": " + xpGained + "\n" +
                "| " + Translation.MESSAGES_SENT.translation() + ": " + messagesSent + "\n" +
                "==============================="
                );
    }

    public static PlayerStat getPlayerStat(Player player) {
        for (PlayerStat stat : players) {
            if (stat.uuid() == player.getUUID()) {
                return stat;
            }
        }
        return new PlayerStat(player);
    }

    public static ArrayList<String> linesToSave() {
        ArrayList<String> lines = new ArrayList<>();
        for (PlayerStat stat : players) {
            lines.add(stat.dump());
        }
        return lines;
    }

    public static void load(ArrayList<String> lines) {
        players.clear();
        for (String line : lines) {
            players.add(new PlayerStat(line));
        }
    }

    /**
     *
     * TODO: Check this after rewriting save
     *
     */
    public static void load() {


        try {
            File file = new File(FMLPaths.GAMEDIR + "player.stats");

            if (!file.exists()) {
                return;
            }

            ArrayList<String> lines = new ArrayList<>();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            scanner.close();
            load(lines);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void save() {
        // TODO: Rewrite this to fucking work

        try {
            File file = new File(FMLPaths.GAMEDIR + "player.stats");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file);
            for (PlayerStat stat : players) {
                writer.write(stat.dump() + "\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public enum Translation {
        BLOCKS_PLACED("stats.blocksPlaced"),
        BLOCKS_BROKEN("stats.blocksBroken"),
        MOBS_KILLED("stats.mobsKilled"),
        ITEMS_CRAFTED("stats.itemsCrafted"),
        XP_GAINED("stats.xpGained"),
        MESSAGES_SENT("stats.messagesSent"),
        STATS_FOR("stats.for"),;

        private final String translationKey;

        Translation(String translationKey) {
            this.translationKey = translationKey;
        }

        public String translationKey() {
            return translationKey;
        }

        public String translation() {
            return Component.translatable(translationKey()).getString();
        }
    }
}

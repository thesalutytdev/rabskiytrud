package org.thesalutyt.dedaebutrabi.common.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import org.thesalutyt.dedaebutrabi.data.PlayerStat;

public class GetStats {
    public GetStats(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                Commands.literal("stats")
                        .then(Commands.argument("player", EntityArgument.player())
                                .executes(context -> {
                                    EntityArgument.getPlayer(context, "player")
                                            .sendSystemMessage(
                                                Component.literal(PlayerStat.getPlayerStat(EntityArgument.getPlayer(context, "player")).toString())
                                            );
                                    return 1;
                                }))
        );
    }
}

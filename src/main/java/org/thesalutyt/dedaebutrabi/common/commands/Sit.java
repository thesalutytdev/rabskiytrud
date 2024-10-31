package org.thesalutyt.dedaebutrabi.common.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import org.thesalutyt.dedaebutrabi.SitUtil;

public class Sit {
    public Sit(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                Commands.literal("sit")
                        .then(Commands.argument("pos", BlockPosArgument.blockPos())
                                .executes(context -> {
                                    SitUtil.sitDown(context.getSource().getPlayerOrException(),
                                            context.getSource().getLevel(),
                                            BlockPosArgument.getLoadedBlockPos(context, "pos"),
                                            0.25D);
                                    return 1;
                                }))
        );
    }
}

package com.davenonymous.bonsaitrees2.command;

import com.davenonymous.bonsaitrees2.block.ModObjects;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.text.StringTextComponent;

public class CommandListSoils implements Command<CommandSource> {
    private static final CommandListSoils CMD = new CommandListSoils();

    public static ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher) {
        return Commands.literal("soil")
                .requires(cs -> cs.hasPermission(0))
                .executes(CMD);
    }

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        if(context.getSource().getLevel() == null) {
            return 0;
        }

        context.getSource().sendSuccess(new StringTextComponent("Registered soils:"), false);
        ModObjects.soilRecipeHelper.getRecipeStream(context.getSource().getLevel().getRecipeManager()).forEach(soil -> {
            context.getSource().sendSuccess(new StringTextComponent(soil.getId().toString()), false);
        });

        return 0;
    }
}

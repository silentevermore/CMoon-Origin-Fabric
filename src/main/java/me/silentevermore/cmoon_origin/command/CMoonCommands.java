package me.silentevermore.cmoon_origin.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import gravity_changer.api.GravityChangerAPI;
import me.silentevermore.cmoon_origin.util.DirectionUtil;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Direction;

import java.util.Collection;

import static net.minecraft.server.command.CommandManager.literal;

public class CMoonCommands {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
                literal("cmoon_gravity").requires(cs->cs.hasPermissionLevel(2))
                        .executes(CMoonCommands::setBaseGravity)
        );
    }

    private static int setBaseGravity(CommandContext<ServerCommandSource> context) throws CommandSyntaxException{
        ServerCommandSource source=context.getSource();
        ServerPlayerEntity player=source.getPlayerOrThrow();
        Direction dir=DirectionUtil.toDirection(player.getRotationVecClient());
        GravityChangerAPI.setBaseGravityDirection(player, dir);
        return 1;
    }
}

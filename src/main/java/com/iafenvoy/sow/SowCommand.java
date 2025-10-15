package com.iafenvoy.sow;

import com.iafenvoy.neptune.ability.AbilityCategory;
import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.sow.item.block.SongCubeBlock;
import com.iafenvoy.sow.registry.power.SowAbilityCategory;
import com.iafenvoy.sow.world.song.SongChunkData;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

import java.util.Collection;

import static net.minecraft.commands.Commands.argument;
import static net.minecraft.commands.Commands.literal;

@EventBusSubscriber
public final class SowCommand {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        event.getDispatcher().register(literal("sow")
                .requires(source -> source.isPlayer() && source.hasPermission(source.getServer().isDedicatedServer() ? 4 : 0))
                .then(literal("power")
                        .then(argument("players", EntityArgument.players())
                                .then(literal("use").executes(SowCommand::useSong))
                                .then(literal("enable").executes(SowCommand::enableSong))
                                .then(literal("disable").executes(SowCommand::disableSong))
                        ))
                .then(literal("chunk")
                        .executes(ctx -> {
                            CommandSourceStack source = ctx.getSource();
                            Player player = source.getPlayerOrException();
                            source.sendSuccess(() -> Component.nullToEmpty("Remain notes: " + SongChunkData.get(player.level().getChunkAt(player.blockPosition())).getRemainNotes()), false);
                            return 1;
                        })
                ));
    }

    public static int useSong(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        CommandSourceStack source = context.getSource();
        Collection<ServerPlayer> players = EntityArgument.getPlayers(context, "players");
        ItemStack stack = source.getPlayerOrException().getMainHandItem();
        if (stack.getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof SongCubeBlock songCube) {
            for (ServerPlayer player : players)
                AbilityData.get(player).get(songCube.getCategory().getCategory()).setActiveAbility(player, songCube.getPower(stack));
            source.sendSuccess(() -> Component.translatable("command." + SongsOfWar.MOD_ID + ".use_song.success"), false);
            return 1;
        }
        source.sendSuccess(() -> Component.translatable("command." + SongsOfWar.MOD_ID + ".use_song.invalid"), false);
        return 0;
    }

    public static int enableSong(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        Collection<ServerPlayer> players = EntityArgument.getPlayers(context, "players");
        for (ServerPlayer player : players)
            AbilityData.get(player).enable(player, SowAbilityCategory.ALL.get().toArray(AbilityCategory[]::new));
        context.getSource().sendSuccess(() -> Component.literal("Success!"), true);
        return 1;
    }

    public static int disableSong(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        Collection<ServerPlayer> players = EntityArgument.getPlayers(context, "players");
        for (ServerPlayer player : players)
            AbilityData.get(player).disable(player, SowAbilityCategory.ALL.get().toArray(AbilityCategory[]::new));
        context.getSource().sendSuccess(() -> Component.literal("Success!"), true);
        return 1;
    }
}

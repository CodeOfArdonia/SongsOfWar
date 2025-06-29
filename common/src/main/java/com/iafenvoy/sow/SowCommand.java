package com.iafenvoy.sow;

import com.iafenvoy.neptune.ability.AbilityCategory;
import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.sow.item.block.SongCubeBlock;
import com.iafenvoy.sow.registry.power.SowAbilityCategory;
import com.iafenvoy.sow.world.song.SongChunkData;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import dev.architectury.event.events.common.CommandRegistrationEvent;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.Collection;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public final class SowCommand {
    public static void init() {
        CommandRegistrationEvent.EVENT.register((dispatcher, registry, selection) -> dispatcher
                .register(literal("sow")
                        .requires(source -> source.isExecutedByPlayer() && source.hasPermissionLevel(source.getServer().isDedicated() ? 4 : 0))
                        .then(literal("power")
                                .then(argument("players", EntityArgumentType.players())
                                        .then(literal("use").executes(SowCommand::useSong))
                                        .then(literal("enable").executes(SowCommand::enableSong))
                                        .then(literal("disable").executes(SowCommand::disableSong))
                                ))
                        .then(literal("chunk")
                                .executes(ctx -> {
                                    ServerCommandSource source = ctx.getSource();
                                    PlayerEntity player = source.getPlayerOrThrow();
                                    source.sendFeedback(() -> Text.of("Remain notes: " + SongChunkData.byChunk(player.getWorld().getWorldChunk(player.getBlockPos())).getRemainNotes()), false);
                                    return 1;
                                })
                        )));
    }

    public static int useSong(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerCommandSource source = context.getSource();
        Collection<ServerPlayerEntity> players = EntityArgumentType.getPlayers(context, "players");
        ItemStack stack = source.getPlayerOrThrow().getMainHandStack();
        if (stack.getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof SongCubeBlock songCube) {
            for (ServerPlayerEntity player : players)
                AbilityData.byPlayer(player).get(songCube.getCategory().getCategory()).setActiveAbility(songCube.getPower(stack));
            source.sendFeedback(() -> Text.translatable("command." + SongsOfWar.MOD_ID + ".use_song.success"), false);
            return 1;
        }
        source.sendFeedback(() -> Text.translatable("command." + SongsOfWar.MOD_ID + ".use_song.invalid"), false);
        return 0;
    }

    public static int enableSong(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        Collection<ServerPlayerEntity> players = EntityArgumentType.getPlayers(context, "players");
        for (ServerPlayerEntity player : players)
            AbilityData.byPlayer(player).enable(SowAbilityCategory.ALL.get().toArray(AbilityCategory[]::new));
        context.getSource().sendFeedback(() -> Text.literal("Success!"), true);
        return 1;
    }

    public static int disableSong(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        Collection<ServerPlayerEntity> players = EntityArgumentType.getPlayers(context, "players");
        for (ServerPlayerEntity player : players)
            AbilityData.byPlayer(player).disable(SowAbilityCategory.ALL.get().toArray(AbilityCategory[]::new));
        context.getSource().sendFeedback(() -> Text.literal("Success!"), true);
        return 1;
    }
}

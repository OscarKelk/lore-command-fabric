package com.oscarkelk.lorecommand.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import com.oscarkelk.lorecommand.LoreCommandMain;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import static com.mojang.brigadier.arguments.StringArgumentType.getString;
import static com.mojang.brigadier.arguments.StringArgumentType.greedyString;
import static net.minecraft.server.command.CommandManager.*;

public class ColourCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {

        dispatcher.register(literal("colour")
                .then(literal("black")
                        .executes(ctx -> colour(ctx, "black")))
                .then(literal("dark_blue")
                        .executes(ctx -> colour(ctx, "dark_blue")))
                .then(literal("dark_green")
                        .executes(ctx -> colour(ctx, "dark_blue")))
                .then(literal("dark_aqua")
                        .executes(ctx -> colour(ctx, "dark_blue")))
                .then(literal("dark_red")
                        .executes(ctx -> colour(ctx, "dark_blue")))
                .then(literal("dark_purple")
                        .executes(ctx -> colour(ctx, "dark_blue")))
                .then(literal("gold")
                        .executes(ctx -> colour(ctx, "dark_blue")))
                .then(literal("gray")
                        .executes(ctx -> colour(ctx, "dark_blue")))
                .then(literal("dark_gray")
                        .executes(ctx -> colour(ctx, "dark_blue")))
                .then(literal("blue")
                        .executes(ctx -> colour(ctx, "dark_blue")))
                .then(literal("green")
                        .executes(ctx -> colour(ctx, "dark_blue")))
                .then(literal("aqua")
                        .executes(ctx -> colour(ctx, "dark_blue")))
                .then(literal("red")
                        .executes(ctx -> colour(ctx, "dark_blue")))
                .then(literal("light_purple")
                        .executes(ctx -> colour(ctx, "dark_blue")))
                .then(literal("yellow")
                        .executes(ctx -> colour(ctx, "dark_blue")))
                .then(literal("white")
                        .executes(ctx -> colour(ctx, "dark_blue")))
        );
    }

    private static int colour(CommandContext<ServerCommandSource> context, String colour) throws CommandSyntaxException {
        ServerPlayerEntity player = context.getSource().getPlayer();

        ItemStack stack = player.getMainHandStack();
        NbtCompound nbt = stack.getNbt();
        NbtCompound nbtDisplay = nbt.getCompound(ItemStack.DISPLAY_KEY);

        NbtCompound lore = nbtDisplay.getCompound(ItemStack.LORE_KEY);

        NbtList nbtLore = new NbtList();
        nbtLore.add(NbtString.of(Text.Serializer.toJson(new LiteralText("test"))));

        nbtDisplay.put(ItemStack.LORE_KEY, nbtLore);
        nbt.put(ItemStack.DISPLAY_KEY, nbtDisplay);
        stack.setNbt(nbt);

        return 1;
    }
}


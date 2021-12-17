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

public class LoreCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {

        dispatcher.register(literal("lore")
            .then(literal("black")
                .then(argument("Item Lore", greedyString())
                        .executes(ctx -> lore(ctx, "black", getString(ctx, "Item Lore")))))
            .then(literal("dark_blue")
                .then(argument("Item Lore", greedyString())
                        .executes(ctx -> lore(ctx, "dark_blue", getString(ctx, "Item Lore")))))
            .then(literal("dark_green")
                .then(argument("Item Lore", greedyString())
                        .executes(ctx -> lore(ctx, "dark_green", getString(ctx, "Item Lore")))))
            .then(literal("dark_aqua")
                .then(argument("Item Lore", greedyString())
                        .executes(ctx -> lore(ctx, "dark_aqua", getString(ctx, "Item Lore")))))
            .then(literal("dark_red")
                .then(argument("Item Lore", greedyString())
                        .executes(ctx -> lore(ctx, "dark_red", getString(ctx, "Item Lore")))))
            .then(literal("dark_purple")
                .then(argument("Item Lore", greedyString())
                        .executes(ctx -> lore(ctx, "dark_purple", getString(ctx, "Item Lore")))))
            .then(literal("gold")
                .then(argument("Item Lore", greedyString())
                        .executes(ctx -> lore(ctx, "gold", getString(ctx, "Item Lore")))))
            .then(literal("gray")
                .then(argument("Item Lore", greedyString())
                        .executes(ctx -> lore(ctx, "gray", getString(ctx, "Item Lore")))))
            .then(literal("dark_gray")
                .then(argument("Item Lore", greedyString())
                        .executes(ctx -> lore(ctx, "dark_gray", getString(ctx, "Item Lore")))))
            .then(literal("blue")
                .then(argument("Item Lore", greedyString())
                        .executes(ctx -> lore(ctx, "blue", getString(ctx, "Item Lore")))))
            .then(literal("green")
                .then(argument("Item Lore", greedyString())
                        .executes(ctx -> lore(ctx, "green", getString(ctx, "Item Lore")))))
            .then(literal("aqua")
                .then(argument("Item Lore", greedyString())
                        .executes(ctx -> lore(ctx, "aqua", getString(ctx, "Item Lore")))))
            .then(literal("red")
                .then(argument("Item Lore", greedyString())
                        .executes(ctx -> lore(ctx, "red", getString(ctx, "Item Lore")))))
            .then(literal("light_purple")
                .then(argument("Item Lore", greedyString())
                        .executes(ctx -> lore(ctx, "light_purple", getString(ctx, "Item Lore")))))
            .then(literal("yellow")
                .then(argument("Item Lore", greedyString())
                        .executes(ctx -> lore(ctx, "yellow", getString(ctx, "Item Lore")))))
            .then(literal("white")
                .then(argument("Item Lore", greedyString())
                        .executes(ctx -> lore(ctx, "white", getString(ctx, "Item Lore"))))));
    }

    private static int lore(CommandContext<ServerCommandSource> context, String colour, String new_lore) throws CommandSyntaxException {
        ServerPlayerEntity player = context.getSource().getPlayer();

        ItemStack stack = player.getMainHandStack();
        NbtCompound nbt = stack.getNbt();
        NbtCompound nbtDisplay = nbt.getCompound(ItemStack.DISPLAY_KEY);
        NbtList nbtLore = new NbtList();

        if(colour == "black") {
            nbtLore.add(NbtString.of(Text.Serializer.toJson(new LiteralText(new_lore).styled(style -> style.withFormatting(Formatting.BLACK)))));
        }
        else if(colour == "dark_blue") {
            nbtLore.add(NbtString.of(Text.Serializer.toJson(new LiteralText(new_lore).styled(style -> style.withFormatting(Formatting.DARK_BLUE)))));
        }
        else if(colour == "dark_green") {
            nbtLore.add(NbtString.of(Text.Serializer.toJson(new LiteralText(new_lore).styled(style -> style.withFormatting(Formatting.DARK_GREEN)))));
        }
        else if(colour == "dark_aqua") {
            nbtLore.add(NbtString.of(Text.Serializer.toJson(new LiteralText(new_lore).styled(style -> style.withFormatting(Formatting.DARK_AQUA)))));
        }
        else if(colour == "dark_red") {
            nbtLore.add(NbtString.of(Text.Serializer.toJson(new LiteralText(new_lore).styled(style -> style.withFormatting(Formatting.DARK_RED)))));
        }
        else if(colour == "dark_purple") {
            nbtLore.add(NbtString.of(Text.Serializer.toJson(new LiteralText(new_lore).styled(style -> style.withFormatting(Formatting.GRAY)))));
        }
        else if(colour == "gold") {
            nbtLore.add(NbtString.of(Text.Serializer.toJson(new LiteralText(new_lore).styled(style -> style.withFormatting(Formatting.GOLD)))));
        }
        else if(colour == "gray") {
            nbtLore.add(NbtString.of(Text.Serializer.toJson(new LiteralText(new_lore).styled(style -> style.withFormatting(Formatting.DARK_GRAY)))));
        }
        else if(colour == "dark_gray") {
            nbtLore.add(NbtString.of(Text.Serializer.toJson(new LiteralText(new_lore).styled(style -> style.withFormatting(Formatting.DARK_GRAY)))));
        }
        else if(colour == "blue") {
            nbtLore.add(NbtString.of(Text.Serializer.toJson(new LiteralText(new_lore).styled(style -> style.withFormatting(Formatting.BLUE)))));
        }
        else if(colour == "green") {
            nbtLore.add(NbtString.of(Text.Serializer.toJson(new LiteralText(new_lore).styled(style -> style.withFormatting(Formatting.GREEN)))));
        }
        else if(colour == "aqua") {
            nbtLore.add(NbtString.of(Text.Serializer.toJson(new LiteralText(new_lore).styled(style -> style.withFormatting(Formatting.AQUA)))));
        }
        else if(colour == "red") {
            nbtLore.add(NbtString.of(Text.Serializer.toJson(new LiteralText(new_lore).styled(style -> style.withFormatting(Formatting.RED)))));
        }
        else if(colour == "light_purple") {
            nbtLore.add(NbtString.of(Text.Serializer.toJson(new LiteralText(new_lore).styled(style -> style.withFormatting(Formatting.LIGHT_PURPLE)))));
        }
        else if(colour == "yellow") {
            nbtLore.add(NbtString.of(Text.Serializer.toJson(new LiteralText(new_lore).styled(style -> style.withFormatting(Formatting.YELLOW)))));
        }
        else if(colour == "white") {
            nbtLore.add(NbtString.of(Text.Serializer.toJson(new LiteralText(new_lore).styled(style -> style.withFormatting(Formatting.WHITE)))));
        }

        nbtLore.add(NbtString.of(Text.Serializer.toJson(new LiteralText(String.format("- %s", player.getEntityName())))));

        nbtDisplay.put(ItemStack.LORE_KEY, nbtLore);
        nbt.put(ItemStack.DISPLAY_KEY, nbtDisplay);
        stack.setNbt(nbt);

        return 1;
    }
}


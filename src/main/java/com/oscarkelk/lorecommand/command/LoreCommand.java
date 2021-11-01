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
            .then(argument("Item Lore", greedyString())
                    .executes(ctx -> lore(ctx, getString(ctx, "Item Lore")))));
    }

    private static int lore(CommandContext<ServerCommandSource> context, String new_lore) throws CommandSyntaxException {
        ServerPlayerEntity player = context.getSource().getPlayer();

        ItemStack stack = player.getMainHandStack();
        NbtCompound nbt = stack.getNbt();
        NbtCompound nbtDisplay = nbt.getCompound(ItemStack.DISPLAY_KEY);
        NbtList nbtLore = new NbtList();

        nbtLore.add(NbtString.of(Text.Serializer.toJson(new LiteralText(new_lore))));
        nbtLore.add(NbtString.of(Text.Serializer.toJson(new LiteralText(String.format("- %s", player.getEntityName())))));

        nbtDisplay.put(ItemStack.LORE_KEY, nbtLore);
        nbt.put(ItemStack.DISPLAY_KEY, nbtDisplay);
        stack.setNbt(nbt);

        return 1;
    }
}


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
        NbtCompound display1 = stack.getOrCreateSubNbt("display");
        NbtList lore = new NbtList();
        lore.add(NbtString.of(new_lore));
        display1.put("Lore", lore);
        player.giveItemStack(stack);

        return 1;
    }
}


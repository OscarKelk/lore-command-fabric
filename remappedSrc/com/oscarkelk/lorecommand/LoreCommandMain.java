package com.oscarkelk.lorecommand;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.CommandRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoreCommandMain implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("lorecommand");

	@Override
	public void onInitialize() {
		LOGGER.info("Lore Command Initialised");
		CommandRegistry.INSTANCE.register(false, com.oscarkelk.lorecommand.command.LoreCommand::register);
	}
}

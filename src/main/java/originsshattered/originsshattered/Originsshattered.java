package originsshattered.originsshattered;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import originsshattered.originsshattered.item.ModItems;
import originsshattered.originsshattered.util.ModLootTableModifiers;

public class Originsshattered implements ModInitializer {
	public static final String MOD_ID = "originsshattered";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModLootTableModifiers.modifyLootTables();
		ModItems.registerModItems();
		LOGGER.info("initializing origins Shattered");
	}
}
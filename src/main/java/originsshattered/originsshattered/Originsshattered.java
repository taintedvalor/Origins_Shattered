package originsshattered.originsshattered;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import originsshattered.originsshattered.item.ModItems;
import originsshattered.originsshattered.util.ModLootTableModifiers;

public class Originsshattered implements ModInitializer {
	public static final String MOD_ID = "originsshattered";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("initializing origins Shattered");
		FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> {
			ResourceManagerHelper.registerBuiltinResourcePack(
					new Identifier(MOD_ID, "originsshattered"),
					modContainer,
					ResourcePackActivationType.DEFAULT_ENABLED);
		});
		ModLootTableModifiers.modifyLootTables();
		ModItems.registerModItems();
	}
}
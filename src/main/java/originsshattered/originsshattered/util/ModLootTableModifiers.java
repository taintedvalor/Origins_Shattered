package originsshattered.originsshattered.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import originsshattered.originsshattered.item.ModItems;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier ANCIENT_CITY_ID =
            new Identifier("originsshattered", "chests/ancient_city");
    private static final Identifier WARDEN_ID =
            new Identifier("originsshattered", "entities/warden");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(ANCIENT_CITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f)) // Drops 30% of the time
                        .with(ItemEntry.builder(ModItems.origin_shard))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(WARDEN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.8f))
                        .with(ItemEntry.builder(ModItems.origins_shard))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}
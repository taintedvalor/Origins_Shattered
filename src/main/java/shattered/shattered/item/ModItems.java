package shattered.shattered.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import shattered.shattered.Originsshattered;

public class ModItems {


    //
    public static final Item shattered_origin = registerItem("shattered_origin", new Item(new FabricItemSettings().maxCount(16)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier( Originsshattered.MOD_ID, name), item);
    }

    public static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(shattered_origin);
    }


    public static void registerModItems() {
        Originsshattered.LOGGER.info("Registering Mod Items for " + Originsshattered.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}

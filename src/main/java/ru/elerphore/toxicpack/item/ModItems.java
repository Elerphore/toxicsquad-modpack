package ru.elerphore.toxicpack.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.elerphore.toxicpack.entity.ModEntities;

import static ru.elerphore.toxicpack.ToxicMod.MODID;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> JOHN_SPAWN_EGG =
            ITEMS.register(
                    "john_spawn_egg",
                    () -> new ForgeSpawnEggItem(
                            ModEntities.JOHN,
                            0x7e9680,
                            0xc5d1c5,
                            new Item.Properties()
                    )
            );

    public static final RegistryObject<Item> SNUS =
            ITEMS.register(
                    "snus",
                    () -> new Item(new Item.Properties().food(ModFoods.SNUS))
            );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}

package ru.elerphore.toxicpack.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static ru.elerphore.toxicpack.ToxicMod.MODID;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<CreativeModeTab> TOXIC_TAB =
            CREATIVE_MODE_TABS.register("toxictab",
                    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.JOHN_SPAWN_EGG.get()))
                            .title(Component.literal("Toxic Squad Pack"))
                            .displayItems(((pParameters, pOutput) -> {
                                pOutput.accept(ModItems.JOHN_SPAWN_EGG.get());
                                pOutput.accept(ModItems.SNUS.get());
                                pOutput.accept(ModItems.SNUS_GOLEM_SPAWN_EGG.get());
                            }))
                            .build());

    public static void register(IEventBus eventBus) {

        CREATIVE_MODE_TABS.register(eventBus);
    }
}

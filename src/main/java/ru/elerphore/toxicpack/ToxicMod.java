package ru.elerphore.toxicpack;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import ru.elerphore.toxicpack.entity.ModEntities;
import ru.elerphore.toxicpack.entity.client.JohnRenderer;
import ru.elerphore.toxicpack.events.OnItemChangeEventImplementation;
import ru.elerphore.toxicpack.events.OnKeyInputEventImplementation;
import ru.elerphore.toxicpack.factory.mob.FactoryReceiver;
import ru.elerphore.toxicpack.item.ModCreativeModTabs;
import ru.elerphore.toxicpack.item.ModItems;

@Mod(ToxicMod.MODID)
public class ToxicMod {

    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    public static final FactoryReceiver factoryReceiver = new FactoryReceiver();

    public static final String MODID = "toxicsquadpack";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ToxicMod() {
        ModEntities.register(modEventBus);
        ModItems.register(modEventBus);
        ModCreativeModTabs.register(modEventBus);
    }

    @Mod.EventBusSubscriber(modid = ToxicMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeEvents {

        @SubscribeEvent
        public static void onItemChangeEvent(LivingEquipmentChangeEvent event) {
            OnItemChangeEventImplementation.implementation(event);
        }

        @SubscribeEvent
        public static void onKeyInputEvent(InputEvent event) {
            OnKeyInputEventImplementation.implementation(event);
        }

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.JOHN.get(), JohnRenderer::new);
        }

    }

}

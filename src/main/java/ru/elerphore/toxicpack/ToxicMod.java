package ru.elerphore.toxicpack;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;
import ru.elerphore.toxicpack.events.OnItemChangeEventImplementation;
import ru.elerphore.toxicpack.factory.mob.FactoryReceiver;

@Mod(ToxicMod.MODID)
public class ToxicMod {

    public static final FactoryReceiver factoryReceiver = new FactoryReceiver();

    public static final String MODID = "toxicsquadpack";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ToxicMod() { }

    @Mod.EventBusSubscriber(modid = ToxicMod.MODID)
    public static class ForgeEvents {

        @SubscribeEvent
        public static void onItemChangeEvent(LivingEquipmentChangeEvent event) {
            OnItemChangeEventImplementation.implementation(event);
        }

    }
}

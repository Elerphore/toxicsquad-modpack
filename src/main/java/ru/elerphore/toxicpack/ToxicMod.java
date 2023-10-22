package ru.elerphore.toxicpack;

import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;
import ru.elerphore.toxicpack.factory.FactoryReceiver;

@Mod(ToxicMod.MODID)
public class ToxicMod {

    private static final FactoryReceiver factoryReceiver = new FactoryReceiver();

    public static final String MODID = "toxicsquadpack";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ToxicMod() {

    }

    @Mod.EventBusSubscriber(modid = ToxicMod.MODID)
    public static class ForgeEvents {

        @SubscribeEvent
        public static void onItemChangeEvent(LivingEquipmentChangeEvent event) {

            if(event.getEntity() instanceof Player player) {
                factoryReceiver.getZombieFactory().mobSpawn(player, 3);
            }

        }

    }
}

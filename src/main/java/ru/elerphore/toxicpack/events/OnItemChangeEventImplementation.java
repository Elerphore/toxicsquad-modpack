package ru.elerphore.toxicpack.events;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;

import static ru.elerphore.toxicpack.ToxicMod.factoryReceiver;

public class OnItemChangeEventImplementation {
    public static void implementation(LivingEquipmentChangeEvent event) {
        if (event.getEntity() instanceof Player player) {
            if (10 >= Math.random() * 100) {
                factoryReceiver.getZombieFactory().mobSpawn(player, 7);
            } else if (10 >= Math.random() * 100) {
                var explosion = factoryReceiver.getExplosionFactory().spawn(player);
                explosion.explode();
                explosion.finalizeExplosion(true);
            } else {
                player.sendSystemMessage(Component.literal("Тебе повезло. Клоун."));
            }
        }
    }
}

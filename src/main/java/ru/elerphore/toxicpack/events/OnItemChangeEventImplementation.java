package ru.elerphore.toxicpack.events;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;

import static ru.elerphore.toxicpack.ToxicMod.factoryReceiver;

public class OnItemChangeEventImplementation {
    public static void implementation(LivingEquipmentChangeEvent event) {

        if (event.getEntity() instanceof Player player) {
            if (Math.random() < 0.01) {
                factoryReceiver.getZombieFactory().mobSpawn(player, 7);
                return;
            }

            if (Math.random() < 0.01) {
                var explosion = factoryReceiver.getExplosionFactory().spawn(player);
                explosion.explode();
                explosion.finalizeExplosion(true);
                return;
            }

            if(Math.random() < 0.01) {
                var localPlayer = Minecraft.getInstance().player;
                assert localPlayer != null;
                localPlayer.setPos(localPlayer.position().x, localPlayer.position().y + 50, localPlayer.position().z);
                return;
            }

            player.sendSystemMessage(Component.literal("Тебе повезло. Клоун."));
        }
    }

}

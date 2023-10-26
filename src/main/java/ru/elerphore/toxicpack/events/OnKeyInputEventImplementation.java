package ru.elerphore.toxicpack.events;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.server.IntegratedServer;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.client.event.InputEvent;

import static ru.elerphore.toxicpack.ToxicMod.factoryReceiver;

public class OnKeyInputEventImplementation {
    public static void implementation(InputEvent event) {

        if(event instanceof InputEvent.Key key) {

            if(key.getKey() == 340) {
                LocalPlayer player = Minecraft.getInstance().player;

                assert player != null;
                factoryReceiver
                        .getZombieFactory()
                        .mobSpawn(player, 7);
            }
        }
    }
}

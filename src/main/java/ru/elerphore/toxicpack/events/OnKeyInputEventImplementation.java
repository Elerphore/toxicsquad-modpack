package ru.elerphore.toxicpack.events;

import net.minecraftforge.client.event.InputEvent;
import ru.elerphore.toxicpack.network.ToxicSquadPacketHandler;
import ru.elerphore.toxicpack.network.packet.ShiftPressedC2SPacket;

public class OnKeyInputEventImplementation {
    public static void implementation(InputEvent event) {

        if(event instanceof InputEvent.Key key) {

            if(key.getKey() == 340) {
                ToxicSquadPacketHandler.sendToServer(new ShiftPressedC2SPacket());
            }
        }
    }
}

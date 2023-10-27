package ru.elerphore.toxicpack.network.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraftforge.network.NetworkEvent;
import ru.elerphore.toxicpack.factory.mob.FactoryReceiver;

import java.util.function.Supplier;

import static ru.elerphore.toxicpack.ToxicMod.factoryReceiver;

public class ShiftPressedC2SPacket {
    public ShiftPressedC2SPacket() { }

    public ShiftPressedC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            var player = context.getSender();
            factoryReceiver.getJohnMobFactory().mobSpawn(player, 7);
            player.sendSystemMessage(Component.literal("YOU'VE SQUAD"));
        });

        return true;
    }


}

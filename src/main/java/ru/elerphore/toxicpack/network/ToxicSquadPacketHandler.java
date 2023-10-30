package ru.elerphore.toxicpack.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import ru.elerphore.toxicpack.network.packet.ShiftPressedC2SPacket;

import static ru.elerphore.toxicpack.ToxicMod.MODID;

public class ToxicSquadPacketHandler {
    private static final String PROTOCOL_VERSION = "1";

    private static SimpleChannel NETWORK_INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {
            var channel = NetworkRegistry.newSimpleChannel(
                new ResourceLocation(MODID, "main"),
                () -> PROTOCOL_VERSION,
                PROTOCOL_VERSION::equals,
                PROTOCOL_VERSION::equals
            );

        channel
            .messageBuilder(ShiftPressedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
            .decoder(ShiftPressedC2SPacket::new)
            .encoder(ShiftPressedC2SPacket::toBytes)
            .consumerMainThread(ShiftPressedC2SPacket::handle)
            .add();

        NETWORK_INSTANCE = channel;
    }

    public static <MSG> void sendToServer(MSG msg) {
        NETWORK_INSTANCE.sendToServer(msg);
    }

    public static <MSG> void sendToPlayer(MSG msg, ServerPlayer player) {
        NETWORK_INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), msg);
    }

}

package ru.elerphore.toxicpack.factory.mob;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;

import java.util.stream.IntStream;

abstract class MobFactory {

    void mobSpawn(Player player) { }

    void mobSpawn(LocalPlayer player) { }

    public void mobSpawn(Player player, Integer quantity) {
        if(quantity == null) quantity = 1;

        IntStream.range(0, quantity).forEach(item -> mobSpawn(player));
    }

    public void mobSpawn(LocalPlayer player, Integer quantity) {
        if(quantity == null) quantity = 1;

        IntStream.range(0, quantity).forEach(item -> mobSpawn(player));
    }

}

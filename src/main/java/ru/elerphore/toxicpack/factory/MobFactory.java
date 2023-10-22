package ru.elerphore.toxicpack.factory;

import net.minecraft.world.entity.player.Player;

import java.util.stream.IntStream;

abstract class MobFactory {

    void mobSpawn(Player player) { }

    public void mobSpawn(Player player, Integer quantity) {
        if(quantity == null) quantity = 1;

        IntStream.range(0, quantity).forEach(item -> mobSpawn(player));
    }

}

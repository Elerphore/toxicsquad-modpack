package ru.elerphore.toxicpack.factory.mob;

import net.minecraft.world.entity.player.Player;

import java.util.stream.IntStream;

public abstract class MobFactory {

    public void mobSpawn(Player player) { }

    public void mobSpawn(Player player, Integer quantity) {
        if(quantity == null) quantity = 1;

        IntStream.range(0, quantity).forEach(item -> mobSpawn(player));
    }

}

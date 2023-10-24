package ru.elerphore.toxicpack.factory.explosion;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;

public class ExplosionFactory {

    public static ExplosionBuilder builder = new ExplosionBuilder();

    public Explosion spawn(Player player) {
        return builder
                .setLevel(player.level())
                .setEntity(player)
                .setX(player.blockPosition().below().getX())
                .setY(player.blockPosition().below().getY())
                .setZ(player.blockPosition().below().getZ())
                .setRadius(10f)
                .setIsFireActive(true)
                .setBlockInteraction(Explosion.BlockInteraction.DESTROY)
                .build();
    }
}

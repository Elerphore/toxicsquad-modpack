package ru.elerphore.toxicpack.factory.explosion;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Explosion;

public class ExplosionFactory {

    public static ExplosionBuilder builder = new ExplosionBuilder();

    public Explosion spawn(Entity entity) {
        return builder
                .setLevel(entity.level())
                .setEntity(entity)
                .setX(entity.blockPosition().below().getX())
                .setY(entity.blockPosition().below().getY())
                .setZ(entity.blockPosition().below().getZ())
                .setRadius(10f)
                .setIsFireActive(true)
                .setBlockInteraction(Explosion.BlockInteraction.DESTROY)
                .build();
    }
}

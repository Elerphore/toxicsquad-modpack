package ru.elerphore.toxicpack.factory.explosion;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

public class ExplosionBuilder {
    private int x, y, z;

    private float radius;

    private boolean fire;

    private Level level;

    private Entity entity;

    private Explosion.BlockInteraction interaction;

    public ExplosionBuilder setX(int value) {
        this.x = value;
        return this;
    }

    public ExplosionBuilder setY(int value) {
        this.y = value;
        return this;
    }

    public ExplosionBuilder setZ(int value) {
        this.z = value;
        return this;
    }

    public ExplosionBuilder setRadius(float value) {
        this.radius = value;
        return this;
    }

    public ExplosionBuilder setIsFireActive(boolean value) {
        this.fire = value;
        return this;
    }

    public ExplosionBuilder setBlockInteraction(Explosion.BlockInteraction value) {
        this.interaction = value;
        return this;
    }

    public ExplosionBuilder setLevel(Level value) {
        this.level = value;
        return this;
    }

    public ExplosionBuilder setEntity(Entity value) {
        this.entity = value;
        return this;
    }

    public Explosion build() {
        return new Explosion(level, entity, x, y, z, radius, fire, interaction);
    }

}

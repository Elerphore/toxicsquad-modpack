package ru.elerphore.toxicpack.factory.mob.factories;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import ru.elerphore.toxicpack.factory.mob.MobFactory;

public class CreeperMobFactory extends MobFactory {

    @Override
    public void mobSpawn(Player player) {
        EntityType.CREEPER.spawn(
                player.getServer().overworld(),
                player.blockPosition(),
                MobSpawnType.NATURAL
        );
    }


}

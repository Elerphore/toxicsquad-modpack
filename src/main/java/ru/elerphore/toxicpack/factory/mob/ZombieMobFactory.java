package ru.elerphore.toxicpack.factory.mob;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;

public class ZombieMobFactory extends MobFactory{

    @Override
    void mobSpawn(Player player) {
        EntityType.ZOMBIE.spawn(
                player.getServer().overworld(),
                player.blockPosition(),
                MobSpawnType.NATURAL
        );
    }

}

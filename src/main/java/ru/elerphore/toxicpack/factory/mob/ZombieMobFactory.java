package ru.elerphore.toxicpack.factory.mob;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.DispenserBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;

public class ZombieMobFactory extends MobFactory{

    @Override
    void mobSpawn(Player player) {
        EntityType.ZOMBIE.spawn(
                player.getServer().overworld(),
                player.blockPosition(),
                MobSpawnType.NATURAL
        );
    }

    void mobSpawn(LocalPlayer player) {
        var clientLevel = player.clientLevel;
        var blockPos = player.blockPosition().below();
        var chunk = clientLevel.getChunk(blockPos);
        var blockEntity = chunk.getBlockEntity(blockPos);



        EntityType.ZOMBIE.spawn(
                blockEntity.getLevel().getServer().overworld(),
                player.blockPosition(),
                MobSpawnType.NATURAL
        );
    }

}

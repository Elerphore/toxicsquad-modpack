package ru.elerphore.toxicpack.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ru.elerphore.toxicpack.entity.client.JohnEntity;
import ru.elerphore.toxicpack.entity.client.ModModelLayers;

import static ru.elerphore.toxicpack.ToxicMod.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.JOHN_LAYER, JohnEntity::createBodyLayer);
    }

}

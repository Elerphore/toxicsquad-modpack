package ru.elerphore.toxicpack.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ru.elerphore.toxicpack.entity.ModEntities;
import ru.elerphore.toxicpack.entity.custom.JohnModel;

import static ru.elerphore.toxicpack.ToxicMod.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.JOHN.get(), JohnModel.createAttributes().build());
    }

}

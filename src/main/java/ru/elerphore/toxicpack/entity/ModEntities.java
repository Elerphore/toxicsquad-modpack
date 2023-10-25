package ru.elerphore.toxicpack.entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.elerphore.toxicpack.entity.custom.JohnModel;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ru.elerphore.toxicpack.ToxicMod.MODID);

    public static final RegistryObject<EntityType<JohnModel>> JOHN =
            ENTITY_TYPES.register("john", () -> EntityType.Builder.of(JohnModel::new, MobCategory.MONSTER)
                    .sized(.5f, .5f).build("john"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

package ru.elerphore.toxicpack.entity.client;

import com.ibm.icu.text.Normalizer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

import static ru.elerphore.toxicpack.ToxicMod.MODID;

public class ModModelLayers {
    public static final ModelLayerLocation JOHN_LAYER = new ModelLayerLocation(new ResourceLocation(MODID, "john_layer"), "main");
}

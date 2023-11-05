package ru.elerphore.toxicpack.entity.client.snusgolem;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import ru.elerphore.toxicpack.entity.client.ModModelLayers;
import ru.elerphore.toxicpack.entity.client.john.JohnEntity;
import ru.elerphore.toxicpack.entity.custom.JohnModel;
import ru.elerphore.toxicpack.entity.custom.SnusGolemModel;

import static ru.elerphore.toxicpack.ToxicMod.MODID;

public class SnusGolemRenderer extends MobRenderer<SnusGolemModel, SnusGolem<SnusGolemModel>> {
    public SnusGolemRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new SnusGolem<>(p_174304_.bakeLayer(ModModelLayers.SNUS_GOLEM_LAYER)), 0.2f);
    }

    @Override
    public ResourceLocation getTextureLocation(SnusGolemModel p_114482_) {
        return new ResourceLocation(MODID, "textures/entities/snus_golem.png");
    }

    @Override
    public void render(SnusGolemModel p_115455_, float p_115456_, float p_115457_, PoseStack p_115458_, MultiBufferSource p_115459_, int p_115460_) {
        super.render(p_115455_, p_115456_, p_115457_, p_115458_, p_115459_, p_115460_);
    }
}

package ru.elerphore.toxicpack.entity.client.john;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import ru.elerphore.toxicpack.entity.client.ModModelLayers;
import ru.elerphore.toxicpack.entity.custom.JohnModel;

import static ru.elerphore.toxicpack.ToxicMod.MODID;

public class JohnRenderer extends MobRenderer<JohnModel, JohnEntity<JohnModel>> {
    public JohnRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new JohnEntity(p_174304_.bakeLayer(ModModelLayers.JOHN_LAYER)), 0.2f);
    }

    @Override
    public ResourceLocation getTextureLocation(JohnModel p_114482_) {
        return new ResourceLocation(MODID, "textures/entities/john.png");
    }

    @Override
    public void render(JohnModel p_115455_, float p_115456_, float p_115457_, PoseStack p_115458_, MultiBufferSource p_115459_, int p_115460_) {
        super.render(p_115455_, p_115456_, p_115457_, p_115458_, p_115459_, p_115460_);
    }
}

package ru.elerphore.toxicpack.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties SNUS =
            new FoodProperties
                    .Builder()
                    .alwaysEat()
                    .nutrition(2)
                    .saturationMod(.2f)
                    .effect(() -> new MobEffectInstance(MobEffects.DARKNESS, 200), 1f)
                    .fast()
                    .build();
}

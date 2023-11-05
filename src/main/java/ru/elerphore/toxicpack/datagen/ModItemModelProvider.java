package ru.elerphore.toxicpack.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import ru.elerphore.toxicpack.item.ModItems;

import java.util.LinkedHashMap;

import static ru.elerphore.toxicpack.ToxicMod.MODID;

public class ModItemModelProvider  extends ItemModelProvider {
    private static LinkedHashMap<TrimMaterial, Float> trimMaterials = new LinkedHashMap<>();


    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(ModItems.JOHN_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.SNUS_GOLEM_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }
}

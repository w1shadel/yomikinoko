package com.Maxwell.yomikinoko;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("removal")
public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, YomikinokoMod.MODID);

    public static final RegistryObject<EntityType<com.Maxwell.yomikinoko.Entity.Yomikinoko>> YOMIKINOKO = ENTITY_TYPES.register("yomikinoko",
            () -> EntityType.Builder.of(com.Maxwell.yomikinoko.Entity.Yomikinoko::new, MobCategory.MONSTER)
                    .sized(1.9f, 1.9f)
                    .clientTrackingRange(10)
                    .build(new ResourceLocation(YomikinokoMod.MODID, "yomikinoko").toString()));
}
package com.Maxwell.yomikinoko.init;

import com.Maxwell.yomikinoko.YomikinokoMod;
import com.Maxwell.yomikinoko.init.Entity.Yomikinoko;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
@Mod.EventBusSubscriber(modid = YomikinokoMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@SuppressWarnings("removal")
public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, YomikinokoMod.MODID);

    public static final RegistryObject<EntityType<Yomikinoko>> YOMIKINOKO = ENTITY_TYPES.register("yomikinoko",
            () -> EntityType.Builder.of(Yomikinoko::new, MobCategory.MONSTER)
                    .sized(1.9f, 1.9f)
                    .clientTrackingRange(10)
                    .build(new ResourceLocation(YomikinokoMod.MODID, "yomikinoko").toString()));

    @SubscribeEvent
    public static void onRegisterSpawnPlacement(SpawnPlacementRegisterEvent event) {
        event.register(
                ModEntities.YOMIKINOKO.get(), 
                SpawnPlacements.Type.ON_GROUND, 
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, 
                Monster::checkMonsterSpawnRules, 
                SpawnPlacementRegisterEvent.Operation.OR 
        );
    }
}
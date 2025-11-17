package com.Maxwell.yomikinoko.init;
import com.Maxwell.yomikinoko.YomikinokoMod;
import com.Maxwell.yomikinoko.init.Entity.Yomikinoko;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = YomikinokoMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class YomiModEvent {
    @SubscribeEvent
    public static void registerAttributes(
            EntityAttributeCreationEvent event) {
        event.put(ModEntities.YOMIKINOKO.get(), Yomikinoko.createYomikinokoAttributes().build());
    }

}
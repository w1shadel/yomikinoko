package com.Maxwell.yomikinoko;
import com.Maxwell.yomikinoko.Entity.Yomikinoko;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = YomikinokoMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class YomiModEvent {
    @SubscribeEvent
    public static void registerAttributes(
            EntityAttributeCreationEvent event) {
        event.put(ModEntities.YOMIKINOKO.get(), Yomikinoko.createAttributes().build());
    }
}
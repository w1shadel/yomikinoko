package com.Maxwell.yomikinoko.init;

import com.Maxwell.yomikinoko.YomikinokoMod;
import com.Maxwell.yomikinoko.init.Entity.YomikinokoRenderer;
import com.Maxwell.yomikinoko.init.Entity.yomi_kinoko;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@SuppressWarnings("removal")
@Mod.EventBusSubscriber(modid = YomikinokoMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {    @SubscribeEvent
public static void onRegisterRenderers(final EntityRenderersEvent.RegisterRenderers event) {
    ;      event.registerEntityRenderer(ModEntities.YOMIKINOKO.get(), YomikinokoRenderer::new);
}
    @SubscribeEvent
    public static void onRegisterLayerDefinitions(final EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(yomi_kinoko.LAYER_LOCATION, yomi_kinoko::createBodyLayer);
    }
}
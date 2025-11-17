package com.Maxwell.yomikinoko;

import com.Maxwell.yomikinoko.init.Entity.ModEvents;
import com.Maxwell.yomikinoko.init.ModConfigs;
import com.Maxwell.yomikinoko.init.ModEntities;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(YomikinokoMod.MODID)
public class YomikinokoMod
{

    public static final String MODID = "yomikinoko";
    public YomikinokoMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        ModEntities.ENTITY_TYPES.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(new ModEvents());
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ModConfigs.SERVER_SPEC, "yomikinoko-server.toml");
    }
}

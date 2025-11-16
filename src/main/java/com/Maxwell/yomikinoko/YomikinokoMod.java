package com.Maxwell.yomikinoko;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(YomikinokoMod.MODID)
public class YomikinokoMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "yomikinoko";
    public YomikinokoMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        ModEntities.ENTITY_TYPES.register(modEventBus);
    }
}

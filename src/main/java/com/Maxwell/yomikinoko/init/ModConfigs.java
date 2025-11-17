package com.Maxwell.yomikinoko.init;

import com.Maxwell.yomikinoko.YomikinokoMod;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = YomikinokoMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModConfigs {

    public static final Server SERVER;
    public static final ForgeConfigSpec SERVER_SPEC;

    static {
        final Pair<Server, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Server::new);
        SERVER_SPEC = specPair.getRight();
        SERVER = specPair.getLeft();
    }


    public static int spawnInterval;
    public static int minSpawnDistance;
    public static int maxSpawnDistance;

    public static double maxHealth;
    public static double movementSpeed;
    public static double attackDamage;
    public static double followRange;
    public static double armor;


    @SubscribeEvent
    public static void onModConfigEvent(final ModConfigEvent.Loading event) {

        if (event.getConfig().getSpec() == SERVER_SPEC) {
            bakeConfig();
        }
    }

    @SubscribeEvent
    public static void onModConfigReloading(final ModConfigEvent.Reloading event) {

        if (event.getConfig().getSpec() == SERVER_SPEC) {
            bakeConfig();
        }
    }

    private static void bakeConfig() {
        spawnInterval = SERVER.spawnInterval.get();
        minSpawnDistance = SERVER.minSpawnDistance.get();
        maxSpawnDistance = SERVER.maxSpawnDistance.get();

        maxHealth = SERVER.maxHealth.get();
        movementSpeed = SERVER.movementSpeed.get();
        attackDamage = SERVER.attackDamage.get();
        followRange = SERVER.followRange.get();
        armor = SERVER.armor.get();
    }


    public static class Server {

        public final ForgeConfigSpec.ConfigValue<Integer> spawnInterval;
        public final ForgeConfigSpec.ConfigValue<Integer> minSpawnDistance;
        public final ForgeConfigSpec.ConfigValue<Integer> maxSpawnDistance;
        public final ForgeConfigSpec.DoubleValue maxHealth;
        public final ForgeConfigSpec.DoubleValue movementSpeed;
        public final ForgeConfigSpec.DoubleValue attackDamage;
        public final ForgeConfigSpec.DoubleValue followRange;
        public final ForgeConfigSpec.DoubleValue armor;

        public Server(ForgeConfigSpec.Builder builder) {

            builder.push("Custom Spawner");
            spawnInterval = builder.defineInRange("spawnInterval", 12000, 1, Integer.MAX_VALUE);
            minSpawnDistance = builder.defineInRange("minSpawnDistance", 24, 0, 128);
            maxSpawnDistance = builder.defineInRange("maxSpawnDistance", 48, 1, 128);
            builder.pop();

            builder.push("Yomikinoko Stats");
            maxHealth = builder.defineInRange("maxHealth", 120.0, 1.0, 1024.0);
            movementSpeed = builder.defineInRange("movementSpeed", 0.35, 0.01, 5.0);
            attackDamage = builder.defineInRange("attackDamage", 12.0, 0.0, 100.0);
            followRange = builder.defineInRange("followRange", 35.0, 1.0, 2048.0);
            armor = builder.defineInRange("armor", 0.0, 0.0, 30.0);
            builder.pop();
        }
    }
}
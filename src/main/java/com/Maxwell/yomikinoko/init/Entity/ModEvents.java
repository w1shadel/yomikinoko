package com.Maxwell.yomikinoko.init.Entity;


import com.Maxwell.yomikinoko.init.ModConfigs;
import com.Maxwell.yomikinoko.init.ModEntities;
import com.Maxwell.yomikinoko.YomikinokoMod;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = YomikinokoMod.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {

        if (event.getEntity() instanceof Villager villager) {

            Entity attacker = event.getSource().getEntity();

            if (attacker instanceof Yomikinoko) {

                if (!villager.level().isClientSide()) {
                    ServerLevel level = (ServerLevel) villager.level();

                    Yomikinoko newYomikinoko = ModEntities.YOMIKINOKO.get().create(level); 

                    if (newYomikinoko != null) {

                        newYomikinoko.moveTo(villager.getX(), villager.getY(), villager.getZ(), villager.getYRot(), villager.getXRot());

                        level.addFreshEntity(newYomikinoko);
                    }
                }
            }
        }
    }
    private static int spawnCooldown = 0;


    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (spawnCooldown > 0) {
                spawnCooldown--;
                return;
            }

            spawnCooldown = ModConfigs.spawnInterval;

            ServerLevel level = event.getServer().overworld();
            List<ServerPlayer> players = level.players();

            if (players.isEmpty()) {
                return;
            }

            RandomSource random = level.getRandom();
            ServerPlayer player = players.get(random.nextInt(players.size()));

            int minSpawnDist = ModConfigs.minSpawnDistance;
            int maxSpawnDist = ModConfigs.maxSpawnDistance;

            if (minSpawnDist >= maxSpawnDist) {
                maxSpawnDist = minSpawnDist + 1;
            }

            int spawnRange = maxSpawnDist - minSpawnDist;

            for (int i = 0; i < 10; i++) { 

                double angle = random.nextDouble() * 2.0 * Math.PI;
                double distance = minSpawnDist + random.nextDouble() * spawnRange;
                int x = (int) (player.getX() + Math.cos(angle) * distance);
                int z = (int) (player.getZ() + Math.sin(angle) * distance);

                int y = level.getHeight(Heightmap.Types.WORLD_SURFACE, x, z);
                BlockPos spawnPos = new BlockPos(x, y, z);

                if (Monster.checkMonsterSpawnRules(ModEntities.YOMIKINOKO.get(), level, net.minecraft.world.entity.MobSpawnType.NATURAL, spawnPos, random)) {
                    Yomikinoko entity = ModEntities.YOMIKINOKO.get().create(level);
                    if (entity != null) {
                        entity.setPos(spawnPos.getX() + 0.5, spawnPos.getY(), spawnPos.getZ() + 0.5);
                        level.addFreshEntity(entity);
                        return; 
                    }
                }
            }
        }
    }
}
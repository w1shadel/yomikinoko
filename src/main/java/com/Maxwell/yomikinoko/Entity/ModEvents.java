package com.Maxwell.yomikinoko.Entity;


import com.Maxwell.yomikinoko.ModEntities;
import com.Maxwell.yomikinoko.YomikinokoMod;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = YomikinokoMod.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        // 死亡したエンティティが村人かどうかを確認
        if (event.getEntity() instanceof Villager villager) {
            // ダメージソース（攻撃者）を取得
            Entity attacker = event.getSource().getEntity();

            // 攻撃者がYomikinokoかどうかを確認
            if (attacker instanceof Yomikinoko) {
                // ワールドがサーバーサイドであることを確認
                if (!villager.level().isClientSide()) {
                    ServerLevel level = (ServerLevel) villager.level();

                    // 新しいYomikinokoを作成
                    Yomikinoko newYomikinoko = ModEntities.YOMIKINOKO.get().create(level); // EntityInit.YOMIKINOKOはあなたのEntityTypeの登録名に合わせる

                    if (newYomikinoko != null) {
                        // 倒された村人の位置に移動させる
                        newYomikinoko.moveTo(villager.getX(), villager.getY(), villager.getZ(), villager.getYRot(), villager.getXRot());
                        // ワールドにスポーンさせる
                        level.addFreshEntity(newYomikinoko);
                    }
                }
            }
        }
    }
}
package com.Maxwell.yomikinoko.Entity;

import com.Maxwell.yomikinoko.YomikinokoMod;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@SuppressWarnings("removal")
@OnlyIn(Dist.CLIENT)
public class YomikinokoRenderer extends MobRenderer<Yomikinoko, yomi_kinoko> {
    private static final ResourceLocation NORMAL_TEXTURE =
        new ResourceLocation(YomikinokoMod.MODID, "textures/entity/yomi_kinoko.png");
    public YomikinokoRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new yomi_kinoko(renderManagerIn.bakeLayer(yomi_kinoko.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(Yomikinoko pEntity) {
        return NORMAL_TEXTURE;
    }
}
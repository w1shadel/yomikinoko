package com.Maxwell.yomikinoko.Entity;// Made with Blockbench 5.0.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports



import com.Maxwell.yomikinoko.YomikinokoMod;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class yomi_kinoko extends HierarchicalModel<Yomikinoko> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(YomikinokoMod.MODID, "yomi_kinoko"), "main");
	private final ModelPart bb_main;

	public yomi_kinoko(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(32, 38).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 26).addBox(-4.0F, -20.8F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(28, 52).addBox(-2.5F, -9.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(40, 22).addBox(-2.0F, -9.0F, -2.5F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(52, 22).addBox(-2.0F, -9.0F, 0.5F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(40, 0).addBox(-2.0F, -13.0F, -2.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(40, 17).addBox(-1.5F, -9.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(32, 26).addBox(-7.0F, -21.8F, 5.0F, 14.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 42).addBox(5.0F, -20.8F, 1.0F, 3.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-5.0F, -20.8F, -5.0F, 10.0F, 5.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(14, 42).addBox(-8.0F, -20.8F, 1.0F, 3.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(52, 52).addBox(-7.0F, -9.8F, 1.5F, 1.0F, 9.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(44, 52).addBox(6.0F, -9.8F, 1.4F, 1.0F, 9.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 15).addBox(-5.0F, -21.8F, -5.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(56, 0).addBox(-7.0F, -21.8F, 1.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(56, 5).addBox(5.0F, -21.8F, 1.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 57).addBox(4.0F, -20.8F, -2.0F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(13, 58).addBox(-7.0F, -20.8F, -2.0F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(26, 67).addBox(-11.0F, -38.8F, 7.0F, 22.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}


    @Override
    public ModelPart root() {
        return bb_main;
    }

    @Override
    public void setupAnim(Yomikinoko pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

    }
}
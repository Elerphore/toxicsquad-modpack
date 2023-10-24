package ru.elerphore.toxicpack.entity.client;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class JohnEntity<T extends Entity> extends EntityModel<T> {
	private final ModelPart head;
	private final ModelPart bone;
	private final ModelPart arms;

	public JohnEntity(ModelPart root) {
		this.head = root.getChild("head");
		this.bone = root.getChild("bone");
		this.arms = root.getChild("arms");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 11).addBox(-2.75F, -16.0F, 0.0F, 7.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(18, 7).addBox(-2.75F, -17.0F, 0.0F, 7.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(-0.1F, -14.4F, -0.15F, 2.0F, 0.6F, 0.15F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 25.0F, 0.0F));

		PartDefinition ears = head.addOrReplaceChild("ears", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition eyebrows = head.addOrReplaceChild("eyebrows", CubeListBuilder.create().texOffs(0, 1).addBox(-1.9F, -16.0F, -0.2F, 2.0F, 0.5F, 0.2F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(1.5F, -16.0F, -0.2F, 2.0F, 0.5F, 0.2F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 26.0F, 0.0F));

		PartDefinition bone_body = bone.addOrReplaceChild("bone_body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.3F, -12.0F, 0.5F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition legs = bone.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition bone_right_leg = legs.addOrReplaceChild("bone_right_leg", CubeListBuilder.create().texOffs(8, 20).addBox(-0.55F, 1.8577F, -1.2357F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -6.2F, 3.0F));

		PartDefinition bone_left_leg = legs.addOrReplaceChild("bone_left_leg", CubeListBuilder.create().texOffs(16, 20).addBox(-0.5016F, 1.8937F, -0.3625F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -6.3F, 2.0F));

		PartDefinition arms = partdefinition.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0F, 14.0F, 3.0F));

		PartDefinition bone_left_arm = arms.addOrReplaceChild("bone_left_arm", CubeListBuilder.create().texOffs(20, 0).addBox(-4.0F, -10.0F, 1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, -3.0F));

		PartDefinition bone_right_arm = arms.addOrReplaceChild("bone_right_arm", CubeListBuilder.create().texOffs(0, 20).addBox(3.7F, -10.0F, 1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, -3.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		arms.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
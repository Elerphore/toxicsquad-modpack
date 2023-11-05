package ru.elerphore.toxicpack.entity.client.snusgolem;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class SnusGolem<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart root;
	private final ModelPart head;
	private final ModelPart legs;

	public SnusGolem(ModelPart root) {
		this.root = root;
		this.head = root.getChild("head");
		this.legs = root.getChild("legs");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition main_head = head.addOrReplaceChild("main_head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -20.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition anthenna_2 = head.addOrReplaceChild("anthenna_2", CubeListBuilder.create().texOffs(1, 1).addBox(-1.8F, -21.0F, -0.1F, 0.7F, 4.0F, 0.8F, new CubeDeformation(0.0F))
		.texOffs(1, 1).addBox(-3.8F, -21.0F, -0.1F, 2.0F, 0.5F, 0.8F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.7F, 0.0F, 3.1416F, 0.0F));

		PartDefinition anthenna_1 = head.addOrReplaceChild("anthenna_1", CubeListBuilder.create().texOffs(1, 1).addBox(-1.8F, -21.0F, -0.1F, 0.7F, 4.0F, 0.8F, new CubeDeformation(0.0F))
		.texOffs(1, 1).addBox(-3.8F, -21.0F, -0.1F, 2.0F, 0.5F, 0.8F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition legs = partdefinition.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(-2.0F, 14.0F, 0.0F));

		PartDefinition bone_right_leg = legs.addOrReplaceChild("bone_right_leg", CubeListBuilder.create().texOffs(0, 13).addBox(-1.0F, -1.0F, -1.0F, 1.9F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, 0.0F));

		PartDefinition bone_left_leg = legs.addOrReplaceChild("bone_left_leg", CubeListBuilder.create().texOffs(8, 13).addBox(-0.8F, -1.0F, -1.0F, 1.8F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		legs.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return root;
	}
}
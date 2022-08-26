package fr.swokky.kinko.entities.projectiles.gomu.render;// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class GomuNoPistolModel extends ModelBase {
	private final ModelRenderer bone3;
	private final ModelRenderer bone2;
	private final ModelRenderer bone4;
	private final ModelRenderer bone;
	private final ModelRenderer bb_main;

	public GomuNoPistolModel() {
		textureWidth = 64;
		textureHeight = 64;

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-2.0F, 24.5F, -0.25F);


		ModelRenderer cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(2.0F, -0.5F, 3.0F);
		bone3.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -1.5708F, 0.0F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 15, -3.0F, 1.0F, 3.0F, 9, 1, 0, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 15, -3.25F, -1.0F, 3.0F, 9, 1, 0, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 15, -2.0F, -2.0F, 3.0F, 9, 1, 0, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 15, -3.75F, 0.0F, 3.0F, 9, 1, 0, 0.0F, false));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(2.25F, 15.5F, -0.5F);
		setRotationAngle(bone2, 1.5708F, 0.0F, 0.0F);


		ModelRenderer cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-2.25F, 3.0F, -8.5F);
		bone2.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 1.5708F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 15, -2.75F, 1.0F, 3.0F, 9, 1, 0, 0.0F, false));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 15, -3.0F, -1.0F, 3.0F, 9, 1, 0, 0.0F, false));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 15, -1.75F, -2.0F, 3.0F, 9, 1, 0, 0.0F, false));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 15, -3.5F, 0.0F, 3.0F, 9, 1, 0, 0.0F, false));

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(1.75F, 21.5F, 0.5F);
		setRotationAngle(bone4, -1.5708F, 0.0F, 0.0F);


		ModelRenderer cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-1.75F, -2.0F, 2.5F);
		bone4.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, -1.5708F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 0, 21, -1.5F, 0.0F, 3.0F, 9, 1, 0, 0.0F, false));
		cube_r3.cubeList.add(new ModelBox(cube_r3, 0, 21, -4.5F, -2.0F, 3.0F, 9, 1, 0, 0.0F, false));
		cube_r3.cubeList.add(new ModelBox(cube_r3, 0, 21, -3.5F, -3.0F, 3.0F, 9, 1, 0, 0.0F, false));
		cube_r3.cubeList.add(new ModelBox(cube_r3, 0, 21, -3.5F, -1.0F, 3.0F, 9, 1, 0, 0.0F, false));

		bone = new ModelRenderer(this);
		bone.setRotationPoint(-2.0F, 24.5F, -0.25F);


		ModelRenderer cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(2.0F, -0.5F, 3.0F);
		bone.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, -1.5708F, 0.0F);
		cube_r4.cubeList.add(new ModelBox(cube_r4, 0, 28, -1.75F, 1.0F, -3.0F, 9, 1, 0, 0.0F, false));
		cube_r4.cubeList.add(new ModelBox(cube_r4, 0, 28, -4.75F, -1.0F, -3.0F, 9, 1, 0, 0.0F, false));
		cube_r4.cubeList.add(new ModelBox(cube_r4, 0, 28, -3.75F, -2.0F, -3.0F, 9, 1, 0, 0.0F, false));
		cube_r4.cubeList.add(new ModelBox(cube_r4, 0, 28, -3.75F, 0.0F, -3.0F, 9, 1, 0, 0.0F, false));

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);


		ModelRenderer cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, 0.0F, 2.75F);
		bb_main.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, -1.5708F, 0.0F);
		cube_r5.cubeList.add(new ModelBox(cube_r5, 0, 0, -8.75F, -2.5F, -2.5F, 12, 5, 5, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bone.rotateAngleY = f4;
		bone2.rotateAngleY = f4;
		bone3.rotateAngleY = f4;
		bone4.rotateAngleY = f4;
		bb_main.rotateAngleY = f4;
		bone.offsetY = f;
		bone2.offsetY = f;
		bone3.offsetY = f;
		bone4.offsetY = f;
		bb_main.offsetY = f;
		bone3.render(f5);
		bone2.render(f5);
		bone4.render(f5);
		bone.render(f5);
		bb_main.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
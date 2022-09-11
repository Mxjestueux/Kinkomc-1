package fr.swokky.kinko.entities.projectiles.mera.render;// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class KageroModel extends ModelBase {
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;

	public KageroModel() {
		textureWidth = 66;
		textureHeight = 59;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 54, 6, -2.0F, -2.0F, -8.0F, 4, 4, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 48, -3.0F, -3.0F, -7.0F, 6, 6, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 38, 38, -4.0F, -4.0F, -6.0F, 8, 8, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -5.0F, -5.0F, -5.0F, 10, 10, 10, 0.0F, false));

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 1.0F);
		bb_main.addChild(cube_r1);
		setRotationAngle(cube_r1, -3.1416F, 0.0F, 3.1416F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 28, 44, -1.0F, -1.0F, -10.0F, 2, 2, 4, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 30, 0, -4.0F, -4.0F, -5.0F, 8, 8, 2, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 40, 18, -3.0F, -3.0F, -6.0F, 6, 6, 2, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 16, 48, -2.0F, -2.0F, -8.0F, 4, 4, 3, 0.0F, false));

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 0.0F, -1.0F);
		bb_main.addChild(cube_r2);
		setRotationAngle(cube_r2, -1.5926F, -1.5689F, 1.5926F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 38, 48, -1.0F, -2.0F, -8.0F, 4, 4, 2, 0.0F, false));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 40, -2.0F, -3.0F, -7.0F, 6, 6, 2, 0.0F, false));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 20, -3.0F, -4.0F, -6.0F, 8, 8, 2, 0.0F, false));

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 0.0F, 1.0F);
		bb_main.addChild(cube_r3);
		setRotationAngle(cube_r3, 1.5926F, 1.5689F, 1.549F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 20, 20, -3.0F, -4.0F, -6.0F, 8, 8, 2, 0.0F, false));
		cube_r3.cubeList.add(new ModelBox(cube_r3, 40, 10, -2.0F, -3.0F, -7.0F, 6, 6, 2, 0.0F, false));
		cube_r3.cubeList.add(new ModelBox(cube_r3, 50, 0, -1.0F, -2.0F, -8.0F, 4, 4, 2, 0.0F, false));

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, 0.0F, 1.0F);
		bb_main.addChild(cube_r4);
		setRotationAngle(cube_r4, 1.5926F, 1.5689F, 0.0218F);
		cube_r4.cubeList.add(new ModelBox(cube_r4, 50, 48, -1.0F, -2.0F, -8.0F, 4, 4, 2, 0.0F, false));
		cube_r4.cubeList.add(new ModelBox(cube_r4, 16, 40, -2.0F, -3.0F, -7.0F, 6, 6, 2, 0.0F, false));
		cube_r4.cubeList.add(new ModelBox(cube_r4, 0, 30, -3.0F, -4.0F, -6.0F, 8, 8, 2, 0.0F, false));

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, 0.0F, -1.0F);
		bb_main.addChild(cube_r5);
		setRotationAngle(cube_r5, -1.6363F, -1.5689F, 0.0654F);
		cube_r5.cubeList.add(new ModelBox(cube_r5, 28, 53, -1.0F, -2.0F, -8.0F, 4, 4, 2, 0.0F, false));
		cube_r5.cubeList.add(new ModelBox(cube_r5, 40, 26, -2.0F, -3.0F, -7.0F, 6, 6, 2, 0.0F, false));
		cube_r5.cubeList.add(new ModelBox(cube_r5, 20, 30, -3.0F, -4.0F, -6.0F, 8, 8, 2, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bb_main.rotateAngleY = f4;
		bb_main.offsetY = f;
		bb_main.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
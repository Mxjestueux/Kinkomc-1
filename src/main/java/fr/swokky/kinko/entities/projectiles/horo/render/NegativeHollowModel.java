package fr.swokky.kinko.entities.projectiles.horo.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class NegativeHollowModel extends ModelBase {
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;

	public NegativeHollowModel() {
		textureWidth = 16;
		textureHeight = 64;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 24, -6.5F, -7.0F, -5.0F, 13, 14, 10, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, 3.5F, 7.0F, -1.0F, 2, 2, 6, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -2.5F, 7.0F, -1.0F, 2, 2, 6, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, 0.5F, 7.0F, 2.0F, 2, 2, 6, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -5.5F, 7.0F, 2.0F, 2, 2, 6, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -3.5F, -5.0F, -6.0F, 2, 2, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, 1.5F, -5.0F, -6.0F, 2, 2, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -5.5F, 1.0F, -6.0F, 2, 2, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -4.25F, 0.0F, -6.0F, 2, 2, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -1.25F, 0.0F, -6.0F, 2, 2, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -2.5F, 1.0F, -6.0F, 2, 2, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, 1.75F, 0.0F, -6.0F, 2, 2, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, 0.5F, 1.0F, -6.0F, 2, 2, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, 3.5F, 1.0F, -6.0F, 2, 2, 2, 0.0F, false));

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.5F, 0.0F, 0.0F);
		bb_main.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -1.5708F, 0.0F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 0, -1.0F, -9.0F, 4.75F, 10, 2, 2, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 0, -1.0F, -9.0F, -5.25F, 10, 2, 2, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 0, -3.0F, -9.0F, -2.5F, 10, 2, 6, 0.0F, false));

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.5F, 0.0F, 0.0F);
		bb_main.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, -1.5708F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 0, -6.0F, -9.0F, 2.0F, 2, 2, 6, 0.0F, false));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 0, 0.0F, -9.0F, 2.0F, 2, 2, 6, 0.0F, false));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 0, -3.0F, -9.0F, -1.0F, 2, 2, 6, 0.0F, false));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 0, 3.0F, -9.0F, -1.0F, 2, 2, 6, 0.0F, false));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 0, 0.0F, 6.0F, 2.0F, 2, 2, 6, 0.0F, false));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 0, 3.0F, 6.0F, -1.0F, 2, 2, 6, 0.0F, false));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 0, -3.0F, 6.0F, -1.0F, 2, 2, 6, 0.0F, false));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 0, -6.0F, 6.0F, 2.0F, 2, 2, 6, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bb_main.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
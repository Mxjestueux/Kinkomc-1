package fr.swokky.kinko.entities.projectiles.gomu.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class GomuNoPistolThirdModel  extends ModelBase {
    private final ModelRenderer bb_main;

    public GomuNoPistolThirdModel() {
        textureWidth = 64;
        textureHeight = 64;

        bb_main = new ModelRenderer(this);
        bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
        bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -3.0F, -2.5F, -8.0F, 6, 5, 13, 0.0F, false));
        bb_main.cubeList.add(new ModelBox(bb_main, 5, 21, 3.5F, -3.5F, 2.0F, 2, 2, 1, 0.0F, false));
        bb_main.cubeList.add(new ModelBox(bb_main, 19, 18, 1.5F, -5.8F, 3.75F, 2, 2, 1, 0.0F, false));

        ModelRenderer cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        bb_main.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 0.0F, 3.1416F);
        cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 0, 3.5F, -3.5F, 3.5F, 2, 2, 1, 0.0F, false));

        ModelRenderer cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
        bb_main.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 0.0F, 1.5708F);
        cube_r2.cubeList.add(new ModelBox(cube_r2, 6, 0, 4.0F, -1.0F, 2.7F, 2, 2, 1, 0.0F, false));
        cube_r2.cubeList.add(new ModelBox(cube_r2, 7, 18, 1.5F, -6.3F, 3.0F, 2, 2, 1, 0.0F, false));

        ModelRenderer cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
        bb_main.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, 0.0F, -1.5708F);
        cube_r3.cubeList.add(new ModelBox(cube_r3, 13, 18, 3.0F, -3.5F, 3.0F, 2, 2, 1, 0.0F, false));
        cube_r3.cubeList.add(new ModelBox(cube_r3, 0, 19, 1.5F, -6.55F, 2.5F, 2, 2, 1, 0.0F, false));

        ModelRenderer cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
        bb_main.addChild(cube_r4);
        setRotationAngle(cube_r4, 1.5708F, 0.0F, -1.5708F);
        cube_r4.cubeList.add(new ModelBox(cube_r4, 0, 0, -3.0F, -5.5F, -2.5F, 0, 1, 3, 0.0F, false));
        cube_r4.cubeList.add(new ModelBox(cube_r4, 0, 0, -3.0F, -6.5F, -3.5F, 0, 1, 5, 0.0F, false));
        cube_r4.cubeList.add(new ModelBox(cube_r4, 0, 2, -3.0F, -7.5F, -2.5F, 0, 1, 5, 0.0F, false));

        ModelRenderer cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
        bb_main.addChild(cube_r5);
        setRotationAngle(cube_r5, -1.5708F, 0.0F, -1.5708F);
        cube_r5.cubeList.add(new ModelBox(cube_r5, 0, 0, 3.0F, 5.5F, -2.5F, 0, 1, 4, 0.0F, false));
        cube_r5.cubeList.add(new ModelBox(cube_r5, 6, 0, 3.0F, 3.5F, -1.5F, 0, 1, 3, 0.0F, false));
        cube_r5.cubeList.add(new ModelBox(cube_r5, 0, 0, 3.0F, 4.5F, -3.5F, 0, 1, 6, 0.0F, false));

        ModelRenderer cube_r6 = new ModelRenderer(this);
        cube_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
        bb_main.addChild(cube_r6);
        setRotationAngle(cube_r6, -1.5708F, 0.0F, 0.0F);
        cube_r6.cubeList.add(new ModelBox(cube_r6, 0, 3, 4.0F, 5.5F, -1.5F, 0, 1, 5, 0.0F, false));
        cube_r6.cubeList.add(new ModelBox(cube_r6, 0, 8, 4.0F, 3.5F, -1.5F, 0, 1, 4, 0.0F, false));
        cube_r6.cubeList.add(new ModelBox(cube_r6, 0, 14, 4.0F, 4.5F, -2.5F, 0, 1, 4, 0.0F, false));
        cube_r6.cubeList.add(new ModelBox(cube_r6, 0, 4, -4.0F, 5.5F, -2.5F, 0, 1, 5, 0.0F, false));
        cube_r6.cubeList.add(new ModelBox(cube_r6, 0, 5, -4.0F, 4.5F, -3.5F, 0, 1, 5, 0.0F, false));
        cube_r6.cubeList.add(new ModelBox(cube_r6, 0, 6, -4.0F, 3.5F, -2.5F, 0, 1, 5, 0.0F, false));
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
package fr.swokky.kinko.entities.projectiles.mera.render;

import fr.swokky.kinko.entities.projectiles.mera.FlameBoom;
import fr.swokky.kinko.utils.References;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

import static org.lwjgl.opengl.GL11.*;

public class RenderFlameBoom extends Render<FlameBoom> {

    private static final ResourceLocation TEXTURES = new ResourceLocation(References.MODID + ":textures/entity/flame_boom.png");
    private FlameBoomModel model = new FlameBoomModel();

    protected RenderFlameBoom(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(FlameBoom entity) {
        return TEXTURES;
    }

    @Override
    public void doRender(FlameBoom entity, double x, double y, double z, float entityYaw, float partialTicks) {
        glPushMatrix();
        bindTexture(TEXTURES);
        glTranslated(x, y, z);
        model.render(entity, -1.0F, 0.0F, 0.0F, 0.0F, entityYaw * 0.017453292F, 0.0625F);
        glPopMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
}

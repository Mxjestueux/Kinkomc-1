package fr.swokky.kinko.entities.projectiles.horo.render;

import fr.swokky.kinko.entities.projectiles.gomu.GomuNoPistol;
import fr.swokky.kinko.entities.projectiles.gomu.render.GomuNoPistolModel;
import fr.swokky.kinko.entities.projectiles.horo.NegativeHollow;
import fr.swokky.kinko.utils.References;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import static org.lwjgl.opengl.GL11.*;

public class RenderNegativeHollow extends Render<NegativeHollow> {

    private static final ResourceLocation TEXTURES = new ResourceLocation(References.MODID + ":textures/entity/negative_hollow.png");
    private NegativeHollowModel model = new NegativeHollowModel();

    public RenderNegativeHollow(RenderManager renderManager) {
        super(renderManager);
    }

    @Override
    protected ResourceLocation getEntityTexture(NegativeHollow entity) {
        return TEXTURES;
    }

    @Override
    public void doRender(NegativeHollow entity, double x, double y, double z, float entityYaw, float partialTicks) {
        glPushMatrix();
        bindTexture(TEXTURES);
        glTranslated(x, y, z);
        model.render(entity, -1.0F, 0.0F, 0.0F, 0.0F, entityYaw * 0.017453292F, 0.0625F);
        glPopMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
}

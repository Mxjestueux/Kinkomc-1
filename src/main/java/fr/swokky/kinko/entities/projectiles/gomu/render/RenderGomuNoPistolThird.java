package fr.swokky.kinko.entities.projectiles.gomu.render;

import fr.swokky.kinko.entities.projectiles.gomu.GomuNoPistol;
import fr.swokky.kinko.entities.projectiles.gomu.GomuNoPistolThird;
import fr.swokky.kinko.utils.References;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import static org.lwjgl.opengl.GL11.*;

public class RenderGomuNoPistolThird  extends Render<GomuNoPistolThird> {

    private static final ResourceLocation TEXTURES = new ResourceLocation(References.MODID + ":textures/entity/gomu_no_pistol_third.png");
    private GomuNoPistolThirdModel model = new GomuNoPistolThirdModel();

    public RenderGomuNoPistolThird(RenderManager renderManager) {
        super(renderManager);
    }

    @Override
    protected ResourceLocation getEntityTexture(GomuNoPistolThird entity) {
        return TEXTURES;
    }

    @Override
    public void doRender(GomuNoPistolThird entity, double x, double y, double z, float entityYaw, float partialTicks) {
        glPushMatrix();
        bindTexture(TEXTURES);
        glTranslated(x, y, z);
        model.render(entity, -1.0F, 0.0F, 0.0F, 0.0F, entityYaw * 0.017453292F, 0.0625F);
        glPopMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
}

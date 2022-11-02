package fr.swokky.kinko.entities.projectiles.horo.render;

import fr.swokky.kinko.entities.projectiles.gomu.GomuNoPistol;
import fr.swokky.kinko.entities.projectiles.gomu.render.RenderGomuNoPistol;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderNegativeHollowPistolFactory implements IRenderFactory<GomuNoPistol> {

    public static final RenderNegativeHollowPistolFactory INSTANCE = new RenderNegativeHollowPistolFactory();


    @Override
    public Render<? super GomuNoPistol> createRenderFor(RenderManager manager) {
        return new RenderGomuNoPistol(manager);
    }
}

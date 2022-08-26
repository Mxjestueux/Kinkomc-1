package fr.swokky.kinko.entities.projectiles.gomu.render;

import fr.swokky.kinko.entities.projectiles.gomu.GomuNoPistol;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderGomuNoPistolFactory implements IRenderFactory<GomuNoPistol> {

    public static final RenderGomuNoPistolFactory INSTANCE = new RenderGomuNoPistolFactory();


    @Override
    public Render<? super GomuNoPistol> createRenderFor(RenderManager manager) {
        return new RenderGomuNoPistol(manager);
    }
}

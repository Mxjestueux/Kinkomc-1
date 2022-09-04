package fr.swokky.kinko.entities.projectiles.gomu.render;

import fr.swokky.kinko.entities.projectiles.gomu.GomuNoPistol;
import fr.swokky.kinko.entities.projectiles.gomu.GomuNoPistolThird;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderGomuNoPistolThirdFactory implements IRenderFactory<GomuNoPistolThird> {

    public static final RenderGomuNoPistolThirdFactory INSTANCE = new RenderGomuNoPistolThirdFactory();


    @Override
    public Render<? super GomuNoPistolThird> createRenderFor(RenderManager manager) {
        return new RenderGomuNoPistolThird(manager);
    }
}

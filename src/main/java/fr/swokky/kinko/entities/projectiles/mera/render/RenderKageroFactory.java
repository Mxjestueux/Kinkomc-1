package fr.swokky.kinko.entities.projectiles.mera.render;

import fr.swokky.kinko.entities.projectiles.mera.Kagero;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderKageroFactory implements IRenderFactory<Kagero> {

    public static final RenderKageroFactory INSTANCE = new RenderKageroFactory();

    @Override
    public Render<? super Kagero> createRenderFor(RenderManager manager) {
        return new RenderKagero(manager);
    }
}

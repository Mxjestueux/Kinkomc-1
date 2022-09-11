package fr.swokky.kinko.entities.projectiles.mera.render;

import fr.swokky.kinko.entities.projectiles.mera.Higan;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHiganFactory implements IRenderFactory<Higan> {

    public static final RenderHiganFactory INSTANCE = new RenderHiganFactory();

    @Override
    public Render<? super Higan> createRenderFor(RenderManager manager) {
        return new RenderHigan(manager);
    }
}

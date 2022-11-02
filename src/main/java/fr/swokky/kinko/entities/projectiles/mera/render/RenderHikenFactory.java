package fr.swokky.kinko.entities.projectiles.mera.render;

import fr.swokky.kinko.entities.projectiles.mera.Higan;
import fr.swokky.kinko.entities.projectiles.mera.Hiken;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHikenFactory implements IRenderFactory<Hiken> {

    public static final RenderHikenFactory INSTANCE = new RenderHikenFactory();

    @Override
    public Render<? super Hiken> createRenderFor(RenderManager manager) {
        return new RenderHiken(manager);
    }
}

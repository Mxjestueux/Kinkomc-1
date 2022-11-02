package fr.swokky.kinko.entities.projectiles.mera.render;

import fr.swokky.kinko.entities.projectiles.mera.FlameBoom;
import fr.swokky.kinko.entities.projectiles.mera.Higan;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderFlameBoomFactory implements IRenderFactory<FlameBoom> {

    public static final RenderFlameBoomFactory INSTANCE = new RenderFlameBoomFactory();

    @Override
    public Render<? super FlameBoom> createRenderFor(RenderManager manager) {
        return new RenderFlameBoom(manager);
    }
}

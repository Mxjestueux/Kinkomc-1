package fr.swokky.kinko.init;

import fr.swokky.kinko.Main;
import fr.swokky.kinko.entities.projectiles.gomu.GomuNoPistol;
import fr.swokky.kinko.utils.References;
import fr.swokky.kinko.utils.handlers.ConfigHandler;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {

    public static void registerEntities()
    {
        registerProjectiles("GomuNoPistolAbility", ConfigHandler.ENTITY_GOMU_PISTOL, GomuNoPistol.class);
    }

    private static void registerProjectiles(String name, int id, Class<? extends Entity> entity)
    {
        EntityRegistry.registerModEntity(new ResourceLocation(References.MODID + ":" + name ), entity, name, id, Main.instance, 64, 10, true);
    }
}

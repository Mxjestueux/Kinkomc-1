package fr.swokky.kinko.init;

import fr.swokky.kinko.Main;
import fr.swokky.kinko.entities.projectiles.gomu.GomuNoPistol;
import fr.swokky.kinko.entities.projectiles.gomu.GomuNoPistolThird;
import fr.swokky.kinko.entities.projectiles.mera.FlameBoom;
import fr.swokky.kinko.entities.projectiles.mera.Higan;
import fr.swokky.kinko.entities.projectiles.mera.Hiken;
import fr.swokky.kinko.entities.projectiles.mera.Kagero;
import fr.swokky.kinko.utils.References;
import fr.swokky.kinko.utils.handlers.ConfigHandler;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {

    public static void registerEntities()
    {
        registerProjectiles("GomuNoPistolAbility", ConfigHandler.ENTITY_GOMU_PISTOL, GomuNoPistol.class);
        registerProjectiles("GomuNoPistolThirdAbility", ConfigHandler.ENTITY_GOMU_PISTOL_THIRD, GomuNoPistolThird.class);
        registerProjectiles("Higan", ConfigHandler.ENTITY_HIGAN, Higan.class);
        registerProjectiles("Kagero", ConfigHandler.ENTITY_KAGERO, Kagero.class);
        registerProjectiles("Hiken", ConfigHandler.ENTITY_HIKEN, Hiken.class);
        registerProjectiles("FlameBoom", ConfigHandler.ENTITY_FLAMEBOOM, FlameBoom.class);
    }

    private static void registerProjectiles(String name, int id, Class<? extends Entity> entity)
    {
        EntityRegistry.registerModEntity(new ResourceLocation(References.MODID + ":" + name ), entity, name, id, Main.instance, 64, 10, true);
    }
}

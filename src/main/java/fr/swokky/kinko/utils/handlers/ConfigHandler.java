package fr.swokky.kinko.utils.handlers;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {
    public static Configuration config;

    public static int ENTITY_GOMU_PISTOL = 250;
    public static int ENTITY_GOMU_PISTOL_THIRD = 251;

    public static void init(File file){
        config = new Configuration(file);
        String category;

        category = "Entity IDs";
        config.addCustomCategoryComment(category, "Set id's for each entity");
        ENTITY_GOMU_PISTOL = config.getInt("entity gomu no pistol", category,250, 250,500, "Entity Gomu No Pistol ID");
        ENTITY_GOMU_PISTOL_THIRD = config.getInt("entity gomu no pistol", category,251, 250,500, "Entity Gomu No Pistol Third ID");
    }
}

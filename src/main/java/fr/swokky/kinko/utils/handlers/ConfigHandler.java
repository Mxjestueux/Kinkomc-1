package fr.swokky.kinko.utils.handlers;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {
    public static Configuration config;

    public static int ENTITY_GOMU_PISTOL = 250;
    public static int ENTITY_GOMU_PISTOL_THIRD = 251;
    public static int ENTITY_HIGAN = 252;
    public static int ENTITY_KAGERO = 253;
    public static int ENTITY_HIKEN = 254;
    public static int ENTITY_FLAMEBOOM = 255;

    public static void init(File file){
        config = new Configuration(file);
        String category;

        category = "Entity IDs";
        config.addCustomCategoryComment(category, "Set id's for each entity");
        ENTITY_GOMU_PISTOL = config.getInt("entity gomu no pistol", category,250, 250,500, "Entity Gomu No Pistol ID");
        ENTITY_GOMU_PISTOL_THIRD = config.getInt("entity gomu no pistol", category,251, 250,500, "Entity Gomu No Pistol Third ID");
        ENTITY_HIGAN = config.getInt("entity higan", category, 252,250,500, "Entity Higan ID");
        ENTITY_KAGERO = config.getInt("entity kagero", category, 253,250,500, "Entity Kagero ID");
        ENTITY_HIKEN = config.getInt("entity hiken", category, 254,250,500,"Entity Hiken ID");
        ENTITY_FLAMEBOOM = config.getInt("entity flame boom", category ,255, 250, 500, "Entity Flame Boom id");
    }
}

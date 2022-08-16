package fr.swokky.kinko;

import fr.swokky.kinko.proxy.CommonProxy;
import fr.swokky.kinko.utils.References;
import fr.swokky.kinko.utils.handlers.RegistryHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = References.MODID, name= References.NAME, version = References.VERSION)
public class Main {

    @Mod.Instance
    public static Main instance;

    @SidedProxy(clientSide = References.CLIENT, serverSide = References.COMMON)
    public static CommonProxy proxy;

    public static org.apache.logging.log4j.Logger logger;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent e) {
        logger = e.getModLog();

        proxy.preInit();

        RegistryHandler.preInitRegistries();

    }
    @Mod.EventHandler
    public static void Init(FMLInitializationEvent e) {
        RegistryHandler.initRegistries();
    }
    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent e) {

    }
}

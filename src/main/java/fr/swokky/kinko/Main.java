package fr.swokky.kinko;

import fr.swokky.kinko.network.PacketActionNoMiMessage;
import fr.swokky.kinko.proxy.CommonProxy;
import fr.swokky.kinko.utils.References;
import fr.swokky.kinko.utils.handlers.RegistryHandler;
import fr.swokky.kinko.utils.handlers.RenderGuiHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;


@Mod(modid = References.MODID, name= References.NAME, version = References.VERSION)
public class Main {

    @Mod.Instance
    public static Main instance;

    public static SimpleNetworkWrapper network;

    @SidedProxy(clientSide = References.CLIENT, serverSide = References.COMMON)
    public static CommonProxy proxy;

    public static org.apache.logging.log4j.Logger logger;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent e) {
        logger = e.getModLog();
        proxy.preInit();
        proxy.registerEntityRenderer();
        RegistryHandler.preInitRegistries();

        network = NetworkRegistry.INSTANCE.newSimpleChannel("PacketActionNoMi");
        network.registerMessage(PacketActionNoMiMessage.Handler.class, PacketActionNoMiMessage.class, 1, Side.SERVER);
    }
    @Mod.EventHandler
    public static void Init(FMLInitializationEvent e) {
        RegistryHandler.initRegistries();
        proxy.init();
    }
    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(new RenderGuiHandler());
    }
}

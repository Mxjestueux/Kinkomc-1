package fr.swokky.kinko;

import fr.swokky.kinko.network.PacketActionNoMiMessage;
import fr.swokky.kinko.proxy.CommonProxy;
import fr.swokky.kinko.utils.References;
import fr.swokky.kinko.utils.handlers.RegistryHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Mod(modid = References.MODID, name= References.NAME, version = References.VERSION)
public class Main {

    public List<EntityPlayer> cooldownMainAbility = new ArrayList<EntityPlayer>();
    public List<Date> cooldownMainAbilityTime = new ArrayList<Date>();
    public List<EntityPlayer> cooldownSecondaryAbility = new ArrayList<EntityPlayer>();
    public List<Date> cooldownSecondaryAbilityTime = new ArrayList<Date>();

    @Mod.Instance
    public static Main instance;

    public static SimpleNetworkWrapper network;
    public static SimpleNetworkWrapper network2;

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

    }
}

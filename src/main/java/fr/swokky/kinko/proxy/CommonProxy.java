package fr.swokky.kinko.proxy;

import fr.swokky.kinko.capabilities.nomi.INoMiCapability;
import fr.swokky.kinko.capabilities.nomi.NoMiCapability;
import fr.swokky.kinko.capabilities.nomi.NoMiStorage;
import fr.swokky.kinko.utils.handlers.CapabilityHandler;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CommonProxy {

    public void registerItemRenderer(Item item,int meta){}
    public void registerVariantRenderer(Item item,int meta,String filename, String id){}
    public void registerEntityRenderer(){}
    public void registerGuis(){}
    public void preInit(){}
    public void init(){
        CapabilityManager.INSTANCE.register(INoMiCapability.class, new NoMiStorage(), NoMiCapability::new);
        MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
    }
}

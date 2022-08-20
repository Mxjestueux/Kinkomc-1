package fr.swokky.kinko.proxy;

import fr.swokky.kinko.capabilities.nomi.INoMi;
import fr.swokky.kinko.capabilities.nomi.NoMi;
import fr.swokky.kinko.capabilities.nomi.NoMiStorage;
import net.minecraft.item.Item;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CommonProxy {

    public void registerItemRenderer(Item item,int meta){}
    public void registerVariantRenderer(Item item,int meta,String filename, String id){}
    public void registerEntityRenderer(){}
    public void registerGuis(){}
    public void preInit(){
        CapabilityManager.INSTANCE.register(INoMi.class, new NoMiStorage(), NoMi::new);
    }
    public void init(){}
}

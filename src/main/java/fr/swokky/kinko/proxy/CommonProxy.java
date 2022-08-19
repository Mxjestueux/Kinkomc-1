package fr.swokky.kinko.proxy;

import net.minecraft.item.Item;

public class CommonProxy {

    public void registerItemRenderer(Item item,int meta){}
    public void registerVariantRenderer(Item item,int meta,String filename, String id){}
    public void registerEntityRenderer(){}
    public void registerGuis(){}
    public void preInit(){}
    public void init(){}
}

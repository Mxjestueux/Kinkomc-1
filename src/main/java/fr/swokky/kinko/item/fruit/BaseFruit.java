package fr.swokky.kinko.item.fruit;

import fr.swokky.kinko.init.ItemInit;
import fr.swokky.kinko.utils.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class BaseFruit  extends ItemFood implements IHasModel {


    public BaseFruit(String name, int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MISC);
        this.setMaxStackSize(1);
        ItemInit.ITEMS.add(this);
    }



    @Override
    public void registerModels() {

    }
}

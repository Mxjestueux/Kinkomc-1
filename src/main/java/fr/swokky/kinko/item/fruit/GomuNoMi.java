package fr.swokky.kinko.item.fruit;

import fr.swokky.kinko.Main;
import fr.swokky.kinko.capabilities.nomi.INoMi;
import fr.swokky.kinko.capabilities.nomi.NoMiProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.lwjgl.Sys;

public class GomuNoMi extends BaseFruit {

    public GomuNoMi(String name)
    {
        super(name,4,1.2F,false);
        this.setAlwaysEdible();
    }


    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this,0);
    }


    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        if(worldIn.isRemote) return;

        INoMi nomi = player.getCapability(NoMiProvider.NO_MI_CAPABILITY, null);

        System.out.println(nomi);

        super.onFoodEaten(stack,worldIn,player);
    }
}

package fr.swokky.kinko.item.fruit;

import fr.swokky.kinko.Main;
import fr.swokky.kinko.capabilities.nomi.INoMi;
import fr.swokky.kinko.capabilities.nomi.NoMi;
import fr.swokky.kinko.capabilities.nomi.NoMiStorage;
import fr.swokky.kinko.init.ItemInit;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.Objects;

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
        if(!worldIn.isRemote)
        {
            if(player.hasCapability(NoMiStorage.NO_MI_CAPABILITY, null) && player.getCapability(NoMiStorage.NO_MI_CAPABILITY, null) != null){
                player.setHealth(0);
            } else {
                player.getCapability(NoMiStorage.NO_MI_CAPABILITY, null).setNoMi("gomu");
            }

        }
        super.onFoodEaten(stack,worldIn,player);
    }
}

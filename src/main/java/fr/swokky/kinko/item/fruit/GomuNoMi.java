package fr.swokky.kinko.item.fruit;

import fr.swokky.kinko.Main;
import fr.swokky.kinko.capabilities.nomi.INoMi;
import fr.swokky.kinko.capabilities.nomi.NoMiProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

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

        if(!(nomi.getNoMi().equals(""))){
            player.setHealth(0);
            String message = player.getDisplayNameString() + " a essayé de manger un deuxième fruit du démon ! Il n'est plus le possesseur du " + nomi.getNoMi() + " no mi et du gomu no mi" ;
            player.getServer().getPlayerList().sendMessage(new TextComponentString(message));
        } else {
            nomi.setNoMi("gomu");
            String message = player.getDisplayNameString() + " est le nouveau possesseur du gomu no mi !";
            player.getServer().getPlayerList().sendMessage(new TextComponentString(message));
            Minecraft minecraft = Minecraft.getMinecraft();
            minecraft.effectRenderer.emitParticleAtEntity(player, EnumParticleTypes.TOTEM, 30);
            minecraft.entityRenderer.displayItemActivation(new ItemStack(this));
        }
        super.onFoodEaten(stack,worldIn,player);
    }
}

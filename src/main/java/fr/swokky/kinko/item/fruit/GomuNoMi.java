package fr.swokky.kinko.item.fruit;

import fr.swokky.kinko.Main;
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
            NBTTagCompound tag = player.getEntityData();
            NBTBase modeTag = tag.getTag("no_mi");
            Database db = Databases.getDatabase("votre_database");
            System.out.println(tag);
            if(modeTag != null){
                ITextComponent component = new TextComponentString("Vous êtes déjà le possesseur du " + modeTag.toString().split("\"")[1] + " no mi");
                player.sendMessage(component);
                worldIn.spawnEntity(new EntityItem(worldIn, player.posX, player.posY + 1, player.posZ, new ItemStack(ItemInit.GOMU_NO_MI)));
            } else {
                MinecraftServer server = worldIn.getMinecraftServer();
                ITextComponent component = new TextComponentString(player.getName() + " est maintenant le possesseur du fruit du gum gum");
                server.getPlayerList().sendMessage(component);
                tag.setString("no_mi", "gomu");
            }
        }
        super.onFoodEaten(stack,worldIn,player);
    }
}

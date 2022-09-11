package fr.swokky.kinko.utils.handlers;

import fr.swokky.kinko.capabilities.nomi.NoMiProvider;
import fr.swokky.kinko.init.PotionInit;
import fr.swokky.kinko.utils.hashmap.DevilFruitHashMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class PlayerEventHandler {

    public static void onConnect(PlayerEvent.PlayerLoggedInEvent event){
        EntityPlayer player = event.player;
        String noMi = player.getCapability(NoMiProvider.NO_MI_CAPABILITY, null).getNoMi();
        if(noMi.equals("")) return;
        if(DevilFruitHashMap.devilFruit.containsKey(player.getUniqueID())) return;
        DevilFruitHashMap.devilFruit.put(player.getUniqueID(), noMi);
    }

    public static void onDeath(LivingDeathEvent event){
        if(!(event.getEntity() instanceof EntityPlayer)) return;
        EntityPlayer player = (EntityPlayer) event.getEntity();
        if(!(DevilFruitHashMap.devilFruit.containsKey(player.getUniqueID()))) return;
        String message = player.getDisplayNameString() + " n'est plus le possesseur du " + DevilFruitHashMap.devilFruit.get(player.getUniqueID());
        DevilFruitHashMap.devilFruit.remove(player.getUniqueID());
        player.getServer().getPlayerList().sendMessage(new TextComponentString(message));
    }
}

package fr.swokky.kinko.utils.handlers;

import fr.swokky.kinko.capabilities.nomi.NoMiProvider;
import fr.swokky.kinko.utils.hashmap.DevilFruitHashMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import java.util.HashMap;

public class PlayerEventHandler {

    public static void onConnect(PlayerEvent.PlayerLoggedInEvent event){
        EntityPlayer player = event.player;
        String noMi = player.getCapability(NoMiProvider.NO_MI_CAPABILITY, null).getNoMi();
        if(noMi.isEmpty()) return;
        if(DevilFruitHashMap.devilFruit.containsKey(player.getUniqueID())) return;
        DevilFruitHashMap.devilFruit.put(player.getUniqueID(), noMi);
    }

    public static void onDeath(LivingDeathEvent event){
        if(!(event.getEntity() instanceof EntityPlayer)) return;
        EntityPlayer player = (EntityPlayer) event.getEntity();
        String noMi = player.getCapability(NoMiProvider.NO_MI_CAPABILITY, null).getNoMi();
        if(noMi.isEmpty()) return;
        if(!(DevilFruitHashMap.devilFruit.containsKey(player.getUniqueID()))) return;
        DevilFruitHashMap.devilFruit.remove(player.getUniqueID(), noMi);
        String message = player.getDisplayNameString() + " n'est plus le possesseur du " + noMi;
        player.getServer().getPlayerList().sendMessage(new TextComponentString(message));
    }
}

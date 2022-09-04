package fr.swokky.kinko.utils.hashmap;

import net.minecraft.entity.player.EntityPlayer;

import java.util.Date;
import java.util.HashMap;

public class CooldownHashMap {

    public final static HashMap<EntityPlayer, Long> mainAbilityCD = new HashMap<>();
    public final static HashMap<EntityPlayer, Long> secondAbilityCD = new HashMap<>();
    public final static HashMap<EntityPlayer, Long> thirdAbilityCD = new HashMap<>();
    public final static HashMap<EntityPlayer, Long> fourthAbilityCD = new HashMap<>();


    public static void addElement(EntityPlayer player, long time, HashMap<EntityPlayer, Long> map){
        map.put(player, time);
    }

    public static void removeElement(EntityPlayer player,HashMap<EntityPlayer, Long> map){
        map.remove(player);
    }

    public static int getCooldown(EntityPlayer player, HashMap<EntityPlayer, Long> map, int maxCooldown){
        long now = new Date().getTime();
        return (maxCooldown - (int) (now - map.get(player)))/1000;
    }
}

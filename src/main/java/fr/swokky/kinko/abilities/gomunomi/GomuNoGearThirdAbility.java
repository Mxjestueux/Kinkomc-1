package fr.swokky.kinko.abilities.gomunomi;

import fr.swokky.kinko.Main;
import fr.swokky.kinko.abilities.CooldownAbility;
import fr.swokky.kinko.init.PotionInit;
import fr.swokky.kinko.utils.api.Config;
import fr.swokky.kinko.utils.hashmap.CooldownHashMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextComponentString;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class GomuNoGearThirdAbility extends CooldownAbility {

    private final int maxCD = 600000;

    public GomuNoGearThirdAbility(EntityPlayer player) {
        super("gomunogearsecond", Config.AbilityCategory.DEVIL);
        this.onUse(player, isOnCooldown(player), Config.AbilityType.COOLDOWN);
    }

    @Override
    public void onUse(EntityPlayer player, Boolean isOnCooldown, Config.AbilityType type){
        if (player.world.isRemote) return;
        if (isOnCooldown) {
            player.sendMessage(new TextComponentString("This ability is on cooldown of " + getCooldown(player) + "seconds"));
            return;
        }
        if(type == Config.AbilityType.DISABLED) return;
        player.addPotionEffect(new PotionEffect(PotionInit.GOMU_NO_GEAR_THIRD_EFFECT, 2400));
        add(player);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                remove(player);
            }
        }, maxCD);
    }

    @Override
    public boolean isOnCooldown(EntityPlayer player) {
        return CooldownHashMap.fourthAbilityCD.containsKey(player);
    }

    private void remove(EntityPlayer player){
        CooldownHashMap.removeElement(player, CooldownHashMap.fourthAbilityCD);
    }

    private void add(EntityPlayer player){
        CooldownHashMap.addElement(player, new Date().getTime() ,CooldownHashMap.fourthAbilityCD);
    }

    @Override
    public int getCooldown(EntityPlayer player){
        return CooldownHashMap.getCooldown(player, CooldownHashMap.fourthAbilityCD,maxCD);
    }
}

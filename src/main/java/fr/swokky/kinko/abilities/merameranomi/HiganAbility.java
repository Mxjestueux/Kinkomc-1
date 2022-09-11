package fr.swokky.kinko.abilities.merameranomi;

import fr.swokky.kinko.abilities.CooldownAbility;
import fr.swokky.kinko.abilities.ThrowableAbility;
import fr.swokky.kinko.entities.projectiles.AbilityProjectilesEntity;
import fr.swokky.kinko.entities.projectiles.mera.Higan;
import fr.swokky.kinko.utils.api.Config;
import fr.swokky.kinko.utils.hashmap.CooldownHashMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class HiganAbility extends ThrowableAbility {

    private final int maxCD = 30000;

    public HiganAbility(EntityPlayer player) {
        super("higan", Config.AbilityCategory.DEVIL);
        this.onUse(player, isOnCooldown(player), Config.AbilityType.COOLDOWN);
    }

    @Override
    public void onUse(EntityPlayer player, Boolean isOnCooldown, Config.AbilityType type) {
        if(!checkWorld(player, isOnCooldown, type)) return;
        Vec3d look = player.getLookVec();
        entitySpawn(player,look);
        add(player);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                remove(player);
            }
        }, maxCD);
    }



    private void entitySpawn(EntityPlayer player, Vec3d look)
    {
        newTaskPeriodic(new TimerTask() {
            @Override
            public void run() {
                AbilityProjectilesEntity entity = new Higan(player.getEntityWorld(), 1.0d, 1.0d, 1.0d);
                entity.setPosition(player.posX + look.x * 1.5D, player.posY + 1D + look.y * 1.5D, player.posZ + look.z * 1.5D);
                entity.setNoGravity(true);
                entity.shoot(player, player.rotationPitch, player.rotationYaw, 0, 1, 0);
                entity.setDamage(2);
                player.world.spawnEntity(entity);
            }
        },3,50);
    }

    @Override
    public boolean isOnCooldown(EntityPlayer player) {
        return CooldownHashMap.mainAbilityCD.containsKey(player);
    }

    private void remove(EntityPlayer player){
        CooldownHashMap.removeElement(player, CooldownHashMap.mainAbilityCD);
    }

    private void add(EntityPlayer player){
        CooldownHashMap.addElement(player, new Date().getTime() ,CooldownHashMap.mainAbilityCD);
    }

    @Override
    public int getCooldown(EntityPlayer player){
        return CooldownHashMap.getCooldown(player,CooldownHashMap.mainAbilityCD,maxCD);
    }
}

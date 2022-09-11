package fr.swokky.kinko.abilities.merameranomi;

import fr.swokky.kinko.abilities.ThrowableAbility;
import fr.swokky.kinko.entities.projectiles.AbilityProjectilesEntity;
import fr.swokky.kinko.entities.projectiles.mera.Higan;
import fr.swokky.kinko.entities.projectiles.mera.Kagero;
import fr.swokky.kinko.utils.api.Config;
import fr.swokky.kinko.utils.hashmap.CooldownHashMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class KageroAbility extends ThrowableAbility {

    private final int maxCD = 90000;

    public KageroAbility(EntityPlayer player) {
        super("kagero", Config.AbilityCategory.DEVIL);
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
        AbilityProjectilesEntity entity = new Kagero(player.getEntityWorld(), 1.0d, 1.0d, 1.0d);
        entity.setPosition(player.posX + look.x * 1.5D, player.posY + 1D + look.y * 1.5D, player.posZ + look.z * 1.5D);
        entity.setNoGravity(true);
        entity.shoot(player, player.rotationPitch, player.rotationYaw, 0, 1, 0);
        entity.setDamage(5);
        player.world.spawnEntity(entity);
    }


    @Override
    public boolean isOnCooldown(EntityPlayer player) {
        return CooldownHashMap.secondAbilityCD.containsKey(player);
    }

    private void remove(EntityPlayer player){
        CooldownHashMap.removeElement(player, CooldownHashMap.secondAbilityCD);
    }

    private void add(EntityPlayer player){
        CooldownHashMap.addElement(player, new Date().getTime() ,CooldownHashMap.secondAbilityCD);
    }

    @Override
    public int getCooldown(EntityPlayer player){
        return CooldownHashMap.getCooldown(player,CooldownHashMap.secondAbilityCD,maxCD);
    }
}

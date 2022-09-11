package fr.swokky.kinko.abilities.gomunomi;

import fr.swokky.kinko.abilities.ThrowableAbility;
import fr.swokky.kinko.entities.projectiles.AbilityProjectilesEntity;
import fr.swokky.kinko.entities.projectiles.gomu.GomuNoPistol;
import fr.swokky.kinko.entities.projectiles.gomu.GomuNoPistolThird;
import fr.swokky.kinko.init.PotionInit;
import fr.swokky.kinko.utils.api.Config;
import fr.swokky.kinko.utils.hashmap.CooldownHashMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class GomuNoPistolAbility extends ThrowableAbility {

    private final int maxCD = 20000;


    public GomuNoPistolAbility(EntityPlayer player){
        super("gomunopistol", Config.AbilityCategory.DEVIL);
        this.onUse(player, isOnCooldown(player), Config.AbilityType.COOLDOWN);
    }


    @Override
    public void onUse(EntityPlayer player, Boolean isOnCooldown, Config.AbilityType type) {
        if(!(checkWorld(player, isOnCooldown, type))) return;
        Vec3d look = player.getLookVec();

        AbilityProjectilesEntity entity = getEntity(player);

        entity.setDamage(getDamage(entity, player));
        entity.setPosition(player.posX + look.x * 1.5D, player.posY + 1D + look.y * 1.5D, player.posZ + look.z * 1.5D);
        entity.setNoGravity(true);
        entity.shoot(player, player.rotationPitch, player.rotationYaw, 0, 1, 0);

        player.world.spawnEntity(entity);
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

    private AbilityProjectilesEntity getEntity(EntityPlayer player){
        return player.isPotionActive(PotionInit.GOMU_NO_GEAR_THIRD_EFFECT) ? new GomuNoPistolThird(player.getEntityWorld(), 1.0d, 1.0d, 1.0d) : new GomuNoPistol(player.getEntityWorld(), 1.0d, 1.0d, 1.0d);
    }
    private int getDamage(AbilityProjectilesEntity entity, EntityPlayer player){
        if(entity instanceof GomuNoPistolThird){
            return player.isPotionActive(PotionInit.GOMU_NO_GEAR_SECOND_EFFECT) ? 10 : 7;
        }
        return player.isPotionActive(PotionInit.GOMU_NO_GEAR_SECOND_EFFECT) ? 5 : 3;
    }
}
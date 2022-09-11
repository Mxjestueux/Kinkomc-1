package fr.swokky.kinko.abilities.gomunomi;

import fr.swokky.kinko.abilities.CooldownAbility;
import fr.swokky.kinko.abilities.ThrowableAbility;
import fr.swokky.kinko.entities.projectiles.AbilityProjectilesEntity;
import fr.swokky.kinko.entities.projectiles.gomu.GomuNoPistol;
import fr.swokky.kinko.entities.projectiles.gomu.GomuNoPistolThird;
import fr.swokky.kinko.init.PotionInit;
import fr.swokky.kinko.utils.api.Config;
import fr.swokky.kinko.utils.hashmap.CooldownHashMap;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class GomuNoGatlingAbility extends ThrowableAbility {

    private final int maxCD = 60000;

    public GomuNoGatlingAbility(EntityPlayer player) {
        super("gomunogatling", Config.AbilityCategory.DEVIL);
        this.onUse(player, isOnCooldown(player), Config.AbilityType.COOLDOWN);
    }

    @Override
    public void onUse(EntityPlayer player, Boolean isOnCooldown, Config.AbilityType type) {
        if(!(checkWorld(player, isOnCooldown, type))) return;
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

    private void entitySpawn(EntityPlayer player, Vec3d look){
        newTaskPeriodic(new TimerTask() {
            @Override
            public void run() {
                int randX = (getRandomNumberInRange(0, 3) - 2) / 2;
                int randY = (getRandomNumberInRange(0, 3) - 2) / 2;
                int randZ = (getRandomNumberInRange(0, 3) - 2) / 2;
                AbilityProjectilesEntity entity = getEntity(player);
                entity.setPosition(player.posX + look.x * 1.5D + randX, player.posY + 1D + look.y * 1.5D + randY, player.posZ + look.z * 1.5D + randZ);
                entity.setNoGravity(true);
                entity.shoot(player, player.rotationPitch, player.rotationYaw, 0, 1, 0);
                entity.setDamage(getDamage(entity, player));
                player.world.spawnEntity(entity);
            }
        },5,11);
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

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return (int) (Math.random() * ((max - min) + 1)) + min;
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
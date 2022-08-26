package fr.swokky.kinko.abilities.gomunomi;

import fr.swokky.kinko.Main;
import fr.swokky.kinko.abilities.CooldownAbilities;
import fr.swokky.kinko.entities.projectiles.gomu.GomuNoPistol;
import fr.swokky.kinko.utils.api.Config;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;

import java.util.*;

public class GomuNoGatlingAbility extends CooldownAbilities {

    public GomuNoGatlingAbility(EntityPlayer player){
        super("gomunogatling");
        this.onUse(player, isOnCooldown(player), Config.AbilityType.COOLDOWN);
    }

    @Override
    public void onUse(EntityPlayer player, Boolean isOnCooldown, Config.AbilityType type){
        if(player.world.isRemote) return;
        if(isOnCooldown) {
            player.sendMessage(new TextComponentString("This ability is on cooldown of " + getCooldown(player) + "seconds"));
            return;
        }
        Vec3d look = player.getLookVec();
        BlockPos pos = new BlockPos(player.posX +look.x, player.posY +1+ look.y, player.posZ + look.z);
        if(player.world.getBlockState(pos).getBlock() != Block.getBlockById(0)) return;
        if(type == Config.AbilityType.DISABLED) return;
        for(int i = 0; i<5; i++){
            int randX = (getRandomNumberInRange(0,3)-2)/2;
            int randY = (getRandomNumberInRange(0,3)-2)/2;
            int randZ = (getRandomNumberInRange(0,3)-2)/2;
            GomuNoPistol entity = new GomuNoPistol(player.getEntityWorld(), 1.0d,1.0d,1.0d);
            entity.setPosition(player.posX + look.x * 1.5D +randX, player.posY + 1D + look.y * 1.5D+randY, player.posZ + look.z * 1.5D+randZ);
            entity.setNoGravity(true);
            entity.shoot(player, player.rotationPitch, player.rotationYaw, 0, 1, 0);
            player.world.spawnEntity(entity);
            try {
                Thread.sleep(11);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        add(player);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                remove(player);
            }
        }, 40000);
    }

    @Override
    public boolean isOnCooldown(EntityPlayer player) {
        List<EntityPlayer> cooldown = Main.instance.cooldownSecondaryAbility;
        for(EntityPlayer p : cooldown){
            if(p == player){
                return true;
            }
        }
        return false;
    }

    private void remove(EntityPlayer player){
        int index = Main.instance.cooldownSecondaryAbility.lastIndexOf(player);
        Main.instance.cooldownSecondaryAbility.remove(player);
        Main.instance.cooldownSecondaryAbilityTime.remove(index);
    }

    private void add(EntityPlayer player){
        Main.instance.cooldownSecondaryAbility.add(player);
        Main.instance.cooldownSecondaryAbilityTime.add(new Date());
    }

    private int getCooldown(EntityPlayer player){
        int index = Main.instance.cooldownSecondaryAbility.lastIndexOf(player);
        long time = Main.instance.cooldownSecondaryAbilityTime.get(index).getTime();
        long now = new Date().getTime();
        return 40 - (int) (now - time)/1000;
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return (int)(Math.random() * ((max - min) + 1)) + min;
    }
}

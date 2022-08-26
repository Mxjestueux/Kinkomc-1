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

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class GomuNoPistolAbility extends CooldownAbilities {


    public GomuNoPistolAbility(EntityPlayer player){
        super("gomunopistol");
        this.onUse(player, isOnCooldown(player), Config.AbilityType.COOLDOWN);
    }


    @Override
    public void onUse(EntityPlayer player, Boolean isOnCooldown, Config.AbilityType type) {
        if(player.world.isRemote) return;
        if(isOnCooldown) {
            player.sendMessage(new TextComponentString("This ability is on cooldown of " + getCooldown(player) + "seconds"));
            return;
        }
        Vec3d look = player.getLookVec();
        BlockPos pos = new BlockPos(player.posX +look.x, player.posY +1+ look.y, player.posZ + look.z);
        if(player.world.getBlockState(pos).getBlock() != Block.getBlockById(0)) return;
        if(type == Config.AbilityType.DISABLED) return;
        fr.swokky.kinko.entities.projectiles.gomu.GomuNoPistol entity = new fr.swokky.kinko.entities.projectiles.gomu.GomuNoPistol(player.getEntityWorld(), 1.0d,1.0d,1.0d);
        entity.setPosition(player.posX + look.x * 1.5D, player.posY + 1D + look.y * 1.5D, player.posZ + look.z * 1.5D);
        entity.setNoGravity(true);
        entity.shoot(player, player.rotationPitch, player.rotationYaw, 0, 2, 0);
        player.world.spawnEntity(entity);
        add(player);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                remove(player);
            }
        }, 15000);
    }

    @Override
    public boolean isOnCooldown(EntityPlayer player) {
        List<EntityPlayer> cooldown = Main.instance.cooldownMainAbility;
        for(EntityPlayer p : cooldown){
            if(p == player){
                return true;
            }
        }
        return false;
    }

    private void remove(EntityPlayer player){
        int index = Main.instance.cooldownMainAbility.lastIndexOf(player);
        Main.instance.cooldownMainAbility.remove(player);
        Main.instance.cooldownMainAbilityTime.remove(index);
    }

    private void add(EntityPlayer player){
        Main.instance.cooldownMainAbility.add(player);
        Main.instance.cooldownMainAbilityTime.add(new Date());
    }

    private int getCooldown(EntityPlayer player){
        int index = Main.instance.cooldownMainAbility.lastIndexOf(player);
        long time = Main.instance.cooldownMainAbilityTime.get(index).getTime();
        long now = new Date().getTime();
        return 15 - (int) (now - time)/1000;
    }
}

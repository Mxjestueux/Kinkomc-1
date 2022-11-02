package fr.swokky.kinko.abilities.merameranomi;

import fr.swokky.kinko.abilities.CooldownAbility;
import fr.swokky.kinko.entities.projectiles.mera.FlameBoom;
import fr.swokky.kinko.init.PotionInit;
import fr.swokky.kinko.utils.api.Config;
import fr.swokky.kinko.utils.hashmap.CooldownHashMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class FlameCallAbility extends CooldownAbility {

    private final int maxCD = 600000;

    public FlameCallAbility(EntityPlayer player) {
        super("flamecall", Config.AbilityCategory.DEVIL);
        this.onUse(player, isOnCooldown(player), Config.AbilityType.COOLDOWN);
    }

    @Override
    public void onUse(EntityPlayer player, Boolean isOnCooldown, Config.AbilityType type){
        if (checkWorld(player, isOnCooldown(player), type)) return;
        player.addPotionEffect(new PotionEffect(Potion.getPotionById(25),10,10));
        play(player);
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

    private void play(EntityPlayer player){
        BlockPos pos = player.getPosition();

        BlockPos minPos = new BlockPos(pos.getX()-10, pos.getY()-1, pos.getZ()-10);
        BlockPos maxPos = new BlockPos(pos.getX()+10, pos.getY()+2, pos.getZ()+10);

        List<Entity> entities = player.world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(minPos,maxPos));

        Entity entity = new FlameBoom(player.world);
        entity.setInvisible(true);
        entity.setPosition(pos.getX(),pos.getY(),pos.getZ());

        player.world.spawnEntity(entity);


        for(Entity e : entities){
            if(e == player) return;
            e.setFire(10);
        }

        player.addPotionEffect(new PotionEffect(Potion.getPotionById(25),10,10));
    }
}

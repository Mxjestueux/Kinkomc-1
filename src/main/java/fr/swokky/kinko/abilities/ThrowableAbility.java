package fr.swokky.kinko.abilities;

import fr.swokky.kinko.utils.api.Config;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;

import java.util.Timer;
import java.util.TimerTask;

public class ThrowableAbility extends CooldownAbility{


    public ThrowableAbility(String name, Config.AbilityCategory category) {
        super(name, category);
    }

    public void newTaskPeriodic(TimerTask task, long repetition, long delay){
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(task,0,delay);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                timer.cancel();
            }
        }, repetition*delay);
    }

    @Override
    public boolean checkWorld(EntityPlayer player, Boolean isOnCooldown, Config.AbilityType type) {
        if (player.world.isRemote) return false;
        if (isOnCooldown) {
            player.sendMessage(new TextComponentString("This ability is on cooldown of " + getCooldown(player) + "seconds"));
            return false;
        }
        Vec3d look = player.getLookVec();
        BlockPos pos = new BlockPos(player.posX + look.x, player.posY + 1 + look.y, player.posZ + look.z);
        if (player.world.getBlockState(pos).getBlock() != Block.getBlockById(0)) return false;
        return type != Config.AbilityType.DISABLED;
    }
}

package fr.swokky.kinko.abilities;

import fr.swokky.kinko.utils.api.Config;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;

public class CooldownAbility extends Ability {

    public CooldownAbility(String name, Config.AbilityCategory category) {
        super(name, category);
        setType(Config.AbilityType.COOLDOWN);
    }

    public boolean checkWorld(EntityPlayer player, Boolean isOnCooldown, Config.AbilityType type) {
        if (player.world.isRemote) return true;
        if (isOnCooldown) {
            player.sendMessage(new TextComponentString("This ability is on cooldown of " + getCooldown(player) + "seconds"));
            return true;
        }
        return type == Config.AbilityType.DISABLED;
    }
}

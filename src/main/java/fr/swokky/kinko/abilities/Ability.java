package fr.swokky.kinko.abilities;


import fr.swokky.kinko.utils.api.Config;
import fr.swokky.kinko.utils.api.Config.AbilityCategory;
import fr.swokky.kinko.utils.api.Config.AbilityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class Ability{

    private String name = "";
    private String description = "";
    protected double cooldown;
    protected double maxCooldown;

    private AbilityCategory category = AbilityCategory.ALL;
    private AbilityType type = AbilityType.DISABLED;


    public Ability(String name, AbilityCategory category){
        this.name = name;
        this.category = category;
    }

    public void onUse(EntityPlayer player, Boolean isOnCooldown, AbilityType type) throws InterruptedException {
    }

    public boolean isOnCooldown(EntityPlayer player){
        return false;
    }

    public void setType(AbilityType type) {
        this.type = type;
    }

    public AbilityType getType() {
        return type;
    }
}

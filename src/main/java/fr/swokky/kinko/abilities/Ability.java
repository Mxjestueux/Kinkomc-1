package fr.swokky.kinko.abilities;


import fr.swokky.kinko.utils.api.Config.AbilityCategory;
import fr.swokky.kinko.utils.api.Config.AbilityType;
import fr.swokky.kinko.utils.hashmap.CooldownHashMap;
import net.minecraft.entity.player.EntityPlayer;

public class Ability{

    private final String name;
    protected double cooldown;
    protected double maxCooldown;

    private AbilityCategory category = AbilityCategory.ALL;
    private AbilityType type = AbilityType.DISABLED;


    public Ability(String name, AbilityCategory category){
        this.name = name;
        this.category = category;
    }

    public void onUse(EntityPlayer player, Boolean isOnCooldown, AbilityType type){
    }

    public boolean isOnCooldown(EntityPlayer player) {
        return CooldownHashMap.fourthAbilityCD.containsKey(player);
    }

    public int getCooldown(EntityPlayer player){
        return 0;
    }

    public void setType(AbilityType type) {
        this.type = type;
    }

    public String getName(){
        return this.name;
    }
}
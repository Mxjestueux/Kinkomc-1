package fr.swokky.kinko.abilities;

import fr.swokky.kinko.utils.api.Config;

public class CooldownAbilities extends Ability{


    public CooldownAbilities(String name) {
        super(name, Config.AbilityCategory.DEVIL);
        setType(Config.AbilityType.COOLDOWN);
    }
}

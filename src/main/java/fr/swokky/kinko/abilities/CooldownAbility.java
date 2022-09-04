package fr.swokky.kinko.abilities;

import fr.swokky.kinko.utils.api.Config;

public class CooldownAbility extends Ability {

    public CooldownAbility(String name, Config.AbilityCategory category) {
        super(name, category);
        setType(Config.AbilityType.COOLDOWN);
    }
}

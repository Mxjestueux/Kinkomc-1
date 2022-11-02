package fr.swokky.kinko.item.fruit;

import fr.swokky.kinko.Main;
import fr.swokky.kinko.abilities.Ability;
import fr.swokky.kinko.abilities.gomunomi.GomuNoGatlingAbility;
import fr.swokky.kinko.abilities.gomunomi.GomuNoGearSecondAbility;
import fr.swokky.kinko.abilities.gomunomi.GomuNoGearThirdAbility;
import fr.swokky.kinko.abilities.gomunomi.GomuNoPistolAbility;
import fr.swokky.kinko.utils.api.Config;
import fr.swokky.kinko.utils.interfaces.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class GomuNoMi extends BaseFruit implements IHasModel {

    public GomuNoMi(String name) {
        super(name, 4, 1.2F, false, Config.DevilType.PARAMECIA_SPECIAL, true, "Gomu Gomu No Mi");
        this.setAlwaysEdible();
    }


    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0);
    }

    @Override
    protected void onFoodEaten(@Nonnull ItemStack stack, World worldIn, @Nonnull EntityPlayer player) {
        super.onFoodEaten(stack, worldIn, player);
    }

    @Override
    public Map<String, Class<? extends Ability>> initAbilities() {
        final Map<String, Class<? extends Ability>> abilities = new HashMap<>();
        abilities.put("Attack", GomuNoPistolAbility.class);
        abilities.put("Special", GomuNoGatlingAbility.class);
        abilities.put("Special_Second", GomuNoGearSecondAbility.class);
        abilities.put("Special_Third", GomuNoGearThirdAbility.class);
        return abilities;
    }
}

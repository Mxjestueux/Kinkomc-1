package fr.swokky.kinko.item.fruit;

import fr.swokky.kinko.abilities.Ability;
import fr.swokky.kinko.capabilities.nomi.INoMiCapability;
import fr.swokky.kinko.capabilities.nomi.NoMiProvider;
import fr.swokky.kinko.init.ItemInit;
import fr.swokky.kinko.utils.api.Config.DevilType;
import fr.swokky.kinko.utils.hashmap.DevilFruitHashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.Map;

public abstract class BaseFruit extends ItemFood {

    private final String name;
    private final String registry_name;
    private final DevilType type;
    private final boolean hasPassive;

    private final Map<String,Class<? extends Ability>> abilities;

    public BaseFruit(String name, int amount, float saturation, boolean isWolfFood, DevilType type, Boolean hasPassive, String displayName) {
        super(amount, saturation, isWolfFood);
        this.name = displayName;
        this.type = type;
        this.registry_name = name;
        this.abilities = initAbilities();
        this.hasPassive = hasPassive;
        this.setMaxStackSize(1);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MISC);
        ItemInit.ITEMS.add(this);
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        if (worldIn.isRemote) return;

        INoMiCapability nomi = player.getCapability(NoMiProvider.NO_MI_CAPABILITY, null);

        assert nomi != null;
        if (nomi.getNoMi().isEmpty()) {
            nomi.setNoMi(this.registry_name);
            DevilFruitHashMap.devilFruit.put(player.getUniqueID(), this.registry_name);
            StringBuilder message = new StringBuilder().append(player.getDisplayNameString()).append(" est le nouveau possesseur du ").append(this.name);
            player.getServer().getPlayerList().sendMessage(new TextComponentString(message.toString()));
            Minecraft minecraft = Minecraft.getMinecraft();
            minecraft.effectRenderer.emitParticleAtEntity(player, EnumParticleTypes.TOTEM, 30);
            minecraft.entityRenderer.displayItemActivation(new ItemStack(this));
        } else {
            player.setHealth(0);
            String message = player.getDisplayNameString() + " a essayé de manger un deuxième fruit du démon ! Il n'est plus le possesseur du " + nomi.getNoMi() + " et du "+ this.name;
            player.getServer().getPlayerList().sendMessage(new TextComponentString(message));
        }
        super.onFoodEaten(stack, worldIn, player);
    }

    protected abstract Map<String, Class<? extends Ability>> initAbilities();
    public Map<String, Class<? extends Ability>> getAbilities(){
     return this.abilities;
    }
    public Class<? extends Ability> getAbility(String key){
        return this.abilities.get(key);
    }
}

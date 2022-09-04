package fr.swokky.kinko.init;

import fr.swokky.kinko.potion.CustomPotion;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class PotionInit
{
    public static final Potion GOMU_NO_GEAR_SECOND_EFFECT = new CustomPotion("gomu_no_gear_second", false, 13791173,0,0)
            .registerPotionAttributeModifier(SharedMonsterAttributes.MOVEMENT_SPEED, MathHelper.getRandomUUID().toString(), 0.20000000298023224D,2)
            .registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_DAMAGE, MathHelper.getRandomUUID().toString(), 1.0d,2);
    public static final PotionType GOMU_NO_GEAR_SECOND = new PotionType("gomu_no_gear_second", new PotionEffect(GOMU_NO_GEAR_SECOND_EFFECT,1200)).setRegistryName("gomu_no_gear_second");

    public static final Potion GOMU_NO_GEAR_THIRD_EFFECT = new CustomPotion("gomu_no_gear_third", false, 13791173,0,1)
            .registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_DAMAGE, MathHelper.getRandomUUID().toString(), 1.0d,2);
    public static final PotionType GOMU_NO_GEAR_THIRD = new PotionType("gomu_no_gear_third", new PotionEffect(GOMU_NO_GEAR_THIRD_EFFECT,2400)).setRegistryName("gomu_no_gear_third");



    public static void registerPotions()
    {
        registerPotion(GOMU_NO_GEAR_SECOND,GOMU_NO_GEAR_SECOND_EFFECT);
        registerPotion(GOMU_NO_GEAR_THIRD,GOMU_NO_GEAR_THIRD_EFFECT);
    }

    private static void registerPotion(PotionType defaultPotion, Potion effect)
    {
        ForgeRegistries.POTIONS.register(effect);
        ForgeRegistries.POTION_TYPES.register(defaultPotion);
    }
}

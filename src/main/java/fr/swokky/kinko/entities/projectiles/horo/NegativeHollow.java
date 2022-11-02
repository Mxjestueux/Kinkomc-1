package fr.swokky.kinko.entities.projectiles.horo;

import fr.swokky.kinko.entities.projectiles.AbilityProjectilesEntity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class NegativeHollow extends AbilityProjectilesEntity {

    int timer = 0;
    int timerMax = 10;

    public NegativeHollow(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
        this.setDamage(3);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);
        if(!(result.entityHit instanceof EntityLivingBase)) return;
        EntityLivingBase entity = (EntityLivingBase) result.entityHit;
        entity.addPotionEffect(new PotionEffect(Potion.getPotionById(2),10,1));
        entity.addPotionEffect(new PotionEffect(Potion.getPotionById(15),10,1));
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, BlockPos pos, Random rand) {
        for (int i = 0; i < 4; ++i) {
            double x = pos.getX() + rand.nextFloat();
            double y = pos.getY() + rand.nextFloat();
            double z = pos.getZ() + rand.nextFloat();
            double d3 = (rand.nextFloat() - 0.5) * 0.5;
            double d4 = (rand.nextFloat() - 0.5) * 0.5;
            double d5 = (rand.nextFloat() - 0.5) * 0.5;

            world.spawnParticle(EnumParticleTypes.SNOWBALL , x, y, z, d3, d4, d5);
        }
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        timer++;
        if(timer>timerMax){
            setDead();
            timer = 0;
        }
        if(timer%2==0){
            randomDisplayTick(world,new BlockPos(posX,posY,posZ), new Random());
        }
    }
}

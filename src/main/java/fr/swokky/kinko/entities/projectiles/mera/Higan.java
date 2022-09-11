package fr.swokky.kinko.entities.projectiles.mera;

import fr.swokky.kinko.entities.projectiles.AbilityProjectilesEntity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class Higan extends AbilityProjectilesEntity {

    int timer = 0;
    int timerMax = 10;

    public Higan(World worldIn) {
        super(worldIn);
        this.setDamage(2);
    }

    public Higan(World worldIn, EntityLivingBase thrower) {
        super(worldIn, thrower);
        this.setDamage(2);
    }

    public Higan(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
        this.setDamage(2);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);
        if(!(result.entityHit instanceof EntityLivingBase)) return;
        EntityLivingBase entity = (EntityLivingBase) result.entityHit;
        entity.setFire(2);
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

            world.spawnParticle(EnumParticleTypes.FLAME , x, y, z, d3, d4, d5);
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

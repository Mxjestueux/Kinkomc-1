package fr.swokky.kinko.entities.projectiles.mera;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.Sys;

import java.util.Random;

public class FlameBoom extends Entity {

    int timer = 0;
    int timerMax = 3;

    public FlameBoom(World worldIn) {
        super(worldIn);
    }


    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, BlockPos pos, Random rand) {
        for (int i = 0; i < 4; ++i) {
            double x = pos.getX();
            double y = pos.getY();
            double z = pos.getZ();
            double d3 = (rand.nextFloat() - 0.5) * 0.5;
            double d4 = (rand.nextFloat() - 0.5) * 0.5;
            double d5 = (rand.nextFloat() - 0.5) * 0.5;

            world.spawnParticle(EnumParticleTypes.FLAME , x, y, z, d3, d4, d5);
        }
    }

    @Override
    protected void entityInit() {

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
        for(int i = 0; i<100;i++){
            this.randomDisplayTick(world,new BlockPos(posX-5+getRandomNumberInRange(0,10),posY,posZ-5+getRandomNumberInRange(0,10)), new Random());
        }
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) {

    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound) {

    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}

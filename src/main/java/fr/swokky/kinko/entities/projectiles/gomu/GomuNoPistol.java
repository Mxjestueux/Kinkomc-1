package fr.swokky.kinko.entities.projectiles.gomu;

import fr.swokky.kinko.entities.projectiles.AbilityProjectilesEntity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class GomuNoPistol extends AbilityProjectilesEntity {

    int timer = 0;
    int timerMax = 10;

    public GomuNoPistol(World worldIn) {
        super(worldIn);
        this.setDamage(5);
    }
    public GomuNoPistol(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn,throwerIn);
        this.setDamage(5);
    }
    public GomuNoPistol(World worldIn, double x,double y ,double z) {
        super(worldIn,x,y,z);
        this.setDamage(5);
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
    }
}

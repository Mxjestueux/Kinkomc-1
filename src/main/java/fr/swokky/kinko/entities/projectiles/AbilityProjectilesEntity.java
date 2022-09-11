package fr.swokky.kinko.entities.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class AbilityProjectilesEntity extends EntityThrowable {

    private int damage;

    public AbilityProjectilesEntity(World worldIn) {
        super(worldIn);
    }
    public AbilityProjectilesEntity(World worldIn, EntityLivingBase thrower) {
        super(worldIn,thrower);
    }
    public AbilityProjectilesEntity(World worldIn, double x,double y ,double z) {
        super(worldIn,x,y,z);
    }

    @Override
    protected void entityInit() {

    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if(this.world.isRemote) return;
        setDead();
        if(!(result.entityHit instanceof EntityLivingBase)) return;
        EntityLivingBase entity = (EntityLivingBase) result.entityHit;
        entity.attackEntityFrom(DamageSource.causeThrownDamage(this,this.thrower), damage);
    }

    public void setDamage(int damage)
    {
        this.damage = damage;
    }
}

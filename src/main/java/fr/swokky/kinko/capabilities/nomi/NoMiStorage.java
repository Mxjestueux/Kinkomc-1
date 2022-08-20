package fr.swokky.kinko.capabilities.nomi;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

import javax.annotation.Nullable;

public class NoMiStorage implements Capability.IStorage<INoMi> {

    @CapabilityInject(INoMi.class)
    public static final Capability<INoMi> NO_MI_CAPABILITY = null;


    @Nullable
    @Override
    public NBTBase writeNBT(Capability<INoMi> capability, INoMi instance, EnumFacing side) {
        NBTTagCompound nbt = new NBTTagCompound();
        return nbt;
    }

    @Override
    public void readNBT(Capability<INoMi> capability, INoMi instance, EnumFacing side, NBTBase base) {
        if(base instanceof NBTTagCompound) {
            NBTTagCompound nbt = (NBTTagCompound)base;
        }
    }


}

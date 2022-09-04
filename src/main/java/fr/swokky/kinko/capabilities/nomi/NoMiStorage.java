package fr.swokky.kinko.capabilities.nomi;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class NoMiStorage implements Capability.IStorage<INoMiCapability> {

    @Override
    public NBTBase writeNBT(Capability<INoMiCapability> capability, INoMiCapability instance, EnumFacing side) {
        new NBTTagCompound();
        return new NBTTagString(instance.getNoMi());
    }

    @Override
    public void readNBT(Capability<INoMiCapability> capability, INoMiCapability instance, EnumFacing side, NBTBase nbt) {
        instance.setNoMi(((NBTTagString) nbt).getString());
    }
}

package fr.swokky.kinko.capabilities.nomi;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class NoMiStorage implements Capability.IStorage<INoMi> {

    @Override
    public NBTBase writeNBT(Capability<INoMi> capability, INoMi instance, EnumFacing side) {
        return new NBTTagString(instance.getNoMi());
    }

    @Override
    public void readNBT(Capability<INoMi> capability, INoMi instance, EnumFacing side, NBTBase nbt) {
        instance.setNoMi(((NBTTagString) nbt).getString());
    }
}

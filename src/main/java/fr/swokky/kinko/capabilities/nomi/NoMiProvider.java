package fr.swokky.kinko.capabilities.nomi;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class NoMiProvider implements ICapabilitySerializable {

    protected INoMi noMi;

    @Override
    public boolean hasCapability(Capability capability, EnumFacing facing) {
        return capability == NoMiStorage.NO_MI_CAPABILITY;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return this.hasCapability(capability, facing) ? NoMiStorage.NO_MI_CAPABILITY.cast(this.noMi) : null;
    }


    @Override
    public NBTBase serializeNBT() {
        return NoMiStorage.NO_MI_CAPABILITY.writeNBT(this.noMi, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        NoMiStorage.NO_MI_CAPABILITY.readNBT(this.noMi, null, nbt);
    }

}

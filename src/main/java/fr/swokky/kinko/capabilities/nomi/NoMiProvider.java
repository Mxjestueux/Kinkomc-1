package fr.swokky.kinko.capabilities.nomi;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class NoMiProvider implements ICapabilitySerializable<NBTBase> {

    @CapabilityInject(INoMi.class)
    public static final Capability<INoMi> NO_MI_CAPABILITY = null;

    private INoMi instance = NO_MI_CAPABILITY.getDefaultInstance();

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == NO_MI_CAPABILITY;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == NO_MI_CAPABILITY ? NO_MI_CAPABILITY.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return NO_MI_CAPABILITY.getStorage().writeNBT(NO_MI_CAPABILITY, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        NO_MI_CAPABILITY.getStorage().readNBT(NO_MI_CAPABILITY, this.instance, null, nbt);
    }
}

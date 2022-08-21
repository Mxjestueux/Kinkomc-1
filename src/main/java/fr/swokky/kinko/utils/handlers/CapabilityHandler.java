package fr.swokky.kinko.utils.handlers;

import fr.swokky.kinko.capabilities.nomi.NoMiProvider;
import fr.swokky.kinko.utils.References;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {

    public static final ResourceLocation NO_MI_CAPABILITY = new ResourceLocation(References.MODID, "nomi");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> e){
        if(!(e.getObject() instanceof EntityPlayer)) return;


        e.addCapability(NO_MI_CAPABILITY, new NoMiProvider());
    }
}

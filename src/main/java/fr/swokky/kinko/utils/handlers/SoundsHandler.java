package fr.swokky.kinko.utils.handlers;

import fr.swokky.kinko.utils.References;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler {
    public static SoundEvent GEAR_SECOND_PLAYER;

    public static void registerSounds()
    {
        GEAR_SECOND_PLAYER = registerSound("gomunomi.gear_second");
    }

    private static SoundEvent registerSound(String name)
    {
        ResourceLocation location = new ResourceLocation(References.MODID, name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }


}

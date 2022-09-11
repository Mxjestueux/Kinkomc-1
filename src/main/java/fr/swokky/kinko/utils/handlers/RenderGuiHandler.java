package fr.swokky.kinko.utils.handlers;

import fr.swokky.kinko.client.AbilityHudOverlay;
import fr.swokky.kinko.utils.hashmap.DevilFruitHashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderGuiHandler {

    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent event)
    {
        if(event.getType() != RenderGameOverlayEvent.ElementType.TEXT) return;
        EntityPlayer player = Minecraft.getMinecraft().player;

        if(!(DevilFruitHashMap.devilFruit.containsKey(player.getUniqueID()))) return;

        new AbilityHudOverlay(Minecraft.getMinecraft(), DevilFruitHashMap.devilFruit.get(player.getUniqueID()));
    }
}

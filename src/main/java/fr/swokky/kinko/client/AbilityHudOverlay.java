package fr.swokky.kinko.client;

import fr.swokky.kinko.utils.References;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;

public class AbilityHudOverlay extends Gui {

    public AbilityHudOverlay(Minecraft mc){
        mc.getTextureManager().bindTexture(new ResourceLocation(References.MODID, "textures/gui/ability/abilitybackground.png"));
        ScaledResolution res = new ScaledResolution(mc);

        int halfScreen = res.getScaledHeight()/2;
        for(int i = 0; i<4; i++){
            drawScaledCustomSizeModalRect(4,halfScreen-68+34*i,0,0,256,256,32,32, 256, 256);
        }
    }
}

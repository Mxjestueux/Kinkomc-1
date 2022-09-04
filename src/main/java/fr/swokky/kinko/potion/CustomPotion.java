package fr.swokky.kinko.potion;

import fr.swokky.kinko.utils.References;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class CustomPotion extends Potion {

    public CustomPotion(String name, boolean isBadEffectIn, int colour, int iconIndexX, int iconIndexY) {
        super(isBadEffectIn, colour);
        setPotionName("effect." + name);
        setIconIndex(iconIndexX, iconIndexY);
        setRegistryName(new ResourceLocation(References.MODID + ":" + name));
    }

    @Override
    public boolean hasStatusIcon() {
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(References.MODID, "textures/gui/potion_effects.png"));
        return true;
    }
}

package fr.swokky.kinko.client;

import fr.swokky.kinko.abilities.Ability;
import fr.swokky.kinko.item.fruit.BaseFruit;
import fr.swokky.kinko.item.fruit.FruitManager;
import fr.swokky.kinko.utils.References;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@SideOnly(Side.CLIENT)
public class AbilityHudOverlay extends Gui {

    public AbilityHudOverlay(Minecraft mc, String devilFruit){
        String path = "textures/gui/ability/" + devilFruit + "/";
        ScaledResolution res = new ScaledResolution(mc);
        int halfScreen = res.getScaledHeight()/2;
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        abilityDraw(mc.player, devilFruit, path, mc, halfScreen, "Attack",0);
        abilityDraw(mc.player, devilFruit, path, mc, halfScreen, "Special",1);
        abilityDraw(mc.player, devilFruit, path, mc, halfScreen, "Special_Second",2);
        abilityDraw(mc.player, devilFruit, path, mc, halfScreen, "Special_Third",3);
    }

    private void abilityDraw(EntityPlayer player, String devilFruit, String path, Minecraft mc, int halfScreen, String ability, int index){
        int cooldown = getCooldown(devilFruit, ability, player);
        float color = cooldown != 0 ? 128.0F/255.0F : 1.0F;

        mc.getTextureManager().bindTexture(new ResourceLocation(References.MODID, "textures/gui/ability/abilitybackground.png"));
        GlStateManager.color(color, color, color, 1.0F);
        drawScaledCustomSizeModalRect(4,halfScreen-68+34*index,0,0,256,256,32,32, 256, 256);

        mc.getTextureManager().bindTexture(new ResourceLocation(References.MODID, path + ability + ".png"));
        drawScaledCustomSizeModalRect(12,halfScreen-60+34*index,0,0,128,128,16,16, 128, 128);

        if(cooldown != 0){
            drawCenteredString(mc.fontRenderer,Integer.toString(cooldown), 20, halfScreen-44+34*index, 4210752);
        }
    }

    private int getCooldown(String devilFruit, String ability, EntityPlayer player){
        try {
            Class<? extends BaseFruit> fruit = FruitManager.getInstance().getFruit(devilFruit);
            Constructor<? extends BaseFruit> constructorFruit = fruit.getDeclaredConstructor(String.class);

            Class<? extends Ability> abilityclass = constructorFruit.newInstance(devilFruit).getAbility(ability);
            Constructor<? extends Ability> constructorAbility = abilityclass.getDeclaredConstructor(EntityPlayer.class);

            return constructorAbility.newInstance(player).isOnCooldown(player) ? constructorAbility.newInstance(player).getCooldown(player) : 0;
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

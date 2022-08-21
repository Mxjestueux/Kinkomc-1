package fr.swokky.kinko.utils.handlers;

import fr.swokky.kinko.capabilities.nomi.INoMi;
import fr.swokky.kinko.capabilities.nomi.NoMiProvider;
import fr.swokky.kinko.init.ItemInit;
import fr.swokky.kinko.proxy.ClientProxy;
import fr.swokky.kinko.utils.References;
import fr.swokky.kinko.utils.interfaces.IHasModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class RegistryHandler {

    public static final ResourceLocation CAPABILITY_LOCATION = new ResourceLocation(References.MODID,"no_mi");

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event)
    {
        for(Item item : ItemInit.ITEMS)
        {
            if(item instanceof IHasModel)
            {
                ((IHasModel)item).registerModels();
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public static void onEvent(InputEvent.KeyInputEvent event)
    {
        final Minecraft mc = Minecraft.getMinecraft();
        EntityPlayerSP player = mc.player;
        KeyBinding[] keyBindings = ClientProxy.keyBindings;

        if(keyBindings[0].isPressed()){
            INoMi cap = player.getCapability(NoMiProvider.NO_MI_CAPABILITY, null);
        }
    }

    public static void preInitRegistries()
    {
    }

    public static void initRegistries()
    {
    }
}

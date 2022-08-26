package fr.swokky.kinko.utils.handlers;

import fr.swokky.kinko.Main;
import fr.swokky.kinko.init.EntityInit;
import fr.swokky.kinko.init.ItemInit;
import fr.swokky.kinko.network.PacketActionNoMiMessage;
import fr.swokky.kinko.proxy.ClientProxy;
import fr.swokky.kinko.utils.interfaces.IHasModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
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

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Item item : ItemInit.ITEMS) {
            if (item instanceof IHasModel) {
                ((IHasModel) item).registerModels();
            }
        }
    }


    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public static void onEvent(InputEvent.KeyInputEvent event)
    {
        KeyBinding[] keyBindings = ClientProxy.keyBindings;

        if(keyBindings[0].isPressed()){
            Main.network.sendToServer(new PacketActionNoMiMessage("Attack"));
        }
        if(keyBindings[1].isPressed()){
            Main.network.sendToServer(new PacketActionNoMiMessage("Special"));
        }
    }

    public static void preInitRegistries()
    {
        EntityInit.registerEntities();
    }

    public static void initRegistries()
    {
    }
}

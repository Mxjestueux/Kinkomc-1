package fr.swokky.kinko.utils.handlers;

import fr.swokky.kinko.capabilities.nomi.NoMiProvider;
import fr.swokky.kinko.init.ItemInit;
import fr.swokky.kinko.packet.ActionAttackPacket;
import fr.swokky.kinko.proxy.ClientProxy;
import fr.swokky.kinko.utils.References;
import fr.swokky.kinko.utils.interfaces.IHasModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class RegistryHandler {

    public static SimpleNetworkWrapper network;
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
        EntityPlayer player = mc.player;
        KeyBinding[] keyBindings = ClientProxy.keyBindings;

        if(keyBindings[0].isPressed()){
            System.out.println(player.getDisplayName());
            network.sendToServer(new ActionAttackPacket("Action1/"));
        }
    }

    @SubscribeEvent
    public static void attachCapability(AttachCapabilitiesEvent <EntityPlayer> event){
        event.addCapability(CAPABILITY_LOCATION, new NoMiProvider());
    }

    public static void preInitRegistries()
    {
        network = NetworkRegistry.INSTANCE.newSimpleChannel("no_mi_actions");
        network.registerMessage(ActionAttackPacket.Handler.class, ActionAttackPacket.class, 0, Side.SERVER);
    }

    public static void initRegistries()
    {
    }
}

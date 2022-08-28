package fr.swokky.kinko.utils.handlers;

import fr.swokky.kinko.Main;
import fr.swokky.kinko.capabilities.nomi.NoMiProvider;
import fr.swokky.kinko.init.EntityInit;
import fr.swokky.kinko.init.ItemInit;
import fr.swokky.kinko.network.PacketActionNoMiMessage;
import fr.swokky.kinko.proxy.ClientProxy;
import fr.swokky.kinko.utils.interfaces.IHasModel;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
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

    @SubscribeEvent
    public static void onHurt(LivingHurtEvent event){
        if(!(event.getEntity() instanceof EntityPlayer)) return;
        EntityPlayer player = (EntityPlayer) event.getEntity();
        float damage = event.getAmount();
        DamageSource source = event.getSource();
        String noMi = player.getCapability(NoMiProvider.NO_MI_CAPABILITY, null).getNoMi();
        switch (noMi){
            case "gomu":
                if(source.isProjectile()){
                    event.setCanceled(true);
                    player.attackEntityFrom(source, Math.round(0.8*damage));
                }
            default:
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
        if(keyBindings[2].isPressed()){
            Main.network.sendToServer(new PacketActionNoMiMessage("Special_Second"));
        }
    }

    public static void preInitRegistries()
    {
        EntityInit.registerEntities();
    }

    public static void initRegistries()
    {
        SoundsHandler.registerSounds();
    }
}

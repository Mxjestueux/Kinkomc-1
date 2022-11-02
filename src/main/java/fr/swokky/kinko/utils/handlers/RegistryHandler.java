package fr.swokky.kinko.utils.handlers;

import fr.swokky.kinko.Main;
import fr.swokky.kinko.init.EntityInit;
import fr.swokky.kinko.init.ItemInit;
import fr.swokky.kinko.init.PotionInit;
import fr.swokky.kinko.network.PacketActionNoMiMessage;
import fr.swokky.kinko.proxy.ClientProxy;
import fr.swokky.kinko.utils.hashmap.DevilFruitHashMap;
import fr.swokky.kinko.utils.interfaces.IHasModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class RegistryHandler {

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
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
    public static void onHurt(LivingHurtEvent event) {

        if (!(event.getEntity() instanceof EntityPlayer)) return;
        EntityPlayer player = (EntityPlayer) event.getEntity();
        float damage = event.getAmount();

        DamageSource source = event.getSource();
        String noMi = DevilFruitHashMap.devilFruit.get(player.getUniqueID());

        if (noMi.equals("GomuGomuNoMi") && source.isProjectile()) {
            event.setCanceled(true);
            player.attackEntityFrom(source, Math.round(0.8 * damage));

        }
    }

    @SubscribeEvent
    public static void onDeath(LivingDeathEvent event) {
        PlayerEventHandler.onDeath(event);
    }

    @SubscribeEvent
    public static void onConnect(PlayerEvent.PlayerLoggedInEvent event) {
        PlayerEventHandler.onConnect(event);
    }


    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public static void onKeyInputEvent(InputEvent.KeyInputEvent event) {
        KeyBinding[] keyBindings = ClientProxy.keyBindings;
        Minecraft mc = Minecraft.getMinecraft();

        String noMi = DevilFruitHashMap.devilFruit.get(mc.player.getUniqueID());
        assert noMi != null;

        if (keyBindings[0].isPressed()) {
            Main.network.sendToServer(new PacketActionNoMiMessage("Attack"));
        }
        if (keyBindings[1].isPressed()) {
            Main.network.sendToServer(new PacketActionNoMiMessage("Special"));
        }
        if (keyBindings[2].isPressed()) {
            Main.network.sendToServer(new PacketActionNoMiMessage("Special_Second"));
        }
        if (keyBindings[3].isPressed()) {
            Main.network.sendToServer(new PacketActionNoMiMessage("Special_Third"));
        }
    }

    public static void preInitRegistries() {
        EntityInit.registerEntities();
        PotionInit.registerPotions();
    }

    public static void initRegistries() {
        SoundsHandler.registerSounds();
    }
}

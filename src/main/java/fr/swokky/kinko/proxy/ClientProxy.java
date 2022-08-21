package fr.swokky.kinko.proxy;

import fr.swokky.kinko.capabilities.nomi.INoMi;
import fr.swokky.kinko.capabilities.nomi.NoMi;
import fr.swokky.kinko.capabilities.nomi.NoMiStorage;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class ClientProxy extends CommonProxy{

    public static KeyBinding[] keyBindings;

    @Override
    public void registerItemRenderer(Item item, int meta) {
        ModelLoader.setCustomModelResourceLocation(item,meta,new ModelResourceLocation(item.getRegistryName(),"inventory"));
    }

    @Override
    public void registerVariantRenderer(Item item, int meta, String filename, String id) {
        super.registerVariantRenderer(item, meta, filename, id);
    }

    @Override
    public void registerEntityRenderer() {
        super.registerEntityRenderer();
    }

    @Override
    public void registerGuis() {
    }

    @Override
    public void preInit() {
        super.preInit();
    }

    @Override
    public void init() {
        keyBindings = new KeyBinding[1];

        keyBindings[0] = new KeyBinding("key.nomi.attack", Keyboard.KEY_H, "key.kinko.category");


        for (KeyBinding keyBinding : keyBindings) {
            ClientRegistry.registerKeyBinding(keyBinding);
        }
        super.init();
    }
}

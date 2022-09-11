package fr.swokky.kinko.network;

import fr.swokky.kinko.abilities.Ability;
import fr.swokky.kinko.capabilities.nomi.INoMiCapability;
import fr.swokky.kinko.capabilities.nomi.NoMiProvider;
import fr.swokky.kinko.item.fruit.BaseFruit;
import fr.swokky.kinko.item.fruit.FruitManager;
import fr.swokky.kinko.utils.api.Config;
import fr.swokky.kinko.utils.hashmap.DevilFruitHashMap;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.lwjgl.Sys;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PacketActionNoMiMessage implements IMessage {

    private String text;

    public PacketActionNoMiMessage() {
    }

    public PacketActionNoMiMessage(String text) {
        this.text = text;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        text = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, text);
    }

    public static class Handler implements IMessageHandler<PacketActionNoMiMessage, IMessage> {

        @Override
        public IMessage onMessage(PacketActionNoMiMessage message, MessageContext ctx) {
            EntityPlayerMP player = ctx.getServerHandler().player;
            if(player.isInsideOfMaterial(Material.WATER)) return null;
            String noMi = DevilFruitHashMap.devilFruit.get(player.getUniqueID());
            if (noMi == null) return null;
            Class<? extends BaseFruit> fruit = FruitManager.getInstance().getFruit(noMi);
            try {
                Constructor<? extends BaseFruit> constructorFruit = fruit.getDeclaredConstructor(String.class);
                Class<? extends Ability> ability = constructorFruit.newInstance(noMi).getAbility(message.text);
                Constructor<? extends Ability> constructorAbility = ability.getDeclaredConstructor(EntityPlayer.class);
                constructorAbility.newInstance(player);
            } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}

package fr.swokky.kinko.network;

import fr.swokky.kinko.abilities.Ability;
import fr.swokky.kinko.capabilities.nomi.INoMiCapability;
import fr.swokky.kinko.capabilities.nomi.NoMiProvider;
import fr.swokky.kinko.item.fruit.BaseFruit;
import fr.swokky.kinko.item.fruit.FruitManager;
import fr.swokky.kinko.utils.api.Config;
import io.netty.buffer.ByteBuf;
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
            INoMiCapability noMi = player.getCapability(NoMiProvider.NO_MI_CAPABILITY, null);
            if (noMi.getNoMi().equals("")) return null;
            Class<? extends BaseFruit> fruit = FruitManager.getInstance().getFruit(noMi.getNoMi());
            try {
                Constructor<? extends BaseFruit> constructorFruit = fruit.getDeclaredConstructor(String.class);
                Class<? extends Ability> ability = constructorFruit.newInstance(noMi.getNoMi()).getAbility(message.text);
                Constructor<? extends Ability> constructorAbility = ability.getDeclaredConstructor(EntityPlayer.class);
                constructorAbility.newInstance(player);
            } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}

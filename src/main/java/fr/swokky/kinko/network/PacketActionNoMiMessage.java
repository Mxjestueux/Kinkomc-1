package fr.swokky.kinko.network;

import fr.swokky.kinko.abilities.gomunomi.GomuNoGatlingAbility;
import fr.swokky.kinko.abilities.gomunomi.GomuNoPistolAbility;
import fr.swokky.kinko.capabilities.nomi.NoMiProvider;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketActionNoMiMessage implements IMessage {

    private String text;

    public PacketActionNoMiMessage(){
    }

    public PacketActionNoMiMessage(String text){
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

    public static class Handler implements IMessageHandler <PacketActionNoMiMessage, IMessage>{

        @Override
        public IMessage onMessage(PacketActionNoMiMessage message, MessageContext ctx) {
            EntityPlayerMP player = ctx.getServerHandler().player;
            String noMi = player.getCapability(NoMiProvider.NO_MI_CAPABILITY, null).getNoMi();
            switch (noMi){
                case "gomu":
                    if(message.text.equals("Attack")){
                        new GomuNoPistolAbility(player);
                    } else if(message.text.equals("Special")){
                        new GomuNoGatlingAbility(player);
                    }

                    break;
                default:
                    break;
            }
            return null;
        }
    }
}

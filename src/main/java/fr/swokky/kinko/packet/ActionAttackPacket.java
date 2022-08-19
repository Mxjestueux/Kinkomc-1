package fr.swokky.kinko.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ActionAttackPacket implements IMessage {

    private String text;

    public ActionAttackPacket() { }

    public ActionAttackPacket(String text) {
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

    public static class Handler implements IMessageHandler<ActionAttackPacket, IMessage> {

        @Override
        public IMessage onMessage(ActionAttackPacket message, MessageContext ctx) {
            switch (message.text.split("/")[0])
            {
                case "Action1":
                    System.out.println("message recieved");
                    System.out.println(message.text);
                default:
                    break;
            }
            return null;
        }
    }
}

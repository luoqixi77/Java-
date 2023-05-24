package Modbus;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/11 12:24
 * @Description TODO
 */
public class AddDeviceServer extends ChannelInboundHandlerAdapter {
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        byte[] data = new byte[]{0x01, 0x05, 0x00, 0x01, (byte) 0x00, 0x00, (byte) 0x9c, (byte) 0x0a};
        // 包装字节数组为ByteBuf
        ByteBuf buf = Unpooled.wrappedBuffer(data);
        SocketAddress remoteAddress = new InetSocketAddress("172.18.7.22", 30);
        // 创建ChannelPromise对象
        ChannelPromise promise = ctx.newPromise();
        // 发送ByteBuf
        ctx.writeAndFlush(buf, promise);
        // 添加异步操作监听器
        promise.addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("Send message to " + remoteAddress + " succeeded.");
            } else {
                System.out.println("Send message to " + remoteAddress + " failed.");
            }
        });
    }
}

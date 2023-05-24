package Modbus;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import java.net.InetSocketAddress;
import java.util.Arrays;


/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/11 12:25
 * @Description TODO
 */
public class AddDeviceClient {
    public static void main(String[] args) throws InterruptedException {

        //通过netty连接，输入IP地址，port端口，传输16进制的字节数组，控制设备
        byte[] data = new byte[]{0x01,0x05,0x00,0x01, (byte) 0xff,0x00, (byte) 0xDD, (byte) 0xfa};
        // 包装字节数组为ByteBuf
        ByteBuf buf = Unpooled.wrappedBuffer(data);
        System.out.println(buf.toString());
        System.out.println(Arrays.toString(data));
        new Bootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) {
                        ch.pipeline().addLast(new StringEncoder());
                    }
                })
                .connect(new InetSocketAddress("172.18.7.22", 30))
                .sync()
                .channel()
                //地址码+功能码+起始地址+寄存器个数+CRC校验
                // 01    03    00 16   00 05   1C 61
                .writeAndFlush(buf);
//                .writeAndFlush("0105000100009c0a");
    }
}

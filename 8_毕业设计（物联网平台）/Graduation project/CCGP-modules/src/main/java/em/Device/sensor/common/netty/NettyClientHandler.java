package em.Device.sensor.common.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.net.InetSocketAddress;


/**
 * Netty的handler处理器类
 */
public class NettyClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private final NettyClient client;

    /**
     * 构造方法
     * @param client 传入的连接client
     */
    public NettyClientHandler(NettyClient client){
        this.client = client;
    }

    /**
     *当服务端返回设备报文信息后，接收返回的报文，并传入Controller层和发送下一个信息
     * @param ctx 传输通道
     * @param msg 服务器返回的数据
     * @throws Exception 异常
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf  msg) throws Exception {
        System.out.println("Received message from device: " + msg);
        client.resetFailedAttempts();
        client.handleResponse(msg);
        InetSocketAddress address = (InetSocketAddress) ctx.channel().remoteAddress();
        client.sendNextRequest(address);
    }

    /**
     * 出现异常后的处理方法
     * @param ctx 收到的异常信息
     * @param cause 抛出的异常
     * @throws Exception 异常
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        client.incrementFailedAttempts();
        InetSocketAddress address = (InetSocketAddress) ctx.channel().remoteAddress();
        client.sendNextRequest(address);
    }

}

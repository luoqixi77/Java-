package com.DeviceTest.Handler;

import com.DeviceTest.Utils.MessageReceivedCallback;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/13 8:44
 * @Description TODO
 */
public class MyClientHandler extends ChannelInboundHandlerAdapter {
    private ByteBuf buf;
    private MessageReceivedCallback callback;

    /**
     * 测试类
     * @param buf 发送的数据
     */
    public MyClientHandler(ByteBuf buf) {
        this.buf = buf;
    }

    /**
     * 测试类
     * @param callback 返回参数
     */
    public MyClientHandler(MessageReceivedCallback callback){
        this.callback = callback;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //发送消息到服务端
        ctx.writeAndFlush(buf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //接收服务端发送过来的消息
        ByteBuf byteBuf = (ByteBuf) msg;
        byte[] bytes = new byte[byteBuf.readableBytes()];
        callback.onMessageReceived(bytes);
    }
}

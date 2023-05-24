package com.test;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/11 15:59
 * @Description TODO
 */
public class Dm {
    /**
     * netty测试代码
     * @param args 主函数参数
     */
    public static void main(String[] args) {
        new Bootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.INFO))
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast(new IdleStateHandler(0, 0, 30, TimeUnit.SECONDS));

                    }
                })
                .option(ChannelOption.SO_KEEPALIVE, true)
                .connect("localhost", 8899);
    }

}

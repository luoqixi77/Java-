package com.test;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/11 8:31
 * @Description TODO
 */
@RestController
public class NettyController {

    /**
     * 测试类中测试netty
     */
    @GetMapping("/device/add")
    public void addDevice() {
        new ServerBootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                            @Override
                            protected void channelRead0(ChannelHandlerContext ctx, String msg) {
                                System.out.println(msg);
                            }
                        });
                    }
                })
                /**
                 * 测试类，要发送的端口
                 */
                .bind(8080);
    }

    /**
     * 测试类中测试设备增加
     * @param deviceDto 设备信息
     * @throws InterruptedException 报错
     */
    @PostMapping("/device/add")
    public void postAddDevice(@RequestBody AddDeviceDto deviceDto) throws InterruptedException {
        new Bootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) {
                        ch.pipeline().addLast(new StringEncoder());
                    }
                })
                .connect(deviceDto.getIp(), 8080)
                .sync()
                .channel()
                //地址码+功能码+起始地址+寄存器个数+CRC校验
                // 01    03    00 16   00 05   1C 61
                .writeAndFlush(deviceDto.getAddress()+deviceDto.getFunction()+deviceDto.getStartAddress()+deviceDto.getRegister()+deviceDto.getCRCVerify());
    }
}

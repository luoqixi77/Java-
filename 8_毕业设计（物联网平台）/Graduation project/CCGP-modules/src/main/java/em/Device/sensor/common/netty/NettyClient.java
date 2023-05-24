package em.Device.sensor.common.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.pool.AbstractChannelPoolMap;
import io.netty.channel.pool.ChannelPoolHandler;
import io.netty.channel.pool.ChannelPoolMap;
import io.netty.channel.pool.FixedChannelPool;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/18 8:50
 * @Description 向服务器发送请求的Netty客户端
 * 该类管理一个设备信息DTO队列，以便作为请求发送，并使用ChannelPoolMap管理各种由套接字地址标识的服务器连接
 */
@Component
@Slf4j
public class NettyClient {
    private final Bootstrap bootstrap;
    private final Queue<ByteBuf> requests = new ConcurrentLinkedQueue<>();
    private final ChannelPoolMap<InetSocketAddress, FixedChannelPool> poolMap;
    private int failedAttempts = 0;
    private static final int MAX_FAILED_ATTEMPTS = 10;
    private ResponseHandler responseHandler;

    /**
     * 回调接口
     */
    public interface ResponseHandler{
        /**
         * 回调方法
         * @param msg 要返回的参数
         */
        void handleResponse(ByteBuf msg);
    }

    /**
     * 回调方法
     * @param responseHandler 传入回调的接口
     */
    public void setResponseHandler(ResponseHandler responseHandler){
        this.responseHandler = responseHandler;
    }

    /**
     * 回调请求
     * @param msg 回调的参数
     */
    public void handleResponse(ByteBuf msg){
        if (responseHandler!=null){
            responseHandler.handleResponse(msg);
        }
    }


    /**
     * NettyClient的构造函数，初始化使用Netty库创建和管理与服务器的连接所需的必要对象
     */
    public NettyClient() {
        EventLoopGroup group = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new NettyClientHandler(NettyClient.this));
                    }
                });
        poolMap = new AbstractChannelPoolMap<>() {
            @Override
            protected FixedChannelPool newPool(InetSocketAddress inetSocketAddress) {
                return new FixedChannelPool(bootstrap.remoteAddress(inetSocketAddress), new ChannelPoolHandler() {
                    @Override
                    public void channelReleased(Channel channel) throws Exception {

                    }

                    @Override
                    public void channelAcquired(Channel channel) throws Exception {

                    }

                    @Override
                    public void channelCreated(Channel channel) throws Exception {

                    }
                }, 30);
            }
        };
    }

    /**
     *
     * 将设备信息Dto列表添加到请求队列，以便发送到服务器
     * @param byteBuf 设备信息的DeviceInfoDto对象列表
     */
    public void addRequest(ByteBuf byteBuf) {
        requests.add(byteBuf);
    }

    /**
     * 将请求队列中的下一个请求发送给由给定套接字地址标识的服务器，该方法从ChannelPoolMap并获取通道，
     * 并使用 writeAndFlush 方法将设备信息写入通道。一旦写操作完成，通道将被释放回池中。
     * @param address 队列里面的消息
     */
    public void sendNextRequest(InetSocketAddress address) {
        while (true) {
            ByteBuf request=requests.poll();
            if (request==null){
                break;
            }
            Future<Channel> future = poolMap.get(address).acquire();
            future.addListener((FutureListener<Channel>) f -> {
                if (f.isSuccess()) {
                    Channel channel = f.getNow();
                    channel.writeAndFlush(request);
                    poolMap.get(address).release(channel);
                } else if (failedAttempts >= MAX_FAILED_ATTEMPTS) {
                    System.err.println("Failed to receive response from device after " + MAX_FAILED_ATTEMPTS + " attempts");
                }
            });
        }
    }

    /**
     * 设备请求失败次数的清零方法
     */
    public void resetFailedAttempts() {
        failedAttempts = 0;
    }

    /**
     * 设备请求失败后++的方法
     */
    public void incrementFailedAttempts() {
        failedAttempts++;
    }

}

package Nio.File;

import Nio.ByteBuffer.Utils;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author luoqixi77
 * @version 1.0
 * @date 2023/3/23 9:28
 * @Description TODO
 */
@Slf4j
public class ChannelDemo6 {
    /**
     * 创建serversocketchannel连接->指定端口号->创建selector->注册selector,accept事件->查询selector连接数->使用Map集合获取事件->
     * 使用迭代器获取事件，逐一处理->(如果是accept事件->使用key打开channel->处理accept->注册read事件)->(如果是read事件->...)处理完毕，将事件移除
     * @param args
     */

    public static void main(String[] args) {
        try (ServerSocketChannel channel = ServerSocketChannel.open()) {
            channel.bind(new InetSocketAddress(8080));
            System.out.println(channel);
            Selector selector = Selector.open();
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                int count = selector.select();
                log.debug("select count: {}", count);

                // 获取所有事件
                Set<SelectionKey> keys = selector.selectedKeys();

                // 遍历所有事件，逐一处理
                Iterator<SelectionKey> iter = keys.iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    // 判断事件类型
                    if (key.isAcceptable()) {
                        ServerSocketChannel c = (ServerSocketChannel) key.channel();
                        // 必须处理
                        SocketChannel sc = c.accept();
                        sc.configureBlocking(false);
                        sc.register(selector,SelectionKey.OP_READ);
                        log.debug("{}", sc);
                    }else if (key.isReadable()){
                        SocketChannel sc=(SocketChannel) key.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                        int read=sc.read(byteBuffer);
                        if (read == -1){
                            key.cancel();
                            sc.close();
                        }else {
                            byteBuffer.flip();
                            Utils.debugAll(byteBuffer);
                        }
                    }
                    // 处理完毕，必须将事件移除
                    iter.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

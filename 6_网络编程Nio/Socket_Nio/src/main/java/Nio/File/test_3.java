package Nio.File;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.*;

/**
 * @author luoqixi77
 * @version 1.0
 * @date 2023/3/22 19:26
 * @Description TODO
 */
public class test_3{
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        SocketChannel socketChannel = SocketChannel.open();
        ServerSocketChannel serverSocket=new ServerSocket().getChannel();
        socketChannel.configureBlocking(false);
        SelectionKey key = socketChannel.register(selector, 0, null);
        socketChannel.bind(new InetSocketAddress(8848));


//        int select = selector.select();


    }

}





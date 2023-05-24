package Nio.File;

import io.netty.channel.unix.Socket;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luoqixi77
 * @version 1.0
 * @date 2023/3/24 9:11
 * @Description TODO
 */
@Slf4j
public class test_4 {
    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress("ndp.nlecloud.com",8600));

        Map<String, String> map = new HashMap<>();

    }
}

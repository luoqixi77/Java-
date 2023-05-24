package Nio.ByteBuffer;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author luoqixi77
 * @version 1.0
 * @date 2023/3/22 8:48
 * @Description NIO编程测试
 */

@Slf4j
public class test {
    public static void main(String[] args) {
        //获取文件地址
        try (RandomAccessFile file = new RandomAccessFile("src/main/java/Nio/data.txt", "rw")) {
            //开启Channel
            FileChannel channel = file.getChannel();
            //准备缓冲区，使用静态方法获取
            ByteBuffer buffer = ByteBuffer.allocate(10);
            do {
                // 向 buffer 写入
                int len = channel.read(buffer);
                log.debug("读到字节数：{}", len);
                if (len == -1) {
                    break;
                }
                // 切换 buffer 读模式
                buffer.flip();
                while(buffer.hasRemaining()) {
                    log.debug("{}", (char)buffer.get());
                }
                // 切换 buffer 写模式
                buffer.clear();
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





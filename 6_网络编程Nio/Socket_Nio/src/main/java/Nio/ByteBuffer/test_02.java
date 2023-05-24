package Nio.ByteBuffer;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author luoqixi77
 * @version 1.0
 * @date 2023/3/22 9:55
 * @Description 分散读取
 */
@Slf4j
public class test_02 {
    public static void main(String[] args) {
//        try {
//            FileChannel fileChannel = new RandomAccessFile("src/main/java/Nio/wuhu.txt", "rw").getChannel();
//            ByteBuffer allocate1 = ByteBuffer.allocate(3);
//            ByteBuffer allocate2 = ByteBuffer.allocate(3);
//            ByteBuffer allocate3 = ByteBuffer.allocate(5);
//            ByteBuffer allocate4 = ByteBuffer.allocate(4);
//            fileChannel.read(new ByteBuffer[]{allocate1, allocate2, allocate3, allocate4});
//            allocate1.flip();
//            allocate2.flip();
//            allocate3.flip();
//            allocate4.flip();
//            log.debug("allocate1:{}",allocate1);
//            log.debug("allocate2:{}",allocate2);
//            log.debug("allocate3:{}",allocate3);
//            log.debug("allocate4:{}",allocate4);
//        } catch (Exception e){
//            e.printStackTrace();
//        }

        //将多个buffer数据填充至channel
        try (RandomAccessFile file = new RandomAccessFile("src/main/java/Nio/wuhu.txt", "rw")) {
            FileChannel channel = file.getChannel();
            ByteBuffer d = ByteBuffer.allocate(4);
            ByteBuffer e = ByteBuffer.allocate(4);
            channel.position(11);

            d.put(new byte[]{'f', 'o', 'u', 'r'});
            e.put(new byte[]{'f', 'i', 'v', 'e'});
            d.flip();
            e.flip();
            log.debug("{}",d);
            log.debug("{}",e);
            channel.write(new ByteBuffer[]{d, e});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

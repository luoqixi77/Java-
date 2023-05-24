package Nio.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @author luoqixi77
 * @version 1.0
 * @date 2023/3/22 10:57
 * @Description 两个Channel传输文件
 */
public class test_1 {
    public static void main(String[] args) {
        String FROM = "src/main/java/Nio/ByteBuffer/data.txt";
        String TO = "src/main/java/Nio/File/he.txt";
        long start = System.nanoTime();
        try (FileChannel from = new FileInputStream(FROM).getChannel();
             FileChannel to = new FileOutputStream(TO).getChannel();
        ) {
            from.transferTo(0, from.size(), to);
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        System.out.println("transferTo 用时：" + (end - start) / 1000_000.0);
    }



//超过2G的文件传输
    public static void BigFile(){
        try (
                FileChannel from = new FileInputStream("data.txt").getChannel();
                FileChannel to = new FileOutputStream("to.txt").getChannel();
        ) {
            // 效率高，底层会利用操作系统的零拷贝进行优化
            long size = from.size();
            // left 变量代表还剩余多少字节
            for (long left = size; left > 0; ) {
                System.out.println("position:" + (size - left) + " left:" + left);
                left -= from.transferTo((size - left), left, to);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

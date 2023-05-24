package Nio.ByteBuffer;

import java.nio.ByteBuffer;

import static Nio.ByteBuffer.Utils.debugAll;

/**
 * @author luoqixi77
 * @version 1.0
 * @date 2023/3/22 10:16
 * @Description TODO
 */
public class test_4 {
    public static void main(String[] args) {
        /**
         * 网络上有多条数据发送给服务端，数据之间使用 \n 进行分隔
         * 但由于某种原因这些数据在接收时，被进行了重新组合，例如原始数据有3条为
         *
         * * Hello,world\n  11
         * * I'm zhangsan\n 11
         * * How are you?\n 10
         *
         * 变成了下面的两个 byteBuffer (黏包，半包)
         *
         * * Hello,world\nI'm zhangsan\nHo
         * * w are you?\n
         *
         * 现在要求你编写程序，将错乱的数据恢复成原始的按 \n 分隔的数据
         */
        ByteBuffer allocate = ByteBuffer.allocate(32);
        allocate.put("Hello,world\nI'm zhangsan\nHo".getBytes());
        split(allocate);
        allocate.put("w are you?\n".getBytes());
        split(allocate);
    }
    private static void split(ByteBuffer buffer){
        buffer.flip();
        int limit = buffer.limit();
        for (int i = 0; i <limit; i++) {
            //找到\n，代表找到了一条完整信息
            if (buffer.get(i)=='\n'){
                System.out.println(i);
                //设置新的长度来接收
                ByteBuffer allocate = ByteBuffer.allocate(i + 1 - buffer.position());
                buffer.limit(i+1);
                allocate.put(buffer);
                System.out.println(allocate);
                debugAll(allocate);
                buffer.limit(limit);
            }
        }
        buffer.compact();
    }

}

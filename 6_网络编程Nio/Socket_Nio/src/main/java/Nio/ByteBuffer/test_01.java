package Nio.ByteBuffer;

import lombok.extern.slf4j.Slf4j;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


/**
 * @author luoqixi77
 * @version 1.0
 * @date 2023/3/22 9:35
 * @Description TODO
 */

@Slf4j
public class test_01 {
    public static void main(String[] args) {
        ByteBuffer buffer=ByteBuffer.allocate(12);
        buffer.put((byte) 123);
        buffer.flip();
        byte b = buffer.get();
        System.out.println(b);



        ByteBuffer buffer1 = StandardCharsets.UTF_8.encode("你好");
        ByteBuffer buffer2 = Charset.forName("utf-8").encode("你好");

       log.debug("buffer1:{}",buffer1);
       log.debug("buffer2:{}",buffer2);

        CharBuffer buffer3 = StandardCharsets.UTF_8.decode(buffer1);
        System.out.println(buffer3.getClass());
        System.out.println(buffer3.toString());
    }
}

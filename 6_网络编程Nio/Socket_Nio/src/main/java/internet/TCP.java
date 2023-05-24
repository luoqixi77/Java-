package internet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author luoqixi77
 * @version 1.0
 * @date 2023/3/21 10:00
 * @Description TODO
 */
public class TCP {



    public static void client() throws IOException {
        // 1、创建Socket对象，指明服务端的IP和端口号
        Socket s = new Socket("192.168.40.165",9999);
        // 2、获取一个输出流，用于输出数据
        OutputStream out = s.getOutputStream();
        // 3、写出数据
        out.write("hello".getBytes());
        // 4、回收资源
        s.close();
    }
    public static void server() throws IOException {
        // 1、创建服务端的ServerSocket，指明自己的端口号
        ServerSocket ss = new ServerSocket(9999);
        // 2、调用accept()监听来自客户端的连接
        Socket s = ss.accept ();
        // 3、获取输入流，读取输入流的数据
        InputStream in = s.getInputStream();
        byte[] buf = new byte[1024];
        int num = in.read(buf);
        String str = new String(buf,0,num);
        System.out.println(s.getInetAddress().toString()+":"+str);
        // 4、回收资源
        s.close();
        ss.close();






    }
}

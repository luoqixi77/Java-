import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author luoqixi77
 * @version 1.0
 * @date 2023/3/21 10:26
 * @Description 通信测试
 */
public class Test_1 {
    /* 客户端 */
    @Test
    public void client() {
        OutputStream output = null;
        Socket socket = null;
        try {
            InetAddress localHost = InetAddress.getByName("127.0.0.1");
            socket = new Socket(localHost, 8848);
            output = socket.getOutputStream();
            output.write("hello I'm the client".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* 服务端 */
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream input = null;
        ByteArrayOutputStream out = null;
        try {
            serverSocket = new ServerSocket(8848);
            socket = serverSocket.accept();
            System.out.println("client IP: " + socket.getInetAddress());
            input = socket.getInputStream();
            out = new ByteArrayOutputStream();
            byte[] buffer = new byte[10];
            int len;
            while ((len = input.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            System.out.println(out.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


package Nio.File;

import java.io.IOException;
import java.net.Socket;

/**
 * @author luoqixi77
 * @version 1.0
 * @date 2023/3/23 9:28
 * @Description TODO
 */
public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080)) {
            System.out.println(socket);
            socket.getOutputStream().write("world".getBytes());
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

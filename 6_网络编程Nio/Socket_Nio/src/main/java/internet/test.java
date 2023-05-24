package internet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author luoqixi77
 * @version 1.0
 * @date 2023/3/21 14:06
 * @Description TODO
 */
public class test {
    public static void main(String[] args) {
        OutputStream output = null;
        Socket socket = null;
        try {
            InetAddress localHost = InetAddress.getByName("127.0.0.1");
            socket = new Socket(localHost, 8848);
            output = socket.getOutputStream();
            PrintStream printStream = new PrintStream(output);
            while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("请讲:");
                printStream.println(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

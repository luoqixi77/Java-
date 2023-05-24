import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author luoqixi77
 * @version 1.0
 * @date 2023/3/21 10:49
 * @Description UDP
 */
public class Test_3 {
        @Test // 发送端
        public void send() throws IOException {
            DatagramSocket socket = new DatagramSocket();

            byte[] data = "hello".getBytes();
            DatagramPacket packet = new DatagramPacket(data,0,data.length, InetAddress.getLocalHost(),8080);

            socket.send(packet);

            socket.close();
        }

        @Test // 接收端
        public void receiver() throws IOException {
            DatagramSocket socket = new DatagramSocket(8080);

            byte[] buffer = new byte[100];
            DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);

            socket.receive(packet);

            System.out.println(new String(packet.getData(),0,packet.getLength()));

            socket.close();
        }
    }


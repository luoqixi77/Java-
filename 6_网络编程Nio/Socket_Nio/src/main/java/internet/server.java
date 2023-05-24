package internet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author luoqixi77
 * @version 1.0
 * @date 2023/3/21 14:07
 * @Description TODO
 */
public class server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8848);
        while (true) {
            Socket accept = serverSocket.accept();
            new ServerReaderThread(accept).start();
        }

    }
}



    class ServerReaderThread extends Thread{
        public Socket socket;
        public ServerReaderThread(Socket socket){
            this.socket=socket;
        }

        @Override
        public void run() {
            try{
                InputStream inputStream = socket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line;
                while((line= bufferedReader.readLine())!=null){
                    System.out.println(line);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


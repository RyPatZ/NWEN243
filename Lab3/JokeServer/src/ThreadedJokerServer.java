
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The attribution of the code : https://www.codejava.net/java-se/networking/java-socket-server-examples-tcp-ip
 */
public class ThreadedJokerServer {
    public static void main(String[] args) throws Exception {
        try {
            ServerSocket serverSocket = new ServerSocket(5001);
            int count = 0;
            while (true) {
                count++;
                System.out.println("Client No:" + count + " connected to the Server.\n");
                Socket serverClient = serverSocket.accept();
                new thread(serverClient).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description: <br/>
 * The multithread version of the Server.
 * 
 * The attribution of the code is from the website:
 * <p>
 * http://net-informations.com/java/net/multithreaded.htm#:~:text=Multithreading%20in%20java%20is%20a,your%20computer%20has%20multiple%20CPUs.
 * <p>
 * 
 * @author Yun Zhou 300442776
 * @version 1.0
 */
public class MultiThreadServer {

    public static void main(String[] args) throws Exception {
        try {
            ServerSocket serverSocket = new ServerSocket(5555);
            int counter = 0;
            System.out.println(
                    "Welcome to the MultiThread Server!" +
                               "\nServer Started ...." +
                               "\nWaiting for Clients");

            while (true) {
                counter++;
                // server accept the client connection request
                Socket serverClient = serverSocket.accept();
                System.out.println(
                        " >> " + "Client No:" + counter +
                                   " connected to the Server Successfully!\n");
                // send the request to a separate thread
                ClientServerThread cst = new ClientServerThread(serverClient, counter);
                // Cause this thread to begin execution
                cst.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * The attribution of the code : https://www.codejava.net/java-se/networking/java-socket-server-examples-tcp-ip
 */
public class JokerClient {

    private final String IP_ADDRESS = "3.25.175.81";

    private final int NORMAL_PORT = 5000;

    private final int THREAD_PORT = 5001;



    public JokerClient() {
        try {

            //Socket socket = new Socket("localhost", NORMAL_PORT);
             //Socket socket = new Socket(IP_ADDRESS, NORMAL_PORT);
           // Socket socket = new Socket("localhost", THREAD_PORT);
            Socket socket = new Socket(IP_ADDRESS, THREAD_PORT);


            // Construct IO
            InputStream inputStream = socket.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String message = null;
            while ((message = bufferedReader.readLine()) != null) {
                System.out.println(message);
            }

            socket.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new JokerClient();
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * The attribution of the code : https://www.codejava.net/java-se/networking/java-socket-server-examples-tcp-ip
 */
public class JokerClient {

    private String IP_ADDRESS = "54.252.221.182";

    private final int NORMAL_PORT = 5005;

    private final int THREAD_PORT = 5001;



    public JokerClient() {
        try {
            for(int i =0; i<=10;i++) {
                if(IP_ADDRESS.equals("54.252.221.182")){
                    IP_ADDRESS = "13.211.233.22";
                }
                else {
                    IP_ADDRESS = "54.252.221.182";
                }
                //Socket socket = new Socket("localhost", NORMAL_PORT);
                Socket socket = new Socket(IP_ADDRESS, NORMAL_PORT);
                // Socket socket = new Socket("localhost", THREAD_PORT);
                // Socket socket = new Socket(IP_ADDRESS, THREAD_PORT);


                // Construct IO
                InputStream inputStream = socket.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String message = null;
                while ((message = bufferedReader.readLine()) != null) {
                    System.out.println(message);
                }


                socket.close();
            }

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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Description: <br/>
 * The attribution of the code is from the website:
 * <p>
 * https://www.runoob.com/java/net-serversocket-socket.html
 * 
 * @author Yun Zhou 300442776
 * @version 1.0
 */
public class MyClient {

    private final String IP_ADDRESS = "18.214.100.94";

    private final int NORMAL_PORT = 5000;

    @SuppressWarnings("unused")
    private final int THREAD_PORT = 5555;

    /**
     * 
     * Description: <br/>
     * Set up the Client.
     * 
     * The attribution of the code is from the website:
     * <p>
     * https://www.runoob.com/java/net-serversocket-socket.html
     * 
     * @author Yun Zhou
     */
    private void setUp() {
        try {

            // Socket socket = new Socket("localhost", NORMAL_PORT);

            // Socket socket = new Socket(IP_ADDRESS, NORMAL_PORT);
            Socket socket = new Socket(IP_ADDRESS, THREAD_PORT);

            // Construct IO
            InputStream inputStream = socket.getInputStream();
            // OutputStream outputStream = socket.getOutputStream();

            // write a message to the Server
            // BufferedWriter bufferedWriter = new BufferedWriter(new
            // OutputStreamWriter(outputStream));
            // bufferedWriter.write("Hi, I am a client and I need a joke\n");
            // bufferedWriter.flush();

            // read the returned message from the Server and print it
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String message = null;
            while ((message = bufferedReader.readLine()) != null) {
                System.out.println(message);
            }

            // System.out.println("Server: " + mess);
            socket.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * A constructor. It construct a new instance of MyClient.
     *
     */
    public MyClient() {
        setUp();
    }

    public static void main(String[] args) {
        new MyClient();
    }

}

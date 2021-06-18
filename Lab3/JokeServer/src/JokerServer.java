
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.net.InetAddress;

/**
 * The attribution of the code : https://www.codejava.net/java-se/networking/java-socket-server-examples-tcp-ip
 */
public class JokerServer {

    private final String[] JOKES = {
            "Q: How do all the oceans say hello to each other?\nThey wave!",
            "Q: What did one wall say to the other wall?\nI’ll meet you at the corner!",
            "Q: What do you call a bear with no teeth?\nA gummy bear!",
            "Q: What do you call cheese that isn’t yours?\nNacho cheese!",
            "Q: Where do cows go for entertainment?\nTo the moo-vies!"
    };

    public JokerServer() {
        while (true) {
            // set up the Server
            try {
                String	ip	=	(InetAddress.getLocalHost().getHostAddress());
                int port = 5005;
                ServerSocket serverSocket = new ServerSocket(port);
                System.out.println("Server is listening on port " + port);
                Socket socket = serverSocket.accept();
                System.out.println("Client:" + socket.getInetAddress().getLocalHost() +
                        " connected to the Server Successfully!");

                OutputStream output = socket.getOutputStream();

                int randomIndex = (int) (Math.random() * JOKES.length);
                String joke = ip+ " tells a joke:\n";
                joke += JOKES[randomIndex] + "\n";
                String jokeString = joke;
                PrintWriter writer = new PrintWriter(output, true);
                writer.println(jokeString);
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        new JokerServer();
    }

}


import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * The attribution of the code : https://www.codejava.net/java-se/networking/java-socket-server-examples-tcp-ip
 */
public class thread extends Thread {
    Socket socket;


    private final String[] JOKES = {
            "Q: How do all the oceans say hello to each other?\nThey wave!",
            "Q: What did one wall say to the other wall?\nI’ll meet you at the corner!",
            "Q: What do you call a bear with no teeth?\nA gummy bear!",
            "Q: What do you call cheese that isn’t yours?\nNacho cheese!",
            "Q: Where do cows go for entertainment?\nTo the moo-vies!"
    };

    thread(Socket inSocket) {
        socket = inSocket;
    }

    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
                int randomIndex = (int) (Math.random() * JOKES.length);
                String joke = "Joke:\n";
                joke += JOKES[randomIndex] + "\n Student ID : 300490953";
                String jokeString = joke;
                writer.println(jokeString);
                socket.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
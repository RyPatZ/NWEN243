
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Description: <br/>
 * This class handled the request independent of any other incoming requests.
 *
 * The attribution of the code is from the website:
 * <p>
 * http://net-informations.com/java/net/multithreaded.htm#:~:text=Multithreading%20in%20java%20is%20a,your%20computer%20has%20multiple%20CPUs.
 * <p>
 * 
 * @author Yun Zhou 300442776
 * @version 1.0
 */
public class ClientServerThread extends Thread {
    /**
     * serverClient:
     */
    Socket serverClient;

    /**
     * clientNo:
     */
    int clientNo;

    /**
     * squre:
     */
    int squre;

    /**
     * Jokes are from the website: https://www.rd.com/list/short-jokes/
     */
    private final String[] JOKES = {
            "What’s the best thing about Switzerland?\nI don’t know, but the flag is a big plus.",
            "Did you hear about the mathematician who’s afraid of negative numbers?\nHe'll stop at nothing to avoid them.",
            "Why do we tell actors to 'break a leg?'\nBecause every play has a cast.",
            "Hear about the new restaurant called Karma?\nThere’s no menu: You get what you deserve.",
            "Why don’t scientists trust atoms?\nBecause they make up everything.",
            "Why did the chicken go to the séance?\nTo get to the other side."
    };

    /**
     * 
     * A constructor. It construct a new instance of ThreadClientServer.
     *
     * @param inSocket
     *            server client socket
     * @param counter
     *            number of the client
     */
    ClientServerThread(Socket inSocket, int counter) {
        serverClient = inSocket;
        clientNo = counter;
    }

    public void run() {
        try {
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(serverClient.getOutputStream()));

            // pick a joke and then write it and flush it
            String jokeString = pick_Joke();
            bw.write(jokeString);
            bw.flush();
            bw.close();

            serverClient.close();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            System.out.println("Client -" + clientNo + " exit!! ");
        }
    }

    /**
     * 
     * Description: <br/>
     * Construct a String which contains: my name,Student ID and a joke from the
     * array.
     * 
     * The string is used for writing to the Client and will print it on the
     * Client consle
     * 
     * @author Yun Zhou
     * @return my name,Student ID and a joke from the array.
     */
    public String pick_Joke() {
        // random get the joke from the joke array
        int randomIndex = (int) (Math.random() * JOKES.length);
        String toReturn = "\nHello, Yun Zhou!\nYour Student ID: 300442776\n" +
                          "There is a joke for you. Enjoy :)\n";
        toReturn += JOKES[randomIndex];
        toReturn += "\n";
        return toReturn;
    }
}

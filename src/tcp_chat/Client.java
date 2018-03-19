package tcp_chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Ticona
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Client cl=new Client();
        cl.ConnessioneC();
        cl.InviaC();
        cl.RiceviC();
        cl.ChiusuraC();
    }

    Socket connection;
    String ip;
    int port;
    PrintWriter out;
    BufferedReader in;
    String colorC;
    String messaggeC;
    Chat cc;

    public Client() {
        ip = "localhost";
        port = 2000;
        out = null;
        in = null;
    }

    public void ConnessioneC() throws IOException {
        connection = new Socket(ip, port);
        System.out.println("Connessione aperta");
    }

    public void InviaC() throws IOException {

        out = new PrintWriter(connection.getOutputStream());
        out.println("Inviami messaggio");
        out.flush();
    }

    public void RiceviC() throws IOException {

        in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        /*String stampa=in.readLine();
         System.out.println("Data: "+ stampa);
         */
        System.out.println("ciao" + (String) in.readLine());
    }

    public void ChiusuraC() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connessione chiusa!");
            }
        } catch (IOException e) {
            System.err.println("Errore nella chiusura della connessione!");
        }
    }

}

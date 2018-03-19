package tcp_chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Ticona
 */
public class Server {

    public static void main(String[] args) throws IOException {
        Server sr=new Server();
        sr.Accendi();
        sr.ConnessioneS();
        sr.Comunica();
        sr.InviaS();
        sr.RiceviS();
        sr.ChiusuraS();
    }

    int port;
    ServerSocket server;
    Socket connection;
    String ip;
    String colorS;
    String messsaggeS;
    PrintWriter out;
    BufferedReader in;
    Chat cs;

    public Server() {
        port = 2000;
        out = null;
        in = null;

    }

    public void Accendi() throws IOException {
        server = new ServerSocket(port);
        System.out.println("In attesa di connessioni!");
    }

    public void ConnessioneS() throws IOException {
        connection = server.accept();
        System.out.println("Connessione stabilita!");
        System.out.println("Socket server: " + connection.getLocalSocketAddress());
        System.out.println("Socket client: " + connection.getRemoteSocketAddress());

    }

    public void InviaS() throws IOException {

        out = new PrintWriter(connection.getOutputStream());
        out.println("Inviami messaggio");
        out.flush();
    }

    public void RiceviS() throws IOException {

        in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        /*String stampa=in.readLine();
         System.out.println("Data: "+ stampa);
         */
        System.out.println("ciao" + (String) in.readLine());
    }

    public void Comunica() throws IOException {
        in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        /*String stampa=in.readLine();
         System.out.println("Il client ha detto: "+ stampa);
         */
        System.out.println("Il client ha detto: " + (String) in.readLine());
        out = new PrintWriter(connection.getOutputStream());
        out.flush();
    }

    public void ChiusuraS() {
        try {
            if (server != null) {
                server.close();
            }
        } catch (IOException ex) {
            System.err.println("Errore nella chiusura della connessione!");
        }
        System.out.println("Connessione chiusa!");
    }

}

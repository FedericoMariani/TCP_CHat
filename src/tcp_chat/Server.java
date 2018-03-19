package tcp_chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Ticona
 */
public class Server {

    public static void main(String[] args) throws IOException {
        Server sr=new Server();
        sr.Accendi();
        sr.ConnessioneS();
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
    DataInputStream in;
    DataOutputStream out;
    Chat cs;
    String autore;
    
    public Server() {
        port = 2000;
        out = null;
        in = null;
        autore="Server";

    }

    public void Accendi() throws IOException {
        server = new ServerSocket(port);
        System.out.println("In attesa di connessioni!");
    }

    public void ConnessioneS() throws IOException {
        connection = server.accept();
        System.out.println("Connessione stabilita!");

    }

    public void InviaS() throws IOException {
        Scanner a=new Scanner(System.in);
        out = new DataOutputStream(connection.getOutputStream());
        String ms = a.nextLine();
        out.writeUTF(ms);
        out.flush();
    }

    public void RiceviS() throws IOException {
        in = new DataInputStream(connection.getInputStream());
        System.out.println("Client: " + in.readUTF());
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

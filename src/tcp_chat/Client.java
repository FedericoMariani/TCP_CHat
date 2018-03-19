package tcp_chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Ticona
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Client cl=new Client();
        cl.ConnessioneC();
        cl.RiceviC();
        cl.InviaC();
        cl.ChiusuraC();
    }

    Socket connection;
    String ip;
    int port;
    String colorC;
    String messaggeC;
    Chat cc;
    String autore;
    DataInputStream in;
    DataOutputStream out;

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

        Scanner a=new Scanner(System.in);
        out = new DataOutputStream(connection.getOutputStream());
        String ms = a.nextLine();
        out.writeUTF(ms);
        out.flush();
    }

    public void RiceviC() throws IOException {

        in = new DataInputStream(connection.getInputStream());
        System.out.println("Server:" + in.readUTF());
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

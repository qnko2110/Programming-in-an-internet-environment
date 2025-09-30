package server;

import java.io.*;
import java.net.*;

class ServeClient extends Thread {

    private final BufferedReader in;
    private final PrintWriter out;
    private final Socket socket;

    // -------------------------------------------------------------------------
    public ServeClient(Socket s) throws IOException {
        socket = s;
        in = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                socket.getOutputStream())), true);
    }

    // -------------------------------------------------------------------------
    @Override
    public void run() {

        try {
            while (true) {
                String instr = in.readLine();
                System.out.println("Client: " + instr);
                if (instr.equals("end")) {
                    break;
                }
                out.println("Server: " + instr);
            }
            System.out.println("Connection closed");
        } catch (IOException e) {
            System.out.println("Communication error!");
        } finally {
            try {
                socket.close();
                in.close();
                out.close();
            } catch (IOException e) {
                System.out.println("Can't close socket!");
            }
        }
    }
    // -------------------------------------------------------------------------						
}

public class Server {

    static final int PORT = 8000;

    public static void main(String[] args) throws IOException {

        ServerSocket s = new ServerSocket(PORT);
        System.out.println("Server starting ...");
        try {
            while (true) {
                Socket socket = s.accept();
                try {
                    ServeClient serveClient = new ServeClient(socket);
                    serveClient.start();
                } catch (IOException e) {
                    socket.close();
                    System.out.println("Error ...");
                }
            }

        } finally {
            s.close();
        }

    }
    // -------------------------------------------------------------------------

}

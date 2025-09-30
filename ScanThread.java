/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanthread;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author User
 */
public class ScanThread extends Thread{
    static final int START_PORT = 1;
    static final int END_PORT = 65535;
    static final int TIMEOUT = 2500;
    static final String HOST_NAME = "localhost";
    static Socket socket;
    static InetAddress ip;
    public ScanThread(String s) {
        super(s);
    } 
    @Override
    public void run() {
        int port = Integer.parseInt(getName());
        try
        {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(ip, port), TIMEOUT );
            System.out.println(port);
        } catch (IOException ex) {      
        }
        finally {
            socket = null;
        }
    }
    public static void main(String[] args) {
     try {
         ip = InetAddress.getByName(HOST_NAME);
     } catch (UnknownHostException uhs) {
       System.out.println("Невалидно име на хост!");
       return;
     }
     System.out.println("\"Отворени\" портове");
     for (int i = START_PORT; i<= END_PORT; i++) {
         (new ScanThread("" + i)).start();
     }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanports;

import java.io.*;
import java.net.*;

public class ScanPortsWithThreads {

    static final int START_PORT = 1;
    static final int END_PORT = 1024;
    static final int TIMEOUT = 3000;
    static final String HOST_NAME = "www.tugab.bg";
    static Socket socket;
    static InetAddress ip;
    // -------------------------------------------------------------------------
    public static void main(String ... pars) {
        try {
            ip = InetAddress.getByName(HOST_NAME);
        } catch (UnknownHostException uhs) {
            System.out.println("Невалидно има на хост!");
            return;
        }
        System.out.println("\"Отворени\" портове:");
        for (int i = START_PORT; i <= END_PORT; i++) {
            (new ScanThread("" + i)).start();
        }    
    }
    // -------------------------------------------------------------------------
    static class ScanThread extends Thread {
        public ScanThread(String name) {
            super(name);
        }	
        @Override
        public void run() {
            
            int port = Integer.parseInt(getName());
            try 
            {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(ip, port), TIMEOUT);
                System.out.println(port);
            } catch (IOException ex) { 
                
            }
            finally 
            {
                socket = null;
            }
        }	
    }
    // -------------------------------------------------------------------------	

}

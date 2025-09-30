/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getwebserverinfo2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 *
 * @author User
 */
public class GetWebServerInfo2 {

 static final int PORT = 80;
 static final int TIMEOUT = 2500;
  static final String HOST_NAME = "www.kst.tugab.bg";
    public static void main(String[] args) {
        InetAddress ip;
        try {
            ip = InetAddress.getByName(HOST_NAME);
        } catch (UnknownHostException ex) {
          System.out.println("Неразпознато име на хост!");
          return;
        }
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(ip, PORT), TIMEOUT);
            System.out.println("Порт" + PORT + "е отворен.");
        } catch (SocketTimeoutException ste) {
           System.out.println("Сървърът не отговаря!"); 
        } catch (IOException ioe) {
          System.out.println("Порт" + PORT + "е затворен.");  
        }
    }
    
}

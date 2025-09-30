/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getwebserverinfo3;

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
public class GetWebServerInfo3 {

    static final int START_PORT = 79;
    static final int END_PORT = 81;
    static final int TIMEOUT = 6500;
    static final String HOST_NAME = "www.kst.tugab.bg";

    public static void main(String[] args) {
        InetAddress ip;
        try {
            ip = InetAddress.getByName(HOST_NAME);
        } catch (UnknownHostException ex) {
            System.out.println("Неразпознато име на хост!");
            return;
        }
        

        for (int i = START_PORT; i <= END_PORT; i++) {
            Socket socket = new Socket();
            try {
                socket.connect(new InetSocketAddress(ip, i), TIMEOUT);
                System.out.println("Порт" + i + "е отворен.");
            } catch (SocketTimeoutException ste) {
                System.out.println("Сървърът не отговаря!");
            } catch (IOException ioe) {
                System.out.println("Порт" + i + "е затворен.");
            }
        }
    }

}

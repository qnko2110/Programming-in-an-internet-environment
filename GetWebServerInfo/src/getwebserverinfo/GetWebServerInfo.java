/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getwebserverinfo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author User
 */
public class GetWebServerInfo {

  final static String REQUEST = "http://www.fbi.gov";
    public static void main(String[] args) {
        try{
            URL server =new URL(REQUEST);
            URLConnection conn = server.openConnection();
            String serverInfo = conn.getHeaderField("Server");
            if (serverInfo != null) {
                System.out.println(serverInfo);
            } else {
                if (conn.getContentLength() == -1) {
                   System.out.println("Липсва мрежова свързаност,"+"протоколът не се поддържа или няма такъв хост!");
                   
                } else {
                    System.out.println("Не е зададено име на Web сървъра!"); 
                } 
            }
        } catch (MalformedURLException ex) {
          System.out.println("Невалиден синтаксис на задачата!");  
        } catch (IOException ex) 
        {
         System.out.println("Грешка при комуникация със сървъра!");   
        }
    }
    
}

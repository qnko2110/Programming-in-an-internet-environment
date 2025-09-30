package scan;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScanPortWithTreadPool {

 final static int TIMEOUT = 2500;
static final int START_PORT = 1;
static final int END_PORT = 1024;
static final String HOST_NAME = "www.tugab.bg";
static Socket socket;
static InetAddress ip;
final static int NUM_OF_THREADS =900;

 public static void main(String[] args) {

 try {
ip = InetAddress.getByName(HOST_NAME);
} catch (UnknownHostException uhs) {
System.out.println("Невалидно име на хост.");
return;
}

 //ExecutorService pool = Executors.newFixedThreadPool(NUM_OF_THREADS);
ExecutorService pool = Executors.newCachedThreadPool();
for (int i = START_PORT; i < END_PORT; i++) {
pool.execute(new ScanJob(i));
}

 pool.shutdown();
}

 static class ScanJob implements Runnable {

 private Socket socket;
int port;

 public ScanJob(int port) {
this.port = port;
}

 @Override
public void run() {

 try {

 Socket socket = new Socket();
socket.connect(new InetSocketAddress(ip, port), TIMEOUT);
System.out.println(port);

 } catch (IOException ex) {

 } finally {

 socket = null;

 }
}
}
}
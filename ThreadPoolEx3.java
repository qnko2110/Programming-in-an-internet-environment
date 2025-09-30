
package threadpoolex3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolEx3 {

    final static int NUM_OF_THREADS = 600;

    static final int START_PORT = 1;
    static final int END_PORT = 1024;
    static final int TIMEOUT = 3500;
    static final String HOST_NAME = "www.tugab.bg";
    
    static InetAddress ip;
    static int port;

    public static void main(String[] args) {

        try {
            ip = InetAddress.getByName(HOST_NAME);
        } catch (UnknownHostException uhs) {
            System.out.println("Невалидно има на хост или няма мрежова свързаност!");
            return;
        }
        System.out.println("Моля, изчакайте ...");
        //ExecutorService pool = Executors.newFixedThreadPool(NUM_OF_THREADS);
        ExecutorService pool = Executors.newCachedThreadPool();
        
        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = START_PORT; i <= END_PORT; i++) {
            tasks.add(new ScanPortJob(i));
        }
        List<Future<String>> results = null;
        try {
            results = pool.invokeAll(tasks);
        } catch (InterruptedException ex) {
        }
        for (Future<String> result : results) {
            try {
                String status = result.get();
                if (!status.isEmpty()) {
                    System.out.println(status);
                }
            } catch (InterruptedException | ExecutionException ex) {
            }
        }
        pool.shutdown();

    }

    static class ScanPortJob implements Callable {

        int port;

        public ScanPortJob(int port) {
            this.port = port;
        }

        @Override
        public String call() {
            String status = "";
            Socket socket = null;
            try {
                socket = new Socket();
                socket.connect(new InetSocketAddress(ip, port), TIMEOUT);
                status = "" + port;
            } catch (IOException ex) {
            } finally {
                socket = null;
            }
            return status;
        }
    }

}

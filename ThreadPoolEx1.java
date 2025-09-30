
package threadpoolex1;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolEx1 {

    final static int NUM_OF_TASKS = 20;
    final static int NUM_OF_THREADS = 4;
    final static int WAIT_TIME_IN_MS = 2500;
    
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("CPU cores: " + cores);

        Runnable runnableTask = () -> {
            long timeout = new Random().nextInt(WAIT_TIME_IN_MS);
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException ex) {
            }
            System.out.println("Task: " + timeout);
        };

        ExecutorService pool = Executors.newFixedThreadPool(NUM_OF_THREADS);
        for (int i=1; i<= NUM_OF_TASKS; i++) {
            pool.execute(runnableTask);
        }
        
        pool.shutdown();
    }

}

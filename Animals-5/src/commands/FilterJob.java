
package commands;

public class FilterJob implements Job {

    private Filter filter;

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public void run() {
        System.out.println("Job ID: " + Thread.currentThread().getId()
                + " executing - filter jobs.");
        if (filter != null) {
            synchronized (lock) {
                filter.execute();
                lock.notifyAll();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

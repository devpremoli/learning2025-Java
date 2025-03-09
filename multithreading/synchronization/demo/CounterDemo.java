package multithreading.synchronization.demo;

class NoSyncCounter {
    private int count = 0;

    public void increment() {
        count++; // not thread-safe
    }

    public int getCount() {
        return count;
    }
}

class SyncCounter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }
    public int getCount() {
        return count;
    }
}

public class CounterDemo {

    public  static void main(String[] args) {

        NoSyncCounter noSynccounter = new NoSyncCounter();
        SyncCounter syncCounter = new SyncCounter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                noSynccounter.increment();
                syncCounter.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                noSynccounter.increment();
                syncCounter.increment();
            }
        });
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                noSynccounter.increment();
                syncCounter.increment();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final syncCounter: " + syncCounter.getCount());
        System.out.println("Final noSyncCounter: " + noSynccounter.getCount());
    }
}

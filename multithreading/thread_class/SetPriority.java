package multithreading.thread_class;

class MyThreadA extends Thread {
    public MyThreadA(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 1_000_000; i++); // Simulating CPU work
        System.out.println(getName() + " - Priority: " + getPriority());
    }
}

/*
Thread priority does not guarantee execution order – It depends on OS scheduling. Higher-priority threads get more CPU time but may not always run first.
 */
public class SetPriority {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " started.");

        MyThreadA t1 = new MyThreadA("Thread-1");
        MyThreadA t2 = new MyThreadA("Thread-2");
        MyThreadA t3 = new MyThreadA("Thread-3");

        t1.setPriority(Thread.MIN_PRIORITY);  // Priority 1
        t2.setPriority(Thread.NORM_PRIORITY); // Priority 5 (default)
        t3.setPriority(Thread.MAX_PRIORITY);  // Priority 10

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

        System.out.println("Main thread finished.");
    }
}

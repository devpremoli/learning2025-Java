package multithreading.thread_class;

import java.util.logging.Level;
import java.util.logging.Logger;


class MyThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started.");
        try {
            Thread.sleep(3000); // Simulating task
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(Thread.currentThread().getName() + " was interrupted!");
            System.out.println("Is thread interrupted? " + Thread.currentThread().isInterrupted()); // Always false

        }
        System.out.println(Thread.currentThread().getName() + " finished.");
    }
}

/*
public final void join() throws InterruptedException
-> Causes the current (calling) thread to wait indefinitely until the thread on which join() is called completes execution.

public final void join(long millis) throws InterruptedException
-> Causes the current thread to wait for up to the specified milliseconds for the thread to complete execution. If the thread does not finish within
the time limit, the current thread resumes execution.

public final void join(long millis, int nanos) throws InterruptedException
-> Causes the current thread to wait for up to the specified milliseconds plus nanoseconds for the thread to complete execution. If the thread does not finish within
the time limit, the current thread resumes execution.

public final boolean join(Duration duration) throws InterruptedException
(Available in Java 19+)
-> Causes the current thread to wait for up to the given duration for the thread to complete execution. Returns true if the thread has terminated before the timeout,
otherwise false.


-> When a thread is waiting for a thread to finish using join() and another thread interrupts it, join() throws InterruptedException.
The interrupted status of the calling thread is cleared, meaning Thread.interrupted() will return false immediately after the exception is caught.
 */
public class JoinMethod {
    private static final Logger LOGGER = Logger.getLogger(JoinMethod.class.getName());
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " started.");

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();
        try {
            t1.join(); // Main thread waits for t1 to complete
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, "Main thread interrupted while waiting for t1", e);
        }
        t2.start(); // Only starts AFTER t1 finishes
        try {
            t2.join(); // Main thread waits for t1 to complete
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, "Main thread interrupted while waiting for t2", e);
        }
        System.out.println("Main thread finished.");
    }
}

class InterruptThread {

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();

        try {
            Thread.sleep(2000); // Give t1 some time to start
            t1.interrupt();  // Interrupt t1
            t1.join(); // Main thread waits for t1
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted!");
        }
        System.out.println("Main thread finished.");
    }
}

package multithreading;

class MyThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class ThreadClass {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName()); // main thread

        MyThread t1 = new MyThread();
        t1.start();
    }
}

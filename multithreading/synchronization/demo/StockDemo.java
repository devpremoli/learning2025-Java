package multithreading.synchronization.demo;

// Separate locks for independent resources. Threads modifying ProductAStock do not block threads modifying ProductBStock

class Warehouse {
    private int productAStock = 100;
    private int productBStock = 100;

    private final Object productALock = new Object(); // Lock for Product A
    private final Object productBLock = new Object(); // Lock for Product B

    public void addProductA(int amount) {
        synchronized (productALock) {
            productAStock += amount;
            System.out.println(Thread.currentThread().getName() + " added " + amount + " Product A. New stock: " + productAStock);
        }
    }

    public void addProductB(int amount) {
        synchronized (productBLock) {
            productBStock += amount;
            System.out.println(Thread.currentThread().getName() + " added " + amount + " Product B. New stock: " + productBStock);
        }
    }

    public void removeProductA(int amount) {
        synchronized (productALock) {
            if (productAStock >= amount) {
                productAStock -= amount;
                System.out.println(Thread.currentThread().getName() + " removed " + amount + " Product A. New stock: " + productAStock);
            } else {
                System.out.println(Thread.currentThread().getName() + " attempted to remove " + amount + " Product A, but not enough stock!");
            }
        }
    }

    public void removeProductB(int amount) {
        synchronized (productBLock) {
            if (productBStock >= amount) {
                productBStock -= amount;
                System.out.println(Thread.currentThread().getName() + " removed " + amount + " Product B. New stock: " + productBStock);
            } else {
                System.out.println(Thread.currentThread().getName() + " attempted to remove " + amount + " Product B, but not enough stock!");
            }
        }
    }

    public int getProductAStock() {
        return productAStock;
    }

    public int getProductBStock() {
        return productBStock;
    }
}

public class StockDemo {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        Thread addProductA = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                warehouse.addProductA(10);
                try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }, "Adder A");

        Thread addProductB = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                warehouse.addProductB(10);
                try { Thread.sleep(120); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }, "Adder B");

        Thread removeProductA = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                warehouse.removeProductA(10);
                try { Thread.sleep(150); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }, "Remover A");

        Thread removeProductB = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                warehouse.removeProductB(10);
                try { Thread.sleep(130); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }, "Remover B");


        addProductA.start();
        addProductB.start();
        removeProductA.start();
        removeProductB.start();

        try {
            addProductA.join();
            addProductB.join();
            removeProductA.join();
            removeProductB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(warehouse.getProductAStock());
        System.out.println(warehouse.getProductBStock());
    }
}

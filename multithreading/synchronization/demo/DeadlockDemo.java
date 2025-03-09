package multithreading.synchronization.demo;

// If two threads try to lock resources in a different order, a deadlock occurs.

class Account {
    private int balance;
    private final String accountName;

    public Account(String accountName, int balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public String getAccountName() {
        return accountName;
    }
}

class Transfer implements Runnable {
    private final Account sender;
    private final Account receiver;
    private final int amount;

    public Transfer(Account sender, Account receiver, int amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    @Override
    public void run() {
        synchronized (sender) {  // First Lock (Sender)
            System.out.println(Thread.currentThread().getName() + " locked " + sender.getAccountName());

            synchronized (receiver) {  // Second Lock (Receiver)
                System.out.println(Thread.currentThread().getName() + " locked " + receiver.getAccountName());

                if (sender.getBalance() >= amount) {
                    sender.withdraw(amount);
                    receiver.deposit(amount);
                    System.out.println(Thread.currentThread().getName() + " transferred $" + amount + " from " +
                            sender.getAccountName() + " to " + receiver.getAccountName());
                } else {
                    System.out.println(Thread.currentThread().getName() + " - Insufficient balance in " + sender.getAccountName());
                }
            }
        }
    }
}

public class DeadlockDemo {
    public static void main(String[] args) {
        Account account1 = new Account("Alice", 1000);
        Account account2 = new Account("Bob", 1500);

        Thread t1 = new Thread(new Transfer(account1, account2, 300), "Thread-1");
        Thread t2 = new Thread(new Transfer(account2, account1, 500), "Thread-2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance of " + account1.getAccountName() + ": $" + account1.getBalance());
        System.out.println("Final Balance of " + account2.getAccountName() + ": $" + account2.getBalance());
    }
}


package multithreading.synchronization.demo;

/*
Example of nested synchronization or reentrant synchronization.
Threads must wait for both locks to be available.
 */

class BankAccount {
    private int balance;
    private final String accountName;

    public BankAccount(String accountName, int balance) {
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

class TransferTask implements Runnable {
    private final BankAccount sender;
    private final BankAccount receiver;
    private final int amount;

    public TransferTask(BankAccount sender, BankAccount receiver, int amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    @Override
    public void run() {
        BankAccount firstLock = sender.getAccountName().compareTo(receiver.getAccountName()) < 0 ? sender : receiver;
        BankAccount secondLock = sender.getAccountName().compareTo(receiver.getAccountName()) < 0 ? receiver : sender;

        synchronized (firstLock) {
            System.out.println(Thread.currentThread().getName() + " locked " + firstLock.getAccountName());

            synchronized (secondLock) {
                System.out.println(Thread.currentThread().getName() + " locked " + secondLock.getAccountName());

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

public class MultipleLockDemo {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Alice", 1000);
        BankAccount account2 = new BankAccount("Bob", 1000);

        Thread t1 = new Thread(new TransferTask(account1, account2, 500), "Thread-1");
        Thread t2 = new Thread(new TransferTask(account2, account1, 500), "Thread-2");

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


package multithreading.synchronization.demo;

class BalanceAccount {
    private int balance;
    private static int totalBankBalance = 0;

    public BalanceAccount(int initialBalance) {
        this.balance = initialBalance;
        addToTotalBalance(initialBalance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: $" + balance);
            deductFromTotalBalance(amount);
        }
        else {
            System.out.println(Thread.currentThread().getName() + " attempted withdrawal, but insufficient funds!");
        }
    }

    // same as using synchronized keyword in the instance method
    public void deposit(int amount) {
        synchronized (this) {
            balance += amount;
            addToTotalBalance(amount);
            System.out.println(Thread.currentThread().getName() + " completed depositing balance: $" + balance);
        }
    }

    public static synchronized void addToTotalBalance(int amount) {
        totalBankBalance += amount;
        System.out.println("Total bank balance updated: $" + totalBankBalance);
    }

    // same as using synchronized keyword in the static method
    public static void deductFromTotalBalance(int amount) {
        synchronized (BalanceAccount.class) {  // Locks only this block
            totalBankBalance -= amount;
            System.out.println("Total bank balance updated: $" + totalBankBalance);
        }
    }

    public int getBalance() {
        return balance;
    }

    public static int getTotalBankBalance() {
        return totalBankBalance;
    }
}

public class BankDemo {
    public static void main(String[] args) {

        BalanceAccount account1 = new BalanceAccount(1000);
        BalanceAccount account2 = new BalanceAccount(1000);

        Thread user1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                account1.withdraw(100);
                account1.deposit(100);
            }
        }, "User-1");

        Thread user2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                account2.withdraw(100);
                account2.deposit(100);
            }
        }, "User-2");

        user1.start();
        user2.start();

        try {
            user1.join();
            user2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance of BalanceAccount 1: $" + account1.getBalance());
        System.out.println("Final balance of BalanceAccount 2: $" + account2.getBalance());
        System.out.println("Final Total Bank Balance: $" + BalanceAccount.getTotalBankBalance());
    }
}


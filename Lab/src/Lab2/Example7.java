package Lab2;

public class Example7 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Иван", 1000);

        System.out.println("Владелец: " + account.getOwner());
        System.out.println("Баланс: " + account.getBalance());

        account.deposit(500);
        System.out.println("Баланс после пополнения: " + account.getBalance());

        account.withdraw(300);
        System.out.println("Баланс после снятия: " + account.getBalance());
    }
}

interface AccountOperations {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}

class BankAccount implements AccountOperations {
    private String owner;
    private double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}
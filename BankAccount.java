import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String pin;
    private double balance;
    private List<String> transactionHistory;

    public BankAccount(String pin, double balance) {
        this.pin = pin;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with initial balance: $" + balance);
    }

    public boolean authenticate(String pin) {
        return this.pin.equals(pin);
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: $" + amount);
            return true;
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: $" + amount);
            return true;
        }
        return false;
    }

    public boolean changePIN(String newPin) {
        if (newPin.length() == 4 && newPin.matches("\\d+")) {
            this.pin = newPin;
            transactionHistory.add("PIN changed.");
            return true;
        }
        return false;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }
}


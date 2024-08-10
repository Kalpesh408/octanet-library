import java.util.ArrayList;
import java.util.Scanner;

public class ATMSimulation {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String DEFAULT_PIN = "1234";

    private static double accountBalance = 1000.00; // Initial balance
    private static String pin = DEFAULT_PIN; // Default PIN
    private static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to the ATM");
            System.out.println("1. Account Balance Inquiry");
            System.out.println("2. Cash Withdrawal");
            System.out.println("3. Cash Deposit");
            System.out.println("4. Change PIN");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Please choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    accountBalanceInquiry();
                    break;
                case 2:
                    cashWithdrawal();
                    break;
                case 3:
                    cashDeposit();
                    break;
                case 4:
                    changePIN();
                    break;
                case 5:
                    transactionHistory();
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void accountBalanceInquiry() {
        if (authenticate()) {
            System.out.printf("Your current balance is: $%.2f%n", accountBalance);
            transactionHistory.add("Checked account balance.");
        }
    }

    private static void cashWithdrawal() {
        if (authenticate()) {
            System.out.print("Enter amount to withdraw: $");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character
            
            if (amount > accountBalance) {
                System.out.println("Insufficient funds.");
            } else if (amount <= 0) {
                System.out.println("Invalid amount.");
            } else {
                accountBalance -= amount;
                System.out.printf("You have withdrawn: $%.2f%n", amount);
                transactionHistory.add("Withdrew: $" + amount);
            }
        }
    }

    private static void cashDeposit() {
        if (authenticate()) {
            System.out.print("Enter amount to deposit: $");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character
            
            if (amount <= 0) {
                System.out.println("Invalid amount.");
            } else {
                accountBalance += amount;
                System.out.printf("You have deposited: $%.2f%n", amount);
                transactionHistory.add("Deposited: $" + amount);
            }
        }
    }

    private static void changePIN() {
        if (authenticate()) {
            System.out.print("Enter new PIN: ");
            String newPIN = scanner.nextLine();
            if (newPIN.length() == 4) {
                pin = newPIN;
                System.out.println("PIN successfully changed.");
                transactionHistory.add("Changed PIN.");
            } else {
                System.out.println("PIN must be exactly 4 digits.");
            }
        }
    }

    private static void transactionHistory() {
        if (authenticate()) {
            System.out.println("Transaction History:");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    private static boolean authenticate() {
        System.out.print("Enter PIN: ");
        String enteredPIN = scanner.nextLine();
        if (enteredPIN.equals(pin)) {
            return true;
        } else {
            System.out.println("Invalid PIN. Access denied.");
            return false;
        }
    }
}


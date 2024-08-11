import java.util.Scanner;

public class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM() {
        this.account = new BankAccount("1234", 1000.0); // Example initialization
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the ATM.");
        while (true) {
            System.out.println("Please enter your PIN:");
            String pin = scanner.nextLine();
            
            if (!account.authenticate(pin)) {
                System.out.println("Invalid PIN. Try again.");
                continue;
            }

            while (true) {
                System.out.println("1. Check Balance");
                System.out.println("2. Withdraw Cash");
                System.out.println("3. Deposit Cash");
                System.out.println("4. Change PIN");
                System.out.println("5. Transaction History");
                System.out.println("6. Exit");
                System.out.print("Select an option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        withdrawCash();
                        break;
                    case 3:
                        depositCash();
                        break;
                    case 4:
                        changePIN();
                        break;
                    case 5:
                        showTransactionHistory();
                        break;
                    case 6:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private void checkBalance() {
        System.out.println("Your balance is: $" + account.getBalance());
    }

    private void withdrawCash() {
        System.out.print("Enter amount to withdraw: ");
        double amount = Double.parseDouble(scanner.nextLine());
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    private void depositCash() {
        System.out.print("Enter amount to deposit: ");
        double amount = Double.parseDouble(scanner.nextLine());
        if (account.deposit(amount)) {
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private void changePIN() {
        System.out.print("Enter new PIN: ");
        String newPin = scanner.nextLine();
        if (account.changePIN(newPin)) {
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("Invalid PIN format.");
        }
    }

    private void showTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : account.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}

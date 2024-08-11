public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("1234", 1000.0);

        // Test deposit
        account.deposit(500.0);
        System.out.println("Balance after deposit: $" + account.getBalance()); // 1500.0

        // Test withdraw
        account.withdraw(200.0);
        System.out.println("Balance after withdrawal: $" + account.getBalance()); // 1300.0

        // Test change PIN
        account.changePIN("5678");
        System.out.println("PIN changed successfully.");

        // Test transaction history
        System.out.println("Transaction History:");
        for (String transaction : account.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }
}

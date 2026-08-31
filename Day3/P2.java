// Variation A: Custom Checked Exception (Extends Exception)
// Used for recoverable conditions (e.g., business rule failures)
class InsufficientFundsException extends Exception {
    private final double deficit;

    public InsufficientFundsException(String message, double deficit) {
        super(message); // Passes error description to parent Exception class
        this.deficit = deficit;
    }

    public double getDeficit() {
        return deficit;
    }
}

// Variation B: Custom Unchecked Exception (Extends RuntimeException)
// Used for invalid program arguments / logic bugs
class InvalidAccountException extends RuntimeException {
    public InvalidAccountException(String message) {
        super(message);
    }
}

// Service class demonstrating throwing custom exceptions
class BankAccount {
    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            // Throwing unchecked exception
            throw new InvalidAccountException("Account number cannot be null or empty.");
        }
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Must declare 'throws InsufficientFundsException' because it is a checked exception
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            double deficit = amount - balance;
            // Throwing custom checked exception
            throw new InsufficientFundsException("Withdrawal failed: Overdraft limit reached.", deficit);
        }
        balance -= amount;
        System.out.println("Withdrawn: Rs." + amount + " | Remaining Balance: Rs." + balance);
    }
}

public class P2 {
    public static void main(String[] args) {
        // --- 1. Handling Custom Checked Exception ---
        System.out.println("--- 1. Checked Custom Exception Handling ---");
        BankAccount account = new BankAccount("ACC-9001", 500.0);

        try {
            System.out.println("Attempting withdrawal of Rs.650...");
            account.withdraw(650.0);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Shortfall amount: Rs." + e.getDeficit());
        }

        // --- 2. Handling Custom Unchecked Exception ---
        System.out.println("\n--- 2. Unchecked Custom Exception Handling ---");
        try {
            System.out.println("Creating account with invalid empty ID...");
            BankAccount invalidAcc = new BankAccount("", 100.0);
        } catch (InvalidAccountException e) {
            System.out.println("Caught Unchecked Exception: " + e.getMessage());
        }
    }
}

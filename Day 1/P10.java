class BankAccount {
    // --- State / Fields ---

    // Instance variables (unique to every instantiated object)
    private String accountHolder;
    private double balance;

    // Static variables (shared across the entire class, stored once in memory)
    private static String bankName = "Global Trust Bank";
    private static int totalAccounts = 0;

    // --- Constructor ---
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        totalAccounts++; // Modifies shared class-level state
    }

    // ==========================================
    // 1. INSTANCE METHODS (Object-Level Behavior)
    // ==========================================

    // Requires an object instance to be called; operates on 'this' specific object's data
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println(this.accountHolder + " deposited: Rs." + amount);
        }
    }

    // Can access BOTH instance variables ('accountHolder', 'balance') and static variables ('bankName')
    public void printStatement() {
        System.out.println("Holder: " + this.accountHolder 
                + " | Balance: Rs." + this.balance 
                + " | Bank: " + bankName);
    }

    // ==========================================
    // 2. STATIC METHODS (Class-Level Behavior)
    // ==========================================

    // Belongs to the class itself; invoked via BankAccount.displayBankSummary() without creating an object
    // CANNOT access 'this', 'accountHolder', or 'balance' directly
    public static void displayBankSummary() {
        System.out.println("=== " + bankName + " Summary ===");
        System.out.println("Total Active Accounts: " + totalAccounts);
    }

    // Static utility method: Performs a calculation based purely on passed parameters
    public static double calculateInterest(double principal, double annualRate, int years) {
        return (principal * annualRate * years) / 100.0;
    }
}

public class P10 {
    public static void main(String[] args) {
        // 1. Calling Static Methods directly using the Class Name (No object needed)
        BankAccount.displayBankSummary();

        double projectedInterest = BankAccount.calculateInterest(1000.0, 5.0, 2);
        System.out.println("Standard 2-Year Interest on Rs.1000 @ 5%: Rs." + projectedInterest);
        System.out.println();

        // 2. Creating Instances (Objects)
        BankAccount acc1 = new BankAccount("Amar", 500.0);
        BankAccount acc2 = new BankAccount("Seena", 1200.0);

        // 3. Calling Instance Methods on individual objects
        acc1.deposit(200.0);        // Modifies only Alice's balance
        acc2.deposit(300.0);        // Modifies only Bob's balance

        System.out.println("\n--- Individual Account Details ---");
        acc1.printStatement();      // Outputs Alice's state
        acc2.printStatement();      // Outputs Bob's state

        // 4. Checking Static State again after object creations
        System.out.println();
        BankAccount.displayBankSummary();
    }
}
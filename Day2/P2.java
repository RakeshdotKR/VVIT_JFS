class Account {
    String accountId;
    String ownerName;
    double balance;

    // Variation 1: Default / No-Argument Constructor
    Account() {
        // Variation 4: Constructor Chaining using this()
        // Must always be the first statement inside the constructor
        this("ACC-0000", "Guest User", 0.0);
    }

    // Variation 2: Overloaded Constructor (2 arguments)
    Account(String accountId, String ownerName) {
        // Chains to the 3-parameter constructor with default balance
        this(accountId, ownerName, 100.0);
    }

    // Variation 3: Fully Parameterized Constructor
    Account(String accountId, String ownerName, double balance) {
        // 'this.variable' resolves shadowing between parameters and instance fields
        this.accountId = accountId;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    void showAccountInfo(String scenario) {
        System.out.println(scenario + " -> ID: " + accountId 
                + " | Owner: " + ownerName 
                + " | Balance: Rs" + balance);
    }
}

public class P2 {
    public static void main(String[] args) {
        // 1. No-argument constructor
        Account acc1 = new Account();
        acc1.showAccountInfo("Default Constructor      ");

        // 2. Overloaded constructor with 2 arguments
        Account acc2 = new Account("ACC-1001", "Alice");
        acc2.showAccountInfo("Overloaded (2 Parameters)");

        // 3. Fully parameterized constructor with 3 arguments
        Account acc3 = new Account("ACC-1002", "Bob", 750.50);
        acc3.showAccountInfo("Full Parameterized       ");
    }
}


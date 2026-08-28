class CounterTracker {
    // 1. Static Constant
    public static final String TRACKER_NAME = "Global Visitor Tracker";

    // 2. Static Variable (shared across all instances)
    static int visitorCount = 0;

    // Instance Variable (unique to each instance)
    String visitorId;

    // 3. Static Initialization Block (runs once when class is loaded into JVM memory)
    static {
        System.out.println("Static Block: Initializing " + TRACKER_NAME + "...");
    }

    // Constructor
    public CounterTracker(String visitorId) {
        this.visitorId = visitorId;
        visitorCount++; // Increments shared static counter
    }

    // 4. Static Utility Method (belongs to class, no 'this' allowed)
    public static void displayTotalVisits() {
        System.out.println("Total Visits Logged: " + visitorCount);
    }

    // Instance method (can access both static and instance fields)
    public void displayVisitor() {
        System.out.println("Visitor Logged: " + this.visitorId + " | Current Total: " + visitorCount);
    }
}

public class P5 {
    public static void main(String[] args) {
        // Accessing static members directly via ClassName (No object created yet)
        System.out.println("System: " + CounterTracker.TRACKER_NAME);
        CounterTracker.displayTotalVisits();

        // Creating instances
        CounterTracker v1 = new CounterTracker("V-1001");
        CounterTracker v2 = new CounterTracker("V-1002");

        v1.displayVisitor();
        v2.displayVisitor();

        // Calling static method again reflects updated shared count
        CounterTracker.displayTotalVisits();
    }
}

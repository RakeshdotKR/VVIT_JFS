// Variation 5: Copy Constructor Pattern
class Point {
    int x;
    int y;

    // Standard parameterized constructor
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Copy constructor: creates an independent duplicate from an existing object
    public Point(Point other) {
        this.x = other.x;
        this.y = other.y;
    }

    public void display(String label) {
        System.out.println(label + " -> Coordinates: (" + x + ", " + y + ")");
    }
}

// Variation 6: Private Constructor (Utility Class Pattern)
class MathUtility {
    // Shared constant
    public static final double PI = 3.14159265359;

    // Private constructor blocks instantiation with 'new' from outside
    private MathUtility() {
        // Suppresses default public constructor to prevent object creation
    }

    // Static helper method
    public static int square(int number) {
        return number * number;
    }
}

public class P3 {
    public static void main(String[] args) {
        // --- 1. Copy Constructor Usage ---
        Point originalPoint = new Point(10, 20);
        Point clonedPoint = new Point(originalPoint); // Independent duplicate on the heap

        // Modifying the cloned point does not alter the original
        clonedPoint.x = 99;

        System.out.println("--- Copy Constructor Demo ---");
        originalPoint.display("Original Point");
        clonedPoint.display("Cloned Point  ");

        // --- 2. Private Constructor Usage ---
        System.out.println("\n--- Private Constructor Demo ---");
        // new MathUtility(); // This line causes a COMPILATION ERROR if uncommented

        // Accessing members directly via the class name
        System.out.println("PI Constant: " + MathUtility.PI);
        System.out.println("Square of 7: " + MathUtility.square(7));
    }
}

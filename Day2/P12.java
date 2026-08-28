class MathOperations {
    // 1. Overloading by Number of Arguments
    public int multiply(int a, int b) {
        return a * b;
    }

    public int multiply(int a, int b, int c) {
        return a * b * c;
    }

    // 2. Overloading by Data Types of Parameters
    public double multiply(double a, double b) {
        return a * b;
    }

    // 3. Automatic Type Promotion Demonstration
    // If no matching (int, double) exists, the smaller type promotes automatically
    public void displayResult(String label, double value) {
        System.out.println(label + ": " + value);
    }
}

public class P12 {
    public static void main(String[] args) {
        MathOperations math = new MathOperations();

        // Method resolution happens at compile-time based on method arguments
        System.out.println("2-arg int multiply: " + math.multiply(4, 5));
        System.out.println("3-arg int multiply: " + math.multiply(2, 3, 4));
        System.out.println("2-arg double multiply: " + math.multiply(2.5, 4.0));

        // Automatic Promotion: Passing an integer 100 where a double is expected
        math.displayResult("Promoted Int to Double", 100);
    }
}

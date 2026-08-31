import java.util.Scanner;

public class P1 {

    // 'throws' declares that this method might throw a checked exception to caller
    public static void validateAge(int age) throws IllegalArgumentException {
        if (age < 18) {
            // 'throw' explicitly creates and raises an exception object
            throw new IllegalArgumentException("Age must be at least 18. Provided: " + age);
        }
        System.out.println("Access granted. Age is valid. The age is correct.");
    }

    public static void main(String[] args) {
        // --- 1. Basic try-catch-finally ---
        System.out.println("--- 1. Basic try-catch-finally ---");
        try {
            int numerator = 50;
            int denominator = 0;
            int result = numerator / denominator; // Throws ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        } finally {
            // 'finally' block ALWAYS executes regardless of whether an exception occurred
            System.out.println("Finally block executed (cleanup step).");
        }

        // --- 2. Multi-catch Block (Java 7+) ---
        System.out.println("\n--- 2. Multi-catch Block ---");
        try {
            String str = null;
            int[] arr = new int[2];
            
            // Uncommenting next line would trigger NullPointerException:
            // System.out.println(str.length());
            
            arr[5] = 100; // Throws ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("Caught combined exception type: " + e.getClass().getSimpleName());
        }

        // --- 3. try-with-resources (AutoCloseable) ---
        System.out.println("\n--- 3. Try-with-resources ---");
        String simulatedInput = "Java Dev";
        // Scanner automatically closes at the end of the try block
        try (Scanner scanner = new Scanner(simulatedInput)) {
            System.out.println("Read from AutoCloseable scanner: " + scanner.nextLine());
        } // scanner.close() is called automatically here

        // --- 4. Handling methods that declare 'throws' ---
        System.out.println("\n--- 4. Handling 'throw' and 'throws' ---");
        try {
            validateAge(15);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught validation error: " + e.getMessage());
        }
    }
}

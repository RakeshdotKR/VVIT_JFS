import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        // --- 1. Operators ---
        int a = 10;
        int b = 3;

        // Arithmetic
        System.out.println("Sum: " + (a + b));
        System.out.println("Integer Division (10 / 3): " + (a / b));
        System.out.println("Remainder (10 % 3): " + (a % b));

        // Relational and Logical
        boolean isGreater = a > b;
        boolean condition = (a > 5) && (b < 5); // AND logic
        System.out.println("Is 'a' greater than 'b'? " + isGreater);
        System.out.println("Both conditions true? " + condition);

        // --- 2. Type Casting ---
        
        // Widening / Implicit (byte -> short -> int -> long -> float -> double)
        int wholeNum = 42;
        double widenedVal = wholeNum; // Automatic conversion
        System.out.println("Widened double: " + widenedVal);

        // Narrowing / Explicit (manual conversion, truncates decimal precision)
        double pi = 3.14159;
        int narrowedVal = (int) pi;   // Result is 3
        System.out.println("Narrowed int: " + narrowedVal);

        // --- 3. Input & Output ---
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine(); // Reads full string input

        System.out.print("Enter your age: ");
        int userAge = scanner.nextInt();  // Reads integer input

        System.out.println("Hello, " + name + "! You are " + userAge + " years old.");

        // Always close scanner to avoid resource leakage
        scanner.close();
    }
}

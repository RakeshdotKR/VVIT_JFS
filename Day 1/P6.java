public class P6 {
    public static void main(String[] args) {
        // --- 1. The 'break' Statement ---
        // Exits the loop immediately when the condition is met
        System.out.println("--- Break Example ---");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                System.out.println("Stopping loop early at i = " + i);
                break; // Terminates loop execution
            }
            System.out.println("Value: " + i);
        }

        // --- 2. The 'continue' Statement ---
        // Skips the rest of the current iteration and jumps to the next
        System.out.println("\n--- Continue Example (Skip Even Numbers) ---");
        for (int i = 1; i <= 5; i++) {
            if (i % 2 == 0) {
                continue; // Skip the print statement for even numbers
            }
            System.out.println("Odd Value: " + i);
        }

        // --- 3. Labeled Loop Control (Nested Loops) ---
        // Breaks out of an outer loop directly from an inner loop
        System.out.println("\n--- Labeled Break Example ---");
        outerLoop:
        for (int row = 1; row <= 3; row++) {
            for (int col = 1; col <= 3; col++) {
                if (row == 2 && col == 2) {
                    System.out.println("Breaking directly out of outerLoop at (" + row + ", " + col + ")");
                    break outerLoop; // Terminates the outer loop entirely
                }
                System.out.println("Row: " + row + ", Col: " + col);
            }
        }
    }
}


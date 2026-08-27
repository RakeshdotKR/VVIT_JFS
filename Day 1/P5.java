public class P5 {
    public static void main(String[] args) {
        // --- 1. Standard For Loop ---
        // Best used when the number of iterations is known in advance
        System.out.println("--- Standard For Loop ---");
        for (int i = 1; i <= 3; i++) {
            System.out.println("Iteration: " + i);
        }

        // --- 2. While Loop (Entry-controlled) ---
        // Condition is checked before entering the loop body
        System.out.println("\n--- While Loop ---");
        int count = 1;
        while (count <= 3) {
            System.out.println("Count is: " + count);
            count++; // Increment counter to prevent infinite loop
        }

        // --- 3. Do-While Loop (Exit-controlled) ---
        // Body executes at least once before condition is checked
        System.out.println("\n--- Do-While Loop ---");
        int start = 5;
        do {
            System.out.println("Executes once even if false. Current start: " + start);
            start++;
        } while (start < 5); // Condition is false, loop terminates

        // --- 4. Enhanced For Loop (For-Each) ---
        // Best used for traversing arrays and collections sequentially
        System.out.println("\n--- Enhanced For-Each Loop ---");
        String[] fruits = {"Apple", "Banana", "Cherry"};
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }
    }
}

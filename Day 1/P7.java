import java.util.Arrays;

public class P7 {
    public static void main(String[] args) {
        // --- 1. Declaration and Initialization ---
        
        // Approach A: Fixed-size allocation (default values: 0 for numeric types)
        int[] numbers = new int[4];
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;

        // Approach B: Direct literal initialization
        String[] colors = {"Red", "Green", "Blue"};

        // --- 2. Accessing Elements and Length ---
        System.out.println("First color: " + colors[0]);
        System.out.println("Array size: " + colors.length); // .length is a property, not a method

        // --- 3. Iteration ---
        System.out.println("\n--- Iterating with Enhanced For Loop ---");
        for (int num : numbers) {
            System.out.println("Element: " + num);
        }

        // --- 4. Common Array Utility Methods (java.util.Arrays) ---
        int[] unorganized = {50, 10, 40, 20, 30};

        // Sorting the array in-place
        Arrays.sort(unorganized);
        System.out.println("\nSorted Array: " + Arrays.toString(unorganized));

        // Binary search (works on sorted arrays)
        int targetIndex = Arrays.binarySearch(unorganized, 30);
        System.out.println("Index of 30: " + targetIndex);
    }
}


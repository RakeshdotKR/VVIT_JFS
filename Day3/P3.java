import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class P3 {
    public static void main(String[] args) {
        // 1. Instantiation (Polymorphic List interface reference)
        List<String> fruits = new ArrayList<>();

        // --- 2. Basic CRUD Operations ---
        fruits.add("Apple");          // Appends to end
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add(1, "Blueberry");   // Inserts at index 1

        System.out.println("Initial List: " + fruits);

        // Read (O(1) fast random access)
        String firstFruit = fruits.get(0);
        System.out.println("Element at index 0: " + firstFruit);

        // Update
        fruits.set(2, "Blackberry"); // Replaces element at index 2

        // Delete (by index or by object value)
        fruits.remove(3);            // Removes element at index 3 ("Orange")
        fruits.remove("Apple");      // Removes object "Apple"

        System.out.println("After updates/removals: " + fruits);
        System.out.println("Contains 'Blueberry'? " + fruits.contains("Blueberry"));
        System.out.println("Total size: " + fruits.size());

        // --- 3. Sorting ---
        fruits.add("Mango");
        fruits.add("Avocado");
        Collections.sort(fruits); // Sorts alphabetically in-place
        System.out.println("Sorted List: " + fruits);

        // --- 4. Iteration Variations ---
        System.out.println("\n--- Iteration: Enhanced For Loop ---");
        for (String item : fruits) {
            System.out.print(item + " ");
        }

        System.out.println("\n\n--- Iteration: Iterator (Safe for removals) ---");
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.equals("Mango")) {
                iterator.remove(); // Safely removes element during iteration
            }
        }
        System.out.println("List after Iterator removal: " + fruits);

        System.out.println("\n--- Iteration: Lambda forEach ---");
        fruits.forEach(f -> System.out.println("Fruit -> " + f));
    }
}


import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class P6 {
    public static void main(String[] args) {
        // --- 1. Natural Ascending Sorting ---
        System.out.println("--- 1. Natural Sorted TreeSet ---");
        TreeSet<Integer> numbers = new TreeSet<>();

        numbers.add(50);
        numbers.add(10);
        numbers.add(40);
        numbers.add(20);
        numbers.add(30);
        // numbers.add(null); // Throws NullPointerException (TreeSet requires comparable elements)

        System.out.println("Sorted Elements (Ascending): " + numbers);

        // --- 2. NavigableSet Boundary Operations ---
        System.out.println("\n--- 2. Navigable Boundary Lookups ---");
        System.out.println("First (Lowest): " + numbers.first());
        System.out.println("Last (Highest): " + numbers.last());

        // higher(x) -> strictly greater (> x); lower(x) -> strictly smaller (< x)
        System.out.println("Strictly Higher than 30: " + numbers.higher(30));
        System.out.println("Strictly Lower than 30: " + numbers.lower(30));

        // ceiling(x) -> (>= x); floor(x) -> (<= x)
        System.out.println("Ceiling of 25 (>= 25): " + numbers.ceiling(25));
        System.out.println("Floor of 25 (<= 25): " + numbers.floor(25));

        // Subsets (fromInclusive, toExclusive)
        System.out.println("Subset between [20, 50): " + numbers.subSet(20, 50));

        // --- 3. Custom Comparator Sorting (Descending Order) ---
        System.out.println("\n--- 3. Custom Comparator (Descending) ---");
        TreeSet<String> fruitsDescending = new TreeSet<>(Comparator.reverseOrder());

        fruitsDescending.add("Apple");
        fruitsDescending.add("Mango");
        fruitsDescending.add("Banana");
        fruitsDescending.add("Cherry");

        System.out.println("Descending Order Set: " + fruitsDescending);
    }
}

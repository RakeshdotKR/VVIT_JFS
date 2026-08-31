import java.util.HashSet;
import java.util.Set;

public class P5 {
    public static void main(String[] args) {
        // 1. Instantiation (Polymorphic Set interface reference)
        Set<String> languages = new HashSet<>();

        // --- 2. Uniqueness and Basic CRUD ---
        languages.add("Java");
        languages.add("Python");
        languages.add("JavaScript");
        languages.add("Java"); // Duplicate entry: ignored automatically
        languages.add(null);   // HashSet permits a single null element

        System.out.println("HashSet Elements (Unordered): " + languages);
        System.out.println("Contains 'Python'? " + languages.contains("Python"));

        languages.remove(null);
        System.out.println("After removing null: " + languages);

        // --- 3. Mathematical Set Operations ---
        Set<Integer> setA = new HashSet<>();
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setA.add(4);

        Set<Integer> setB = new HashSet<>();
        setB.add(3);
        setB.add(4);
        setB.add(5);
        setB.add(6);

        // Union (All unique elements from both sets)
        Set<Integer> union = new HashSet<>(setA);
        union.addAll(setB);
        System.out.println("\nUnion (A ∪ B): " + union);

        // Intersection (Common elements in both sets)
        Set<Integer> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);
        System.out.println("Intersection (A ∩ B): " + intersection);

        // Difference (Elements in A but not in B)
        Set<Integer> difference = new HashSet<>(setA);
        difference.removeAll(setB);
        System.out.println("Difference (A - B): " + difference);
    }
}

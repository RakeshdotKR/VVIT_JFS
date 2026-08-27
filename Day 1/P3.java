public class P3 {
    public static void main(String[] args) {
        int score = 85;

        // --- 1. Basic if / else-if / else Ladder ---
        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 75) {
            System.out.println("Grade: B");
        } else if (score >= 50) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: F (Fail)");
        }

        // --- 2. Nested if Statement ---
        int age = 20;
        boolean hasId = true;

        if (age >= 18) {
            if (hasId) {
                System.out.println("Entry permitted: Verified adult.");
            } else {
                System.out.println("Entry denied: Missing valid ID.");
            }
        } else {
            System.out.println("Entry denied: Underage.");
        }

        // --- 3. Ternary Operator (condition ? trueVal : falseVal) ---
        int number = 14;
        String parity = (number % 2 == 0) ? "Even" : "Odd";
        System.out.println(number + " is " + parity);
    }
}

public class P1 {
    public static void main(String[] args) {
        // --- Primitive Data Types ---

        // Integer types
        byte smallNumber = 127;          // 1 byte: -128 to 127
        short shortNumber = 32000;       // 2 bytes: -32,768 to 32,767
        int age = 25;                    // 4 bytes: default integer type
        long largeNumber = 9876543210L;  // 8 bytes: 'L' suffix indicates long

        // Floating-point types
        float temperature = 36.6f;       // 4 bytes: 'f' suffix indicates float
        double price = 99.99;            // 8 bytes: default decimal type

        // Character and Boolean types
        char grade = 'A';                // 2 bytes: single character in single quotes
        boolean isEnrolled = true;       // 1 bit: holds true or false

        // --- Non-Primitive / Reference Type ---
        String studentName = "Alex";     // Sequence of characters in double quotes

        // Output stored values
        System.out.println("Student: " + studentName);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
        System.out.println("Fee: $" + price);
        System.out.println("Enrolled: " + isEnrolled);
    }
}


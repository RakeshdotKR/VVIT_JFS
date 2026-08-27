public class P9 {

    // --- 1. Method Overloading (Compile-time Polymorphism) ---

    // Overload 1: Two integer arguments
    public static int multiply(int a, int b) {
        return a * b;
    }

    // Overload 2: Three integer arguments
    public static int multiply(int a, int b, int c) {
        return a * b * c;
    }

    // Overload 3: Two double arguments (different data type)
    public static double multiply(double a, double b) {
        return a * b;
    }

    // --- 2. Variable Arguments (Varargs) ---
    // The '...' syntax allows passing zero or more values as an array
    public static int sumAll(int... numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }

    public static void main(String[] args) {
        // Overloaded methods resolve based on arguments passed
        System.out.println("multiply(4, 5): " + multiply(4, 5));
        System.out.println("multiply(2, 3, 4): " + multiply(2, 3, 4));
        System.out.println("multiply(2.5, 4.0): " + multiply(2.5, 4.0));

        // Varargs method calls with different numbers of arguments
        System.out.println("\nsumAll(10, 20): " + sumAll(10, 20));
        System.out.println("sumAll(1, 2, 3, 4, 5): " + sumAll(1, 2, 3, 4, 5));
        System.out.println("sumAll() with no args: " + sumAll());
    }
}

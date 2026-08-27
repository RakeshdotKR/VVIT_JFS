public class P8 {

    // 1. Method with no parameters and void return type
    public static void printHeader() {
        System.out.println("=== Java Methods Demo ===");
    }

    // 2. Method with parameters and a return value
    public static int add(int num1, int num2) {
        return num1 + num2; // Sends calculated value back to caller
    }

    // 3. Method demonstrating Pass-by-Value behavior
    public static void modifyPrimitive(int value) {
        value = value + 10; // Modifies local copy only, original remains unaffected
        System.out.println("Inside modifyPrimitive(): " + value);
    }

    public static void main(String[] args) {
        // Calling a void method
        printHeader();

        // Calling a method with return value
        int result = add(15, 25);
        System.out.println("Result of add(15, 25): " + result);

        // Demonstrating pass-by-value
        int original = 50;
        System.out.println("Before method call: " + original);
        modifyPrimitive(original);
        System.out.println("After method call: " + original);
    }
}

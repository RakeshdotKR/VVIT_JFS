// Blueprint Class
class Product {
    // Instance variables (State / Attributes)
    String productName;
    double unitPrice;
    int quantity;

    // Instance method (Behavior)
    double calculateTotalValue() {
        return unitPrice * quantity;
    }

    // Method to display current state
    void displayDetails() {
        System.out.println("Product: " + productName 
                + " | Price: Rs" + unitPrice 
                + " | Qty: " + quantity 
                + " | Total: Rs" + calculateTotalValue());
    }
}

public class P1 {
    public static void main(String[] args) {
        // 1. Instantiating independent objects on the Heap
        Product item1 = new Product();
        item1.productName = "Keyboard";
        item1.unitPrice = 45.00;
        item1.quantity = 2;

        Product item2 = new Product();
        item2.productName = "Mouse";
        item2.unitPrice = 25.00;
        item2.quantity = 4;

        // Calling instance methods
        item1.displayDetails();
        item2.displayDetails();

        // 2. Reference assignment vs new object
        // 'item3' does NOT allocate a new object; it shares item1's reference
        Product item3 = item1;
        item3.quantity = 5; // Mutating item3 directly mutates item1

        System.out.println("\nAfter modifying item3.quantity to 5:");
        item1.displayDetails();
    }
}


// Abstract base class: Cannot be instantiated directly with 'new'
abstract class Appliance {
    String brand;

    // Abstract class can have a constructor to initialize common fields
    public Appliance(String brand) {
        this.brand = brand;
    }

    // 1. Abstract method: No implementation; subclasses MUST override this
    public abstract void turnOn();

    // 2. Concrete method: Fully implemented shared behavior
    public void displayBrand() {
        System.out.println("Brand: " + this.brand);
    }

    // 3. Final method: Cannot be overridden by subclasses
    public final void checkPowerConnection() {
        System.out.println("Power supply verified.");
    }
}

// Concrete subclass 1
class Fan extends Appliance {
    public Fan(String brand) {
        super(brand); // Calls abstract class constructor
    }

    @Override
    public void turnOn() {
        System.out.println(brand + " fan is spinning blades.");
    }
}

// Concrete subclass 2
class Refrigerator extends Appliance {
    public Refrigerator(String brand) {
        super(brand);
    }

    @Override
    public void turnOn() {
        System.out.println(brand + " refrigerator is cooling compressor.");
    }
}

public class P15 {
    public static void main(String[] args) {
        // Appliance a = new Appliance("Generic"); // COMPILE ERROR: Cannot instantiate abstract class

        // Polymorphic reference using abstract base class
        Appliance fan = new Fan("Havells");
        Appliance fridge = new Refrigerator("Samsung");

        fan.displayBrand();
        fan.checkPowerConnection();
        fan.turnOn(); // Invokes Fan's implementation

        System.out.println();

        fridge.displayBrand();
        fridge.checkPowerConnection();
        fridge.turnOn(); // Invokes Refrigerator's implementation
    }
}

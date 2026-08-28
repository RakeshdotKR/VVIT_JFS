// Top-Level Superclass (Grandparent)
class Vehicle {
    void startEngine() {
        System.out.println("Vehicle: Engine started.");
    }
}

// Mid-Level Subclass (Parent)
class FourWheeler extends Vehicle {
    // 'final' method: Subclasses cannot override this security/compliance rule
    final void displaySafetyRating() {
        System.out.println("Safety Standards: 5-Star Certified.");
    }

    void drive() {
        System.out.println("FourWheeler: Driving on road.");
    }
}

// Bottom-Level Subclass (Child): Multilevel Inheritance (Vehicle -> FourWheeler -> ElectricCar)
// 'final' class: Cannot be inherited/extended by any other class
final class ElectricCar extends FourWheeler {
    @Override
    void drive() {
        System.out.println("ElectricCar: Driving smoothly in silent EV mode.");
    }

    void charge() {
        System.out.println("ElectricCar: Fast-charging battery at 80%...");
    }
}

public class P10 {
    public static void main(String[] args) {
        ElectricCar ev = new ElectricCar();

        // 1. Inherited from Grandparent (Vehicle)
        ev.startEngine();

        // 2. Inherited from Parent (FourWheeler)
        ev.displaySafetyRating();

        // 3. Overridden in Child (ElectricCar)
        ev.drive();

        // 4. Child-specific method
        ev.charge();
    }
}

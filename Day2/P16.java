// Interface 1
interface Drivable {
    // Variables are implicitly 'public static final' (Constants)
    int MAX_SPEED_LIMIT = 120;

    // Methods are implicitly 'public abstract'
    void drive();
}

// Interface 2
interface Refuelable {
    void refuel(String fuelType);
}

// Concrete class implementing multiple interfaces
class PetrolCar implements Drivable, Refuelable {
    private final String model;

    public PetrolCar(String model) {
        this.model = model;
    }

    // Implementing method from Drivable
    @Override
    public void drive() {
        System.out.println(model + " is driving safely within speed limit: " + MAX_SPEED_LIMIT + " km/h");
    }

    // Implementing method from Refuelable
    @Override
    public void refuel(String fuelType) {
        System.out.println(model + " refueled with " + fuelType + ".");
    }
}

public class P16 {
    public static void main(String[] args) {
        PetrolCar car = new PetrolCar("Honda Civic");

        // Calling implemented methods
        car.drive();
        car.refuel("Premium Petrol");

        // Accessing interface constants directly
        System.out.println("Global Speed Limit Constant: " + Drivable.MAX_SPEED_LIMIT);
    }
}

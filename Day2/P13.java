// Base Superclass
class Shape {
    public void draw() {
        System.out.println("Drawing a generic shape.");
    }

    public double calculateArea() {
        return 0.0;
    }
}

// Subclass 1
class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle with radius " + radius);
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Subclass 2
class Square extends Shape {
    private final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Square with side " + side);
    }

    @Override
    public double calculateArea() {
        return side * side;
    }
}

public class P13 {
    public static void main(String[] args) {
        // Dynamic Method Dispatch: Base reference -> Subclass object
        Shape s1 = new Circle(5.0);
        Shape s2 = new Square(4.0);

        // JVM resolves the actual method at runtime based on the object on the heap
        s1.draw();
        System.out.printf("Circle Area: %.2f%n", s1.calculateArea());

        s2.draw();
        System.out.printf("Square Area: %.2f%n", s2.calculateArea());

        // Heterogeneous Array Processing (Unified polymorphic handling)
        System.out.println("\n--- Batch Polymorphic Processing ---");
        Shape[] shapeCollection = { new Circle(2.0), new Square(3.0), new Shape() };
        for (Shape shape : shapeCollection) {
            shape.draw();
        }
    }
}


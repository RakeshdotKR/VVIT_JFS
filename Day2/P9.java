// Base / Parent Class
class Animal {
    String name;

    // Parent Constructor
    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " is eating food.");
    }

    public void makeSound() {
        System.out.println(name + " makes a generic animal sound.");
    }
}

// Child Class 1: Single Inheritance (Animal -> Dog)
class Dog extends Animal {
    String breed;

    public Dog(String name, String breed) {
        super(name); // super() invokes the parent constructor (must be 1st statement)
        this.breed = breed;
    }

    // Method Overriding: Specialized behavior for Dog
    @Override
    public void makeSound() {
        System.out.println(name + " (" + breed + ") barks: Woof! Woof!");
    }

    public void fetch() {
        System.out.println(name + " is fetching a ball.");
    }
}

// Child Class 2: Hierarchical Inheritance (Animal -> Cat shares the same parent Animal)
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    // Method Overriding
    @Override
    public void makeSound() {
        System.out.println(name + " meows: Meow! Meow!");
    }
}

public class P9 {
    public static void main(String[] args) {
        // --- 1. Single Inheritance Demo ---
        Dog dog = new Dog("Buddy", "Golden Retriever");
        dog.eat();        // Inherited directly from parent
        dog.makeSound();  // Overridden method
        dog.fetch();      // Child-specific method

        System.out.println();

        // --- 2. Hierarchical Inheritance Demo ---
        Cat cat = new Cat("Whiskers");
        cat.eat();        // Inherited directly from parent
        cat.makeSound();  // Overridden method
    }
}

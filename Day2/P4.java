// this keyword
class StudentBuilder {
    String name;
    int rollNumber;
    String department;

    // 1. Constructor Chaining: this() calls another constructor in the same class
    public StudentBuilder() {
        this("Guest", 0, "General"); // Must be the first statement
    }

    // 2. Resolving Variable Shadowing: this.field distinguishes field from parameter
    public StudentBuilder(String name, int rollNumber, String department) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.department = department;
    }

    // 3. Method Chaining: Returning 'this' allows calling methods in a single chain
    public StudentBuilder updateDepartment(String newDept) {
        this.department = newDept;
        return this; // Returns current instance
    }

    // 4. Passing current object reference to an external printer method
    public void printUsingHelper() {
        StudentPrinter.print(this); // Passes 'this' object
    }
}

class StudentPrinter {
    public static void print(StudentBuilder student) {
        System.out.println("Student: " + student.name 
                + " | Roll No: " + student.rollNumber 
                + " | Dept: " + student.department);
    }
}

public class P4 {
    public static void main(String[] args) {
        // Usage 1 & 2: Chaining & Shadowing
        StudentBuilder s1 = new StudentBuilder("Alice", 101, "Computer Science");
        s1.printUsingHelper();

        // Usage 3: Method Chaining (Fluent call)
        s1.updateDepartment("Data Science").printUsingHelper();

        // Usage 4: Default chained constructor
        StudentBuilder s2 = new StudentBuilder();
        s2.printUsingHelper();
    }
}

// Interface 1
interface Printable {
    void print(); // Abstract method
}

// Interface 2
interface Showable {
    void show(); // Abstract method
}

// Base Class
class Document {
    String title;

    public Document(String title) {
        this.title = title;
    }
}

// Multiple & Hybrid Inheritance: Extends 1 Class and Implements Multiple Interfaces
class Report extends Document implements Printable, Showable {

    public Report(String title) {
        super(title);
    }

    // Implementing method from Printable interface
    @Override
    public void print() {
        System.out.println("Printing Document: " + title);
    }

    // Implementing method from Showable interface
    @Override
    public void show() {
        System.out.println("Displaying Document on screen: " + title);
    }
}

public class P11 {
    public static void main(String[] args) {
        Report quarterlyReport = new Report("Q3 Financial Analysis");

        quarterlyReport.show();  // From Showable
        quarterlyReport.print(); // From Printable
    }
}

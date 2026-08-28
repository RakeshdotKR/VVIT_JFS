class StudentRecord {
    // 1. Private fields (Data Hiding: hidden from direct outside access)
    private String studentName;
    private int marks;

    // Constructor routes input through setters for uniform validation
    public StudentRecord(String studentName, int marks) {
        this.studentName = studentName;
        setMarks(marks); // Uses validation logic
    }

    // --- Getters (Read Access) ---
    public String getStudentName() {
        return this.studentName;
    }

    public int getMarks() {
        return this.marks;
    }

    // --- Setters (Controlled Write Access with Validation) ---
    public void setStudentName(String studentName) {
        if (studentName != null && !studentName.trim().isEmpty()) {
            this.studentName = studentName;
        } else {
            System.out.println("Error: Student name cannot be empty.");
        }
    }

    public void setMarks(int marks) {
        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        } else {
            System.out.println("Error: Marks must be between 0 and 100. Provided: " + marks);
        }
    }
}

public class P7 {
    public static void main(String[] args) {
        StudentRecord student = new StudentRecord("Alex", 85);
        System.out.println("Student: " + student.getStudentName() + " | Marks: " + student.getMarks());

        // Attempting invalid updates (Blocked by validation logic)
        student.setMarks(120);
        student.setStudentName("");

        // Valid update
        student.setMarks(95);
        System.out.println("Updated Marks: " + student.getMarks());
    }
}


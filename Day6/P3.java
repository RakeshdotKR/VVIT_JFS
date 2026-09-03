import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class P3 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/Tech_DB";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {
        String sql = "SELECT emp_id, first_name, salary FROM employees ORDER BY emp_id";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             // Create a statement that produces a Scrollable and Updatable ResultSet
             Statement stmt = conn.createStatement(
                     ResultSet.TYPE_SCROLL_INSENSITIVE,  // Can scroll forward/backward; immune to concurrent DB changes
                     ResultSet.CONCUR_UPDATABLE         // Allows updating rows directly through the ResultSet
             );
             ResultSet rs = stmt.executeQuery(sql)) {

            // --- 1. Bidirectional & Absolute Navigation ---
            System.out.println("--- 1. Scrollable Navigation ---");

            // Move to first row
            if (rs.first()) {
                System.out.println("First Row -> ID: " + rs.getInt("emp_id") + " | Name: " + rs.getString("first_name"));
            }

            // Jump directly to the last row
            if (rs.last()) {
                System.out.println("Last Row  -> ID: " + rs.getInt("emp_id") + " | Name: " + rs.getString("first_name") 
                        + " (Row Number: " + rs.getRow() + ")");
            }

            // Move backward one row
            if (rs.previous()) {
                System.out.println("Previous  -> ID: " + rs.getInt("emp_id") + " | Name: " + rs.getString("first_name"));
            }

            // Jump to absolute row index 3
            if (rs.absolute(3)) {
                System.out.println("Row at Index 3 -> Name: " + rs.getString("first_name") + " | Salary: $" + rs.getDouble("salary"));
            }

            // --- 2. Updatable ResultSet (In-Place Row Update) ---
            System.out.println("\n--- 2. Updatable ResultSet Modification ---");
            rs.first(); // Target the first employee
            double currentSalary = rs.getDouble("salary");
            double newSalary = currentSalary + 500.0;

            // Modify column in memory
            rs.updateDouble("salary", newSalary);
            // Commit update back to the database
            rs.updateRow();

            System.out.println("Updated Salary in DB for " + rs.getString("first_name") + " to: $" + newSalary);

        } catch (SQLException e) {
            System.err.println("ResultSet Error: " + e.getMessage());
        }
    }
}

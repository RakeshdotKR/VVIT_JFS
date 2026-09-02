import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class P4 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/Tech_DB";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {
        // Simulated user inputs from a login / search field
        String normalInput = "aarav.sharma@bharattech.com";
        // Malicious input designed to bypass authentication or dump data
        String maliciousInput = "' OR '1'='1";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement()) {

            // --- 1. Safe Static Query with Statement ---
            System.out.println("--- 1. Safe Static Query via Statement ---");
            String staticQuery = "SELECT dept_name, city FROM departments WHERE dept_id = 10";
            ResultSet rs1 = stmt.executeQuery(staticQuery);
            while (rs1.next()) {
                System.out.println("Dept: " + rs1.getString("dept_name") + " | City: " + rs1.getString("city"));
            }

            // --- 2. SQL INJECTION VULNERABILITY (String Concatenation) ---
            System.out.println("\n--- 2. Demonstrating SQL Injection Flaw ---");
            // Constructing SQL using direct string concatenation:
            String vulnerableQuery = "SELECT emp_id, first_name, email FROM employees WHERE email = '" + maliciousInput + "'";
            
            System.out.println("Constructed Query: " + vulnerableQuery);
            // Resulting SQL becomes: SELECT ... WHERE email = '' OR '1'='1' (Always true!)

            ResultSet rs2 = stmt.executeQuery(vulnerableQuery);
            System.out.println("Data leaked via SQL injection:");
            while (rs2.next()) {
                System.out.println("ID: " + rs2.getInt("emp_id") + " | Name: " + rs2.getString("first_name") + " | Email: " + rs2.getString("email"));
            }

        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
    }
}

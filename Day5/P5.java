import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class P5 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/Tech_DB";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {
        // Attempted SQL Injection input
        String maliciousInput = "' OR '1'='1";

        // Pre-compiled query template with positional placeholder '?'
        String safeQuery = "SELECT emp_id, first_name, email, salary FROM employees WHERE email = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(safeQuery)) {

            // --- 1. Binding Parameters by Position (1-based index) ---
            // The JDBC driver escapes and quotes the entire input as a literal string value
            pstmt.setString(1, maliciousInput);

            System.out.println("Executing safe PreparedStatement with input: " + maliciousInput);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (!rs.next()) {
                    System.out.println("No records found! (SQL Injection successfully blocked).");
                } else {
                    do {
                        System.out.println("Found: " + rs.getString("first_name"));
                    } while (rs.next());
                }
            }

            // --- 2. Querying with Valid Parameter ---
            System.out.println("\nExecuting with legitimate user email:");
            pstmt.setString(1, "aarav.sharma@bharattech.com");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println("Employee: " + rs.getString("first_name") 
                            + " | Salary: $" + rs.getDouble("salary"));
                }
            }

        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
    }
}


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class P6 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/Tech_DB";
    private static final String DB_USER = "invalid_user"; // Intentionally invalid
    private static final String DB_PASSWORD = "wrong_password";

    public static void main(String[] args) {
        System.out.println("Attempting connection with invalid credentials...");

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("INSERT INTO departments (dept_id, dept_name, city) VALUES (200, 'Test', 'Delhi')");

        } catch (SQLException e) {
            // 1. Structured Exception Logging
            System.err.println("=== JDBC Error Details ===");
            System.err.println("Message:   " + e.getMessage());
            System.err.println("SQL State: " + e.getSQLState()); // Standardized 5-char code
            System.err.println("Error Code:" + e.getErrorCode()); // Vendor-specific error code (e.g., 1045 for access denied)

            // 2. Exception Chaining (Underlying cause)
            Throwable cause = e.getCause();
            if (cause != null) {
                System.err.println("Root Cause: " + cause.getMessage());
            }

            // 3. Full Stack Trace (For debugging only; avoid in production logs)
            // e.printStackTrace();

        } catch (Exception e) {
            // Catch-all for non-SQL exceptions (e.g., ClassNotFoundException if driver missing)
            System.err.println("Unexpected Error: " + e.getMessage());
        }
    }
}

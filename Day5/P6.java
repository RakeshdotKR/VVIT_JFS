import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class P6 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/Tech_DB";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {
        String insertSql = "INSERT INTO departments (dept_id, dept_name, city) VALUES (?, ?, ?)";
        String updateSalarySql = "UPDATE employees SET salary = salary * ? WHERE dept_id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

            // --- 1. Single Parameterized DML (UPDATE) ---
            System.out.println("--- 1. Parameterized DML Update ---");
            try (PreparedStatement updateStmt = conn.prepareStatement(updateSalarySql)) {
                updateStmt.setDouble(1, 1.05); // 5% raise
                updateStmt.setInt(2, 10);      // For dept_id = 10

                int rowsAffected = updateStmt.executeUpdate();
                System.out.println("Rows updated successfully: " + rowsAffected);
            }

            // --- 2. Batch Execution with PreparedStatement ---
            System.out.println("\n--- 2. Batch Execution (Optimized Multi-Row Insert) ---");
            try (PreparedStatement batchStmt = conn.prepareStatement(insertSql)) {

                // Row 1
                batchStmt.setInt(1, 60);
                batchStmt.setString(2, "Data Engineering");
                batchStmt.setString(3, "Chennai");
                batchStmt.addBatch(); // Adds statement to batch queue

                // Row 2
                batchStmt.setInt(1, 70);
                batchStmt.setString(2, "Quality Assurance");
                batchStmt.setString(3, "Kolkata");
                batchStmt.addBatch(); // Adds statement to batch queue

                // Send all batched queries to the database server in a single network round-trip
                int[] results = batchStmt.executeBatch();
                System.out.println("Batch execution results: " + Arrays.toString(results));
            }

        } catch (SQLException e) {
            System.err.println("Execution Error: " + e.getMessage());
        }
    }
}

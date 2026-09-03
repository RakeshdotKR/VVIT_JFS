import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class P2 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/Tech_DB";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {
        String insertSql = "INSERT INTO departments (dept_id, dept_name, city) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

            // --- 1. Disable Auto-Commit (Start Transaction Boundary) ---
            conn.setAutoCommit(false);

            try (PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
                System.out.println("Preparing batch of departments...");

                // Record 1
                pstmt.setInt(1, 80);
                pstmt.setString(2, "Data Science");
                pstmt.setString(3, "Bengaluru");
                pstmt.addBatch(); // Enqueue statement

                // Record 2
                pstmt.setInt(1, 90);
                pstmt.setString(2, "Product Marketing");
                pstmt.setString(3, "Mumbai");
                pstmt.addBatch(); // Enqueue statement

                // Record 3
                pstmt.setInt(1, 95);
                pstmt.setString(2, "Cyber Security Ops");
                pstmt.setString(3, "Hyderabad");
                pstmt.addBatch(); // Enqueue statement

                // --- 2. Execute Batch across Network in 1 Round-Trip ---
                int[] affectedRows = pstmt.executeBatch();
                System.out.println("Batch Executed. Rows affected per statement: " + Arrays.toString(affectedRows));

                // --- 3. Explicit Commit (Persist Changes Atomically) ---
                conn.commit();
                System.out.println("Transaction committed successfully!");

            } catch (SQLException e) {
                // --- 4. Rollback on Error (Atomicity Guaranteed) ---
                System.err.println("Batch failed! Rolling back all transaction changes. Error: " + e.getMessage());
                conn.rollback();
            } finally {
                // Restore default auto-commit state
                conn.setAutoCommit(true);
            }

        } catch (SQLException e) {
            System.err.println("Connection Error: " + e.getMessage());
        }
    }
}

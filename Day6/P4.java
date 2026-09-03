import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

public class P4 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/Tech_DB";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {
        String insertSql = "INSERT INTO departments (dept_id, dept_name, city) VALUES (?, ?, ?)";

        Connection conn = null;
        Savepoint sp = null;

        try {
            // 1. Establish connection and disable auto-commit (Start Transaction)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            conn.setAutoCommit(false); // Begin explicit transaction boundary

            System.out.println("Transaction started. Auto-commit disabled.");

            try (PreparedStatement pstmt = conn.prepareStatement(insertSql)) {

                // Operation 1: Insert valid department (Success)
                pstmt.setInt(1, 100);
                pstmt.setString(2, "Research & Development");
                pstmt.setString(3, "Bengaluru");
                pstmt.executeUpdate();
                System.out.println("Inserted Dept 100 successfully.");

                // Create a savepoint before risky operation
                sp = conn.setSavepoint("BeforeRiskyInsert");
                System.out.println("Savepoint '" + sp.getSavepointName() + "' created.");

                // Operation 2: Insert duplicate dept_id (Will fail due to PRIMARY KEY constraint)
                pstmt.setInt(1, 100); // Duplicate PK
                pstmt.setString(2, "Duplicate Dept");
                pstmt.setString(3, "Pune");
                pstmt.executeUpdate();

                // If we reach here, commit all changes
                conn.commit();
                System.out.println("Transaction committed successfully.");

            } catch (SQLException e) {
                // 2. Handle failure: Rollback to savepoint or full rollback
                System.err.println("Error occurred: " + e.getMessage());

                if (sp != null) {
                    // Rollback only to the savepoint (partial rollback)
                    conn.rollback(sp);
                    System.out.println("Rolled back to Savepoint. First insert retained.");

                    // Commit the remaining valid changes
                    conn.commit();
                    System.out.println("Partial transaction committed.");
                } else {
                    // Full transaction rollback
                    conn.rollback();
                    System.out.println("Full transaction rolled back.");
                }
            }

        } catch (SQLException e) {
            System.err.println("Connection Error: " + e.getMessage());
        } finally {
            // 3. Restore default auto-commit behavior
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.setAutoCommit(true);
                    conn.close();
                    System.out.println("Connection closed and auto-commit restored.");
                }
            } catch (SQLException e) {
                System.err.println("Cleanup Error: " + e.getMessage());
            }
        }
    }
}

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class P1 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/Tech_DB";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

            // --- 1. Procedure with IN & OUT Parameters ---
            System.out.println("--- 1. Procedure with IN and OUT Parameters ---");
            String procedureSql = "{CALL GetDeptPayroll(?, ?)}";

            try (CallableStatement cstmt = conn.prepareCall(procedureSql)) {
                // Set IN parameter (Department ID = 10)
                cstmt.setInt(1, 10);

                // Register OUT parameter SQL type (Position 2 is DECIMAL)
                cstmt.registerOutParameter(2, Types.DECIMAL);

                // Execute the stored procedure
                cstmt.execute();

                // Retrieve output value from registered index
                double totalPayroll = cstmt.getDouble(2);
                System.out.println("Total Payroll for Dept 10: $" + totalPayroll);
            }

            // --- 2. Procedure with INOUT Parameter ---
            System.out.println("\n--- 2. Procedure with INOUT Parameter ---");
            String inoutSql = "{CALL ApplyBudgetBonus(?, ?)}";

            try (CallableStatement cstmt = conn.prepareCall(inoutSql)) {
                double startingBudget = 100000.0;
                double bonusPercentage = 15.0;

                // Parameter 1 acts as BOTH IN and OUT
                cstmt.setDouble(1, startingBudget);
                cstmt.registerOutParameter(1, Types.DECIMAL);

                // Parameter 2 is a standard IN parameter
                cstmt.setDouble(2, bonusPercentage);

                cstmt.execute();

                double updatedBudget = cstmt.getDouble(1);
                System.out.println("Starting Budget: $" + startingBudget 
                        + " -> After " + bonusPercentage + "% Bonus: $" + updatedBudget);
            }

            // --- 3. Stored Function with Return Value ---
            System.out.println("\n--- 3. Stored Function with Return Value ---");
            String functionSql = "{? = CALL GetEmployeeCountByDept(?)}";

            try (CallableStatement cstmt = conn.prepareCall(functionSql)) {
                // Register return value at index 1
                cstmt.registerOutParameter(1, Types.INTEGER);

                // Pass input argument at index 2
                cstmt.setInt(2, 10);

                cstmt.execute();

                int employeeCount = cstmt.getInt(1);
                System.out.println("Headcount for Dept 10: " + employeeCount);
            }

        } catch (SQLException e) {
            System.err.println("Procedure Execution Error: " + e.getMessage());
        }
    }
}

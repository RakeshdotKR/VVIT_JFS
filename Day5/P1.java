import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class P1 {

    // Standard JDBC Connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Tech_DB";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {
        // --- 1. Driver Registration ---
        // In JDBC 4.0+, the driver is automatically discovered on the classpath.
        // Legacy explicitly registered: Class.forName("com.mysql.cj.jdbc.Driver");

        // --- 2. Establishing Connection with try-with-resources ---
        System.out.println("Connecting to database using DriverManager...");
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("Connection established successfully!");

                // --- 3. Inspecting Database Metadata ---
                DatabaseMetaData metaData = conn.getMetaData();
                System.out.println("Database Product Name:    " + metaData.getDatabaseProductName());
                System.out.println("Database Product Version: " + metaData.getDatabaseProductVersion());
                System.out.println("Driver Name:              " + metaData.getDriverName());
                System.out.println("Driver Version (Type 4):  " + metaData.getDriverVersion());
            }
        } catch (SQLException e) {
            System.err.println("JDBC Connection Failed!");
            System.err.println("Error Message: " + e.getMessage());
            System.err.println("SQL State:     " + e.getSQLState());
            System.err.println("Error Code:    " + e.getErrorCode());
        }
        // conn.close() is invoked automatically here
    }
}

// 1 Download the MySQL Connector/J JAR:
// •	Visit: https://dev.mysql.com/downloads/connector/j/
// •	Download the Platform Independent ZIP (e.g., mysql-connector-j-8.3.0.zip).
// •	Extract it and locate the JAR file: mysql-connector-j-8.3.0.jar.
// 2  Add the JAR to Your Project:
// •	Create a folder named lib inside your project directory.
// •	Copy the mysql-connector-j-8.3.0.jar file into this lib folder.
  
// 1. Compile (with JAR)
// javac -cp .;lib\mysql-connector-j-26.7.0.jar test.java
// 2. Run (with JAR)
// java -cp .;lib\mysql-connector-j-26.7.0.jar test

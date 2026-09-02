import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class P2 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/Tech_DB";

    public static void main(String[] args) {
        // Encapsulate credentials and connection options in a Properties object
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "password");

        // Advanced JDBC driver parameters
        connectionProps.put("useSSL", "false");
        connectionProps.put("allowPublicKeyRetrieval", "true");
        connectionProps.put("serverTimezone", "Asia/Kolkata");
        connectionProps.put("connectTimeout", "5000"); // 5-second connection timeout

        System.out.println("Connecting with custom connection properties...");

        try (Connection conn = DriverManager.getConnection(DB_URL, connectionProps)) {
            System.out.println("Connected successfully with timezone: Asia/Kolkata");
            System.out.println("Auto-commit status: " + conn.getAutoCommit());
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }
}

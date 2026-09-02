import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

// A simple factory representing DataSource abstraction
class DatabaseConnectionFactory {

    // Method to obtain a connection from a configured DataSource
    public static Connection getConnection(DataSource dataSource) throws SQLException {
        return dataSource.getConnection();
    }
}

public class P3 {
    public static void main(String[] args) {
        /*
         * In a production application (e.g., using MySQL Connector/J or HikariCP):
         * 
         * com.mysql.cj.jdbc.MysqlDataSource ds = new com.mysql.cj.jdbc.MysqlDataSource();
         * ds.setServerName("localhost");
         * ds.setPortNumber(3306);
         * ds.setDatabaseName("BharatTech_DB");
         * ds.setUser("root");
         * ds.setPassword("rootpassword");
         * 
         * try (Connection conn = ds.getConnection()) {
         *     System.out.println("Connected via DataSource successfully!");
         * }
         */

        System.out.println("DataSource pattern configured: Preferred over DriverManager for enterprise pooling.");
    }
}

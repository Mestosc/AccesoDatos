import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:postgresql://10.0.9.115:5432/probas";
            conn = DriverManager.getConnection(url, "postgres","admin");
        } catch (SQLException e) {
            System.out.println("Hola hay este error: " + e.getMessage());
        }
        return conn;
    }
}

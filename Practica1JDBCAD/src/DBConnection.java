import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection connect() {
        Connection conn = null;
        try {
            String ipColegio = "10.0.9.115";
            String ipCasa = "192.168.0.29";
            String url = "jdbc:postgresql://"+ipCasa+"/probas";
            conn = DriverManager.getConnection(url, "postgres","admin");
        } catch (SQLException e) {
            System.out.println("Hola hay este error: " + e.getMessage());
        }
        return conn;
    }
}

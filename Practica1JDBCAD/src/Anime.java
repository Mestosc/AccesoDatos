import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Anime {
    public void insertNuevoAnime(String nombre,String descripcion, int puntuacion, String fecha) {
        try (Connection conn = DBConnection.connect();
             PreparedStatement statement = conn.prepareStatement("insert into anime (nombre, descripcion, puntuacion, fecha) values (?, ?, ?, ?)")) {
            statement.setString(1, nombre);
            statement.setString(2, descripcion);
            statement.setInt(3, puntuacion);
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}

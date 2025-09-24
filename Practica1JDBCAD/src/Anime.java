import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Anime {
    public void mostrarAnime(String nombre) {
        try (Connection conn = DBConnection.connect();
            PreparedStatement stm = conn.prepareStatement("select * from anime where nombre = ?")) {
            stm.setString(1, nombre);
            var rs = stm.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Descripcion: " + rs.getString("descripcion"));
                System.out.println("Puntuacion: " + rs.getInt("puntuacion"));
                System.out.println("Fecha: " + rs.getString("fecha"));
            }

        } catch (SQLException e) {
            System.out.println("Error mostrando anime: " + e);
        }
    }
    public void insertNuevoAnime(String nombre,String descripcion, int puntuacion, String fecha) {
        try (Connection conn = DBConnection.connect();
             PreparedStatement statement = conn.prepareStatement("insert into anime (nombre, descripcion, puntuacion, fecha) values (?, ?, ?, ?)")) {
            statement.setString(1, nombre);
            statement.setString(2, descripcion);
            statement.setInt(3, puntuacion);
            statement.setString(4,fecha);
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}

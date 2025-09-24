import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Anime {
    public static void actualizarResultados(String datoActualizar,String nuevoValor,String nombre) {
        try (Connection conn = DBConnection.connect();
             PreparedStatement stm = conn.prepareStatement("update anime set "+" where nome = ?")) {
            stm.setString(1, "Evangelion");
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error actualizando resultados: " + e);
        }
    }
    public static void mostrarAnime(String nombre) {
        try (Connection conn = DBConnection.connect();
            PreparedStatement stm = conn.prepareStatement("select * from anime where nome = ?")) {
            stm.setString(1, nombre);
            ResultSet set = stm.executeQuery();
            if (set.next()) {
                System.out.println("Nombre: " + set.getString("nome"));
                System.out.println("Descripcion: " + set.getString("descripcion"));
                System.out.println("Fecha: " + set.getString("data"));
                System.out.println("Puntuacion: " + set.getInt("puntuacion"));
            }


        } catch (SQLException e) {
            System.out.println("Error mostrando anime: " + e);
        }
    }
    public static void insertNuevoAnime(String nombre,String descripcion, int puntuacion, String fecha) {
        try (Connection conn = DBConnection.connect();
             PreparedStatement statement = conn.prepareStatement("insert into anime (nome, descripcion, data, puntuacion) values (?, ?, ?, ?)")) {
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

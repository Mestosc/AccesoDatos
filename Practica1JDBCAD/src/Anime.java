import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Anime {
    String nombre;
    String descripcion;
    int puntuacion;
    String fecha;

    public Anime(String nombre, String descripcion, int puntuacion, String fecha) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntuacion = puntuacion;
        this.fecha = fecha;
    }
    public static void actualizarResultados(String datoActualizar,String nuevoValor,String nombre) {
        try (Connection conn = DBConnection.connect();
             PreparedStatement stm = conn.prepareStatement("update anime set "+ datoActualizar+"="+nuevoValor+ " where nome = ?")) {
            stm.setString(1, nombre);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error actualizando resultados: " + e);
        }
    }
    public static void eliminarAnime(String nombre) {
        try (Connection conn = DBConnection.connect();
             PreparedStatement stm = conn.prepareStatement("delete from anime where nome = ?")) {
            stm.setString(1, nombre);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error eliminando anime: " + e);
        }
    }
    public static Anime obtenerAnime(String nombre) {
        try (Connection conn = DBConnection.connect();
            PreparedStatement stm = conn.prepareStatement("select * from anime where nome = ?")) {
            stm.setString(1, nombre);
            ResultSet set = stm.executeQuery();
            if (set.next()) {
                return new Anime(set.getString("nome"),
                        set.getString("descripcion"),
                        set.getInt("puntuacion"),
                        set.getString("data"));
            }
        } catch (SQLException e) {
            System.out.println("Error mostrando anime: " + e);
        }
        return null;
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
    public void insertNuevoAnime() {
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
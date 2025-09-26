import java.sql.*;
import java.util.ArrayList;

public class Anime {
    String nombre;
    String descripcion;
    int puntuacion;
    Date fecha;

    public Anime(String nombre, String descripcion, int puntuacion, Date fecha) {
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
                        set.getDate("data"));
            }
        } catch (SQLException e) {
            System.out.println("Error mostrando anime: " + e);
        }
        return null;
    }
    public static ArrayList<Anime> obtenerAnimesNombre(String nombre) { // En este caso lo pongo porque en la base de datos aparece asi normalmente deberia haber un elemento diferenciador
        ArrayList<Anime> animes = new ArrayList<>();
        try (Connection conn = DBConnection.connect();
             PreparedStatement stm = conn.prepareStatement("select * from anime where nome = ?")) {
            stm.setString(1, nombre);
            ResultSet set = stm.executeQuery();
            while (set.next()) {
                animes.add(new Anime(set.getString("nome"),
                        set.getString("descripcion"),
                        set.getInt("puntuacion"),
                        set.getDate("data")));
            }
            return animes;
        } catch (SQLException e) {
            System.out.println("Error mostrando anime: " + e);
        }
        return null;
    }
    public static ArrayList<Anime> obtenerAnimesPuntuaciono(int puntuacion) {
        ArrayList<Anime> animes = new ArrayList<>();
        try (Connection conn = DBConnection.connect();
             PreparedStatement stm = conn.prepareStatement("select * from anime where puntuacion = ?")) {
            stm.setInt(1, puntuacion);
            ResultSet set = stm.executeQuery();
            while (set.next()) {
                animes.add(new Anime(set.getString("nome"),
                        set.getString("descripcion"),
                        set.getInt("puntuacion"),
                        set.getDate("data")));
            }
            return animes;
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
}
package AnimeService;
import Connection.DBConnection;
import java.sql.*;
import java.util.ArrayList;

public class Anime {
    private String nombre;
    private String descripcion;
    private int puntuacion;
    private Date fecha;

    public String getFecha() {
        return fecha.toString();
    }
    public Date getFechaDate() {
        return fecha;
    }

    @Override
    public String toString() { // Metodo para Debug principalmente
        return "AnimeService.Anime{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", puntuacion=" + puntuacion +
                ", fecha=" + fecha +
                '}';
    }

    private Anime(String nombre, String descripcion, int puntuacion, Date fecha) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntuacion = puntuacion;
        this.fecha = fecha;
    }
    public Anime(String nombre, String descripcion, int puntuacion, String fecha) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntuacion = puntuacion;
        this.fecha = Date.valueOf(fecha);
    }
    public static void actualizarNombreDondeNombre(String nuevoNombre, String nombre) {
        try (Connection conn = DBConnection.connect();
             PreparedStatement stm = conn.prepareStatement("update anime set nome= ? where nome = ?")) {
            stm.setString(1,nuevoNombre);
            stm.setString(2, nombre);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error actualizando resultados: " + e);
        }
    }
    public static void actualizarPuntuacionDondeNombre(int puntuacion, String nombre) {
        try (Connection conn = DBConnection.connect();
             PreparedStatement stm = conn.prepareStatement("update anime set puntuacion= ? where nome = ?")) {
            stm.setInt(1,puntuacion);
            stm.setString(2, nombre);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error actualizando resultados: " + e);
        }
    }
    public static void actualizarFechaDondeNombre(String fecha, String nombre) {
        try (Connection conn = DBConnection.connect();
             PreparedStatement stm = conn.prepareStatement("update anime set data= ? where nome = ?")) {
            stm.setDate(1,Date.valueOf(fecha));
            stm.setString(2, nombre);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error actualizando resultados: " + e);
        }
    }
    public static void actualizarDescripcionDondeNombre(String nuevaDescipcion, String nombre) {
        try (Connection conn = DBConnection.connect();
             PreparedStatement stm = conn.prepareStatement("update anime set descripcion= ? where nome = ?")) {
            stm.setString(1,nuevaDescipcion);
            stm.setString(2, nombre);
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
            System.err.println("Error eliminando anime: " + e);
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
            System.err.println("Error mostrando anime: " + e);
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
            System.err.println("Error mostrando anime: " + e);
        }
        return null;
    }
    public static ArrayList<Anime> obtenerAnimesFecha(String fecha) {
        ArrayList<Anime> animes = new ArrayList<>();
        try (Connection conn = DBConnection.connect();
             PreparedStatement stm = conn.prepareStatement("select * from anime where data = ?")) {
            stm.setDate(1, Date.valueOf(fecha));
            ResultSet set = stm.executeQuery();
            while (set.next()) {
                animes.add(new Anime(set.getString("nome"),
                        set.getString("descripcion"),
                        set.getInt("puntuacion"),
                        set.getDate("data")));
            }
            return animes;
        } catch (SQLException e) {
            System.err.println("Error mostrando anime: " + e);
        }
        return null;
    }

    public static ArrayList<Anime> obtenerAnimesPuntuacion(int puntuacion) {
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
            System.err.println("Error mostrando anime: " + e);
        }
        return null;
    }
    public void eliminarAnime() {
        eliminarAnime(this.nombre);
    }
    public void insertNuevoAnime() {
        insertNuevoAnime(nombre,descripcion,puntuacion,fecha);
    }
    public static void insertNuevoAnime(String nombre,String descripcion, int puntuacion, String fecha) {
        try (Connection conn = DBConnection.connect();
             PreparedStatement statement = conn.prepareStatement("insert into anime (nome, descripcion, data, puntuacion) values (?, ?, ?, ?)")) {
            statement.setString(1, nombre);
            statement.setString(2, descripcion);
            statement.setDate(3,Date.valueOf(fecha));
            statement.setInt(4, puntuacion);
            statement.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
    public static void insertNuevoAnime(String nombre,String descripcion, int puntuacion, Date fecha) {
        try (Connection conn = DBConnection.connect();
             PreparedStatement statement = conn.prepareStatement("insert into anime (nome, descripcion, data, puntuacion) values (?, ?, ?, ?)")) {
            statement.setString(1, nombre);
            statement.setString(2, descripcion);
            statement.setDate(3,fecha);
            statement.setInt(4, puntuacion);
            statement.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        actualizarDescripcionDondeNombre(descripcion,nombre);
    }
    public int getPuntuacion() {
        return puntuacion;
    }

    public void setFechaDate(Date fecha) {
        this.fecha = fecha;
        actualizarFechaDondeNombre(fecha.toString(),nombre);
    }
    public void setFecha(String fecha) {
        this.fecha = Date.valueOf(fecha);
        actualizarFechaDondeNombre(fecha,nombre);
    }
    public void setNombre(String nombre) {
        String anteriorNombre = this.nombre;
        this.nombre = nombre;
        actualizarNombreDondeNombre(nombre,anteriorNombre);
    }
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
        actualizarPuntuacionDondeNombre(puntuacion,nombre);
    }
}
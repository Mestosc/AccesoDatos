import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Anime anime1 = Anime.obtenerAnime("Akira");
        Anime.actualizarNombreDondeNombre("Akira", "Akira 2");
        ArrayList<Anime> animes = Anime.obtenerAnimesNombre("Akira");
        if (animes!=null) {
        for (Anime anime : animes) {
            System.out.println(anime.nombre + " " + anime.descripcion + " " + anime.puntuacion + " " + anime.fecha);
        }
    }
    }
}
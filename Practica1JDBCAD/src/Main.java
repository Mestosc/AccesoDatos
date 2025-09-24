//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Anime anime = Anime.obtenerAnime("Ghost In the Shell");
        if (anime!=null) {
            System.out.println(anime.nombre);
            System.out.println(anime.descripcion);
            System.out.println(anime.fecha);
            System.out.println(anime.puntuacion);
        }
    }
}
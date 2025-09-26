import AnimeService.Anime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Anime.insertNuevoAnime("Naruto", "Naruto Uzumaki es un joven ninja con el sueño de convertirse en el Hokage, el líder de su aldea. A lo largo de la serie, Naruto enfrenta numerosos desafíos y enemigos mientras busca reconocimiento y aceptación.", 9, "2002-10-03");
        Anime.insertNuevoAnime("Death Note", "Light Yagami, un estudiante brillante, encuentra un cuaderno llamado Death Note que le permite matar a cualquier persona cuyo nombre escriba en él. Decidido a eliminar el mal del mundo, Light se convierte en un vigilante conocido como Kira, enfrentándose a un genio detective llamado L.", 10, "2006-10-04");
        Anime.eliminarAnime("Death Note");
        Anime.eliminarAnime("Naruto");
        Anime.insertNuevoAnime("Naruto", "Naruto Uzumaki es un joven ninja con el sueño de convertirse en el Hokage, el líder de su aldea. A lo largo de la serie, Naruto enfrenta numerosos desafíos y enemigos mientras busca reconocimiento y aceptación.", 9, "2002-10-03");
        Anime.insertNuevoAnime("Death Note", "Light Yagami, un estudiante brillante, encuentra un cuaderno llamado Death Note que le permite matar a cualquier persona cuyo nombre escriba en él. Decidido a eliminar el mal del mundo, Light se convierte en un vigilante conocido como Kira, enfrentándose a un genio detective llamado L.", 10, "2006-10-04");
        Anime anime = Anime.obtenerAnime("Death Note");
        System.out.println(anime.getPuntuacion());
        Anime.actualizarPuntuacionDondeNombre(20,"Death Note");
        Anime anime1 = Anime.obtenerAnime("Death Note");
        System.out.println(anime1.getPuntuacion());
    }
}
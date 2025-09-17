package Parte1;

import java.io.*;
import java.util.ArrayList;

public class Ejercicio2 {
    public static void main(String[] args) {
        copiarArchivoByteByte("texto2.txt",leerByteAByteFichero("texto1.txt"),false);
    }

    /**
     * Lee un fichero byte a byte
     * @param fichero El fichero a leer
     * @return Una lista de los bytes del fichero
     */
    public static ArrayList<Integer> leerByteAByteFichero(String fichero) {
        ArrayList<Integer> bytesFichero = new ArrayList<>();
        try (FileInputStream f = new FileInputStream(fichero)) {
            int lectura = f.read();
            while (lectura != -1) {
                bytesFichero.add(lectura);
                lectura = f.read();
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            System.out.println("Ha habido un fallo de lectura escritura");
        }
        return bytesFichero;
    }
    public static boolean copiarArchivoByteByte(String nombreFichero, ArrayList<Integer> bytesFicheroCopiar, boolean anadirAFichero) {
        try (FileOutputStream f = new FileOutputStream(nombreFichero,anadirAFichero)) {
            for (Integer bytef : bytesFicheroCopiar) {
                f.write(bytef);
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error en la localizacion del archivo");
        }
        return false;
    }
}

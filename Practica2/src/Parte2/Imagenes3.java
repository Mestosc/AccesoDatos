package Parte2;

import java.io.*;
import java.util.ArrayList;

public class Imagenes3 {
    public static void main(String[] args) {
        copiarFicheroBuffer("foto23.jpg",leerFicheroBuffer("marek-pavlik-YhpiG-0mKUg-unsplash.jpg"));
    }
    public static void copiarFicheroBuffer(String nombreFichero, ArrayList<Integer> bytesFichero) {
        try (BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(nombreFichero))) {
            for (Integer b : bytesFichero) {
                writer.write(b);
            }
        } catch (FileNotFoundException e) {
            System.err.println("No existe el archivo: " + e);
        } catch (IOException e) {
            System.err.println("Fallo entrada salida");
        }
    }
    public static ArrayList<Integer> leerFicheroBuffer(String nombreArchivo) {
        ArrayList<Integer> bytes = new ArrayList<>();
        try (BufferedInputStream archivo = new BufferedInputStream(new FileInputStream(nombreArchivo))) {
            int n = archivo.read();
            while (n != -1) {
                bytes.add(n);
                n = archivo.read();
            }
        } catch (IOException e) {
            System.err.println("Fallo en entrada salida");
        }
        return bytes;
    }
}

package Parte1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio1 {
    public static void main(String[] args) {
        escribirArchivo("texto1.txt","Tanjiro","Nezuko","Muzan"); // Yo hice así el texto1

    }

    /**
     * Escribir en un archivo una lista de palabras
     * @param nombreArchivo el nombre del archivo a escribir
     * @param datosEscribir los datos a escribir
     */
    public static void escribirArchivo(String nombreArchivo, String...datosEscribir) {
        try (FileOutputStream f = new FileOutputStream(new File(nombreArchivo))) {
            for (String dato : datosEscribir) {
                for (int i = 0;i<dato.length();i++) {
                    f.write(dato.charAt(i));
                }
                f.write('\n');
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo ");
        } catch (IOException e) {
            System.out.println("Problema entrada salida");
        } finally {
            System.out.println("Archivo creado");
        }
    }
}

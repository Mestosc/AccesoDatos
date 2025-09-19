package Parte3;

import java.io.*;
import java.util.ArrayList;

public class Ejercicio1 {
    public static void main(String[] args) {
        escribirUTF("prob.txt","o tempo está xélido", "o tempo está xélido", "o tempo esta xélido");
        leerUTF("prob.txt");
    }
    public static void escribirUTF(String fichero,String...cadenas) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(fichero))) {
            for (String cadena : cadenas) {
                System.out.println("Escribiendo la cadena: " + cadena);
                System.out.println("Tamaño do ficheiro: " + dataOutputStream.size() + " bytes");
                dataOutputStream.writeUTF(cadena);
                System.out.println("Tamaño do ficheiro: " + dataOutputStream.size() + " bytes");
            }
            System.out.println("Tamaño total do ficheiro: " + dataOutputStream.size() + " bytes");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado? " + e);
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
    }
    public static ArrayList<String> leerUTF(String fichero) {
        ArrayList<String> cadenas = new ArrayList<>();
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(fichero))) {
            while (true) {
                try {
                    if (dataInputStream.available() > 0) System.out.println("quedan: " +dataInputStream.available() + " bytes");
                    String fic = dataInputStream.readUTF();
                    System.out.println("cadea: " + fic);
                    cadenas.add(fic);
                } catch (EOFException e) {
                    System.out.println("Xa non queda nada por leer");
                    break;
                } catch (IOException e) {
                    System.out.println("Fallo de  I/O " + e);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no ha sido encontrado");
        } catch (IOException e) {
            System.out.println("Error Entrada/Salida");
        }
        return cadenas;
    }
}

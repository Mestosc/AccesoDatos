package Parte3;

import java.io.*;
import java.util.ArrayList;

public class Ejercicio1 {
    public static void main(String[] args) {
        escribirUTF("prob.txt","o tempo está xélido");
        for (String i : leerUTF("prob.txt")) {
            System.out.println(i);
        }
    }
    public static void escribirUTF(String fichero,String cadena) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(fichero))) {
            dataOutputStream.writeUTF(cadena);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado? " + e);
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
    }
    public static ArrayList<String> leerUTF(String fichero) {
        ArrayList<String> cadenas = new ArrayList<>();
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(fichero))) {
            while (true)
                try {
                    cadenas.add(dataInputStream.readUTF());
                } catch (EOFException e) {
                    System.out.println("Final alcanzado");
                    break;
                } catch (IOException e) {
                    System.out.println("Fallo de  I/O " + e);
                }
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no ha sido encontrado");
        } catch (IOException e) {
            System.out.println("Error Entrada/Salida");
        }
        return cadenas;
    }
}

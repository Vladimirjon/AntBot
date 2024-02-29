package DataAccessExamen.ArchivoTexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class vistaTexto {

       public static ArrayList<String> obtenerPalabras() {
        ArrayList<String> listaPalabras = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader("setAlimento.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                // Dividir la línea en palabras utilizando espacios como separadores
                String[] palabras = linea.split("\\s+");

                // Agregar cada palabra al ArrayList
                for (String palabra : palabras) {
                    listaPalabras.add(palabra);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaPalabras;
    }
}

package DataAcess.ArchivoTexto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class archivoTexto {

    public static void EscribirArchivo(String larva, String alimento) {
        File archivo;
        FileWriter escribir;
        PrintWriter linea;

        archivo = new File("setAlimento.txt");

        try {
           
            escribir = new FileWriter(archivo, true);
            linea = new PrintWriter(escribir);

            linea.print(larva  + ":" + alimento + "\n");
            

            linea.close();
            escribir.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

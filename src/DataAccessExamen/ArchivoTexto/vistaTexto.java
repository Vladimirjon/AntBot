package DataAccessExamen.ArchivoTexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class vistaTexto {

    public static void leerArchivo() {
        FileReader archivo;
        BufferedReader lector;

        try {
            archivo = new FileReader("setAlimento.txt");
            lector = new BufferedReader(archivo);

            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }

            lector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

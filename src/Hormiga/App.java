package Hormiga;

import java.util.Random;

import DataAccessExamen.ArchivoTexto.archivoTexto;
import DataAccessExamen.ArchivoTexto.vistaTexto;

import java.util.ArrayList;


public class App {

    public static void main(String[] args) {
        
        String[] clasificacion = { "Soldado", "Zangano", "Reina", "Larva", "Rastreadora" };

        NumeroSerie oNumeroSerie = new NumeroSerie();

         archivoTexto TParchivoTexto = new archivoTexto();
         vistaTexto TPvistaTexto = new vistaTexto();

         ArrayList<String> palabras = TPvistaTexto.obtenerPalabras();

        AntBot oAntBot = new AntBot();

        Hormiga Hormiguita = null;

        

        ArrayList<Hormiga> listaHormigas = new ArrayList<>();

        int codigo;

        for (int i = 0; i < 20; i++) {

            codigo = oNumeroSerie.generarCodigoUnico();

            Random random = new Random();
            
            int indiceAleatorio = random.nextInt(clasificacion.length);
            
            String elementoAleatorio = clasificacion[indiceAleatorio];
            String numserieunica = oNumeroSerie.generarserieUnica();

            switch (indiceAleatorio) {
                case 0:
                    System.out.println(elementoAleatorio);
                    Hormiguita = new Hormiga(codigo, numserieunica, elementoAleatorio);
                    System.out.println(numserieunica);
                    Hormiguita.oAntBot.Instrucciones(elementoAleatorio);
                    System.out.println(Hormiguita.oAntBot.generarExtremidades());
                    oAntBot.IdiomarIngles();
                    oAntBot.IdiomarRuso();
                   
                    
                    break;
                case 1:
                    System.out.println(elementoAleatorio);
                    Hormiguita = new Hormiga(codigo, numserieunica, elementoAleatorio);
                    System.out.println(numserieunica);
                    Hormiguita.oAntBot.Instrucciones(elementoAleatorio);
                    System.out.println(Hormiguita.oAntBot.generarExtremidades());
                    System.out.println("Fuente de poder al maximo. Alas listo para su uso");
                    System.out.println("Alas integradas en el torso");
                    oAntBot.IdiomarIngles();
                    oAntBot.IdiomarRuso();
                    break;
                case 2:
                System.out.println(elementoAleatorio);
                    Hormiguita = new Hormiga(codigo, elementoAleatorio);
                    break;
                case 3:
                System.out.println(elementoAleatorio);
                    Hormiguita = new Hormiga(codigo, elementoAleatorio);
                    break;
                case 4:
                System.out.println(elementoAleatorio);
                    Hormiguita = new Hormiga(codigo, numserieunica, elementoAleatorio);
                    System.out.println(numserieunica);
                    Hormiguita.oAntBot.Instrucciones(elementoAleatorio);
                    System.out.println(Hormiguita.oAntBot.generarExtremidades());
                    oAntBot.IdiomarIngles();
                    oAntBot.IdiomarRuso();
                    break;
                default:
                System.err.println("Error en la asignación de etiqueta");
                    break;
            }
            listaHormigas.add(Hormiguita);


            System.out.println(Hormiguita.getCodigoUnico());
            
            Hormiguita.setListaHormigas(listaHormigas);

            
            
        }
        // for (Hormiga hormiga : listaHormigas) {
        //     System.out.println(hormiga.getTPtipoHormiga());
        // }
        
      
        System.out.println("");    
        
        Hormiguita.verificarReina();
        Hormiguita.TPcrearLarvas();
        for (int i = 1; i < 2; i++) {
        System.out.println(Hormiguita.getTPlarvas());

        }

        //TPvistaTexto.obtenerPalabras();
    }

    // private static DatosHormiga seleccionarHormigaReina(ArrayList<DatosHormiga> listaHormigas) {
    //     for (DatosHormiga hormiga : listaHormigas) {
    //         // Add your logic to determine if the hormiga is the queen
    //         // For example, check a property like isReina() if it exists in DatosHormiga
    //         if (hormiga.isReina()) {
    //             return hormiga;
    //         }
    //     }
    
    //     // Return null if no queen is found
    //     return null;
    // }
}

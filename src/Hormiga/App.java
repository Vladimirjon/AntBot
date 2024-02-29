package Hormiga;

import java.util.Random;
import java.util.ArrayList;


public class App {

    public static void main(String[] args) {
        ArrayList<Hormiga> listaHormigas = new ArrayList<>();
        String[] clasificacion = { "Soldado", "Zangano", "Reina", "Larva", "Rastreadora" };

        NumeroSerie oNumeroSerie = new NumeroSerie();

        AntBot oAntBot = new AntBot();

        Hormiga Hormiguita = null;

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
            
            System.out.println(Hormiguita.getCodigoUnico());
            
            listaHormigas.add(Hormiguita);
            
            
        }

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

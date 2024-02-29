package Hormiga;

import java.security.GeneralSecurityException;
import java.util.Random;

import javax.sound.midi.Soundbank;

public class App {

    public static void main(String[] args) {

        String[] clasificacion = { "SOLDADO", "ZANGANO", "REINA", "LARVA", "RASTREADORA" };

        NumeroSerie oNumeroSerie = new NumeroSerie();

        AntBot oAntBot = new AntBot();

        Hormiga Hormiguita = null;

       

        int especie = oNumeroSerie.randomHormiga();
        

        int codigo;

        for (int i = 0; i < 20; i++) {

            codigo = oNumeroSerie.generarCodigoUnico();

            Random random = new Random();
            
            int indiceAleatorio = random.nextInt(clasificacion.length);
            
            String elementoAleatorio = clasificacion[indiceAleatorio];
            String numserieunica = oNumeroSerie.generarserieUnica();

            switch (indiceAleatorio) {
                case 0:
                Hormiguita = new Hormiga(codigo, numserieunica);
                    System.out.println(elementoAleatorio);
                    System.out.println(numserieunica);
                    Hormiguita.oAntBot.Instrucciones(elementoAleatorio);
                    System.out.println(Hormiguita.oAntBot.generarExtremidades());
                    oAntBot.IdiomarIngles();
                    oAntBot.IdiomarRuso();
                   
                    
                    break;
                case 1:
                Hormiguita = new Hormiga(codigo, numserieunica);
                    System.out.println(elementoAleatorio);
                    System.out.println(numserieunica);
                    Hormiguita.oAntBot.Instrucciones(elementoAleatorio);
                    System.out.println(Hormiguita.oAntBot.generarExtremidades());
                    System.out.println("Fuente de poder al maximo. Alas listo para su uso");
                    System.out.println("Alas integradas en el torso");
                    oAntBot.IdiomarIngles();
                    oAntBot.IdiomarRuso();
                    System.out.println();
                    break;
                case 2:
                Hormiguita = new Hormiga(codigo);
                System.out.println(elementoAleatorio);
                    System.out.println();

                    break;
                case 3:
                Hormiguita = new Hormiga(codigo);
                System.out.println(elementoAleatorio);
                    System.out.println();

                    break;
                case 4:
                Hormiguita = new Hormiga(codigo, numserieunica);
                System.out.println(elementoAleatorio);
                    System.out.println(numserieunica);
                    Hormiguita.oAntBot.Instrucciones(elementoAleatorio);
                    System.out.println(Hormiguita.oAntBot.generarExtremidades());
                    oAntBot.IdiomarIngles();
                    oAntBot.IdiomarRuso();
                    System.out.println();

                    break;
                default:
                System.err.println("Error en la asignación de etiqueta");
                System.out.println();

                    break;
            }
            
            System.out.println(Hormiguita.getCodigoUnico());
            
         
            
            
        }

    }
}

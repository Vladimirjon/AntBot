package Hormiga;

import java.util.Random;

public class Hormiga {
    
    private int codigoUnico;
    private String numeroSerie;
    AntBot oAntBot;

    


    public String getNumeroSerie() {
        return numeroSerie;
    }

    // public void setNumeroSerie(String numeroSerie) {
    //     this.numeroSerie = numeroSerie;
    // }

    public int getCodigoUnico() {
        return codigoUnico;
    }

    // Constructor
    public Hormiga(int codigoUnico) {
        
        this.codigoUnico = codigoUnico;





        // if(Hormiga.tipodeHormiga){
        //     int tipodeHormiga = new Random().nextInt(5);
        //     switch (tipodeHormiga) {
        //         case 1:
                    
        //             break;
        //         case 2:
                    
        //             break;
        //         case 3:
                    
        //             break;
        //         case 4:
                    
        //             break;
        //         case 5:
        //             System.out.println(Clasificacion[5]);

        //             break;
            
        //         default:
        //             break;
        //     }
        // }


        // public void TJhormiguita() {
        //     // Declarar un array de cadenas
        //     String[] clasificacion = {"Soldado", "Zangano", "Reina", "Larva", "Rastereadora"};
    
        //     // Crear una instancia de la clase Random
        //     Random random = new Random();
    
        //     // Obtener un índice aleatorio
        //     int indiceAleatorio = random.nextInt(clasificacion.length);
    
        //     // Acceder al elemento en el índice aleatorio
        //     String elementoAleatorio = clasificacion[indiceAleatorio];
    
        //     // Imprimir el elemento aleatorio
        //     System.out.println("Elemento aleatorio: " + elementoAleatorio);
        // }
    }

    public Hormiga(int codigoUnico, String numeroSerie){
        this.codigoUnico=codigoUnico;
        this.numeroSerie=numeroSerie;
        oAntBot = new AntBot();
        AntBot oAntBot = new AntBot();
        


    }
    String[] Clasificacion={"Soldado","Zangano","Reina","Larva","Rastereadora"};


   
}




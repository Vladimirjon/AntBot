package Hormiga;

import java.util.Random;

class NumeroSerie{

    //1. soldado
    //2. rastreadora
    //3. larva
    //4. reina
    //5. zangano

    public int randomHormiga() {

        Random random = new Random();

        int numeroAleatorio = random.nextInt(5) + 1;
        
        return numeroAleatorio;
    }

    public int generarCodigoUnico() {
        Random random = new Random();
        // Generar un número aleatorio en el rango de 100 a 999 (inclusive)
        int numeroAleatorio = random.nextInt(900) + 100;
        return numeroAleatorio;}

    private final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final int LONGITUD = 5;
    
    public String generarserieUnica(){
        StringBuilder numeroSerie = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < LONGITUD; i++) {
            int indiceAleatorio = random.nextInt(CARACTERES.length());
            numeroSerie.append(CARACTERES.charAt(indiceAleatorio));
        }
        return numeroSerie.toString();
    }

    // public void asignarEspecie(this.randomHormiga){

    // }
    

    // Hormiga oHormiga = new Hormiga();

}
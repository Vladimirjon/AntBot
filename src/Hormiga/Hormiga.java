package Hormiga;

import java.util.ArrayList;
import java.util.Random;

public class Hormiga implements  IHormiga {
    
    private int codigoUnico;
    private String numeroSerie;
    private String TPtipoHormiga;
    NumeroSerie oNumeroSerie = new NumeroSerie();
    AntBot oAntBot;
    ArrayList<Hormiga> listaHormigas = new ArrayList<>();
<<<<<<< HEAD
=======
    public ArrayList<Hormiga> getTPgusanos() {
        return TPgusanos;
    }


    public void setTPgusanos(ArrayList<Hormiga> tPgusanos) {
        TPgusanos = tPgusanos;
    }
>>>>>>> 7e5bf34edfd5f5ffdd4b6ccb1310ab3b75f9d0c2
    ArrayList<Hormiga> TPgusanos = new ArrayList<>();

    public ArrayList<String> getTPlarvas() {
        return TPlarvas;
    }


    public void setTPlarvas(ArrayList<String> tPlarvas) {
        TPlarvas = tPlarvas;
    }
    ArrayList<String> TPlarvas = new ArrayList<>();

    public String getNumeroSerie() {
        return numeroSerie;
    }


    public int getCodigoUnico() {
        return codigoUnico;
    }

    // Constructor
    public Hormiga(int codigoUnico, String TJtipoHormiga) {
        
        this.codigoUnico = codigoUnico;
        this.TPtipoHormiga = TJtipoHormiga;
    }

    public Hormiga(int codigoUnico, String numeroSerie, String TJtipoHormiga){
        this.codigoUnico=codigoUnico;
        this.numeroSerie=numeroSerie;
        this.TPtipoHormiga=TJtipoHormiga;
        oAntBot = new AntBot();
        AntBot oAntBot = new AntBot();
        


    }
    String[] Clasificacion={"Soldado","Zangano","Reina","Larva","Rastereadora"};

    public void setCodigoUnico(int codigoUnico) {
        this.codigoUnico = codigoUnico;
    }


    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }


    public String getTPtipoHormiga() {
        return TPtipoHormiga;
    }


    public void setTPtipoHormiga(String tJtipoHormiga) {
        TPtipoHormiga = tJtipoHormiga;
    }


    public AntBot getoAntBot() {
        return oAntBot;
    }


    public void setoAntBot(AntBot oAntBot) {
        this.oAntBot = oAntBot;
    }


    public ArrayList<Hormiga> getListaHormigas() {
        return listaHormigas;
    }


    public void setListaHormigas(ArrayList<Hormiga> listaHormigas) {
        this.listaHormigas = listaHormigas;
    }


    public String[] getClasificacion() {
        return Clasificacion;
    }


    public void setClasificacion(String[] clasificacion) {
        Clasificacion = clasificacion;
    }

    // public Hormiga comprobarReina(Hormiga lisHormiga){
    //     for (Hormiga hormiga : lisHormiga){
    //         String nombreHormiga =  hormiga.getNombre();
    //     }
    // }
    public int verificarReina() {
        for (int i = 0; i < listaHormigas.size(); i++) {
            Hormiga hormiga = listaHormigas.get(i);
            String nombreHormiga = hormiga.getTPtipoHormiga();
            
            if (nombreHormiga.equalsIgnoreCase("Reina")) {
                return i;  // Retorna la Reina y sale del método
            }
        }
    
        // Si llegamos aquí, significa que no se encontró ninguna hormiga "Reina"
        System.out.println("No se encontró ninguna Reina en la lista.");
        return 0;
    }

    // public void TPcrearLarvas(){
    //     int posicionReina = verificarReina();
    //     TPlarvas = new ArrayList<>();
    //     if (posicionReina  != 0) {
    //         for(int i=1; i<=40; i++){
    //             TPlarvas.add("Larva" + i);
    //         }
    //     }

    // }

    public void TPcrearLarvas() {
        int posicionReina = verificarReina();
        TPlarvas = new ArrayList<>();

        if (posicionReina != -1) {
            for (int i = 1; i <= 40; i++) {
                // Generar código único
                int codigoUnico = oNumeroSerie.generarCodigoUnico();
                // Crear nombre de larva
                String nombreLarva = "Larva" + i;

                // Crear instancia de Hormiga y agregarla a la lista
                TPgusanos.add(new Hormiga(codigoUnico, nombreLarva));
            }
        }

    }

    // public void TPcrearLarvas() {
    //     int posicionReina = verificarReina();
    //     TPlarvas = new ArrayList<>();

    //     if (posicionReina != -1) {
    //         for (int i = 1; i <= 40; i++) {
    //             // Generar código único
    //             int codigoUnico = oNumeroSerie.generarCodigoUnico();
    //             // Crear nombre de larva
    //             String nombreLarva = "Larva" + i;
    //             System.out.println("");

    //             // Crear instancia de Hormiga y agregarla a la lista
    //             TPgusanos.add(new Hormiga(codigoUnico, nombreLarva));
    //         }
    //     }
    // }
    

    
    public boolean comer(String alimento){
        if (alimento.equals("Carnivoro")) {
            return true;
        }
        return false;
    }

    
   
}




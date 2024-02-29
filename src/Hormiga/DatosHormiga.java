package Hormiga;

import java.util.Random;

public class DatosHormiga {
    
    private int codigoUnico;
    private String numeroSerie;
    private String TJtipoHormiga;
    AntBot oAntBot;

    public String getNumeroSerie() {
        return numeroSerie;
    }


    public int getCodigoUnico() {
        return codigoUnico;
    }

    // Constructor
    public DatosHormiga(int codigoUnico, String TJtipoHormiga) {
        
        this.codigoUnico = codigoUnico;
        this.TJtipoHormiga = TJtipoHormiga;
    }

    public DatosHormiga(int codigoUnico, String numeroSerie, String TJtipoHormiga){
        this.codigoUnico=codigoUnico;
        this.numeroSerie=numeroSerie;
        this.TJtipoHormiga=TJtipoHormiga;
        oAntBot = new AntBot();
        AntBot oAntBot = new AntBot();
        


    }
    String[] Clasificacion={"Soldado","Zangano","Reina","Larva","Rastereadora"};


   
}




package Hormiga;
import DataAccessExamen.ArchivoTexto.archivoTexto;
import DataAccessExamen.ArchivoTexto.vistaTexto;
import DataAcess.*;

public class HormigaReina extends Hormiga {

    //   public Hormiga comprobarReina(Hormiga lisHormiga){
    //     for (Hormiga hormiga : lisHormiga){
    //         String nombreHormiga =  hormiga.getNombre();
    //     }
    // }
    
    
    // public String verificarReina(){
    //     String nombreHormiga = "";
    //     //while(!nombreHormiga.equals("Reina")){
    //         for (int i = 0; i < listaHormigas.size(); i++) {
    //             Hormiga hormiga = listaHormigas.get(i);
    //             nombreHormiga = hormiga.getTPtipoHormiga();
    //             System.out.println(hormiga.getTPtipoHormiga());
    //             if (nombreHormiga.equalsIgnoreCase("Reina")) {
    //                 return nombreHormiga;
    //             }
    //         }
    //     //}
    //     return null;
    // }
        


     
    public HormigaReina(int codigoUnico, String TJtipoHormiga) {
        super(codigoUnico, TJtipoHormiga);
        //TODO Auto-generated constructor stub
    }

    archivoTexto archivoTexto = new archivoTexto();
    vistaTexto vistaTexto = new vistaTexto();
    NumeroSerie oNumeroSerie = new NumeroSerie();
    
    


    int codigo;
    Hormiga Hormiguita = null;

    // public void HormigasCreadas(){
    //     for(int i = 1;  i <= 40; i++){
    //         codigo = oNumeroSeriegenerarCodigoUnico();        
    //         Hormiguita = new Hormiga(codigo);        
    //     }
    
        
    // }



}

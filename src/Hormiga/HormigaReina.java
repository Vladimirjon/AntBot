package Hormiga;
import DataAccessExamen.ArchivoTexto.archivoTexto;
import DataAccessExamen.ArchivoTexto.vistaTexto;
import DataAcess.*;

public class HormigaReina {
     
    archivoTexto archivoTexto = new archivoTexto();
    vistaTexto vistaTexto = new vistaTexto();
    NumeroSerie oNumeroSerie = new NumeroSerie();
    
    Hormiga Hormiga = new App();


    int codigo;
    Hormiga Hormiguita = null;

    public void HormigasCreadas(){
        for(int i = 1;  i <= 40; i++){
            codigo = oNumeroSeriegenerarCodigoUnico();        
            Hormiguita = new Hormiga(codigo);        
        }
    
        
    }



}

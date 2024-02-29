package Hormiga;
import DataAcess.*;
import DataAcess.ArchivoTexto.archivoTexto;
import DataAcess.ArchivoTexto.vistaTexto;

public class HormigaReina {
     
    archivoTexto archivoTexto = new archivoTexto();
    vistaTexto vistaTexto = new vistaTexto();
    NumeroSerie oNumeroSerie = new NumeroSerie();
    
    DatosHormiga Hormiga = new Hormiga();


    int codigo;
    DatosHormiga Hormiguita = null;

    public void HormigasCreadas(){
        for(int i = 1;  i <= 40; i++){
            codigo = oNumeroSeriegenerarCodigoUnico();        
            Hormiguita = new DatosHormiga(codigo);        
        }
    
        
    }



}

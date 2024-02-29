package DataAccessExamen.DTO;

public class tpLarvasDTO {


        private int IdHormiga;
        private String CodigoHormiga;
        private String Clasificacion;
        private String Comio;
        private String Estado;
        private String Recogio;
    
        public tpLarvasDTO() {
        }
    
        public tpLarvasDTO(int idHormiga, String codigoHormiga, String clasificacion, String comio, String estado, String recogio) {
            IdHormiga = idHormiga;
            CodigoHormiga = codigoHormiga;
            Clasificacion = clasificacion;
            Comio = comio;
            Estado = estado;
            Recogio = recogio;
        }
    
        public int getIdHormiga() {
            return IdHormiga;
        }
    
        public void setIdHormiga(int idHormiga) {
            IdHormiga = idHormiga;
        }
    
        public String getCodHormiga() {
            return CodigoHormiga;
        }
    
        public void setCodHormiga(String codigoHormiga) {
            CodigoHormiga = codigoHormiga;
        }
    
        public String getClasificacion() {
            return Clasificacion;
        }
    
        public void setClasificacion(String clasificacion) {
            Clasificacion = clasificacion;
        }
    
        public String getComio() {
            return Comio;
        }
    
        public void setComio(String comio) {
            Comio = comio;
        }
    
        public String getEstado() {
            return Estado;
        }
    
        public void setEstado(String estado) {
            Estado = estado;
        }
    
        public String getRecogio() {
            return Recogio;
        }
    
        public void setRecogio(String recogio) {
            Recogio = recogio;
        }
    
    }
    
    // public String toString(){
    //     return getClass().getName()
    //     +"\n IdHormiga: "+getIdHormiga()
    //     +"\n CodigoHormiga: "+getCodHormiga()
    //     +"\n Clasificacion: "+getClasificacion()
    //     +"\n Comio: "+getComio()
    //     +"\n Estado: "+getEstado()
    //     +"\n Recogio: " +getRecogio();
    // }




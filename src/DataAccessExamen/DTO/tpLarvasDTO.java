package DataAccessExamen.DTO;

public class tpLarvasDTO {
    private Integer IdHormiga;
    public Integer getIdHormiga() {
        return IdHormiga;
    }

    public void setIdHormiga(Integer idHormiga) {
        IdHormiga = idHormiga;
    }
    private String CodHormiga;
    public String getCodHormiga() {
        return CodHormiga;
    }

    public void setCodHormiga(String codHormiga) {
        CodHormiga = codHormiga;
    }
    private String Clasificacion;
    public String getClasificacion() {
        return Clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        Clasificacion = clasificacion;
    }
    private String Comio;
    public String getComio() {
        return Comio;
    }

    public void setComio(String comio) {
        Comio = comio;
    }
    private String Estado;
    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
    private String Recogio;

    public String getRecogio() {
        return Recogio;
    }

    public void setRecogio(String recogio) {
        Recogio = recogio;
    }

    public tpLarvasDTO(){

    }

    public tpLarvasDTO(int id,String codigo,String clasificacion,String comio,String estado,String recogio){
        IdHormiga=id;
        CodHormiga=codigo;
        Clasificacion=clasificacion;
        Comio=comio;
        Estado=estado;
        Recogio=recogio;
    }
    public String toString(){
        return getClass().getName()
        +"\n IdHormiga: "+getIdHormiga()
        +"\n CodigoHormiga: "+getCodHormiga()
        +"\n Clasificacion: "+getClasificacion()
        +"\n Comio: "+getComio()
        +"\n Estado: "+getEstado()
        +"\n Recogio: " +getRecogio();
    }
}



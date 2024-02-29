package DataAcess.DTO;

public class ClasificacionHormigaDTO {

    private Integer IdCategoriaHormiga;

    public void setIdCategoriaHormiga(Integer idCategoriaHormiga) {
        IdCategoriaHormiga = idCategoriaHormiga;
    }

    public Integer getIdCategoriaHormiga() {
        return IdCategoriaHormiga;
    }

    private String ClasificacionHormiga;

    public void setClasificacionHormiga(String clasificacionHormiga) {
        ClasificacionHormiga = clasificacionHormiga;
    }

    public String getClasificacionHormiga() {
        return ClasificacionHormiga;
    }

    public ClasificacionHormigaDTO(){

    }

    private String FechaCrea;

    public String getFechaCrea() {
        return FechaCrea;
    }

    public void setFechaCrea(String fechaCrea) {
        FechaCrea = fechaCrea;
    }

    private String FechaModifica;

    public String getFechaModifica() {
        return FechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        FechaModifica = fechaModifica;
    }

    public ClasificacionHormigaDTO(int IdCategoriaHormiga, String ClasificacionHormiga,String fechacrea,String fechamodifica) {
        this.IdCategoriaHormiga = IdCategoriaHormiga;
        this.ClasificacionHormiga = ClasificacionHormiga;
        this.FechaCrea = fechacrea;
        this.FechaModifica= fechamodifica;

    }

    public String toString(){
        return getClass().getName()
        + "\n Id:       "+ getIdCategoriaHormiga()       
        + "\n TipoHormiga:       "+ getClasificacionHormiga()      
        + "\n FechaCrea:       "+ getFechaCrea() 
        + "\n FechaModifica:       "+ getFechaModifica();
    }



    }    



    // private Integer IdPregunta;
    // private Integer IdCategoriaEstructura;
    // private String Enunciado;

    // private String Estado;
    // private String FechaCrea;
    // private String FechaModifica;

    // public PreguntaDTO() {
    // }

    // public PreguntaDTO(int IdPregunta, int IdCategoriaEstructura, String Enunciado, String Estado,
    //         String FechaCrea, String FechaModifica) {
    //     this.IdPregunta = IdPregunta;
    //     this.IdCategoriaEstructura = IdCategoriaEstructura;
    //     this.Enunciado = Enunciado;

    //     this.Estado = Estado;
    //     this.FechaCrea = FechaCrea;
    //     this.FechaModifica = FechaModifica;
    // }

    // public Integer getIdPregunta() {
    //     return IdPregunta;
    // }

    // public Integer getIdCateogoriaEstructura() {
    //     return IdCategoriaEstructura;
    // }

    // public String getEnunciado() {
    //     return Enunciado;
    // }

    // public String getEstado() {
    //     return Estado;
    // }

    // public String getFechaCrea() {
    //     return FechaCrea;
    // }

    // public String getFechaModifica() {
    //     return FechaModifica;
    // }

    // @Override
    // public String toString() {
    //     return "\n \nPREGUNTA:     " + getIdPregunta() + ": " + getEnunciado();

    // }


package DataAcess.DTO;

public class ClasificacionHormigaDTO {

    private Integer IdCategoriaHormiga;

    public Integer getIdCategoriaHormiga() {
        return IdCategoriaHormiga;
    }

    private String ClasificacionHormiga;

    public String getClasificacionHormiga() {
        return ClasificacionHormiga;
    }

    public ClasificacionHormigaDTO(){

    }

    public ClasificacionHormigaDTO(int IdCategoriaHormiga, String ClasificacionHormiga) {
        this.IdCategoriaHormiga = IdCategoriaHormiga;
        this.ClasificacionHormiga = ClasificacionHormiga;
        

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


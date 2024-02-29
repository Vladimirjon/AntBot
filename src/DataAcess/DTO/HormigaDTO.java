package DataAcess.DTO;

public class HormigaDTO {

    private Integer IdHormiga;

    public Integer getIdHormiga() {
        return IdHormiga;
    }

    private String CodigoHormiga;

    public String getCodigoHormiga() {
        return CodigoHormiga;
    }

    private Integer IdCategoriaHormigas;

    public Integer getIdCategoriaHormigas() {
        return IdCategoriaHormigas;
    }

    private Integer SerieAntBot;

    public Integer getSerieAntBot() {
        return SerieAntBot;
    }

    public HormigaDTO() {
    }

    public HormigaDTO(Integer IdHormiga, String CodigoHormiga, Integer IdCategoriaHormigas, Integer SerieAntBot) {
        this.IdHormiga = IdHormiga;
        this.CodigoHormiga = CodigoHormiga;
        this.IdCategoriaHormigas = IdCategoriaHormigas;
        this.SerieAntBot = SerieAntBot;

    }

    //@Override
    // public String toString() {
    //     return "\n \nPREGUNTA:     " + getIdPregunta() + ": " + getEnunciado();

    // }

}

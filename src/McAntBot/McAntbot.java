package McAntBot;

import McEjercitoRuso.McITecnicoEspanol;
import McEjercitoRuso.McITecnicoIngles;
import McInteligenciaArtificial.IAbot;

public class McAntbot extends IAbot
        implements McIantBotComponentes, McITecnicoEspanol, McITecnicoIngles, IgenerarCodigo, IgenerarSerie {

    public McAntbot(IAbot iAbot) {
        super(iAbot);
        MchormigaReina ohormigaReina = new MchormigaReina();
        ohormigaReina.mostrar();
        MchormigaLarva ohormigaLarva = new MchormigaLarva();
        ohormigaLarva.mostrar();
        MchormigaSoldado oSoldado =  new MchormigaSoldado();
        oSoldado.mostrar();
        MchormigaZangano ohormigaZangano =  new MchormigaZangano();
        ohormigaZangano.integrarAlas();
        MchormigaRastreadora ohormigaRastreadora = new MchormigaRastreadora();
        ohormigaRastreadora.mostrar();
    
    }
}

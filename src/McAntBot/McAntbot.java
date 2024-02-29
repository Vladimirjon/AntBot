package McAntBot;

import McEjercitoRuso.McExpertoIngles;
import McEjercitoRuso.McExpertoRuso;
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
        mcProcesador i = new mcProcesador();
        McAntenas mcAntenas = new McAntenas();
        McCircuitoAnillado circuitoAnillado = new McCircuitoAnillado();
        MccircuitoCarga c = new MccircuitoCarga();
        McRadio mcRadio = new McRadio();
        McSensorOptico sensorOptico=new McSensorOptico();
        MctransductorFlexion mctransductorFlexion = new MctransductorFlexion();
        McTenaza mcTenaza = new McTenaza();
        McExpertoIngles mcExpertoIngles = new McExpertoIngles();
        McExpertoRuso mcExpertoRuso = new McExpertoRuso();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("--->   --->   --->   Formica rufa creada con las siguientes caracteristicas <---  <---  <--- ");
        System.out.println("");
        if(McAntbot.mcProcesador)
        i.mcProceso();
        if(McAntbot.mcantenas)
        System.out.println("");
        mcAntenas.mccontactar();
        System.out.println("");
        if(McAntbot.mccircuitoAnillado)
        circuitoAnillado.MccircuitoAnillado();
        System.out.println("");
        if(McAntbot.mccirucitoCarga)
        c.carga();
        System.out.println("");
        if(McAntbot.mcradio)
        mcRadio.mccomunicacion();
        System.out.println("");
        if(McAntbot.mcsensorOptico)
        sensorOptico.mccamara();
        System.out.println("");
        if(McAntbot.mctTransductorFlexion)
        mctransductorFlexion.MctransductorFlexion1();
        System.out.println("");
        if(McAntbot.mctenaza)
        mcTenaza.McTenaza1();
        System.out.println("");
        if(McAntbot.mctronco)
        System.out.println("            MEDIDAS DE LA FORMICA RUFA");
        System.out.println("--->  20 cm largo , 5 cm alto , 5 cm ancho ");
        System.out.println("");
        if(McAntbot.ensenarruso)
        mcExpertoRuso.idiomar();
        System.out.println("");
        if(McAntbot.ensenaringles)
        mcExpertoIngles.idioma();
        System.out.println("");
        System.out.println("");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("ZANGANO");

    }
}

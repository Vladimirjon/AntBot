package McAntBot;

import McEjercitoRuso.McITecnicoEspanol;
import McEjercitoRuso.McITecnicoIngles;
import McInteligenciaArtificial.IAbot;

public class McAntbot extends IAbot implements McIantBotComponentes,McITecnicoEspanol,McITecnicoIngles,IgenerarCodigo,IgenerarSerie{

    public McAntbot(IAbot iAbot) {
        super(iAbot);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("--->   --->   --->   Formica rufa creada con las siguientes caracteristicas <---  <---  <--- ");
        System.out.println("");
        if(McAntbot.mcProcesador)
        System.out.println("--->  Procesador para distribuir senales en funcionamiento");
        if(McAntbot.mcantenas)
        System.out.println("");
        System.out.println("--->  Antenas de contacto ");
        McAntenas mcAntenas = new McAntenas();
        mcAntenas.mccontactar();
        System.out.println("");
        if(McAntbot.mccircuitoAnillado)
        System.out.println("--->  Circuito Anillado con salida de 300 V");
        McCircuitoAnillado circuitoAnillado = new McCircuitoAnillado();
        circuitoAnillado.MccircuitoAnillado();
        System.out.println("");
        if(McAntbot.mccirucitoCarga)
        System.out.println("--->  La bateria esta cargada y con 40 minutos de vida");
        System.out.println("");
        if(McAntbot.mcradio)
        System.out.println("--->  Radio para comunicacion con otros soldados funcional");
        McRadio mcRadio = new McRadio();
        mcRadio.mccomunicacion();
        System.out.println("");
        if(McAntbot.mcsensorOptico)
        System.out.println("--->  Sensor Optico y camara en funcionamiento ");
        McSensorOptico sensorOptico=new McSensorOptico();
        sensorOptico.mccamara();
        System.out.println("");
        if(McAntbot.mctTransductorFlexion)
        System.out.println("--->  Transductor Flexión para movimiento");
        MctransductorFlexion mctransductorFlexion = new MctransductorFlexion();
        mctransductorFlexion.MctransductorFlexion1();
        System.out.println("");
        if(McAntbot.mctenaza)
        System.out.println("--->  Tenaza de agarre ");
        McTenaza mcTenaza = new McTenaza();
        mcTenaza.McTenaza1();
        System.out.println("");
        if(McAntbot.mctronco)
        System.out.println("            MEDIDAS DE LA FORMICA RUFA");
        System.out.println("--->  20 cm largo , 5 cm alto , 5 cm ancho ");
        System.out.println("");
        if(McAntbot.ensenarespanol)
        System.out.println("--->  Espanol tecnico.... lexico, gramatica, fonetica transferida al ANTBOT");
        System.out.println("");
        if(McAntbot.ensenaringles)
        System.out.println("--->  Ingles tecnico.... lexico, gramatica, fonetica transferida al ANTBOT");
        System.out.println("");
        System.out.println("");
        if(McAntbot.mcAlas)
            System.out.println("   Hormiga Zangano lista para volar con sus alas");
        }
    
    }



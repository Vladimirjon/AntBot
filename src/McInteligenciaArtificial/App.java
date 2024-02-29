package McInteligenciaArtificial;

import McAntBot.McAntbot;

public class App {
    public static void main(String[] args) throws Exception {
        IAbot iAbot = IAbot.getInstance("AntBot Formica Rufa");

        McAntbot a1 = new McAntbot(iAbot);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("HORMIGAS LISTAS PARA LA BATALLA");
        System.out.println("------------------------------------------------------------------------------");


    }
}
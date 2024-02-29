package Hormiga;

import java.util.Random;

public class AntBot extends IaBot {

    public String generarExtremidades() {
        String Extremidades;

        if (true) {
            boolean habilitar = new Random().nextBoolean();
            if (habilitar) {
                Extremidades ="Saltar 5m";
            } else {
                Extremidades = "Correr a 100 km/h";
            }
        }

        return Extremidades;
    }
}
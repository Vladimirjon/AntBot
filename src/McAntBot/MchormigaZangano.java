package McAntBot;

import java.util.Random;

public class MchormigaZangano {
    private int mcAlas;

    public MchormigaZangano() {
        // Generar un número aleatorio entre 1 y 4 para mcAlas
        Random random = new Random();
        mcAlas = random.nextInt(4) + 1;
    }

    public void integrarAlas() {
        System.out.println("La hormiga zángano está preparada con sus " + mcAlas + " alas");
    }
}

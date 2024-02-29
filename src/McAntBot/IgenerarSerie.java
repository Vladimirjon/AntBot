package McAntBot;

import java.security.SecureRandom;

public interface IgenerarSerie {
    default String generaSerie() {
        int length = 3;  // Longitud de los números aleatorios
        String caracteres = "0123456789";

        // Utiliza SecureRandom para generar números aleatorios de forma segura
        SecureRandom random = new SecureRandom();

        StringBuilder numerosAleatorios = new StringBuilder();
        
        // Genera tres números aleatorios
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(caracteres.length());
            char caracter = caracteres.charAt(index);
            numerosAleatorios.append(caracter);
        }

        // Concatena "HRM" con los números aleatorios
        return "HRM" + numerosAleatorios.toString();
    }
}

package McAntBot;

import java.security.SecureRandom;

public interface IgenerarSerie {
    default String generaSerie() {
        int length = 8;  // Longitud del código de serie
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        
        // Utiliza SecureRandom para generar números aleatorios de forma segura
        SecureRandom random = new SecureRandom();
        
        StringBuilder serieBuilder = new StringBuilder();
        
        // Genera el código de serie combinando letras y números
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(caracteres.length());
            char caracter = caracteres.charAt(index);
            serieBuilder.append(caracter);
        }
        
        return serieBuilder.toString();
    }
}

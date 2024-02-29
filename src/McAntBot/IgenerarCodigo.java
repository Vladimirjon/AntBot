package McAntBot;

import java.security.SecureRandom;

public interface IgenerarCodigo {
    default String generaCodigo() {
        int length = 6;  // Longitud del código
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        
        // Utiliza SecureRandom para generar números aleatorios de forma segura
        SecureRandom random = new SecureRandom();
        
        StringBuilder codigoBuilder = new StringBuilder();
        
        // Genera el código combinando letras y números
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(caracteres.length());
            char caracter = caracteres.charAt(index);
            codigoBuilder.append(caracter);
        }
        
        return codigoBuilder.toString();
    }
}

package McAntBot;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

interface IgenerarCodigo {
    default String generaCodigo() {
        int length = 6;  // Length of the code
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        // Use SecureRandom to generate random numbers securely
        SecureRandom random = new SecureRandom();

        StringBuilder codeBuilder = new StringBuilder();

        // Generate the code by combining letters and numbers
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char character = characters.charAt(index);
            codeBuilder.append(character);
        }

        return codeBuilder.toString();
    }
}
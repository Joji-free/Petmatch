package util;

import org.mindrot.jbcrypt.BCrypt;

public class HashUtil {

    // Encripta la contraseña
    public static String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt(12));
    }

    // Verifica si la contraseña ingresada coincide con la encriptada
    public static boolean checkPassword(String plainTextPassword, String hashedPassword) {
        return BCrypt.checkpw(plainTextPassword, hashedPassword);
    }
}

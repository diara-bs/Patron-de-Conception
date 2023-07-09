import java.util.*;
public class Bruteforce implements Attaque{
    public Bruteforce(){
    }
    public ArrayList<String> CreerAttaque(){
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    ArrayList<String> password = new ArrayList<String>();
		for (int i = 0; i < alphabet.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                for (int k = 0; k < alphabet.length; k++) {
                    for (int l = 0; l < alphabet.length; l++) {
                        String combination = "" + alphabet[i] + alphabet[j] + alphabet[k] + alphabet[l];
                        password.add(combination);
                    }
                }
            }
        }
	return (password);
}
}

import java.util.*;
import java.nio.charset.*;
import java.security.*;

public class TestAttaque{
    public static void main(String args[]) throws Exception{
        if ( args.length < 1 || args.length > 1 ){
            System.out.println(" Argument invalid");
            return;
        }
        System.out.println("Entrer votre mot de passe");
        Scanner sc  = new Scanner(System.in);
        String password = sc.nextLine();

        User user = new User();
        user.setUser(Hash.md5(password));
        AttaqueFactory factory = new AttaqueFactory();
        Attaque attaque = factory.getAttaque(args[0]);
        long avantattaque = System.currentTimeMillis();
        ArrayList<String> attaquer = new ArrayList<String>();
        attaquer = attaque.CreerAttaque();
       // System.out.println(user.getUser());
        for(String a : attaquer ){
           if(user.connexion(a)){
                System.out.println("LE MOT DE PASSE EST CRACKER AVEC SUCCEE :"+a) ;
                long apresattaque = System.currentTimeMillis();
                long duree = (apresattaque - avantattaque)/1000;
                System.out.println(duree+"secondes");
                return;
           }
        }
        String last = attaquer.get(attaquer.size()-1) ;
        if(!user.connexion(last))
            System.out.println("Malheureusemnt pour vous on peut pas cracker le mot de passe essayez une autre methode !!!");
    }
}
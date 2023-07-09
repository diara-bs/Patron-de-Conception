import  java.lang.Throwable;
public class AttaqueFactory {
public Attaque getAttaque(String nom)/*  throws UnknowFormatException */{
    Attaque hack = null;
    if(nom.equalsIgnoreCase("bruteforce")){
        hack= new Bruteforce();
    }
    else if(nom.equalsIgnoreCase("dictionnaire")){
        hack= new Dictionnaire();
    }
    else{
        throw new IllegalArgumentException("Unknown Attaque ");
       // throw new UnknowFormatException("Attaque");
    }
    return hack;
    }
}
// c'est notre fabrique où on instencie les classes Bruteforce et Dictionnaire
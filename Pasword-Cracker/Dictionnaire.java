import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Dictionnaire implements Attaque{
    public Dictionnaire(){    
    }
    public ArrayList<String> CreerAttaque(){
        ArrayList<String> lpassword = new ArrayList<String>();
        File dictionnaire =new File("dictionnaire.txt");
        try(Scanner ligne = new Scanner(dictionnaire) ){
            while(ligne.hasNextLine()){
               lpassword.add(ligne.nextLine());  
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return (lpassword);
    }
}
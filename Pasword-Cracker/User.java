public class User{
    private String login;
    private String password;
    public void setUser(String password){
        this.password=password;
    }
    public String getUser(){
       return this.password;
    }
    public boolean connexion(String connect)throws Exception{

        if(Hash.md5(connect).equals(this.password))return true;
        else return false;
    }
}
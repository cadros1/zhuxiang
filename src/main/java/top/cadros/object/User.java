package top.cadros.object;

public class User implements java.io.Serializable{
    int id;
    String account;
    String password;

    public User(String account,String password){
        this.account=account;
        this.password=password;
    }

    public int getID(){
        return this.id;
    }

    public String getAccount(){
        return this.account;
    }

    public String getPassword(){
        return this.password;
    }
}

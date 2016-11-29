package BusinessLogic;

import Database.MyDatabase;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * Created by Jennes on 25-11-2016.
 */
public class User {
    MyDatabase db = new MyDatabase();
    private String username;
    public TextField pass1;
    public TextField pass2;
    Security sc = new Security();

    public void addToTimeline(){

    }

    public void changeContent(){

    }

    public void deleteContent(){

    }

    public void changeLogin(String userN, String pass1, String pass2){
        if(pass1.equals(pass2)){
           db.editDataLogin(userN, sc.hashpw(pass1));
        }
        else{
            System.out.println("Koderne er ikke ens!");
        }
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

package BusinessLogic;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * Created by Jennes on 25-11-2016.
 */
public class User {
    private String username;
    public TextField pass1;
    public TextField pass2;
    public void addToTimeline(){

    }

    public void changeContent(){

    }

    public void deleteContent(){

    }

    public void changeLogin(){

        if(pass1.getText().equals(pass2.getText())){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Succes!");
            alert.setContentText("Dit password er nu ændret");
            alert.showAndWait();
            // metode fra database der ændrer til den nye kode ex. editDataLogin(String pass1);
            pass1.setText("");
            pass2.setText("");
        }
        else{
            System.out.println("Koderne er ikke ens!");
        }
    }

}

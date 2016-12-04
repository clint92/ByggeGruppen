package Controller;

import BusinessLogic.Admin;
import BusinessLogic.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class AdminController extends Controller implements Initializable {
    Admin newU = new Admin();
    //public TextField username;
    //public PasswordField password;




    @FXML
    public ComboBox<String> userType;
    ObservableList<String> types = FXCollections.observableArrayList("Client", "Contractor", "Admin");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userType.setItems(types);
    }

   /* public void createProfile()
    {
        String type = (userType.getValue());
        int level = -1;
        if(type ==  "Client")
        {
            level = 2;
        }
        else if(type == "Contractor")
        {
            level = 1;
        }
        else if(type == "Admin")
        {
            level = 0;
        }
        newU.addProfile(username.getText(), password.getText(), level);
    }*/
}

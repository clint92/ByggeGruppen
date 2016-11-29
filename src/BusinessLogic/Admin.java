package BusinessLogic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

/**
 * Created by Jennes on 25-11-2016.
 */
public class Admin extends User implements Initializable {
    private int userid = 1;

    public void setUserid(int id){
        this.userid = id;
    }

    public int getUserid(){
        return this.userid;
    }


    @FXML
    public ComboBox<String> userType;
    ObservableList<String> types = FXCollections.observableArrayList("Client", "Contractor", "Admin");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    userType.setItems(types);
    }

}

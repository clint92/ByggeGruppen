package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by clint on 29-11-2016.
 */
public class AdminController implements Initializable {

    @FXML
    public ComboBox<String> userType;
    ObservableList<String> types = FXCollections.observableArrayList("Client", "Contractor", "Admin");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userType.setItems(types);
    }
}

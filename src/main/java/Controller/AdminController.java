package Controller;

import BusinessLogic.MyProject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController extends Controller implements Initializable {
    @FXML
    public ComboBox<String> userType;
    ObservableList<String> types = FXCollections.observableArrayList("Client", "Contractor", "Admin");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userType.setItems(types);
        cb.setItems(BL.getProjects());
        cb.setOnAction(e-> {
            infoText.setText(BL.loadInformation(cb.getSelectionModel().getSelectedItem().toString()));
            MyProject.projectInstance().setProjectName(cb.getSelectionModel().getSelectedItem().toString());
        });
    }
}

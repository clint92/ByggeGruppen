package Controller;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController extends Controller implements Initializable{

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cb.setItems(op.getProjects());
        cb.setOnAction(e -> {
            infoText.setText(op.projectInformation(cb.getSelectionModel().getSelectedItem().toString()));
            op.setMyProjectName(cb.getSelectionModel().getSelectedItem().toString());
        });
    }
}

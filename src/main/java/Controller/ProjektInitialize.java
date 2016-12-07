package Controller;

import BusinessLogic.MyProject;
import BusinessLogic.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Julius on 06-12-2016.
 */
public class ProjektInitialize extends Controller implements Initializable {
    public ProjectAddUser e;
    public ComboBox<String> addUser;
    public ObservableList<String> types = FXCollections.observableArrayList("Client", "Contractor", "Admin");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        timeline.setVvalue(1.0);
        timeline.setContent(BL.getTimeline(MyProject.projectInstance().getProjectName()));

        e = new ProjectAddUser(addUser,types);
        e.initialize(location,resources);
    }

    public void addUserToProject()
    {

    }
}

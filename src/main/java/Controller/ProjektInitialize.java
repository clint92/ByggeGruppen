package Controller;

import BusinessLogic.MyProject;
import BusinessLogic.User;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Julius on 06-12-2016.
 */
public class ProjektInitialize extends Controller implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        timeline.setVvalue(1.0);
        timeline.setContent(BL.getTimeline(MyProject.projectInstance().getProjectName()));
    }
}

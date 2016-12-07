package Controller;

import BusinessLogic.MyProject;
import BusinessLogic.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import BusinessLogic.*;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.input.KeyEvent;
import javafx.util.StringConverter;
import java.net.URL;
import java.util.ResourceBundle;

public class ProjektInitialize extends Controller implements Initializable {
    public ProjectAddUser e;
    public ComboBox<String> addUser;
    public ObservableList<String> types = FXCollections.observableArrayList("Client", "Contractor", "Admin");
    public DatePicker calender;
    Timeline tl = new Timeline();
    MyCalender mp = new MyCalender();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        timeline.setVvalue(1.0);
        timeline.setContent(tl.getTimeline(MyProject.projectInstance().getProjectName()));

        e = new ProjectAddUser(addUser,types);
        e.initialize(location,resources);
    }


    public void getProjectDate(){
        timeline.setContent(mp.getProjectDate(calender.getEditor().getText()));
    }

    public void onEnterSendMessage(KeyEvent keyEvent) {

        if (keyEvent.getCode().toString().equals("ENTER")) sendMessage();
    }
}

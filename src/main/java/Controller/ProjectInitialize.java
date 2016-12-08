package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import BusinessLogic.*;
import javafx.scene.control.DatePicker;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ProjectInitialize extends Controller implements Initializable {
    public ProjectAddUser e;
    public ComboBox<String> addUser;
    public ObservableList<String> types = FXCollections.observableArrayList("Client", "Contractor");
    public DatePicker calender;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        timeline.setVvalue(1.0);
        timeline.setContent(TL.getTimeline(MyProject.getMyProjectName()));
        e = new ProjectAddUser(addUser,types);
        e.initialize(location,resources);
        if(u.getLevel() == "Admin"){
            addUser.setVisible(true);
        }
        calender.setOnAction(e -> timeline.setContent(mc.getProjectDate(calender.getEditor().getText())));
    }

    public void getProjectDate(){

    }

    public void onEnterSendMessage(KeyEvent keyEvent) {

        if (keyEvent.getCode().toString().equals("ENTER")) sendMessage();
    }
}

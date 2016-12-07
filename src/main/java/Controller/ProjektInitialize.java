package Controller;

import BusinessLogic.*;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.input.KeyEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class ProjektInitialize extends Controller implements Initializable {

    @FXML
    public DatePicker calender;
    Timeline tl = new Timeline();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        timeline.setVvalue(1.0);
        timeline.setContent(tl.getTimeline(MyProject.projectInstance().getProjectName()));
        calender.setConverter(mc.convertDate());
        calender.setOnAction(e-> getProjectDate());
    }

    public void getProjectDate(){
        timeline.setContent(mc.getProjectDate(calender.getEditor().getText()));
    }

    public void onEnterSendMessage(KeyEvent keyEvent) {

        if (keyEvent.getCode().toString().equals("ENTER")) sendMessage();
    }
}

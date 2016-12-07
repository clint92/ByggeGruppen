package Controller;

import BusinessLogic.*;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.input.KeyEvent;
import javafx.util.StringConverter;


import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ProjektInitialize extends Controller implements Initializable {

    @FXML
    public DatePicker calender;
    Timeline tl = new Timeline();
    MyCalender mp = new MyCalender();
    String pattern = "dd/MM/yyyy";


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        timeline.setVvalue(1.0);
        timeline.setContent(tl.getTimeline(MyProject.projectInstance().getProjectName()));
        calender.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }

        });
        calender.setOnAction(e-> getProjectDate());
    }

    public void getProjectDate(){
        timeline.setContent(mp.getProjectDate(calender.getEditor().getText()));
    }

    public void onEnterSendMessage(KeyEvent keyEvent) {

        if (keyEvent.getCode().toString().equals("ENTER")) sendMessage();
    }
}

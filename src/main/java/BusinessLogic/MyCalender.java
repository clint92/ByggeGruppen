package BusinessLogic;

import Database.MyDatabase;
import javafx.scene.layout.VBox;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.scene.text.Text;
import javafx.util.StringConverter;

public class MyCalender {
    Timeline tl = new Timeline();

    public VBox getProjectDate (String date) {
        VBox vb = new VBox();
        ResultSet rs = MyDatabase.dbInstance().query("SELECT  * FROM Timeline where timelineID='"+ MyProject.projectInstance().getProjectName() +"'");

        try {
            while (rs.next()) {
                if (rs.getString("DateAndTime").equals(date)) {
                    vb.getChildren().add(new Text(rs.getString("DateAndTime") +"\n" + "From: " + rs.getString("firstName") + "\n" + "Sent: " +  rs.getString("Description") + "\n\n"));
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (vb.getChildren().isEmpty()) {
            InfoBox.info("Ingen beskeder!");
            return tl.getTimeline(MyProject.projectInstance().getProjectName());
        }
        else  return vb;

    }

    public StringConverter<LocalDate> convertDate(){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringConverter<LocalDate> lc = new StringConverter<LocalDate>() {
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
        };
        return lc;
    }
}




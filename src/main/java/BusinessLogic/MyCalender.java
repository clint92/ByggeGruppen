package BusinessLogic;

import Database.MyDatabase;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.text.Text;

public class MyCalender {
    Timeline tl = new Timeline();





    public void myCalender(DatePicker startDate, DatePicker endDate ) {

    }

    public VBox getProjectDate (String date) {
        VBox vb = new VBox();
        ResultSet rs = MyDatabase.dbInstance().query("SELECT  * FROM Timeline");



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




}



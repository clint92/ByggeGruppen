package BusinessLogic;


import Database.MyDatabase;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Timeline {
    MyDatabase db = MyDatabase.dbInstance();
    private String timelineID;
    private String DateAndTime;
    private String Description;
    private String picture = "null";
    private String firstName;

    public Timeline(){

    }
    public Timeline(String dateAndTime, String description, String firstName) {
        DateAndTime = dateAndTime;
        Description = description;
        this.firstName = firstName;
    }
    public VBox getTimeline(String projectName) {
        ResultSet rs = db.query("SELECT * FROM Timeline where timelineID='" + projectName + "';");
        VBox vb = new VBox();
        try {
            while (rs.next()) {
                vb.getChildren().add(new Text(new Timeline(rs.getString("DateAndTime"), rs.getString("firstName"), rs.getString("Description")).toString()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vb;
    }
    public String toString(){
        return DateAndTime + "\n" + "From: " + firstName + "\n" + Description+"\n\n";
    }
}

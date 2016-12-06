package BusinessLogic;


import Database.MyDatabase;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Timeline {
    public void addToTimeline() {

    }
    public void setTimeline() {

    }
    public VBox getTimeline(String projectName){
        ResultSet rs = MyDatabase.dbInstance().query("SELECT * FROM Timeline where timelineID='"+ projectName +"';");
        VBox vb = new VBox();
        try {
            while (rs.next()) {
                vb.getChildren().add(new Text(rs.getString("DateAndTime") +"\n" + "From: " + rs.getString("firstName") + "\n" + "Sent: " +  rs.getString("Description") + "\n\n"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return vb;
    }
    public void uploadPicture() {

    }
    public void deleteFromTimelint() {

    }

    public void operation() {

    }

}

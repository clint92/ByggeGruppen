package BusinessLogic;

import Controller.Controller;
import Database.MyDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyBLMain {

    Security sc = new Security();

    public int validate(String user, String pass){
        return Login.handleLogin(user, sc.hashpw(pass));
    }

    public void setScene(Stage oStage, String path) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(path));
            oStage.setScene(new Scene(root));
            oStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public VBox getTimeline(String projectName){
        ResultSet rs = MyDatabase.dbInstance().query("SELECT * FROM Timeline where timelineID='"+ projectName +"';");
        VBox vb = new VBox();
        try {
            while (rs.next()) {
                vb.getChildren().add(new Label(rs.getString("DateAndTime") +"[ " + rs.getString("firstName") + ": " +  rs.getString("Description") + " ]"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return vb;
    }

    public ObservableList<String> getProjects(){
        ResultSet rs = MyDatabase.dbInstance().query("SELECT * FROM Projects;");
        ObservableList<String> options = FXCollections.observableArrayList();
        try {
            while (rs.next()) {
                options.add(rs.getString("projectName"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return options;
    }

    public String loadInformation(String st){
        ResultSet rs = MyDatabase.dbInstance().query("SELECT * FROM Projects where projectName='" + st + "';");
        String info = "";
        try {
            while (rs.next()) {
               info = "ProjektID : " + rs.getString("project_ID") +"\n" + "Projekt navn : "+ rs.getString("projectName")
                       + "\n" + "Adresse : " + rs.getString("address") + "\n" + "Postnummer : " + rs.getInt("zip")
                        + "\n" + "Beskrivelse : " + rs.getString("Description") + "\n" + "Start dato : " +  rs.getString("startDate") + "\n"
                       + "Slut dato : " + rs.getString("endDate") + "\n" + "Pris : " + rs.getDouble("Price");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return info;
    }
}

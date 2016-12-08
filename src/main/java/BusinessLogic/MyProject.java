package BusinessLogic;

import Database.MyDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Julius on 07-12-2016.
 */
public class MyProject implements ProjectInterface {
    private static String myProjectName;

    private String projectName;
    private String address;
    private int zip;
    private String description;
    private String startDate;
    private String endDate;
    private double price;
    MyDatabase db = MyDatabase.dbInstance();

    public MyProject(){

    }
    public MyProject(String projectName, String address, int zip, String description, String startDate, String endDate, double price) {
        this.projectName = projectName;
        this.address = address;
        this.zip = zip;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }
    public static void setMyProjectName(String pName){
        myProjectName = pName;
    }
    public static String getMyProjectName(){
        return myProjectName;
    }
    public String projectInformation(String st){
        ResultSet rs = db.query("SELECT * FROM Projects where projectName='" + st + "';");
        String info = "";
        try {
            while (rs.next()) {
                info = "Projekt navn : "+ rs.getString("projectName")
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
    public ObservableList<String> getProjects(){
        ResultSet rs = db.query("SELECT projectName FROM UserProjectRelation where UserName='" + User.getOwnUsername() + "';");
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
    public ObservableList<String> getAllProjects(){
        ResultSet rs = db.query("SELECT projectName FROM Projects;");
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
    public String toString(){
        return "' " + projectName + " ',' " + address + " '," + zip + ", '" + description + " ',' " + startDate + " ',' " + endDate + " ', " + price;
    }
}

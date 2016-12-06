package BusinessLogic;


import Database.MyDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyProject {
    private static String projectName;
    private static MyProject mp;


    private MyProject(String pName) {
        projectName = pName;
    }

    public static synchronized MyProject projectInstance(){
        if (mp == null) {
            mp = new MyProject(projectName);
        }
        return mp;
    }
    public String projectInformation(String st){
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

    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String pName){
        projectName = pName;
    }
    public String toString(){
        return projectName;
    }
}

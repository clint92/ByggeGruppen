package BusinessLogic;


import Database.MyDatabase;
import javafx.scene.control.Alert;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin extends User {
    private int userid = 1;

    public int getUserid(){
        return this.userid;
    }

    public void setUserid(int id){
        this.userid = id;
    }

    public void finishProject() {
    }

    public void createProject() {

    }
    public void changeProject() {

    }
    public void deleteProject() {

    }
    public void sendToArchive() {

    }

    public void addToCalender() {

    }

    public void addProfile(String username, String password, int level, String firstName, String lastName, String address, int zip, String email, int number ) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("System message");
        alert.setHeaderText("Succes!");
        alert.setContentText("Profile added");
        alert.showAndWait();
        MyDatabase.dbInstance().updateDB("INSERT INTO Users(user_ID, userName, password, level)" + "values(user_ID,'"+username+"'," + "'"+sc.hashpw(password)+"'," + level + ");");
        int ID = -1;
        try {
            ResultSet data = MyDatabase.dbInstance().query("SELECT user_ID FROM Users WHERE userName = '" + username + "';");
            while (data.next()) {
                ID = data.getInt("user_ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        MyDatabase.dbInstance().updateDB("INSERT INTO UserInformation(InformationID, UsersUserID, Name, LastName, Address, Zip, Email, MobilNr)" +
                "values(InformationID," + ID + ",'" + firstName +"','" + lastName + "','" + address + "'," + zip + ",'" + email + "'," + number + ");");

    }

    public void getProjectFromArchive() {

    }


}

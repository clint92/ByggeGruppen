package BusinessLogic;


import Database.MyDatabase;
import javafx.scene.control.Alert;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;

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

    public void addProfile(String username, String password, int level, String firstName, String lastName, String address, int zip, String email, int number ) throws EmptyFieldException {

                MyDatabase.dbInstance().updateDB("INSERT INTO Users(user_ID, userName, password, level)" + "values(user_ID,'" + username + "'," + "'" + sc.hashpw(password) + "'," + level + ");");
                MyDatabase.dbInstance().updateDB("INSERT INTO UserInformation(UsersUserID, Name, LastName, Address, Zip, Email, MobilNr)" +
                        "values( LAST_INSERT_ID() " + ",'" + firstName + "','" + lastName + "','" + address + "'," + zip + ",'" + email + "'," + number + ");");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("System message");
                alert.setHeaderText("Succes!");
                alert.setContentText("Profile added");
                alert.showAndWait();
            }



    public void getProjectFromArchive() {

    }


}

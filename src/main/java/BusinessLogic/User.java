package BusinessLogic;

import Database.MyDatabase;
import javafx.scene.control.Alert;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    Security sc = new Security();
    private static String username;

    public void addToTimeline(String message, String userN) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        MyDatabase.dbInstance().updateDB("INSERT INTO Timeline values(null,'"+ dateFormat.format(date) +"', '"+ message +"',  null ,'" + userN + "');");
    }

    public void changeContent() {

    }

    public void deleteContent() {

    }

    public void changeLogin(String userN, String pass1, String pass2) {
        if (pass1.equals(pass2)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("System message");
            alert.setHeaderText("Succes!");
            alert.setContentText("Password changed");
            alert.showAndWait();
            MyDatabase.dbInstance().updateDB("UPDATE Users SET password='" + sc.hashpw(pass1) + "' WHERE userName='" + userN + "';");
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("System message");
            alert.setHeaderText("Failed!");
            alert.setContentText("Password not changed!\nThe 2 passwords are not equal!");
            alert.showAndWait();
        }
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        User.username = username;
    }
}

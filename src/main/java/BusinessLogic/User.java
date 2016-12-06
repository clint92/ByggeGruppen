package BusinessLogic;

import Database.MyDatabase;
import javafx.scene.control.Alert;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    Security sc = new Security();
    private static String username;

    public void addToTimeline(String pjName, String message, String userN) {
        String msg = message;
        int count = 0;
        if (msg.length() > 50) {
            msg = "";
            for (int i = 0; i < message.length(); i++) {
                if (count != 50) {
                    msg += message.substring(i, i + 1);
                } else {
                    msg += "\n";
                    count = 0;
                }
                count++;
            }
        }
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();


        MyDatabase.dbInstance().updateDB("INSERT INTO Timeline values('" + pjName + "','"+ dateFormat.format(date) +"', '"+ msg +"',  null ,'" + userN + "');");
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

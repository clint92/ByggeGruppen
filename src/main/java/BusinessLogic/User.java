package BusinessLogic;

import Database.MyDatabase;
import javafx.scene.control.Alert;

public class User {
    MyDatabase db = MyDatabase.dbInstance();
    private static String username;
    private static String level;
    private Message msg;

    public void addToTimeline(String message) {
        msg = new Message(MyProject.getMyProjectName(), MyCalender.currentDate(), message, username);
        msg.send();
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
            db.updateDB("UPDATE Users SET password='" + Security.hashpw(pass1) + "' WHERE userName='" + userN + "';");
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

    public static String getLevel() {
        return level;
    }

    public static void setLevel(String level) {
        User.level = level;
    }
}

package BusinessLogic;

import Database.MyDatabase;
import javafx.scene.control.Alert;

public class User {
    MyDatabase db = new MyDatabase();
    Security sc = new Security();
    private static String username;

    public void addToTimeline() {

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
            db.editDataLogin(userN, sc.hashpw(pass1));
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

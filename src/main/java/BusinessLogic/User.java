package BusinessLogic;

import Database.MyDatabase;
import javafx.scene.control.Alert;

public class User implements UserInterface{
    MyDatabase db = MyDatabase.dbInstance();
    private static String username;
    private static String level;
    //Users <- database
    private String userN;
    private String passW;
    private int lvl;
    //UserInfomation
    private UserInformation u;

    public User(){

    }
    public User(String userN, String passW){
        this.userN = userN;
        this.passW = Security.hashpw(passW);
    }
    public User(String userN, String passW, int lvl, UserInformation u) {
        this.userN = userN;
        this.passW = Security.hashpw(passW);
        this.lvl = lvl;
        this.u = u;
    }
    public void addToTimeline(Message message) {
        if(message.getDescription().length() <= 0){
            InfoBox.info("Skriv venligst noget!");
        }else {
            db.updateDB("INSERT INTO Timeline values("+ message +");");
            InfoBox.info("Sendt!");
        }
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

    //statisk for at gemme brugernavn igennem nye fxml??
    public static String getOwnUsername() {
        return username;
    }
    public static void setOwnUsername(String username) {
        User.username = username;
    }
    public static String getLevel() {
        return level;
    }
    public static void setLevel(String level) {
        User.level = level;
    }

    public String getUserN(){
        return this.userN;
    }
    public String getPassW(){
        return this.passW;
    }
    public int getLvl(){
        return this.lvl;
    }

    public UserInformation getUserInformation(){
        return this.u;
    }

    public String toString(){
        return "user_ID, '" + userN + "', '" + passW + "'," + lvl;
    }
}

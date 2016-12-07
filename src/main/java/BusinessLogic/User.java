package BusinessLogic;

import Database.MyDatabase;
import javafx.scene.control.Alert;

public class User {
    MyDatabase db = MyDatabase.dbInstance();
    private static String username;
    private static String level;
    //Users <- database
    private String userN;
    private String passW;
    private int lvl;
    //UserInfomation
    private String name;
    private String lName;
    private String address;
    private int zip;
    private String email;
    private int mobil;

    public User(){

    }
    public User(String userN, String passW, int lvl, String name, String lName, String address, int zip, String email, int mobil) {
        this.userN = userN;
        this.passW = passW;
        this.lvl = lvl;
        this.name = name;
        this.lName = lName;
        this.address = address;
        this.zip = zip;
        this.email = email;
        this.mobil = mobil;
    }
    public void addToTimeline(Message message) {
        if(message.getDescription().length() <= 0){
            InfoBox.info("Skriv venligst noget!");
        }else {
            db.updateDB("INSERT INTO Timeline values("+ message +");");
            InfoBox.info("Sendt!");
        }
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

    public String Information(){
        return "LAST_INSERT_ID(), '" + name + "', '"+ lName + "', '"+ address+"', " + zip+ ", '"+ email +"', " + mobil;

    }
    public String toString(){
        return "user_ID, '" + userN + "', '" + Security.hashpw(passW) + "'," + lvl;
    }
}

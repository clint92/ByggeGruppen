package Controller;

import BusinessLogic.*;
import Database.MyDatabase;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Controller {
    ////////////////////////////////////// Overordnet
    MyBLMain BL = new MyBLMain();
    User u = new User();
    //////////////////////////////////////LOGIN
    @FXML
    private TextField user;
    @FXML
    private PasswordField pass;
    //////////////////////////////////////// Admin, Client, Contractor filerne.
    public TextField pass1;
    public TextField pass2;

    public TextField textfield;
    public ScrollPane timeline;

    public AnchorPane pjMain;

    public void userLogin() {
        u.setUsername(user.getText());
        switch (BL.validate(user.getText(), pass.getText())) {
            case -1:
                InfoBox.info("Wrong Password!");
                break;
            case 0:
                BL.setScene((Stage) user.getScene().getWindow(), "../Admin.fxml");
                break;
            case 1:
                BL.setScene((Stage) user.getScene().getWindow(), "../Contractor.fxml");
                break;
            case 2:
                BL.setScene((Stage) user.getScene().getWindow(), "../Client.fxml");
                break;

            }
        }
    public void userChangeLogin(){
        u.changeLogin(u.getUsername(), pass1.getText(), pass2.getText());
    }

    public void sendMessage(){
        u.addToTimeline(textfield.getText(), u.getUsername());
    }

    public void getProjects() {pjMain.getChildren().addAll(BL.getProjects());}

    public void openProject() {
        BL.setScene((Stage) pass1.getScene().getWindow(), "../Project.fxml");
    }

    public void setTimeline() {
        timeline.setContent(BL.getTimeline());
    }
}

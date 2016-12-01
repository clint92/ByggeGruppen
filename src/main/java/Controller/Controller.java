package Controller;

import BusinessLogic.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
                BL.setScene((Stage) user.getScene().getWindow(), "../contractor.fxml");
                break;
            case 2:
                BL.setScene((Stage) user.getScene().getWindow(), "../Client.fxml");
                break;
        }
    }
    public void userChangeLogin(){
        u.changeLogin(u.getUsername(), pass1.getText(), pass2.getText());
    }
}

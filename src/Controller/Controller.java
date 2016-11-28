package Controller;

import BusinessLogic.*;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by Jennes on 25-11-2016.
 */
public class Controller {

    public TextField user;
    public PasswordField pass;
    MyBLMain BL = new MyBLMain();
    public void userLogin() throws LoginException {
        switch (BL.valiedate(user.getText(), pass.getText())) {
            case -1:
                System.out.println("FORKERT KODE");
                break;
            case 0:
                BL.setScene((Stage) user.getScene().getWindow(), "../Admin.fxml");
                break;
            case 1:
                BL.setScene((Stage) user.getScene().getWindow(), "../Contractor.fxml");
                break;
            case 2:
                BL.setScene((Stage) user.getScene().getWindow(), "../User.fxml");
                break;
        }
    }
}

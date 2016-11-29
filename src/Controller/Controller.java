package Controller;

import BusinessLogic.*;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by Jennes on 25-11-2016.
 */
public class Controller {
    //Overordnet
    User u = new User();
    MyBLMain BL = new MyBLMain();
    //LOGIN
    public TextField user;
    public PasswordField pass;
    //Contractor
    public TextField pass1;
    public TextField pass2;
    //

    //////////////////////Controller.fxml LOGIN OK BUTTON/////////////////////////////////////////
    public void userLogin() {
        user.setText(user.getText());
        System.out.println(user.getText());
        switch (BL.valiedate(user.getText(), pass.getText())) {
            case -1:
                System.out.println("FORKERT KODE");
                break;
            case 0:
                BL.setScene((Stage) user.getScene().getWindow(), "../Admin.fxml");
                break;
            case 1:
                BL.setScene((Stage) user.getScene().getWindow(), "../contractor.fxml");
                break;
            case 2:
                BL.setScene((Stage) user.getScene().getWindow(), "../User.fxml");
                break;
        }
    }

    ///////////////////////Contractor.fxml Change Login Ok Button/////////////////////////
}

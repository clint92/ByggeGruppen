package Controller;

import BusinessLogic.*;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Controller {
    ////////////////////////////////////// Overordnet
    MyBLMain BL = new MyBLMain();
    User u = new User();
    Timeline TL = new Timeline();
    MyCalender mc = new MyCalender();
    MyProject mp = MyProject.projectInstance();
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
    public TextArea infoText;
    public ComboBox cb;

    public void userLogin() {
        u.setUsername(user.getText());
        switch (BL.validate(user.getText(), pass.getText())) {
            case -1:
                InfoBox.info("Wrong Password or Username!");
                break;
            case 0:
                u = new Admin();
                u.setLevel("Admin");
                BL.setScene((Stage) user.getScene().getWindow(), "../Admin.fxml");
                break;
            case 1:
                u = new Contractor();
                u.setLevel("Contractor");
                BL.setScene((Stage) user.getScene().getWindow(), "../Contractor.fxml");
                break;
            case 2:
                u = new Client();
                u.setLevel("Client");
                BL.setScene((Stage) user.getScene().getWindow(), "../Client.fxml");
                break;
        }
    }

    public void userChangeLogin() {
        u.changeLogin(u.getUsername(), pass1.getText(), pass2.getText());
    }

    public void sendMessage() {
        u.addToTimeline(mp.getProjectName(), textfield.getText(), u.getUsername());
        InfoBox.info("Sendt!");
        timeline.setContent(TL.getTimeline(mp.getProjectName()));
        textfield.setText("");
    }

    public void openProject() {
        if (cb.getValue() == null) {
            InfoBox.info("Vælg et projekt!");
        } else {
            BL.setScene((Stage) pass1.getScene().getWindow(), "../Project.fxml");
        }
    }
    public void pjBack(){
        BL.setScene((Stage)timeline.getScene().getWindow(), "../"+ User.getLevel() + ".fxml");
    }


    public void onEnterLogin(KeyEvent keyEvent) {
        if (keyEvent.getCode().toString().equals("ENTER")) {
            userLogin();
        }
    }
}

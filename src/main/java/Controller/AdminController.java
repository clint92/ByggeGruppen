package Controller;

import BusinessLogic.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;


public class AdminController extends Controller implements Initializable {

    //CreateUser!
    Admin newU = new Admin();
    private TextField usernameboks;
    private TextField passwordboks;
    private TextField firstname;
    private TextField lastname;
    private TextField address;
    private TextField zip;
    private TextField email;
    private TextField number;
    //CreateProjekt!
    private TextField cpName;
    private TextField cpAddress;
    private TextField cpZip;
    private DatePicker cpStartDate;
    private DatePicker cpEndDate;
    private TextField cpPrice;
    private TextArea cpDescription;

    @FXML
    private ComboBox<String> usertype;
    private ObservableList<String> types = FXCollections.observableArrayList("Client", "Contractor", "Admin");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usertype.setItems(types);
        cb.setItems(op.getAllProjects());
        cb.setOnAction(e -> {
            infoText.setText(op.projectInformation(cb.getSelectionModel().getSelectedItem().toString()));
            MyProject.setMyProjectName(cb.getSelectionModel().getSelectedItem().toString());
        });
    }

    public void createProfile() {
        int level = -1;
        try {
            if (usertype.getValue() != null) {
                String type = usertype.getSelectionModel().getSelectedItem().toString();
                if (type.equals("Client")) {
                    level = 2;
                } else if (type.equals("Contractor")) {
                    level = 1;
                } else if (type.equals("Admin")) {
                    level = 0;
                }
            } else {
                throw new EmptyFieldException();
            }
            if (usernameboks.getText().equals("") || passwordboks.getText().equals("") || level == -1 || firstname.getText().equals("") || lastname.getText().equals("") || address.getText().equals("") || zip.getText().equals("") || email.getText().equals("") || number.getText().equals("")) {
                System.out.println("fejl");
                throw new EmptyFieldException();
            } else {
                newU.addProfile(usernameboks.getText(), passwordboks.getText(), level, firstname.getText(), lastname.getText(), address.getText(), Integer.parseInt(zip.getText()), email.getText(), Integer.parseInt(number.getText()));
                System.out.println(firstname.getText());
            }
        } catch (EmptyFieldException e) {
            e.printStackTrace();
        }
    }

    public void createNewProject() {
        try {
            if (cpName.getText().equals("") || cpAddress.getText().equals("") || cpZip.getText().length() <= 4
                    || cpDescription.getText().equals("") || cpStartDate.getEditor().getText().equals("") || cpEndDate.getEditor().getText().equals("")
                    || cpPrice.getText().equals("")) {
                throw new EmptyFieldException();
            } else {
                newU.createProject(cpName.getText(), cpAddress.getText(), Integer.parseInt(cpZip.getText()), cpDescription.getText(),
                        cpStartDate.getEditor().getText(), cpEndDate.getEditor().getText(), Double.parseDouble(cpPrice.getText()));
                cb.setItems(op.getAllProjects());
            }
        } catch (EmptyFieldException e) {
            e.printStackTrace();
        }
    }


    //NÅR VI TRYKKER ENTER
    public void onEnterAdminProjects(KeyEvent keyEvent) {
        if (keyEvent.getCode().toString().equals("ENTER")) openProject();

    }

    public void onEnterChangeLogin(KeyEvent keyEvent) {
        if (keyEvent.getCode().toString().equals("ENTER")) userChangeLogin();

    }

    public void onEnterAddUser(KeyEvent keyEvent) {
        if (keyEvent.getCode().toString().equals("ENTER")) createProfile();
    }

    public void onEnterCreateProject(KeyEvent keyEvent) {
        if (keyEvent.getCode().toString().equals("ENTER")) createNewProject();

    }
}


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
    @FXML
    private TextField usernameboks;
    @FXML
    private TextField passwordboks;
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField address;
    @FXML
    private TextField zip;
    @FXML
    private TextField email;
    @FXML
    private TextField number;
    //CreateProjekt!
    @FXML
    private TextField cpName;
    @FXML
    private TextField cpAddress;
    @FXML
    private TextField cpZip;
    @FXML
    private DatePicker cpStartDate;
    @FXML
    private DatePicker cpEndDate;
    @FXML
    private TextField cpPrice;
    @FXML
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
        String userN = usernameboks.getText();
        String passW = passwordboks.getText();
        String fName = firstname.getText();
        String lName = lastname.getText();
        String street = address.getText();
        String postcode = zip.getText();
        String mail = email.getText();
        String mobil = number.getText();
        int level = -1;

        try {
            if (usertype.getValue() != null) {
                String type = usertype.getSelectionModel().getSelectedItem();
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
            if (userN.isEmpty() || passW.isEmpty() || level == -1 || fName.isEmpty() || lName.isEmpty() || street.isEmpty() || postcode.isEmpty() || mail.isEmpty() || mobil.isEmpty()) {
                throw new EmptyFieldException();
            } else {
                newU.addProfile(new User(userN, passW, level, fName, lName, street, Integer.parseInt(postcode), mail, Integer.parseInt(mobil)));

            }
        } catch (EmptyFieldException e) {
            e.printStackTrace();
        }
    }

    public void createNewProject() {
        String name = cpName.getText();
        String address = cpAddress.getText();
        String zip = cpZip.getText();
        String description = cpDescription.getText();
        String sDate = cpStartDate.getEditor().getText();
        String eDate = cpEndDate.getEditor().getText();
        String price = cpPrice.getText();
        try {
            if (name.isEmpty() || address.isEmpty() || zip.length() >= 5 || description.isEmpty() || sDate.isEmpty() || eDate.isEmpty() || price.isEmpty()) {
                throw new EmptyFieldException();
            } else {
                newU.createProject(new MyProject(name, address, Integer.parseInt(zip), description, sDate, eDate, Double.parseDouble(price)));
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


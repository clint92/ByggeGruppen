package Controller;

import BusinessLogic.Admin;
import BusinessLogic.MyProject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

/**
 * Created by clint on 06-12-2016.
 */
public class ProjectAddUser extends ProjektInitialize{
    Admin a = new Admin();
    public ComboBox<String> addUser;
    ObservableList<String> types;

    public ProjectAddUser(ComboBox<String> addUser,ObservableList<String> types)
    {
        this.addUser = addUser;
        this.types = types;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        addUser.setItems(types);
        addUser.setOnAction(e -> {
            String userT = addUser.getSelectionModel().getSelectedItem().toString();
            addUser.setItems(a.findUsersForProject(userT));
            addUser.setOnAction(f -> {
                String choosen = addUser.getSelectionModel().getSelectedItem().toString();
                String temp = choosen.substring(0, choosen.indexOf(' '));
                a.addUserToProject(temp);
                System.out.println(temp);
                System.out.println(choosen);
                initialize( location,  resources);
                    });

        });
    }

}

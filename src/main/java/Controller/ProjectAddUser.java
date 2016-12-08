package Controller;

import BusinessLogic.Admin;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by clint on 06-12-2016.
 */
public class ProjectAddUser extends ProjectInitialize{
    Admin a = new Admin();
    public ProjectAddUser(ComboBox<String> addUser,ObservableList<String> types) {
        this.addUser = addUser;
        this.types = types;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addUser.setItems(types);
        addUser.setOnAction(e -> {
            createOkBox(addUser.getSelectionModel().getSelectedItem().toString());
        });
    }

    public void createOkBox(String userT){
        Stage cuStage = new Stage();
        ComboBox cb = new ComboBox();
        cb.setPromptText("Choose user");
        cb.setItems(a.findUsersForProject(userT));
        cuStage.initModality(Modality.APPLICATION_MODAL);
        Button ok = new Button("OK");
        VBox bg = new VBox(cb, new Text("Vælg user!"), ok);
        ok.setOnAction(e -> {
            String selected = cb.getSelectionModel().getSelectedItem().toString();
            String uID = selected.substring(0, selected.indexOf(' '));
            a.addUserToProject(uID);
            cuStage.close();
        });
        bg.setAlignment(Pos.CENTER);
        bg.setMinWidth(300);
        cuStage.setScene(new Scene(bg));
        cuStage.showAndWait();
    }
}
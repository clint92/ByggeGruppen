package BusinessLogic;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Jennes on 25-11-2016.
 */
public class MyBLMain {

    Security sc = new Security();

    public int valiedate(String user, String pass){
        Login l = new Login();
        return l.handleLogin(user, sc.hashpw(pass));
    }

    public void setScene(Stage oStage, String path) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(path));
            oStage.setScene(new Scene(root));
            oStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

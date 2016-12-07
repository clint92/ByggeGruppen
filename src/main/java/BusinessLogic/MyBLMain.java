package BusinessLogic;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyBLMain {
    public int validate(String user, String pass){
        Login login = new Login(user, Security.hashpw(pass));
        return login.handleLogin();
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

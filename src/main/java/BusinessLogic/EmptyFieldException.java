package BusinessLogic;

import javafx.scene.control.Alert;

/**
 * Created by clint on 05-12-2016.
 */
public class EmptyFieldException extends Exception {

   public EmptyFieldException(){
       showException();
   }
   public void showException()
   {
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
       alert.setTitle("System message");
       alert.setHeaderText("Empty fields");
       alert.setContentText("Not all fields has ben filled. /N fill all and try agin");
       alert.showAndWait();
   }

}

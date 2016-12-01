package BusinessLogic;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Julius on 01-12-2016.
 */
public class InfoBox {
    public static void info(String message) {
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        Button ok = new Button("OK");
        VBox info = new VBox(new Text(message), ok);
        ok.setOnAction(e -> dialogStage.close());
        info.setAlignment(Pos.CENTER);
        info.setMinWidth(200);
        dialogStage.setScene(new Scene(info));
        dialogStage.showAndWait();
    }
}
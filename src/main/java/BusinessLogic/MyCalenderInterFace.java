package BusinessLogic;


import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

import java.time.LocalDate;

public interface MyCalenderInterFace {
    VBox getProjectDate(String date);
    //i tilfælde af vi vil have en anderledes date.
    StringConverter<LocalDate> convertDate();
}

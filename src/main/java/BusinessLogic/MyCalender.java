package BusinessLogic;

import Database.MyDatabase;
import javafx.scene.layout.VBox;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javafx.scene.text.Text;
import javafx.util.StringConverter;

public class MyCalender {
    public VBox getProjectDate(String date) {
        VBox vb = new VBox();
        System.out.println(date);
        ResultSet rs = MyDatabase.dbInstance().query("SELECT  * FROM Timeline where timelineID='" + MyProject.getMyProjectName() + "'");

        try {
            while (rs.next()) {
                if (rs.getString("DateAndTime").equals(date)) {
                    vb.getChildren().add(new Text(rs.getString("DateAndTime") + "\n" + "From: " + rs.getString("firstName") + "\n" + rs.getString("Description") + "\n\n"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (vb.getChildren().isEmpty()) {
            vb.getChildren().add(new Text("Ingen beskeder"));
            //return MyProject.getMyProjectName());
            return vb;
        } else return vb;

    }

    public static String currentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    //i tilfælde af vi vil have en anderledes date.
    public StringConverter<LocalDate> convertDate() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringConverter<LocalDate> lc = new StringConverter<LocalDate>() {
            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };
        return lc;
    }
}




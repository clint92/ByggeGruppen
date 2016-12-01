package BusinessLogic;

import Database.MyDatabase;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    public static int handleLogin(String user, String pass) {
        try {
            ResultSet data = MyDatabase.getDbCon().query("SELECT * FROM Users");
            while (data.next()) {
                if (data.getString("userName").equals(user) && data.getString("password").equals(pass)) {
                    int level = data.getInt("level");
                    return level;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}

package BusinessLogic;

import Database.Database;
import Database.MyDatabase;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    Database db = new MyDatabase();
    public int handleLogin(String user, String pass) {
        try {
            ResultSet data = db.getUserData();
            while (data.next()) {
                if (data.getString("userName").equals(user) && data.getString("password").equals(pass)) {
                    int level = data.getInt("level");
                    db.closeConnection();
                    return level;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}

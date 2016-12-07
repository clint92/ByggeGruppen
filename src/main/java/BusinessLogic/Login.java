package BusinessLogic;

import Database.MyDatabase;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login implements LoginInterface {

    private String user;
    private String pass;

    public Login(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }
    public int handleLogin() {
        try {
            ResultSet data = MyDatabase.dbInstance().query("SELECT * FROM Users");
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

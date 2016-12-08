package BusinessLogic;

import Database.MyDatabase;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login implements LoginInterface {
    private User u;
    private MyDatabase db = MyDatabase.dbInstance();

    public Login(User u){
        this.u = u;
    }
    public int handleLogin() {
        String userName = u.getUserN();
        String hashedPassword = u.getPassW();
        try {
            ResultSet data = db.query("SELECT * FROM Users");
            while (data.next()) {
                if (data.getString("userName").equals(userName) && data.getString("password").equals(hashedPassword)) {
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

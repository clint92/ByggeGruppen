package Database;

import java.sql.ResultSet;

public interface Database {
    ResultSet getUserData();
    void closeConnection();
    void editDataLogin(String userN, String pass);
}

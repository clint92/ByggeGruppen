package Database;

import java.sql.ResultSet;

public interface Database {
    ResultSet query(String query);
    void updateDB(String query);
    //void editDataLogin(String userN, String pass);
}

package Database;

import java.sql.ResultSet;

/**
 * Created by Jennes on 25-11-2016.
 */
public interface Database {
    ResultSet getUserData();
    void closeConnection();
}

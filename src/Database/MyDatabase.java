package Database;

import java.sql.*;

/**
 * Created by Jennes on 25-11-2016.
 */
public class MyDatabase implements Database {
    String url = "jdbc:mysql://sql7.freemysqlhosting.net:3306/";
    String dbName = "sql7146768";
    String usern = "sql7146768";
    String passw = "w2gAY97YQQ";
    Connection connection;
    @Override
    public ResultSet getUserData() {
        ResultSet data = null;
        try {
            connection = DriverManager.getConnection(url + dbName, usern, passw);
            Statement statement = connection.createStatement();
            data = statement.executeQuery("SELECT * FROM Users");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return data;
    }


    public void editDataLogin(String pass){

    }
    public void closeConnection() {
        try {
            connection.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}

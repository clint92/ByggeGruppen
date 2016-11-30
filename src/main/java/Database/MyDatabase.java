package Database;

import java.sql.*;

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

    public void editDataLogin(String userN, String pass){
        try {
            connection = DriverManager.getConnection(url + dbName, usern, passw);
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE Users SET password='" + pass + "' WHERE userName='" + userN + "';");
        }
        catch(SQLException e){
            e.printStackTrace();
        }

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

package Database;

import BusinessLogic.InfoBox;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import java.sql.*;

public class MyDatabase implements Database {
    private static Statement statement;
    private static MyDatabase databaseCon;
    private Connection connection;

    //Privat konstruktør sådan at nye objekter ikke kan oprettes udenfor klassen (kernen i singleton pattern).
    private MyDatabase() {
        String url = "jdbc:mysql://sql7.freemysqlhosting.net:3306/";
        String dbName = "sql7146768";
        String usern = "sql7146768";
        String passw = "w2gAY97YQQ";
        try {
            this.connection = DriverManager.getConnection(url + dbName, usern, passw);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized MyDatabase dbInstance() {
        if (databaseCon == null) {
            databaseCon = new MyDatabase();
        }
        return databaseCon;
    }

    public ResultSet query(String query) {
        ResultSet data = null;
        try {
            statement = databaseCon.connection.createStatement();
            data = statement.executeQuery(query);
        }
        catch(SQLException e){
                e.printStackTrace();
            }

        return data;
    }

    public void updateDB(String query){
        try {
            statement = databaseCon.connection.createStatement();
            statement.executeUpdate(query);
        }
        catch(SQLException e){
            if(e instanceof com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException){
                InfoBox.info("Duplicate");
            }
            else {
                e.printStackTrace();
            }
        }
    }



    /*
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
        */
    public void closeConnection() {
        try {
            connection.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}

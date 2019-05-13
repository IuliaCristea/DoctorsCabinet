package DataBaseConnection;

import Log.MyLogger;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    private static DbConnection INSTANCE = null;
    private DbConnection() {
    }

    public Connection getConnection(){

        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinic","root","root");
        }
        catch(Exception e){
            MyLogger.Error("getConnection",e.toString());
        }
        return connection;
    }

    public static DbConnection getInstance() {
        if(INSTANCE ==null ) {
            INSTANCE = new DbConnection();
        }
        return INSTANCE;
    }
}

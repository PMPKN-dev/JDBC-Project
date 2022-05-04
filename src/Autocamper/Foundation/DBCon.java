package Autocamper.Foundation;

import java.sql.*;

public class DBCon {

    static Connection con;

    public static Connection getCon(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CamperDB", "sa", "1234");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }

    public static void closeCon(){
        try {
            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

package Application.Controller;
import java.sql.*;

public class DBcon {
    static Connection con;
    public static void Connection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=sample", "sa", "goodpassword");


            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

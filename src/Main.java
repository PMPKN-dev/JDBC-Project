import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    //adding this for testing

    private static Connection con;
    public static void main(String args[]){

        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=sample","sa","1234");

            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

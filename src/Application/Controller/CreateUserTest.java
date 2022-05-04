package Application.Controller;
import Autocamper.Foundation.DBCon;
import Autocamper.Model.SQLHandler;
import org.junit.*;
import static org.junit.Assert.*;
import java.sql.*;
import java.sql.Connection;

public class CreateUserTest {
    public static SQLHandler instance;

    private static PreparedStatement PS;
    private static ResultSet RS;

    @Test
    public void UserCreation() throws SQLException {
        Connection con = DBCon.getCon();
        SQLHandler.insertCustomer(con,"jimmy","wallstreet","71706040");
        SQLHandler.getPhoneNumber(con,"jimmy");
        String queryTest = "Select PhoneNo from tbl_Customer where PhoneNo = '71706040'";
        PS = con.prepareStatement(queryTest);
        RS = PS.executeQuery();
        RS.next();
        System.out.println(RS.getString(1));
        String expected = "71706040";
        String actual = RS.getString(1);
        assertEquals(expected,actual);



    }
}

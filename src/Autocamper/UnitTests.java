package Autocamper;
import Autocamper.Foundation.DBCon;
import Autocamper.Foundation.SQLHandler;
import org.junit.*;
import static org.junit.Assert.*;
import java.sql.*;
import java.sql.Connection;

public class UnitTests {
    public static SQLHandler instance;

    @org.junit.Before
    public void setUp() throws Exception {
        instance = new SQLHandler();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        instance=null;
    }

    @Test
    public void UserCreation() throws SQLException {
        Connection con = DBCon.getCon();
        SQLHandler.insertCustomer(con,"jimmy","wallstreet",71706040);

        int expected = 71706040;
        int actual = SQLHandler.getPhoneNumber(con,"jimmy");;
        assertEquals(expected,actual);
    }

    @Test
    public void PhoneNumberUpdate() throws SQLException {
        Connection con = DBCon.getCon();
        SQLHandler.updateUserPhoneNumber(con,"jimmy",98765432);

        int expected = 98765432;
        int actual = SQLHandler.getPhoneNumber(con,"jimmy");
        assertEquals(expected,actual);
    }

}
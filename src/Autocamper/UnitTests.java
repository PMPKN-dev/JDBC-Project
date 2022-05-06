package Autocamper;

import Autocamper.Foundation.*;
import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;
import java.sql.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UnitTests {
    public static SQLHandler instance;

    @org.junit.Before
    public void setUp() throws Exception {instance = new SQLHandler();}

    @org.junit.After
    public void tearDown() throws Exception {instance=null;}

    @Test
    public void Test1UserCreation() throws SQLException {
        Connection con = DBCon.getCon();
        SQLHandler.insertCustomer(con,"jimmy","wallstreet",71706040);
        int expected = 71706040;
        int actual = SQLHandler.getPhoneNumber(con,"jimmy");
        DBCon.closeCon();
        assertEquals(expected,actual);
    }

    @Test
    public void Test2PhoneNumberUpdate() throws SQLException {
        Connection con = DBCon.getCon();
        SQLHandler.updateUserPhoneNumber(con,"jimmy",98765432);

        int expected = 98765432;
        int actual = SQLHandler.getPhoneNumber(con,"jimmy");
        DBCon.closeCon();
        assertEquals(expected,actual);
    }
}

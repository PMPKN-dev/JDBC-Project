package Autocamper.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLHandler {
    public static void insertCustomer(Connection con, String Name, String Address, String Phone) throws SQLException {
        PreparedStatement p = con.prepareStatement("insert into tbl_Customer values (?,?,?,?)");
        p.setString(1,Name);
        p.setString(2,Address);
        p.setInt(3, Integer.parseInt(Phone));
        p.setInt(4,0);
        p.executeUpdate();
        p.close();
    }
}

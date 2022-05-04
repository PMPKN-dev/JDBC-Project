package Autocamper.Foundation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLHandler {
    public static void insertCustomer(Connection con, String Name, String Address, int Phone) throws SQLException {
        PreparedStatement p = con.prepareStatement("insert into tbl_Customer values (?,?,?,?)");
        p.setString(1,Name);
        p.setString(2,Address);
        p.setInt(3, Phone);
        p.setInt(4,0);
        p.executeUpdate();
        p.close();
    }

    public static int getPhoneNumber(Connection con, String Name) throws SQLException {
        PreparedStatement p = con.prepareStatement("SELECT PhoneNo from tbl_Customer where Name=?");
        p.setString(1,Name);
        ResultSet rs = p.executeQuery();
        rs.next();
        int temp = rs.getInt(1);
        p.close();
        return temp;
    }

    public static void updateUserPhoneNumber(Connection con, String Name,int PhoneNumber) throws SQLException {
        PreparedStatement p = con.prepareStatement("UPDATE tbl_Customer SET PhoneNo = ? WHERE Name = ?");
        p.setInt(1,PhoneNumber);
        p.setString(2,Name);
        p.executeUpdate();
        p.close();
    }
}
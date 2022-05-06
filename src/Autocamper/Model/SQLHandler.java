package Autocamper.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLHandler {
    public static void insertCustomer(Connection con, String Name, String Address, String Phone) throws SQLException {
        PreparedStatement p = con.prepareStatement("insert into tbl_Customer values (?,?,?,?)");
        p.setString(1, Name);
        p.setString(2, Address);
        p.setInt(3, Integer.parseInt(Phone));
        p.setInt(4, 0);
        p.executeUpdate();
        p.close();
    }

    public static int getPhoneNumber(Connection con, String Name) throws SQLException {
        PreparedStatement p = con.prepareStatement("SELECT PhoneNo from tbl_Customer where Name=?");
        p.setString(1, Name);
        ResultSet rs = p.executeQuery();
        rs.next();
        int temp = rs.getInt(1);
        p.close();
        return temp;
    }

    public static int LoginVerification(Connection con, String Name, int Phone) throws SQLException {
        PreparedStatement p = con.prepareStatement("select CustomerID from tbl_Customer where Name = ? and PhoneNo = ?");
        p.setString(1, Name);
        p.setInt(2, Phone);
        ResultSet rs = p.executeQuery();
        rs.next();
        int temp = rs.getInt(1);
        p.close();
        return temp;
    }

    public static String getCustomerName(Connection con, int CustomerID) throws SQLException {
        PreparedStatement p = con.prepareStatement("Select Name from tbl_Customer where CustomerID = ?");
        p.setInt(1, CustomerID);
        ResultSet rs = p.executeQuery();
        rs.next();
        String temp = "";
        System.out.println(rs.getString("Name"));
        p.close();
        return temp;
    }

    public static int getCamperCost(Connection con, int PriceCatID) throws SQLException {
        PreparedStatement p = con.prepareStatement("select HighSeasonPrice from tbl_PriceCategory where PriceCatID = ?");
        p.setInt(1, PriceCatID);
        ResultSet rs = p.executeQuery();
        rs.next();
        int temp = rs.getInt(1);
        p.close();
        return temp;
    }

    public static int getDiscount(Connection con, int CustomerID) throws SQLException {
        PreparedStatement p = con.prepareStatement("select max(DiscountPercent) from tbl_Discount where NumberofRentalsReq <= (select NumberOfRentals from tbl_Customer where CustomerID = ?)");
        p.setInt(1, CustomerID);
        ResultSet rs = p.executeQuery();
        rs.next();
        int temp = rs.getInt(1);
        p.close();
        return temp;
    }

    public static void createReservation(Connection con, int CustomerID, int CamperID, int FinalPrice) throws SQLException {
        PreparedStatement p = con.prepareStatement("insert into tbl_Reservations values (?,?,?)");
        p.setInt(1, CustomerID);
        p.setInt(2, CamperID);
        p.setInt(3, FinalPrice);
        p.executeUpdate();
        p.close();


    }
}

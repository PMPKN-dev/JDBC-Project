package Application.Database;

import java.sql.*;
import java.util.List;

public class DBConnection {

    Connection con;
    PreparedStatement ps;
    CallableStatement cs;
    ResultSet rs;
    List<CustomerEntries> customerEntries;

    public DBConnection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CamperDB", "sa", "1234");
            System.out.println("Database Ready");
        }catch (Exception e){
            e.getMessage();
        }
    }

    public void closePSConnection(){
        try{
            con.close();
            ps.close();
            cs.close();
            System.out.println("Connection Closed");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getCustomerEntries(){
        int customerID;
        String name;
        String address;
        int PhoneNo;
        int numberOfRentals;
        CustomerEntries tempEntry;

        try{
            ps = con.prepareStatement("SELECT * FROM tbl_Customer");
            rs = ps.executeQuery();
            while(rs.next()){
                customerID = rs.getInt(1);
                name = rs.getString(2);
                address = rs.getString(3);
                PhoneNo = rs.getInt(4);
                numberOfRentals = rs.getInt(5);
                tempEntry = new CustomerEntries(customerID,name,address,PhoneNo,numberOfRentals);
                tempEntry.printCustomerEntries();

            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getCustomerDetails(int CustomerID){
        String customerName = "";
        try{
            cs = con.prepareCall("{CALL getCustomerName (?)}");
            cs.setInt(1,CustomerID);
            rs = cs.executeQuery();
            while(rs.next()){
                customerName = rs.getString(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return customerName;
    }
}

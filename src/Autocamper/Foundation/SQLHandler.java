package Autocamper.Foundation;


import java.sql.*;

public class SQLHandler{

    /**
     * Using a simple INSERT INTO SQL query, inserts a new record into the Customer table.
     * This method uses the following query: "insert into tbl_Customer values (Name,Address,Phone Number,Number of rentals)"
     *
     * <p>Note that the number of rentals is hard-coded to zero as this is the creation of a new user, meaning they have not rented a camper before
     * @param con a connection to the database
     * @param Name the name of the customer to be added
     * @param Address the address of the customer to be added
     * @param Phone the phone number of the customer to be added
     * @throws SQLException SQLException
     */
    public static void insertCustomer(Connection con, String Name, String Address, int Phone) throws SQLException {
        PreparedStatement p = con.prepareStatement("insert into tbl_Customer values (?,?,?,?)");
        p.setString(1,Name);
        p.setString(2,Address);
        p.setInt(3, Phone);
        p.setInt(4,0);
        p.executeUpdate();
        p.close();
    }

    /**
     * Using a simple SELECT query, finds the phone number of a customer by the input name. This method uses the following query: "SELECT PhoneNo from tbl_Customer where Name=Name"
     * <p>After the query, it extracts the first field from the result set and returns it</p>
     * <p>Comment: this is a stub for the idea of getting data based on a single input. It can be expanded to get prices based on camper names or reservations based on CusomerID</p>
     * @param con a connection to the database
     * @param Name the customer's name
     * @return the customer's phone number
     * @throws SQLException SQLException
     */

    public static int getPhoneNumber(Connection con, String Name) throws SQLException {
        PreparedStatement p = con.prepareStatement("SELECT PhoneNo from tbl_Customer where Name=?");
        p.setString(1, Name);
        ResultSet rs = p.executeQuery();
        rs.next();
        int temp = rs.getInt(1);
        p.close();
        return temp;
    }

    /**
     * <p>Explanation goes here</p>
     * <p>2nd paragraph goes here if needed, otherwise delete this line</p>
     * @param con a conneciton to the database
     * @param Name the customer's name
     * @param Phone the customer's phone number
     * @return
     * @throws SQLException SQLException
     */
    //fixme add an explanation into the javadoc above as well as describe the return type
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

    /**
     * Using a simple SELECT query, finds the customer name, prints it to the log and returns it. This method uses the following query:
     * "Select Name from tbl_Customer where CustomerID = CustomerID"
     * @param con a connection to the database
     * @param CustomerID the customer's ID
     * @return the customer's name
     * @throws SQLException SQLException
     */
    public static String getCustomerName(Connection con, int CustomerID) throws SQLException {
        PreparedStatement p = con.prepareStatement("Select Name from tbl_Customer where CustomerID = ?");
        p.setInt(1, CustomerID);
        ResultSet rs = p.executeQuery();
        rs.next();
        String temp = rs.getString("Name");
        System.out.println(temp);
        p.close();
        return temp;
    }

    /**
     * Using a simple SELECT query, finds the category price and returns it. This method uses the following query:
     * "select HighSeasonPrice from tbl_PriceCategory where PriceCatID = PriceCatID"
     * @param con a connection to the database
     * @param PriceCatID the price category ID
     * @return the weekly price based on the ID
     * @throws SQLException SQLException
     */
    public static int getCamperCost(Connection con, int PriceCatID) throws SQLException {
        PreparedStatement p = con.prepareStatement("select HighSeasonPrice from tbl_PriceCategory where PriceCatID = ?");
        p.setInt(1, PriceCatID);
        ResultSet rs = p.executeQuery();
        rs.next();
        int temp = rs.getInt(1);
        p.close();
        return temp;
    }

    /**
     * Using a SELECT query, finds the discount amount and returns it. This method uses the following query:
     * <p>"select max(DiscountPercent) from tbl_Discount where NumberofRentalsReq <= <br>(select NumberOfRentals from tbl_Customer where CustomerID = CustomerID)"
     * @param con a connection to the database
     * @param CustomerID the customer's ID
     * @return the discount based on previous rentals
     * @throws SQLException SQLException
     */
    public static int getDiscount(Connection con, int CustomerID) throws SQLException {
        PreparedStatement p = con.prepareStatement("select max(DiscountPercent) from tbl_Discount where NumberofRentalsReq <= (select NumberOfRentals from tbl_Customer where CustomerID = ?)");
        p.setInt(1, CustomerID);
        ResultSet rs = p.executeQuery();
        rs.next();
        int temp = rs.getInt(1);
        p.close();
        return temp;
    }

    /**
     * Using a simple INSERT query, creates a new reservation and inserts it into the database. This method uses the following query:
     * "insert into tbl_Reservations values (CustomerID,CamperID,FinalPrice)"
     * @param con a connection to the database
     * @param CustomerID the customer's ID
     * @param CamperID the camper's ID
     * @param FinalPrice the final price
     * @throws SQLException SQLException
     */
    public static void createReservation(Connection con, int CustomerID, int CamperID, int FinalPrice) throws SQLException {
        PreparedStatement p = con.prepareStatement("insert into tbl_Reservations values (?,?,?)");
        p.setInt(1, CustomerID);
        p.setInt(2, CamperID);
        p.setInt(3, FinalPrice);
        p.executeUpdate();
        p.close();
    }

    /**
     * Using a simple UPDATE query, changes the Phone Number in the database for the customer with the given name. This method uses the following query:
     * "UPDATE tbl_Customer SET PhoneNo = PhoneNumber WHERE Name = Name"
     * @param con a connection to the database
     * @param Name the customer's Name
     * @param PhoneNumber the customer's Phone number
     * @throws SQLException SQLException
     */

    public static void updateUserPhoneNumber(Connection con, String Name,int PhoneNumber) throws SQLException {
        PreparedStatement p = con.prepareStatement("UPDATE tbl_Customer SET PhoneNo = ? WHERE Name = ?");
        p.setInt(1,PhoneNumber);
        p.setString(2,Name);
        p.executeUpdate();
        p.close();
    }
    public static String selectCustomer(Connection con, String CustomerID) throws SQLException{
        PreparedStatement p = con.prepareStatement("SELECT * FROM tbl_Customer WHERE CustomerID = ?");
        p.setString(1,CustomerID);
        ResultSet rs = p.executeQuery();
        rs.next();
        String temp = rs.getString(1);
        p.close();
        return temp;
    }
}

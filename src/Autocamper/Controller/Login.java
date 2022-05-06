package Autocamper.Controller;

import Autocamper.Foundation.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.SQLException;

public class Login {

    public static int CustomerID;

    @FXML TextField Username;
    @FXML TextField PhoneNumber;

    public static SQLHandler instance;

    //a simple handler for the return button

    @FXML
    public void onBackClick(){
        Main.changeScene(ControllerNames.ReservationLoginPrompt);
    }

    @FXML
    public void onLogin() throws SQLException{
        Connection con = DBCon.getCon();
        try{
            //in this try catch function we call the LoginVerification method in SQLHandler,
            //this method is basically a query that selects the ID associated with the name and phone number
            //if the output is null, then the program will give an exception and be caught by the catch
            int Phone = Integer.parseInt(PhoneNumber.getText());
            int ID = SQLHandler.LoginVerification(con,Username.getText(),Phone);
            CustomerID = ID;
            //we save the ID output from the query for later use in the reservation part(Just used to figure out discount prices)
            System.out.println("Login Successful");

            Main.changeScene(ControllerNames.Reservation);
        }catch(Exception e){
            System.out.println("Invalid Information");
            e.printStackTrace();
        }

        /*
        public int getCustomerID(){
            return CustomerID;
        }

         */
    }
}

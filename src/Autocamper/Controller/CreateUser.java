package Autocamper.Controller;

import Autocamper.Foundation.ControllerNames;
import Autocamper.Foundation.DBCon;
import Autocamper.Foundation.SQLHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.*;

import java.sql.Connection;

public class CreateUser {
    @FXML TextField Name;
    @FXML TextField Address;
    @FXML TextField Phone;
    @FXML Button bypassButton;

    // simple return button handler
    @FXML
    public void onBackClick(){
        Main.changeScene(ControllerNames.ReservationLoginPrompt);
    }

    //handler for creating a user, which uses the DBCon and the SQLHandler class as well as a workaround for the phone number
    @FXML
    public void onCreateUserClick() throws SQLException {
        Connection con = DBCon.getCon();
        int phoneNumber = (int) Double.parseDouble(Phone.getText()); //Using Double.parseDouble cause Java :)
            //Integer.parseInt returns a hex number of sorts which is not useable as a human being
            // while Double.parseDouble returns a nice decimal value
        SQLHandler.insertCustomer(con,Name.getText(),Address.getText(),phoneNumber);
        DBCon.closeCon();
    }

    //this is hidden
    @FXML
    public void onBypassClick(){
        Main.changeScene(ControllerNames.Reservation);
    }

}

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

    @FXML
    public void onBackClick(){
        Main.changeScene(ControllerNames.ReservationLoginPrompt);
    }

    @FXML
    public void onCreateUserClick() throws SQLException {
        Connection con = DBCon.getCon();
        int phoneNumber = (int) Double.parseDouble(Phone.getText());//Using Double.parseDouble cause java is bad :)
                            // Integer.parseInt returns a hex number of sorts which is not use-able as a human being
                            // while Double.parseDouble returns a nice decimal value
        SQLHandler.insertCustomer(con,Name.getText(),Address.getText(),phoneNumber);
        DBCon.closeCon();
    }

    @FXML
    public void onBypassClick(){
        Main.changeScene(ControllerNames.Reservation);
    }

}

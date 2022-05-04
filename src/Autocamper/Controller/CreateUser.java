package Autocamper.Controller;

import Autocamper.Foundation.ControllerNames;
import Autocamper.Foundation.DBCon;
import Autocamper.Model.SQLHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.*;

import java.sql.Connection;

public class CreateUser {
static Connection con;
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
        SQLHandler.insertCustomer(con,Name.getText(),Address.getText(),Phone.getText());
        DBCon.closeCon();
    }
    @FXML
    public void onBypassClick(){
        Main.changeScene(ControllerNames.Reservation);
    }

}

package Application.Controller;

import Application.ControllerNames;
import Application.DBCon;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.*;

import java.sql.DriverManager;

import java.sql.Connection;

public class CreateUser {
static Connection con;
    @FXML TextField Name;
    @FXML TextField Address;
    @FXML TextField Phone;

    @FXML
    public void onBackClick(){
        Main.changeScene(ControllerNames.Registration);
    }
    @FXML
    public void onCreateUserClick() throws SQLException {
        Connection con = DBCon.getCon();
        PreparedStatement p = con.prepareStatement("insert into tbl_Customer values (?,?,?,?)");
        p.setString(1,Name.getText());
        p.setString(2,Address.getText());
        p.setInt(3, Integer.parseInt(Phone.getText()));
        p.setInt(4,0);
        p.executeUpdate();
        p.close();
        DBCon.closeCon();
    }

}

package Application.Controller;

import Application.ControllerNames;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.*;

import java.sql.DriverManager;

public class CreateUser {
static Connection con;

    @FXML
    public void onBackClick(){
        Main.changeScene(ControllerNames.Registration);
    }
    @FXML
    public void onCreateUserClick(){
        @FXML TextField Name;
        @FXML TextField Address;
        @FXML TextField Phone;
        try{
            PreparedStatement p = con.prepareStatement("insert into tbl_Customer values (?,?,?)");
            p.setString(1,Name.getText());
            p.setString(2,Address.getText());
            p.setString(3,Phone.getText());
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=sample","sa","goodpassword");
        }catch(Exception e){
            e.printStackTrace();
        }



    }

}

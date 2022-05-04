package Autocamper.Controller;

import Autocamper.Foundation.ControllerNames;
import Autocamper.Foundation.DBCon;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.*;

public class AdminEdition
{
    @FXML Button buttonManuallyAddUser;
    @FXML Button buttonSelectCustDetails;
    @FXML Button buttonCampersUsed;
    @FXML Button buttonEnter;
    @FXML TextField textfieldEditionOne;
    @FXML TextField textfieldEditionTwo;
    @FXML TextField textfieldEditionThree;
    @FXML TextField textfieldEditionFour;
    @FXML TextArea textareaEditionView;
    @FXML Text manualAddName;
    @FXML Text manualAddAddress;
    @FXML Text manualAddPhone;
    @FXML Text manualAddRentals;

    static Connection con;
    static PreparedStatement ps;
    static CallableStatement cs;
    static ResultSet rs;

    public void onManuallyAddClicked(){
        manualAddName.setOpacity(100);
        manualAddName.setMouseTransparent(false);
        manualAddAddress.setOpacity(100);
        manualAddAddress.setMouseTransparent(false);
        manualAddPhone.setOpacity(100);
        manualAddPhone.setMouseTransparent(false);
        manualAddRentals.setOpacity(100);
        manualAddRentals.setMouseTransparent(false);
        buttonEnter.setOpacity(100);
        buttonEnter.setMouseTransparent(false);

    }

    public void onEnterClicked() throws SQLException {
        Connection con = DBCon.getCon();
        PreparedStatement p = con.prepareStatement("insert into tbl_Customer values (?,?,?,?)");
        p.setString(1,textfieldEditionOne.getText());
        p.setString(2,textfieldEditionTwo.getText());
        p.setInt(3, Integer.parseInt(textfieldEditionThree.getText()));
        p.setInt(4,Integer.parseInt(textfieldEditionFour.getText()));
        System.out.println("Database updated with info");
        p.executeUpdate();
        p.close();
        DBCon.closeCon();
    }

    public void onSelectCustomerDetailsClicked() throws SQLException {

        con = DBCon.getCon();
        ps = con.prepareStatement("SELECT * FROM tbl_Customer");
        System.out.println(ps);
        rs = ps.executeQuery();
        rs.next();
        System.out.println(rs);
        textareaEditionView.setText(rs.getString(1));
        //textareaEditionView.getText().equals(rs.getString(1));
        ps.close();
        con.close();



        textareaEditionView.setText(DBCon.claimCustomerDetails());
        //DBCon.claimCustomerDetails(); //null connection
    }
    public void onCampersUsedClicked(){

    }

    public void onExitReturnStart(){
        Main.changeScene(ControllerNames.View);
    }
}

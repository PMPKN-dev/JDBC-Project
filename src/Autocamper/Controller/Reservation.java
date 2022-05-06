package Autocamper.Controller;


import Autocamper.Foundation.*;
import javafx.fxml.FXML;
import javafx.scene.text.*;
import javafx.scene.control.*;
import java.sql.*;
import java.util.Scanner;

public class Reservation {

    @FXML ListView camperList;
    @FXML MenuBar menuQual;
    @FXML MenuItem basic;
    @FXML MenuItem standard;
    @FXML MenuItem luxury;
    @FXML Menu menuName;
    @FXML Text camperCost;
    @FXML Text camperDeposit;
    @FXML Text camperDiscount;
    @FXML Button createReservation;

    @FXML
    private void ListViewFiller(ListView<String> ListView, String query) throws SQLException {
        //in order to fill the listview with information about campers,
        // a method was created that you can pass queries to,
        //then it runs this query through a prepared statement and the resulting data is grabed by ResultSet seen below
        Connection con = DBCon.getCon();
        PreparedStatement p = con.prepareStatement(query);
        ResultSet rs = p.executeQuery();
        do {
            if (!rs.next()) {
                break;

            } else {
                ListView.getItems().add(String.join(", ", rs.getString(1), rs.getString(2), rs.getString(3)));
                //Here it goes through each row of data and adds it to the listview, and loops based on amount of rows
                //when it reaches the end, the rs.next() boolean becomes false and breaks the do while loop
            }
        } while (true);
        p.close();

    }

    @FXML
    private void onCancelButtonClick(){
        //eh prolly leave the scene
    }

    /**
     *
     * @throws SQLException
     */
    public void basicSelection() throws SQLException {
        //These three methods basically sorts the listview by price category, using the same filllistview method above to pass a query to and sort the list.
        camperList.getSelectionModel().clearSelection();
        //Have to clear the focus first as to not break the program.
        menuName.setText(basic.getText());
        camperList.getItems().clear();
        ListViewFiller(camperList,"select CamperID, CamperName, PriceCatID from tbl_Camper where PriceCatID = 1");
    }

    /**
     *
     * @throws SQLException
     */
    public void standardSelection() throws SQLException {
        camperList.getSelectionModel().clearSelection();
        menuName.setText(standard.getText());
        camperList.getItems().clear();
        ListViewFiller(camperList,"select CamperID, CamperName, PriceCatID from tbl_Camper where PriceCatID = 2");
    }

    /**
     *
     * @throws SQLException
     */
    public void luxurySelection() throws SQLException {
        camperList.getSelectionModel().clearSelection();
        menuName.setText(luxury.getText());
        camperList.getItems().clear();
        ListViewFiller(camperList, "select CamperID, CamperName, PriceCatID from tbl_Camper where PriceCatID = 3");
    }

    /**
     * @param ListView
     */
    public void camperSelectionListener(ListView<String> ListView){
        //In this method we create a listener to see which item on the listview has been clicked on,
        //this helps us find the clicked items camperID, name and price category for future calculations
        ListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            //just setting up the listener and linking it to the listviews item selection
            Connection con = DBCon.getCon();
            String selected = camperList.getSelectionModel().getSelectedItems().toString();
            //Here we create a string that gets reassigned a new string each time we select an item in the listview,
            //further down this string is used to find the selected item camperID and price category ID
            int camperPrice = 0;
            double discount = 0;
            double discountedPrice = 0;
            //we use the campers price category ID to find the correct price range in tbl_PriceCategory,
            //this is done down below in the try catch function, using SQL queries that are prebuilt in the SQLHandler class
            try{
                discount = SQLHandler.getDiscount(con,Login.CustomerID);
                camperPrice = SQLHandler.getCamperCost(con, Integer.parseInt(selected.substring(selected.length()-1)));
            }catch(SQLException e){
                e.printStackTrace();
            }
            discountedPrice = 1-(discount/100);
            //here we adjust the prices on a text in the program as we select items in the list view
            camperCost.setText(String.valueOf(camperPrice*discountedPrice));
            camperDeposit.setText(String.valueOf(camperPrice*0.1*discountedPrice));
            camperDiscount.setText(String.valueOf(discount));
        });
    }

    /**
     * @throws SQLException
     */
    public void createReservation() throws SQLException{
        Connection con = DBCon.getCon();
        //in order to create the correct reservation,
        // we pull the customerID from login class then the first char in the selected string below and lastly
        //the text on the camperCost text which is based on the selected camper
        String selected = camperList.getSelectionModel().getSelectedItems().toString();
        SQLHandler.createReservation(con, Login.CustomerID, selected.charAt(0),(int)Double.parseDouble(camperCost.getText()));
    }

    //Runs the methods required to initialize the class
    public void initialize() throws SQLException{
        //In order to fill the listview, we call the method in initialize and pass a query to it that selects all the data needed from tbl_Camper
        ListViewFiller(camperList,"select CamperID, CamperName, PriceCatID from tbl_Camper");
        //Adding the listener to the listview
        camperSelectionListener(camperList);

    }
}

package Application.Controller;

import Application.ControllerNames;
import Application.DBCon;
import javafx.fxml.FXML;

import java.sql.Connection;

public class CreateUser {

    @FXML
    public void onBackClick(){
        Main.changeScene(ControllerNames.Registration);
    }


    public void onCreteUserClick(){
        Connection con = DBCon.getCon();
        //magic
        DBCon.closeCon();
    }

}

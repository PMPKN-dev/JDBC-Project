package Application.Controller;

import Application.ControllerNames;
import javafx.fxml.FXML;

public class Reservation {

    @FXML
    public void onCreateUserClick(){
        Main.changeScene(ControllerNames.CreateUser);
    }
    @FXML
    public void onExistingUserClick(){
        Main.changeScene(ControllerNames.Login);
    }
    @FXML
    public void onBackClick(){
        Main.changeScene(ControllerNames.View);
    }
}

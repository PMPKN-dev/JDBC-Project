package Autocamper.Controller;

import Autocamper.Model.ControllerNames;
import javafx.fxml.FXML;

public class Login {
    @FXML
    public void onBackClick(){
        Main.changeScene(ControllerNames.ReservationLoginPrompt);
    }
}

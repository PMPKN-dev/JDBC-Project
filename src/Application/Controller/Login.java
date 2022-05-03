package Application.Controller;

import Application.ControllerNames;
import javafx.fxml.FXML;

public class Login {
    @FXML
    public void onBackClick(){
        Main.changeScene(ControllerNames.ReservationLoginPrompt);
    }
}

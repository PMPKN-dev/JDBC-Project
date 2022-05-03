package Application.Controller;

import Application.Controller.Main;
import Application.ControllerNames;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class View {

    @FXML
    public void onMakeReservationClick(){
        Main.changeScene(ControllerNames.ReservationLoginPrompt);
    }


}

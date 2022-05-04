package Autocamper.Controller;

import Autocamper.Model.ControllerNames;
import javafx.fxml.FXML;

public class View {

    @FXML
    public void onMakeReservationClick(){
        Main.changeScene(ControllerNames.ReservationLoginPrompt);
    }


}

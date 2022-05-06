package Autocamper.Controller;

import Autocamper.Foundation.ControllerNames;
import javafx.fxml.FXML;

public class View {

    //simple scene change handler
    @FXML
    public void onMakeReservationClick(){
        Main.changeScene(ControllerNames.ReservationLoginPrompt);
    }


}

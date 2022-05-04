package Autocamper.Controller;

import Autocamper.Foundation.ControllerNames;
import javafx.fxml.FXML;

public class View {

    @FXML
    public void onMakeReservationClick(){
        Main.changeScene(ControllerNames.ReservationLoginPrompt);
    }

    @FXML
    public void onLoginAdminClick(){
        Main.changeScene(ControllerNames.AdminLogin);
    }


}

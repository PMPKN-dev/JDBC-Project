package Autocamper.Controller;

import Autocamper.Foundation.ControllerNames;
import javafx.fxml.FXML;

//the name is not final but a placeholder until we figure out a name that makes sense
public class ReservationLoginPrompt {

    // simple scene change handlers
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

package Application.Controller;

import Application.ControllerNames;
import javafx.fxml.FXML;

public class CreateUser {

    @FXML
    public void onBackClick(){
        Main.changeScene(ControllerNames.Registration);
    }

}

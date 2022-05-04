package Autocamper.Controller;

import Autocamper.Foundation.ControllerNames;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.Objects;

public class AdminLogin {

    @FXML TextField passTextfield;
    @FXML TextField userTextfield;
    @FXML TextField adminResultView;
    @FXML Button buttonLogin;
    @FXML Button proceedButton;



    @FXML
    public void onReturnClick(){
        Main.changeScene(ControllerNames.View);
    }


    public void loginAsAdmin() {

        buttonLogin.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String insertedUser = userTextfield.getText();
                String insertedPass = passTextfield.getText();
                if(Objects.equals(insertedUser, "sa") && Objects.equals(insertedPass, "12")){
                    adminResultView.setText("Login Successful. Press button to proceed");
                    proceedButton.setOpacity(100); //Makes button visible
                    proceedButton.setMouseTransparent(false); //Makes mouse able to interact with button
                    proceedButton.setText("Proceed");
                    proceedButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            onProceedClicked();
                        }
                    });
                }
                else{
                    adminResultView.setText("Wrong User or Pass, please try again");
                    userTextfield.setText("");
                    passTextfield.setText("");
                }

            }
        });

    }

    @FXML
    public void onProceedClicked(){
        Main.changeScene(ControllerNames.AdminEdition);
    }
}

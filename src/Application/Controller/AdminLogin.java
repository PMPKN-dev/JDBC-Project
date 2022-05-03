package Application.Controller;

import Application.ControllerNames;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;

import java.util.Locale;
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

    public void checkLogin(){
        DBcon.Connection();
        //loginAsAdmin();

    }

    public void loginAsAdmin() {

        buttonLogin.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String insertedUser = userTextfield.getText();
                String insertedPass = passTextfield.getText();
                if(Objects.equals(insertedUser, "management") && Objects.equals(insertedPass, "fabulous")){
                    adminResultView.setText("Login Successful. Press button to proceed");
                    proceedButton.setOpacity(100);
                    proceedButton.setMouseTransparent(false);
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

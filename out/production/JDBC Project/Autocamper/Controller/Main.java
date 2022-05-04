package Autocamper.Controller;

import Autocamper.Foundation.SceneCtrlNamePair;
import Autocamper.Foundation.ControllerNames;
import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;

import java.util.ArrayList;

public class Main extends Application {

    private static ArrayList<SceneCtrlNamePair> scenes = new ArrayList<>();
    private static Stage primaryStageHolder = null;
    private static final int width = 600;
    private static final int height = 400;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStageHolder = primaryStage;
        Application.setUserAgentStylesheet(getClass().getResource("/Autocamper/View/Style.css").toExternalForm());

        //region Creating FXMLLoaders for the controllers
        FXMLLoader CreateUserPaneLoader = new FXMLLoader(getClass().getResource("/Autocamper/View/CreateUser.fxml"));
        Parent CreateUserPane = CreateUserPaneLoader.load();
        Scene CreateUserScene = new Scene(CreateUserPane,width,height);

        FXMLLoader LoginPaneLoader = new FXMLLoader(getClass().getResource("/Autocamper/View/Login.fxml"));
        Parent LoginPane = LoginPaneLoader.load();
        Scene LoginScene = new Scene(LoginPane,width,height);

        FXMLLoader RegistrationPaneLoader = new FXMLLoader(getClass().getResource("/Autocamper/View/ReservationLoginPrompt.fxml"));
        Parent RegistrationPane = RegistrationPaneLoader.load();
        Scene RegistrationScene = new Scene(RegistrationPane,width,height);

        FXMLLoader ViewPaneLoader = new FXMLLoader(getClass().getResource("/Autocamper/View/View.fxml"));
        Parent ViewPane = ViewPaneLoader.load();
        Scene viewScene = new Scene(ViewPane,width,height);

        FXMLLoader ReservationPaneLoader = new FXMLLoader(getClass().getResource("/Autocamper/View/Reservation.fxml"));
        Parent ReservationPane = ReservationPaneLoader.load();
        Scene ReservationScene = new Scene(ReservationPane,width,height);

        FXMLLoader AdminLoginPaneLoader = new FXMLLoader(getClass().getResource("/Autocamper/View/AdminLogin.fxml"));
        Parent AdminLoginPane = AdminLoginPaneLoader.load();
        Scene AdminLoginScene = new Scene(AdminLoginPane,width,height);

        FXMLLoader AdminEditionPaneLoader = new FXMLLoader(getClass().getResource("/Autocamper/View/AdminEdition.fxml"));
        Parent AdminEditionPane = AdminEditionPaneLoader.load();
        Scene AdminEditionScene = new Scene(AdminEditionPane,width,height);
        //endregion

        //region adding scenes to scenes Arraylist
        scenes.add(new SceneCtrlNamePair(CreateUserScene, ControllerNames.CreateUser));
        scenes.add(new SceneCtrlNamePair(LoginScene, ControllerNames.Login));
        scenes.add(new SceneCtrlNamePair(RegistrationScene, ControllerNames.ReservationLoginPrompt));
        scenes.add(new SceneCtrlNamePair(viewScene, ControllerNames.View));
        scenes.add(new SceneCtrlNamePair(ReservationScene,ControllerNames.Reservation));
        scenes.add(new SceneCtrlNamePair(AdminLoginScene,ControllerNames.AdminLogin));
        scenes.add(new SceneCtrlNamePair(AdminEditionScene,ControllerNames.AdminEdition));
        //endregion

        primaryStage.setTitle("View");
        primaryStage.setScene(viewScene);
        primaryStage.show();
    }

    //Changes the scene based on the name input
    public static void changeScene(ControllerNames sceneName){
        primaryStageHolder.setTitle(sceneName.toString());

        for(SceneCtrlNamePair sceneCtrlNamePair : scenes){
            if(sceneCtrlNamePair.getName().equals(sceneName)){
                primaryStageHolder.setScene(sceneCtrlNamePair.getScene());
            }
        }
    }
}

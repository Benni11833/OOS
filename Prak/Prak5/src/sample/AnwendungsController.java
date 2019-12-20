package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sun.applet.Main;

public class AnwendungsController {

    public void initialize(MainApplication mainApp){
        System.out.println("AnwendungsController initialize");
        mainApp_ref = mainApp;
    }

    MainApplication mainApp_ref;

    @FXML
    public void closeWindow(ActionEvent e){
        System.out.println("Anwedungsfenster schließt.");
        Platform.exit();
    }
}

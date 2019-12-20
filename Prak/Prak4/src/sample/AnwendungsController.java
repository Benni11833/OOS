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

public class AnwendungsController {

    @FXML
    public TextField MessageLabel;

    @FXML
    public void closeWindow(ActionEvent e){
        System.out.println("Anwedungsfenster schließt.");
        Platform.exit();
    }
}

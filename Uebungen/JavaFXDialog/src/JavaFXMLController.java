import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class JavaFXMLController {

    @FXML
    public Button runbutton;
    public TextField nameField;
    //public Button swapSceneButton;

    @FXML
    public void buttonClicked(ActionEvent event){
        System.out.println(nameField.getText());
    }

    @FXML
    public void swapScene(ActionEvent event) throws IOException {
        System.out.println("Swap Scene");
        Parent root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("layout.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Scene 2");
        stage.setScene(scene);
        stage.show();
    }

}
